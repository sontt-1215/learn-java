import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        while (true) {
            System.out.println("\n===== QUẢN LÝ ĐIỂM SINH VIÊN =====");
            System.out.println("1. Nhập danh sách sinh viên");
            System.out.println("2. In danh sách sinh viên");
            System.out.println("3. Tính điểm trung bình cả lớp");
            System.out.println("4. Tìm sinh viên có điểm cao nhất và thấp nhất");
            System.out.println("0. Thoát");
            System.out.print("Chọn chức năng: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Nhập số lượng sinh viên: ");
                    int n = sc.nextInt();
                    sc.nextLine();
                    for (int i = 0; i < n; i++) {
                        System.out.println("\nSinh viên thứ " + (i + 1));
                        System.out.print("Tên: ");
                        String name = sc.nextLine();
                        System.out.print("Điểm: ");
                        double score = sc.nextDouble();
                        sc.nextLine();
                        students.add(new Student(name, score));
                    }
                    break;

                case 2:
                    if (students.isEmpty()) {
                        System.out.println("Chưa có dữ liệu sinh viên!");
                    } else {
                        System.out.println("\n=== DANH SÁCH SINH VIÊN ===");
                        for (Student s : students) {
                            System.out.println(s);
                        }
                    }
                    break;

                case 3:
                    if (students.isEmpty()) {
                        System.out.println("Chưa có dữ liệu để tính trung bình!");
                    } else {
                        double sum = 0;
                        for (Student s : students) {
                            sum += s.getScore();
                        }
                        double avg = sum / students.size();
                        System.out.printf("Điểm trung bình cả lớp: %.2f%n", avg);
                    }
                    break;

                case 4:
                    if (students.isEmpty()) {
                        System.out.println("Chưa có dữ liệu!");
                    } else {
                        Student max = students.get(0);
                        Student min = students.get(0);
                        for (Student s : students) {
                            if (s.getScore() > max.getScore()) max = s;
                            if (s.getScore() < min.getScore()) min = s;
                        }
                        System.out.println("Sinh viên điểm cao nhất: " + max);
                        System.out.println("Sinh viên điểm thấp nhất: " + min);
                    }
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
