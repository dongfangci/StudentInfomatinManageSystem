package jdbc4;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StudentDao {
	public void addStudent(Student stu){
		
	}
	
	public void delStudent(int sid){
		
	}
	
	public void updateStudent(Student stu){
		
	}
	
	public List<Student> queryByName(String name) throws SQLException{
		List<Student> list = new ArrayList<Student>();
		Student stu = null;
		Connection conn = DBUtil.getConnection();
		
		String sql = "select * from student where name like ?";
		PreparedStatement pt = conn.prepareStatement(sql);
		pt.setString(1, "%"+ name + "%");
		ResultSet rs = pt.executeQuery();
		
		while(rs.next()){
			stu = new Student();
			stu.setSid(rs.getInt("sid"));
			stu.setName(rs.getString("name"));
			stu.setAge(rs.getInt("age"));
			stu.setSex(rs.getInt("sex"));
			list.add(stu);	
		}
		return list;
	}
	
	public List<Student> queryAll() throws SQLException{
		List<Student> list = new ArrayList<Student>();
		Student stu = null;
		Connection conn = DBUtil.getConnection();
		Statement st = conn.createStatement();
		String sql = "select * from student";
		ResultSet rs = st.executeQuery(sql);
		
		while(rs.next()){
			stu = new Student();
			stu.setSid(rs.getInt("sid"));
			stu.setName(rs.getString("name"));
			stu.setAge(rs.getInt("age"));
			stu.setSex(rs.getInt("sex"));
			list.add(stu);	
		}
		return list;
	}
	
	public int count() throws SQLException{
		Connection conn = DBUtil.getConnection();
		Statement st = conn.createStatement();
		String sql = "select count(*) from student";
		ResultSet rs = st.executeQuery(sql);
		int count = 0;;
		while(rs.next()){
			 count = rs.getInt(1);
		}
		
		return count;
	}
}
