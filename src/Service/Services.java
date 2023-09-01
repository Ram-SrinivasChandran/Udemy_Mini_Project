package Service;

import Entity.Course;
import Entity.Lesson;
import Entity.Section;

import java.util.ArrayList;
import java.util.List;

public class Services {
    List<Course> courses = new ArrayList<>();
    ServiceMethods serviceMethods = new ServiceMethods();

    public void courseAdd() {
        Lesson lesson = new Lesson("Introduction", 5.0, "Video");
        Lesson lesson1 = new Lesson("Hello World", 0, "Code");
        List<Lesson> lessonList=new ArrayList<>();
        lessonList.add(lesson);
        lessonList.add(lesson1);
        Section section = new Section("Introduction to Java", lessonList);
        List<Section> sectionList = new ArrayList<>();
        sectionList.add(section);
        courses.add(new Course("Tim", "05/08/2022", 20.5, 4.5, 1, sectionList));
    }

    public void service() {
        String context = """
                Welcome to the Udemy course
                1.  List of Sections.
                2.  List of Lessons in a Section.
                3.  View Total number of Sections.
                4.  View the Total number of Lessons in a Section.
                5.  Display the Sections with the most number of Lessons.
                6.  Display the longest Section(in terms of Duration/in terms of Lessons Count/in terms of most Coding Lessons).
                7.  Display the smallest Section(in terms of Duration/in terms of Lessons Count/in terms of most Coding Lessons).
                8.  Display the Lesson(with the Key).
                9.  Display the longest Lesson in a Section(in terms of Duration).
                10. Add a new Lesson to a Section.
                11. Add a new Section to the Course.
                12. Remove a Section from the Course.
                13. Edit the name of the Section.
                14. Display the Course in the file.\s
                """;
        System.out.println(context);


        serviceMethods.add(new Section("introduction to Java"), courses.get(0));
        for (var a :
                courses) {
            System.out.println(a);
        }
        System.out.println(courses.size());
    }
}