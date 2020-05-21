<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 添加界面 -->
	<div class="pageContent">
		<form method="post" action="smanager/add"	class="pageForm required-validate"	onsubmit="return validateCallback(this, dialogAjaxDone);">
			<div class="pageFormContent" layoutH="65">
				<p>
					<label>学     	 号：</label> <input name="sn" type="text" size="30" class="required" alt="请输入学号"/>
				</p>
				<p>
					<label>姓	名：</label> <input name="name" class="required"	type="text" size="30" alt="请输入学生姓名" />
				</p>			
				<p>
					<label>身份证号：</label> <input  name="" type="text"  size="30"  class="textInput">
				</p>
				<p>
					<label>性	别：</label> <input name="code"  type="text"	size="30"  />
				</p>				
				<p>
					<label>学	院：</label> <input name="" type="text" size="30" />
				</p>
				<p>
					<label>专	业：</label> <input name="" type="text" size="30" />
				</p>
				<p>
					<label>班	级：</label> <input name="" type="text" size="30" />
				</p>
				<p>
					<label>年	级：</label> <input name="" type="text" size="30" />
				</p>				
			</div>
			<div class="formBar">
				<ul>					
					<li><div class="buttonActive">
							<div class="buttonContent">
								<button type="submit">保存</button>
							</div>
						</div></li>
					<li>
						<div class="button">
							<div class="buttonContent">
								<button type="button" class="close">取消</button>
							</div>
						</div>
					</li>
				</ul>
			</div>
		</form>
	</div>
</body>
</html>