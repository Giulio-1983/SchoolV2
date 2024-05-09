package ManageSchool;

public class StudentsInClasses {
	private String studentFiscalCode;
	private int classLevel;
	private String classSection;
	public StudentsInClasses(String studentFiscalCode, int classLevel, String classSection) {
		super();
		this.studentFiscalCode = studentFiscalCode;
		this.classLevel = classLevel;
		this.classSection = classSection;
	}
	public String getStudentFiscalCode() {
		return studentFiscalCode;
	}
	public void setStudentFiscalCode(String studentFiscalCode) {
		this.studentFiscalCode = studentFiscalCode;
	}
	public int getClassLevel() {
		return classLevel;
	}
	public void setClassLevel(int classLevel) {
		this.classLevel = classLevel;
	}
	public String getClassSection() {
		return classSection;
	}
	public void setClassSection(String classSection) {
		this.classSection = classSection;
	}
	
}
