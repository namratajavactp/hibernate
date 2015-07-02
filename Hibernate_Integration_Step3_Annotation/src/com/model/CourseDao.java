package com.model;

import java.util.List;

public interface CourseDao
{
	public void store(Course course);
	public void delete(Long id);
	public Course findById(Long id);
	public List<Course> findAll();
}
