layui.config({
    base: '/layuiadmin/' //静态资源所在路径
  }).extend({
    index: 'lib/index' //主入口模块
  }).use(['index', 'table'], function(){
    var table = layui.table
    ,$ = layui.$
    ,layer = top.layer?top.layer:layui.layer;
  
    var collect = {
		yes:'<svg t="1581405348510" class="icon" viewBox="0 0 1080 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="2060" width="200" height="200"><path d="M1077.529145 388.206248C1072.06379 371.533456 1056.511742 360.326019 1039.008769 360.326019L686.956883 360.326019 578.161726 27.824884C572.876243 11.207437 557.37954 0 539.765877 0 522.262904 0 506.710856 11.207437 501.370028 27.700357L392.450343 360.326019 40.467639 360.326019C22.909321 360.326019 7.398781 371.533456 2.002608 388.206248-3.462747 404.713004 2.528389 422.963139 16.682967 433.119014L301.504067 638.533348 192.764255 971.214355C187.243555 987.776457 193.234691 1005.860556 207.444614 1016.127121 221.474665 1026.338342 240.845544 1026.338342 254.944776 1016.127121L539.765877 810.588261 824.642322 1016.127121C831.629675 1021.191223 839.972989 1023.820128 848.371649 1023.820128 856.701127 1023.820128 865.099787 1021.191223 872.142485 1016.127121 886.297062 1005.860556 892.288199 987.776457 886.767498 971.214355L778.138377 638.533348 1062.793441 433.119014C1076.934183 422.963139 1082.869974 404.713004 1077.529145 388.206248Z" fill="#f4ea2a" p-id="2061"></path></svg>',
		no:'<svg t="1581405191894" class="icon" viewBox="0 0 1080 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="1931" width="200" height="200"><path d="M1077.529145 388.206248C1072.06379 371.533456 1056.511742 360.326019 1039.008769 360.326019L686.956883 360.326019 578.161726 27.824884C572.876243 11.207437 557.37954 0 539.765877 0 522.262904 0 506.710856 11.207437 501.370028 27.700357L392.450343 360.326019 40.467639 360.326019C22.909321 360.326019 7.398781 371.533456 2.002608 388.206248-3.462747 404.713004 2.528389 422.963139 16.682967 433.119014L301.504067 638.533348 192.764255 971.214355C187.243555 987.776457 193.234691 1005.860556 207.444614 1016.127121 221.474665 1026.338342 240.845544 1026.338342 254.944776 1016.127121L539.765877 810.588261 824.642322 1016.127121C831.629675 1021.191223 839.972989 1023.820128 848.371649 1023.820128 856.701127 1023.820128 865.099787 1021.191223 872.142485 1016.127121 886.297062 1005.860556 892.288199 987.776457 886.767498 971.214355L778.138377 638.533348 1062.793441 433.119014C1076.934183 422.963139 1082.869974 404.713004 1077.529145 388.206248Z" fill="#dbdbdb" p-id="1932"></path></svg>'
    }
    
    table.render({
      elem: '#table-page'
      ,url: '/project/page'
      ,cols: [[
        {field:'index', width:70, title: '序号'}
        ,{field:'name',  title: '项目名', templet:function(d){
      	  return '<a lay-href="/project/env?id='+d.id+'" class="proj">'+d.name+'</a>';
        }}
        ,{field:'remark', title: '备注'}
        ,{field:'realName', title: '创建人'}
        ,{field:'collect', title: '收藏', templet:function(data){
        	if(data.collect){
        		return '<p class="collect" cl="'+data.collect+'" id="'+data.id+'">'+collect.yes+'</p>';
        	}else{
        		return '<p class="collect" cl="'+data.collect+'" id="'+data.id+'">'+collect.no+'</p>'
        	}
        }}
        ,{title: '操作', align:'center', fixed: 'right', toolbar: '#table-operate-bar'}
      ]]
      ,page: true
    });
    
    $('body').on('click','.collect',function(){
    	var cl = false;
    	if ($(this).attr('cl')=='true'){
    		$(this).attr('cl','false');
    		$(this).html('').html(collect.no);
    	}else{
    		$(this).attr('cl','true');
    		cl = true;
    		$(this).html('').html(collect.yes);
    	}
    	
    	$.ajax({
    		url:'/collect/save',
    		type:'post',
    		data:{projectId:$(this).attr('id'), cl:cl},
    		success:function(data){
    			layer.msg(cl?'收藏成功':'取消收藏成功');
    		}
    	})
    	
    })

    //监听工具条
    table.on('tool(table-page)', function(obj){
      var data = obj.data;
      if(obj.event === 'update'){
    	  layeropen(data);
      }else if (obj.event === 'del'){
          layer.confirm('真的删除么？', function(index){
              $.ajax({
                  url:'/project/del?id='+data.id,
                  type:'post',
                  success:function(data){
                      if (data.success){
                          obj.del();
                          layer.close(index);
                      }
                      layer.msg(data.resultMessage);
                  }
              })
          });
      }
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
            	name: $('#name').val(),
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
            area: '500px',
            content:'<form class="layui-form" id="project-form">'
                +'<input type="hidden" value="'+(data&&data.id?data.id:'')+'" name="id">'
                +'<div class="layui-col-space10"><label class="layui-form-label">项目名：</label><div class="layui-input-block"><input type="text" value="'+(data&&data.name?data.name:'')+'" name="name" required  lay-verify="required" placeholder="项目名" autocomplete="off" class="layui-input"></div></div>'
                +'<div class="layui-col-space10"><label class="layui-form-label">备注：</label><div class="layui-input-block"><input type="text" value="'+(data&&data.remark?data.remark:'')+'" name="remark" required  lay-verify="required" placeholder="备注" autocomplete="off" class="layui-input"></div></div>'
                +'</form>',
            btn:['确定', '取消'],
            yes: function(index, layero){
                var data = layero.find('#project-form').serialize();
                
                var name = layero.find('input[name="name"]').val();
                if(!/^[a-zA-Z0-9_\-]+$/.test(name)){
                    layer.msg("项目名只能是数字，下划线，中划线，字母组合");
                    return;
                }
                
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
            	layer.close(index);
            }
        });
    }
  });