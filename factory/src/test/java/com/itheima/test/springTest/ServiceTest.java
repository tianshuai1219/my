package com.itheima.test.springTest;

import com.itheima.Domain.Account;
import com.itheima.dao.daoimpl.AccountDaoImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by admin on 2018/8/13.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class ServiceTest {
    @Autowired
    private AccountDaoImpl adi;
    @Test
    public void meth(){
        List<Account> all = adi.findAll();
        System.out.println(all);
    }
}
