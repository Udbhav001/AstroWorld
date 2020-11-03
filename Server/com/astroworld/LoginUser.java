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
 * Servlet implementation class LoginUser
 */
@WebServlet("/LoginUser")
public class LoginUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public Connection connection;
	public PreparedStatement preparedStatement;
	public ResultSet resultSet;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginUser() {
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
	

		response.setContentType("application/json");
		PrintWriter printWriter=response.getWriter();
		System.out.println("renu");
		String uid=request.getParameter("userid");
		String upass=request.getParameter("userpass");
		System.out.println(uid);
		System.out.println(upass);
		String sqlcheck1="select * from logindetails where userid=?";
	
		try {
			connection=CurdOperation.createConnection();
			preparedStatement=connection.prepareStatement(sqlcheck1);
			preparedStatement.setString(1, uid);
			resultSet=preparedStatement.executeQuery();
			Profile profile=new Profile();
			profile.setErrormsg(null);
			if(resultSet.next())
			{
					String pass=resultSet.getString("userpass");
					if(pass.equals(upass))
					{
						String utype=resultSet.getString("usertype");
						String ustatus=resultSet.getString("status");
						System.out.println(utype);
						System.out.println(ustatus);
						
						//String picname="profilepicture/"+resultSet.getString("picname");
						if(ustatus.equals("true"))
						{
							System.out.println("bhanu");
							if(utype.equals("Astrologer"))	
							{
								String sql="select * from astrologer where userid=?";
								profile.setUsertype("Astrologer");
								connection=CurdOperation.createConnection();
								preparedStatement=connection.prepareStatement(sql);
								preparedStatement.setString(1, uid);
								resultSet=preparedStatement.executeQuery();
								
								if(resultSet.next())
								{
									profile.setUserid(uid);
									profile.setName(resultSet.getString("Name"));
									profile.setEmail(resultSet.getString("email"));
									profile.setAddress(resultSet.getString("Address"));
									profile.setPhoneno(resultSet.getString("PhoneNo"));
									profile.setSkill(resultSet.getString("skills"));
									profile.setExperience(resultSet.getString("experience"));
									profile.setGender(resultSet.getString("Gender"));
									profile.setRegistrationno(resultSet.getString("registrationNo"));
									System.out.println(profile.getExperience());
									System.out.println(profile.getSkill());
								}
							
							}
							else if(utype.equals("User"))
							{
								String sql="select * from userdetails where userid=?";
								connection=CurdOperation.createConnection();
								preparedStatement=connection.prepareStatement(sql);
								preparedStatement.setString(1, uid);
								resultSet=preparedStatement.executeQuery();
								if(resultSet.next())
								{
									String a=resultSet.getString("Name");
									profile.setName(a);
									profile.setUsertype("User");
									profile.setAddress(resultSet.getString("Address"));
									profile.setEmail(resultSet.getString("email"));
									profile.setUserid(uid);
									profile.setGender(resultSet.getString("Gender"));
									profile.setPhoneno(resultSet.getString("PhoneNo"));
									profile.setDor(resultSet.getString("dor"));
									profile.setDob(resultSet.getString("DOB"));
									System.out.println(profile.getAddress());
								}
							}
						}
					
						else
						{
							System.out.println("renu");
							profile.setErrormsg("your status is still not varified please wait");
						}
					}
					else
					{
						String sql;
						int flag=0;
						profile.setErrormsg("User Not Found/Incorrect email or password");
						profile.setPassword(resultSet.getString("userpass"));
						profile.setUserid(uid);
						String type=resultSet.getString("usertype");
						profile.setUsertype(type);
						if(type.equals("Astrologer"))
							sql="select * from astrologer where userid=?";
						else
							sql="select * from userdetails where userid=?";
						try
						{
							Connection c=CurdOperation.createConnection();
							PreparedStatement p=c.prepareStatement(sql);
							p.setString(1, uid);
							ResultSet r=p.executeQuery();
							if(r.next())
							{
								flag=1;
								profile.setPhoneno(r.getString("PhoneNo"));
							}
							if(flag==0)
							{
								profile.setErrormsg("User Not Found/Incorrect email or password.");
							}
						}
						catch(Exception e)
						{
							System.out.println("Hello "+e);
						}
					}
				}
			
				else
					profile.setErrormsg("User Not Found/Incorrect email or password");
				ArrayList<Profile> arrayList=new ArrayList<>();
				arrayList.add(profile);
				JSONArray array=new JSONArray(arrayList);
				System.out.println(array);
				printWriter.println(array);
			}	
			catch (Exception e)
			{
				// TODO: handle exception
			}
		}

	}