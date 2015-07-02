package com.client;

import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.model.Course;
import com.model.CourseDao;
import com.model.HibernateCourseDao;

public class Client 
{
	public static void main(String[] args) 
	{
		
		ApplicationContext ctx=new ClassPathXmlApplicationContext("Hibernate-Beans.xml");
		CourseDao courseDao = (CourseDao) ctx.getBean("hibernateCourseDao");
		
		Course course = new Course();
		course.setTitle("Core Spring");
		course.setBeginDate(new GregorianCalendar(2007, 8, 1).getTime());
		course.setEndDate(new GregorianCalendar(2007, 9, 1).getTime());
		course.setFee(1000);
		courseDao.store(course);
		
		
		Course course1 = new Course();
		course1.setTitle("Core java");
		course1.setBeginDate(new GregorianCalendar(2007, 8, 2).getTime());
		course1.setEndDate(new GregorianCalendar(2007, 9, 2).getTime());
		course1.setFee(1100);
		courseDao.store(course1);
		
		
		/*List<Course> courses = courseDao.findAll();
		System.out.println("courses are: " + courses);
		
		Long courseId = courses.get(0).getId();
		System.out.println(courseId);
		course = courseDao.findById(courseId);
		if(course!=null){
		System.out.println("Course Title: " + course.getTitle());
		System.out.println("Begin Date: " + course.getBeginDate());
		System.out.println("End Date: " + course.getEndDate());
		System.out.println("Fee: " + course.getFee());
		courseDao.delete(courseId);
		}
		*/
		
	}

}
