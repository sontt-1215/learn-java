public class TextBook extends Book {
    private String subject;

    public TextBook(int id, String title, String author, String subject) {
        super(id, title, author);
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "Giáo trình: " + super.toString() + " | Môn: " + subject;
    }
}
