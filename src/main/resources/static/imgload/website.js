(function() {
    var t, n, o, i, c, e, r;
    n = $(window),
    t = $(document),
    e = {
        wrapper: $(".grid-wrapper"),
        item: $(".grid-item")
    },
    e.wrapper.hide(),
    c = $(".control-button"),
    i = {
        one: $(".control-button.one"),
        two: $(".control-button.two"),
        three: $(".control-button.three"),
        four: $(".control-button.four"),
        five: $(".control-button.five"),
        six: $(".control-button.six"),
        seven: $(".control-button.seven"),
        eight: $(".control-button.eight"),
        nine: $(".control-button.nine"),
        ten: $(".control-button.ten"),
        eleven: $(".control-button.eleven"),
        twelve: $(".control-button.twelve"),
        bottom_one: $(".control-button.bottom-one")
    },
    r = {
        one: $(".control-input.one")
    },
    o = function(t) {
        var n, o;
        n = $('<div class="grid-item"><img src="' + t + '"></div>'),
        o = e.wrapper,
        $.imgload(t, function() {
            return n.appendTo(e.wrapper),
            $.stackgrid.append(n)
        })
    },
    n.on("load", function() {
        return e.wrapper.show().fadeIn(),
        $.stackgrid(".grid-wrapper", ".grid-item", {
            move: function(t, n, o, i) {
                t.stop().velocity({
                    left: n,
                    top: o
                },
                500,
                function() {
                    return i()
                })
            },
            scale: function(t, n, o, i) {
                t.stop().velocity({
                    height: n,
                    width: o
                },
                function() {
                    return i()
                })
            }
        }),
        t.on("click", ".grid-item", function() {
            $(this).remove(),
            $.stackgrid.restack(),
			console.log(111);
        }),
        i.bottom_one.on("click", function() {
            var t;
            t = r.one.val(),
            o(t),
            r.one.val("")
        }),
        c.on("click", function(t) {
            t.preventDefault()
        }),
        i.one.on("click", function() {
            var t;
            t = "img/small.png",
            o(t)
        }),
        i.two.on("click", function() {
            var t;
            t = "img/medium.png",
            o(t)
        }),
        i.three.on("click", function() {
            var t;
            t = "img/large.png",
            o(t)
        }),
        i.four.on("click", function() {
            $.stackgrid.config.gutter = 20,
            $.stackgrid.restack()
        }),
        i.five.on("click", function() {
            $.stackgrid.config.gutter = 0,
            $.stackgrid.restack()
        }),
        i.six.on("click", function() {
            $.stackgrid.config.is_optimized = !0,
            $.stackgrid.restack()
        }),
        i.seven.on("click", function() {
            $.stackgrid.config.is_optimized = !1,
            $.stackgrid.restack()
        }),
        i.eight.on("click", function() {
            $.stackgrid.config.is_fluid = !0,
            $.stackgrid.restack()
        }),
        i.nine.on("click", function() {
            $.stackgrid.config.is_fluid = !1,
            $.stackgrid.restack()
        }),
        i.ten.on("click", function() {
            $(".grid-item").remove(),
            $.stackgrid.reset(),
            $.stackgrid.restack()
        }),
        i.eleven.on("click", function() {
            $.stackgrid.config.column_width = 320,
            $.stackgrid.reset(),
            $.stackgrid.restack()
        }),
        i.twelve.on("click", function() {
            $.stackgrid.config.column_width = 200,
            $.stackgrid.reset(),
            $.stackgrid.restack()
        })
    })
}).call(this);