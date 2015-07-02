package com.model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.HibernateUtility;

public class HibernateCourseDao implements CourseDao
{

	@Override
	public void delete(Long id) 
	{
		// TODO Auto-generated method stub
		Session session=HibernateUtility.getSession();
		Transaction tx=session.beginTransaction();
		try
		{
			tx.begin();
			Course course= (Course) session.get(com.model.Course.class, id);
			session.delete(course);
			tx.commit();
		}
		catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		finally
		{
		//	session.close();
		}
		
		
	}

	@Override
	public List<Course> findAll() {
		Session session=HibernateUtility.getSession();
		Transaction tx=session.beginTransaction();
		try
		{
			tx.begin();
			List<Course> courseList=session.createQuery("from Course").list();
			tx.commit();
			return courseList;
			
		}
		catch (Exception e)
		{
			// TODO: handle exception
			tx.rollback();
			e.printStackTrace();
			return null;
		}
		finally
		{
		//	session.close();
		}	
	
		
	}

	@Override
	public Course findById(Long id) 
	{
		Session session=HibernateUtility.getSession();
		Course course=null;
		try
		{
			course=(Course) session.get(com.model.Course.class, id);
			
		}
		catch (Exception e) {
				e.printStackTrace();
		}
		finally
		{
			//session.close();
		}
	
		// 
		return course;
	}

	@Override
	public void store(Course course)
	{
		Session session=HibernateUtility.getSession();
		Transaction tx=session.beginTransaction();
		try
		{
			tx.begin();
			session.saveOrUpdate(course);
			tx.commit();
		}
		catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		finally
		{
			//session.close();
		}
	
		
	}
	

}
