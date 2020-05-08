package newWatson;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestQuery2 {

	// test for query:
	// SELECT product.prodName, product.prodAddedToInv FROM product WHERE
	// product.prodAddedToInv >= "2014-01-01";

	public static void main(String[] args) {
		
		String queryReturn = "SELECT product.prodName, product.prodAddedToInv FROM product WHERE product.prodAddedToInv >= \"2014-01-01\";";
		System.out.println("Input to MySQL: ");
		System.out.println(queryReturn);

		try {
			// Connect to MySQL DB
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/movedb", "root", "password");
			// Create Statement
			Statement myStatement = myConn.createStatement();
			// Execute SQL Query
			ResultSet myRS = myStatement.executeQuery(queryReturn);
			// Process SQL Result Set
			while (myRS.next()) {
				System.out.println(myRS.getString("prodName") + ", " + myRS.getString("prodAddedToInv"));
			}
		} catch (Exception exc) {
			exc.printStackTrace();
		}

	}

}
