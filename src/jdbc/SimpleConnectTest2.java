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

package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SimpleConnectTest2 {
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
 	public void insert(){
		getConnection();
		String sql = "insert student values(default,'Bill',30)";
		try {
			pt = conn.prepareStatement(sql);
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
	public void delete(){
		getConnection();
		String sql = "delete from student where name = 'Bill'";
		try {
			pt = conn.prepareStatement(sql);
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
	public void update(){
		getConnection();
		String sql = "update student set age=10 where name = 'Bill'";
		try {
			pt = conn.prepareStatement(sql);
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
				System.out.print(rs.getInt("sid") + " " +  rs.getString("name"));
				System.out.println(" ");
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeConnection();
		}
		
	}
	
		
	public static void main(String[] args) {
		SimpleConnectTest2 s = new SimpleConnectTest2();
		s.insert();
		s.delete();
		s.update();
		s.queryAll();
	}

}