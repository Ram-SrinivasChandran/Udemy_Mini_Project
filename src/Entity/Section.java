package Entity;

import java.util.ArrayList;
import java.util.List;


public class Section{
    private String name;
    private List<Lesson> lessons=new ArrayList<>();

    public Section(String name) {
        this.name = name;
    }

    public Section(String name, List<Lesson> lessons) {
        this.name = name;
        this.lessons = lessons;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLessons(List<Lesson> lessons) {
        this.lessons = lessons;
    }

    public List<Lesson> getLessons() {
        return lessons;
    }

    @Override
    public String toString() {
        return "Section{" +
                "name='" + name + '\'' +
                ", lessons=" + lessons +
                "} " ;
    }
}
