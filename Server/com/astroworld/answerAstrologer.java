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
 * Servlet implementation class answerAstrologer
 */
@WebServlet("/answerAstrologer")
public class answerAstrologer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con;
    PreparedStatement ps;
    ResultSet resultSet;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public answerAstrologer() {
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
		String sql="Update question_answer set answer=?,Date_answer=?,status=? where userid=? and Question=?";
		try
		{
			con=CurdOperation.createConnection();
			ps=con.prepareStatement(sql);
			ps.setString(1, request.getParameter("answer"));
			ps.setString(2, request.getParameter("date"));
			ps.setString(3, "Success");
			ps.setString(4, request.getParameter("userid"));
			ps.setString(5, request.getParameter("question"));
			System.out.println(ps);
			
			int r=ps.executeUpdate();
			
			if(r>0)
			{
				out.println("Success");
			}
		}
		catch(Exception e)
		{
			
		}
		
	}

}
