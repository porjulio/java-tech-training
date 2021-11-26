package SelectServlet;
// java.lang.* gets imported by default
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
		out.println("<title>Display Product Details</title>");
		out.println(" <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n" + 
				"<link rel=\\\"stylesheet\\\" href=\\\"https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\\\">\\r\\n\" + \r\n" + 
				"				\"    <script src=\\\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\\\"></script>\\r\\n\" + \r\n" + 
				"				\"    <script src=\\\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js\\\"></script>\\r\\n\" + \r\n" + 
				"				\"    <script src=\\\"https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js\\\"></script>></script>");
		out.println("</head>");
		out.println("<body>");
		out.println(" <h1>List of Users</h1>");
		try {
			System.out.println("CONNECTING");
//			Connection mySQLConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/JBEDB", "root",
//					"mysql");
//			System.out.println("CREATING STATEMENT");
			Statement selectStatement = getStatement();
//			System.out.println("EXECUTING QUERY AND OBTAINING RESULTSET");
			String queryString = "SELECT * FROM USERS";
			//print all data in table
			ResultSet resultSet =  selectStatement.executeQuery(queryString);
//			System.out.println("ITERATING THROUGH THE RESULT SET AND FETCHING THE ROWS");
			boolean found = false;
			out.println("<table class=\"table table-dark table-striped\"><tr><th>Product ID</th><th>Name</th><th>Price</th></tr>");
			while(resultSet.next()) {
				int userId = resultSet.getInt("PRODUCT_ID");
				String userName = resultSet.getString("PRODUCT_NAME");
				String userPassword = resultSet.getString("USER_PASSWORD");
				String creationDate = resultSet.getString("CREATION_DATE");
				int numberOfAccounts = resultSet.getInt("NUMBER_OF_ACCOUNTS");
				int accountNumber = resultSet.getInt("ACCOUNT_NUMBER");
				float totalBalance = resultSet.getFloat("TOTAL_BALANCE");
				String contactNumber = resultSet.getString("CONTACT_NUMBER");
				out.println("<tr><td>" + userId + "</td><td>" + userName + "</td><td>" + userPassword  + "</td><td>" + 
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
			Connection mySQLConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/JBEDB", "root", "mysql");
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
