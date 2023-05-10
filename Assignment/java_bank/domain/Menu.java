package Assignment.java_bank.domain;

import Assignment.java_bank.service.AccountService;

import java.util.Scanner;

public class Menu
{
    Scanner sc = new Scanner(System.in);
    AccountService accountService = new AccountService();

    public void start()
    {
        while(true)
        {
            System.out.println("=======Bank Menu=======");
            System.out.println("1. 계좌 개설");
            System.out.println("2. 입금");
            System.out.println("3. 출금");
            System.out.println("4. 전체 계좌 조회");
            System.out.println("5. 계좌 이체");
            System.out.println("6. 종료");
            System.out.println("=======================");
            System.out.print("입력 : ");
            int select = Integer.parseInt(sc.nextLine());
            if (select == 1)
            {
                accountService.createAccount();
            }
            else if(select == 2)
            {
                accountService.saveMoney();
            }
            else if(select == 3)
            {
                accountService.withdrawMoney();
            }
            else if(select == 4)
            {
                accountService.showAll();
            }
            else if(select == 5)
            {
                accountService.withdrawMoney();
            }
            else if(select == 6)
            {
                System.out.println("=====프로그램을 종료합니다.=====");
                System.exit(0);
            }

        }

    }
}
