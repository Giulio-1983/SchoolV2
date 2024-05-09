package ManageSchool;

import java.time.LocalDate;

public class Person {

		private String name;
		private String surname;
		private LocalDate birthDate;
		private String birthPlace;
		private String sex;
		private String mail;
		private String fiscalCode;
		
		public Person(String name, String surname, LocalDate birthDate, String birthPlace, String sex, String mail,
				String fiscalCode) {
			
			this.name = name;
			this.surname = surname;
			this.birthDate = birthDate;
			this.birthPlace = birthPlace;
			this.sex = sex;
			this.mail = mail;
			this.fiscalCode = fiscalCode;
		}
		
		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getSurname() {
			return surname;
		}

		public void setSurname(String surname) {
			this.surname = surname;
		}

		public LocalDate getBirthDate() {
			return birthDate;
		}

		public void setBirthDate(LocalDate birthDate) {
			this.birthDate = birthDate;
		}

		public String getBirthPlace() {
			return birthPlace;
		}

		public void setBirthPlace(String birthPlace) {
			this.birthPlace = birthPlace;
		}

		public String getSex() {
			return sex;
		}

		public void setSex(String sex) {
			this.sex = sex;
		}

		public String getMail() {
			return mail;
		}

		public void setMail(String mail) {
			this.mail = mail;
		}

		public String getFiscalCode() {
			return fiscalCode;
		}

		public void setFiscalCode(String fiscalCode) {
			this.fiscalCode = fiscalCode;
		}

		public String toStringSetup() {
			return "Name: "+name+" - Surname: "+surname+" - Birthdate: "
		+birthDate+" - Birthplace: "+birthPlace+" - Sex: "+sex+ " - Email: "+mail
		+" - Fiscal Code: "+fiscalCode;
		}
}
