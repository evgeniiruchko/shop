package ru.garant21.payments.facadePattern;

public interface TranzactionalService {
    boolean transferMoney(String fromCard, String toAccount, Double sum);
}
