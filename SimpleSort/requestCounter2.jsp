<%@ page import="bookstore.javabean.CounterBean" %>
<html>
<head>
    <title>pageCounter2.jsp</title>
</head>
<body>
<jsp:useBean id="myRequestBean" scope="page" class="bookstore.javabean.CounterBean"/>
current count value is :<jsp:getProperty name="myRequestBean" property="count"/>
</body>
</html>