<%@ page import="bookstore.javabean.CounterBean" %>
<html>
<head>
    <title>pageCounter1.jsp</title>
</head>
<body>
<jsp:useBean id="myPageBean" scope="page" class="bookstore.javabean.CounterBean"/>
<jsp:setProperty name="myPageBean" property="count" value="<%=myPageBean.getCount()+1%>"/>
current count value is :<jsp:getProperty name="myPageBean" property="count"/>
<%
    String[] scopeNames = {"no scope","page","request","session","application"};
    int scope = pageContext.getAttributesScope("myPageBean");
%>
<p>scope=<%=scopeNames[scope]%></p>
<jsp:forward page="pageCounter2.jsp"></jsp:forward>
</body>
</html>