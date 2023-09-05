package Service;

import Entity.Course;
import Entity.Lesson;
import Entity.Section;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class ServiceMethods {

    public void addSection(Section section, Course course){
        List<Section> sections= course.getSections();
        if(isEqualSection(sections,section)) {
            sections.add(section);
            course.setSections(sections);
            System.out.println("The Section Added Successfully to the course "+course.getCourseName());
            System.out.println("Enter 0 for ContextList...");
        }
        else{
            System.out.println("The Section is already Available..");
        }
    }

    public void addLesson(Section section,String lessonName,double lessonDuration,String lessonType){
        section.getLessons().add(new Lesson(lessonName,lessonDuration,lessonType));
    }
    public void removeSection(Section section,Course course){
            List<Section> sections = course.getSections();
                sections.remove(section);
                course.setSections(sections);
                System.out.println("The Section Removed Sucessfully....");
                System.out.println("Enter 0 for ContextList...");
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
                System.out.println("          Lesson Type     : "+lesson.type());
                if(lesson.type().equalsIgnoreCase("Video")) {
                    System.out.println("          Lesson Duration : " + lesson.duration());
                }
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
            System.out.println("Longest Lesson in this Section : "+lessonName+" ("+lessonDuration+") ");
            sectionCount++;
        }
    }

    public void longestSection(Course course,int option){
        List<Section> sections= course.getSections();
        List<String> sectionNames=new ArrayList<>();
        String longestSectionName = "";
        switch (option) {
            case 1 -> {
                double lessonTotalDuration = 0;
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
                    } else if (lessonTotalDuration==durations) {
                        lessonTotalDuration = durations;
                        longestSectionName = section.getName();
                        sectionNames.add(longestSectionName);
                    }
                }
                System.out.println("Longest Section in terms of Duration is : ");
                for (var sectionName:
                     sectionNames) {
                    System.out.println(sectionName+" ("+lessonTotalDuration+")  ");
                }
            }
            case 2 -> {
                int lessonCount = 0;
                for (var section :
                        sections) {
                    if (lessonCount < totalLesson(section)) {
                        lessonCount = totalLesson(section);
                        longestSectionName = section.getName();
                        sectionNames.clear();
                        sectionNames.add(longestSectionName);
                    } else if (lessonCount==totalLesson(section)) {
                        lessonCount = totalLesson(section);
                        longestSectionName = section.getName();
                        sectionNames.add(longestSectionName);
                    }
                }
                System.out.println("Longest Section in terms of Lesson Count is : ");
                for (var sectionName:
                        sectionNames) {
                    System.out.println(sectionName+" ("+lessonCount+")  ");
                }
            }
            case 3 -> {
                long codingLessonCountInSection = 0;
                for (var section :
                        sections) {
                    long codingLessonCount = section.getLessons()
                            .stream()
                            .filter(lesson -> lesson.type().equalsIgnoreCase("Code"))
                            .count();
                    if(codingLessonCountInSection<codingLessonCount){
                        codingLessonCountInSection=codingLessonCount;
                        longestSectionName=section.getName();
                        sectionNames.clear();
                        sectionNames.add(longestSectionName);
                    }else if(codingLessonCountInSection==codingLessonCount){
                        codingLessonCountInSection=codingLessonCount;
                        longestSectionName=section.getName();
                        sectionNames.add(longestSectionName);
                    }
                }
                System.out.println("Longest Section in terms of Coding Lesson Count is : ");
                for (var sectionName:
                        sectionNames) {
                    System.out.println(sectionName+" ("+codingLessonCountInSection+")  ");
                }
            }
            default -> System.out.println("Enter the Valid Option...");
        }
    }
    public void smallestSection(Course course,int option){
        List<Section> sections= course.getSections();
        List<String> sectionNames=new ArrayList<>();
        String smallestSectionName = "";
        switch (option) {
            case 1 -> {
                double lessonTotalDuration = 9999;
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
                        smallestSectionName = section.getName();
                        sectionNames.clear();
                        sectionNames.add(smallestSectionName);
                    } else if (lessonTotalDuration==durations) {
                        lessonTotalDuration = durations;
                        smallestSectionName = section.getName();
                        sectionNames.add(smallestSectionName);
                    }
                }
                System.out.println("Smallest Section in terms of Duration is : ");
                for (var sectionName:
                        sectionNames) {
                    System.out.println(sectionName+" ("+lessonTotalDuration+")  ");
                }
            }
            case 2 -> {
                int lessonCount = 9999;
                for (var section :
                        sections) {
                    if (lessonCount > totalLesson(section)) {
                        lessonCount = totalLesson(section);
                        smallestSectionName = section.getName();
                        sectionNames.clear();
                        sectionNames.add(smallestSectionName);
                    } else if (lessonCount==totalLesson(section)) {
                        lessonCount = totalLesson(section);
                        smallestSectionName = section.getName();
                        sectionNames.add(smallestSectionName);
                    }
                }
                System.out.println("Smallest Section in terms of Lesson Count is : ");
                for (var sectionName:
                        sectionNames) {
                    System.out.println(sectionName+" ("+lessonCount+")  ");
                }
            }
            case 3 -> {
                long codingLessonCountInSection = 9999;
                for (var section :
                        sections) {
                    long codingLessonCount = section.getLessons()
                            .stream()
                            .filter(lesson -> lesson.type().equalsIgnoreCase("Code"))
                            .count();
                    if(codingLessonCountInSection > codingLessonCount){
                        codingLessonCountInSection=codingLessonCount;
                        smallestSectionName=section.getName();
                        sectionNames.clear();
                        sectionNames.add(smallestSectionName);
                    }else if(codingLessonCountInSection==codingLessonCount){
                        codingLessonCountInSection=codingLessonCount;
                        smallestSectionName=section.getName();
                        sectionNames.add(smallestSectionName);
                    }
                }
                System.out.println("Smallest Section in terms of Coding Lesson Count is : ");
                for (var sectionName:
                        sectionNames) {
                    System.out.println(sectionName+" ("+codingLessonCountInSection+")  ");
                }
            }
            default -> System.out.println("Enter the Valid Option...");
        }
    }
    public boolean isContains(String lessonName,String keyword){
        if(lessonName.contains(keyword)){
            return true;
        }
        return false;
    }

    public void lessonNameByKey(Course course,String keyword){
        List<Section> sections = course.getSections();
        List<String> lessonNames=new ArrayList<>();
        AtomicInteger count= new AtomicInteger(1);
        sections.forEach(section -> {
            List<Lesson> lessons = section.getLessons();
            lessons.forEach(lesson -> {
                String name = lesson.name();
                String lowerCaseKeyword = keyword.toLowerCase();
                String lowerCaseName = name.toLowerCase();
                if(isContains(lowerCaseName,lowerCaseKeyword)){
                    System.out.println(count+". "+lesson.name()+" (Section : "+section.getName()+")");
                    count.getAndIncrement();
                    lessonNames.add(lesson.name());
                }
            });
        });
        if(lessonNames.isEmpty()){
            System.out.println("There is no Matching Lesson to the given Keyword...");
        }
    }

}