<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>开启分页 - 数据表格</title>
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
              <button class="layui-btn" data-type="addSpider"><i class="layui-icon layui-icon-add-1" style="color: #FFF;"></i>添加</button>
              <div class="layui-inline">
                <input class="layui-input" id="projectName" name="projectName" placeholder="项目名" id="test-table-demoReload" autocomplete="off">
              </div>
              <div class="layui-inline">
                <input class="layui-input" id="depict" name="depict" placeholder="描述" id="test-table-demoReload" autocomplete="off">
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
      ,url: '/project/page'
      ,cols: [[
        {field:'index', width:70, title: '序号'}
        ,{field:'projectName', width:'180', title: '项目名'}
        ,{field:'website', width:'150', title: '官网'}
        ,{field:'depict', width:'180', title: '描述'}
        ,{field:'dbUrl', width:180, title: '数据库url'}
        ,{field:'dbUsername', width:100, title: '数据库账号'}
        ,{field:'dbPass', width:100, title: '数据库密码'}
        ,{field:'extendsEntity', width:180, title: 'DO继承类'}
        ,{field:'ignorePropertiesInDo', width:'180', title: 'DO忽略字段'}
        ,{field:'queryUsePage', width:'80', title: '是否分页'}
        ,{width:'180', title: '操作', align:'center', fixed: 'right', toolbar: '#table-operate-bar'}
      ]]
      ,page: true
    });

    //监听工具条
    table.on('tool(table-page)', function(obj){
      var data = obj.data;
      if(obj.event === 'detail'){
        top.window.open('/video/v?id='+data.id, "_blank");
        
      } else if(obj.event === 'del'){
        layer.confirm('真的删除行么', function(index){
          obj.del();
          layer.close(index);
        });
        
      } else if(obj.event === 'update'){
    	  layeropen(data);
      }
    });


    var $ = layui.$, active = {
  	  addSpider: function(){
  		layeropen();
      },
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


    function layeropen(data, id){
        layer.open({
            title:'项目参数确认',
            area: '50%',
            content:'<form class="layui-form" id="spider-form">\
                <input type="hidden" value="'+(data&&data.id?data.id:'')+'" name="id">\
                <div class="layui-col-space10"><label class="layui-form-label">项目名：</label><div class="layui-input-block"><input type="text" value="'+(data&&data.projectName?data.projectName:'')+'" name="projectName" required  lay-verify="required" placeholder="项目名" autocomplete="off" class="layui-input"></div></div>\
                <div class="layui-col-space10"><label class="layui-form-label">官网：</label><div class="layui-input-block"><input type="text" value="'+(data&&data.website?data.website:'http://www.cqliving.com')+'" name="website" required  lay-verify="required" placeholder="官网" autocomplete="off" class="layui-input"></div></div>\
                <div class="layui-col-space10"><label class="layui-form-label">描述：</label><div class="layui-input-block"><input type="text" value="'+(data&&data.depict?data.depict:'')+'" name="depict" required  lay-verify="required" placeholder="描述" autocomplete="off" class="layui-input"></div></div>\
                <div class="layui-col-space10"><label class="layui-form-label">基础包：</label><div class="layui-input-block"><input type="text" value="'+(data&&data.basePackage?data.basePackage:'com.cqliving')+'" name="basePackage" required  lay-verify="required" placeholder="基础包" autocomplete="off" class="layui-input"></div></div>\
                <div class="layui-col-space10"><label class="layui-form-label">db链接：</label><div class="layui-input-block"><input type="text" value="'+(data&&data.dbUrl?data.dbUrl:'')+'" name="dbUrl" required  lay-verify="required" placeholder="数据库url" autocomplete="off" class="layui-input"></div></div>\
                <div class="layui-col-space10"><label class="layui-form-label">db账号：</label><div class="layui-input-block"><input type="text" value="'+(data&&data.dbUsername?data.dbUsername:'')+'" name="dbUsername" required  lay-verify="required" placeholder="数据库账号" autocomplete="off" class="layui-input"></div></div>\
                <div class="layui-col-space10"><label class="layui-form-label">db密码：</label><div class="layui-input-block"><input type="text" value="'+(data&&data.dbPass?data.dbPass:'')+'" name="dbPass" required  lay-verify="required" placeholder="数据库密码" autocomplete="off" class="layui-input"></div></div>\
                <div class="layui-col-space10"><label class="layui-form-label">DO继承类：</label><div class="layui-input-block"><input type="text" value="'+(data&&data.extendsEntity?data.extendsEntity:'')+'" name="extendsEntity" required  lay-verify="required" placeholder="DO继承类" autocomplete="off" class="layui-input"></div></div>\
                <div class="layui-col-space10"><label class="layui-form-label">忽略字段：</label><div class="layui-input-block"><input type="text" value="'+(data&&data.ignorePropertiesInDo?data.ignorePropertiesInDo:'id,createTime,creatorId,creator,updateIime,updatorId,updator')+'" name="ignorePropertiesInDo" required  lay-verify="required" placeholder="DO忽略字段" autocomplete="off" class="layui-input"></div></div>\
                <div class="layui-col-space10"><label class="layui-form-label">是否分页：</label><div class="layui-input-block"><input type="text" value="'+(data&&data.queryUsePage?data.queryUsePage:'false')+'" name="queryUsePage" required  lay-verify="required" placeholder="是否分页" autocomplete="off" class="layui-input"></div></div>\
                <div class="layui-col-space10"><label class="layui-form-label">用lombok：</label><div class="layui-input-block"><input type="text" value="'+(data&&data.useLombok?data.useLombok:'false')+'" name="useLombok" required  lay-verify="required" placeholder="是否使用Lombok" autocomplete="off" class="layui-input"></div></div>\
                </form>',
            btn:['确定','测试连接','取消'],
            yes: function(index, layero){
                var data = layero.find('#spider-form').serialize();
                layui.$.ajax({
                    url:'/project/save',
                    data:data,
                    type:'post',
                    success:function(data){
                        layer.msg(data.resultMessage);
                        active.reload();
                    }
                })
            },
            btn2:function(index, layero){
            	var data = layero.find('#spider-form').serialize();
                layui.$.ajax({
                    url:'/project/test/conn',
                    data:data,
                    type:'post',
                    success:function(data){
                        layer.tips(data.resultMessage, '.layui-layer-btn1');
                    }
                })
                return false;
            },
            btn3:function(index, layero){
            	layer.close(index);
            }
        });
    }

    
  });

  
  </script>
</body>
</html>