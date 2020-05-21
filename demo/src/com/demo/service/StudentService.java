package com.demo.service;

import java.util.List;

import com.demo.beans.Student;
import com.demo.beans.StudentExample;

public interface StudentService {

	public List<Student> getAllStudents();

	public Student getStudent(String sno);
	
	// add student by id
	public int addStudent(Student student);

	// update student by id
	public int update(Student student);

	// update student by sno
	public int update(Student student, StudentExample se);
	
	// delete student by id
	public int delete(Integer id);
	
	// delete student by sno
	public int delete(StudentExample se);
	
	

}
