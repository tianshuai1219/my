package com.itheima.service.serviceimpl;

import com.itheima.Domain.Account;
import com.itheima.dao.AccountDao;
import com.itheima.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by admin on 2018/8/13.
 */
@Service("accountService")
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountDao accountDao;
//
//    public AccountServiceImpl(AccountDao accountDao) {
//
//        this.accountDao = accountDao;
//    }

    public List<Account> findAll() {
        return accountDao.findAll();
    }

    public Account finbById(int i) {
        return accountDao.finbById(i);
    }

    public void saveAccount(Account a) {
        accountDao.saveAccount(a);
    }

    public void delAccount(int i) {
        accountDao.delAccount(i);
    }

    public void changeAccount(Account a) {
        accountDao.changeAccount(a);
    }
}
