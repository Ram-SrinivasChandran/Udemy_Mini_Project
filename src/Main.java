import Service.CourseManagement;

/**
 * Main Class
 */

public class Main {
    public static void main(String[] args) {
        CourseManagement services=new CourseManagement();
        services.service();
        System.out.println("Thanks for Choosing this course...");
    }
}