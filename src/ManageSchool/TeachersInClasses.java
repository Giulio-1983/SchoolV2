package ManageSchool;

public class TeachersInClasses {
	private String teacherFiscalCode;
	private int classLevel;
	private String classSection;
	public TeachersInClasses(String teacherFiscalCode, int classLevel, String classSection) {
		super();
		this.teacherFiscalCode = teacherFiscalCode;
		this.classLevel = classLevel;
		this.classSection = classSection;
	}
	public String getTeacherFiscalCode() {
		return teacherFiscalCode;
	}
	public void setTeacherFiscalCode(String teacherFiscalCode) {
		this.teacherFiscalCode = teacherFiscalCode;
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
