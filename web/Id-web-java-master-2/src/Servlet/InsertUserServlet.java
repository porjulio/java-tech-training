package Servlet;

import java.io.IOException;
//import java.io.PrintWriter;
//import java.rmi.ServerException;
//import java.security.Provider.Service;
import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/InsertUserServlet")
public class InsertUserServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//	read inputs from html form data
		String userNameString = request.getParameter("pUsername");
		String userPassword = request.getParameter("pPassword");
		String contactNumber = request.getParameter("pContactNumber");
		String initialDepositString = request.getParameter("pInitialDeposit");
		float initialDeposit = Float.parseFloat(initialDepositString);

		System.out.println(userNameString + ">" + contactNumber + ">" + initialDeposit);
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("CONNECTING");
			Connection mySQLConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/GBSDBV1", "root",
					"mysql");
			System.out.println("CREATING STATEMENT");
			Statement insertStatement = mySQLConnection.createStatement();
			System.out.println("EXECUTING QUERY AND OBTAINING NO OF ROWS AFFECTED");
//			Executes the given SQL statement, which may be an INSERT, UPDATE, or DELETE statement
			String queryString = "INSERT INTO USERS(USER_ID, USER_NAME, USER_PASSWORD, CREATION_DATE, TOTAL_BALANCE, CONTACT_NUMBER) VALUES (UUID_SHORT(),"
			+ "'" + userNameString + "','" + userPassword + "',now()," + initialDeposit + ",'" + contactNumber + "'" + ")";
			System.out.println(queryString);
			int rowCount = insertStatement.executeUpdate(queryString);
			if (rowCount != 0) {
				System.out.println("Inserted : " + rowCount);
			} else {
				System.out.println("No Rows Inserted!");
			}
		} catch (SQLException sqlException) {
			System.out.println("DATABASE CONNECTION ISSUE " + sqlException);
		} catch (ClassNotFoundException classNotFoundException) {
			System.out.println("UNABLE TO LOAD DRIVER" + classNotFoundException);
		}
	}
}