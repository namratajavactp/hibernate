package ano;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.*;
import java.util.*;

@Entity
@Table(name="COURSE")
@IdClass(CoursePK.class)
public class Course {

	private long courseId;
	private String courseName;

	public Course() {
	}

	public Course(long courseId,String courseName) {
		this.courseId=courseId;
		this.courseName = courseName;
	}

	@Id
//	@GeneratedValue
	@Column(name="COURSE_ID")
	public long getCourseId() {
		return this.courseId;
	}

	public void setCourseId(long courseId) {
		this.courseId = courseId;
	}

	@Column(name="COURSE_NAME", nullable=false)
	public String getCourseName() {
		return this.courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	
	
	private Set<Student> students = new HashSet<Student>();

	
	@ManyToMany(mappedBy="courses")
	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	
	
	


}
