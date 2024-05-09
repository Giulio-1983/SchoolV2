package Libraries;

public class Prove {

	public static void main(String[] args) {
	ManageDb myDb = new ManageDb();
	boolean bret = myDb.ConnectToDb("localhost",3306,"scuola_db","server_scuola","password123");
    myDb.ReadFromDb("Select * from classes");
	}

}
