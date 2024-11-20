package org.exercises.java17plus.SealedClass;

public final class ElectronicsProduct extends Product {
    private final int warrantyPeriod;

    public  ElectronicsProduct(String name, double price, int warrantyPeriod) {
        super(name, price);
        this.warrantyPeriod = warrantyPeriod;
    }

    public int warrantyPeriod() {
        return warrantyPeriod;
    }

}
