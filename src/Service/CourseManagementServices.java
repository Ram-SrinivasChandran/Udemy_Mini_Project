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
     *This method is for adding a section inside the course
     * @param section The section to added into the Course
     * @param course Course in which the section to be added
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
     * This method is for adding a Lesson inside the Section
     * @param section Lesson added into this Section
     * @param lessonName The lesson name
     * @param lessonDuration The lesson Duration
     * @param lessonType The lesson type
     */
    public void addLesson(Section section, String lessonName, double lessonDuration, String lessonType) {
        section.getLessons().add(new Lesson(lessonName, lessonDuration, lessonType));
    }

    /**
     * This method is to remove a Section from the course
     * @param section This section to removed from the Course
     * @param course The section is removed from this Course
     */
    public void removeSection(Section section, Course course) {
        List<Section> sections = course.getSections();
        sections.remove(section);
        course.setSections(sections);
        System.out.println("The Section Removed Successfully....");
        System.out.println("Enter 0 to return to the main menu...");
    }

    /**
     * This method check whether the section is already available or not
     * @param sections List of Sections in the Course
     * @param section This Section is to check whether present in the section list or not
     * @return Returns a boolean value that the Section is available in the list or not
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
     * This method Displays the Section list from the course
     * @param course This is the Course in which the Section is there
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
     * This method Displays the Lesson list from a Particular Section
     * @param course This is the Course in which the Lesson is there
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
     * This method returns the Total count of a sections
     * @param course This is the Course in which the Section is there
     * @return Return the Total count of a section
     */
    public int getTotalSections(Course course) {
        List<Section> sections = course.getSections();
        return sections.size();
    }

    /**
     * This method returns the Total count of a lessons
     * @param section This is the Course in which the Lesson is there
     * @return Return the Total count of a lesson
     */
    public int getTotalLessons(Section section) {
        List<Lesson> lessons = section.getLessons();
        return lessons.size();
    }

    /**
     * This method replace the Section name with newSectionName
     * @param section This is the Section to change the name
     * @param newSectionName The new Section Name
     */
    public void renameSection(Section section, String newSectionName) {
        System.out.println(" ' " + section.getName() + " '  Section Name changed in to  ' " + newSectionName + " ' ");
        section.setName(newSectionName);
    }

    /**
     * This method displays the Longest Lesson According to the Duration
     * @param course This is the Course in which the Lesson is there
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
     * Displays the Longest Section According to the Duration Lesson Count or Coding Lesson Count
     * @param course This is the Course in which the Sections is there
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
     * Displays the Smallest Section According to the Duration Lesson Count or Coding Lesson Count
     * @param course This is the Course in which the Section is there
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
     * This method check whether the keyword is contained in the lesson Name
     * @param lessonName Lesson name to check
     * @param keyword Keyword with which the Lesson name to be checked
     * @return Returns a boolean value Whether the key is contained in the Lesson Name or not
     */
    public boolean doesLessonNameContainKeyword(String lessonName, String keyword) {
        String lowerCaseKeyword = keyword.toLowerCase();
        String lowerCaseName = lessonName.toLowerCase();
        return lowerCaseName.contains(lowerCaseKeyword);
    }

    /**
     * This method display a list of Lesson with the given keyword
     * @param sections List of Section to take the List of Lessons
     * @param keyword Keyword with which the Lesson name to be checked
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