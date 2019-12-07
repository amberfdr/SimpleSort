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
        <font color="red" size="+2">��ɾ����һ����:<%=book.getTitle()%></font><br>
<%
    }
    if(request.getParameter("Clear") != null){
        cart.clear();
%>
        <font color="red" size="+2">��չ��ﳵ</font><br>
<%
    }
    int num = cart.getNumberOfItems();
    if(num > 0){
%>
        <font>��Ĺ��ﳵ���У�<%=num%>����</font>&nbsp;
        <table>
            <tr>
                <td align="left">����</td>
                <td align="left">����</td>
                <td align="left">�۸�</td>
            </tr>
            <%
                Iterator i = cart.getItems().iterator();
                while (i.hasNext()){
                    ShoppingCartItem cartItem = (ShoppingCartItem) i.next();
                    BookDetails book = (BookDetails)cartItem.getItem();
            %>
            <tr>
                <td align="right" bgcolor="#d2691e"><%=cartItem.getQuantity()%></td>
                <td align="right" bgcolor="#ffebcd"><a href="<%=request.getContextPath()%>/book_bookdetails.jsp?bookId=<%=book.getBookId()%>">�鿴����</a></td>
                <td align="right" bgcolor="#7fffd4"><%=book.getPrice()%></td>
                <td align="right" bgcolor="#d2691e"><a href="<%=request.getContextPath()%>/book_showcart.jsp?Remove=<%=book.getBookId()%>">ɾ��</a></td>
            </tr>
            <%}%>
            <tr><td colspan="5" bgcolor="#ffffff"></td></tr>
            <tr>
                <td colspan="2">�ܶԪ��</td>
                <td><%=cart.getTotal()%></td>
                <td><br></td>
            </tr>
        </table>
        <p><br></p>
        <a href="<%=request.getContextPath()%>/book_catalog.jsp">��������</a>
        <a href="<%=request.getContextPath()%>/book_cashier.jsp">����</a>
        <a href="<%=request.getContextPath()%>/book_showcart.jsp?Clear=clear">��չ��ﳵ</a>
<%}else{%>
        <font>��Ŀǰ�Ĺ��ﳵ�ǿյ�</font><br>
        <a href="<%=request.getContextPath()%>/book_catalog.jsp">��������</a>
<%}%>
</body>
</html>