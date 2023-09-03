package com.project.spring.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.spring.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer>{

}
