package Assignment.java_bank.domain;

import Assignment.java_bank.Main;
import Assignment.java_bank.repository.AccountRepository;
import Assignment.java_bank.service.AccountService;

import java.util.HashMap;
import java.util.Scanner;

public class Account
{
    Scanner sc = new Scanner(System.in);

    private AccountService accountService = new AccountService();
    AccountRepository accountRepository = Main.getAccountRepository();
    private Long id;
    private String name;
    private Long money;
    HashMap account = new HashMap();

    public Account()
    {
        setId();
        setName();
        setMoney();
        accountRepository.save(account);
    }

    public void setId()
    {
        while(true)
        {
            try
            {
                System.out.print("계좌번호 : ");
                Long newId = Long.valueOf(sc.nextLine());
                if(!accountService.isSameId(newId))
                {
                    this.id = newId;
                    account.put("id",newId);
                    break;
                }
                else throw new IllegalStateException();
            }
            catch (IllegalStateException e)
            {
                System.out.println("이미 존재하는 계좌입니다. 다시 입력해주세요.");
            }
            catch (NumberFormatException e)
            {
                System.out.println("계좌번호는 숫자로만 이루어져야합니다. 다시 입력해주세요.");

            }
        }
    }

    private void setName()
    {
        System.out.print("이름 : ");
        this.name = sc.nextLine();
        account.put("name",this.name);
    }

    public void setMoney()
    {
        while(true)
        {
            try
            {
                System.out.print("예금 : ");
                Long newMoney = Long.parseLong(sc.nextLine());
                if(accountService.isPositive(newMoney))
                {
                    this.money = newMoney;
                    account.put("money",newMoney);
                    break;
                }
                else throw new IllegalStateException();
            }
            catch (IllegalStateException e)
            {
                System.out.println("입력하시는 금액은 항상 양수여야합니다. 다시 입력해주세요.");
            }
            catch (NumberFormatException e)
            {
                System.out.println("올바른 숫자를 입력해주세요.");

            }
        }
    }
}
