package com.haoteng.miss4.md.dao;

import com.haoteng.miss4.md.module.Account;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2016/3/16.
 */
@Repository
public interface AccountDao {
    int addAccount(Account account);

    int modifyAcount(Account account);

    Account selectAccountById(String accountId);
}
