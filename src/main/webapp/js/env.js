layui.config({
    base: '/layuiadmin/' //静态资源所在路径
}).extend({
    index: 'lib/index' //主入口模块
}).use(['index', 'table','form'], function(){
    var table = layui.table
    ,$ = layui.$
    ,form = layui.form
    ,layer = top.layer?top.layer:layui.layer;
  
    // 初始化表格
    table.render({
        elem: '#table-page'
        ,url: '/project/env/list?projectId='+$('#projectId').val()
        ,cols: [[
            {field:'envName', align:'center', title: '环境',templet:function(d){
        	       return '<a  class="layui-btn layui-btn-xs layui-btn-radius" lay-event="envEdit">'+d.envName+'</a>';
            }}
            ,{title: '操作', align:'center', fixed: 'right', toolbar: '#table-operate-bar'}
        ]]
        ,page: true
    });
    
    // 按钮点击事件
    var active = {
       add : function() {
           layeropen();
       },
       save : function() {
           
           var commonId = '';
           $("input[name='common-id']:checked").each(function() { 
               commonId += $(this).attr('data-id') +',';
           });
           if (commonId){
               commonId = commonId.substr(0, commonId.length - 1)  
           }
           
           var envId = $('#env-content-id').val();
           if (!envId){
               layer.msg('请选择环境')
               return;
           }
           
           var content = envEditor.getValue();
           if (content) {
               $.ajax({
                   url : '/project/env/save',
                   type : 'post',
                   data : { content : content.replace('\n\n','\n'), id : envId , commonIds:commonId},
                   success : function(data) {
                       if (data.success){
                           active.reload();
                       }
                       layer.msg(data.resultMessage);
                   }
               })
           }
       },
       reload : function() {
           table.reload('table-page', {
               page : {
                   curr : 1
               //重新从第 1 页开始
               },
               where : {
                   envName : $('#envName').val(),
               }
           });
       }
    };
        
    
    $('.layui-btn').on('click', function() {
        var type = $(this).data('type');
        active[type] ? active[type].call(this) : '';
    });
    
    
    var envEditor;// 当前环境编辑
    var commonEditor;// 公共环境编辑
    
    //监听工具条
    table.on('tool(table-page)', function(obj) {
        var data = obj.data;
        if (obj.event === 'envEdit') {
            $('#current-eidt').html('(当前编辑环境：'+data.envName+')');
            $('#env-content-id').val(data.id);
            $('#env-content-edit').text('').next('.CodeMirror').remove();
            if (data.content) {
            	envEditor = genCodemirrorDiv('env-content-edit', data.content)
            }
            // 加载公共配置
            $.ajax({
                url:'/common-env/listWithUsed?envId='+data.id,
                success:function(data){
                    if (data.success){
                        $('#env-common-box').html('');
                        $('#env-common-content').text('').next('.CodeMirror').remove();
                        var content = '';
                        $.each(data.data, function(i,e){
                            $('#env-common-box').append('<input name="common-id" class="common-checkbox" lay-filter="commonCheckbox" data="'+e.content.replace(new RegExp("\r\n","g"),'　')+'" type="checkbox" data-id="'+e.id+'" lay-skin="primary" title="'+e.envName+'" '+(e.used?'checked':'')+'>');
                            if (e.used){
                            	content +='\n# '+e.envName + '\n' + e.content
                            }
                        })
                        commonEditor= genCodemirrorDiv('env-common-content', content, true);
                        
                    }else{
                        layer.msg(data.resultMessage)
                    }
                    form.render();
                }
            })
        } else if (obj.event === 'update') {
            layeropen(data);
        } else if (obj.event === 'del') {
            layer.confirm('真的删除么？', function(index){
                $.ajax({
                    url:'/project/env/del?envId='+data.id,
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
        } else if (obj.event === 'publish') {
            console.log('publish')
        } else if (obj.event === 'download') {
        	window.open('/project/env/export?envId='+data.id, '_parent')
        }
        
    });
    
    function genCodemirrorDiv(elementId, content, readOnly){
    	var editor = CodeMirror.fromTextArea(document.getElementById(elementId), {
            lineNumbers: true,
            styleActiveLine: true,
            matchBrackets: true,
            theme: 'lucario',
            readOnly: readOnly
          });
        editor.setValue(content)
        return editor;
    }
    
    form.on('checkbox(commonCheckbox)', function(obj){
        //当前元素
        var data = $(obj.elem);
        var check = obj.elem.checked;
        var thisContent = '# '+data.attr('title')+'\n'+(data.attr('data').replace(new RegExp("　","g"), '\n'));
        var value = commonEditor.getValue();
        value = value?value:'';
        
        if (check){
        	commonEditor.setValue(value +'\n'+ thisContent)
        }else{
        	commonEditor.setValue(value.replace('\n'+thisContent,''))
        }
    });
    
    function layeropen(data, id){
        layer.open({
            title:'项目参数确认',
            area: '400px',
            content:'<form class="layui-form" id="env-form">'
                + '<input type="hidden" value="'+$('#projectId').val()+'" name="projectId">'
                + '<input type="hidden" value="'+(data&&data.id?data.id:'')+'" name="id">'
                + '<div class="layui-col-space10"><label class="layui-form-label">环境名：</label><div class="layui-input-block"><input type="text" value="'+(data&&data.envName?data.envName:'')+'" name="envName" required  lay-verify="required" placeholder="环境名" autocomplete="off" class="layui-input"></div></div>'
                + '</form>',
            btn:['确定', '取消'],
            yes: function(index, layero){
                var data = layero.find('#env-form').serialize();
                
                var name = layero.find('input[name="envName"]').val();
                if(!/^[a-zA-Z0-9_\-]+$/.test(name)){
                	layer.msg("环境名只能是数字，下划线，中划线，字母组合");
                	return;
                }
                
                layui.$.ajax({
                    url:'/project/env/save',
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
    
});
