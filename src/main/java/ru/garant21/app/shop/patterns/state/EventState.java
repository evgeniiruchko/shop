package ru.garant21.app.shop.patterns.state;

public interface EventState {
    void cancel(); //отменить
    void approve(); //согласовать
    void improve(); //на доработку
    void changeEvent(String conditions); //редактирование
}
