package domain;

public class Evaluation {
	private String id;
	private String subject;
	private String description;
	private String stu_name;
	private String tch_id;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStu_name(){
		return stu_name;
	}
	public void setStu_name(String stu_name) {
		this.stu_name = stu_name;
	}
	public String getTch_id() {
		return tch_id;
	}
	public void setTch_id(String tch_id) {
		this.tch_id = tch_id;
	}

	
}
