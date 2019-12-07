<%@ page import="java.io.*" %>
<%@ page import="java.util.*" %>
<%@ page import="java.sql.*" %>
<%@ page import="javax.sql.*" %>
<%@ page import="javax.naming.*" %>
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

                // ͨ������Դ�ķ�ʽ�������
                // �������Դ����
                Context ctx = new InitialContext();
                // ������ݿ�����
                DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/BookDB");
                con = ds.getConnection();

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
        %>
        <%@ include file="book_page.jsp"%>
        <%
                stmt.close();
                con.close();
            }catch (Exception ex){
                ex.printStackTrace();
                    out.println(ex.getMessage());
            }
        %>
    </body>
</html>