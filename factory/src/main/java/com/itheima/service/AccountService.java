package com.itheima.service;

import com.itheima.Domain.Account;

import java.util.List;

/**
 * Created by admin on 2018/8/13.
 */
public interface AccountService {
    List<Account> findAll();
    Account finbById(int i);
    void  saveAccount(Account account);
    void delAccount(int i );
    void changeAccount(Account a);
}
