package com.astroworld;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import com.dbutil.CurdOperation;

import beans.Profile;

import java.sql.*;
import java.util.ArrayList;
/**
 * Servlet implementation class updateUser
 */
@WebServlet("/updateUser")
public class updateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       Connection con;
       PreparedStatement ps;
       ResultSet resultSet;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		Profile profile=new Profile();
		String sql="Update userdetails set Name=?,Address=?,email=?,PhoneNo=? where userid=?";
		try
		{
			con=CurdOperation.createConnection();
			ps=con.prepareStatement(sql);
			ps.setString(1, request.getParameter("name"));
			ps.setString(2, request.getParameter("address"));
			ps.setString(3, request.getParameter("email"));
			ps.setString(4, request.getParameter("phoneno"));
			ps.setString(5, request.getParameter("userid"));
			System.out.println(ps);
			
			int r=ps.executeUpdate();
			
			System.out.println(request.getParameter("name")+" "+request.getParameter("address")+" "+request.getParameter("email")+" "+r);
			
			if(r>0)
			{
				sql="select * from userdetails where userid=?";
				con=CurdOperation.createConnection();
				ps=con.prepareStatement(sql);
				ps.setString(1, request.getParameter("userid"));
				resultSet=ps.executeQuery();
				if(resultSet.next())
				{
					String a=resultSet.getString("Name");
					profile.setName(a);
					profile.setAddress(resultSet.getString("Address"));
					profile.setEmail(resultSet.getString("email"));
					profile.setPhoneno(resultSet.getString("PhoneNo"));
					profile.setErrormsg("success");
					System.out.println(profile.getAddress());
				}
				ArrayList<Profile> arr=new ArrayList<>();
				arr.add(profile);
				JSONArray array=new JSONArray(arr);
				out.println(array);
			}
			
		}
		catch(SQLException e)
		{
			out.println(e);
		}
	}
}
