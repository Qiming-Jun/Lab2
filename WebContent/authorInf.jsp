<%@ page contentType="text/html; charset=UTF-8" import="java.util.LinkedList,java.util.List"
pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<title>作家信息</title>
<body>

<center>
    <p>作家个人信息</p>
	<table border="1" align="center">
	<tr>
	    <td>编号</td>
	    <td>姓名</td>
	    <td>年龄</td>
	    <td>国家</td>
	    <td>删除</td>
	</tr>
    <%List<String> authorInf = (List<String>)session.getAttribute("authorInf");
//    String username = (String)session.getAttribute("username");
    for (int i = 0; i < authorInf.size(); i=i+4) {
    	out.print("<tr>");
 		 out.print("<td>"+authorInf.get(i)+"</td>");
 		out.print("<td>"+authorInf.get(i+1)+"</td>");
 		out.print("<td>"+authorInf.get(i+2)+"</td>");
 		out.print("<td>"+authorInf.get(i+3)+"</td>");
 		out.print("<td><a href=DeleteAuthor?authorid="+authorInf.get(i)+"><button type=\"button\">删除</button></a></td>");
 		out.print("</tr>");
	}%>
	</table>
	
	<h2 align="center">书籍信息</h2>
	<p align="center">
	<%List<String> authorBook = (List<String>)session.getAttribute("authorBook");
    String username = (String)session.getAttribute("username");
    for (int i = 0; i < authorBook.size(); i++) {
 		 out.print("<a href=BookInf?title="+authorBook.get(i)+">"
    		+authorBook.get(i)+"<br />");
	}%>
	</p>
	
<a href=Start><button type="button">返回主页</button></a>
</center>
</body>
</html>