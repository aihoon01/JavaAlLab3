package org.exercises.rxjava.StockPrice;

import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import javafx.application.Platform;

import java.util.concurrent.TimeUnit;

public class JavaFxScheduler extends Scheduler {

    private static final JavaFxScheduler INSTANCE = new JavaFxScheduler();

    public static JavaFxScheduler platform() {
        return INSTANCE;
    }

    @Override
    public Worker createWorker() {
        return new JavaFxWorker();
    }

    static class JavaFxWorker extends Worker {

        private volatile boolean disposed;

        @Override
        public Disposable schedule(Runnable run, long delay, TimeUnit unit) {
            if (disposed) {
                return EmptyDisposable.INSTANCE;
            }
            if (delay <= 0) {
                Platform.runLater(run);
            } else {
                Platform.runLater(() -> {
                    if (!disposed) {
                        run.run();
                    }
                });
            }
            return EmptyDisposable.INSTANCE;
        }

        @Override
        public void dispose() {
            disposed = true;
        }

        @Override
        public boolean isDisposed() {
            return disposed;
        }
    }
}
