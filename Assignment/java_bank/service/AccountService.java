package Assignment.java_bank.service;

import Assignment.java_bank.Main;
import Assignment.java_bank.domain.Account;
import Assignment.java_bank.repository.AccountRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class AccountService
{
    Scanner sc = new Scanner(System.in);
    AccountRepository accountRepository = Main.getAccountRepository();

    // 1. 계좌 개설하기
    public void createAccount()
    {
        System.out.println("========계좌 개설========");
        Account account = new Account();
        System.out.println("======계좌 개설 완료======");
    }
    //2. 입금
    public void saveMoney()
    {
        System.out.println("======입금하기======");

        HashMap account = null;
        while(true)
        {
            try
            {
                System.out.print("입급하실 계좌번호를 입력해주세요. :");
                account = accountRepository.findById(Long.valueOf(sc.nextLine()));
                if (account != null) break;
                else throw new IllegalStateException();
            }
            catch (IllegalStateException e)
            {
                System.out.println("존재하지 않는 계좌입니다. 다시 입력해주세요.");
            }
        }

        checkName(account);

        while(true)
        {
            try
            {
                System.out.print("입금하실 금액을 입력해주세요. : ");
                Long money = Long.valueOf(sc.nextLine());
                if(isPositive(money))
                {
                    account.put("money",Long.parseLong(String.valueOf(account.get("money")))+money);
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

        System.out.println("계좌 잔고 : " + account.get("money"));
        System.out.println("======입금 완료======");
    }

    private void checkName(HashMap account)
    {
        while(true)
        {
            try
            {
                System.out.print("계좌 이름 :");
                String name = sc.nextLine();
                if(account.get("name").equals(name)) break;
                else throw new IllegalStateException();
            }
            catch (IllegalStateException e)
            {
                System.out.println("계좌 이름이 일치하지 않습니다. 다시 입력해주세요.");
            }
        }

        System.out.println("계좌 잔고 :" + account.get("money"));
    }

    //3. 출금
    public void withdrawMoney()
    {
        HashMap account = null;
        while(true)
        {
            try
            {
                System.out.print("출금하실 계좌번호를 입력해주세요. :");
                account = accountRepository.findById(Long.valueOf(sc.nextLine()));
                if (account != null) break;
                else throw new IllegalStateException();
            }
            catch (IllegalStateException e)
            {
                System.out.println("존재하지 않는 계좌입니다. 다시 입력해주세요.");
            }
        }

        checkName(account);

        while(true)
        {
            try
            {
                System.out.print("출금하실 금액을 입력해주세요. : ");
                Long money = Long.valueOf(sc.nextLine());
                if(!isPositive(money)) throw new IllegalStateException();

                if(money <= Long.parseLong(String.valueOf(account.get("money"))))
                {
                    account.put("money", Long.parseLong(String.valueOf(account.get("money"))) - money);
                    break;
                }
                else throw new Exception();
            }
            catch (IllegalStateException e)
            {
                System.out.println("입력하시는 금액은 항상 양수여야합니다. 다시 입력해주세요.");
            }
            catch (NumberFormatException e)
            {
                System.out.println("올바른 숫자를 입력해주세요.");
            }
            catch (Exception e)
            {
                System.out.println("잔액이 부족합니다. 다시 입력해주세요.");
            }
        }
        System.out.println("계좌 잔고 :" + account.get("money"));
        System.out.println("======출금 완료======");
    }

    //4. 전체 조회
    public void showAll()
    {
        System.out.println("======전체 조회======");
        List<HashMap> all = accountRepository.findAll();
        for (HashMap account : all)
        {
            System.out.print("[");
            System.out.print("계좌번호 : " + account.get("id") + " , ");
            System.out.print("이름 : " + account.get("name") + " , ");
            System.out.println("잔액 : " + account.get("money") + "]");
        }
        System.out.println("==================");
        
    }

    //5. 계좌 이체
    public void sendMoney()
    {
        System.out.println("귀찮으니까 심심할 때 해야지..");
    }


    //6. 종료

    public boolean isSameId(Long id)
    {
        HashMap account = accountRepository.findById(id);
        return account != null;
    }

    public boolean isPositive(Long money)
    {
        return money>=0;
    }
}
