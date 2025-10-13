import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== QUẢN LÝ THƯ VIỆN =====");
            System.out.println("1. Thêm sách mới");
            System.out.println("2. Hiển thị tất cả sách");
            System.out.println("3. Tìm sách theo tên");
            System.out.println("4. Cho mượn sách");
            System.out.println("5. Trả sách");
            System.out.println("0. Thoát");
            System.out.print("Chọn: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Nhập ID sách: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Tên sách: ");
                    String title = sc.nextLine();
                    System.out.print("Tác giả: ");
                    String author = sc.nextLine();

                    System.out.print("Loại sách (1 - TextBook, 2 - Novel, khác - thường): ");
                    int type = sc.nextInt();
                    sc.nextLine();

                    Book book;
                    if (type == 1) {
                        System.out.print("Môn học: ");
                        String subject = sc.nextLine();
                        book = new TextBook(id, title, author, subject);
                    } else if (type == 2) {
                        System.out.print("Thể loại: ");
                        String genre = sc.nextLine();
                        book = new Novel(id, title, author, genre);
                    } else {
                        book = new Book(id, title, author);
                    }

                    library.addBook(book);
                    System.out.println("Đã thêm sách thành công!");
                    break;

                case 2:
                    library.showBooks();
                    break;

                case 3:
                    System.out.print("Nhập từ khóa tên sách: ");
                    String keyword = sc.nextLine();
                    library.findBookByTitle(keyword);
                    break;

                case 4:
                    System.out.print("Nhập ID sách muốn mượn: ");
                    int borrowId = sc.nextInt();
                    library.borrowBook(borrowId);
                    break;

                case 5:
                    System.out.print("Nhập ID sách muốn trả: ");
                    int returnId = sc.nextInt();
                    library.returnBook(returnId);
                    break;

                case 0:
                    System.out.println("Thoát chương trình.");
                    sc.close();
                    return;

                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }
}
