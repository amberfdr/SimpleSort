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
<p><%=name%>���ټ���</p>
<a href="<%=response.encodeURL("maillogin.jsp")%>">���µ�½�ʼ�ϵͳ</a>
</body>
</html>