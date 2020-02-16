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
    .proj{
    	color: #63baf6
    }
  </style>
</head>
<body>

  <div class="layui-fluid">
    <div class="layui-row layui-col-space15">
      <div class="layui-col-md12">
        <div class="layui-card">
          <div class="layui-card-body">
            <div class=" table-operate-btn" style="margin-bottom: 10px;">
              <button class="layui-btn layui-btn-xs" data-type="add"><i class="layui-icon layui-icon-add-1" style="color: #FFF;"></i>添加</button>
              <div class="layui-inline">
                <input class="layui-input xs-input" id="name" name="name" placeholder="项目名" id="test-table-demoReload" autocomplete="off">
              </div>
              <button class="layui-btn layui-btn-xs" data-type="reload">搜索</button>
            </div>
            <table class="layui-hide" id="table-page" lay-filter="table-page"></table>
            <script type="text/html" id="table-operate-bar">
              <a class="layui-btn layui-btn-xs" lay-event="update" title="编辑"><i class="layui-icon layui-icon-edit"></i></a>
              <a class="layui-btn layui-btn-xs layui-btn-danger" lay-event="del" title="删除"><i class="layui-icon layui-icon-delete"></i></a>
            </script>
          </div>
        </div>
      </div>
    </div>
  </div>
  
  <script src="/layuiadmin/layui/layui.js"></script>
  <script src="/js/common.js?v=1.0"></script>
  <script src="/js/project-list.js?v=1.0"></script>
</body>
</html>