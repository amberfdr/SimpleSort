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
                // 加载驱动
                Class.forName("com.mysql.jdbc.Driver");
                // 注册驱动 其实mysql没必要，因为。。。
                DriverManager.registerDriver(new Driver());
                // 用适当的驱动器连接数据库
                String dbUrl = "jdbc:mysql://localhost:3306/BookDB?useUnicode=true&characterEncoding=GB2312";
                String dbUser = "dbuser";
                String dbPwd = "1234";
                con = DriverManager.getConnection(dbUrl, dbUser, dbPwd);
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
                stmt.close();
                con.close();
            }catch (Exception e){
                out.println(e.getMessage());
            }
        %>
    </body>
</html>