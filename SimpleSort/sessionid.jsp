<%
    Cookie[] cookies = request.getCookies();
    if(cookies == null){
        out.println("no cookies");
        return;
    }
    for(Cookie cookie : cookies){
%>
    <p>
        <b>Cookie name:</b>
        <%=cookie.getName()%>
        <b>Cookie value:</b>
        <%=cookie.getValue()%>
    </p>
<p>
    <b>Max age in seconds:</b>
    <%=cookie.getMaxAge()%>
</p>
<%
    }
%>