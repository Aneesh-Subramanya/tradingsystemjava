package main.java;

import java.util.List;

/**
 * Definition of a generic base class Service.
 * Uses key generic type K and value generic type V.
 */
public abstract class Service<K, V> {
    // Get data on our service given a key
    public abstract V GetData(K key);

    // The callback that a Connector should invoke for any new or updated data
    public abstract void OnMessage(V data) throws InterruptedException;

    // Add a listener to the Service for callbacks on add, remove, and update events
    // for data to the Service.
    public abstract void AddListener(ServiceListener<V> listener);

    // Get all listeners on the Service.
    public abstract List<ServiceListener<V>> GetListeners();

}
