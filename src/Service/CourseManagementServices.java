package Service;

import Entity.Course;
import Entity.Lesson;
import Entity.Section;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * This class contains the methods to access for the usage from CourseManagement class
 */

public class CourseManagementServices {

    /**
     * This method accepts two parameters
     * @param section
     * @param course
     * This method is for adding a section inside the course
     */
    public void addSection(Section section, Course course) {
        List<Section> sections = course.getSections();
        if (hasUniqueSectionName(sections, section)) {
            sections.add(section);
            course.setSections(sections);
            System.out.println("The Section Added Successfully to the course " + course.getCourseName());
            System.out.println("Enter 0 to return to the main menu...");
        } else {
            System.out.println("The section already exists in the course...");
        }
    }

    /**
     * This method accepts four Parameters
     * @param section
     * @param lessonName
     * @param lessonDuration
     * @param lessonType
     * This method is for adding a Lesson inside the Section
     */
    public void addLesson(Section section, String lessonName, double lessonDuration, String lessonType) {
        section.getLessons().add(new Lesson(lessonName, lessonDuration, lessonType));
    }

    /**
     * This method accepts two Parameters
     * @param section
     * @param course
     * This method is to remove a Section from the course
     */
    public void removeSection(Section section, Course course) {
        List<Section> sections = course.getSections();
        sections.remove(section);
        course.setSections(sections);
        System.out.println("The Section Removed Sucessfully....");
        System.out.println("Enter 0 to return to the main menu...");
    }

    /**
     * This method is a private method accepts two parameters
     * @param sections
     * @param section
     * @return
     * Returns a boolean value
     * This methods check whether the section is already available or not
     */
    private boolean hasUniqueSectionName(List<Section> sections, Section section) {
        for (Section object : sections) {
            if (section.getName()
                    .equalsIgnoreCase(object.getName())) {
                return false;
            }
        }
        return true;
    }

    /**
     * This method accepts a Parameter
     * @param course
     * This method Displays the Section list from the course
     */
    public void displaySections(Course course) {
        List<Section> sections = course.getSections();
        var sectionCount = 1;
        for (var section :
                sections) {
            System.out.println("Section " + sectionCount + " : " + section.getName());
            sectionCount++;
        }
    }

    /**
     * This method accepts a Parameter
     * @param course
     * This method Displays the Lesson list from a Particular Section
     */
    public void displayLessons(Course course) {
        List<Section> sections = course.getSections();
        var sectionCount = 1;
        for (var section :
                sections) {
            var lessonCount = 1;
            System.out.println("Section " + sectionCount + " : " + section.getName());
            var lessons = section.getLessons();
            for (var lesson :
                    lessons) {
                System.out.println("     Lesson " + lessonCount + " : " + lesson.name());
                System.out.println("          Lesson Type     : " + lesson.type());
                if (lesson.type().equalsIgnoreCase("Video")) {
                    System.out.println("          Lesson Duration : " + lesson.duration());
                }
                lessonCount++;
            }
            sectionCount++;
        }
    }

    /**
     * This method accepts a parameter
     * @param course
     * @return
     * Return the Total count of a section
     */
    public int getTotalSections(Course course) {
        List<Section> sections = course.getSections();
        return sections.size();
    }

    /**
     * This method accepts a parameter
     * @param section
     * @return
     * Return the Total count of a lesson
     */
    public int getTotalLessons(Section section) {
        List<Lesson> lessons = section.getLessons();
        return lessons.size();
    }

    /**
     * This method accepts two parameters
     * @param section
     * @param newSectionName
     * This method replace the Section name with newSectionName
     */
    public void renameSection(Section section, String newSectionName) {
        System.out.println(" ' " + section.getName() + " '  Section Name changed in to  ' " + newSectionName + " ' ");
        section.setName(newSectionName);
    }

    /**
     * This method accepts a parameter
     * @param course
     * Displays the Longest Lesson According to the Duration
     */
    public void displayLongestLessons(Course course) {
        List<Section> sections = course.getSections();
        var sectionCount = 1;
        for (var section :
                sections) {
            System.out.println("Section " + sectionCount + " : " + section.getName());
            var lessons = section.getLessons();
            double lessonDuration = 0;
            String lessonName = " ";
            for (var lesson :
                    lessons) {
                if (lessonDuration < lesson.duration()) {
                    lessonDuration = lesson.duration();
                    lessonName = lesson.name();
                }
            }
            System.out.println("Longest Lesson in this Section : " + lessonName + " (" + lessonDuration + ") ");
            sectionCount++;
        }
    }

    /**
     * This method accepts a parameter
     * @param course
     * Displays the Longest Section According to the Duration Lesson Count or Coding Lesson Count
     */
    public void displayLongestSections(Course course, int selectOption) {
        List<Section> sections = course.getSections();
        List<String> sectionNames = new ArrayList<>();
        String longestSectionName = "";
        switch (selectOption) {
            case 1 -> {
                double lessonTotalDuration = Integer.MIN_VALUE;
                for (var section :
                        sections) {
                    double durations = 0;
                    List<Lesson> lessons = section.getLessons();
                    for (var lesson :
                            lessons) {
                        durations += lesson.duration();
                    }
                    if (lessonTotalDuration < durations) {
                        lessonTotalDuration = durations;
                        longestSectionName = section.getName();
                        sectionNames.clear();
                        sectionNames.add(longestSectionName);
                    } else if (lessonTotalDuration == durations) {
                        lessonTotalDuration = durations;
                        longestSectionName = section.getName();
                        sectionNames.add(longestSectionName);
                    }
                }
                System.out.println("Longest Section in terms of Duration is : ");
                for (var sectionName :
                        sectionNames) {
                    System.out.println(sectionName + " (" + lessonTotalDuration + ")  ");
                }
            }
            case 2 -> {
                int lessonCount = Integer.MIN_VALUE;
                for (var section :
                        sections) {
                    if (lessonCount < getTotalLessons(section)) {
                        lessonCount = getTotalLessons(section);
                        longestSectionName = section.getName();
                        sectionNames.clear();
                        sectionNames.add(longestSectionName);
                    } else if (lessonCount == getTotalLessons(section)) {
                        lessonCount = getTotalLessons(section);
                        longestSectionName = section.getName();
                        sectionNames.add(longestSectionName);
                    }
                }
                System.out.println("Longest Section in terms of Lesson Count is : ");
                for (var sectionName :
                        sectionNames) {
                    System.out.println(sectionName + " (" + lessonCount + ")  ");
                }
            }
            case 3 -> {
                long codingLessonCountInSection = Integer.MIN_VALUE;
                for (var section :
                        sections) {
                    long codingLessonCount = section.getLessons()
                            .stream()
                            .filter(lesson -> lesson.type().equalsIgnoreCase("Code"))
                            .count();
                    if (codingLessonCountInSection < codingLessonCount) {
                        codingLessonCountInSection = codingLessonCount;
                        longestSectionName = section.getName();
                        sectionNames.clear();
                        sectionNames.add(longestSectionName);
                    } else if (codingLessonCountInSection == codingLessonCount) {
                        longestSectionName = section.getName();
                        sectionNames.add(longestSectionName);
                    }
                }
                System.out.println("Longest Section in terms of Coding Lesson Count is : ");
                for (var sectionName :
                        sectionNames) {
                    System.out.println(sectionName + " (" + codingLessonCountInSection + ")  ");
                }
            }
            default -> System.out.println("Enter the Valid Option...");
        }
    }

    /**
     * This method accepts a parameter
     * @param course
     * Displays the Smallest Section According to the Duration Lesson Count or Coding Lesson Count
     */
    public void displaySmallestSections(Course course, int option) {
        List<Section> sections = course.getSections();
        List<String> sectionNames = new ArrayList<>();
      //  String smallestSectionName = "";
        switch (option) {
            case 1 -> {
                double lessonTotalDuration = Integer.MAX_VALUE;
                for (var section :
                        sections) {
                    double durations = 0;
                    List<Lesson> lessons = section.getLessons();
                    for (var lesson :
                            lessons) {
                        durations += lesson.duration();
                    }
                    if (lessonTotalDuration > durations) {
                        lessonTotalDuration = durations;
                        sectionNames.clear();
                        sectionNames.add(section.getName());
                    } else if (lessonTotalDuration == durations) {
                        sectionNames.add(section.getName());
                    }
                }
                System.out.println("Smallest Section in terms of Duration is : ");
                for (var sectionName :
                        sectionNames) {
                    System.out.println(sectionName + " (" + lessonTotalDuration + ")  ");
                }
            }
            case 2 -> {
                int lessonCount = Integer.MAX_VALUE;
                for (var section :
                        sections) {
                    if (lessonCount > getTotalLessons(section)) {
                        lessonCount = getTotalLessons(section);
                        sectionNames.clear();
                        sectionNames.add(section.getName());
                    } else if (lessonCount == getTotalLessons(section)) {
                        lessonCount = getTotalLessons(section);
                        sectionNames.add(section.getName());
                    }
                }
                System.out.println("Smallest Section in terms of Lesson Count is : ");
                for (var sectionName :
                        sectionNames) {
                    System.out.println(sectionName + " (" + lessonCount + ")  ");
                }
            }
            case 3 -> {
                long codingLessonCountInSection = Integer.MAX_VALUE;
                for (var section :
                        sections) {
                    long codingLessonCount = section.getLessons()
                            .stream()
                            .filter(lesson -> lesson.type().equalsIgnoreCase("Code"))
                            .count();
                    if (codingLessonCountInSection > codingLessonCount) {
                        codingLessonCountInSection = codingLessonCount;
                        sectionNames.clear();
                        sectionNames.add(section.getName());
                    } else if (codingLessonCountInSection==codingLessonCount) {
                        sectionNames.add(section.getName());
                    }
                }
                System.out.println("Smallest Section in terms of Coding Lesson Count is : ");
                for (var sectionName :
                        sectionNames) {
                    System.out.println(sectionName + " (" + codingLessonCountInSection + ")  ");
                }
            }
            default -> System.out.println("Enter the Valid Option...");
        }
    }

    /**
     * This method accepts two Parameters
     * @param lessonName
     * @param keyword
     * @return
     * This method check whether the keyword is contained in the lesson Name
     * Returns a boolean value
     */
    public boolean doesLessonNameContainKeyword(String lessonName, String keyword) {
        String lowerCaseKeyword = keyword.toLowerCase();
        String lowerCaseName = lessonName.toLowerCase();
        return lowerCaseName.contains(lowerCaseKeyword);
    }

    /**
     * This method accepts two Parameters
     * @param sections
     * @param keyword
     * This method display a list of Lesson with the given keyword
     */
    public void searchLessonByKeyword(List<Section> sections, String keyword) {
        List<String> lessonNames = new ArrayList<>();
        AtomicInteger count = new AtomicInteger(1);
        sections.forEach(section -> {
            List<Lesson> lessons = section.getLessons();
            lessons.forEach(lesson -> {
                String name = lesson.name();
                if (doesLessonNameContainKeyword(name, keyword)) {
                    System.out.println(count + ". " + lesson.name() + " (Section : " + section.getName() + ")");
                    count.getAndIncrement();
                    lessonNames.add(lesson.name());
                }
            });
        });
        if (lessonNames.isEmpty()) {
            System.out.println("There is no Matching Lesson to the given Keyword...");
        }
    }

}