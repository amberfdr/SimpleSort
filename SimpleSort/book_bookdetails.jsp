<%@ page contentType="text/html; charset=GB2312" %>
<%@ include file="book_common.jsp"%>
<%@ page import="java.util.*" %>
<%@ page import="bookstore.vision0.BookDetails" %>
<html>
<head>
    <title>title book discription</title>
</head>
<body>
<%@ include file="book_banner.jsp"%>
<br>
<%
String bookId = request.getParameter("bookId");
if(bookId == null){
    bookId = "201";
}
    BookDetails book = bookDB.getBookDetails(bookId);
%>
<% if(book == null){%>
<p>书号：<%=bookId%>在数据库中不存在</p>
<strong><a href="<%=request.getContextPath()%>/book_catalog.jsp">继续购物</a></strong>
<%return;}%>
<p>书名：<%=book.getTitle()%></p>
<p>作者：<%=book.getName()%>&nbsp;;&nbsp;<%=book.getYear()%>></p>
<p>价格：<%=book.getPrice()%></p>
<p>销售数量：<%=book.getSaleAmount()%></p>
<p>评论：<%=book.getDescription()%></p>
<p><a href="<%=request.getContextPath()%>/book_catalog.jsp?Add=<%=bookId%>">加入购物车</a></p>
<p><a href="<%=request.getContextPath()%>/book_catalog.jsp">继续购物</a></p>

</body>
</html>