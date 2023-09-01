package Entity;

import java.util.ArrayList;
import java.util.List;

public class Course {
    private String author;
    private String datePublished;
    private double cost;
    private double rating;
    private int id;
    private List<Section> sections=new ArrayList<>();

    public Course(String author, String datePublished, double cost, double rating, int id,List<Section> sections) {
        this.author = author;
        this.datePublished = datePublished;
        this.cost = cost;
        this.rating = rating;
        this.id = id;
        this.sections=sections;
    }
    public Course() {
    }

    public List<Section> getSections() {
        return sections;
    }

    public void setSections(List<Section> sections) {
        this.sections = sections;
    }

    @Override
    public String toString() {
        return "Course{" +
                "author='" + author + '\'' +
                ", datePublished='" + datePublished + '\'' +
                ", cost=" + cost +
                ", rating=" + rating +
                ", id=" + id +
                ", sections=" + sections +
                '}';
    }
}