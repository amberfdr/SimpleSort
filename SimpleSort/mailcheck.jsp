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
<a href="<%=response.encodeURL("maillogin.jsp")%>">��½</a>
<a href="<%=response.encodeURL("maillogout.jsp")%>">ע��</a>
<p>�û�����<%=name%></p>
<p>�����������100���ʼ�</p>
<%
    Integer counter = (Integer)application.getAttribute("counterSession");
    if(counter != null){
%>
    ��ǰ��������Ϊ��<%=counter%><br>
<%}%>
</body>
</html>