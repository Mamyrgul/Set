package service;

import models.Lesson;
import models.Student;

import java.util.ArrayList;
import java.util.List;

public interface StudentService {
    Student getStudentById(Long groupId,Long id);
    void saveStudent(Long groupId,Student student);
    Student updateStudent(Long groupId,Long idStudent,Student student);
    Student findStudentByFirsName(String name);
    List<Student> getAllStudentsByGroupName(String groupName);
    String deleteStudent(Long groupId, Long studentId);

}
