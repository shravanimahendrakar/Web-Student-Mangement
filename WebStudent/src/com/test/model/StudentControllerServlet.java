package com.test.model;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class StudentControllerServlet
 */
@WebServlet("/StudentControllerServlet")
public class StudentControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private StudentDBUtil dbUtil;
	
	@Resource(name="jdbc/web_student")
	private DataSource dataSource;
	
	

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		
		try {
			dbUtil=new StudentDBUtil(dataSource);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}



	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String cmd=request.getParameter("command");
			
			if(cmd==null) {
				cmd="LIST";
			}
			
			switch(cmd) {
			case "LIST" : getListStudent(request, response); break;
			case "ADD" : addStudent(request, response); break;
			case "LOAD" : loadStudent(request, response); break;
			case "UPDATE" : updateStudent(request, response); break;
			case "DELETE" : deleteStudent(request, response); break;
			
			default: getListStudent(request, response); break;
			
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}



	private void deleteStudent(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int id = Integer.parseInt(request.getParameter("studentId"));
		dbUtil.deleteStudentById(id);
		getListStudent(request, response);
	}



	private void updateStudent(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		int id = Integer.parseInt(request.getParameter("studentId"));
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		
		Student s = new Student(id,name,email);
		
		dbUtil.updateStudent(s);
		getListStudent(request, response);
	}



	private void loadStudent(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		String id = request.getParameter("studentId");
		
		Student s = dbUtil.getStudentById(id);
		
		request.setAttribute("student", s);
		
		RequestDispatcher dis = request.getRequestDispatcher("/updateStudent.jsp");
		
		dis.forward(request, response);
	}



	private void addStudent(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		Student s= new Student(name,email);
		
		dbUtil.addStudent(s);
		getListStudent(request, response);
		
	}



	private void getListStudent(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<Student> list = dbUtil.getStudent();
		request.setAttribute("list", list);
		
		RequestDispatcher dis = request.getRequestDispatcher("/list-student.jsp");
		
		dis.forward(request, response);
		
	}

}
