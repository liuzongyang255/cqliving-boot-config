<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>用户管理</title>
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
          <div class="layui-card-header">用户列表</div>
          <div class="layui-card-body">
            <div class=" table-operate-btn" style="margin-bottom: 10px;">
              <div class="layui-inline">
                <input class="layui-input xs-input" id="realName" name="realName" placeholder="姓名"  autocomplete="off">
              </div>
              <div class="layui-inline">
                <input class="layui-input xs-input" id="userName" name="userName" placeholder="用户名"  autocomplete="off">
              </div>
              <div class="layui-inline">
                <input class="layui-input xs-input" id="email" name="email" placeholder="邮箱"  autocomplete="off">
              </div>
              <button class="layui-btn layui-btn-xs" data-type="reload">搜索</button>
              <button class="layui-btn layui-btn-xs layui-btn-normal" data-type="add">添加</button>
            </div>
            <table class="layui-hide" id="table-page" lay-filter="table-page"></table>
            <script type="text/html" id="table-operate-bar">
              <a class="layui-btn layui-btn-xs" lay-event="reset" title="重置密码"><i class="layui-icon layui-icon-refresh"></i></a>
            </script>
          </div>
        </div>
      </div>
    </div>
  </div>
  
  <script src="/layuiadmin/layui/layui.js"></script>  
  <script src="/js/common.js?v=1.1"></script>
  <script src="/js/user.js?v=1.3"></script>
</body>
</html>