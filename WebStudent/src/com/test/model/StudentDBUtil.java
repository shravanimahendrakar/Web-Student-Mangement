package com.test.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;	
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class StudentDBUtil {
	private DataSource dataSource;

	public StudentDBUtil(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public List<Student> getStudent() throws Exception{
		List<Student> list = new ArrayList<>();
		Connection con = null;
		Statement stat = null;
		ResultSet rs = null;	

		try {
			con = dataSource.getConnection();


			String sql ="select * from student";

			stat = con.createStatement();

			rs = stat.executeQuery(sql);

			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				list.add(new Student(id,name,email)); 
			} 			
			return list;

		}finally {
			rs.close();
			stat.close();
			con.close();
		}
	}

	public void addStudent(Student s) throws Exception {
		Connection con = null;
		PreparedStatement stat = null; 
		

		try {
			con = dataSource.getConnection();


			String sql ="insert into student (name, email) values (?,?)";
			

			stat = con.prepareStatement(sql);
			stat.setString(1, s.getName());
			stat.setString(2, s.getEmail());
			
			stat.execute();

						
			

		}finally {
			
			stat.close();
			con.close();
		}
		
	}

	public Student getStudentById(String studentId) throws Exception {
		Student s = null;
		Connection con = null;
		PreparedStatement stat = null;
		ResultSet rs = null;	

		try {
			con = dataSource.getConnection();


			String sql ="select * from student where id = ?";
			int stId = Integer.parseInt(studentId);

			stat = con.prepareStatement(sql);
			stat.setInt(1, stId);

			rs = stat.executeQuery();

			if(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				s = new Student(id,name,email);
			}else {
				throw new Exception("didnt found student ");
				
			}
			return s;

		}finally {
			rs.close();
			stat.close();
			con.close();
		}
		
	}

	public void updateStudent(Student s) throws Exception{
		Connection con = null;
		PreparedStatement stat = null; 
		

		try {
			con = dataSource.getConnection();


			String sql ="update student set name=?, email=? where id=?";
			
			stat = con.prepareStatement(sql);
			stat.setString(1, s.getName());
			stat.setString(2, s.getEmail());
			stat.setInt(3, s.getId()); 
			
			stat.execute();
			
		}finally {
			
			stat.close();
			con.close();
		}
		
	}

	public void deleteStudentById(int id) throws Exception{
		Connection con = null;
		PreparedStatement stat = null; 
		

		try {
			con = dataSource.getConnection();


			String sql ="delete from student where id=?";
			
			stat = con.prepareStatement(sql);
			stat.setInt(1, id); 
			
			stat.execute();
			
		}finally {
			
			stat.close();
			con.close();
		}
		
	}
}
