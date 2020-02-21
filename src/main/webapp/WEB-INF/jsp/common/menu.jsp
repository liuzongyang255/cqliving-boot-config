<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
                  <dd data-name="mobile-pc"><a lay-href="/common-env">公共配置</a></dd>
              </dl>
            </li>
            <c:if test="${user.userName eq 'admin'}">
                <li data-name="component" class="layui-nav-item layui-nav-itemed">
                  <a href="javascript:;" lay-tips="用户管理" lay-direction="2">
                    <i class="layui-icon layui-icon-component"></i>
                    <cite>用户管理</cite>
                  </a>
                  <dl class="layui-nav-child">
                      <dd data-name="mobile-pc"><a lay-href="/users">账户管理</a></dd>
                  </dl>
                </li>
            </c:if>
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