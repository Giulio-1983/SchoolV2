package ManageSchool;

public class TeachersSubjects {
	private String teacherFiscalCode;
	private String subjects;
	public TeachersSubjects(String teacherFiscalCode, String subjects) {
		super();
		this.teacherFiscalCode = teacherFiscalCode;
		this.subjects = subjects;
	}
	public String getTeacherFiscalCode() {
		return teacherFiscalCode;
	}
	public void setTeacherFiscalCode(String teacherFiscalCode) {
		this.teacherFiscalCode = teacherFiscalCode;
	}
	public String getSubjects() {
		return subjects;
	}
	public void setSubjects(String subjects) {
		this.subjects = subjects;
	}
	
}
