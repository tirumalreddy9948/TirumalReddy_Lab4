package com.greatlearning.studentManagement.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.greatlearning.studentManagement.entity.Student;
import com.greatlearning.studentManagement.service.StudentService;

@Controller
@RequestMapping("/students")
public class StudentController {

	@Autowired
	StudentService studentService;

	@RequestMapping("/list")
	public String getAllStudents(Model model) {
		List<Student> students = studentService.getAllStudents();
		model.addAttribute("Students", students);
		return "list-Students";
	}

	@RequestMapping("/showFormForAdd")
	public String formForAdd(Model model) {
		Student student = new Student();
		model.addAttribute("Student", student);
		return "Student-form";
	}

	@RequestMapping("/showFormForUpdate")
	public String showFormforUpdate(@RequestParam("studentId") int studentId, Model model) {
		Student student = studentService.findById(studentId);
		model.addAttribute("Student", student);
		return "Student-form";
	}

	@PostMapping("/save")
	public String saveStudent(@RequestParam("studentId") int studentId, @RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName, @RequestParam("course") String course,
			@RequestParam("country") String country) {

		System.out.println(studentId);
		Student student = null;
		if (studentId != 0) {
			student = studentService.findById(studentId);

		} else {
			student = new Student();
		}
		student.setFirstName(firstName);
		student.setLastName(lastName);
		student.setCourse(course);
		student.setCountry(country);

		studentService.save(student);

		return "redirect:/students/list";

	}

	@RequestMapping("/delete")
	public String deleteBook(@RequestParam("studentId") int studentId) {
		studentService.deleteById(studentId);
		return "redirect:/students/list";
	}

	@RequestMapping("/403")
	public ModelAndView handleAccessDenied(Principal user) {
		ModelAndView model = new ModelAndView();
		if (user != null)
			model.addObject("msg", "Hi " + user.getName() + ", you don't have access to perform this operation");
		else
			model.addObject("msg", "Hi, you don't have access to perform this operation");
		model.setViewName("403");
		return model;
	}

}
