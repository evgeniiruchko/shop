package ru.garant21.payments.facadePattern;

public class PaymentService implements Payment{
    private AccountService accountService;
    private CheckService checkService;
    private TranzactionalService tranzactionalService;

    public PaymentService(AccountService accountService, CheckService checkService, TranzactionalService tranzactionalService) {
        this.accountService = accountService;
        this.checkService = checkService;
        this.tranzactionalService = tranzactionalService;
    }


    @Override
    public boolean pay(String userName, String fromCard, String toAccount, Double amount) {
        checkService.checkClient(userName);
        Double accountAmount =accountService.getAccountAmount(fromCard);
        if (accountAmount >= amount) {
            tranzactionalService.transferMoney(fromCard, toAccount, amount);
            return true;
        } else {
            System.out.println("Не достаточно средств");
            return false;
        }
    }
}
