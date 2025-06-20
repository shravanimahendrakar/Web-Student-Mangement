package com.test.jdbc;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.mysql.cj.protocol.Resultset;

/**
 * Servlet implementation class JdbcTest
 */
@WebServlet("/JdbcTest")
public class JdbcTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Resource(name="jdbc/web_student")
	private DataSource dataSource;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JdbcTest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	  PrintWriter out = response.getWriter();
	  response.setContentType("text/plain");	
	  
	  Connection con = null;
	  Statement stat = null;
	  ResultSet rs = null;
	  
	  try {
		  con = dataSource.getConnection();
		  
		  String sql ="select * from student";
		  stat = con.createStatement();
		  
		  rs = stat.executeQuery(sql);
		  
		  while(rs.next()) {
			  String email = rs.getString("email");
			  out.println(email);
		  }
		  
		  
	  }catch(Exception ex) {
		  ex.printStackTrace();
	  }
			  
			 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
