package pl.kurs.homework.task4.model;

public enum BehaviorGrade {
    EXCELLENT("Excellent"),
    VERY_GOOD("Very Good"),
    GOOD("Good"),
    SATISFACTORY("Satisfactory"),
    UNSATISFACTORY("Unsatisfactory");

    private final String description;

    BehaviorGrade(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return description;
    }
}
