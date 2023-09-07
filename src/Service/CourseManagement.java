package Service;

import Entity.Course;
import Entity.Lesson;
import Entity.Section;
import Utility.CourseFileReader;
import Utility.CourseFileWriter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * This CourseManagement class is used for make changes or display the Course contents
 */

public class CourseManagement {
    List<Course> courses = new ArrayList<>();
    CourseManagementServices courseManagementServices = new CourseManagementServices();
    CourseFileWriter courseFileWriter = new CourseFileWriter();
    CourseFileReader courseFileReader = new CourseFileReader();
    Scanner scanner = new Scanner(System.in).useDelimiter("\n");

    /**
     * This method is used to add the beginning lessons to the Section
     * This method will return a List of Sections
     * @return
     */
    private List<Section> initializeSampleCourse(){
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

    /**
     * This Method has Menu which displays in the console
     */
    public void service() {
        courses.add(new Course("Tim", "05/08/2022", 20.5, 4.5, 1, initializeSampleCourse(), "Java Programming Masterclass for Software Developers"));
        Course course=courses.get(0);
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
        String sortingOptions = """
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
                        if (!course.getSections().isEmpty()) {
                            courseManagementServices.displaySections(course);
                            System.out.println("The list of Sections has been Displayed Successfully....");
                            System.out.println("Enter 0 to return to the main menu...");
                        } else {
                            System.out.println("There are no sections in the course. Please add sections to the course first.");
                        }
                    }
                    case 2 -> {
                        if (!course.getSections().isEmpty()) {
                            courseManagementServices.displayLessons(course);
                            System.out.println("The list of Lessons has been Displayed Successfully....");
                            System.out.println("Enter 0 to return to the main menu...");
                        } else {
                            System.out.println("There are no sections in the course. Please add sections to the course first.");
                        }

                    }
                    case 3 -> {
                        if (!course.getSections().isEmpty()) {
                            System.out.println("Total Number of Sections: " + courseManagementServices.getTotalSections(course));
                            System.out.println("The total Number of Sections has been Displayed Successfully....");
                            System.out.println("Enter 0 to return to the main menu...");
                        } else {
                            System.out.println("There are no sections in the course. Please add sections to the course first.");
                        }
                    }
                    case 4 -> {
                        if (!course.getSections().isEmpty()) {
                            courseManagementServices.displaySections(course);
                            System.out.print("Enter the Section Number : ");
                            int sectionNumber = scanner.nextInt();
                            if (sectionNumber <= course.getSections().size() && sectionNumber > 0) {
                                System.out.println("Total Number of Lessons in the Section : " + courseManagementServices.getTotalLessons(course.getSections().get(sectionNumber - 1)));
                                System.out.println("The total Number of Lessons has been Displayed Successfully....");
                            } else {
                                System.out.println("Please enter the Correct Section Number...");
                            }
                            System.out.println("Enter 0 to return to the main menu...");
                        } else {
                            System.out.println("There are no sections in the course. Please add sections to the course first.");
                        }
                    }
                    case 5 -> {
                        if (!course.getSections().isEmpty()) {
                            System.out.println(sortingOptions);
                            System.out.print("Enter the desired option (1-3): ");
                            int selectedOption = scanner.nextInt();
                            if (selectedOption > 0 && selectedOption <= 3) {
                                courseManagementServices.displayLongestSections(course, selectedOption);
                                System.out.println("The Longest Section has been Displayed Successfully....");
                                System.out.println("Enter 0 to return to the main menu...");
                            } else {
                                System.out.println("Enter the Correct Option.");
                            }
                        } else {
                            System.out.println("There are no sections in the course. Please add sections to the course first.");
                        }
                    }
                    case 6 -> {
                        if (!course.getSections().isEmpty()) {
                            System.out.println(sortingOptions);
                            System.out.print("Enter the desired option (1-3): ");
                            int selectedOption = scanner.nextInt();
                            if (selectedOption > 0 && selectedOption <= 3) {
                                courseManagementServices.displaySmallestSections(course, selectedOption);
                                System.out.println("The Smallest Section has been Displayed Successfully....");
                                System.out.println("Enter 0 to return to the main menu...");
                            } else {
                                System.out.println("Enter the Correct Option...");
                            }
                        } else {
                            System.out.println("There are no sections in the course. Please add sections to the course first.");
                        }
                    }
                    case 7 -> {
                        if (!course.getSections().isEmpty()) {
                            System.out.print("Enter a Keyword to Search a Lesson : ");
                            String keyWord = scanner.next();
                            courseManagementServices.searchLessonByKeyword(course.getSections(), keyWord);
                            System.out.println("The Process Completed Successfully....");
                            System.out.println("Enter 0 to return to the main menu...");
                        } else {
                            System.out.println("There are no sections in the course. Please add sections to the course first.");
                        }
                    }
                    case 8 -> {
                        if (!course.getSections().isEmpty()) {
                            courseManagementServices.displayLongestLessons(course);
                            System.out.println("The Process Completed Successfully....");
                            System.out.println("Enter 0 to return to the main menu...");
                        } else {
                            System.out.println("There are no sections in the course. Please add sections to the course first.");
                        }
                    }
                    case 9 -> {
                        courseManagementServices.displaySections(course);
                        System.out.print("Enter the Section Number to add new Lesson : ");
                        int sectionNumber = scanner.nextInt();
                        if (sectionNumber <= course.getSections().size() && sectionNumber > 0) {
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
                                courseManagementServices.addLesson(course.getSections().get(sectionNumber - 1), lessonName, duration, type);
                                System.out.println("The Lesson has been added to the section " + course.getSections().get(sectionNumber - 1).getName() + " successfully.");
                                System.out.println("Enter 0 to return to the main menu...");
                            } else {
                                System.out.println("Please enter a correct lesson type (Code or Video).");
                            }
                        } else {
                            System.out.println("Please enter the Correct Section Number...");
                        }
                    }
                    case 10 -> {
                        System.out.print("Enter the Section Name : ");
                        String sectionName = scanner.next();
                        courseManagementServices.addSection(new Section(sectionName), course);
                    }
                    case 11 -> {
                        if (!course.getSections().isEmpty()) {
                            courseManagementServices.displaySections(course);
                            System.out.print("Enter the Section Number to Remove : ");
                            int sectionNumber = scanner.nextInt();
                            if (sectionNumber <= course.getSections().size() && sectionNumber > 0) {
                                courseManagementServices.removeSection(course.getSections().get(sectionNumber - 1), course);
                            } else {
                                System.out.println("Please Enter the Valid Section Number...");
                            }
                        } else {
                            System.out.println("There are no Section to Remove...");
                        }
                    }
                    case 12 -> {
                        if (!course.getSections().isEmpty()) {
                            courseManagementServices.displaySections(course);
                            System.out.print("Enter the Section Number : ");
                            int sectionNumber = scanner.nextInt();
                            if (sectionNumber <= course.getSections().size() && sectionNumber > 0) {
                                System.out.print("Enter the New Name of the Section : ");
                                String newSectionName = scanner.next();
                                courseManagementServices.renameSection(course.getSections().get(sectionNumber - 1), newSectionName);
                                System.out.println("The Name of the Section Changed Successfully....");
                                System.out.println("Enter 0 to return to the main menu...");
                            } else {
                                System.out.println("Please enter the Correct Section Number...");
                            }
                        } else {
                            System.out.println("There are no sections in the course. Please add sections to the course first.");
                        }
                    }
                    case 13 -> {
                        userInput = false;
                        courseFileWriter.write(course);
                        courseFileReader.read();
                    }
                    default -> System.out.println("Please Enter a Context Number...");
                }
            } catch (Exception e) {
                System.out.println("Please enter a valid Input....");
                scanner.next();
                System.out.println("Enter 0 to return to the main menu...");
            }
        }
    }
}