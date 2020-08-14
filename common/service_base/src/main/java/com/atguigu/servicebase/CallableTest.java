package com.atguigu.servicebase;

import io.swagger.models.auth.In;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class CallableTest implements Callable<Integer> {
    public static void main(String[] args) {

        CallableTest ct = new CallableTest();
        FutureTask<Integer> ft = new FutureTask<>(ct);
        for (int i = 0; i < 100; i++){
            System.out.println(Thread.currentThread().getName() + "的循环变量i的值" + i);
            if (i == 20) {
                new Thread(ft, "FutureTask").start();
            }
            try{
                System.out.println("子线程的返回值：" + ft.get());

            }catch (Exception e){
                e.printStackTrace();
            }

        }
    }
    @Override
    public Integer call() throws Exception {
        int i = 0;
        for (; i < 50; i++){
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
        return i;
    }
}
