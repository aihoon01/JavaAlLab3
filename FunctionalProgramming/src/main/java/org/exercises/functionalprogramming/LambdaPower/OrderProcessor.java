package org.exercises.functionalprogramming.LambdaPower;

import java.util.List;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class OrderProcessor {

    public static void main(String[] args) {
        List<Double> prices = List.of(19.99, 39.23, 70.09);

        //Using an anonymous inner class to calculate total
        double total = prices.stream().reduce(0.0, new BinaryOperator<Double>() {
            @Override
            public Double apply(Double aDouble, Double aDouble2) {
                return aDouble + aDouble2;
            }
        });
        System.out.println("Order Total with anonymous function: " + total);


        //Using a Lambda Expression to calculate total
        double totalPrice = prices.stream().reduce(0.0, (a,b) -> a + b);
        System.out.println("totalPrice with Lambda: " + total);


        //Using Method Referencing
        double totalPriceWithLambda = prices.stream().reduce(0.0, Double::sum);
        System.out.println("totalPrice with Method Referencing: " + totalPriceWithLambda);


        //Filtered and Mapped items with price > 30
        List<Double> filteredPrices = prices.stream()
                .filter(price -> price > 30)
                .map(price -> price * 0.05)
                .collect(Collectors.toList());
        System.out.println("Filtered and Mapped Prices: " + filteredPrices);
    }
}
