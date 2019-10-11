package com.springjpa.course;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springjpa.topics.Topics;

@RestController
public class CourseController {
@Autowired
private CourseService courseService;
@RequestMapping("/topic/{id}/course")
public List<Course> getAllCourse(@PathVariable String id)
{
return courseService.getAllCourse(id);
}

@RequestMapping("/topic/{topicId}/course/{id}")
public Course getCourse(@PathVariable String id)
{
	return courseService.getCourse(id);
}
@RequestMapping(method=RequestMethod.POST, value="/topic/{topicId}/course")
public void addCourse(@RequestBody Course course,@PathVariable String topicId)
{
	course.setTopic(new Topics(topicId,"",""));
	courseService.addCourse(course);
}

@RequestMapping(method=RequestMethod.PUT, value="/topic/{topicId}/course/{id}")
public void updateCourse(@RequestBody Course course, @PathVariable String topicId ,@PathVariable String id)
{
	course.setTopic(new Topics(topicId,"",""));
	courseService.updateCourse(course);
}

@DeleteMapping(value="/topic/{topicId}/course/{id}")
public void deleteCourse(@PathVariable String id)
{
	
	 courseService.deleteCourse(id);
}
}
