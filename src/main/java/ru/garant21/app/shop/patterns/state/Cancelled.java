package ru.garant21.app.shop.patterns.state;

public class Cancelled implements EventState{
    private MarketingEvent marketingEvent;

    public Cancelled(MarketingEvent marketingEvent) {
        this.marketingEvent = marketingEvent;
    }

    @Override
    public void cancel() {
        throw new IllegalArgumentException("Акция уже отменена");
    }

    @Override
    public void approve() {
        throw new IllegalArgumentException("Акция отменена");
    }

    @Override
    public void improve() {
        throw new IllegalArgumentException("Акция отменена");
    }

    @Override
    public void changeEvent(String conditions) {
        throw new IllegalArgumentException("Акция отменена");
    }
}
