<%@ page contentType="text/html; charset=GB2312" %>
<%
    // ��ҳ��������
    // ÿҳ��ʾ�ļ�¼��
    final int e = 3;
    // ҳ������
    int totalPage = 0;
    // ��ǰҳ����
    int currentPage = 1;
    // ���ݿ������ݵ��ܼ�¼��
    int totalCount = 0;
    // ��ǰҳ������ʾ�ĵ�һ����¼������
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
    // ��ǰҳ���һ����¼������
    p = (currentPage-1)*e;
    String sql = "select ID,NAME,TITLE,PRICE from BOOKS order by id limit "+p+","+e;
    rs = stmt.executeQuery(sql);


%>
<%--��ʾҳ���ǩ--%>
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
&nbsp;��<%=totalPage%>ҳ����<%=totalCount%>����¼
<table border="1" width="400">
    <tr>
        <td bgcolor="aqua"><b>����</b></td>
        <td bgcolor="#ffebcd"><b>����</b></td>
        <td bgcolor="#7fffd4"><b>����</b></td>
        <td bgcolor="#d2691e"><b>�۸�</b></td>
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

