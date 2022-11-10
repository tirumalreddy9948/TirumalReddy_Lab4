package com.greatlearning.studentManagement.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.greatlearning.studentManagement.entity.Student;

@Service
public interface StudentService {

	public List<Student> getAllStudents();

	public void save(Student student);

	public Student findById(int id);

	public void deleteById(int id);
}
