package com.haoteng.miss4.md.service;

import com.haoteng.miss4.md.module.Account;

/**
 * Created by Administrator on 2016/3/15.
 */
public interface AccountSrvice {
    boolean AddAccount(Account account);

    boolean modifyAccount(String comeId,String amount);

    Account queryAccountById(String id);
}
