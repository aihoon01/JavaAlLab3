package org.exercises.rxjava.StockPrice;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import java.util.concurrent.TimeUnit;

//In a reactive dashboard, we might want to poll for updates
//and filter data for significant changes. We’ll use Observable.interval
//for periodic polling and filter to process data.

//This monitorStockPrice method will retrieve stock data every minute,
//only emit new values if they change, and filter for prices above $100. Adjust this filter to match your criteria.
public class StockPriceMonitor {
    private final StockService stockService;

    public StockPriceMonitor(StockService stockService) {
        this.stockService = stockService;
    }

    public Observable<Double> monitorStockPrice(String symbol) {
        return Observable.interval(0, 1, TimeUnit.MINUTES, Schedulers.io())
                .flatMap(tick -> stockService.getStockPrice(symbol))
                .distinctUntilChanged()
                .filter(price -> price > 100); // Example filter for prices above 100
    }
}
