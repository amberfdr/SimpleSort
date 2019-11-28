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
            System.out.println("jspInit():jsp被初始化了"+initVar+"次");
        }
        public void jspDestroy(){
            destroyVar++;
            System.out.println("jspDestroy():jsp被销毁了"+destroyVar+"次");
        }
    %>
    <%
        servletVar++;
        System.out.println("_jspService():jsp共响应了"+servletVar+"次请求");
        String content1 = "初始化次数："+initVar;
        String content2 = "响应客户请求次数："+servletVar;
        String content3 = "销毁次数："+destroyVar;
    %>
    <h1><%=content1%></h1>
    <h1><%=content2%></h1>
    <h1><%=content3%></h1>
</body>
</html>