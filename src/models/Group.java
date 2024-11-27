package models;

import java.util.List;

public class Group {
  private Long id;
  private String groupName;
  private String description;
  private List<Student> students;
  private List<Lesson> lessons;
    public Group(){};
    public Group(Long id,String groupName, String description, List<Student> students,List<Lesson>lessons) {
        this.id=id;
        this.groupName = groupName;
        this.description = description;
        this.students = students;
        this.lessons = lessons;
    }

    public Long getId() {
        return id;
    }

    public List<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(List<Lesson> lessons) {
        this.lessons = lessons;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return
                "\nID:                    " + id +
                "\nGroup name:            " + groupName +
                "\nDescription:           " + description +
                "\nStudents:              " + students +
                "\nLessons:               " + lessons ;
    }
}
