<%@ page contentType="text/html; charset=UTF-8" import="java.util.LinkedList,java.util.List"
pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<title>书籍详细信息</title>>
<body>
<center>
<p>作者信息</p>
<table border="1" align="center">
<tr>
    <td>编号</td>
    <td>姓名</td>
    <td>年龄</td>
    <td>国家</td>
<tr>
    <%List<String> authorInf = (List<String>)session.getAttribute("authorInf1");
    for (int i = 0; i < authorInf.size(); i++) {
  out.print("<td align=\"center\">"+authorInf.get(i)+"</td>");
} %>

<p>书籍详细信息</p>
<table border="1" align="center">
<tr>
    <td>ISBN</td>
    <td>书名</td>
    <td>作者编号</td>
    <td>作者姓名</td>
    <td>出版社</td>
    <td>出版日期</td>
    <td>价格</td>
    <td>修改</td>
    <td>删除</td>
<tr>
    <%List<String> bookInf = (List<String>)session.getAttribute("bookInf1");
    String username = (String)session.getAttribute("theAuthorName");
    for (int i = 0; i < bookInf.size(); i+=6) {
  out.print("<td align=\"center\">"+bookInf.get(i)+"</td>");
  out.print("<td align=\"center\">"+bookInf.get(i+1)+"</td>");
  out.print("<td align=\"center\">"+bookInf.get(i+2)+"</td>");
  out.print("<td align=\"center\">"+username+"</td>");
  
  out.print("<td align=\"center\">"+bookInf.get(i+3)+"</td>");
  out.print("<td align=\"center\">"+bookInf.get(i+4)+"</td>");
  out.print("<td align=\"center\">"+bookInf.get(i+5)+"</td>");
  out.print("<td align=\"center\"><a href=Gotoedit?isbn="+bookInf.get(i)+"><button type=\"button\">修改</button></a></td>");
  out.print("<td align=\"center\"><a href=Delete?isbn="+bookInf.get(i)+"><button type=\"button\">删除</button></a></td>");
} %>
</tr>
</table>

<a href=Start><button type="button">返回主页</button></a>
</center>
</body>
</html>