package com.haoteng.miss4.md.serviceImpl;

import com.haoteng.miss4.md.dao.AccountDao;
import com.haoteng.miss4.md.module.Account;
import com.haoteng.miss4.md.service.AccountSrvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2016/3/15.
 */
@Service
public class AccountSrviceImpl implements AccountSrvice {
    @Autowired
     AccountDao accountDao;
    public boolean AddAccount(Account account) {
        return true;
    }
}
