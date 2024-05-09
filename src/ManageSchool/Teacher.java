package ManageSchool;

import java.time.LocalDate;

public class Teacher extends Person{

	public Teacher(String name, String surname, LocalDate birthDate, String birthPlace, String sex, String mail,
			String fiscalCode) {
		super(name, surname, birthDate, birthPlace, sex, mail, fiscalCode);
	}

}
