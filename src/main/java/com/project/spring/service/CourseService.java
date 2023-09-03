package com.project.spring.service;

import java.util.List;

import com.project.spring.Course;

public interface CourseService {
	public String upsert(Course course);
	
	public Course getById(Integer id);
	
	public List<Course> getAllCourse();
	
	public String deleteById(Integer id);
	
}
