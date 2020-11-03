package com.astroworld;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dbutil.CurdOperation;

/**
 * Servlet implementation class Question
 */
@WebServlet("/Question")
public class Question extends HttpServlet {
	 private Connection con;
     private ResultSet rs;
     private PreparedStatement ps;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Question() {
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
		String astrologerid=request.getParameter("astroid");
		String question=request.getParameter("ques");
		String doq=request.getParameter("dofques");
		System.out.println(userid+" "+astrologerid+" "+question+" "+doq);
		String sqlInsert;
		try
		{
			sqlInsert="insert into question_answer(userid,astrologerId,Question,Date_Question,status) values (?,?,?,?,?)";
			con=CurdOperation.createConnection();
			ps=con.prepareStatement(sqlInsert);
			ps.setString(1, userid);
			ps.setString(2, astrologerid);
			ps.setString(3, question);
			ps.setString(4, doq);
			ps.setString(5, "Pending");
			int a=ps.executeUpdate();
			System.out.println(a);
			if(a>0)
			{
				System.out.println("Hello4");
				out.println("success");
				System.out.println("Login entered");
			}
		}
		catch(SQLException e)
		{
			out.println(e);
		}
	}

}
