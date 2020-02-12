<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html lang="zh_CN">
<head>
  <meta charset="utf-8">
  <title>项目列表</title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
  <link rel="stylesheet" href="/layuiadmin/layui/css/layui.css" media="all">
  <link rel="stylesheet" href="/layuiadmin/style/admin.css" media="all">
  <link rel="stylesheet" href="/layuiadmin/style/custom.css" media="all">
  <style type="text/css">
  	.layui-form-label {
	    margin-top: 5px;
	}
	.collect{
		cursor: pointer;
	}
	.collect svg {
		width: 20px;
		height: 20px;
    }
    .env-content-edit {
	    overflow-x: auto;
	    background: #e2e2f6;
	    padding: 10px;
	    font-family: Consolas;
	    font-size: 15px;
	    font-weight: 600;
	}
    .env-content-edit>div{
        white-space:nowrap;
        text-overflow:ellipsis;
    }
    .comment{
    	color:#999
    }
    .key{
    	color:red
    }
    .value{
    	color:green
    }
    .bool{
    	color:#ff05f8
    }
    .num{
    	color:#01aaed
    }
  </style>
</head>
<body>

  <div class="layui-fluid">
    <div class="layui-row layui-col-space15">
      <div class="layui-col-md4">
        <div class="layui-card">
          <div class="layui-card-body">
            <input id="projectId" type="hidden" value="${projectId}"/>
            <div class=" table-operate-btn" style="margin-bottom: 10px;">
              <button class="layui-btn layui-btn-xs" data-type="add">
              	<i class="layui-icon layui-icon-add-1" style="color: #FFF;"></i>添加环境
              </button>
              <button class="layui-btn layui-btn-xs layui-btn-normal" data-type="save">
                <i class="layui-icon layui-icon-ok-circle" style="color: #FFF;"></i>保存
              </button>
              
            </div>
            <table class="layui-hide" id="table-page" lay-filter="table-page"></table>
            <script type="text/html" id="table-operate-bar">
              <a class="layui-btn layui-btn-xs" lay-event="update"><i class="layui-icon layui-icon-edit"></i></a>
              <a class="layui-btn layui-btn-xs layui-btn-danger" lay-event="del"><i class="layui-icon layui-icon-delete"></i></a>
            </script>
            
          </div>
        </div>
      </div>
      <div class="layui-col-md8">
        <div class="layui-card">
          <div class="layui-card-header">配置信息<t style="color: red;">(仅支持properties格式)</t></div>
          <div class="layui-card-body">
            <input type="hidden" id="env-content-id" />
            <div id="env-content-edit" class="env-content-edit" contenteditable="true" >
            </div>
          </div>
        </div>
        <div class="layui-card">
          <div class="layui-card-header">公共配置</div>
          
          <div class="layui-card-body">
          <button class="layui-btn layui-btn-xs" data-type="add">
           	  <i class="layui-icon layui-icon-add-1" style="color: #FFF;"></i>添加公共配置
            </button>
            <input type="hidden" id="env-content-id" />
            <div id="env-content-edit" class="env-content-edit" contenteditable="true" >
            </div>
          </div>
        </div>
        
      </div>
    </div>
  </div>
  
  <script src="/layuiadmin/layui/layui.js"></script>  
  <script>
  layui.config({
    base: '/layuiadmin/' //静态资源所在路径
  }).extend({
    index: 'lib/index' //主入口模块
  }).use(['index', 'table'], function(){
    var admin = layui.admin
    ,table = layui.table
    ,$ = layui.$
    ,layer = top.layer?top.layer:layui.layer;
  
    table.render({
      elem: '#table-page'
      ,url: '/project/env/list?projectId='+$('#projectId').val()
      ,cols: [[
        {field:'envName', align:'center', title: '环境',templet:function(d){
        	return '<a  class="layui-btn layui-btn-xs layui-btn-radius" lay-event="envEdit">'+d.envName+'</a>';
        }}
        ,{title: '操作', align:'center', fixed: 'right', toolbar: '#table-operate-bar'}
      ]]
      ,page: true
    });
    
    var active = {
  	  add: function(){
  		layeropen();
      },
      save: function(){
    	var content = '';
      	$('.content-node').each(function(i,e){
      		content += $(this).text() +'\r\n';
      	})
      	if (content){
      		var envId = $('#env-content-id').val();
      		$.ajax({
      			url:'/project/env/save',
      			type:'post',
      			data:{content:content,id:envId},
      			success:function(data){
      				layer.msg('保存成功');
      				active.reload();
      			}
      		})
      		
      	}
      	
    	  
      },
      reload: function(){
    	  table.reload('table-page', {
            page: {
              curr: 1 //重新从第 1 页开始
            }
            ,where: {
            	envName: $('#envName').val(),
            }
          });
      }
    };
    
  //监听工具条
    table.on('tool(table-page)', function(obj){
      var data = obj.data;
      if(obj.event === 'envEdit'){
    	  $('#env-content-id').val(data.id);
    	  $('#env-content-edit').html('').html(genEnvDiv(data.content))
    	  
      }
    });
  
    $('#env-content-edit')
    .on('keyup',function(){
    	if($(this).find('div').text()==''){
    		$(this).html('');
    	}
    })
    .on('blur',function(){
    	var content = '';
    	$(this).find('div').each(function(i,e){
    		content += $(this).text() +'\r\n';
    	})
    	$(this).html('').html(genEnvDiv(content));
    	
    })
  
    function genEnvDiv(data){
    	if (!data){ return data};
    	var divs = data.split('\r\n');
    	var obj = {};
    	$.each(divs,function(i,e){
    		if (!e){
    			return;
    		}
    		
    		if (e.trim().startsWith('#')){
    			obj['#'+i] = e.trim();
    		}else{
    			var key = e.substr(0,e.indexOf('='));
    			var value = e.substr(e.indexOf('=')+1,e.length);
    			obj[key] = value;
    		}
    	})
    	var result = '';
    	$.each(obj, function(key){
			var clazz = '', value = obj[key];
			if (key.startsWith('#')){
    			result += '<div class="content-node comment">'+value+'</div>';
    		}else{
    			if (value=="true" || value=="false"){
    				clazz='bool';
    			}else if (/^\d+(\.\d+)?$/.test(value)){
    				clazz='num';
    			}else{
    				clazz='value';
    			}
    			var adder = '<div class="content-node"><code class="key">'+key+'</code>=<code class="'+clazz+'">'+value+'</code></div>';
    			result += adder;
    		}
    	})
    	
    	return result;
    }
  
    
    $('.table-operate-btn .layui-btn').on('click', function(){
      var type = $(this).data('type');
      active[type] ? active[type].call(this) : '';
    });


    function layeropen(data, id){
        layer.open({
            title:'项目参数确认',
            area: '50%',
            content:'<form class="layui-form" id="env-form">\
                <input type="hidden" value="'+$('#projectId').val()+'" name="projectId">\
                <input type="hidden" value="'+(data&&data.id?data.id:'')+'" name="id">\
                <div class="layui-col-space10"><label class="layui-form-label">环境名：</label><div class="layui-input-block"><input type="text" value="'+(data&&data.envName?data.envName:'')+'" name="envName" required  lay-verify="required" placeholder="环境名" autocomplete="off" class="layui-input"></div></div>\
                </form>',
            btn:['确定', '取消'],
            yes: function(index, layero){
                var data = layero.find('#env-form').serialize();
                layui.$.ajax({
                    url:'/project/env/save',
                    type:'post',
                    data:data,
                    success:function(data){
                        layer.msg(data.resultMessage);
                        active.reload();
                    }
                })
            },
            btn2:function(index, layero){
            	layer.close(index);
            }
        });
    }

  });

  
  </script>
</body>
</html>