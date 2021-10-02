package ru.garant21.payments.facadePattern;

public interface Payment {
    boolean pay(String userName, String fromCard, String toAccount, Double amount);

}
