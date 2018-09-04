package com.itheima.dao.daoimpl;

import com.itheima.Domain.Account;
import com.itheima.dao.AccountDao;
import com.itheima.utils.ConnectionUtils;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.util.List;

/**
 * Created by admin on 2018/8/13.
 */
@Repository("accountDao")
public class AccountDaoImpl implements AccountDao {
    @Autowired
    private QueryRunner runner;
    @Autowired
    private ConnectionUtils cu;
    public AccountDaoImpl(QueryRunner runner) {
        this.runner = runner;
    }

    public List<Account> findAll()  {
        try {
            return runner.query(cu.getC(),"select * from account", new BeanListHandler<Account>(Account.class));
        }catch (Exception e){
            e.printStackTrace();
            return  null;
        }
    }

    public Account finbById(int i) {
        try {
            System.out.println(cu.getC());
            return runner.query(cu.getC(),"select * from account where id = ?", new BeanHandler<Account>(Account.class),i);
        }catch (Exception e){
            e.printStackTrace();
            return  null;
        }
    }

    public void saveAccount(Account a) {
        try {
            int id = a.getId();
            double money = a.getMoney();
            int uid = a.getUid();
            runner.update(cu.getC(),"insert into account(id,uid,money)values(?,?,?)",id,uid,money);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void delAccount(int i) {
        try{
            runner.update(cu.getC(),"DELETE FROM  account WHERE id= ?",i);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void changeAccount(Account a) {
        try{
            runner.update(cu.getC(),"UPDATE account SET money = ? WHERE id = ?",a.getMoney(),a.getId());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
