<%--
  Created by IntelliJ IDEA.
  User: whc
  Date: 2020/4/13
  Time: 10:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%
	String bathPath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
		+ request.getContextPath() + "/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>学生管理系统</title>
<base href="<%=bathPath %>"/> 
<link href="static/themes/default/style.css" rel="stylesheet"	type="text/css" media="screen" />
<link href="static/themes/css/core.css" rel="stylesheet" type="text/css"
	media="screen" />
<link href="static/themes/css/print.css" rel="stylesheet"	type="text/css" media="print" />
<link href="static/uploadify/css/uploadify.css" rel="stylesheet" type="text/css" media="screen" />
<!--[if IE]>
<link href="themes/css/ieHack.css" rel="stylesheet" type="text/css" media="screen"/>
<![endif]-->

<!--[if lt IE 9]><script src="js/speedup.js" type="text/javascript"></script><script src="js/jquery-1.11.3.min.js" type="text/javascript"></script><![endif]-->
<!--[if gte IE 9]><!-->
<script src="static/js/jquery-2.1.4.min.js" type="text/javascript"></script>
<!--<![endif]-->

<script src="static/js/jquery.cookie.js" type="text/javascript"></script>
<script src="static/js/jquery.validate.js" type="text/javascript"></script>
<script src="static/xheditor/xheditor-1.2.2.min.js"	type="text/javascript"></script>
<script src="static/xheditor/xheditor_lang/zh-cn.js" type="text/javascript"></script>
<script src="static/uploadify/scripts/jquery.uploadify.js" type="text/javascript"></script>

<script type="text/javascript" src="static/chart/echarts.min.js"></script>
<script src="static/js/dwz.min.js" type="text/javascript"></script>


<script type="text/javascript">
	$(function() {
		DWZ.init("dwz.frag.xml", {
			loginUrl : "login_dialog.html",
			loginTitle : "登录", // 弹出登录对话框
			//		loginUrl:"login.html",	// 跳到登录页面
			statusCode : {
				ok : 200,
				error : 300,
				timeout : 301
			}, //【可选】
			pageInfo : {
				pageNum : "pageNum",
				numPerPage : "numPerPage",
				orderField : "orderField",
				orderDirection : "orderDirection"
			}, //【可选】
			keys : {
				statusCode : "statusCode",
				message : "message"
			}, //【可选】
			ui : {
				hideMode : 'offsets'
			}, //【可选】hideMode:navTab组件切换的隐藏方式，支持的值有’display’，’offsets’负数偏移位置的值，默认值为’display’
			debug : false, // 调试模式 【true|false】
			callback : function() {
				initEnv();
				$("#themeList").theme({
					themeBase : "themes"
				}); // themeBase 相对于index页面的主题base路径
			}
		});
	});
</script>

</head>

<body scroll="no">
	<div id="layout">
		<div id="header">
			<div class="headerNav">
				<a class="logo" style="text-decoration: none;" href="#">学生管理系统</a>
				<ul class="nav" style="margin-top: 2px">
					<li><span style="color: white; font-size: 10px">你好，${admin.username}</span></li>
					<li><a href="#">退出</a></li>
				</ul>
				<ul class="themeList" id="themeList">
					<li theme="default"><div class="selected">蓝色</div></li>
					<li theme="green"><div>绿色</div></li>
					<li theme="purple"><div>紫色</div></li>
					<li theme="silver"><div>银色</div></li>
					<li theme="azure"><div>天蓝</div></li>
				</ul>
			</div>

			<!-- navMenu -->

		</div>

		<div id="leftside">
			<div id="sidebar_s">
				<div class="collapse">
					<div class="toggleCollapse">
						<div></div>
					</div>
				</div>
			</div>
			<div id="sidebar">
				<div class="toggleCollapse">
					<h2>功能菜单</h2>
					<div>收缩</div>
				</div>
				<div class="accordion" fillSpace="sidebar">
					<c:forEach items="${tModules}" var="t1">
						<div class="accordionHeader">
							<h2>
								<span>Folder</span>
								<c:if test="${ t1.modulename != null}">${t1.modulename}</c:if>
							</h2>
						</div>
						<div class="accordionContent">
							<ul class="tree treeFolder">
								<c:forEach items="${tModules2 }" var="t2">
									<c:if test="${t1.moduleid != null && t2.parentid != null && t1.moduleid == t2.parentid}">
										<li><a>${t2.modulename}</a>
											<ul>
												<c:forEach items="${tModules3}" var="t3">
													<c:if test="${t2.moduleid != null && t3.parentid != null && t2.moduleid == t3.parentid}">
														<li><a href="${t3.execfile}" target="navTab" rel="${t3.rel}">${t3.modulename}</a></li>
													</c:if>
												</c:forEach>
											</ul>
										</li>
									</c:if>
								</c:forEach>
							</ul>
						</div>
					</c:forEach>
				</div>
			</div>
		</div>
		<div id="container">
			<div id="navTab" class="tabsPage"> 
				<div class="tabsPageHeader">
					<div class="tabsPageHeaderContent">
						<!-- 显示左右控制时添加 class="tabsPageHeaderMargin" -->
						<ul class="navTab-tab">
							<li tabid="main" class="main"><a href="javascript:;"> <span>
										<span class="home_icon">我的主页</span>
								</span>
							</a></li>
						</ul>
					</div>
					<div class="tabsLeft">left</div>
					<!-- 禁用只需要添加一个样式 class="tabsLeft tabsLeftDisabled" -->
					<div class="tabsRight">right</div>
					<!-- 禁用只需要添加一个样式 class="tabsRight tabsRightDisabled" -->
					<div class="tabsMore">more</div>
				</div>
				<ul class="tabsMoreList">
					<li><a href="javascript:;">我的主页</a></li>
				</ul>
				<div class="navTab-panel tabsPageContent layoutBox">
					<div class="page unitBox">
						<div class="accountInfo">
							<div class="alertInfo">
								<p>
									<a href="#" target="_blank" style="line-height: 19px"><span>系统列表</span></a>
								</p>
							</div>
							<div class="right"></div>
							<p>
								<span>常用功能</span>
							</p>
						</div>
						<div class="pageFormContent" layoutH="80"
							style="margin-right: 230px">
							<h2>DWZ系列开源项目:</h2>
						</div>
					</div>

				</div>
			</div>
		</div>

	</div>

	<div id="footer">Copyright &copy; 2020 by whc</div>

</body>
</html>

