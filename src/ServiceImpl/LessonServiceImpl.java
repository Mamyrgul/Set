package ServiceImpl;

import database.Database;
import models.Group;
import models.Lesson;
import models.Student;
import service.LessonService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static database.Database.groups;

public class LessonServiceImpl implements LessonService {
    @Override
    public Lesson getLessonById(Long id, Long groupId) {
        Group group = new GroupServiceImpl().getGroupById(groupId);
        if (group==null){
            throw new IllegalArgumentException("Like this group doesnt exist");
        }
        for (Lesson lesson:group.getLessons()){
            if (lesson.getId().equals(id)){
                return lesson;
            }
        }
        return null;
    }

    @Override
    public void saveLesson(Long groupId, Lesson lesson) {
        Group group = new GroupServiceImpl().getGroupById(groupId);
        if (group==null){
            throw new IllegalArgumentException("Like this group doesnt exist");
        }
        for (Lesson lesson1:group.getLessons()){
            if (lesson1==null){
                throw new IllegalArgumentException("Like this lesson already exists in the group");
            }
        }
        group.getLessons().add(lesson);
        System.out.println(lesson);
    }

    @Override
    public List<Lesson> getAllLessons(Long groupId) {
        Group group = new GroupServiceImpl().getGroupById(groupId);
        if (group==null){
            throw new IllegalArgumentException("Like this group doesnt exist");
        }
       return group.getLessons();
    }

    @Override
    public Lesson getLessonByName(String name) {
     for (Group group:Database.groups){
         if (group!=null){
             for (Lesson lesson:group.getLessons()){
                 if (lesson.getLessonName().equalsIgnoreCase(name)){
                     return lesson;
                 }
             }
         }
     }throw new IllegalArgumentException("We cant found like this lesson");
    }

    @Override
    public List<Lesson> getAllLessonByGroupName(String name) {
        for (Group group:Database.groups){
            if (group.getGroupName().equalsIgnoreCase(name)){
                return group.getLessons();
            }
        }
        return null;
    }
    @Override
    public String deleteLesson(Long groupId, Long lessonId) {
       Group group = new GroupServiceImpl().getGroupById(groupId);
        if (group != null) {
            for (Lesson lesson: group.getLessons()) {
                if (lesson.getId().equals(lessonId)) {
                    group.getLessons().remove(lesson);
                    return "Successfully deleted";
                }
            }
        }
        return "Try again";
    }
}
