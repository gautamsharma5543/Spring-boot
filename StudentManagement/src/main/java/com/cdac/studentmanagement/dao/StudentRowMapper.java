package com.cdac.studentmanagement.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.cdac.studentmanagement.model.Student;

/**
*Author :Gautam Sharma
*Date   :17-Feb-2025
*Time   :1:15:29 am
*/

public class StudentRowMapper implements RowMapper<Student> {

	@Override
	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Student student =new Student();
		student.setStudId(rs.getInt("studId"));
		student.setFirstName(rs.getString("firstName"));
		student.setLastName(rs.getString("lastName"));
		student.setGender(rs.getString("gender"));
		student.setCourse(rs.getString("course"));
		return student;
		
	}
}