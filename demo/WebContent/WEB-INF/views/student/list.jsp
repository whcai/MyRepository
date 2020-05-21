<%--
  Created by IntelliJ IDEA.
  User: whc
  Date: 2020/4/15
  Time: 9:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
</head>
<body>
	<form id="pagerForm" method="post" action="w_list.html">
		<input type="hidden" name="pageNum" value="1" /> <input type="hidden"
			name="numPerPage" value="${model.numPerPage}" /> <input
			type="hidden" name="orderField" value="${param.orderField}" /> <input
			type="hidden" name="orderDirection" value="${param.orderDirection}" />
	</form>
	<div class="pageHeader">
		<form rel="pagerForm" onsubmit="return navTabSearch(this);"
			action="smanager/list" method="post">
			<div class="searchBar">
				<ul class="searchContent">
					<li><label>学 号：</label> <input type="text" name="sno" /></li>
					<li><lable>姓 名：</lable><input type="text" name="name" /></li>
					<li><lable>身份证号：</lable><input type="text" name="name" /></li>
				</ul>
				<div class="subBar">
					<ul>
						<li><div class="buttonActive">
								<div class="buttonContent">
									<button type="submit">检索</button>
								</div>
							</div></li>
						<li><a class="button" href="demo_page6.html" target="dialog"
							mask="true" title="查询框"><span>高级检索</span></a></li>
					</ul>
				</div>
			</div>
		</form>
	</div>
	<div class="pageContent">
		<div class="panelBar">
			<ul class="toolBar">
				<li><a class="add" href="smanager/init" target="dialog" width="600" height="400" ><span>添加</span></a></li>
				<li><a class="delete" href="smanager/del?sid={sid_student}"	target="ajaxTodo" title="确定要删除吗？" warn="请选择一个用户"><span>删除</span></a></li>
				<li><a class="edit" href="smanager/edit?sid={sid_student}"	target="target" warn="请选择一个用户"><span>修改</span></a></li>			
			</ul>
		</div>

		<div id="w_list_print">
			<table class="list" width="98%" targetType="navTab" asc="asc"
				desc="desc" layoutH="116">
				<thead>
					<tr>
						<th align="center" width="80" orderField="name" class="asc">学号</th>
						<th align="center" width="100" orderField="num" class="desc">姓名</th>
						<th align="center" width="100">身份证号</th>
						<th align="center" width="100">性别</th>
						<th align="center" width="100">学院</th>
						<th align="center" width="100">专业</th>
						<th align="center" width="100">班级</th>
						<th align="center" width="100">年级</th>
						<th align="center" width="100">年级</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="" var="s">
						<tr target="sid_student" rel="${s.id}">
							<td>${s.sno }</td>
							<td>${s.name }</td>
							<td>${s.cardid }</td>
							<td>${s.sex }</td>
							<td>${s.cid }</td>
							<td>${s.pid}</td>
							<td>${s.bid }</td>
							<td>${s.gid }</td>
							<td>${s.hid }</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>

		<div class="panelBar">
			<div class="pages">
				<span>显示</span> <select name="numPerPage"
					onchange="navTabPageBreak({numPerPage:this.value})">
					<option value="20">20</option>
					<option value="50">50</option>
					<option value="100">100</option>
					<option value="200">200</option>
				</select> <span>条，共23条</span>
			</div>
			<div class="pagination" targetType="navTab" totalCount="200"
				numPerPage="20" pageNumShown="10" currentPage="2"></div>
		</div>
	</div>
</body>
</html>
