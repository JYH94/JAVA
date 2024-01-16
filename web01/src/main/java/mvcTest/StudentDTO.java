package mvcTest;

public class StudentDTO {
	private int sno;
	private String name;
	private int age;
	private int jno;
	private String info;
	private double point;

	public StudentDTO() {

	}

	public StudentDTO(int sno, String name, int age, int jno, String info, double point) {
		this.sno = sno;
		this.name = name;
		this.age = age;
		this.jno = jno;
		this.info = info;
		this.point = point;
	}

	public int getSno() {
		return this.sno;
	}

	public void setSno(int sno) {
		this.sno = sno;
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

	public int getJno() {
		return jno;
	}

	public void setJno(int jno) {
		this.jno = jno;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public double getPoint() {
		return point;
	}

	public void setPoint(double point) {
		this.point = point;
	}

	@Override
	public String toString() {
		return "StudentDTO [sno=" + sno + ", name=" + name + ", age=" + age + ", jno=" + jno + ", info=" + info
				+ ", point=" + point + "]";
	}

} // class