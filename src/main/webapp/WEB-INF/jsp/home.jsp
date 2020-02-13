<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>首页</title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
  <link rel="stylesheet" href="/layuiadmin/layui/css/layui.css" media="all">
  <link rel="stylesheet" href="/layuiadmin/style/admin.css" media="all">
  <link rel="stylesheet" href="/layuiadmin/style/custom.css" media="all">
  <style type="text/css">
  	.proj{
    	color: #63baf6
    }
  </style>
</head>
<body>

  <div class="layui-fluid">
    <div class="layui-row layui-col-space15">
   	  <div class="layui-col-md4">
      	<div class="layui-card">
      	<div class="layui-card-header">我的收藏</div>
          <div class="layui-card-body">
            <div class=" table-operate-btn" style="margin-bottom: 10px;">
              <div class="layui-inline">
                <input class="layui-input" id="name" name="name" placeholder="项目名"  autocomplete="off">
              </div>
              <button class="layui-btn" data-type="reloadColl">搜索</button>
            </div>
            <table class="layui-hide" id="coll-table" lay-filter="coll-table"></table>
          </div>
        </div>
      </div>
    
      <div class="layui-col-md8">
        <div class="layui-card">
          <div class="layui-card-header">操作记录</div>
          <div class="layui-card-body">
            <div class=" table-operate-btn" style="margin-bottom: 10px;">
              <div class="layui-inline">
                <input class="layui-input" id="realName" name="realName" placeholder="姓名"  autocomplete="off">
              </div>
              <button class="layui-btn" data-type="reload">搜索</button>
            </div>
            <table class="layui-hide" id="table-page" lay-filter="table-page"></table>
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
    ,layer = top.layer?top.layer:layui.layer;
  
    table.render({
      elem: '#table-page'
      ,url: '/user-act/page?orderField=create_time&sort=desc'
      ,cols: [[
        {field:'index', width:70, title: '序号'}
        ,{field:'realName',  title: '姓名'}
        ,{field:'apiName',  title: 'API名'}
        ,{field:'apiUrl',  title: 'API url'}
        ,{field:'params',  title: '参数'}
        ,{field:'createTime', title: '操作时间'}
      ]]
      ,page: true
    });
    
    table.render({
        elem: '#coll-table'
        ,url: '/project/page/collect'
        ,cols: [[
          {field:'name',  title: '项目名', templet:function(d){
          	  return '<a lay-href="/project/env?id='+d.id+'" class="proj">'+d.name+'</a>';
          }}
          ,{field:'remark',  title: '备注'}
        ]]
        ,page: true
      });

    var $ = layui.$, active = {
    		
	  reloadColl: function(){
		  table.reload('coll-table', {
            page: {
              curr: 1 //重新从第 1 页开始
            }
            ,where: {
            	name: $('#name').val(),
            }
          });
	  },
      reload: function(){
    	  table.reload('table-page', {
            page: {
              curr: 1 //重新从第 1 页开始
            }
            ,where: {
            	realName: $('#realName').val(),
            }
          });
      }
    };
    
    $('.table-operate-btn .layui-btn').on('click', function(){
      var type = $(this).data('type');
      active[type] ? active[type].call(this) : '';
    });

  });

  
  </script>
</body>
</html>