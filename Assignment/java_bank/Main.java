package Assignment.java_bank;

import Assignment.java_bank.domain.Account;
import Assignment.java_bank.domain.Menu;
import Assignment.java_bank.repository.AccountRepository;

import java.util.HashMap;

public class Main {
    static AccountRepository accountRepository = new AccountRepository();

    public static AccountRepository getAccountRepository()
    {
        return accountRepository;
    }

    public static void main(String[] args)
    {
        Menu menu = new Menu();
        menu.start();
    }
}
