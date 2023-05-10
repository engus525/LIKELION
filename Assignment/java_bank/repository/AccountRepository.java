package Assignment.java_bank.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AccountRepository
{
    private List<HashMap> accounts = new ArrayList<>();

    public void save(HashMap account)
    {
        accounts.add(account);
    }

    public HashMap findById(Long id)
    {
        if(accounts.isEmpty()) return null;
        for (HashMap account : accounts)
        {
            if(account.get("id").equals(id))
            {
                return account;
            }
        }
        return null;
    }

    public List<HashMap> findAll()
    {
        return accounts;
    }
}
