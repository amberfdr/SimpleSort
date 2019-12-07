<%@ page import="bookstore.javabean.CounterBean" %>
<html>
<head>
    <title>pageCounter1.jsp</title>
</head>
<body>
<jsp:useBean id="myRequestBean" scope="request" class="bookstore.javabean.CounterBean"/>
<jsp:setProperty name="myRequestBean" property="count" value="<%=myRequestBean.getCount()+1%>"/>
current count value is :<jsp:getProperty name="myRequestBean" property="count"/>
<%
    String[] scopeNames = {"no scope","page","request","session","application"};
    int scope = pageContext.getAttributesScope("myRequestBean");
%>
<p>scope=<%=scopeNames[scope]%></p>
<jsp:forward page="requestCounter2.jsp"></jsp:forward>
</body>
</html>