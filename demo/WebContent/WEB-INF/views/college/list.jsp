<%--
  Created by IntelliJ IDEA.
  User: whc
  Date: 2020/4/15
  Time: 9:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
</head>
<body>
	<div class="pageHeader">
		<form onsubmit="return navTabSearch(this);" action="cmanager/list"
			method="post">
			<div class="searchBar">
				<table class="searchContent">
					<tr>
						<td><lable>学院号：</lable><input type="text" name="cid" /></td>
					</tr>
					<tr>
						<td>
							<ul>
								<li>
									<div class="buttonActive">
										<div class="buttonContent">
											<button type="submit">查询</button>
										</div>
									</div>
								</li>
								<li>
									<div class="buttonActive">
										<div class="buttonContent">
											<button type="reset">重置</button>
										</div>
									</div>
								</li>
							</ul>
						</td>
					</tr>
				</table>
			</div>
		</form>
	</div>
	<div class="pageContent">
		<div class="panelBar">
			<ul class="toolBar">
				<li><a class="add" href="cmanager/init" target="dialog"	width="400" height="150" rel="a_college"><span>添加</span></a></li>
				<li><a class="delete" href="cmanager/delete?cid={cid_college}"	target="ajaxTodo" title="确定要删除吗？" warn="请选择一个学院" rel="d_college"><span>删除</span></a></li>
				<li><a class="edit" href="cmanager/edit?cid={cid_college}"	target="target" warn="请选择一个学院" rel="e_college"><span>修改</span></a></li>
			</ul>
		</div>

		<div id="collegeMain">
			<table class="list" width="50%" targetType="navTab" asc="asc"
				desc="desc" layoutH="116">
				<thead>
					<tr>
						<th align="center" width="5%" orderField="cid" class="asc">学院号</th>
						<th align="center" width="10%" orderField="num" class="desc">学院名</th>
						<th align="center" width="10%">修改日期</th>
						<th align="center" width="10%">备注</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${colleges }" var="c">
						<tr target="cid_college" rel="${c.cid}">
							<td>${c.cid }</td>
							<td>${c.cname }</td>
							<td>${c.editdate }</td>
							<td>${c.note }</td>
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
