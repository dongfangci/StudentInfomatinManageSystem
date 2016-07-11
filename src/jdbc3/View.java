package jdbc3;

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
	public  void queryAll(){
		System.out.print("以下为人员基本信息：");
		System.out.println();
		sct.queryAll();
	}
	public void queryInfo(Scanner sc){
		System.out.println("请输入姓名查看详细信息：");
		String s = sc.nextLine();
		sct.queryInfo(s);
	}
	
	public void add(Scanner sc){
		System.out.println("添加人员");
		System.out.println("请输入学号：");
		int s1 = sc.nextInt();
		sc.nextLine();
		System.out.println("请输入姓名：");
		String s = sc.nextLine();
		System.out.println("请输入年龄：");
		int s2 = sc.nextInt();
		sc.nextLine();
		DBinfo person = new DBinfo(s1,s,s2);
		sct.insert(person);
	}
	public void delete(Scanner sc){
		System.out.println("删除人员信息");
		System.out.println("请输入姓名：");
		String s = sc.nextLine();
		sct.delete(s);
	}
	public void update(Scanner sc){
		System.out.println("更新人员信息");
		System.out.println("请输入姓名：");
		String name = sc.nextLine();
		if(name.endsWith("a")){
			menuShow();
			return;
		}
		System.out.println("请输入年龄：");
		String age = sc.nextLine();
		System.out.println("请输入性别：");
		String sex = sc.nextLine();
		sct.update(name, age, sex);
	
	}
	
	public static void main(String[] args) {
		View v = new View();
		v.sct = new SimpleConnectTest3();
		
		menuShow();		
		
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			String s = sc.nextLine();
			switch(s){ 
				case "a":
					menuShow();
					break;
				case "b":
					v.queryAll();		//注意一定要有break，否则有Bug
					break;
				case "c":
					v.queryInfo(sc);
					break;
				case "d":
					v.add(sc);
					break;
				case "e":
					v.delete(sc);
					break;
				case "f":
					v.update(sc);
					break;
				case "exit":
					System.out.println("退出查询");
					System.exit(0);
					break;
				default :
					System.out.println("输入错误，请重新输入");
					break;
			}

			
		}
	}

}
