package io.javabrains.course;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
	
	@Autowired
	private CourseRepository courseRepository;
	
	public List<Course> getAllCourses(String id){
		
		return courseRepository.findByTopicId(id);
	}
	
	public Course getCourse(String id) {
		//return courses.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		return courseRepository.findById(id).orElse(null);
	}

	public void addCourse(Course course) {
		courseRepository.save(course);
	}

	public void updateCourse(Course course) {
		courseRepository.save(course);
		//courses.set(courses.indexOf(courses.stream().filter(t -> t.getId().equals(id)).findFirst().get()), topic);
	}

	public void deleteCourse(String id) {
		courseRepository.deleteById(id);	
	}
}
