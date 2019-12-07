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
                // ���Ӽ�¼
                stmt.executeUpdate("insert into BOOKS(ID,NAME,TITLE,PRICE)values('999','Tom','tomcat bible',44.5)");
                // ��ѯ��¼
                rs = stmt.executeQuery("select ID,NAME,TITLE,PRICE from BOOKS");
                // �����ѯ���
                out.println("<table border=1 width=400>");
                while(rs.next()){
                    out.println("<tr><td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getFloat(4)+"</td></tr>");
                }
                out.println("</table>");
                // ɾ�������ļ�¼
                stmt.executeUpdate("delete from BOOKS where ID = '999'");
                rs.close();
                stmt.close();
                con.close();
            }catch (Exception e){
                out.println(e.getMessage());
            }
        %>
    </body>
</html>