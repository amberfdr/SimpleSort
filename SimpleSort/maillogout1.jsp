<%@ page import="bookstore.session0.User" %>
<%@ page contentType="text/html; charset=GB2312" %>
<html>
<head>
    <title>maillogout.jsp</title>
</head>
<body>
<%
   User user = (User)session.getAttribute("user");
   String name = null;
   if(user != null){
       name = user.getName();
   }
    session.invalidate();
%>
<p><%=name%>���ټ���</p>
<a href="<%=response.encodeURL("maillogin1.jsp")%>">���µ�½�ʼ�ϵͳ</a>
</body>
</html>