<%@ page contentType="text/html; charset=GB2312" %>
<%@ page import="bookstore.vision0.ShoppingCart" %>
<%@ include file="book_common.jsp"%>
<jsp:useBean id="cart" scope="session" class="bookstore.vision0.ShoppingCart"/>


<html>
<head>
    <title></title>
</head>
<body>
<%@ include file="book_banner.jsp"%>
<%
        bookDB.buyBooks(cart);
        session.invalidate();
%>
</body>
</html>