<%@ page contentType="text/html; charset=GB2312" %>
<%@ page import="java.io.*" %>
<html>
    <head><title>visit.jsp</title></head>
    <body>
        <%!
            File tempDir = null;
            public void jspInit(){
                // ��Ϊjsp����������ɵ�java���붼��ʵ��������ʵ��������application��������jsp��_jspService()���񷽷��ж���ģ������������ܷ���
                // tempDir = (File)application.getAttribute("javax.servlet.context.tempdir");
                tempDir = (File)getServletConfig().getServletContext().getAttribute("javax.servlet.context.tempdir");
            }
        %>
        ����Ŀ¼Ϊ��<%=tempDir.getPath()%>
    </body>
</html>