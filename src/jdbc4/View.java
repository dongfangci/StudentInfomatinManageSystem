package jdbc4;

import java.util.Scanner;

public class View {
	
	private static final String OPERATION_MAIN="MAIN";
	private static final String OPERATION_QUERY="QUERY";
	private static final String OPERATION_GET="GET";
	private static final String OPERATION_ADD="ADD";
	private static final String OPERATION_UPDATE="UPDATE";
	private static final String OPERATION_DELETE="DELETE";
	private static final String OPERATION_SEARCH="SEARCH";
	private static final String OPERATION_EXIT="EXIT";

	private static final String CONTEXT = 
				"������Ա��Ϣ�������б�\n" +
				"[QUERY/Q]:�鿴ȫ����Ա����Ϣ\n" +
				"[GET/G]:�鿴ĳλ����ϸ��Ϣ\n" +
				"[ADD/A]:�����Ա��Ϣ\n" +
				"[UPDATE/U]:������Ա��Ϣ\n" +
				"[DELETE/D]:ɾ����Ա��Ϣ\n" +
				"[SEARCH/S]:��Ա��ϸ��Ϣ(����������ѯ)\n" +
				"[EXIT/E]:�˳�����ϵͳ\n" +
				"[MAIN/M]:�˳���ǰ���ܣ��������˵�";
	
	public static void main(String[] args) {
		StudentAction stua = new StudentAction();
		Scanner sc = new Scanner(System.in);
		System.out.println(CONTEXT);
		
		while(sc.hasNext()){
			String in = sc.nextLine();
		}
	
	}
}
