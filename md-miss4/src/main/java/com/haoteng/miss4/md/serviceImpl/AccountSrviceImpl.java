package com.haoteng.miss4.md.serviceImpl;

import com.haoteng.miss4.md.dao.AccountDao;
import com.haoteng.miss4.md.module.Account;
import com.haoteng.miss4.md.service.AccountSrvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * Created by Administrator on 2016/3/15.
 */
@Service
public class AccountSrviceImpl implements AccountSrvice {
    @Autowired
    AccountDao accountDao;

    public boolean AddAccount(Account account) {
        account.setAccountId(UUID.randomUUID().toString().replaceAll("-",""));
        return accountDao.addAccount(account) > 0;
    }

    public boolean modifyAccount(String comeId, String amount) {
        Account account = accountDao.selectAccountById(comeId);
        Double amout = Double.parseDouble(amount);
        Double oldAmout = Double.parseDouble(account.getAmount());
        Double money = oldAmout - amout;
        if (account != null) {
            account.setAmount(money.toString());
            return accountDao.modifyAcount(account) > 0;
        }
        return false;
    }


    public Account queryAccountById(String id) {
        return accountDao.selectAccountById(id);
    }
}
