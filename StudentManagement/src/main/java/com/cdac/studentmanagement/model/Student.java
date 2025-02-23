package com.cdac.studentmanagement.model;
/**
*Author :Gautam Sharma
*Date   :17-Feb-2025
*Time   :1:13:14 am
*/

public class Student {
	private int studId;
	private String firstName,lastName;
	private String gender;
	private String course;
	
	public Student() {
	}

	public Student(int studId, String firstName, String lastName, String gender, String course) {
		this.studId = studId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.course = course;
	}

	public int getStudId() {
		return studId;
	}

	public void setStudId(int studId) {
		this.studId = studId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}
}
