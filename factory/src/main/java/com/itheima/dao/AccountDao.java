package com.itheima.dao;

import com.itheima.Domain.Account;

import java.util.List;

/**
 * Created by admin on 2018/8/13.
 */
public interface AccountDao {

    List<Account> findAll();
    Account finbById(int i);
    void  saveAccount(Account a);
    void delAccount(int i);
    void changeAccount(Account a);
 }
