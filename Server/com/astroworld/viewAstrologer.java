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

import beans.Profile;

/**
 * Servlet implementation class viewAstrologer
 */
@WebServlet("/viewAstrologer")
public class viewAstrologer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public Connection connection;
	public PreparedStatement preparedStatement;
	public ResultSet resultSet;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public viewAstrologer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("application/json");
		PrintWriter out=response.getWriter();
		String uid=request.getParameter("userid");
		System.out.println(uid);
		String sqlcheck1="select * from astrologer where userid=?";
		
		try {
			connection=CurdOperation.createConnection();
			preparedStatement=connection.prepareStatement(sqlcheck1);
			preparedStatement.setString(1, uid);
			System.out.println(preparedStatement);
			resultSet=preparedStatement.executeQuery();
			Profile profile=null;
			if(resultSet.next())
			{
				profile=new Profile();
				
				profile.setName(resultSet.getString("Name"));
				profile.setEmail(resultSet.getString("email"));
				profile.setAddress(resultSet.getString("Address"));
				profile.setPhoneno(resultSet.getString("PhoneNo"));
				profile.setSkill(resultSet.getString("skills"));
				profile.setExperience(resultSet.getString("experience"));
				profile.setGender(resultSet.getString("Gender"));
				profile.setRegistrationno(resultSet.getString("registrationNo"));
			}
			ArrayList<Profile> arrayList=new ArrayList<>();
			arrayList.add(profile);
			System.out.println(profile.getAddress());
			JSONArray array=new JSONArray(arrayList);
			System.out.println(array);
			out.println(array);
		}
		
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

}
