package newWatson;

import java.sql.*;
import java.util.Scanner;

import com.ibm.cloud.sdk.core.security.Authenticator;
import com.ibm.cloud.sdk.core.security.BasicAuthenticator;
import com.ibm.watson.assistant.v1.*;
import com.ibm.watson.assistant.v1.model.*;
//program to test MySQL Java Connection.

public class mySQLconnector {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		String plainText = "";
		String queryReturn = "";

		System.out.println("What data would you like to see?");
		plainText = scan.next();

		// Watson authenticator
		BasicAuthenticator authenticator = new BasicAuthenticator("mckennab@my.easternct.edu", "CSC440Research");
		Assistant assistant = new Assistant(plainText, authenticator);

		// method to send out plaintext to Watson
		// simulated query returns due to issues with Watson Assistant
		
		//queryReturn = assistant.createCounterexample(plainText);

//		queryReturn = "SELECT * FROM customer";
		queryReturn = "SELECT product.prodName, product.prodAddedToInv FROM product WHERE product.prodAddedToInv >= [DATE]";
//		queryReturn = "SELECT product.prodName, product.prodVendor, product.bulkyItem, transactions.transDate\r\n" + 
//				"	FROM product\r\n" + 
//				"    INNER JOIN transactions ON product.prodID = transactions.productID \r\n" + 
//				"    WHERE (((product.bulkyItem)=True))";

		if (queryReturn.contains("[DATE]")) {
			System.out.println("Please enter a date for the query (in the form of YYYY-MM-DD): ");
			String date = scan.next();
			queryReturn = dateReplace(date, queryReturn);
			System.out.println("Query to be submitted: ");
			System.out.println(queryReturn);
		}

		try {
			// Connect to MySQL DB
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/movedb", "root", "password");
			// Create Statement
			Statement myStatement = myConn.createStatement();
			// Execute SQL Query
			ResultSet myRS = myStatement.executeQuery(queryReturn);
			// Process SQL Result Set
			while (myRS.next()) {
				// System.out.println(myRS.getString("custLastName") + ", " +
				// myRS.getString("custFirstName"));

			}

		} catch (Exception exc) {
			exc.printStackTrace();
		}

	}

	public static String dateReplace(String date, String input) {
		String returnString = input;
		returnString = input.replace("[DATE]", date);
		return returnString;
	}
}
