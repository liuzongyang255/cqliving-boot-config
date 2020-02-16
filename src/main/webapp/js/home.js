layui.config({
    base: '/layuiadmin/' //静态资源所在路径
  }).extend({
    index: 'lib/index' //主入口模块
  }).use(['index', 'table'], function(){
    var table = layui.table;
  
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
      ,page: true,
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
        ,page: false
      });

    var $ = layui.$, active = {
    		
	  reloadColl: function(){
		  table.reload('coll-table', {
            page: false
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