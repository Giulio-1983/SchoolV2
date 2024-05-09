package ManageSchool;

import java.time.LocalDate;

public class NonTeachingStaff extends Person{

	public NonTeachingStaff(String name, String surname, LocalDate birthDate, String birthPlace, String sex,
			String mail, String fiscalCode) {
		super(name, surname, birthDate, birthPlace, sex, mail, fiscalCode);
	}

}
