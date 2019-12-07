<%@ page import="bookstore.session0.User" %>
<%@ page import="bookstore.session0.OnlineUsers" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html; charset=GB2312" %>
<%@ page session="true" %>
<html>
<head>
    <title>mailcheck.jsp</title>
</head>
<body bgcolor="#FFFFFF">
<%
    String name = null;
    User user = null;
    name = request.getParameter("username");
    if(name != null){
        session.setAttribute("user",new User(name));
    }else{
        user = (User)session.getAttribute("user");
        if(user == null){
            response.sendRedirect(response.encodeRedirectURL("maillogin1.jsp"));
        }
    }
%>
<a href="<%=response.encodeURL("maillogin1.jsp")%>">登陆</a>
<a href="<%=response.encodeURL("maillogout1.jsp")%>">注销</a>
<p>用户名：<%=name%></p>
<p>你的信箱中有100封邮件</p>
<%
    OnlineUsers onlineUsers = OnlineUsers.getInstance();
    List<String> users = onlineUsers.getUser();
%>
    当前在线人数为：<%=onlineUsers.getCount()%><br>
<%for(String username : users){%>
        <%=username%>&nbsp;&nbsp;
<%  }%>
</body>
</html>