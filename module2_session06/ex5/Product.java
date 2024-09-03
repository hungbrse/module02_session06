package module2_session06.ex5;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


public class Product {
    private String productId;
    private String productName;
    private float price;
    private String description;
    private Date created;
    private String catalogName;
    private int productStatus;

    // Constructor
    public Product(String productId, String productName, float price, String description, Date created, String catalogName, int productStatus) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.description = description;
        this.created = created;
        this.catalogName = catalogName;
        this.productStatus = productStatus;
    }

    // Getters and Setters
    public String getProductId() { return productId; }
    public void setProductId(String productId) { this.productId = productId; }

    public String getProductName() { return productName; }
    public void setProductName(String productName) { this.productName = productName; }

    public float getPrice() { return price; }
    public void setPrice(float price) { this.price = price; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Date getCreated() { return created; }
    public void setCreated(Date created) { this.created = created; }

    public String getCatalogName() { return catalogName; }
    public void setCatalogName(String catalogName) { this.catalogName = catalogName; }

    public int getProductStatus() { return productStatus; }
    public void setProductStatus(int productStatus) { this.productStatus = productStatus; }

    // Validate methods
    private boolean validateProductId(String productId) {
        return productId.matches("^[CSA]\\d{3}$");
    }

    private boolean validateProductName(String productName) {
        return productName.length() >= 10 && productName.length() <= 50;
    }

    private boolean validatePrice(float price) {
        return price > 0;
    }

    private boolean validateCreatedDate(String createdDate) {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        format.setLenient(false);
        try {
            format.parse(createdDate);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    private boolean validateCatalogName(String catalogName) {
        return catalogName != null && !catalogName.trim().isEmpty();
    }

    private boolean validateProductStatus(int productStatus) {
        return productStatus >= 0 && productStatus <= 2;
    }

    // Input data method
    public void inputData() {
        Scanner scanner = new Scanner(System.in);

        // Product ID
        System.out.print("Nhập mã sản phẩm (C/S/A theo sau là 3 chữ số): ");
        String inputId = scanner.nextLine();
        while (!validateProductId(inputId)) {
            System.out.print("Mã sản phẩm không hợp lệ. Nhập lại (C/S/A theo sau là 3 chữ số): ");
            inputId = scanner.nextLine();
        }
        this.productId = inputId;

        // Product Name
        System.out.print("Nhập tên sản phẩm (10-50 ký tự): ");
        String inputName = scanner.nextLine();
        while (!validateProductName(inputName)) {
            System.out.print("Tên sản phẩm không hợp lệ. Nhập lại (10-50 ký tự): ");
            inputName = scanner.nextLine();
        }
        this.productName = inputName;

        // Price
        System.out.print("Nhập giá sản phẩm (lớn hơn 0): ");
        while (!scanner.hasNextFloat()) {
            System.out.print("Giá không hợp lệ. Nhập lại (lớn hơn 0): ");
            scanner.next(); // clear the invalid input
        }
        float inputPrice = scanner.nextFloat();
        while (!validatePrice(inputPrice)) {
            System.out.print("Giá không hợp lệ. Nhập lại (lớn hơn 0): ");
            inputPrice = scanner.nextFloat();
        }
        this.price = inputPrice;

        // Description
        scanner.nextLine(); // clear the buffer
        System.out.print("Nhập mô tả sản phẩm: ");
        this.description = scanner.nextLine();

        // Created Date
        System.out.print("Nhập ngày nhập (dd/MM/yyyy): ");
        String inputDate = scanner.nextLine();
        while (!validateCreatedDate(inputDate)) {
            System.out.print("Ngày không hợp lệ. Nhập lại (dd/MM/yyyy): ");
            inputDate = scanner.nextLine();
        }
        try {
            this.created = new SimpleDateFormat("dd/MM/yyyy").parse(inputDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        // Catalog Name
        System.out.print("Nhập tên danh mục: ");
        String inputCatalog = scanner.nextLine();
        while (!validateCatalogName(inputCatalog)) {
            System.out.print("Tên danh mục không hợp lệ. Nhập lại: ");
            inputCatalog = scanner.nextLine();
        }
        this.catalogName = inputCatalog;

        // Product Status
        System.out.print("Nhập trạng thái sản phẩm (0: Đang bán, 1: Hết hàng, 2: Không bán): ");
        while (!scanner.hasNextInt()) {
            System.out.print("Trạng thái không hợp lệ. Nhập lại (0: Đang bán, 1: Hết hàng, 2: Không bán): ");
            scanner.next(); // clear the invalid input
        }
        int inputStatus = scanner.nextInt();
        while (!validateProductStatus(inputStatus)) {
            System.out.print("Trạng thái không hợp lệ. Nhập lại (0: Đang bán, 1: Hết hàng, 2: Không bán): ");
            inputStatus = scanner.nextInt();
        }
        this.productStatus = inputStatus;
    }

    // Display data method
    public void displayData() {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("Mã sản phẩm: " + this.productId);
        System.out.println("Tên sản phẩm: " + this.productName);
        System.out.println("Giá: " + this.price);
        System.out.println("Mô tả: " + this.description);
        System.out.println("Ngày nhập: " + format.format(this.created));
        System.out.println("Tên danh mục: " + this.catalogName);
        System.out.println("Trạng thái sản phẩm: " + this.productStatus);
    }
}