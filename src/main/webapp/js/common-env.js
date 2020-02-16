layui.config({
    base: '/layuiadmin/' //静态资源所在路径
  }).extend({
    index: 'lib/index' //主入口模块
  }).use(['index', 'table'], function(){
    var table = layui.table
    ,$ = layui.$
    ,layer = top.layer?top.layer:layui.layer;
  
    table.render({
      elem: '#table-page'
      ,url: '/common-env/page'
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
            var envId = $('#env-content-id').val();
            if (!envId){
              layer.msg('请选择环境')
              return;
            }
            var content = '';
            $('.content-node').each(function(i,e){
            	content += $(this).text() +'\r\n';
            })
            if (content){
            	$.ajax({
            		url:'/common-env/save',
            		type:'post',
            		data:{content:content,id:envId},
            		success:function(data){
            		    layer.msg(data.resultMessage);
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
    	  $('#env-content-edit').html('<div class="content-node">&nbsp;</div>');
    	  if(data.content){
    		  $('#env-content-edit').html(genEnvDiv(data.content)) 
    	  }
      }else if (obj.event === 'update'){
    	  layeropen(data);
      }else if (obj.event === 'del'){
    	  layer.confirm('真的删除么？', function(index){
             $.ajax({
           	  url:'/common-env/del?id='+data.id,
           	  type:'post',
           	  success:function(data){
     			  layer.msg('删除成功');
     			  obj.del();
     	          layer.close(index);
           	  }
             })
           });
      }
    });
  
    $('#env-content-edit').on('blur',function(){
        var data = {};
        if ($(this).find('.content-node .content-node').length > 0){
            data = $(this).find('.content-node .content-node');
        }else{
            data = $(this).find('div');
        }
    	var content = '';
    	data.each(function(i,e){
    		content += $(this).text() +'\r\n';
    	})
    	$(this).html('<div class="content-node">&nbsp;</div>');
    	if (content){
    		$(this).html(genEnvDiv(content))
    	}
    	
    })
  
    function genEnvDiv(data){
    	var divs = data.split('\r\n');
    	var obj = {};
    	$.each(divs,function(i,e){
    		if (!e){
    			return;
    		}
    		if (e.trim().startsWith('#')){
    			obj['#'+i] = e.trim();
    		}else{
    			var key = e.substr(0,e.indexOf('=')).trim();
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
            area: '500px',
            content:'<form class="layui-form" id="env-form">'
                +'<input type="hidden" value="'+(data&&data.id?data.id:'')+'" name="id">'
                +'<div class="layui-col-space10"><label class="layui-form-label">环境名：</label><div class="layui-input-block"><input type="text" value="'+(data&&data.envName?data.envName:'')+'" name="envName" required  lay-verify="required" placeholder="环境名" autocomplete="off" class="layui-input"></div></div>'
                +'</form>',
            btn:['确定', '取消'],
            yes: function(index, layero){
                var data = layero.find('#env-form').serialize();
                layui.$.ajax({
                    url:'/common-env/save',
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