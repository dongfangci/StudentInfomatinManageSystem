/*
 *  SQL语句固定参数的增删改查操作：利用Connection的方法
 * prepareStatement
PreparedStatement prepareStatement(String sql)
                               throws SQLException
创建一个 PreparedStatement 对象来将参数化的 SQL 语句发
送到数据库。 带有 IN 参数或不带有 IN 参数的 SQL 语句都可
以被预编译并存储在PreparedStatement 对象中。然后可以有
效地使用此对象来多次执行该语句。 

注：为了处理受益于预编译的带参数 SQL 语句，此方法进行了优化。
如果驱动程序支持预编译，则 prepareStatement 方法将该语句发
送给数据库进行预编译。一些驱动程序可能不支持预编译。在这种情况下，
执行 PreparedStatement 对象之前无法将语句发送给数据库。
这对用户没有直接影响；但它的确会影响哪些方法将抛出某些 SQLException 对象。

 * 
 * */

package jdbc3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SimpleConnectTest3 {
	private  Connection conn;
	private  PreparedStatement pt;		//使用PreparedStatement接口来执行SQL语句
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
			pt.close();
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
 	public void insert(DBinfo p){
		getConnection();
		String sql = "insert student set sid = ?,name = ?, age = ?";
		try {
			pt = conn.prepareStatement(sql);
			pt.setInt(1, p.getSid());
			pt.setString(2, p.getName());
			pt.setInt(3, p.getAge());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			int count = pt.executeUpdate();
			System.out.println("插入了" + count + "条记录");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeConnection();
		}
		
	}
	public void delete(String name){
		getConnection();
		String sql = "delete from student where name = ?";
		try {
			pt = conn.prepareStatement(sql);
			pt.setString(1, name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			int count = pt.executeUpdate();
			System.out.println("删除了" + count + "条记录");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeConnection();
		}
		
	}
	public void update(String name,String age,String sex){
		getConnection();
		String sql;
		if(age.equals("null")&& sex.equals("null")){
			System.out.println("没有更新项目");
			return;
		}
		else if(age.equals("null")){
			int sexSql = Integer.parseInt(sex);
			 sql = "update student set sex=? where name = ?"
			 		+ "";
			 try {
				pt = conn.prepareStatement(sql);
				pt.setInt(1, sexSql);
				pt.setString(2, name);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
		}
		//else if(sex == null){
			else if(sex.equals("null")){

			int ageSql = Integer.parseInt(age);
			 sql = "update student set age=? where name = ?";
			 try {
				pt = conn.prepareStatement(sql);
				pt.setInt(1, ageSql);
				pt.setString(2, name);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else{
			int sexSql = Integer.parseInt(sex);
			int ageSql = Integer.parseInt(age);
		sql = "update student set age=?,sex=? where name = ?";
		try {
			pt = conn.prepareStatement(sql);
			pt.setInt(1, ageSql);
			pt.setInt(2, sexSql);
			pt.setString(3, name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}

		try {
			int count = pt.executeUpdate();
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
			pt = conn.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			rs = pt.executeQuery();
			while(rs.next()){
				System.out.print(rs.getInt("sid") + " " +  rs.getString("name") );
				System.out.println(" ");
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeConnection();
		}
		
	}
	
	public void queryInfo(String s){
		getConnection();
		String sql = "select * from student where name = ?";
		try {
			pt = conn.prepareStatement(sql);
			pt.setString(1, s);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			rs = pt.executeQuery();
			if(rs != null)
			while(rs.next()){
				System.out.println(rs.getInt("sid") );
				System.out.println(rs.getString("name"));
				System.out.println(rs.getInt("age"));
				System.out.println(" ");
			}
			else{
				System.out.println("查无此人");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeConnection();
		}
		
	}	
	public static void main(String[] args) {
		SimpleConnectTest3 s = new SimpleConnectTest3();
		DBinfo person = new DBinfo(111111789,"John",14);
		s.insert(person);
		//s.queryAll();
		//s.delete("New");
		//s.update("Newton", "23", "12");
	}

}