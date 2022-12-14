package main.java;

import java.util.List;

/**
 * Service for processing and persisting historical data to a persistent store.
 * Keyed on some persistent key.
 * Type T is the data type to persist.
 */
public abstract class HistoricalDataService<T> extends Service<String, T> {
    public abstract void PersistData(String persistKey, T data);
}
