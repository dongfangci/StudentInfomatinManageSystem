package jdbc4;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentAction {
	
	public void add(){}
	public void del(){}
	public void update(){}
	public List<Student> queryAll() throws SQLException{
		StudentDao stud = new StudentDao();
		return stud.queryAll();
	}
	public List<Student> queryByName(String name) throws SQLException {
		StudentDao stud = new StudentDao();
		return stud.queryByName(name);
	}
	public int count() throws SQLException{
		StudentDao stud = new StudentDao();
		return stud.count();
	}
	
	public static void main(String[] args) throws SQLException {
		List<Student> list = new ArrayList<Student>();
		StudentAction stua = new StudentAction();
//		list = stua.queryAll();
//		for(Student stu : list){
//			System.out.println(stu.toString());
//		}
		
		System.out.println("当前学生数量为：" + stua.count());
		
		list = stua.queryByName("j");
		for(Student stu : list){
			System.out.println(stu.toString());
		}
	}
	

}
