package org.exercises.java17plus.Records;

// Test the Product record
class ProductTest {
    public static void main(String[] args) {
        // Create a new Product
        Product product = new Product("Ghana", 78299.99, "Country");

        // Access product data using accessors
        System.out.println("Product Name: " + product.name());
        System.out.println("Product Price: $" + product.price());
        System.out.println("Product Category: " + product.category());
    }
}