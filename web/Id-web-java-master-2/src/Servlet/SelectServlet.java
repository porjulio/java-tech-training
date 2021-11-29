package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/SelectServlet")
public class SelectServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//	System.out.println("Inside the service method of SelectServlet");
		
//		Printing HTML
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Display User Details</title>");
//		out.println(" <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\"><link rel=\\\"stylesheet\\\" href=\\\"https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\\\"><script src=\\\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\\\"></script><script src=\\\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js\\\"></script><script src=\\\"https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js\\\"></script></script>");
		out.println("<meta charset=\"utf-8\">\r\n" + 
				"  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n" + 
				"  <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\">\r\n" + 
				"  <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>\r\n" + 
				"  <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js\"></script>\r\n" + 
				"  <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js\"></script>");
		out.println("</head>");
		out.println("<body>");
		out.println(" <h1>List of Users</h1>");
		try {
			Statement selectStatement = getStatement();
			String queryString = "SELECT * FROM USERS";
			
			//print all data in table
			ResultSet resultSet =  selectStatement.executeQuery(queryString);

//			boolean found = false;
			out.println("<table class=\"table table-dark table-striped\"><tr><th>User ID</th><th>Userame</th><th>Creation Date</th><th>Number of Accounts</th><th>Account Number</th><th>Total Balance</th><th>Contact Number</th></tr>");
			while(resultSet.next()) {
				String userId = resultSet.getString("USER_ID");
				String userName = resultSet.getString("USER_NAME");
//				String userPassword = resultSet.getString("USER_PASSWORD");
				String creationDate = resultSet.getString("CREATION_DATE");
				int numberOfAccounts = resultSet.getInt("NUMBER_OF_ACCOUNTS");
				int accountNumber = resultSet.getInt("ACCOUNT_NUMBER");
				float totalBalance = resultSet.getFloat("TOTAL_BALANCE");
				String contactNumber = resultSet.getString("CONTACT_NUMBER");
				out.println("<tr><td>" + userId + "</td><td>" + userName + "</td><td>" + "</td><td>" + 
				creationDate + "</td><td>" + numberOfAccounts + "</td><td>" + accountNumber + "</td><td>" + 
						totalBalance + "</td><td>" + contactNumber + "</td></tr>");
		}
	} catch (SQLException sqlException) {
		System.out.println("DATABASE CONNECTION ISSUE " + sqlException);		
	}
		out.println(" </table>");
		out.println("</body>");
		out.println("</html>");		
	}
	public Statement getStatement() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection mySQLConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/GBSDBV1", "root", "mysql");
//			System.out.println("CREATING STATEMENT");
			Statement statement = mySQLConnection.createStatement();
			return statement;
		} catch (SQLException sqlException) {
			System.out.println("DATABASE CONNECTION ISSUE " + sqlException);
		} catch (ClassNotFoundException classNotFoundException) {
			System.out.println("UNABLE TO LOAD DRIVER" + classNotFoundException);
		}
		return null;
	}
}
