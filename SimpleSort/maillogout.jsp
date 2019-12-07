<%@ page contentType="text/html; charset=GB2312" %>
<html>
<head>
    <title>maillogout.jsp</title>
</head>
<body>
<%
   String name = (String)session.getAttribute("username");
    session.invalidate();
%>
<p><%=name%>，再见！</p>
<a href="<%=response.encodeURL("maillogin.jsp")%>">重新登陆邮件系统</a>
</body>
</html>