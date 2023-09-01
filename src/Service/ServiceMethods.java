package Service;

import Entity.Course;
import Entity.Section;

import java.util.List;

public class ServiceMethods {

    public void add(Section section, Course course){
        List<Section> objects= course.getSections();
        objects.add(section);
        course.setSections(objects);

    }
}
