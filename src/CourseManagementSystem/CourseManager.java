package CourseManagementSystem;

import Entity.Course;
import Entity.Lesson;
import Entity.Section;
import Utility.CourseFileReader;
import Utility.CourseFileWriter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CourseManager {
    List<Course> courses = new ArrayList<>();
    CourseManagingMethods serviceMethods = new CourseManagingMethods();
    CourseFileWriter writer = new CourseFileWriter();
    CourseFileReader reader = new CourseFileReader();
    Scanner scanner = new Scanner(System.in).useDelimiter("\n");

    private List<Section> course(){
        Lesson lesson = new Lesson("Introduction", 12.0, "Video");
        Lesson lesson1 = new Lesson("Hello World", 0, "Code");
        Lesson lesson2 = new Lesson("Introduction to variables", 12.0, "Video");
        List<Lesson> lessonList = new ArrayList<>();
        lessonList.add(lesson);
        lessonList.add(lesson1);
        lessonList.add(lesson2);
        Section section = new Section("Introduction to Java", lessonList);
        Lesson lesson3 = new Lesson("Introduction", 25.0, "Video");
        Lesson lesson4 = new Lesson("Hello World", 0, "Code");
        Lesson lesson5 = new Lesson("Introduction to variables", 12.0, "Video");
        List<Lesson> lessonList1 = new ArrayList<>();
        lessonList1.add(lesson3);
        lessonList1.add(lesson4);
        lessonList1.add(lesson5);
        Section section1 = new Section("Java", lessonList1);
        List<Section> sectionList = new ArrayList<>();
        sectionList.add(section);
        sectionList.add(section1);
        return sectionList;
    }

    public void service() {
        courses.add(new Course("Tim", "05/08/2022", 20.5, 4.5, 1, course(), "Java Programming Masterclass for Software Developers"));
        System.out.println("Welcome to the Udemy course");
        String context = """
                1.  List of Sections.
                2.  List of Lessons in a Section.
                3.  View Total number of Sections.
                4.  View the Total number of Lessons in a Section.
                5.  Display the longest Section.
                6.  Display the smallest Section.
                7.  Display the Lesson(with the Key).
                8.  Display the longest Lesson in a Section(in terms of Duration).
                9.  Add a new Lesson to a Section.
                10. Add a new Section to the Course.
                11. Remove a Section from the Course.
                12. Edit the name of the Section.
                13. Display the Course in the file. \s
                """;
        String listOfTypes = """
                1. In Terms of Durations.
                2. In terms of Lesson Count.
                3. In Terms of Most Coding Lessons.""";
        System.out.println(context);
        boolean userInput = true;
        while (userInput) {
            System.out.print("Enter the service according to the above mentioned context List(1-13) : ");
            try {
                int input = scanner.nextInt();
                switch (input) {
                    case 0 -> System.out.println(context);
                    case 1 -> {
                        if (!courses.get(0).getSections().isEmpty()) {
                            serviceMethods.listSections(courses.get(0));
                            System.out.println("The list of Sections has been Displayed Successfully....");
                            System.out.println("Enter 0 for ContextList...");
                        } else {
                            System.out.println("The Course is Empty...");
                        }
                    }
                    case 2 -> {
                        if (!courses.get(0).getSections().isEmpty()) {
                            serviceMethods.listLessons(courses.get(0));
                            System.out.println("The list of Lessons has been Displayed Successfully....");
                            System.out.println("Enter 0 for ContextList...");
                        } else {
                            System.out.println("The Course is Empty...");
                        }

                    }
                    case 3 -> {
                        if (!courses.get(0).getSections().isEmpty()) {
                            System.out.println("Total Number of Sections: " + serviceMethods.totalSection(courses.get(0)));
                            System.out.println("The total Number of Sections has been Displayed Successfully....");
                            System.out.println("Enter 0 for ContextList...");
                        } else {
                            System.out.println("The Course is Empty...");
                        }
                    }
                    case 4 -> {
                        if (!courses.get(0).getSections().isEmpty()) {
                            serviceMethods.listSections(courses.get(0));
                            System.out.print("Enter the Section Number : ");
                            int sectionNumber = scanner.nextInt();
                            if (sectionNumber <= courses.get(0).getSections().size() && sectionNumber > 0) {
                                System.out.println("Total Number of Lessons in the Section : " + serviceMethods.totalLesson(courses.get(0).getSections().get(sectionNumber - 1)));
                            } else {
                                System.out.println("Please enter the Correct Section Number...");
                            }
                            System.out.println("The total Number of Lessons has been Displayed Successfully....");
                            System.out.println("Enter 0 for ContextList...");
                        } else {
                            System.out.println("The Course is Empty...");
                        }
                    }
                    case 5 -> {
                        if (!courses.get(0).getSections().isEmpty()) {
                            System.out.println(listOfTypes);
                            System.out.print("Enter the Function in Above Three : ");
                            int typeInput = scanner.nextInt();
                            if (typeInput > 0 && typeInput <= 3) {
                                serviceMethods.longestSection(courses.get(0), typeInput);
                                System.out.println("The Longest Section(in terms of Duration) has been Displayed Successfully....");
                                System.out.println("Enter 0 for ContextList...");
                            } else {
                                System.out.println("Enter the Correct Option.");
                            }
                        } else {
                            System.out.println("The Course is Empty...");
                        }
                    }
                    case 6 -> {
                        if (!courses.get(0).getSections().isEmpty()) {
                            System.out.println(listOfTypes);
                            System.out.print("Enter the Function in Above Three : ");
                            int typeInput = scanner.nextInt();
                            if (typeInput > 0 && typeInput <= 3) {
                                serviceMethods.smallestSection(courses.get(0), typeInput);
                                System.out.println("The Smallest Section(in terms of Duration) has been Displayed Successfully....");
                                System.out.println("Enter 0 for ContextList...");
                            } else {
                                System.out.println("Enter the Correct Option...");
                            }
                        } else {
                            System.out.println("The Course is Empty...");
                        }
                    }
                    case 7 -> {
                        if (!courses.get(0).getSections().isEmpty()) {
                            System.out.print("Enter a Keyword to Search a Lesson (Single Word) : ");
                            String keyWord = scanner.next();
                            serviceMethods.lessonNameByKey(courses.get(0), keyWord);
                            System.out.println("The Process Completed Successfully....");
                            System.out.println("Enter 0 for ContextList...");
                        } else {
                            System.out.println("The Course is Empty...");
                        }
                    }
                    case 8 -> {
                        if (!courses.get(0).getSections().isEmpty()) {
                            serviceMethods.longestLessons(courses.get(0));
                            System.out.println("The Process Completed Successfully....");
                            System.out.println("Enter 0 for ContextList...");
                        } else {
                            System.out.println("The Course is Empty...");
                        }
                    }
                    case 9 -> {
                        serviceMethods.listSections(courses.get(0));
                        System.out.print("Enter the Section Number to add a Lesson : ");
                        int sectionNumber = scanner.nextInt();
                        if (sectionNumber <= courses.get(0).getSections().size() && sectionNumber > 0) {
                            System.out.print("Enter the name of the Lesson : ");
                            String lessonName = scanner.next();
                            System.out.print("Enter the Type of the Lesson (Code or Video) : ");
                            String type = scanner.next();
                            double duration = 0;
                            if (type.equalsIgnoreCase("code") || type.equalsIgnoreCase("video")) {
                                if (type.equalsIgnoreCase("video")) {
                                    System.out.print("Enter the Duration of the Lesson(in minutes) : ");
                                    duration = scanner.nextDouble();
                                }
                                serviceMethods.addLesson(courses.get(0).getSections().get(sectionNumber - 1), lessonName, duration, type);
                                System.out.println("The Lesson Added Successfully....");
                                System.out.println("Enter 0 for ContextList...");
                            } else {
                                System.out.println("Enter Correct Video Type...");
                            }
                        } else {
                            System.out.println("Please enter the Correct Section Number...");
                        }
                    }
                    case 10 -> {
                        System.out.print("Enter the Section Name : ");
                        String sectionName = scanner.next();
                        serviceMethods.addSection(new Section(sectionName), courses.get(0));
                    }
                    case 11 -> {
                        if (!courses.get(0).getSections().isEmpty()) {
                            serviceMethods.listSections(courses.get(0));
                            System.out.print("Enter the Section Number to Remove : ");
                            int sectionNumber = scanner.nextInt();
                            if (sectionNumber <= courses.get(0).getSections().size() && sectionNumber > 0) {
                                serviceMethods.removeSection(courses.get(0).getSections().get(sectionNumber - 1), courses.get(0));
                            } else {
                                System.out.println("Please Enter the Valid Section Number...");
                            }
                        } else {
                            System.out.println("There is no Section to Remove...");
                        }
                    }
                    case 12 -> {
                        if (!courses.get(0).getSections().isEmpty()) {
                            serviceMethods.listSections(courses.get(0));
                            System.out.print("Enter the Section Number : ");
                            int sectionNumber = scanner.nextInt();
                            if (sectionNumber <= courses.get(0).getSections().size() && sectionNumber > 0) {
                                System.out.print("Enter the New Name of the Section : ");
                                String newSectionName = scanner.next();
                                serviceMethods.editSectionName(courses.get(0).getSections().get(sectionNumber - 1), newSectionName);
                                System.out.println("The Name of the Section Changed Successfully....");
                                System.out.println("Enter 0 for ContextList...");
                            } else {
                                System.out.println("Please enter the Correct Section Number...");
                            }
                        } else {
                            System.out.println("The Course is Empty...");
                        }
                    }
                    case 13 -> {
                        userInput = false;
                        writer.write(courses.get(0));
                        reader.read();
                    }
                    default -> System.out.println("Please Enter a Context Number...");
                }
            } catch (Exception e) {
                System.out.println("Please enter a valid Input....");
                scanner.next();
                System.out.println("Enter 0 for ContextList...");
            }
        }
    }
}