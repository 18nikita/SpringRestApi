package com.project.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.spring.Course;
import com.project.spring.service.CourseService;

@RestController
public class CourseController {

	@Autowired
	private CourseService courseService;
	
	@PostMapping("/course")
	public ResponseEntity<String> saveCourse(@RequestBody Course course) {
		String status = courseService.upsert(course);
		return new ResponseEntity<>(status, HttpStatus.CREATED);	
	}
	
	@GetMapping("/course/{id}")
	public ResponseEntity<Course> getCouses(@PathVariable Integer id){
		Course course = courseService.getById(id);
		return new ResponseEntity<>(course, HttpStatus.OK);
	}
	
	@GetMapping("/courses")
	public ResponseEntity<List<Course>> getAllCourses(){
		List<Course> allCourses= courseService.getAllCourse();
		return new ResponseEntity<>(allCourses, HttpStatus.OK);	
	}
	
	@DeleteMapping("/course/{id}")
	public ResponseEntity<String> deleteCourse(@PathVariable Integer id) {
		String status = courseService.deleteById(id);
		return new ResponseEntity<>(status, HttpStatus.OK);
	}
	
	
}
