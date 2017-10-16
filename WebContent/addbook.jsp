<%@ page contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<title>添加图书</title>
<body>
<center>
    <h2>添加图书</h2>
    <s:form action="Addbook">
        <s:textfield name="isbn" label="ISBN"/>
        <s:textfield name="title" label="书名"/>
        <s:textfield name="authorid" label="作家ID"/>
        <s:textfield name="publisher" label="出版社"/>
        <s:textfield name="publishdate" label="出版日期"/>
        <s:textfield name="price" label="价格"/>
        <s:submit value="添加"/>
    </s:form>
</center>
</body>
</html>