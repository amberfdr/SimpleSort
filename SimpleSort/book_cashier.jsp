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
<p>��һ��������<%=cart.getNumberOfItems()%>����</p>
<p>��Ӧ֧���Ľ����<%=cart.getTotal()%>Ԫ</p>
<form action="<%=request.getContextPath()%>/book_receipt.jsp" method="post">
    <table>
        <tr>
            <td>���ÿ��û�����</td>
            <td><input type="text" name="cardname" value="guest"></td>
        </tr>
        <tr>
            <td>���ÿ��˺ţ�</td>
            <td><input type="text" name="cardnum" value="xxxx xxxx xxxxx xxxx"></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit"  value="�ύ"></td>
        </tr>
    </table>
</form>
</body>
</html>