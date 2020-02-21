layui.config({
    base: '/layuiadmin/' //静态资源所在路径
  }).extend({
    index: 'lib/index' //主入口模块
  }).use(['index', 'table'], function(){
    var table = layui.table,
    layer = top.layer?top.layer:layui.layer;
  
    table.render({
      elem: '#table-page'
      ,url: '/users/page?orderField=create_time&sort=desc'
      ,cols: [[
        {field:'index', width:70, title: '序号'}
        ,{field:'realName',  title: '姓名'}
        ,{field:'userName',  title: '用户名'}
        ,{field:'email',  title: '邮箱'}
        ,{field:'createTime', title: '创建时间'}
        ,{field:'creator', title: '创建人'}
        ,{title: '操作', align:'center', fixed: 'right', toolbar: '#table-operate-bar'}
      ]]
      ,page: true,
    });
    
    var $ = layui.$, active = {
      reload: function(){
    	  table.reload('table-page', {
            page: {
              curr: 1 //重新从第 1 页开始
            }
            ,where: {
            	realName: $('#realName').val(),
            	userName: $('#userName').val(),
            	email: $('#email').val(),
            }
          });
      },
      add: function(){
    	  layer.open({
              title:'添加用户',
              area: '400px',
              content:'<form class="layui-form" id="user-add-form">'
                  + '<div class="layui-col-space10"><label class="layui-form-label">用&nbsp;&nbsp;户&nbsp;&nbsp;名：</label><div class="layui-input-block"><input type="text" value="" name="userName" required  lay-verify="required" placeholder="用户名" autocomplete="off" class="layui-input"></div></div>'
                  + '<div class="layui-col-space10"><label class="layui-form-label">密　　码：</label><div class="layui-input-block"><input type="text" value="" name="userPass" required  lay-verify="required" placeholder="密码" autocomplete="off" class="layui-input"></div></div>'
                  + '<div class="layui-col-space10"><label class="layui-form-label">确认密码：</label><div class="layui-input-block"><input type="text" value="" name="userPass2" required  lay-verify="required" placeholder="再次数据密码" autocomplete="off" class="layui-input"></div></div>'
                  + '<div class="layui-col-space10"><label class="layui-form-label">姓　　名：</label><div class="layui-input-block"><input type="text" value="" name="realName" required  lay-verify="required" placeholder="姓名" autocomplete="off" class="layui-input"></div></div>'
                  + '<div class="layui-col-space10"><label class="layui-form-label">邮　　箱：</label><div class="layui-input-block"><input type="text" value="" name="email" required  lay-verify="required" placeholder="邮箱" autocomplete="off" class="layui-input"></div></div>'
                  + '</form>',
              btn:['确定', '取消'],
              yes: function(index, layero){
                  var data = layero.find('#user-add-form').serialize();
                  layui.$.ajax({
                      url:'/users/add',
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
    };
    
    $('.table-operate-btn .layui-btn').on('click', function(){
      var type = $(this).data('type');
      active[type] ? active[type].call(this) : '';
    });
    
    //监听工具条
    table.on('tool(table-page)', function(obj){
      var data = obj.data;
      if(obj.event === 'reset'){
          layer.confirm('真的重置密码？', function(index){
              $.ajax({
                  url:'/users/reset?userId='+data.id,
                  success:function(data){
                      layer.alert("重置密码成功，新密码：xhl123456",{title:'成功',icon : 1})
                  }
              })
          });
      }
    });
    
  });