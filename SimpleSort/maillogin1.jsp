<%@ page import="bookstore.session0.User" %>
<%@ page contentType="text/html; charset=GB2312" %>
<html>
<head>
    <title>maillogin.jsp</title>
</head>
<body bgcolor="#FFFFFF" onload="document.loginForm.username.focus()">
<%
    String name = "";
    User user = null;
    if(!session.isNew()){
        user = (User)session.getAttribute("user");
        if(user == null){
            name = "";
        }else{
            name = user.getName();
        }
    }
%>
<p>欢迎光临本系统：</p>
<p>Session ID:<%=session.getId()%></p>
    <table>
        <tr>
            <td>
                <table>
                    <form name="loginForm" action="<%=response.encodeURL("mailcheck1.jsp")%>" method="post">
                        <tr>
                            <td>User name:&nbsp;</td>
                            <td><input name="username" value="<%=name%>"/></td>
                        </tr>
                        <tr>
                            <td>Password:&nbsp;</td>
                            <td><input name="password" type="password"/></td>
                        </tr>
                        <tr>
                            <td>&nbsp;</td>
                            <td><input name="submit" type="submit" value="提交"/></td>
                        </tr>
                    </form>
                </table>
            </td>
        </tr>
    </table>
</body>
</html>