<%@ page contentType="text/html; charset=GB2312" %>
<%
    // 分页变量定义
    // 每页显示的记录数
    final int e = 3;
    // 页面总数
    int totalPage = 0;
    // 当前页面编号
    int currentPage = 1;
    // 数据库中数据的总记录数
    int totalCount = 0;
    // 当前页面所显示的第一条记录的索引
    int p = 0;

    String tempStr = request.getParameter("currentPage");
    if(tempStr != null || tempStr.equals("")){
        currentPage = Integer.parseInt(tempStr);
    }

    rs = stmt.executeQuery("select count(*) from BOOKS");
    if(rs.next()){
        totalCount = rs.getInt(1);
    }
    totalPage = totalCount % e == 0 ? totalCount / e : totalCount / e +1;
    if(totalPage == 0){
        totalPage = 1;
    }
    if(currentPage > totalPage){
        currentPage = totalPage;
    }else if(currentPage < 1){
        currentPage = 1;
    }
    // 当前页面第一条记录的索引
    p = (currentPage-1)*e;
    String sql = "select ID,NAME,TITLE,PRICE from BOOKS order by id limit "+p+","+e;
    rs = stmt.executeQuery(sql);


%>
<%--显示页面标签--%>
<%
    for(int i = 1;i < totalPage;i++){
        if(i == currentPage){
%>
            <%=i%>
<%        }else{%>
            <a href="./dbaccess2.jsp?currentPage=<%=i%>"><%=i%></a>
<%        }
    }
%>
&nbsp;共<%=totalPage%>页，共<%=totalCount%>条记录
<table border="1" width="400">
    <tr>
        <td bgcolor="aqua"><b>书编号</b></td>
        <td bgcolor="#ffebcd"><b>作者</b></td>
        <td bgcolor="#7fffd4"><b>书名</b></td>
        <td bgcolor="#d2691e"><b>价格</b></td>
    </tr>
    <%
        while(rs.next()){
            String id = rs.getString(1);
            String name = rs.getString(2);
            String title = rs.getString(3);
            float price = rs.getFloat(4);

    %>
    <tr>
        <td><%=id%></td>
        <td><%=name%></td>
        <td><%=title%></td>
        <td><%=price%></td>
    </tr>
    <%
        }
    %>
</table>

