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
<p>你一共购买了<%=cart.getNumberOfItems()%>本书</p>
<p>你应支付的金额是<%=cart.getTotal()%>元</p>
<form action="<%=request.getContextPath()%>/book_receipt.jsp" method="post">
    <table>
        <tr>
            <td>信用卡用户名：</td>
            <td><input type="text" name="cardname" value="guest"></td>
        </tr>
        <tr>
            <td>信用卡账号：</td>
            <td><input type="text" name="cardnum" value="xxxx xxxx xxxxx xxxx"></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit"  value="提交"></td>
        </tr>
    </table>
</form>
</body>
</html>