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
      	<div class="layui-card-header"><i class="layui-icon layui-icon-rate-solid"></i>我的收藏</div>
          <div class="layui-card-body">
            <div class=" table-operate-btn" style="margin-bottom: 10px;">
              <div class="layui-inline">
                <input class="layui-input xs-input" id="name" name="name" placeholder="项目名"  autocomplete="off">
              </div>
              <button class="layui-btn layui-btn-xs" data-type="reloadColl">搜索</button>
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
                <input class="layui-input xs-input" id="realName" name="realName" placeholder="姓名"  autocomplete="off">
              </div>
              <button class="layui-btn layui-btn-xs" data-type="reload">搜索</button>
            </div>
            <table class="layui-hide" id="table-page" lay-filter="table-page"></table>
          </div>
        </div>
      </div>
      
    </div>
  </div>
  
  <script src="/layuiadmin/layui/layui.js"></script>  
  <script src="/js/common.js?v=1.1"></script>
  <script src="/js/home.js?v=1.1"></script>
</body>
</html>