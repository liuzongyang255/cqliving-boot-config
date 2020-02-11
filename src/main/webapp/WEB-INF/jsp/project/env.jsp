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
              <button class="layui-btn" data-type="add">添加</button>
              <div class="layui-inline">
                <input class="layui-input" id="envName" name="envName" placeholder="环境名"  autocomplete="off">
              </div>
              <button class="layui-btn" data-type="reload">搜索</button>
            </div>
            <table class="layui-hide" id="table-page" lay-filter="table-page"></table>
            <script type="text/html" id="table-operate-bar">
              <a class="layui-btn layui-btn-xs" lay-event="update">修改</a>
            </script>
          </div>
        </div>
      </div>
      <div class="layui-col-md8">
        <div class="layui-card">
          <div class="layui-card-header">配置信息</div>
          <div class="layui-card-body">
            <table class="layui-hide" id="table-page1" lay-filter="table-page1"></table>
            <script type="text/html" id="table-operate-bar">
              <a class="layui-btn layui-btn-xs" lay-event="update">修改</a>
            </script>
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
        {field:'envName', title: '环境',templet:function(d){
        	return '<a  class="layui-btn layui-btn-xs layui-btn-radius" lay-event="envEdit">'+d.envName+'</a>';
        }}
      ]]
      ,page: true
    });
    
    var active = {
  	  add: function(){
  		layeropen();
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
    	  console.log(data);
      }
    });
    
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