package org.exercises.java17plus.SealedClass;

public class ProductTest {
    public static void main(String[] args) {
        // Create an ElectronicsProduct
        ElectronicsProduct laptop = new ElectronicsProduct("Laptop", 999.99, 24);
        System.out.println("Electronics Product:");
        System.out.println("Name: " + laptop.name());
        System.out.println("Price: $" + laptop.price());
        System.out.println("Warranty Period: " + laptop.warrantyPeriod() + " months");

        // Create a ClothingProduct
        ClothingProduct shirt = new ClothingProduct("T-Shirt", 19.99, "M", "Cotton");
        System.out.println("\nClothing Product:");
        System.out.println("Name: " + shirt.name());
        System.out.println("Price: $" + shirt.price());
        System.out.println("Size: " + shirt.size());
        System.out.println("Material: " + shirt.material());
    }
}
