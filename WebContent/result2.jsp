<%@ page contentType="text/html; charset=UTF-8" import="java.util.LinkedList,java.util.List"
pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<title>搜索结果</title>
<body>
<center>
    <h2 align="center">搜索结果</h2>

    <center>作者:</center>
	<table border="1" align="center">
	<tr>
	<%
	List<String> authorList = (List<String>)session.getAttribute("authorList1");
	if(authorList.size()==0)
		out.print("<td>无对应作者</td>");
	else{
		out.print("<td>姓名</td> <td>ID</td>");
	    for (int i = 0; i < authorList.size(); i=i+2) {
		  out.print("<tr><td align=\"center\"><a href=AuthorInf?username="+authorList.get(i)+">"
		    +authorList.get(i)+"</td>");
		  out.print("<td align=\"center\">"+authorList.get(i+1)+"</td></tr>");
		}
	}
	%>
	</table>
	
	<p><br /></p>
	
	<center>书籍:</center>
	<table  align="center">
	<tr>
	<%
	List<String> bookList = (List<String>)session.getAttribute("bookList1");
	if(bookList.size()==0)
		out.print("<td>无对应书籍</td>");
	else{
		out.print("<td>书名</td> <td>ISBN</td>");
	    for (int i = 0; i < bookList.size(); i=i+2) {
		  out.print("<tr><td align=\"center\"><a href=BookInf?title="+bookList.get(i)+">"
		    +bookList.get(i)+"</td>");
		  out.print("<td align=\"center\">"+bookList.get(i+1)+"</td></tr>");
		}
	}
	%>
	</table>
	
<a href=Start><button type="button">返回主页</button></a>
</center>
</body>
</html>