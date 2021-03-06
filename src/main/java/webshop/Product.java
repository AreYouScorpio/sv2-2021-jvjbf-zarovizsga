package webshop;

public class Product {

    private long id;
    private String productName;
    private long price;
    private long stock;

    public Product(long id, String name, long price, long stock) {
        this.id = id;
        this.productName = name;
        this.price = price;
        this.stock = stock;
    }

    public long getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public long getPrice() {
        return price;
    }

    public long getStock() {
        return stock;
    }
}
