package com.haoteng.miss4.md.module;

/**
 * Created by Administrator on 2016/3/15.
 */
public class Account extends Base {
    private static final long serialVersionUID = 3550515540489968115L;
    public String accountId;
    public String usernName;
    public String idcardNo;
    public String amount;


    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getUsernName() {
        return usernName;
    }

    public void setUsernName(String usernName) {
        this.usernName = usernName;
    }

    public String getIdcardNo() {
        return idcardNo;
    }

    public void setIdcardNo(String idcardNo) {
        this.idcardNo = idcardNo;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
