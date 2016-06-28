package minhaihuang.dbutils.myUtils;
/**
 * 创建一个persons类，里面的字段要求与数据库的persons表的一致
 * @author 黄帅哥
 *
 */
public class Persons {
	private int id;
	private String name;
	private int age;
	private String salary;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	
	public Persons(int id, String name, int age, String salary) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.salary = salary;
	}
	
	public Persons() {
		super();
	}
	
	@Override
	public String toString() {
		return "Persons [id=" + id + ", name=" + name + ", age=" + age
				+ ", salary=" + salary + "]";
	}
	
	
}
