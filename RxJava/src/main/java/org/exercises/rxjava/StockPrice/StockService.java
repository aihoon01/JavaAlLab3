package org.exercises.rxjava.StockPrice;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.reactivex.rxjava3.core.Observable;

import java.io.IOException;


//This StockService class uses the Observable.create() method
//to make the API request and emit the latest stock price.
//The getStockPrice() method emits a stream with the latest price
//of the given stock symbol.

public class StockService {
//    private static final String API_KEY = "09SMGVCSP7CQUYZA";
    private static final String API_KEY = "TO7PEVOL6F4XKC6D";
    private static final String BASE_URL = "https://www.alphavantage.co/query";
    private static final String symbol = "IBM";
//    private static final String API_KEY = System.getProperty("api.key", "default_api_key");

    private final OkHttpClient client = new OkHttpClient();

    public Observable<Double> getStockPrice(String symbol) {
        return Observable.create(emitter -> {
            String url = String.format("%s?function=TIME_SERIES_INTRADAY&symbol=%s&interval=1min&apikey=%s", BASE_URL, symbol, API_KEY);
            Request request = new Request.Builder().url(url).build();

            try (Response response = client.newCall(request).execute()) {
                if (!response.isSuccessful()) {
                    emitter.onError(new IOException("Unexpected code " + response));
                } else {
                    String responseData = response.body().string();
                    JsonObject jsonObject = JsonParser.parseString(responseData).getAsJsonObject();

                    // Check if "Time Series (1min)" exists in the JSON response
                    if (jsonObject.has("Time Series (1min)")) {
                        JsonObject timeSeries = jsonObject.getAsJsonObject("Time Series (1min)");
                        String latestTime = timeSeries.keySet().iterator().next(); // Get the latest time
                        Double latestPrice = timeSeries.getAsJsonObject(latestTime).get("1. open").getAsDouble();
                        emitter.onNext(latestPrice);
                        emitter.onComplete();
                    } else {
                        // Handle missing "Time Series (1min)" data
                        emitter.onError(new IOException("Time Series data not available in response: " + responseData));
                    }
                }
            } catch (IOException e) {
                emitter.onError(e);
            }
        });
    }


}
