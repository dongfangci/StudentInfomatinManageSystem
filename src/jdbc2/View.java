package jdbc2;

import java.util.Scanner;

public class View {
	SimpleConnectTest3 sct;;
	public static void menuShow(){
		System.out.println("欢迎使用管理系统");
		System.out.println("字母【a】:返回主菜单");
		System.out.println("字母【b】:查看所有信息");
		System.out.println("字母【c】:查看详细信息");
		System.out.println("字母【d】:添加人员信息");
		System.out.println("字母【e】:删除人员信息");
		System.out.println("字母【f】:更新人员信息");
		System.out.println("字母【g】:查询人员基本信息");
		System.out.println("字母【h】:退出");
		System.out.print("字母【exit】:返回主菜单\n\r");
		//System.out.println();
	}

	
	public static void main(String[] args) {
		View v = new View();
		v.sct = new SimpleConnectTest3();
		menuShow();
		String s = null;
		int s1 ;
		int s2 ;
		String name;
		String age;
		String sex;
		
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
		s = sc.nextLine();
		if(s.equals("b") ){
			System.out.print("以下为人员基本信息：");
			System.out.println();
			v.sct.queryAll();
		}
		else if(s.equals("c")){
			System.out.println("请输入姓名查看详细信息：");
			s = sc.nextLine();
			v.sct.queryInfo(s);
		}
		else if(s.equals("d")){
			System.out.println("添加人员");
			System.out.println("请输入学号：");
			s1 = sc.nextInt();
			sc.nextLine();
			System.out.println("请输入姓名：");
			s = sc.nextLine();
			System.out.println("请输入年龄：");
			s2 = sc.nextInt();
			sc.nextLine();
			DBinfo person = new DBinfo(s1,s,s2);
			v.sct.insert(person);
		}
		
		else if(s.equals("e")){
			System.out.println("删除人员信息");
			System.out.println("请输入姓名：");
			s = sc.nextLine();
			v.sct.delete(s);
		}
		else if(s.equals("f")){
			System.out.println("更新人员信息");
			System.out.println("请输入姓名：");
			name = sc.nextLine();
			System.out.println("请输入年龄：");
			age = sc.nextLine();
			System.out.println("请输入性别：");
			sex = sc.nextLine();
			v.sct.update(name, age, sex);
		}
		else{
			System.out.println("输入错误，请重新输入");
		}
			
		}
	}

}
