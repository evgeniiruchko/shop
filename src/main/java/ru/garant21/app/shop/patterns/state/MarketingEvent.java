package ru.garant21.app.shop.patterns.state;

import ru.garant21.app.shop.Model.Entity.Product;

import java.util.List;

public class MarketingEvent {
    private List<Product> products;
    private String conditions;
    private EventState currentState;

    private EventState created = new Created(this);
    private EventState cancelled = new Cancelled(this);
    private EventState approved = new Approved(this);
    private EventState improved = new Improved(this);

    public MarketingEvent(List<Product> products, String conditions, EventState currentState) {
        this.products = products;
        this.conditions = conditions;
        this.currentState = currentState;
    }

    public EventState getCreated() {
        return created;
    }

    public void setCreated(EventState created) {
        this.created = created;
    }

    public EventState getCancelled() {
        return cancelled;
    }

    public void setCancelled(EventState cancelled) {
        this.cancelled = cancelled;
    }

    public EventState getApproved() {
        return approved;
    }

    public void setApproved(EventState approved) {
        this.approved = approved;
    }

    public EventState getImproved() {
        return improved;
    }

    public void setImproved(EventState improved) {
        this.improved = improved;
    }

    public void setCurrentState(EventState currentState) {
        this.currentState = currentState;
    }

    public void changeEvent(String conditions) {
        currentState.changeEvent(conditions);
    }

    public void cancelEvent() {
        currentState.cancel();
    }
}
