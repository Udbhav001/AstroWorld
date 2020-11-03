package com.astroworld;

import java.io.IOException;

import java.io.PrintWriter;

import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import com.dbutil.CurdOperation;
import beans.Profile;

import java.sql.*;

/**
 * Servlet implementation class AskQuestions
 */
@WebServlet("/AskQuestions")
public class AskQuestions extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public Connection connection;
	public PreparedStatement preparedStatement;
	public ResultSet resultSet;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AskQuestions() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

	response.setContentType("application/json");
		
		PrintWriter printWriter = response.getWriter();
		System.out.println("renu");

		String sqlcheck1 = "select * from logindetails where usertype=? and status=?";

		try {
			connection = CurdOperation.createConnection();
			preparedStatement = connection.prepareStatement(sqlcheck1);
			preparedStatement.setString(1, "Astrologer");
			preparedStatement.setString(2, "true");
			System.out.println("neeraj");
			resultSet = preparedStatement.executeQuery();
			
			ArrayList<String> arrayList = new ArrayList<>();
			if (resultSet.next()) {
				do {System.out.println("udbhav");
					String uid = resultSet.getString("userid");

					System.out.println(uid);
					
					arrayList.add(uid);
				} while (resultSet.next());

			} else {
				
				arrayList.add("User Not Found/Incorrect email or password");
				printWriter.println("Fail");
			}
			
			
			JSONArray array = new JSONArray(arrayList);
			 System.out.println("bhanu");
			 System.out.println(array.get(0));
			 System.out.println(array.get(1));
			printWriter.println(array);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
