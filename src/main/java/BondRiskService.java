package main.java;

import java.util.List;

/**
 * Risk Service to vend out risk for a particular security and across a risk bucketed sector.
 * Keyed on product identifier.
 * Type T is the product type.
 */
public class BondRiskService<T> extends RiskService<T> {
    // Add a position that the service will risk
    public void AddPosition(Position<T> position) {

    }

    // Get the bucketed risk for the bucket sector
    public PV01<BucketedSector<T>> GetBucketedRisk(BucketedSector<T> sector) {
        return null;
    }

    @Override
    public PV01<T> GetData(String key) {
        return null;
    }

    @Override
    public void OnMessage(PV01<T> data) {

    }

    @Override
    public void AddListener(ServiceListener<PV01<T>> listener) {

    }

    @Override
    public List<ServiceListener<PV01<T>>> GetListeners() {
        return null;
    }
}
