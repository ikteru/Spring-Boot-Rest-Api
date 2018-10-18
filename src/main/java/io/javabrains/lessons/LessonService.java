package io.javabrains.lessons;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LessonService {
	
	@Autowired
	private LessonRepository lessonRepository;
	
	public List<Lesson> getAllLessons(String courseId){
		return lessonRepository.findByCourseId(courseId);
	}
	
	public Lesson getLesson(String lessonId) {
		//return courses.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		return lessonRepository.findById(lessonId).orElse(null);
	}

	public void addLesson(Lesson lesson) {
		lessonRepository.save(lesson);
	}

	public void updateLesson(Lesson lesson) {
		lessonRepository.save(lesson);
		//courses.set(courses.indexOf(courses.stream().filter(t -> t.getId().equals(id)).findFirst().get()), topic);
	}

	public void deleteLesson(String id) {
		lessonRepository.deleteById(id);	
	}


}
