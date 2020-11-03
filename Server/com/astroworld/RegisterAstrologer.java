package com.astroworld;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.dbutil.CurdOperation;
import java.sql.*;

/**
 * Servlet implementation class RegisterAstrologer
 */
@WebServlet("/RegisterAstrologer")
public class RegisterAstrologer extends HttpServlet 
{
	private ResultSet rs;
	public Connection con;
	private PreparedStatement ps,ps1;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterAstrologer() {
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
		String experience=request.getParameter("experience");
		String skill=request.getParameter("skills");
		
		String regno=request.getParameter("registrationo");
		String password=request.getParameter("userpass");
		System.out.println(userid+" "+name+" "+address+" "+email);
		/*String userid="udbhav1";
		String name="renu";
		String address="let it be x";
		String email="abc@gmail.com";
		String gender="Male";
		String phone="9876543120";
		String experience="None";
		String skill="None";
		String password="123qwe";
		String regno="123qwe";
		String usertype="Astrologer";
		String status="false";
		*/
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
			sqlInsert="insert into astrologer values(?,?,?,?,?,?,?,?,?)";
			ps=con.prepareStatement(sqlInsert);
			ps.setString(1, userid);
			ps.setString(2, name);
			ps.setString(3, address);
			ps.setString(4, email);
			ps.setString(5, gender);
			ps.setString(6, phone);
			ps.setString(7, experience);
			ps.setString(8, skill);
			ps.setString(9, regno);
			int a=ps.executeUpdate();
			
			sqlInsert="insert into logindetails values(?,?,?,?)";
			ps1=con.prepareStatement(sqlInsert);
			ps1.setString(1, userid);
			ps1.setString(2, password);
			ps1.setString(3, "Astrologer");
			ps1.setString(4, "false");
			int b=ps1.executeUpdate();
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
