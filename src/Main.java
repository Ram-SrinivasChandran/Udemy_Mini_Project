import CourseManagementSystem.CourseManager;

public class Main {
    public static void main(String[] args) {
        CourseManager services=new CourseManager();
        services.service();
        System.out.println("Thanks for Choosing this course...");
    }
}