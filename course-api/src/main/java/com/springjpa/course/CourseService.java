package com.springjpa.course;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

@Autowired	
private CourseRepositary courseRepositary;
	
	/*
	 * List<Course> course=new ArrayList<>(Arrays.asList( new
	 * Course("1","Rohit","HR"), new Course("2","Shekhar","HR"), new
	 * Course("3","Ramesh","HR") ));
	 */

public List<Course> getAllCourse(String topicId)
{
//return topics;	
	List<Course> course=new ArrayList<>();
	courseRepositary.findByTopicId(topicId).forEach(course::add);
	return course;
}

public Course getCourse(String id)
{
//	return topics.stream().filter(t -> t.getEmpid().equals(id)).findFirst().get();
	return courseRepositary.findById(id).orElse(null);
}

public void addCourse(Course course) {
	courseRepositary.save(course);
	
}

public void updateCourse(Course course) {

	courseRepositary.save(course);	
}

public void deleteCourse(String id) {
	
	courseRepositary.deleteById(id);
}


}
