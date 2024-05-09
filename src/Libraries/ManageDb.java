package Libraries;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

public class ManageDb {
	private Connection myConn;

	// colegati al db
	public Boolean ConnectToDb(String sIPServer, int iTcpPort, String sDbName, String sUserName, String sUserPassword) {
		String sConnectString;
		sConnectString = "jdbc:mysql://" + sIPServer + ":" + iTcpPort + "/" + sDbName + "?user=" + sUserName
				+ "&password=" + sUserPassword;

		try {
			myConn = DriverManager.getConnection(sConnectString);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}
	
	
	// ESEMPIO DI UTILIZZO
	
//	ManageDb myDb = new ManageDb();
//	myDb.ConnectToDb("localhost",3306,"scuola_db","username","password");
	
	

	public boolean WriteInDb(String sSqlQuery) {
		// inserisci entry nel db
		
		try {
			
			Statement stm = myConn.createStatement();
			return stm.execute(sSqlQuery);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	// ESEMPIO DI UTILIZZO
//	myDb.WriteInDb("insert into provajava values(2)");
//	System.out.println("fatto");

	public ResultSet ReadFromDb(String sSqlQuery) {
		// chiedi dati al db
		try {
			Statement stm = myConn.createStatement();
			return stm.executeQuery(sSqlQuery);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

//	ESEMPIO DI UTILIZZO
//	ResultSet res =myDb.ReadFromDb("select * from students");
//	try {
//		while (res.next()) {
//			String nomeAlievo = res.getString("name");
//			LocalDate datanascita = res.getDate("birthdate").toLocalDate();
//			System.out.println(datanascita);
//		}
//	} catch (SQLException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
	
	
	public boolean DisconnectFromDb() {
		// chiudi il db
		try {
			myConn.close();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
