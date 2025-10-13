public class Novel extends Book {
    private String genre;

    public Novel(int id, String title, String author, String genre) {
        super(id, title, author);
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Tiểu thuyết: " + super.toString() + " | Thể loại: " + genre;
    }
}
