package Service;

import Entity.Course;
import Entity.Lesson;
import Entity.Section;

import java.util.List;

public class ServiceMethods {

    public void addSection(Section section, Course course){
        List<Section> sections= course.getSections();
        if(isEqualSection(sections,section)) {
            sections.add(section);
            course.setSections(sections);
        }
        else{
            System.out.println("The Section is already Available..");
        }

    }

    public void addLesson(Section section,String lessonName,double lessonDuration,String lessonType){
        section.getLessons().add(new Lesson(lessonName,lessonDuration,lessonType));
    }
    public void removeSection(String section, Course course){
        List<Section> sections= course.getSections();
        Section toRemove=find(sections,section);
        sections.remove(toRemove);
        course.setSections(sections);
    }

    private boolean isEqualSection(List<Section> sections,Section section){
        for (Section object : sections) {
            if (section.getName()
                    .equalsIgnoreCase(object.getName())) {
                return false;
            }
        }
        return true;
    }
    private Section find(List<Section> sections,String sectionName){
        for (Section section : sections) {
            if (sectionName
                    .equalsIgnoreCase(section.getName())) {
                return section;
            }
        }
        System.out.println("The Section is not there...");
        return null;
    }

    public void listSections(Course course){
        List<Section> sections= course.getSections();
        var sectionCount=1;
        for (var a:
             sections) {
            System.out.println("Section "+sectionCount+" : "+a.getName());
            sectionCount++;
        }
    }
    public void listLessons(Course course){
        List<Section> sections= course.getSections();
        var sectionCount=1;
        for (var section:
             sections) {
            var lessonCount=1;
            System.out.println("Section "+sectionCount+" : "+section.getName());
            var lessons=section.getLessons();
            for (var lesson:
                 lessons) {
                System.out.println("     Lesson "+lessonCount+" : "+lesson.name());
                lessonCount++;
            }
            sectionCount++;
        }
    }
    public int totalSection(Course course){
        List<Section> sections= course.getSections();
        return sections.size();
    }
    public int totalLesson(Section section){
        List<Lesson> lessons= section.getLessons();
        return lessons.size();
    }
    public void editSectionName(Section section,String newSectionName){
        System.out.println(" ' "+section.getName()+" '  Section Name changed in to  ' "+newSectionName+" ' ");
        section.setName(newSectionName);
    }

    public void longestLessons(Course course){
        List<Section> sections= course.getSections();
        var sectionCount=1;
        for (var section:
                sections) {
            System.out.println("Section "+sectionCount+" : "+section.getName());
            var lessons=section.getLessons();
            double lessonDuration=0;
            String lessonName=" ";
            for (var lesson:
                    lessons) {
                if(lessonDuration<lesson.duration()){
                    lessonDuration=lesson.duration();
                    lessonName=lesson.name();
                }
            }
            System.out.println("Longest Lesson in the Section : "+lessonName);
            sectionCount++;
        }
    }

    public void longestSection(Course course,int option){
        List<Section> sections= course.getSections();
        switch (option) {
            case 1 -> {
                String longestSectionName = " ";
                for (var section :
                        sections) {
                    double lessonTotalDuration = 0;
                    double durations = 0;
                    List<Lesson> lessons = section.getLessons();
                    for (var lesson :
                            lessons) {
                        durations += lesson.duration();
                    }
                    if (lessonTotalDuration < durations) {
                        lessonTotalDuration = durations;
                        longestSectionName = section.getName();
                    }
                }
                System.out.println("Longest Section in terms of Duration is : " + longestSectionName);
            }
            case 2 -> {
                int lessonCount = 0;
                String longestSectionName = "";
                for (var section :
                        sections) {
                    if (lessonCount < totalLesson(section)) {
                        lessonCount = totalLesson(section);
                        longestSectionName = section.getName();
                    }
                }
                System.out.println("Longest Section in terms of Lesson Count : " + longestSectionName);
            }
            case 3 -> {
                long codingLessonCountInSection = 0;
                String longestSectionName = "";
                for (var section :
                        sections) {
                    long codingLessonCount = section.getLessons()
                            .stream()
                            .filter(lesson -> lesson.type().equalsIgnoreCase("Code"))
                            .count();
                    if(codingLessonCountInSection<codingLessonCount){
                        codingLessonCountInSection=codingLessonCount;
                        longestSectionName=section.getName();
                    }
                }

                System.out.println("Longest Section in terms of Coding Section Count : "+longestSectionName);
            }
            default -> System.out.println("Enter the Valid Number...");
        }
    }
}

