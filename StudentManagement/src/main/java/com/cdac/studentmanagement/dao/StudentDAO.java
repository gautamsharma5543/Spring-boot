package com.cdac.studentmanagement.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cdac.studentmanagement.model.Student;


/**
*Author :Gautam Sharma
*Date   :17-Feb-2025
*Time   :1:14:01 am
*/
@Repository
public class StudentDAO {


	@Autowired
	private JdbcTemplate jdbctemplate;
	
	public int save(Student stud) {
		String sql="INSERT INTO spring_jdbc (firstName,lastName,gender,course) VALUES (?,?,?,?)";
		return jdbctemplate.update(sql,stud.getFirstName(),stud.getLastName(),stud.getGender(),stud.getCourse());
		
	}
	
	public List<Student> listall(){
		String query="SELECT * FROM spring_jdbc";
		return jdbctemplate.query(query,new StudentRowMapper());	
	}
	
	
	public int update(Student students) {
		String sql="UPDATE spring_jdbc SET firstName=? ,lastName=?,gender=?,course=? WHERE studId=?";
		return jdbctemplate.update(sql,students.getFirstName(),students.getLastName(),students.getGender(),students.getCourse(),students.getStudId());	
	}
	
	public int delete(int studId) {
		String sql="DELETE from spring_jdbc WHERE studId=? ";
		return jdbctemplate.update(sql,studId);
	}
	
	public Student getbyid(int studId) {
		String sql ="SELECT * FROM spring_jdbc WHERE studId=?";
		return jdbctemplate.queryForObject(sql,new StudentRowMapper(),studId);
	}
	
}
