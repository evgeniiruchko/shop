package ru.garant21.app.shop.patterns.state;

public class Improved implements EventState{
    private MarketingEvent marketingEvent;

    public Improved(MarketingEvent marketingEvent) {
        this.marketingEvent = marketingEvent;
    }

    @Override
    public void cancel() {
        marketingEvent.setCurrentState(marketingEvent.getCancelled());
        System.out.println("Акция успешно отменена");
    }

    @Override
    public void approve() {
        marketingEvent.setCurrentState(marketingEvent.getApproved());
        System.out.println("Акция согласована");
    }

    @Override
    public void improve() {
        throw new IllegalArgumentException("Акция и так на доработке");
    }

    @Override
    public void changeEvent(String conditions) {
        marketingEvent.changeEvent(conditions);
        System.out.println("Редактирование акции");
    }
}
