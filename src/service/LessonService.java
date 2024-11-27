package service;

import models.Lesson;

import java.util.HashSet;
import java.util.List;

public interface LessonService {
    Lesson getLessonById(Long id, Long groupId);
    void saveLesson(Long groupId, Lesson lesson);
    List<Lesson> getAllLessons(Long groupId);
    Lesson getLessonByName(String name);
    List<Lesson> getAllLessonByGroupName(String name);
    String deleteLesson(Long groupId,Long lessonId);
}
