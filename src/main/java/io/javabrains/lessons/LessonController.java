package io.javabrains.lessons;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.javabrains.course.Course;

@RestController
public class LessonController {
	
	@Autowired
	private LessonService lessonRepository;
	
	@GetMapping("/topics/{topicId}/courses/{courseId}/lessons")
	public List<Lesson> getAllLessons(@PathVariable String courseId) {
		
		return lessonRepository.getAllLessons(courseId);
	}
	
	@GetMapping("/topics/{topicId}/courses/{courseId}/lessons/{lessonId}")
	public Lesson getLesson(@PathVariable("lessonId") String lessonId) {
		return lessonRepository.getLesson(lessonId);
	}
	
	@PostMapping("/topics/{topicId}/courses/{courseId}/lessons")
	public void addLesson(@RequestBody Lesson lesson, @PathVariable String courseId) {
		lesson.setCourse(new Course(courseId,"","",""));
		lessonRepository.addLesson(lesson);
	}
	
	@PutMapping("/topics/{topicId}/courses/{courseId}/lessons/{lessonId}")
	public void updateCourse(@RequestBody Lesson lesson, @PathVariable String courseId) {
		lesson.setCourse(new Course(courseId,"","",""));
		lessonRepository.updateLesson(lesson);
	}
	
	@DeleteMapping("/topics/{topicId}/courses/{courseId}/lessons/{lessonId}")
	public void deleteCourse(@PathVariable("id") String lessonId) {
		lessonRepository.deleteLesson(lessonId);
	}
}
