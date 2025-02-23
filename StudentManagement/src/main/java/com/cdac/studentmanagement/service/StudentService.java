package com.cdac.studentmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.studentmanagement.dao.StudentDAO;
import com.cdac.studentmanagement.model.Student;

/**
*Author :Gautam Sharma
*Date   :17-Feb-2025
*Time   :1:17:05 am
*/

@Service
public class StudentService {

	@Autowired
	private StudentDAO studentDao;
	
	public int savestudent(Student stud) {
		return studentDao.save(stud);
	}
	
	public List<Student> getallstudent(){
		return studentDao.listall();
	}
	
	public int update(Student students) {
		return studentDao.update(students);	
	}
	public int delete(int studId) {
		return studentDao.delete(studId);
	}
	
	public Student getsinglestudetn(int studId) {
		return studentDao.getbyid(studId);
	}
	

}
