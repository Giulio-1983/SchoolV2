package ManageSchool;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import Libraries.ConsoleManage;
import Libraries.ManageDb;

public class ManageSchool {
	ConsoleManage cm = new ConsoleManage();
	ManageDb myDb = new ManageDb();
	HashMap<String, Student> studentMap = new HashMap<>();
	HashMap<String, Teacher> teacherMap = new HashMap<>();
	List<Verifications> verificationsList = new ArrayList<>();

	public void getVerificationsFromDb() {
		boolean isConnected = myDb.ConnectToDb("localhost", 3306, "Scuolav2", "server_scuola", "password123");
		ResultSet res = null;
		if (isConnected) {
			res = myDb.ReadFromDb("select * from verifications");
			try {
				while (res.next()) {
					LocalDate date = res.getDate("date").toLocalDate();
					String tFc = res.getString("teacher_fc");
					String sfc = res.getString("student_fc");
					String subject = res.getString("subject");
					int vote = res.getInt("vote");
					Verifications v = new Verifications(date, tFc, sfc, subject, vote);
					verificationsList.add(v);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void saveStudentsInDb(String fiscalCode, String name, String surname, String sex, LocalDate birthdate,
			String birthplace, String email) {
		String query = "INSERT INTO Students (NAME, SURNAME, SEX, BIRTHPLACE, BIRTHDATE, FISCAL_CODE, EMAIL)"
				+ "VALUES ('" + name + "','" + surname + "','" + sex + "','" + birthplace + "','" + birthdate + "','"
				+ fiscalCode + "','" + email + "')";
		myDb.WriteInDb(query);
	}

	public void saveVerificationsInDb(LocalDate date, String teacher_fc, String student_fc, String subject, int vote) {
		String query = "INSERT INTO verifications (DATE, TEACHER_FC, STUDENT_FC, SUBJECT, VOTE)" + "VALUES ('" + date
				+ "','" + teacher_fc + "','" + student_fc + "','" + subject + "','" + vote + "')";
		myDb.WriteInDb(query);
	}

	public void saveTeachersInDb(String fiscalCode, String name, String surname, String sex, LocalDate birthdate,
			String birthplace, String email) {
		String query = "INSERT INTO Teachers (NAME, SURNAME, SEX, BIRTHPLACE, BIRTHDATE, FISCAL_CODE, EMAIL)"
				+ "VALUES ('" + name + "','" + surname + "','" + sex + "','" + birthplace + "','" + birthdate + "','"
				+ fiscalCode + "','" + email + "')";
		myDb.WriteInDb(query);
	}

	public void getTeachersFromDb() {
		boolean isConnected = myDb.ConnectToDb("localhost", 3306, "Scuolav2", "server_scuola", "password123");
		ResultSet res = null;
		if (isConnected) {
			res = myDb.ReadFromDb("select * from students");
			try {
				while (res.next()) {
					String fiscalCode = res.getString("fiscal_code");
					String name = res.getString("name");
					String surname = res.getString("surname");
					String birthplace = res.getString("birthplace");
					String sex = res.getString("sex");
					String email = res.getString("email");
					LocalDate birthDate = res.getDate("birthdate").toLocalDate();
					Teacher t = new Teacher(name, surname, birthDate, birthplace, sex, email, fiscalCode);
					teacherMap.put(fiscalCode, t);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void getStudentsFromDb() {
		boolean isConnected = myDb.ConnectToDb("localhost", 3306, "Scuolav2", "server_scuola", "password123");
		ResultSet res = null;
		if (isConnected) {
			res = myDb.ReadFromDb("select * from students");
			try {
				while (res.next()) {
					String fiscalCode = res.getString("fiscal_code");
					String name = res.getString("name");
					String surname = res.getString("surname");
					String birthplace = res.getString("birthplace");
					String sex = res.getString("sex");
					String email = res.getString("email");
					LocalDate birthDate = res.getDate("birthdate").toLocalDate();
					Student s = new Student(name, surname, birthDate, birthplace, sex, email, fiscalCode);
					studentMap.put(fiscalCode, s);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void runSelectionMenu() {
		while (true) {
			String menu = "";
			String[] cMenu = new String[2];
			cMenu = (cm.giveMenuOption(
					"Please select an option: \nA)Manage Students \nB)Manage Teachers\nC)Manage Non Teaching Staff\nD)Exit",
					"It was not recognized as a valid response, try again.", "A valid response was not entered", 3,
					"ABCD"));
			if (cMenu[0].equals("1")) {
				menu = cMenu[1];
			}
			switch (menu) {
			case "A": {
				runStudentsMainMenu();
				break;
			}
			case "B": {
				runTeachersMainMenu();
				break;
			}
			case "C": {
				runStaffMainMenu();
				break;
			}
			case "D": {
				System.out.println(cm.giveGreenMessage("Goodbye!"));
				return;
			}
			default:
				break;
			}
		}
	}

	public void runStaffMainMenu() {
		System.out.println("Menu staff");

	}

	private void runTeachersMainMenu() {
		while (true) {
			String menu = "";
			String[] cMenu = new String[2];
			cMenu = (cm.giveMenuOption(
					"Please select an option: \nA)Add a new teacher.\nB)Search teacher from name/surname.\nC)Serach teacher from Fiscal Code.\nD)Verification menu.\nE)Return to the selection menu.",
					"It was not recognized as a valid response, try again.", "A valid response was not entered", 3,
					"ABCDE"));
			if (cMenu[0].equals("1")) {
				menu = cMenu[1];
			}
			switch (menu) {
			case "A": {
				addteacher();
				break;
			}
			case "B": {
				searchTeacherByName();
				break;
			}
			case "C": {
				searchTeacherByFc();
				break;
			}
			case "D": {
				runVoteMenu();
				break;
			}
			case "E": {
				return;
			}
			default:
				break;
			}

		}

	}

	private void addteacher() {
		String name = "";
		String surname = "";
		String sex = "";
		String birthplace = "";
		LocalDate birthDate = LocalDate.of(0002, 01, 01);
		String fiscalCode = "";
		String email = "";

		String[] cString = new String[2];
		cString = (cm.giveString("Enter a name.", "try again.", "No name entered.", 3));
		if (cString[0].equals("1")) {
			name = cString[1];

			cString = (cm.giveString("Enter a surname.", "try again.", "No surname entered.", 3));
			if (cString[0].equals("1")) {
				surname = cString[1];

				String[] cSex = new String[2];
				cSex = (cm.giveSex("Enter a gender (M/F).", "Try Again", "No gender entered.", 3));
				if (cSex[0].equals("1")) {
					sex = cSex[1];

					cString = (cm.giveString("Enter a birth place..", "try again.", "No birth place entered.", 3));
					if (cString[0].equals("1")) {
						birthplace = cString[1];

						LocalDate[] cDate = new LocalDate[2];
						cDate = (cm.giveDate("Enter a birth date (dd/mm/yyyy)", "try again.", "No birth place entered.",
								3));
						if (cDate[0].equals(LocalDate.of(0002, 01, 01))) {
							birthDate = cDate[1];

							String[] cCf = new String[2];
							cCf = (cm.giveCf("Enter a fiscal code.", "Try again.", "No fiscal code entered.", 3));
							if (cCf[0].equals("1")) {
								fiscalCode = cCf[1];

								String[] cMail = new String[2];
								cMail = (cm.giveMail("Enter an Email.", "Try agan.", "No email entered.", 3));
								if (cMail[0] == "1") {
									email = cMail[1];

									Teacher t = new Teacher(name, surname, birthDate, birthplace, sex, email,
											fiscalCode);
									if (!teacherMap.containsKey(fiscalCode)) {
										teacherMap.put(fiscalCode, t);
										System.out.println(cm.giveGreenMessage("Teacher added."));
										saveTeachersInDb(fiscalCode, name, surname, sex, birthDate, birthplace, email);
									} else {
										System.out
												.println(cm.giveErrorMessage("It seems this teacher already exists."));
									}
								}

							}
						}

					}
				}

			}

		}
	}

	private void searchTeacherByFc() {
		String[] cString = new String[2];
		cString = (cm.giveString("Enter a fiscal code.", "try again.", "No fiscal code entered.", 3));
		if (cString[0].equals("1")) {
			String fc = cString[1];
			for (Map.Entry<String, Teacher> entry : teacherMap.entrySet()) {
				if (entry.getValue().getFiscalCode().equalsIgnoreCase(fc)) {
					System.out.println(entry.getValue().toStringSetup());
				}
			}
		}

	}

	private void searchTeacherByName() {
		String[] cString = new String[2];
		cString = (cm.giveString("Enter a name.", "try again.", "No name entered.", 3));
		if (cString[0].equals("1")) {
			String name = cString[1];
			for (Map.Entry<String, Teacher> entry : teacherMap.entrySet()) {
				if (entry.getValue().getName().equalsIgnoreCase(name)
						|| entry.getValue().getSurname().equalsIgnoreCase(name)) {
					System.out.println(entry.getValue().toStringSetup());
				}
			}
		}

	}

	private void runStudentsMainMenu() {
		while (true) {
			String menu = "";
			String[] cMenu = new String[2];
			cMenu = (cm.giveMenuOption(
					"Please select an option: \nA)Add a new student.\nB)Search student from name/surname.\nC)Serach student from Fiscal Code.\nD)Verification menu.\nE)Return to the selection menu.",
					"It was not recognized as a valid response, try again.", "A valid response was not entered", 3,
					"ABCDE"));
			if (cMenu[0].equals("1")) {
				menu = cMenu[1];
			}
			switch (menu) {
			case "A": {
				addStudent();
				break;
			}
			case "B": {
				searchStudentByName();
				break;
			}
			case "C": {
				searchStudentByFc();
				break;
			}
			case "D": {
				runVoteMenu();
				break;
			}
			case "E": {
				return;
			}
			default:
				break;
			}

		}

	}

	private void runVoteMenu() {
		while (true) {
			String menu = "";
			String[] cMenu = new String[2];
			cMenu = (cm.giveMenuOption(
					"Please select an option: \nA)Add a new verification.\nB)Search verifications from student/teacher name/surname.\nC)Serach verifications from student/teacher Fiscal Code.\nD)Return to the last menu.",
					"It was not recognized as a valid response, try again.", "A valid response was not entered", 3,
					"ABCD"));
			if (cMenu[0].equals("1")) {
				menu = cMenu[1];
			}
			switch (menu) {
			case "A": {
				addVerifications();
				break;
			}
			case "B": {
				searchVerificationsByName();
				break;
			}
			case "C": {
				searchVerificationsByFc();
				break;
			}
			case "D": {
				return;
			}
			default:
				break;
			}

		}

	}

	private void searchVerificationsByFc() {
		String[] cString = new String[2];
		cString = (cm.giveString("Enter a fiscal code.", "try again.", "No fiscal code entered.", 3));
		if (cString[0].equals("1")) {
			String fc = cString[1];
			for (Verifications entry : verificationsList) {
				if (entry.getStudentFiscalCode().equalsIgnoreCase(fc)
						|| entry.getTeacherFiscalCode().equalsIgnoreCase(fc)) {
					System.out.println(entry.toStringSetup());
				}
			}
		}

	}

	private void searchVerificationsByName() {
		List<Verifications> temporaryList = new ArrayList<>();
		String[] cString = new String[2];
		cString = (cm.giveString("Enter a name.", "try again.", "No name entered.", 3));
		if (cString[0].equals("1")) {
			String name = cString[1];
			for (Map.Entry<String, Student> entry : studentMap.entrySet()) {
				if (entry.getValue().getName().equalsIgnoreCase(name)
						|| entry.getValue().getSurname().equalsIgnoreCase(name)) {
					String fc = entry.getValue().getFiscalCode();
					for (Verifications entry2 : verificationsList) {
						if (entry2.getStudentFiscalCode().equalsIgnoreCase(fc)
								|| entry2.getTeacherFiscalCode().equalsIgnoreCase(fc)) {
							if (!temporaryList.contains(entry2)) {
								temporaryList.add(entry2);
							}
						}
					}
				}

			}
			for (Map.Entry<String, Teacher> entry : teacherMap.entrySet()) {
				if (entry.getValue().getName().equalsIgnoreCase(name)
						|| entry.getValue().getSurname().equalsIgnoreCase(name)) {
					String fc = entry.getValue().getFiscalCode();
					for (Verifications entry2 : verificationsList) {
						if (entry2.getStudentFiscalCode().equalsIgnoreCase(fc)
								|| entry2.getTeacherFiscalCode().equalsIgnoreCase(fc)) {
							if (!temporaryList.contains(entry2)) {
								temporaryList.add(entry2);
							}
						}
					}
				}

			}
		}
		for (Verifications entry : temporaryList) {
			System.out.println(entry.toStringSetup());
		}
	}

	private void addVerifications() {
		LocalDate date = LocalDate.of(0002, 01, 01);
		String teacherFc = "";
		String studentFc = "";
		String subject = "";
		int vote = 0;

		LocalDate[] cDate = new LocalDate[2];
		cDate = (cm.giveDate("Enter a verification date (dd/mm/yyyy)", "try again.", "No verification date entered.",
				3));
		if (cDate[0].equals(LocalDate.of(0002, 01, 01))) {
			date = cDate[1];

			String[] cCf = new String[2];
			cCf = (cm.giveCf("Enter the teacher fiscal code.", "Try again.", "No fiscal code entered.", 3));
			if (cCf[0].equals("1")) {
				teacherFc = cCf[1];
				if (teacherMap.containsKey(teacherFc)) {
					cCf = (cm.giveCf("Enter the Student fiscal code.", "Try again.", "No fiscal code entered.", 3));
					if (cCf[0].equals("1")) {
						studentFc = cCf[1];
						if (studentMap.containsKey(studentFc)) {
							String[] cString = new String[2];
							cString = (cm.giveString("Enter the subject of the verification.", "try again.",
									"No name entered.", 3));
							if (cString[0].equals("1")) {
								subject = cString[1];

								int[] cInt = new int[2];
								cInt = (cm.giveInt("Enter the verification vote.", "try again.", "No vote entered.",
										3));
								if (cInt[0] == 1) {
									vote = cInt[1];

									Verifications v = new Verifications(date, teacherFc, studentFc, subject, vote);
									if (!verificationsList.contains(v)) {
										verificationsList.add(v);
										System.out.println(cm.giveGreenMessage("Verification added."));
										saveVerificationsInDb(date, teacherFc, studentFc, subject, vote);
									} else {
										System.out.println(
												cm.giveErrorMessage("It seems this verification already exists."));
									}
								}
							}
						}else {
							System.out.println(cm.giveErrorMessage("It seems this student does not exist."));
						}
					}
				}else {
					System.out.println(cm.giveErrorMessage("It seems this Teacher does not exist."));
				}
			}
		}

	}

	private void searchStudentByFc() {
		String[] cString = new String[2];
		cString = (cm.giveString("Enter a fiscal code.", "try again.", "No fiscal code entered.", 3));
		if (cString[0].equals("1")) {
			String fc = cString[1];
			for (Map.Entry<String, Student> entry : studentMap.entrySet()) {
				if (entry.getValue().getFiscalCode().equalsIgnoreCase(fc)) {
					System.out.println(entry.getValue().toStringSetup());
				}
			}
		}

	}

	private void searchStudentByName() {
		String[] cString = new String[2];
		cString = (cm.giveString("Enter a name.", "try again.", "No name entered.", 3));
		if (cString[0].equals("1")) {
			String name = cString[1];
			for (Map.Entry<String, Student> entry : studentMap.entrySet()) {
				if (entry.getValue().getName().equalsIgnoreCase(name)
						|| entry.getValue().getSurname().equalsIgnoreCase(name)) {
					System.out.println(entry.getValue().toStringSetup());
				}
			}
		}

	}

	private void addStudent() {
		String name = "";
		String surname = "";
		String sex = "";
		String birthplace = "";
		LocalDate birthDate = LocalDate.of(0002, 01, 01);
		String fiscalCode = "";
		String email = "";

		String[] cString = new String[2];
		cString = (cm.giveString("Enter a name.", "try again.", "No name entered.", 3));
		if (cString[0].equals("1")) {
			name = cString[1];

			cString = (cm.giveString("Enter a surname.", "try again.", "No surname entered.", 3));
			if (cString[0].equals("1")) {
				surname = cString[1];

				String[] cSex = new String[2];
				cSex = (cm.giveSex("Enter a gender (M/F).", "Try Again", "No gender entered.", 3));
				if (cSex[0].equals("1")) {
					sex = cSex[1];

					cString = (cm.giveString("Enter a birth place..", "try again.", "No birth place entered.", 3));
					if (cString[0].equals("1")) {
						birthplace = cString[1];

						LocalDate[] cDate = new LocalDate[2];
						cDate = (cm.giveDate("Enter a birth date (dd/mm/yyyy)", "try again.", "No birth place entered.",
								3));
						if (cDate[0].equals(LocalDate.of(0002, 01, 01))) {
							birthDate = cDate[1];

							String[] cCf = new String[2];
							cCf = (cm.giveCf("Enter a fiscal code.", "Try again.", "No fiscal code entered.", 3));
							if (cCf[0].equals("1")) {
								fiscalCode = cCf[1];

								String[] cMail = new String[2];
								cMail = (cm.giveMail("Enter an Email.", "Try agan.", "No email entered.", 3));
								if (cMail[0] == "1") {
									email = cMail[1];

									Student s = new Student(name, surname, birthDate, birthplace, sex, email,
											fiscalCode);
									if (!studentMap.containsKey(fiscalCode)) {
										studentMap.put(fiscalCode, s);
										System.out.println(cm.giveGreenMessage("Student added."));
										saveStudentsInDb(fiscalCode, name, surname, sex, birthDate, birthplace, email);
									} else {
										System.out
												.println(cm.giveErrorMessage("It seems this student already exists."));
									}
								}

							}
						}

					}
				}

			}

		}
	}
}
