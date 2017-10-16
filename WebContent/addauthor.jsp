<%@ page contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<title>添加作者</title>
<body>
<center>
    <h2 align="center">添加作家</h2>
    <s:form action="Addauthor">
        <s:textfield name="authorid" label="编号" />
        <s:textfield name="name" label="作家名"/>
        <s:textfield name="age" label="年龄"/>
        <s:textfield name="country" label="国籍"/>
        <s:submit value="添加"/>
    </s:form>
</center>
</body>
</html>