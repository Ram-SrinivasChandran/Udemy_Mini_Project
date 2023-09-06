package Test;

import Entity.Course;
import Entity.Lesson;
import Entity.Section;
import Service.CourseManagementServices;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is to Test the Methods which has been written in the CourseManagingServices
 * Whether the functions are working correctly or not
 */
class CourseManagementServicesTest {

    CourseManagementServices courseManagementServices = new CourseManagementServices();

    @Test
    void addSection() {
        // given
        Course course1 = new Course("Tim", "05/08/2022", 20.5, 4.5, 1, new ArrayList<>(), "Java Programming Masterclass for Software Developers");
        Section section = new Section("Intro", new ArrayList<>());
        //when
        courseManagementServices.addSection(section, course1);
        //then
        //assertion
        Assertions.assertEquals(1, course1.getSections().size());
        Assertions.assertEquals(section.getName(),course1.getSections().get(0).getName());
    }

    @Test
    void addLesson() {
        // given
        Section section = new Section("Intro", new ArrayList<>());
        String lessonName="Introduction";
        double lessonDuration=12.00;
        String lessonType="Code";
        //when
        courseManagementServices.addLesson(section,lessonName,lessonDuration,lessonType);
        //then
        //assertion
        Assertions.assertEquals(lessonName, section.getLessons().get(0).name());
        Assertions.assertEquals(lessonDuration, section.getLessons().get(0).duration());
    }

    @Test
    void removeSection() {
        // given
        Section section = new Section("Intro", new ArrayList<>());
        List<Section> sections = new ArrayList<>();
        sections.add(section);
        Course course1 = new Course("Tim", "05/08/2022", 20.5, 4.5, 1, sections, "Java Programming Masterclass for Software Developers");
        //when
        courseManagementServices.removeSection(section, course1);
        //then
        //assertion
        Assertions.assertEquals(0, course1.getSections().size());
    }

    @Test
    void getTotalSections() {
        //given
        Section section = new Section("Intro", new ArrayList<>());
        List<Section> sections = new ArrayList<>();
        sections.add(section);
        Course course1 = new Course("Tim", "05/08/2022", 20.5, 4.5, 1, sections, "Java Programming Masterclass for Software Developers");
        //when
        courseManagementServices.getTotalSections(course1);
        //then
        //assertion
        Assertions.assertEquals(1, course1.getSections().size());
    }

    @Test
    void getTotalLessons() {
        //given
        Lesson lesson = new Lesson("Introduction to variables", 12.0, "Video");
        List<Lesson> lessonList=new ArrayList<>();
        lessonList.add(lesson);
        Section section = new Section("Intro", lessonList);
        List<Section> sections = new ArrayList<>();
        sections.add(section);
        Course course1 = new Course("Tim", "05/08/2022", 20.5, 4.5, 1, sections, "Java Programming Masterclass for Software Developers");
        //when
        courseManagementServices.getTotalLessons(section);
        //then
        //assertion
        Assertions.assertEquals(1, course1.getSections().get(0).getLessons().size());
    }

    @Test
    void renameSection() {
        //given
        Section section = new Section("Intro", new ArrayList<>());
        //when
        courseManagementServices.renameSection(section,"Introduction");
        //then
        //assertion
        Assertions.assertEquals("Introduction", section.getName());
    }

    @Test
    void doesLessonNameContainKeyword() {
        //given
        Lesson lesson=new Lesson("Introduction",12.00,"Code");
        //when
        boolean contains = courseManagementServices.doesLessonNameContainKeyword(lesson.name(), "intro");
        Assertions.assertTrue(contains);
    }
}