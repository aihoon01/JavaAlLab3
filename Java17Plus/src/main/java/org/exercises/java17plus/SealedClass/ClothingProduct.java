package org.exercises.java17plus.SealedClass;

public final class ClothingProduct extends Product {
    private final String size;
    private final String material;

    public ClothingProduct(String name, double price, String size, String material) {
        super(name, price);
        this.size = size;
        this.material = material;
    }

    public String size() {
        return size;
    }

    public String material() {
        return material;
    }
}
