package com.astroworld;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import com.dbutil.CurdOperation;

import beans.Profile;

/**
 * Servlet implementation class updateAstrologer
 */
@WebServlet("/updateAstrologer")
public class updateAstrologer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con;
    PreparedStatement ps;
    ResultSet resultSet;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateAstrologer() {
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
		Profile profile=new Profile();
		String sql="Update astrologer set Name=?,Address=?,email=?,PhoneNo=?,experience=?,skills=? where userid=?";
		try
		{
			con=CurdOperation.createConnection();
			ps=con.prepareStatement(sql);
			ps.setString(1, request.getParameter("name"));
			ps.setString(2, request.getParameter("address"));
			ps.setString(3, request.getParameter("email"));
			ps.setString(4, request.getParameter("phoneno"));
			ps.setString(5, request.getParameter("experience"));
			ps.setString(6, request.getParameter("skills"));
			ps.setString(7,request.getParameter("userid"));
			System.out.println(ps);
			
			int r=ps.executeUpdate();
			
			System.out.println(request.getParameter("name")+" "+request.getParameter("address")+" "+request.getParameter("email")+" "+r);
			
			if(r>0)
			{
				sql="select * from astrologer where userid=?";
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
					profile.setExperience(resultSet.getString("experience"));
					profile.setSkill(resultSet.getString("skills"));
					profile.setErrormsg("success");
					System.out.println(profile.getAddress());
				}
				ArrayList<Profile> arr=new ArrayList<>();
				arr.add(profile);
				JSONArray array=new JSONArray(arr);
				System.out.println(array);
				out.println(array);
			}
			
		}
		catch(SQLException e)
		{
			out.println(e);
		}
	}


}
