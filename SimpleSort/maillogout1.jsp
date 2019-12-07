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
<p><%=name%>，再见！</p>
<a href="<%=response.encodeURL("maillogin1.jsp")%>">重新登陆邮件系统</a>
</body>
</html>