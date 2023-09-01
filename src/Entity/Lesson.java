package Entity;

public record Lesson(String name,double duration,String type) {
    @Override
    public String name() {
        return name;
    }

    @Override
    public double duration() {
        return duration;
    }

    @Override
    public String type() {
        return type;
    }

    @Override
    public String toString() {
        return "Lesson{" +
                "name='" + name + '\'' +
                ", duration=" + duration +
                ", type='" + type + '\'' +
                '}';
    }
}
