<%@ page import="java.io.*" %>
<%@ page import="java.util.*" %>
<%@ page import="java.sql.*" %>
<%@ page import="com.mysql.jdbc.Driver" %>
<%@ page contentType="text/html; charset=GB2312" %>

<html>
    <head>
        <title>dbaccess.jsp</title>
    </head>
    <body>
        <%
            try{
                Connection con = null;
                Statement stmt = null;
                ResultSet rs = null;
                // ��������
                Class.forName("com.mysql.jdbc.Driver");
                // ע������ ��ʵmysqlû��Ҫ����Ϊ������
                DriverManager.registerDriver(new Driver());
                // ���ʵ����������������ݿ�
                String dbUrl = "jdbc:mysql://localhost:3306/BookDB?useUnicode=true&characterEncoding=GB2312";
                String dbUser = "dbuser";
                String dbPwd = "1234";
                con = DriverManager.getConnection(dbUrl, dbUser, dbPwd);
                stmt = con.createStatement();
        %>
        <%@ include file="./book_page.jsp"%>
        <%
                stmt.close();
                con.close();
            }catch (Exception ex){
                out.println(ex.getMessage());
            }
        %>
    </body>
</html>