package Utility;

import Entity.Course;
import Entity.Lesson;
import Entity.Section;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.List;

public class Writer {
    public void write(Course course) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("Java_Course.txt"))) {
            List<Section> sections = course.getSections();
            bufferedWriter.write("*  Course - " + course.getCourseName());
            int sectionCount = 1;
            for (var section :
                    sections) {
                bufferedWriter.write("\n\t#  Section " + sectionCount + " - " + section.getName());
                List<Lesson> lessons = section.getLessons();
                int lessonCount = 1;
                for (var lesson :
                        lessons) {
                    if (lesson.type().equalsIgnoreCase("video")) {
                        bufferedWriter.write("\n\t\t-->  Lesson " + lessonCount + " - " + lesson.name() + " (" + lesson.duration() + ")");
                    } else {
                        bufferedWriter.write("\n\t\t-->  Lesson " + lessonCount + " - " + lesson.name());
                    }
                    lessonCount++;
                }
                sectionCount++;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
