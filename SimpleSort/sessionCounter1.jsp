<%@ page import="bookstore.javabean.CounterBean" %>
<html>
<head>
    <title>pageCounter1.jsp</title>
</head>
<body>
<jsp:useBean id="mySessionBean" scope="session" class="bookstore.javabean.CounterBean"/>
<jsp:setProperty name="mySessionBean" property="count" value="<%=mySessionBean.getCount()+1%>"/>
current count value is :<jsp:getProperty name="mySessionBean" property="count"/>
<%
    String[] scopeNames = {"no scope","page","request","session","application"};
    int scope = pageContext.getAttributesScope("mySessionBean");
%>
<p>scope=<%=scopeNames[scope]%></p>
</body>
</html>