package com.project.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.spring.Course;
import com.project.spring.repo.CourseRepository;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseRepository courseRepository;

	@Override
	public String upsert(Course course) {
		courseRepository.save(course);
		return "Success ";
	}

	@Override
	public Course getById(Integer id) {
		Optional<Course> findById = courseRepository.findById(id);
		if (findById.isPresent()) {
			return findById.get();
		}
		return null;
	}

	@Override
	public List<Course> getAllCourse() {
		return courseRepository.findAll();
	}

	@Override
	public String deleteById(Integer id) {
		if (courseRepository.existsById(id)) {
			courseRepository.deleteById(id);
			return "delete Successfully";
		} else {
			return "No record found";
		}
	}
}
