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
import beans.QuestionAnswer;

/**
 * Servlet implementation class answerAstrologer
 */
@WebServlet("/viewuserquesans")
public class viewuserquesans extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public Connection connection;
	public PreparedStatement preparedStatement;
	public ResultSet resultSet;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public viewuserquesans() {
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
		ArrayList<QuestionAnswer> arr=new ArrayList<>();
		String sql="select * from question_answer where astrologerId=? and Question=?";
		String uid=request.getParameter("astroid");
		String a=request.getParameter("ques");
		System.out.println(uid+ " "+ a);
		try 
		{
			connection=CurdOperation.createConnection();
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, uid);
			preparedStatement.setString(2, a);
			resultSet=preparedStatement.executeQuery();
			if(resultSet.next())
			{
				System.out.println(resultSet);
				do
				{
					QuestionAnswer x=new QuestionAnswer();
					x.setQuestion(resultSet.getString("Question"));
					x.setAns(resultSet.getString("answer"));
					arr.add(x);
				}
				while(resultSet.next());
			}
			JSONArray array=new JSONArray(arr);
			System.out.println("hello "+ array);
			printWriter.println(array);
		}
		catch(Exception e)
		{
			
		}
			
		
	}

}
