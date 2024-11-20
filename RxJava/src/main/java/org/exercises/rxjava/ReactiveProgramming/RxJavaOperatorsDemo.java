package org.exercises.rxjava.ReactiveProgramming;

import io.reactivex.rxjava3.core.Observable;

public class RxJavaOperatorsDemo {
    public static void main(String[] args) {

        // Sample data stream
        Observable<Integer> numbers = Observable.just(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Using map operator to square each number
        Observable<Integer> squaredNumbers = numbers
                .map(number -> number * number);

        // Using filter operator to only pass even squared numbers
        Observable<Integer> evenSquaredNumbers = squaredNumbers
                .filter(square -> square % 2 == 0);

        // Subscribing to the observable and printing each item
        evenSquaredNumbers.subscribe(
                System.out::println,                           // onNext (print each item)
                Throwable::printStackTrace,                    // onError (print error if any)
                () -> System.out.println("Stream complete!")   // onComplete (print completion message)
        );
    }
}
