package bookstore.vision0;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

/**
 * Describe:
 *
 * @Author fuderong
 * @Date 2019/11/29
 * @Version 1.0
 */
public class BookDB {
    private String dbUrl = "jdbc:mysql://localhost:3306/BookDB";
    private String dbUser = "dbuser";
    private String dbPwd = "1234";

    public BookDB() throws ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
    }

    public Connection getConnection() throws SQLException {
        return java.sql.DriverManager.getConnection(dbUrl,dbUser,dbPwd);
    }

    public void closeConnection(Connection conn){
        try {
            if(conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void closePrepStmt(PreparedStatement prepStmt){
        try {
            if(prepStmt != null){
                prepStmt.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void closeResultSet(ResultSet rs){
        try {
            if(rs != null){
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取书的种类
     * @return
     * @throws SQLException
     */
    public int getNumbersOfBooks() throws SQLException {
        Connection con = null;
        PreparedStatement prepStmt = null;
        ResultSet rs = null;
        int count = 0;
        try{
            con = getConnection();
            String selectStatement = "select count(*) from BOOKS";
            prepStmt =  con.prepareStatement(selectStatement);
            rs = prepStmt.executeQuery();
            if(rs.next()){
                count = rs.getInt(1);
            }
        }finally {
            closeResultSet(rs);
            closePrepStmt(prepStmt);
            closeConnection(con);
        }
        return count;
    }

    public Collection getBooks() throws SQLException {
        Connection con = null;
        PreparedStatement prepStmt = null;
        ResultSet rs = null;
        ArrayList books = new ArrayList();

        try {
            con = getConnection();
            String selectStatement = "select * from BOOKS";
            prepStmt = con.prepareStatement(selectStatement);
            rs = prepStmt.executeQuery();
            while(rs.next()){
                BookDetails bd = new BookDetails(rs.getString(1),rs.getString(2),rs.getString(3),
                        rs.getFloat(4),rs.getInt(5),rs.getString(6),rs.getInt(7));
                books.add(bd);
            }
        }finally {
            closeResultSet(rs);
            closePrepStmt(prepStmt);
            closeConnection(con);
        }
        // TODO 这个方法作用？
        Collections.sort(books);
        return books;
    }

    /**
     * 根据id查到一本书的详情
     * @param bookId
     * @return
     * @throws SQLException
     */
    public BookDetails getBookDetails(String bookId) throws SQLException {
        Connection con = null;
        PreparedStatement prepStmt = null;
        ResultSet rs = null;
        try{
            con = getConnection();
            String selectStatement = "select * from BOOKS where ID = ?";
            prepStmt = con.prepareStatement(selectStatement);
            prepStmt.setString(1,bookId);
            rs = prepStmt.executeQuery();
            if(rs.next()){
                BookDetails bd = new BookDetails(rs.getString(1),rs.getString(2),rs.getString(3),
                        rs.getFloat(4),rs.getInt(5),rs.getString(6),rs.getInt(7));
                return bd;
            }else{
                return null;
            }
        }finally {
            closeResultSet(rs);
            closePrepStmt(prepStmt);
            closeConnection(con);
        }
    }

    /**
     * 购物车购买
     * 批量更新数据库
     * 事物处理：如果发生异常
     *          rollback()撤销事务
     * @param cart
     * @throws Exception
     */
    public void buyBooks(ShoppingCart cart) throws Exception {
        Connection con = null;
        Collection items = cart.getItems();
        Iterator i = items.iterator();
        try{
            con = getConnection();
            con.setAutoCommit(false);
            while (i.hasNext()){
                ShoppingCartItem sci = (ShoppingCartItem) i.next();
                BookDetails bd = (BookDetails) sci.getItem();
                String id = bd.getBookId();
                int quantity = sci.getQuantity();
                buyBook(id,quantity,con);
            }
            con.commit();
            con.setAutoCommit(true);
        }catch (Exception ex){
            // TODO 销毁？
            con.rollback();
            throw ex;
        }finally {
            closeConnection(con);
        }

    }

    /**
     * 单本书购买数量更新操作
     * @param bookId
     * @param quantity
     * @param con
     * @throws SQLException
     */
    public void buyBook(String bookId,int quantity,Connection con) throws SQLException {
        PreparedStatement prepStmt = null;
        ResultSet rs = null;
        con = getConnection();
        try{
            String selectStatement = "select * from BOOKS where id = ?";
            prepStmt = con.prepareStatement(selectStatement);
            prepStmt.setString(1,bookId);
            rs = prepStmt.executeQuery();
            if(rs.next()){
                prepStmt.close();
                String updateStatement = "update BOOKS set sale_amount = sale_amount + ?  where ID = ?";
                prepStmt = con.prepareStatement(updateStatement);
                prepStmt.setInt(1,quantity);
                prepStmt.setString(2,bookId);
                prepStmt.executeUpdate();
                prepStmt.close();
            }
        }finally {
            closeResultSet(rs);
            closePrepStmt(prepStmt);
        }
    }
}
