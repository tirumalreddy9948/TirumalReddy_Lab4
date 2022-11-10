package com.greatlearning.studentManagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.studentManagement.entity.Student;
import com.greatlearning.studentManagement.respository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;

	@Override
	public List<Student> getAllStudents() {

		return studentRepository.findAll();
	}

	@Override
	public Student findById(int id) {

		Optional<Student> student = studentRepository.findById(id);

		if (student.isPresent()) {
			return student.get();
		}
		return null;

	}

	@Override
	public void save(Student student) {

		studentRepository.save(student);
	}

	@Override
	public void deleteById(int id) {

		Student student = findById(id);
		studentRepository.delete(student);
	}
//
//		@Override
//		public List<Student> searchBy(String firstName, String lastName) {
//			
//			List<Student> students =studentRepository.findByFirstNameContainsAndLastNameContainsAllIgnoreCase(firstName, lastName);
//			return null;
//		}

}
