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
</head>
<body>

  <div class="layui-fluid">
    <div class="layui-row layui-col-space15">
      <div class="layui-col-md12">
        <div class="layui-card">
          <div class="layui-card-body">
          
            <div class=" table-operate-btn" style="margin-bottom: 10px;">
              <div class="layui-inline">
                <input class="layui-input" id="projectName" name="projectName" placeholder="项目名" id="test-table-demoReload" autocomplete="off">
              </div>
              <div class="layui-inline">
                <input class="layui-input" id="depict" name="depict" placeholder="描述" id="test-table-demoReload" autocomplete="off">
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
        {field:'id', width:70, title: 'ID'}
        ,{field:'realName',  title: '姓名'}
        ,{field:'apiName',  title: 'API名'}
        ,{field:'apiUrl',  title: 'API url'}
        ,{field:'params',  title: '参数'}
        ,{field:'createTime', title: '操作时间'}
      ]]
      ,page: true
    });

    var $ = layui.$, active = {
      reload: function(){
    	  table.reload('table-page', {
            page: {
              curr: 1 //重新从第 1 页开始
            }
            ,where: {
            	projectName: $('#projectName').val(),
            	depict: $('#depict').val()
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