<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>

<script type="text/javascript">
	if (!'${user}'){
		window.location.href="/login";
	}
</script>
 <!-- 侧边菜单 -->
      <div class="layui-side layui-side-menu">
        <div class="layui-side-scroll">
          <div class="layui-logo" lay-href="/project">
            <span>配置中心 2.0</span>
          </div>
          <ul class="layui-nav layui-nav-tree" lay-shrink="all" id="LAY-system-side-menu" lay-filter="layadmin-system-side-menu">
            <li data-name="component" class="layui-nav-item layui-nav-itemed">
              <a href="javascript:;" lay-tips="项目配置" lay-direction="2">
                <i class="layui-icon layui-icon-component"></i>
                <cite>项目配置</cite>
              </a>
              <dl class="layui-nav-child">
                  <dd data-name="mobile-pc"><a lay-href="/project">项目管理</a></dd>
                  <dd data-name="mobile-pc"><a lay-href="/table">表生成</a></dd>
              </dl>
            </li>
             <li data-name="component" class="layui-nav-item">
              <a href="javascript:;" lay-tips="公共配置" lay-direction="2">
                <i class="layui-icon layui-icon-component"></i>
                <cite>公共配置</cite>
              </a>
              <dl class="layui-nav-child">
                  <dd data-name="mobile-pc"><a lay-href="/project">项目管理</a></dd>
              </dl>
            </li>
          </ul>
        </div>
      </div>

      <!-- 页面标签 -->
      <div class="layadmin-pagetabs" id="LAY_app_tabs">
        <div class="layui-icon layadmin-tabs-control layui-icon-prev" layadmin-event="leftPage"></div>
        <div class="layui-icon layadmin-tabs-control layui-icon-next" layadmin-event="rightPage"></div>
        <div class="layui-icon layadmin-tabs-control layui-icon-down">
          <ul class="layui-nav layadmin-tabs-select" lay-filter="layadmin-pagetabs-nav">
            <li class="layui-nav-item" lay-unselect>
              <a href="javascript:;"></a>
              <dl class="layui-nav-child layui-anim-fadein">
                <dd layadmin-event="closeThisTabs"><a href="javascript:;">关闭当前标签页</a></dd>
                <dd layadmin-event="closeOtherTabs"><a href="javascript:;">关闭其它标签页</a></dd>
                <dd layadmin-event="closeAllTabs"><a href="javascript:;">关闭全部标签页</a></dd>
              </dl>
            </li>
          </ul>
        </div>
        <div class="layui-tab" lay-unauto lay-allowClose="true" lay-filter="layadmin-layout-tabs">
          <ul class="layui-tab-title" id="LAY_app_tabsheader">
            <li lay-id="/home" lay-attr="/home" class="layui-this"><i class="layui-icon layui-icon-home"></i></li>
          </ul>
        </div>
      </div>