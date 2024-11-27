import ServiceImpl.GroupServiceImpl;
import ServiceImpl.LessonServiceImpl;
import ServiceImpl.StudentServiceImpl;
import database.Counter;
import database.Database;
import enams.Gender;
import models.Group;
import models.Lesson;
import models.Student;
import service.GroupService;
import service.LessonService;
import service.StudentService;
import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        GroupService groupService =new GroupServiceImpl();
        LessonService lessonService = new LessonServiceImpl();
        StudentService studentService = new StudentServiceImpl();
        Scanner scanner= new Scanner(System.in);
        Scanner scanner1= new Scanner(System.in);
        LocalDateTime now = LocalDateTime.now();
        int hours = now.getHour();
        int minutes=now.getMinute();
        System.out.println("Current hour: " + hours+":"+minutes);

        if (hours>=6 && hours<=10){
            System.out.println("Good morning");
        } else if (hours>=11 && hours<=15) {
            System.out.println("Good afternoon");
        }else if (hours>=16 && hours<=20){
            System.out.println("Good evening");
        }else if (hours>=21 && hours<=22){
            System.out.println("Good night");
        }
        String gmail="qw";
        String password= "qw";
        while (true){
            System.out.println("Welcome to our group to go into enter gmail and password");
            System.out.println("Enter gmail: ");
            String gmail1=scanner.nextLine();
            System.out.println("Enter password");
            String password1=scanner.nextLine();
        if (gmail.equals(gmail1) && password.equals(password1)) {
            while (true){
                try {
                    System.out.println("1.Group service");
                    System.out.println("2.Student service");
                    System.out.println("3.Lesson service");
                    System.out.print("Choose an option: ");
                    int choice = scanner1.nextInt();
                    scanner.nextLine();
                    switch (choice) {
                        case 1: {
                            try {
                                boolean check = true;
                                while (check) {
                                    System.out.println("1. Create group");
                                    System.out.println("2. Get all groups");
                                    System.out.println("3. Get group by name");
                                    System.out.println("4.  Delete group");
                                    System.out.println("5. Update group name");
                                    System.out.println("6. Return menu");

                                    int choice1 = scanner.nextInt();
                                    scanner.nextLine();
                                    switch (choice1) {
                                        case 1: {
                                            try {
                                                System.out.println("Group name: ");
                                                String name = scanner.nextLine();
                                                for (int i = 0; i < name.length(); i++) {
                                                    if (!Character.isLetter(name.charAt(i))) {
                                                        throw new IllegalArgumentException("Only letters");
                                                    }
                                                }
                                                System.out.println("Description: ");
                                                String description = scanner.nextLine().trim();
                                                Long id = Counter.counterGroupId();
                                                Group group = new Group(id,name, description, new ArrayList<>(), new ArrayList<>());
                                               groupService.saveGroup(group);
                                            } catch (IllegalArgumentException e) {
                                                System.out.println(e.getMessage());
                                            }
                                        }
                                        break;
                                        case 2: {
                                            System.out.println("All groups");
                                            System.out.println(groupService.getAllGroups());
                                            for (Group group : Database.groups) {
                                                if (group == null) {
                                                    System.out.println("Empty");
                                                }
                                            }
                                        }
                                        break;
                                        case 3: {
                                            System.out.println("Enter group name");
                                            String name = scanner.nextLine();
                                            System.out.println(groupService.getGroupByName(name));
                                        }
                                        break;
                                        case 4: {
                                            System.out.println("Enter id group for delete");
                                            Long id = scanner1.nextLong();
                                            scanner.nextLine();
                                            System.out.println(groupService.deleteGroup(id));
                                        }
                                        break;
                                        case 5:{
                                            try {
                                                System.out.println("Write id group to update: ");
                                                Long id = scanner1.nextLong();
                                                scanner.nextLine();

                                                System.out.println("Write name for update:");
                                                String name= scanner.nextLine();
                                                for (int i = 0; i < name.length(); i++) {
                                                    if (!Character.isLetter(name.charAt(i))){
                                                        throw new IllegalArgumentException("Write only letters");
                                                    }
                                                }

                                             Group group = new Group();
                                                group.setGroupName(name);
                                                Group updateGroup=groupService.updateGroupName(id,group);
                                                System.out.println("Successfully updated"+ updateGroup);
                                            }catch (IllegalArgumentException e){
                                                System.out.println(e.getMessage());
                                            }catch (Exception e){
                                                System.out.println("Error "+e.getMessage());
                                            }
                                        }break;
                                        case 6: {
                                            check = false;

                                            scanner1.nextLine();
                                            break;

                                        }
                                        default: {
                                            System.out.println("Some problem try again");
                                        }
                                    }
                                    if (!check) {
                                        break;
                                    }
                                }
                            } catch (Exception e) {
                                System.out.println("Try again");
                                scanner.nextLine();
                                scanner1.nextLine();
                            }
                        }

                        scanner.nextLine();
                        break;
                        case 2: {
                            try {
                                boolean check = true;
                                while (check) {
                                    System.out.println("1. Create student");
                                    System.out.println("2. Find student by firstname");
                                    System.out.println("3. Get all students by groups name");
                                    System.out.println("4. Delete student");
                                    System.out.println("5. Return to menu");

                                    int choice1 = scanner1.nextInt();
                                    scanner.nextLine();
                                    switch (choice1) {
                                        case 1: {
                                            try {
                                                System.out.println("Which group you want to add: ");
                                                Long id1=scanner1.nextLong();
                                                scanner.nextLine();
                                                Long id = Counter.studentId();
                                                System.out.println("Enter name: ");
                                                String name = scanner.nextLine();
                                                for (int i = 0; i < name.length(); i++) {
                                                    if (!Character.isLetter(name.charAt(i))) {
                                                        throw new IllegalArgumentException("Only letters");
                                                    }
                                                }
                                                System.out.println("Enter lastname");
                                                String lastName = scanner.nextLine();
                                                for (int i = 0; i < lastName.length(); i++) {
                                                    if (!Character.isLetter(lastName.charAt(i))) {
                                                        throw new IllegalArgumentException("Only letters");
                                                    }
                                                }
                                                System.out.println("Enter gmail: ");
                                                String gmail2 = scanner.nextLine();
                                                if (!gmail2.contains("@")) {
                                                    throw new IllegalArgumentException("In your gmail have to contain '@'");
                                                }
                                                System.out.println("Enter password: ");
                                                String password2 = scanner.nextLine();

                                                System.out.println("Gender male/female:");
                                                String gender = scanner.next().toUpperCase();
                                                Gender gender1 = Gender.valueOf(gender);

                                                Student student = new Student(id, name, lastName, gmail2, password2, gender1);
                                                studentService.saveStudent(id1,student);
                                            } catch (IllegalArgumentException e) {
                                                System.out.println(e.getMessage());
                                            }
                                        }
                                        break;
                                        case 2: {
                                            try {
                                                System.out.println("Enter student firstname:");
                                                String name = scanner.nextLine();
                                                for (int i = 0; i < name.length(); i++) {
                                                    if (!Character.isLetter(name.charAt(i))){
                                                        throw new IllegalArgumentException("Write only letter");
                                                    }
                                                }
                                                System.out.println(studentService.findStudentByFirsName(name));
                                            }catch (IllegalArgumentException e){
                                                System.out.println(e.getMessage());
                                            }

                                        }
                                        break;

                                        case 3: {
                                            try {
                                                System.out.println("Enter groups name: ");
                                                String name = scanner.nextLine();
                                                for (int i = 0; i < name.length(); i++) {
                                                    if (!Character.isLetter(name.charAt(i))){
                                                        throw new IllegalArgumentException("Write only letter");
                                                    }
                                                }
                                                System.out.println(studentService.getAllStudentsByGroupName(name));
                                            }catch (IllegalArgumentException e){
                                                System.out.println(e.getMessage());
                                            }
                                        }
                                        break;
                                        case 4: {
                                            try {
                                                System.out.println("Enter group id: ");
                                                Long id1= scanner1.nextLong();
                                                scanner.nextLine();
                                                System.out.println("Enter student id: ");
                                                Long id= scanner1.nextLong();
                                                scanner.nextLine();
                                                System.out.println(studentService.deleteStudent(id1, id));
                                            }catch (Exception e){
                                                System.out.println("Write only numbers: ");
                                            }
                                        }break;
                                        case 5:{
                                            check = false;
                                            break;
                                        }
                                        default: {
                                            System.out.println("Some problem try again");
                                        }
                                    }
                                    if (!check) {
                                        break;
                                    }
                                }
                            } catch (Exception e) {
                                System.out.println("Try again");
                            }
                        }

                        scanner.nextLine();
                        break;
                        case 3:{
                            try {
                                boolean check= true;
                                while (check){
                                    System.out.println("1. Create lesson");
                                    System.out.println("2. Get all lessons");
                                    System.out.println("3. Get lesson by name");
                                    System.out.println("4. Get all lesson by group name");
                                    System.out.println("5. Delete lesson");
                                    System.out.println("6. Return to menu");

                                    int choice1= scanner1.nextInt();
                                    scanner.nextLine();
                                    switch (choice1){
                                        case 1:{
                                            try {
                                                System.out.println("Which group you want to add: ");
                                                Long id= scanner1.nextLong();
                                                scanner.nextLine();
                                                Long id1=Counter.counterLessonId();
                                                System.out.println("Enter lesson name: ");
                                                String name=scanner.nextLine();
                                                for (int i = 0; i < name.length(); i++) {
                                                    if (!Character.isLetter(name.charAt(i))){
                                                        throw new IllegalArgumentException("Write only letter");
                                                    }
                                                }
                                                System.out.println("Write description: ");
                                                String description= scanner.nextLine();
                                                Lesson lesson = new Lesson(id1,name,description);
                                                lessonService.saveLesson(id,lesson);
                                            }catch (IllegalArgumentException e) {
                                                System.out.println(e.getMessage());
                                            }
                                        }break;
                                        case 2:{
                                            try {
                                                System.out.println("Write id group: ");
                                                Long id = scanner.nextLong();
                                                scanner.nextLine();
                                                System.out.println(lessonService.getAllLessons(id));
                                            }catch (Exception e){
                                                System.out.println("Error try again");
                                            }
                                        }break;
                                        case 3:{
                                            try {
                                                System.out.println("Write name lesson to find: ");
                                                String name=scanner.nextLine();
                                                for (int i = 0; i < name.length(); i++) {
                                                    if (!Character.isLetter(name.charAt(i))){
                                                        throw new IllegalArgumentException("Write only letter");
                                                    }
                                                }
                                                System.out.println(lessonService.getLessonByName(name));
                                            }catch (IllegalArgumentException e){
                                                System.out.println(e.getMessage());
                                            }
                                        }break;
                                        case 4:{
                                            try {
                                                System.out.println("Write group name: ");
                                                String name = scanner.nextLine();
                                                for (int i = 0; i < name.length(); i++) {
                                                    if (!Character.isLetter(name.charAt(i))){
                                                        throw new IllegalArgumentException("Write only letter");
                                                    }
                                                }
                                                System.out.println(lessonService.getAllLessonByGroupName(name));
                                            }catch (IllegalArgumentException e){
                                                System.out.println(e.getMessage());
                                            }
                                        }break;
                                        case 5:{
                                            try {
                                                System.out.println("Enter group id: ");
                                                Long id1= scanner.nextLong();
                                                scanner.nextLine();
                                                System.out.println("Enter student id: ");
                                                Long id= scanner.nextLong();
                                                scanner.nextLine();
                                                System.out.println(studentService.deleteStudent(id1, id));
                                            }catch (Exception e){
                                                System.out.println("Write only numbers: ");
                                            }
                                        }break;
                                        case 6: {
                                            check = false;
                                            break;
                                        }
                                        default: {
                                            System.out.println("Some problem try again");
                                        }
                                    }
                                    if (!check) {
                                        break;
                                    }
                                }
                            } catch (Exception e) {
                                System.out.println("Try again");
                            }
                        }
                        scanner.nextLine();
                        break;
                            }
                        }catch (Exception e){
                    System.out.println(e.getMessage());
                }
            }
        }else {
            System.out.println("Error try again");
        }
        }
    }
}
