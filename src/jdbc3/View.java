package jdbc3;

import java.util.Scanner;

public class View {
	SimpleConnectTest3 sct;;
	public static void menuShow(){
		System.out.println("��ӭʹ�ù���ϵͳ");
		System.out.println("��ĸ��a��:�������˵�");
		System.out.println("��ĸ��b��:�鿴������Ϣ");
		System.out.println("��ĸ��c��:�鿴��ϸ��Ϣ");
		System.out.println("��ĸ��d��:�����Ա��Ϣ");
		System.out.println("��ĸ��e��:ɾ����Ա��Ϣ");
		System.out.println("��ĸ��f��:������Ա��Ϣ");
		System.out.println("��ĸ��g��:��ѯ��Ա������Ϣ");
		System.out.println("��ĸ��h��:�˳�");
		System.out.print("��ĸ��exit��:�������˵�\n\r");
		//System.out.println();
	}
	public  void queryAll(){
		System.out.print("����Ϊ��Ա������Ϣ��");
		System.out.println();
		sct.queryAll();
	}
	public void queryInfo(Scanner sc){
		System.out.println("�����������鿴��ϸ��Ϣ��");
		String s = sc.nextLine();
		sct.queryInfo(s);
	}
	
	public void add(Scanner sc){
		System.out.println("�����Ա");
		System.out.println("������ѧ�ţ�");
		int s1 = sc.nextInt();
		sc.nextLine();
		System.out.println("������������");
		String s = sc.nextLine();
		System.out.println("���������䣺");
		int s2 = sc.nextInt();
		sc.nextLine();
		DBinfo person = new DBinfo(s1,s,s2);
		sct.insert(person);
	}
	public void delete(Scanner sc){
		System.out.println("ɾ����Ա��Ϣ");
		System.out.println("������������");
		String s = sc.nextLine();
		sct.delete(s);
	}
	public void update(Scanner sc){
		System.out.println("������Ա��Ϣ");
		System.out.println("������������");
		String name = sc.nextLine();
		if(name.endsWith("a")){
			menuShow();
			return;
		}
		System.out.println("���������䣺");
		String age = sc.nextLine();
		System.out.println("�������Ա�");
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
					v.queryAll();		//ע��һ��Ҫ��break��������Bug
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
					System.out.println("�˳���ѯ");
					System.exit(0);
					break;
				default :
					System.out.println("�����������������");
					break;
			}

			
		}
	}

}
