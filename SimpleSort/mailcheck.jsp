<%@ page contentType="text/html; charset=GB2312" %>
<%@ page session="true" %>
<html>
<head>
    <title>mailcheck.jsp</title>
</head>
<body bgcolor="#FFFFFF">
<%
    String name = null;
    name = request.getParameter("username");
    if(name != null){
        session.setAttribute("username",name);
    }else{
        name = (String)session.getAttribute("username");
        if(name == null){
            response.sendRedirect(response.encodeRedirectURL("maillogin.jsp"));
        }
    }
%>
<a href="<%=response.encodeURL("maillogin.jsp")%>">登陆</a>
<a href="<%=response.encodeURL("maillogout.jsp")%>">注销</a>
<p>用户名：<%=name%></p>
<p>你的信箱中有100封邮件</p>
<%
    Integer counter = (Integer)application.getAttribute("counterSession");
    if(counter != null){
%>
    当前在线人数为：<%=counter%><br>
<%}%>
</body>
</html>