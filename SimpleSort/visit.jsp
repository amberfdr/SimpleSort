<%@ page contentType="text/html; charset=GB2312" %>
<%@ page import="java.io.*" %>
<html>
    <head><title>visit.jsp</title></head>
    <body>
        <%!
            File tempDir = null;
            public void jspInit(){
                // 因为jsp声明，编译成的java代码都是实例变量或实例方法，application变量是在jsp的_jspService()服务方法中定义的，其它方法不能访问
                // tempDir = (File)application.getAttribute("javax.servlet.context.tempdir");
                tempDir = (File)getServletConfig().getServletContext().getAttribute("javax.servlet.context.tempdir");
            }
        %>
        工作目录为：<%=tempDir.getPath()%>
    </body>
</html>