package main.java;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Definition of a Connector class.
 * This will invoke the Service.OnMessage() method for subscriber Connectors
 * to push data to the Service.
 * Services can invoke the Publish() method on this Service to publish data to the Connector
 * for a publisher Connector.
 * Note that a Connector can be publisher-only, subscriber-only, or both publisher and susbcriber.
 */
public abstract class Connector<V> {
    // Publish data to the Connector
    public abstract void Publish(V data);

    public void WriteToFile(String str, File file) {
        try {
            FileWriter writer = new FileWriter(file, true);
            writer.write(str);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
