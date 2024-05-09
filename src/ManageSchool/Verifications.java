package ManageSchool;

import java.time.LocalDate;

public class Verifications {
	private LocalDate date;
	private String teacherFiscalCode;
	private String studentFiscalCode;
	private String subject;
	private int vote;
	public Verifications(LocalDate date, String teacherFiscalCode, String studentFiscalCode, String subject, int vote) {
		this.date=date;;
		this.teacherFiscalCode = teacherFiscalCode;
		this.studentFiscalCode = studentFiscalCode;
		this.subject = subject;
		this.vote = vote;
	}
	public String getTeacherFiscalCode() {
		return teacherFiscalCode;
	}
	public void setTeacherFiscalCode(String teacherFiscalCode) {
		this.teacherFiscalCode = teacherFiscalCode;
	}
	public String getStudentFiscalCode() {
		return studentFiscalCode;
	}
	public void setStudentFiscalCode(String studentFiscalCode) {
		this.studentFiscalCode = studentFiscalCode;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public int getVote() {
		return vote;
	}
	public void setVote(int vote) {
		this.vote = vote;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public String toStringSetup() {
		return "Date: "+date+" - Teacher FC: "+teacherFiscalCode+" - Student FC: "+studentFiscalCode+" - Subject: "+subject+" - Vote: "+vote;
	}
}
