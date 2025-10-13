import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books;
    private ArrayList<User> users;

    public Library() {
        books = new ArrayList<>();
        users = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void showBooks() {
        if (books.isEmpty()) {
            System.out.println("Chưa có sách nào trong thư viện.");
            return;
        }
        for (Book b : books) {
            System.out.println(b);
        }
    }

    public void findBookByTitle(String keyword) {
        boolean found = false;
        for (Book b : books) {
            if (b.getTitle().toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println(b);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy sách nào có từ khóa \"" + keyword + "\"");
        }
    }

    public void borrowBook(int id) {
        for (Book b : books) {
            if (b.getId() == id) {
                if (b.isAvailable()) {
                    b.borrow();
                    System.out.println("Mượn sách \"" + b.getTitle() + "\" thành công!");
                } else {
                    System.out.println("Sách này đã được mượn!");
                }
                return;
            }
        }
        System.out.println("Không tìm thấy sách có ID = " + id);
    }

    public void returnBook(int id) {
        for (Book b : books) {
            if (b.getId() == id) {
                if (!b.isAvailable()) {
                    b.returnBook();
                    System.out.println("Trả sách \"" + b.getTitle() + "\" thành công!");
                } else {
                    System.out.println("Sách này đang có sẵn, không cần trả!");
                }
                return;
            }
        }
        System.out.println("Không tìm thấy sách có ID = " + id);
    }
}
