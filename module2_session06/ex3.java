package module2_session06;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ex3 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Biểu thức chính quy để kiểm tra địa chỉ email hợp lệ
        String regex = "^[\\w-\\.]+@[\\w-\\.]+\\.[a-z]{2,6}$";

        // Yêu cầu người dùng nhập vào địa chỉ email
        System.out.print("Nhập địa chỉ email để kiểm tra: ");
        String email = scanner.nextLine();

        // Sử dụng lớp Pattern để kiểm tra
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);

        if (matcher.matches()) {
            System.out.println("Địa chỉ email hợp lệ.");
        } else {
            System.out.println("Địa chỉ email không hợp lệ.");
        }
    }

}
