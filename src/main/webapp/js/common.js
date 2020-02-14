(function() {
    layui.use([ 'jquery', 'layer' ], function() {
        var layer = layui.layer
        // 将原ajax放到_ajax中
        , _ajax = layui.$.ajax, close = function(res, index) {
            layer.close(index);
            if (res.code && res.code == 103) {
                (window.top ? window.top : window).location.href = '/login'
            }
        };

        layui.$.ajax = function(cfg) {
            // 将原ajax 中的success方法保存为_success
            cfg._success = cfg.success;
            cfg.cache = false;
            // 重写ajax的success方法
            cfg.success = function(res) {
                if (!res.success) {
                    layer.alert(res.resultMessage || res.message, {
                        icon : 2,
                        yes : function(index, layero) {
                            close(res, index);
                        },
                        cancel : function(index) {
                            close(res, index);
                        }
                    });
                    return;
                }
                // 如果我们在前面没有return,在这里我们将后台返回的数据重新放入原先ajax
                if (cfg._success != null) {
                    cfg._success(res);
                }
            }
            _ajax(cfg);
        }
    })

})()