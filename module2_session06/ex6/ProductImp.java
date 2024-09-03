package module2_session06.ex6;



import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;

public class ProductImp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Product[] products = new Product[100];
        int productCount = 0;

        while (true) {
            System.out.println("------------------------------MENU---------------------------------");
            System.out.println("1. Nhập thông tin n sản phẩm");
            System.out.println("2. Hiển thị thông tin các sản phẩm");
            System.out.println("3. Tính lợi nhuận các sản phẩm");
            System.out.println("4. Sắp xếp các sản phẩm theo lợi nhuận giảm dần");
            System.out.println("5. Thống kê các sản phẩm theo giá");
            System.out.println("6. Tìm các sản phẩm theo tên sản phẩm");
            System.out.println("7. Nhập sản phẩm");
            System.out.println("8. Bán sản phẩm");
            System.out.println("9. Cập nhật trạng thái sản phẩm");
            System.out.println("10. Thoát");
            System.out.print("Chọn chức năng: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Nhập số lượng sản phẩm cần thêm: ");
                    int n = scanner.nextInt();
                    scanner.nextLine();
                    for (int i = 0; i < n; i++) {
                        if (productCount >= products.length) {
                            System.out.println("Danh sách sản phẩm đã đầy!");
                            break;
                        }
                        Product product = new Product("", "", 0, 0, 0, "", false);
                        product.inputData(scanner, products);
                        products[productCount++] = product;
                    }
                    break;

                case 2:
                    System.out.println("Danh sách sản phẩm:");
                    for (int i = 0; i < productCount; i++) {
                        products[i].displayData();
                        System.out.println();
                    }
                    break;

                case 3:
                    System.out.println("Tính lợi nhuận các sản phẩm:");
                    for (int i = 0; i < productCount; i++) {
                        System.out.println("Mã sản phẩm: " + products[i].getProductId() + " - Lợi nhuận: " + products[i].calProfit());
                    }
                    break;

                case 4:
                    Arrays.sort(products, 0, productCount, Comparator.comparing(Product::calProfit).reversed());
                    System.out.println("Danh sách sản phẩm sau khi sắp xếp theo lợi nhuận giảm dần:");
                    for (int i = 0; i < productCount; i++) {
                        products[i].displayData();
                        System.out.println();
                    }
                    break;

                case 5:
                    System.out.print("Nhập khoảng giá (từ - đến): ");
                    float fromPrice = scanner.nextFloat();
                    float toPrice = scanner.nextFloat();
                    scanner.nextLine(); // clear buffer

                    int count = 0;
                    for (int i = 0; i < productCount; i++) {
                        if (products[i].getExportPrice() >= fromPrice && products[i].getExportPrice() <= toPrice) {
                            count++;
                        }
                    }
                    System.out.println("Số lượng sản phẩm có giá xuất trong khoảng từ " + fromPrice + " đến " + toPrice + ": " + count);
                    break;

                case 6:
                    System.out.print("Nhập tên sản phẩm để tìm: ");
                    String searchName = scanner.nextLine();
                    System.out.println("Danh sách sản phẩm theo tên \"" + searchName + "\":");
                    for (int i = 0; i < productCount; i++) {
                        if (products[i].getProductName().equalsIgnoreCase(searchName)) {
                            products[i].displayData();
                            System.out.println();
                        }
                    }
                    break;

                case 7:
                    System.out.print("Nhập mã sản phẩm và số lượng cần nhập: ");
                    String importId = scanner.nextLine();
                    int importQuantity = scanner.nextInt();
                    scanner.nextLine(); // clear buffer

                    boolean found = false;
                    for (int i = 0; i < productCount; i++) {
                        if (products[i].getProductId().equals(importId)) {
                            products[i].setQuantity(products[i].getQuantity() + importQuantity);
                            System.out.println("Đã cập nhật số lượng cho sản phẩm có mã: " + importId);
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Sản phẩm với mã " + importId + " không tồn tại.");
                    }
                    break;

                case 8:
                    System.out.print("Nhập tên sản phẩm và số lượng cần bán: ");
                    String sellName = scanner.nextLine();
                    int sellQuantity = scanner.nextInt();
                    scanner.nextLine(); 

                    boolean sold = false;
                    for (int i = 0; i < productCount; i++) {
                        if (products[i].getProductName().equalsIgnoreCase(sellName)) {
                            if (products[i].getQuantity() >= sellQuantity) {
                                products[i].setQuantity(products[i].getQuantity() - sellQuantity);
                                System.out.println("Đã bán " + sellQuantity + " sản phẩm có tên: " + sellName);
                            } else {
                                System.out.println("Số lượng bán vượt quá số lượng hiện có.");
                            }
                            sold = true;
                            break;
                        }
                    }
                    if (!sold) {
                        System.out.println("Sản phẩm với tên " + sellName + " không tồn tại.");
                    }
                    break;

                case 9:
                    System.out.print("Nhập mã sản phẩm để cập nhật trạng thái: ");
                    String statusId = scanner.nextLine();

                    boolean updated = false;
                    for (int i = 0; i < productCount; i++) {
                        if (products[i].getProductId().equals(statusId)) {
                            products[i].setStatus(!products[i].isStatus());
                            System.out.println("Trạng thái sản phẩm với mã " + statusId + " đã được cập nhật.");
                            updated = true;
                            break;
                        }
                    }
                    if (!updated) {
                        System.out.println("Sản phẩm với mã " + statusId + " không tồn tại.");
                    }
                    break;

                case 10:
                    System.out.println("Thoát chương trình.");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        }
    }
}
