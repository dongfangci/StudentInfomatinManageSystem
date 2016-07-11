package jdbc4;



public class Student {
	private int sid;
	private String name;
	private int age;
	private int sex;
	
	public Student(){}
	public Student(int sid, String name, int age,int sex){
		this.sid = sid;
		this.name = name;
		this.age = age;
		this.setSex(sex);
		
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

	
	
	@Override
	public String toString() {
		return "Student [sid=" + sid + ", name=" + name + ", age=" + age + ", sex=" + sex + "]";
	}
	public void setAge(int age) {
		this.age = age;
	}
	public static void main(String[] args) {
		Student stu = new Student(2014111789,"John",14,1);
		System.out.println(stu.getSid() + " " + stu.getName() + " " + stu.getAge() + " " + stu.getSex());
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
}
