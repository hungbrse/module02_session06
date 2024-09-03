package module2_session06.ex6;

import java.util.Scanner;

public class Product {
    private String productId;
    private String productName;
    private float importPrice;
    private float exportPrice;
    private float profit;
    private int quantity;
    private String descriptions;
    private boolean status;

    public Product(String productId, String productName, float importPrice, float exportPrice, int quantity, String descriptions, boolean status) {
        this.productId = productId;
        this.productName = productName;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.profit = calProfit();
        this.quantity = quantity;
        this.descriptions = descriptions;
        this.status = status;
    }

    public String getProductId() { return productId; }
    public void setProductId(String productId) { this.productId = productId; }

    public String getProductName() { return productName; }
    public void setProductName(String productName) { this.productName = productName; }

    public float getImportPrice() { return importPrice; }
    public void setImportPrice(float importPrice) { this.importPrice = importPrice; }

    public float getExportPrice() { return exportPrice; }
    public void setExportPrice(float exportPrice) { this.exportPrice = exportPrice; }

    public float getProfit() { return profit; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public String getDescriptions() { return descriptions; }
    public void setDescriptions(String descriptions) { this.descriptions = descriptions; }

    public boolean isStatus() { return status; }
    public void setStatus(boolean status) { this.status = status; }

    public float calProfit() {
        return exportPrice - importPrice;
    }

    public void inputData(Scanner scanner, Product[] arrProduct) {
        System.out.print("Nhập mã sản phẩm (P và 3 chữ số): ");
        String inputId = scanner.nextLine();
        while (!validateProductId(inputId, arrProduct)) {
            System.out.print("Mã sản phẩm không hợp lệ hoặc đã tồn tại. Nhập lại (P và 3 chữ số): ");
            inputId = scanner.nextLine();
        }
        this.productId = inputId;

        System.out.print("Nhập tên sản phẩm (6-50 ký tự): ");
        String inputName = scanner.nextLine();
        while (!validateProductName(inputName, arrProduct)) {
            System.out.print("Tên sản phẩm không hợp lệ hoặc đã tồn tại. Nhập lại (6-50 ký tự): ");
            inputName = scanner.nextLine();
        }
        this.productName = inputName;

        System.out.print("Nhập giá nhập (lớn hơn 0): ");
        while (!scanner.hasNextFloat()) {
            System.out.print("Giá nhập không hợp lệ. Nhập lại (lớn hơn 0): ");
            scanner.next(); // clear invalid input
        }
        float inputImportPrice = scanner.nextFloat();
        while (inputImportPrice <= 0) {
            System.out.print("Giá nhập không hợp lệ. Nhập lại (lớn hơn 0): ");
            inputImportPrice = scanner.nextFloat();
        }
        this.importPrice = inputImportPrice;

        System.out.print("Nhập giá xuất (phải lớn hơn ít nhất 20% so với giá nhập): ");
        float inputExportPrice = scanner.nextFloat();
        while (inputExportPrice < importPrice * 1.2) {
            System.out.print("Giá xuất không hợp lệ. Nhập lại (phải lớn hơn ít nhất 20% so với giá nhập): ");
            inputExportPrice = scanner.nextFloat();
        }
        this.exportPrice = inputExportPrice;

        System.out.print("Nhập số lượng sản phẩm (lớn hơn 0): ");
        int inputQuantity = scanner.nextInt();
        while (inputQuantity <= 0) {
            System.out.print("Số lượng không hợp lệ. Nhập lại (lớn hơn 0): ");
            inputQuantity = scanner.nextInt();
        }
        this.quantity = inputQuantity;

        scanner.nextLine(); // clear buffer
        System.out.print("Nhập mô tả sản phẩm: ");
        this.descriptions = scanner.nextLine();

        System.out.print("Nhập trạng thái sản phẩm (true: Đang bán, false: Không bán): ");
        this.status = scanner.nextBoolean();
    }

    // Display data
    public void displayData() {
        System.out.println("Mã sản phẩm: " + this.productId);
        System.out.println("Tên sản phẩm: " + this.productName);
        System.out.println("Giá nhập: " + this.importPrice);
        System.out.println("Giá xuất: " + this.exportPrice);
        System.out.println("Lợi nhuận: " + calProfit());
        System.out.println("Số lượng: " + this.quantity);
        System.out.println("Mô tả: " + this.descriptions);
        System.out.println("Trạng thái: " + (this.status ? "Đang bán" : "Không bán"));
    }

    private boolean validateProductId(String productId, Product[] arrProduct) {
        if (!productId.matches("^P\\d{3}$")) return false;
        for (Product product : arrProduct) {
            if (product != null && product.getProductId().equals(productId)) return false;
        }
        return true;
    }

    private boolean validateProductName(String productName, Product[] arrProduct) {
        if (productName.length() < 6 || productName.length() > 50) return false;
        for (Product product : arrProduct) {
            if (product != null && product.getProductName().equalsIgnoreCase(productName)) return false;
        }
        return true;
    }
}
