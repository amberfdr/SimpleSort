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
<a href="<%=response.encodeURL("maillogin1.jsp")%>">��½</a>
<a href="<%=response.encodeURL("maillogout1.jsp")%>">ע��</a>
<p>�û�����<%=name%></p>
<p>�����������100���ʼ�</p>
<%
    OnlineUsers onlineUsers = OnlineUsers.getInstance();
    List<String> users = onlineUsers.getUser();
%>
    ��ǰ��������Ϊ��<%=onlineUsers.getCount()%><br>
<%for(String username : users){%>
        <%=username%>&nbsp;&nbsp;
<%  }%>
</body>
</html>