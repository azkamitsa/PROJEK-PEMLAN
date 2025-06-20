public class Task {
    private String title;
    private String description;
    private int priority; // 1 (tinggi) - 5 (rendah)
    private String deadline;

    public Task(String title, String description, int priority, String deadline) {
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.deadline = deadline;
    }

    // Getter dan Setter
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public int getPriority() { return priority; }
    public String getDeadline() { return deadline; }

    @Override
    public String toString() {
        return "Task{" +
                "title='" + title + '\'' +
                ", priority=" + priority +
                ", deadline='" + deadline + '\'' +
                '}';
    }
}


