package ManageSchool;

public class SchoolMain {

	public static void main(String[] args) {
		ManageSchool ms = new ManageSchool();
		ms.getVerificationsFromDb();
		ms.getTeachersFromDb();
		ms.getStudentsFromDb();
		ms.runSelectionMenu();

	}

}
