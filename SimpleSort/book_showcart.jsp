<%@ page contentType="text/html; charset=GB2312" %>
<%@ page import="bookstore.vision0.ShoppingCart" %>
<%@ page import="bookstore.vision0.BookDetails" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="bookstore.vision0.ShoppingCartItem" %>
<%@ include file="book_common.jsp"%>
<jsp:useBean id="cart" scope="session" class="bookstore.vision0.ShoppingCart"/>

<html>
<head>
    <title></title>
</head>
<body>
<%@ include file="book_banner.jsp"%>

<%
    String booId = request.getParameter("Remove");
    if(booId != null){
        cart.remove(booId);
        BookDetails book = bookDB.getBookDetails(booId);
%>
        <font color="red" size="+2">你删除了一本书:<%=book.getTitle()%></font><br>
<%
    }
    if(request.getParameter("Clear") != null){
        cart.clear();
%>
        <font color="red" size="+2">清空购物车</font><br>
<%
    }
    int num = cart.getNumberOfItems();
    if(num > 0){
%>
        <font>你的购物车内有：<%=num%>本书</font>&nbsp;
        <table>
            <tr>
                <td align="left">数量</td>
                <td align="left">书名</td>
                <td align="left">价格</td>
            </tr>
            <%
                Iterator i = cart.getItems().iterator();
                while (i.hasNext()){
                    ShoppingCartItem cartItem = (ShoppingCartItem) i.next();
                    BookDetails book = (BookDetails)cartItem.getItem();
            %>
            <tr>
                <td align="right" bgcolor="#d2691e"><%=cartItem.getQuantity()%></td>
                <td align="right" bgcolor="#ffebcd"><a href="<%=request.getContextPath()%>/book_bookdetails.jsp?bookId=<%=book.getBookId()%>">查看详情</a></td>
                <td align="right" bgcolor="#7fffd4"><%=book.getPrice()%></td>
                <td align="right" bgcolor="#d2691e"><a href="<%=request.getContextPath()%>/book_showcart.jsp?Remove=<%=book.getBookId()%>">删除</a></td>
            </tr>
            <%}%>
            <tr><td colspan="5" bgcolor="#ffffff"></td></tr>
            <tr>
                <td colspan="2">总额（元）</td>
                <td><%=cart.getTotal()%></td>
                <td><br></td>
            </tr>
        </table>
        <p><br></p>
        <a href="<%=request.getContextPath()%>/book_catalog.jsp">继续购物</a>
        <a href="<%=request.getContextPath()%>/book_cashier.jsp">付帐</a>
        <a href="<%=request.getContextPath()%>/book_showcart.jsp?Clear=clear">清空购物车</a>
<%}else{%>
        <font>你目前的购物车是空的</font><br>
        <a href="<%=request.getContextPath()%>/book_catalog.jsp">继续购物</a>
<%}%>
</body>
</html>