package ru.garant21.app.shop.patterns.state;

public class Approved implements EventState{
    private MarketingEvent marketingEvent;

    public Approved(MarketingEvent marketingEvent) {
        this.marketingEvent = marketingEvent;
    }

    @Override
    public void cancel() {
        throw new IllegalArgumentException("Акция согласована. Отмена невозможна");
    }

    @Override
    public void approve() {
        throw new IllegalArgumentException("Акция уже согласована.");
    }

    @Override
    public void improve() {
        marketingEvent.setCurrentState(marketingEvent.getImproved());
        System.out.println("Надо доработать");
    }

    @Override
    public void changeEvent(String conditions) {
        throw new IllegalArgumentException("Акция согласована. Изменять её нельзя");
    }
}
