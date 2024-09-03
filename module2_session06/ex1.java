package module2_session06;

public class ex1 {
    public static void main(String[] args) {
        String str1 = " ha ha ha hAaaaa";
        String str2 = "";
        String str3 = " concatsad a";

        System.out.println("chuỗi str1 là rỗng " + str1.isEmpty());
        System.out.println("chuỗi str2 là rỗng " + str2.isEmpty());


        System.out.println("loại bỏ khảng trắng "+ str1.trim());
        System.out.println("kiểm tra chuỗi xem có giống nhau hay không"+str1.equals(str2));
        System.out.println("kiểm tra chuỗi xem có giống nhau hay không không phân biệt hoa thường"+str1.equals(str2));

        String[] strArr = str1.split(" ");

        for (String str : strArr) {
            System.out.println(str);
        }

        String result = str2.concat(str3);
        System.out.println("nối chuỗi bằng concat"+ result);


        boolean containsWorld = str1.contains("ha");

        System.out.println("kiểm tra xem str1 có chứa chuỗi đã điền hay không" + containsWorld);
        System.out.println(" dùng để chuyển chữ thường trong chuỗi thành chữ hoa " + str1.toUpperCase());
        System.out.println(" dùng để chuyển chữ hoa trong chuỗi thành chữ thuong" + str1.toLowerCase());

        String replaceStr = str1.replace("ha", "ka");
        System.out.println(" dùng để thay thế tất cả các ký tự hoặc chuỗi cũ thành ký tự hoặc chuỗi mới" + replaceStr);
        System.out.println(" dùng để lấy được độ dài của chuỗi" + str1.length());

    }
}
