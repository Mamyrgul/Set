package database;

public class Counter {
    public static Long lessonId=0L;
    public static Long counterLessonId(){
        return ++lessonId;
    }
    public static Long groupID=0L;
    public static Long counterGroupId(){
        return ++groupID;
    }
    public static Long studentId= 0L;
    public static Long studentId(){
        return ++studentId;
    }
}
