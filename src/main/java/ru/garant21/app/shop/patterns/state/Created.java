package ru.garant21.app.shop.patterns.state;

import ru.garant21.app.shop.Model.Entity.Product;

public class Created  implements EventState{
    private MarketingEvent marketingEvent;

    public Created(MarketingEvent marketingEvent) {
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
        marketingEvent.setCurrentState(marketingEvent.getApproved());
        System.out.println("на доработку");
    }

    @Override
    public void changeEvent(String conditions) {
        marketingEvent.changeEvent(conditions);
        System.out.println("Редактирование акции");
    }
}
