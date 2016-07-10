/*
 * SQL语句固定的增删改查操作：利用Connection的方法
 * Statement createStatement()
                          throws SQLException
 * 创建一个 Statement 对象来将 SQL 语句发送到数据库。
 * 不带参数的 SQL 语句通常使用 Statement 对象执行。
 * 如果多次执行相同的 SQL 语句，使用 PreparedStatement 对象可能更有效。
 * */
package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SimpleConnectTest {
	private  Connection conn;
	private  Statement st;	//使用Statement接口来执行SQL语句
	private  ResultSet rs;
	
	public void getConnection(){

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test_db","root","3563551");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public void closeConnection(){
		
		try {
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
 	public void insert(){
		getConnection();
		String sql = "insert student values(default,'Bill',30)";
		try {
			st = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			int count = st.executeUpdate(sql);
			System.out.println("插入了" + count + "条记录");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeConnection();
		}
		
	}
	public void delete(){
		getConnection();
		String sql = "delete from student where name = 'Bill'";
		try {
			st = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			int count = st.executeUpdate(sql);
			System.out.println("删除了" + count + "条记录");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeConnection();
		}
		
	}
	public void update(){
		getConnection();
		String sql = "update student set age=10 where name = 'Ben'";
		try {
			st = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			int count = st.executeUpdate(sql);
			System.out.println("更新了" + count + "条记录");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeConnection();
		}
		closeConnection();
	}
	public void queryAll(){
		getConnection();
		String sql = "select * from student";
		try {
			st = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			 rs = st.executeQuery(sql);
			while(rs.next()){
				System.out.println(rs.getString("name"));
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			closeConnection();
		}
		
	}
	
		
	public static void main(String[] args) {
		SimpleConnectTest s = new SimpleConnectTest();
		s.insert();
		s.delete();
		s.update();
		s.queryAll();
	}

}
