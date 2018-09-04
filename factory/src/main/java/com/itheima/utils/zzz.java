package com.itheima.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;

/**
 * Created by admin on 2018/8/15.
 */
@Component
@Aspect
public class zzz {
    @Autowired
    private DataSource ds ;
    @Autowired
    private ConnectionUtils cu;
//    @Before("execution(* com.itheima.utils.Zz.zz(..))")

    public void t1(){

    }
    public void kq(){
        try {

            System.out.println("事务开启了");
            cu.getC().setAutoCommit(false);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
//    @AfterReturning("execution(* com.itheima.utils.Zz.zz(..))")
    public void cg(){
        try {
            System.out.println("事务执行成功了");
            cu.getC().commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
//    @After("execution(* com.itheima.utils.Zz.zz(..))")
    public void zz(){
        try {
            System.out.println("事务执行完毕了");
            cu.getC().close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
//    @AfterThrowing("execution(* com.itheima.utils.Zz.zz(..))")
    public void yc(){
        try {
            System.out.println("回滚事务");
            cu.getC().rollback();
        }catch (Exception e){
            System.out.println("事务执行有异常了");
            e.printStackTrace();
        }
    }


    @Around("execution(* com.itheima.utils.Zz.zz(..))")
    public Object ar(ProceedingJoinPoint pjp){
        Object o = null;
        try {
            Object[] args = pjp.getArgs();
                kq();
            o = pjp.proceed(args);
                cg();
        }catch (Throwable t){
            yc();
            t.printStackTrace();
        }finally {
            zz();
        }
        return o;
    }
//            System.out.println("回滚事务");
//            connection.rollback();
//        }catch (Exception e){
//            System.out.println("事务执行有异常了");
//            e.printStackTrace();
//        }

}
