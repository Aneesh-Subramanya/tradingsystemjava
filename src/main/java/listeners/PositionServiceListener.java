package main.java.listeners;

import main.java.entities.Trade;
import main.java.services.PositionService;

public class PositionServiceListener<T> extends ServiceListener<Trade<T>> {
    PositionService<T> positionService;

    public PositionServiceListener(PositionService<T> positionService) {
        this.positionService = positionService;
    }

    public PositionService<T> getPositionService() {
        return positionService;
    }

    public void setPositionService(PositionService<T> positionService) {
        this.positionService = positionService;
    }

    @Override
    public void ProcessAdd(Trade<T> data) {
        positionService.AddTrade(data);
    }

    @Override
    public void ProcessRemove(Trade<T> data) {

    }

    @Override
    public void ProcessUpdate(Trade<T> data) {

    }
}
