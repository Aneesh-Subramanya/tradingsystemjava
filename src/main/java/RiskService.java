package main.java;

import java.util.List;

/**
 * Risk Service to vend out risk for a particular security and across a risk bucketed sector.
 * Keyed on product identifier.
 * Type T is the product type.
 */
public abstract class RiskService<T> extends Service<String, PV01<T>> {
    // Add a position that the service will risk
    public abstract void AddPosition(Position<T> position);

    // Get the bucketed risk for the bucket sector
    public abstract PV01<BucketedSector<T>> GetBucketedRisk(BucketedSector<T> sector);
}
