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
        Lesson lesson = new Lesson("Introduction", 13.0, "Video");
        Lesson lesson1 = new Lesson("Hello World", 0, "Code");
        Lesson lesson2 = new Lesson("Introduction to variables", 12.0, "Video");
        List<Lesson> lessonList=new ArrayList<>();
        lessonList.add(lesson);
        lessonList.add(lesson1);
        lessonList.add(lesson2);
        Section section = new Section("Introduction to Java", lessonList);
        Lesson lesson3 = new Lesson("Introduction", 25.0, "Video");
        Lesson lesson4 = new Lesson("Hello World", 0, "Code");
        Lesson lesson5 = new Lesson("Introduction to variables", 12.0, "Video");
        List<Lesson> lessonList1=new ArrayList<>();
        lessonList1.add(lesson3);
        lessonList1.add(lesson4);
        lessonList1.add(lesson5);
        Section section1=new Section("Java",lessonList1);
        List<Section> sectionList = new ArrayList<>();
        sectionList.add(section);
        sectionList.add(section1);
        courses.add(new Course("Tim", "05/08/2022", 20.5, 4.5, 1, sectionList));
    }

    public void service() {
        String context = """
                Welcome to the Udemy course
                1.  List of Sections.
                2.  List of Lessons in a Section.
                3.  View Total number of Sections.
                4.  View the Total number of Lessons in a Section.
                5.  Display the longest Section(in terms of Duration/in terms of Lessons Count/in terms of most Coding Lessons).
                6.  Display the smallest Section(in terms of Duration/in terms of Lessons Count/in terms of most Coding Lessons).
                7.  Display the Lesson(with the Key).
                8.  Display the longest Lesson in a Section(in terms of Duration).
                9.  Add a new Lesson to a Section.
                10. Add a new Section to the Course.
                11. Remove a Section from the Course.
                12. Edit the name of the Section.
                13. Display the Course in the file.\s 
                """;
        System.out.println(context);

int sectionNumber=1;
//        serviceMethods.addSection(new Section("introduction to Java"), courses.get(0));
//        serviceMethods.removeSection("introduction to Java", courses.get(0));
//        serviceMethods.listSections(courses.get(0));

//        System.out.println(serviceMethods.totalSection(courses.get(0)));
//        serviceMethods.editSectionName(courses.get(0).getSections().get(sectionNumber-1),"New Course");
//        serviceMethods.addLesson(courses.get(0).getSections().get(sectionNumber-1),"Introduction to Condition Statement",12.0,"Video");
//        System.out.println(serviceMethods.totalLesson(courses.get(0).getSections().get(sectionNumber - 1)));
//        serviceMethods.listLessons(courses.get(0));
//        serviceMethods.listLessons(courses.get(0));
//        serviceMethods.longestSection(courses.get(0),1);
//        serviceMethods.longestSection(courses.get(0),2);
//        serviceMethods.longestSection(courses.get(0),3);
//        serviceMethods.smallestSection(courses.get(0),1);
//        serviceMethods.smallestSection(courses.get(0),2);
//        serviceMethods.smallestSection(courses.get(0),3);
        serviceMethods.lessonNameByKey(courses.get(0),"hello world");
        for (var a :
                courses) {
            System.out.println(a);
        }
        System.out.println(courses.size());
    }
}