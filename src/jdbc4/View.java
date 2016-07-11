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
				"下面人员信息管理功能列表：\n" +
				"[QUERY/Q]:查看全部人员的信息\n" +
				"[GET/G]:查看某位的详细信息\n" +
				"[ADD/A]:添加人员信息\n" +
				"[UPDATE/U]:更新人员信息\n" +
				"[DELETE/D]:删除人员信息\n" +
				"[SEARCH/S]:人员详细信息(根据姓名查询)\n" +
				"[EXIT/E]:退出管理系统\n" +
				"[MAIN/M]:退出当前功能，返回主菜单";
	
	public static void main(String[] args) {
		StudentAction stua = new StudentAction();
		Scanner sc = new Scanner(System.in);
		System.out.println(CONTEXT);
		
		while(sc.hasNext()){
			String in = sc.nextLine();
		}
	
	}
}
