/*
 *  SQL���̶���������ɾ�Ĳ����������Connection�ķ���
 * prepareStatement
PreparedStatement prepareStatement(String sql)
                               throws SQLException
����һ�� PreparedStatement ���������������� SQL ��䷢
�͵����ݿ⡣ ���� IN �����򲻴��� IN ������ SQL ��䶼��
�Ա�Ԥ���벢�洢��PreparedStatement �����С�Ȼ�������
Ч��ʹ�ô˶��������ִ�и���䡣 

ע��Ϊ�˴���������Ԥ����Ĵ����� SQL ��䣬�˷����������Ż���
�����������֧��Ԥ���룬�� prepareStatement ����������䷢
�͸����ݿ����Ԥ���롣һЩ����������ܲ�֧��Ԥ���롣����������£�
ִ�� PreparedStatement ����֮ǰ�޷�����䷢�͸����ݿ⡣
����û�û��ֱ��Ӱ�죻������ȷ��Ӱ����Щ�������׳�ĳЩ SQLException ����

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
	private  PreparedStatement pt;		//ʹ��PreparedStatement�ӿ���ִ��SQL���
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
			System.out.println("������" + count + "����¼");
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
			System.out.println("ɾ����" + count + "����¼");
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
			System.out.println("û�и�����Ŀ");
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
			System.out.println("������" + count + "����¼");
			
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
				System.out.println("���޴���");
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