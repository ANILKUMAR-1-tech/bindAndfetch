 package com.example2MVC;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example2MVC.bind.StudentBind;
import com.example2MVC.model.Student;
import com.example2MVC.model.StudentData66;
import com.example2MVC.repository.StudentRepo;

import ch.qos.logback.core.joran.util.beans.BeanUtil;


@Controller
public class Controller2 {
	
	@Autowired
	private StudentRepo repo;
	@ModelAttribute
	public void modelData(org.springframework.ui.Model m) {
		m.addAttribute("name", "student");
	}

	@GetMapping("/home")
	public String home() {
		return "welcome";
	}
	
	@GetMapping("/add")
	public String add(@RequestParam("num1") int i,@RequestParam("num2") int j, org.springframework.ui.Model m) {
	  
	
		int num3=i+j;
		 m.addAttribute("num3", num3);
		
		return "result";
	}
	
	@PostMapping("/addStudent")
	public String addStudent(@ModelAttribute("student") Student s) {
		 return "result";
		
	}
	@GetMapping("/getStudents")
	public String getStudents(org.springframework.ui.Model m) {
		List<Student> students= Arrays.asList(new Student(101,"anil"),new Student(102,"naresh"));
		m.addAttribute("students",students);
		return "showStudents";
	}
	
	@GetMapping("/loadForm")
	public String loadForm(org.springframework.ui.Model model) {
		repeatedData(model);
		return "studentform";
	}

	private void repeatedData(org.springframework.ui.Model model) {
		StudentBind bind=new StudentBind();
		List<String> courseList=Arrays.asList("java","python","sql","spring");
		List<String> timings=Arrays.asList("morning","afternoon","evening");
	   model.addAttribute("courses",courseList);
	   model.addAttribute("timings",timings);
	   model.addAttribute("student",bind);
	}
	
	@PostMapping("/submitForm")
	public String submitStudent(@ModelAttribute StudentBind student,org.springframework.ui.Model model)
	{
	  StudentData66 data= new StudentData66();
	 BeanUtils.copyProperties(student, data);
	 data.setTimings(List.of(student.getTimings()));
	  repo.save(data);
	  String message="Data saved";
	  model.addAttribute("msg",message);
		repeatedData(model);
		return "studentform";
	}
	
	@GetMapping("/fetchAll")
	public String findAll(Model model) {
		List<StudentData66> data=repo.findAll();
		model.addAttribute("student",data);
		return "submitPage";
	}
	
	@GetMapping("/fetchByTimings")
	public String fetchByTimings(Model model) {
		List<String> timings=Arrays.asList("afternoon");
		List<StudentData66> studentsTimgs=repo.findByTimings(timings);
		model.addAttribute("student",studentsTimgs);
		return "submitPage";
	}
	@GetMapping("/findByTimings")
	public String findByTimings(Model model) {
		List<String> timings=Arrays.asList("afternoon","evening");
		List<StudentData66> studentsTimgs=repo.findByTimingsIn(timings);
		model.addAttribute("student",studentsTimgs);
		return "submitPage";
	}
}
