package main.java.listeners;

/**
 * Definition of a generic base class ServiceListener to listen to add, update, and remove
 * events on a Service. This listener should be registered on a Service for the Service
 * to notify all listeners for these events.
 */
public abstract class ServiceListener<V> {
    // Listener callback to process an add event to the Service
    public abstract void ProcessAdd(V data);

    // Listener callback to process a remove event to the Service
    public abstract void ProcessRemove(V data);

    // Listener callback to process an update event to the Service
    public abstract void ProcessUpdate(V data);
}
