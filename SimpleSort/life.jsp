<%@ page contentType="text/html;charset=GB2312" %>
<html>
    <head>
        <title>life.jsp</title>
    </head>
<body>
    <%!
        private int initVar = 0;
        private int servletVar = 0;
        private int destroyVar = 0;
    %>
    <%!
        public void jspInit(){
            initVar++;
            System.out.println("jspInit():jsp����ʼ����"+initVar+"��");
        }
        public void jspDestroy(){
            destroyVar++;
            System.out.println("jspDestroy():jsp��������"+destroyVar+"��");
        }
    %>
    <%
        servletVar++;
        System.out.println("_jspService():jsp����Ӧ��"+servletVar+"������");
        String content1 = "��ʼ��������"+initVar;
        String content2 = "��Ӧ�ͻ����������"+servletVar;
        String content3 = "���ٴ�����"+destroyVar;
    %>
    <h1><%=content1%></h1>
    <h1><%=content2%></h1>
    <h1><%=content3%></h1>
</body>
</html>