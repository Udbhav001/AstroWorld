package com.astroworld;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import com.dbutil.CurdOperation;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dbutil.CurdOperation;

/**
 * Servlet implementation class RegisterUser
 */
@WebServlet("/RegisterUser")
public class RegisterUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
      private Connection con;
      private ResultSet rs;
      private PreparedStatement ps;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String userid=request.getParameter("userid");
		String name=request.getParameter("Name");
		String address=request.getParameter("Address");
		String email=request.getParameter("email");
		String gender=request.getParameter("Gender");
		String phone=request.getParameter("PhoneNo");
		String dateofbirth=request.getParameter("date");
		String dateofreg=request.getParameter("datereg");
		String password=request.getParameter("userpass");
		System.out.println(userid+" "+name+" "+address+" "+email);
		String sqlInsert;
		try
		{
			sqlInsert="select * from logindetails where userid=?";
			con=CurdOperation.createConnection();
			ps=con.prepareStatement(sqlInsert);
			
			
			
			ps.setString(1, userid);
			
			
			rs=ps.executeQuery();

			System.out.println("Hello1");
			if(rs.next())
			{
				out.println("exists");

				System.out.println("Hello2");
			}
			else
			{
			sqlInsert="insert into userdetails values (?,?,?,?,?,?,?,?)";
			ps=con.prepareStatement(sqlInsert);
			ps.setString(1, userid);
			ps.setString(2, name);
			ps.setString(3, address);
			ps.setString(4, email);
			ps.setString(5, gender);
			ps.setString(6, phone);
			ps.setString(7, dateofreg);
			ps.setString(8, dateofbirth);
			int a=ps.executeUpdate();
			System.out.println(a);
			sqlInsert="insert into logindetails values(?,?,?,?)";
			ps=con.prepareStatement(sqlInsert);
			ps.setString(1, userid);
			ps.setString(2, password);
			ps.setString(3, "User");
			ps.setString(4, "true");
			int b=ps.executeUpdate();
			System.out.print("Hello3");
			if(a>0&&b>0)
			{

				System.out.println("Hello4");
				out.println("success");
				System.out.println("Login entered");
			}
			
			}
		}
		catch(SQLException e)
		{
			out.println(e);
		}
	}
}
