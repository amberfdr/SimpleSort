<%@ page import="bookstore.javabean.CounterBean" %>
<html>
<head>
    <title>pageCounter1.jsp</title>
</head>
<body>
<jsp:useBean id="myApplicationBean" scope="application" class="bookstore.javabean.CounterBean"/>
<jsp:setProperty name="myApplicationBean" property="count" value="<%=myApplicationBean.getCount()+1%>"/>
current count value is :<jsp:getProperty name="myApplicationBean" property="count"/>
<%
    String[] scopeNames = {"no scope","page","request","session","application"};
    int scope = pageContext.getAttributesScope("myApplicationBean");
%>
<p>scope=<%=scopeNames[scope]%></p>
</body>
</html>