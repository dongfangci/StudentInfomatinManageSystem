package jdbc2;

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
			System.out.print("����Ϊ��Ա������Ϣ��");
			System.out.println();
			v.sct.queryAll();
		}
		else if(s.equals("c")){
			System.out.println("�����������鿴��ϸ��Ϣ��");
			s = sc.nextLine();
			v.sct.queryInfo(s);
		}
		else if(s.equals("d")){
			System.out.println("�����Ա");
			System.out.println("������ѧ�ţ�");
			s1 = sc.nextInt();
			sc.nextLine();
			System.out.println("������������");
			s = sc.nextLine();
			System.out.println("���������䣺");
			s2 = sc.nextInt();
			sc.nextLine();
			DBinfo person = new DBinfo(s1,s,s2);
			v.sct.insert(person);
		}
		
		else if(s.equals("e")){
			System.out.println("ɾ����Ա��Ϣ");
			System.out.println("������������");
			s = sc.nextLine();
			v.sct.delete(s);
		}
		else if(s.equals("f")){
			System.out.println("������Ա��Ϣ");
			System.out.println("������������");
			name = sc.nextLine();
			System.out.println("���������䣺");
			age = sc.nextLine();
			System.out.println("�������Ա�");
			sex = sc.nextLine();
			v.sct.update(name, age, sex);
		}
		else{
			System.out.println("�����������������");
		}
			
		}
	}

}
