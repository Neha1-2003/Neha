package internshipproject;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class student
 */
@WebServlet("/student")
public class student extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String Name=request.getParameter("name");
		String Age=request.getParameter("age");
		String USN=request.getParameter("usn");
		String Email=request.getParameter("email");
		
		PrintWriter pw=response.getWriter();
		
			try {
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/register","root","root");
				String insert="insert into stud_registration values(?,?,?,?)";
				PreparedStatement pre=con.prepareStatement(insert);
				pre.setString(1, Name);
				pre.setString(2, Age);
				pre.setString(3, USN);
				pre.setString(4, Email);
				pre.executeUpdate();
				pw.println("successfully registerd");
				response.sendRedirect("course.html");
				
			}catch(SQLException e) {
				pw.println(e);
			}
		}
		


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}