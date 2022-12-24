package main.java.listeners;

import main.java.entities.Position;
import main.java.services.RiskService;

public class RiskServiceListener<T> extends ServiceListener<Position<T>> {
    RiskService<T> riskService;

    public RiskServiceListener(RiskService<T> riskService) {
        this.riskService = riskService;
    }

    public RiskService<T> getRiskService() {
        return riskService;
    }

    public void setRiskService(RiskService<T> riskService) {
        this.riskService = riskService;
    }

    @Override
    public void ProcessAdd(Position<T> data) {
        riskService.AddPosition(data);
    }

    @Override
    public void ProcessRemove(Position<T> data) {

    }

    @Override
    public void ProcessUpdate(Position<T> data) {

    }
}
