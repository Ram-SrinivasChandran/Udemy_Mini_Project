package Test;

import Entity.Course;
import Entity.Lesson;
import Entity.Section;
import CourseManagementSystem.CourseManagingMethods;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class CourseManagingMethodsTest {

    CourseManagingMethods serviceMethods = new CourseManagingMethods();

    @Test
    void addSection() {
        // given
        Course course1 = new Course("Tim", "05/08/2022", 20.5, 4.5, 1, new ArrayList<>(), "Java Programming Masterclass for Software Developers");
        Section section = new Section("Intro", new ArrayList<>());
        //when
        serviceMethods.addSection(section, course1);
        //then
        //assertion
        Assertions.assertEquals(1, course1.getSections().size());
    }

    @Test
    void addLesson() {
        // given
        Section section = new Section("Intro", new ArrayList<>());
        String lessonName="Introduction";
        double lessonDuration=12.00;
        String lessonType="Code";
        //when
        serviceMethods.addLesson(section,lessonName,lessonDuration,lessonType);
        //then
        //assertion
        Assertions.assertEquals(lessonName, section.getLessons().get(0).name());
    }

    @Test
    void removeSection() {
        // given
        Section section = new Section("Intro", new ArrayList<>());
        List<Section> sections = new ArrayList<>();
        sections.add(section);
        Course course1 = new Course("Tim", "05/08/2022", 20.5, 4.5, 1, sections, "Java Programming Masterclass for Software Developers");
        //when
        serviceMethods.removeSection(section, course1);
        //then
        //assertion
        Assertions.assertEquals(0, course1.getSections().size());
    }

    @Test
    void totalSection() {
        //given
        Section section = new Section("Intro", new ArrayList<>());
        List<Section> sections = new ArrayList<>();
        sections.add(section);
        Course course1 = new Course("Tim", "05/08/2022", 20.5, 4.5, 1, sections, "Java Programming Masterclass for Software Developers");
        //when
        serviceMethods.totalSection(course1);
        //then
        //assertion
        Assertions.assertEquals(1, course1.getSections().size());
    }

    @Test
    void totalLesson() {
        //given
        Lesson lesson = new Lesson("Introduction to variables", 12.0, "Video");
        List<Lesson> lessonList=new ArrayList<>();
        lessonList.add(lesson);
        Section section = new Section("Intro", lessonList);
        List<Section> sections = new ArrayList<>();
        sections.add(section);
        Course course1 = new Course("Tim", "05/08/2022", 20.5, 4.5, 1, sections, "Java Programming Masterclass for Software Developers");
        //when
        serviceMethods.totalSection(course1);
        //then
        //assertion
        Assertions.assertEquals(1, course1.getSections().get(0).getLessons().size());
    }

    @Test
    void editSectionName() {
        //given
        Section section = new Section("Intro", new ArrayList<>());
        //when
        serviceMethods.editSectionName(section,"Introduction");
        //then
        //assertion
        Assertions.assertEquals("Introduction", section.getName());
    }

    @Test
    void isContains() {
        //given
        Lesson lesson=new Lesson("Introduction",12.00,"Code");
        //when
        boolean contains = serviceMethods.isContains(lesson.name(), "intro");
        Assertions.assertTrue(contains);
    }
}