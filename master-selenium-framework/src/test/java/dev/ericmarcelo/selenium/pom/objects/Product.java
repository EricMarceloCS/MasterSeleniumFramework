package dev.ericmarcelo.selenium.pom.objects;

public class Product {

    private int productId;
    private String name;

    private boolean featured;

    public Product(int productId) {
        this.productId = productId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isFeatured() {
        return featured;
    }

    public void setFeatured(boolean featured) {
        this.featured = featured;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", featured=" + featured +
                ", name='" + name + '\'' +
                '}';
    }
}
