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
<p>��ţ�<%=bookId%>�����ݿ��в�����</p>
<strong><a href="<%=request.getContextPath()%>/book_catalog.jsp">��������</a></strong>
<%return;}%>
<p>������<%=book.getTitle()%></p>
<p>���ߣ�<%=book.getName()%>&nbsp;;&nbsp;<%=book.getYear()%>></p>
<p>�۸�<%=book.getPrice()%></p>
<p>����������<%=book.getSaleAmount()%></p>
<p>���ۣ�<%=book.getDescription()%></p>
<p><a href="<%=request.getContextPath()%>/book_catalog.jsp?Add=<%=bookId%>">���빺�ﳵ</a></p>
<p><a href="<%=request.getContextPath()%>/book_catalog.jsp">��������</a></p>

</body>
</html>