package Service;

import Entity.Course;
import Entity.Section;

import java.util.List;

public class ServiceMethods {

    public void add(Section section, Course course){
        List<Section> objects= course.getSections();
        if(Search(objects,section)) {
            objects.add(section);
            course.setSections(objects);
        }
        else{
            System.out.println("The Section is already Available..");
        }

    }
    public void remove(String section, Course course){
        List<Section> objects= course.getSections();
        Section toRemove=Search(objects,section);
        objects.remove(toRemove);
        course.setSections(objects);
    }

    private boolean Search(List<Section> objects,Section section){
        for (Section object : objects) {
            if (section.getName()
                    .equalsIgnoreCase(object.getName())) {
                return false;
            }
        }
        return true;
    }
    private Section Search(List<Section> objects,String section){
        for (Section object : objects) {
            if (section
                    .equalsIgnoreCase(object.getName())) {
                return object;
            }
        }
        System.out.println("The Section is not there...");
        return null;
    }
}
