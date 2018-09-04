package com.itheima.utils;

import com.itheima.Domain.Account;
import com.itheima.dao.daoimpl.AccountDaoImpl;
import org.aspectj.lang.annotation.Around;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * Created by admin on 2018/8/15.
 */
@Component("zz")
public class Zz {
    @Autowired
    private   AccountDaoImpl ad;

    public   void zz(int aid,int bid,double money){
        Account a1 = ad.finbById(aid);
        Account a2 = ad.finbById(bid);
        a1.setMoney(a1.getMoney()-money);
        a2.setMoney(a2.getMoney()+money);
        ad.changeAccount(a1);
        ad.changeAccount(a2);
    }

    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        Zz zz = ac.getBean("zz", Zz.class);
        zz.zz(1,2,1000f);
    }
}
