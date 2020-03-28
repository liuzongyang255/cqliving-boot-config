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
  <link rel="stylesheet" href="/layuiadmin/ext/codemirror/codemirror.css"  media="all"/>
  <link rel="stylesheet" href="/layuiadmin/ext/codemirror/lucario.css"  media="all"/>
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
    .CodeMirror{
        height: 700px
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
              <a class="layui-btn layui-btn-xs" lay-event="update" title="编辑"><i class="layui-icon layui-icon-edit"></i></a>
              <a class="layui-btn layui-btn-xs layui-btn-danger" lay-event="del" title="删除"><i class="layui-icon layui-icon-delete"></i></a>
            </script>
          </div>
        </div>
      </div>
      <div class="layui-col-md8">
        <div class="layui-card">
          <div class="layui-card-header">配置信息</div>
          <div class="layui-card-body">
            <input type="hidden" id="env-content-id" />
            <textarea id="env-content-edit" class="env-content-edit layui-hide"></textarea>
          </div>
        </div>
      </div>
    </div>
  </div>
  
  <script src="/layuiadmin/layui/layui.js"></script>  
  <script src="/js/common.js?v=1.0"></script>
  <script type="text/javascript" src="/layuiadmin/ext/codemirror/codemirror.js"></script>
  <script type="text/javascript" src="/layuiadmin/ext/codemirror/properties.js"></script>
  <script src="/js/common-env.js?v=1.0"></script>
</body>
</html>