package newWatson;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestQuery3 {

	// test for query:
	// SELECT product.prodName, product.prodVendor, product.bulkyItem,
	// transactions.transDate
	// FROM product
	// INNER JOIN transactions ON product.prodID = transactions.productID
	// WHERE (((product.bulkyItem)=True));

	public static void main(String[] args) {
		
		String queryReturn = "SELECT product.prodName, product.prodVendor, product.bulkyItem, transactions.transDate\r\n"
				+ "	FROM product\r\n"
				+ "    INNER JOIN transactions ON product.prodID = transactions.productID \r\n"
				+ "    WHERE (((product.bulkyItem)=True));";
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
				System.out.println(myRS.getString("prodName") + ", " + myRS.getString("prodVendor") + ", "
						+ myRS.getBoolean("bulkyItem") + ", " + myRS.getString("transDate"));
			}
		} catch (Exception exc) {
			exc.printStackTrace();
		}

	}

}
