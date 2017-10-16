<%@ page contentType="text/html; charset=UTF-8" import="java.util.LinkedList,java.util.List"
pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<title>图书管理系统</title>
<body>
<h1 align="center">欢迎来到图书管理系统</h1>
    <center>
    <s:form action="Search">
        <s:textfield name="indexMessage" label="搜索书籍、作者、作者ID、ISBN"/><s:submit value="查询"/>
    </s:form>
    
    
    <a align="center" href=Gotoadd><button type="button">添加书籍</button></a>
    <a align="center" href=AddauthorTemp><button type="button">添加作者</button></a>
    <a align="center" href=Start><button type="button">刷新</button></a>
    
    
    <p align="center">
              图书馆所有作者：<br />
    <%List<String> authorList = (List<String>)session.getAttribute("authorList");
    	for (int i = 0; i < authorList.size(); i++) {
  		out.print("<a href=AuthorInf?username="+authorList.get(i)+">"+authorList.get(i)+"<br />");
		} %>
	</p>
	
	<p align="center">
	图书馆库存图书：<br />
	<%List<String> bookList = (List<String>)session.getAttribute("bookList");
    	for (int i = 0; i < bookList.size(); i++) {
  		out.print("<a href=BookInf?title="+bookList.get(i)+">"
    				+bookList.get(i)+"<br />");
	} %></p>
	

</table>
</center>

</body>
</html>