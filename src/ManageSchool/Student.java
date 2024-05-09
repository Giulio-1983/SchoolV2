package ManageSchool;

import java.time.LocalDate;

public class Student extends Person{

	public Student(String name, String surname, LocalDate birthDate, String birthPlace, String sex, String mail,
			String fiscalCode) {
		super(name, surname, birthDate, birthPlace, sex, mail, fiscalCode);
	}
}
