package main.java.services;

import main.constants.UtilConstants;
import main.java.entities.BucketedSector;
import main.java.entities.PV01;
import main.java.entities.Position;
import main.java.listeners.ServiceListener;
import main.java.products.Bond;
import main.java.products.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Risk Service to vend out risk for a particular security and across a risk bucketed sector.
 * Keyed on product identifier.
 * Type T is the product type.
 */
public class RiskService<T> extends Service<String, PV01<T>> {
    private final Map<String, PV01<T>> riskMap = new HashMap<>();
    private final Map<String, PV01<BucketedSector<T>>> bucketedRiskMap = new HashMap<>();
    private final List<ServiceListener<PV01<T>>> listeners = new ArrayList<>();

    // Add a position that the service will risk
    public void AddPosition(Position<T> position) {
        T product = position.getProduct();
        if (product instanceof Bond) {
            String productId = ((Bond) product).getProductId();
            // Sum up the positions of the given security across all risk books.
            PV01<T> pv01 = new PV01<>(product, PV01.GetPV01(productId), position.getPositions().values().stream().mapToLong(Long::longValue).sum());
            riskMap.put(productId, pv01);
            UpdateBucketedRisk();
            for (ServiceListener<PV01<T>> listener : listeners) {
                listener.ProcessAdd(pv01);
            }
        }
    }

    PV01<BucketedSector<T>> GetBucketedRisk(BucketedSector<T> sector) {
        return bucketedRiskMap.get(sector);
    }

    // Get the bucketed risk for the bucket sector
    void UpdateBucketedRisk() {
        List<T> frontEndProducts = (List<T>) UtilConstants.FRONTEND_TENORS.stream().map(Bond::GetBond).collect(Collectors.toList());
        List<T> bellyProducts = (List<T>) UtilConstants.BELLY_TENORS.stream().map(Bond::GetBond).collect(Collectors.toList());
        List<T> longEndProducts = (List<T>) UtilConstants.LONGEND_TENORS.stream().map(Bond::GetBond).collect(Collectors.toList());
        BucketedSector<T> frontEndBucketedSector = new BucketedSector<>(frontEndProducts, UtilConstants.FRONTEND_BUCKET);
        BucketedSector<T> bellyBucketedSector = new BucketedSector<>(bellyProducts, UtilConstants.BELLY_BUCKET);
        BucketedSector<T> longEndBucketedSector = new BucketedSector<>(longEndProducts, UtilConstants.LONGEND_BUCKET);
        double frontEndRisk = 0L;
        double bellyRisk = 0L;
        double longEndRisk = 0L;
        Long frontEndQuantity = 0L;
        Long bellyQuantity = 0L;
        Long longEndQuantity = 0L;

        for (T product : frontEndProducts) {
            assert product instanceof Product;
            PV01<T> pv01Temp = riskMap.get(((Product) product).getProductId());
            if (pv01Temp != null) {
                frontEndRisk += pv01Temp.getPv01() * pv01Temp.getQuantity();
                frontEndQuantity += pv01Temp.getQuantity();
            }
        }
        for (T product : bellyProducts) {
            assert product instanceof Product;
            PV01<T> pv01Temp = riskMap.get(((Product) product).getProductId());
            if (pv01Temp != null) {
                bellyRisk += pv01Temp.getPv01() * pv01Temp.getQuantity();
                bellyQuantity += pv01Temp.getQuantity();
            }
        }
        for (T product : longEndProducts) {
            assert product instanceof Product;
            PV01<T> pv01Temp = riskMap.get(((Product) product).getProductId());
            if (pv01Temp != null) {
                longEndRisk += pv01Temp.getPv01() * pv01Temp.getQuantity();
                longEndQuantity += pv01Temp.getQuantity();
            }
        }
        frontEndRisk = frontEndRisk / frontEndQuantity;
        bellyRisk = bellyRisk / bellyQuantity;
        longEndRisk = longEndRisk / longEndQuantity;

        PV01<BucketedSector<T>> frontEndPV01 = new PV01<>(frontEndBucketedSector, frontEndRisk, frontEndQuantity);
        PV01<BucketedSector<T>> bellyPV01 = new PV01<>(bellyBucketedSector, bellyRisk, bellyQuantity);
        PV01<BucketedSector<T>> longEndPV01 = new PV01<>(longEndBucketedSector, longEndRisk, longEndQuantity);
        bucketedRiskMap.put(UtilConstants.FRONTEND_BUCKET, frontEndPV01);
        bucketedRiskMap.put(UtilConstants.BELLY_BUCKET, bellyPV01);
        bucketedRiskMap.put(UtilConstants.LONGEND_BUCKET, longEndPV01);
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
        listeners.add(listener);
    }

    @Override
    public List<ServiceListener<PV01<T>>> GetListeners() {
        return listeners;
    }
}
