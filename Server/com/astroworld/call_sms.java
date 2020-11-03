package com.astroworld;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
 * Servlet implementation class call_sms
 */
@WebServlet("/call_sms")
public class call_sms extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public Connection connection;
	public PreparedStatement preparedStatement;
	public ResultSet resultSet;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public call_sms() {
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
		PrintWriter out=response.getWriter();
		ArrayList<Profile> arr=new ArrayList<>();
		String sql="select * from astrologer";
		try
		{
			connection=CurdOperation.createConnection();
			preparedStatement=connection.prepareStatement(sql);
			resultSet=preparedStatement.executeQuery();
			if(resultSet.next())
			{
				do
				{
					Profile x=new Profile();
					x.setName(resultSet.getString("Name"));
					x.setEmail(resultSet.getString("email"));
					x.setPhoneno(resultSet.getString("PhoneNo"));
					arr.add(x);
				}
				while(resultSet.next());
				JSONArray a=new JSONArray(arr);
				System.out.println(a);
				out.println(a);
			}
		}
		
		catch(Exception e)
		{
			
		}
	}
}
