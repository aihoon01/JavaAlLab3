package org.exercises.java17plus.Records;

//Records in Java provide a concise way to model data
// eliminate the need for manually defining getters.
// Instead, they provide accessor methods with the same name as each field

public record Product(String name, double price, String category) {
}