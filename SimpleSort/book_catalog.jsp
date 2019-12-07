<%@ page contentType="text/html; charset=GB2312" %>
<%@ page import="bookstore.vision0.ShoppingCart" %>
<%@ page import="bookstore.vision0.BookDetails" %>
<%@ include file="book_common.jsp"%>

<html>
<head>
    <title></title>
</head>
<body>
<jsp:useBean id="cart" scope="session" class="bookstore.vision0.ShoppingCart"/>
<%
        String booId = request.getParameter("Add");
        if(booId != null){
            BookDetails bookDetails = bookDB.getBookDetails(booId);
            cart.add(booId,bookDetails);
        }
%>
</body>
</html>