package org.exercises.java17plus.Switch;

public class ProductCategoryExample {
    public static void main(String[] args) {
        String productCode = "E01";  // Example product code
        String category = switch (productCode) {
            case "E01", "E02", "E03" -> "Electronics";
            case "C01", "C02" -> "Clothing";
            case "H01", "H02" -> "Home";
            default -> "Unknown Category";
        };

        String aboutSwitchExpression = """
                The switch expression is new feature developed by Java
                It reduces boilerplate code in multiple switch statements
                It Makes your code clean and concise and more readable.
                """;


        System.out.println(aboutSwitchExpression);
        System.out.println("Product Category: " + category);

    }

}
