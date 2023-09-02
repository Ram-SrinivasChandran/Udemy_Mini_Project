package Service;

import Entity.Course;
import Entity.Lesson;
import Entity.Section;

import java.util.List;

public class ServiceMethods {

    public void add(Section section, Course course){
        List<Section> objects= course.getSections();
        if(isEqual(objects,section)) {
            objects.add(section);
            course.setSections(objects);
        }
        else{
            System.out.println("The Section is already Available..");
        }

    }
    public void remove(String section, Course course){
        List<Section> objects= course.getSections();
        Section toRemove=find(objects,section);
        objects.remove(toRemove);
        course.setSections(objects);
    }

    private boolean isEqual(List<Section> objects,Section section){
        for (Section object : objects) {
            if (section.getName()
                    .equalsIgnoreCase(object.getName())) {
                return false;
            }
        }
        return true;
    }
    private Section find(List<Section> objects,String section){
        for (Section object : objects) {
            if (section
                    .equalsIgnoreCase(object.getName())) {
                return object;
            }
        }
        System.out.println("The Section is not there...");
        return null;
    }

    public void listSections(Course course){
        List<Section> objects= course.getSections();
        var sectionCount=1;
        for (var a:
             objects) {
            System.out.println("Section "+sectionCount+" : "+a.getName());
            sectionCount++;
        }
    }
    public void listLessons(Course course){
        List<Section> objects= course.getSections();
        var sectionCount=1;
        for (var section:
             objects) {
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
    public void totalSection(Course course){
        List<Section> objects= course.getSections();
        System.out.println(objects.size());
    }
    public void totalLesson(Section section){
        List<Lesson> objects= section.getLessons();
        System.out.println(objects.size());
    }
    public void editSectionName(Section section,String newSectionName){
        System.out.println(" ' "+section.getName()+" '  Section Name changed in to  ' "+newSectionName+" ' ");
        section.setName(newSectionName);
    }

}
