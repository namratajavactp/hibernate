package ano;

import hibernate.HibernateUtility;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;



 
public class Main {

	public static void main(String[] args) {

	//	Session session = HibernateUtility.getSession();
		/*
		Session session= new AnnotationConfiguration().configure("hibernate-annotation.cfg.xml").buildSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();

			Set<Course> courses = new HashSet<Course>();
			Course a=new Course(11,"Maths");
			Course b=new Course(12,"Computer Science");
			Course c=new Course(13,"java");
			courses.add(a);
			courses.add(b);
			courses.add(c);

			Student student1 = new Student("Eswar", courses);
			Student student2 = new Student("Joe", courses);
			
			Set<Student> students=new HashSet<Student>();
			students.add(student1);
			students.add(student2);
			c.setStudents(students);
			
			session.save(student1);
			session.save(student2);
			session.save(c);

			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}  */
		
		/*********************************************************************************************/
		  Session session1=null;
		try{
			
			session1= new AnnotationConfiguration().configure("hibernate-annotation.cfg.xml").buildSessionFactory().openSession();
			String sql = "Select student_id,course_id,course_name FROM student_course";
			Query query = session1.createSQLQuery(sql);

			List<Object> objectList = query.list();
			Iterator iterator = objectList.iterator();
			System.out.println("student Id\t course_id\tcourse_name");
			while(iterator.hasNext()){ 
			Object []obj = (Object[])iterator.next();
			System.out.print(obj[0]);
			System.out.print("\t"+obj[1]);
			System.out.print("\t"+obj[2]);
			System.out.println();
		    }
		}catch(Exception e){
			//tx.rollback();
			System.out.println(e.getMessage());
		}finally{
			// Actual contact insertion will happen at this step
			session1.flush();
			session1.close();

			}
		

	}
}
