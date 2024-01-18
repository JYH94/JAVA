package jdbc02;

public class JoDTO {

	private String jname;
	private String project;
	private int captain;
	
	public JoDTO(String jname, String project, int captain) {
		this.jname = jname;
		this.project = project;
		this.captain = captain;
	}
	
	public String getJname() {
		return jname;
	}
	public void setJname(String jname) {
		this.jname = jname;
	}
	public String getProject() {
		return project;
	}
	public void setProject(String project) {
		this.project = project;
	}
	public int getCaptain() {
		return captain;
	}
	public void setCaptain(int captain) {
		this.captain = captain;
	}
	
	
	
}
