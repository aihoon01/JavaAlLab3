package org.exercises.rxjava.StockPrice;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import io.reactivex.rxjava3.disposables.Disposable;


//In this UI, we’ll use Label to display the price and update
//it whenever the price changes.
public class StockDashboardApp extends Application {
    private final StockService stockService = new StockService();
    private final StockPriceMonitor monitor = new StockPriceMonitor(stockService);
    private Disposable subscription;

    @Override
    public void start(Stage primaryStage) {
        Label priceLabel = new Label("Fetching...");
        VBox root = new VBox(priceLabel);
        Scene scene = new Scene(root, 300, 200);

        primaryStage.setTitle("Stock Price Monitor");
        primaryStage.setScene(scene);
        primaryStage.show();

        // Subscribe to the stock price observable and update the label dynamically
        subscription = monitor.monitorStockPrice("AAPL")
                .observeOn(JavaFxScheduler.platform())
                .subscribe(
                        price -> priceLabel.setText("Price: $" + price),
                        Throwable::printStackTrace
                );
    }

    @Override
    public void stop() {
        if (subscription != null && !subscription.isDisposed()) {
            subscription.dispose();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
