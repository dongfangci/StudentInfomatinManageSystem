package jdbc2;

public class DBinfo {
	private int sid;
	private String name;
	private int age;
	
	public DBinfo(){}
	public DBinfo(int sid, String name, int age){
		this.sid = sid;
		this.name = name;
		this.age = age;
		
	}
	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	public static void main(String[] args) {
		DBinfo person = new DBinfo(2014111789,"John",14);
		System.out.println(person.getSid() + " " + person.getName() + " " + person.getAge());
	}
}
