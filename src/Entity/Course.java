package Entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Course class Contains Name of the Course,Author name,Date Published,Cost of the Course,ID of the Course
 * It also contains a List of Sections
 */
public class Course {
    private String author;
    private String publicationDate;
    private double cost;
    private double rating;
    private int id;
    private String courseName;
    private List<Section> sections=new ArrayList<>();

    public Course(String author, String datePublished, double cost, double rating, int id,List<Section> sections,String courseName) {
        this.author = author;
        this.publicationDate = datePublished;
        this.cost = cost;
        this.rating = rating;
        this.id = id;
        this.sections=sections;
        this.courseName=courseName;
    }
    public Course() {
    }

    public List<Section> getSections() {
        return sections;
    }

    public void setSections(List<Section> sections) {
        this.sections = sections;
    }

    public String getCourseName() {
        return courseName;
    }

    @Override
    public String toString() {
        return "Course{" +
                ", courseName='" + courseName + '\'' +
                "author='" + author + '\'' +
                ", datePublished='" + publicationDate + '\'' +
                ", cost=" + cost +
                ", rating=" + rating +
                ", id=" + id +
                ", sections=" + sections +
                '}';
    }
}
