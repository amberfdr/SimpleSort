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

                // 通过数据源的方式获得连接
                // 获得数据源引用
                Context ctx = new InitialContext();
                // 获得数据库连接
                DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/BookDB");
                con = ds.getConnection();

                stmt = con.createStatement();
                // 增加记录
                stmt.executeUpdate("insert into BOOKS(ID,NAME,TITLE,PRICE)values('999','Tom','tomcat bible',44.5)");
                // 查询记录
                rs = stmt.executeQuery("select ID,NAME,TITLE,PRICE from BOOKS");
                // 输出查询结果
                out.println("<table border=1 width=400>");
                while(rs.next()){
                    out.println("<tr><td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getFloat(4)+"</td></tr>");
                }
                out.println("</table>");
                // 删除新增的记录
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