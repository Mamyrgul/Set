package ServiceImpl;

import database.Database;
import enams.Gender;
import models.Group;
import models.Lesson;
import models.Student;
import service.GroupService;
import service.StudentService;

import java.util.ArrayList;
import java.util.List;

public class StudentServiceImpl implements StudentService {
    @Override
    public Student getStudentById(Long groupId, Long id) {
        Group group = new GroupServiceImpl().getGroupById(groupId);
        if (group != null) {
            for (Student student : group.getStudents()) {
                if (student.getId().equals(id)) {
                    return student;
                }
            }
        }
        throw new IllegalArgumentException("Try again");
    }

    @Override
    public void saveStudent(Long groupId, Student student) {
        Group group = new GroupServiceImpl().getGroupById(groupId);
        if (group != null) {
            group.getStudents().add(student);
            System.out.println(student);
        }
    }

    @Override
    public Student updateStudent(Long groupId, Long idStudent, Student updatedStudent) {
        Group group = new GroupServiceImpl().getGroupById(groupId);

        if (group == null) {
            throw new IllegalArgumentException("Group doesn't exist");
        }
        for (Student student : group.getStudents()) {
            if (student.getId().equals(idStudent)) {
                student.setName(updatedStudent.getName());
                student.setLastName(updatedStudent.getLastName());
                student.setGmail(updatedStudent.getGmail());
                student.setPassword(updatedStudent.getPassword());
                student.setGender(updatedStudent.getGender());
                return student;
            }
        }

        throw new IllegalArgumentException("Student with this ID  doesn't exist in group ");
    }


    @Override
    public Student findStudentByFirsName(String name) {
        for (Group group : Database.groups) {
            if (group != null) {
                for (Student student : group.getStudents()) {
                    if (student.getName().equalsIgnoreCase(name)) {
                        return student;
                    }
                }
            }
        }
        return null;
    }

    @Override
    public List<Student> getAllStudentsByGroupName(String groupName) {
        for (Group group : Database.groups) {
            if (group.getGroupName().equalsIgnoreCase(groupName)) {
                return group.getStudents();
            }
        }
        return null;
    }

    @Override
    public String deleteStudent(Long groupId, Long studentId) {
        Group group = new GroupServiceImpl().getGroupById(groupId);
        if (group != null) {
            for (Student student : group.getStudents()) {
                if (student.getId().equals(studentId)) {
                    group.getStudents().remove(student);
                    return "Successfully deleted";
                }
            }
        }
        return "Try again";
    }
}


