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

import beans.QuestionAnswer;
import com.dbutil.CurdOperation;

/**
 * Servlet implementation class viewQuestionAstrologer
 */
@WebServlet("/viewAnswer")
public class viewAnswer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public Connection connection;
	public PreparedStatement preparedStatement;
	public ResultSet resultSet;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public viewAnswer() {
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
		ArrayList<QuestionAnswer> arr=new ArrayList<>();
		String sql="select * from question_answer where astrologerId=? and userid=?";
		String aid=request.getParameter("astroid");
		String uid=request.getParameter("userid");
		System.out.println(uid+" "+aid);
		try 
		{
			connection=CurdOperation.createConnection();
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, aid);
			preparedStatement.setString(2,uid );
			resultSet=preparedStatement.executeQuery();
			if(resultSet.next())
			{
				System.out.println(resultSet);
				do
				{
					QuestionAnswer a=new QuestionAnswer();
					a.setQuestion(resultSet.getString("Question"));
					a.setStatus(resultSet.getString("status"));
					a.setAstroid(resultSet.getString("astrologerId"));
					arr.add(a);
				}
				while(resultSet.next());
			}
			JSONArray array=new JSONArray(arr);
			System.out.println(array);
			printWriter.println(array);
		}
		catch(Exception e)
		{
			
		}
			
	}

}
