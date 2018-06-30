package com.java.learning.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

/**
 * Description:同步代码的学习（Lock）
 * User:Lee
 * Date:2018/6/30
 */
public class LockApp {

    private Lock lock;

    private int a=0;

    //测试传入的lock为 new ReentrantLock()
    public LockApp(Lock lock){
        this.lock = lock;
    }

    //获取锁，若不成功，直到其他线程释放锁
    public void lockMethod(Thread thread){
        lock.lock();
        runMethod(thread);
    }

    //获取锁，若不成功，直接失败
    public void tryLockMethod(Thread thread){
        if(lock.tryLock()){
            runMethod(thread);
        }else {
            System.out.println("线程"+thread.getName()+"获取锁失败");
        }
    }

    //获取锁，若不成功，按指定时间等待
    public void tryLockWaitMethod(Thread thread) throws Exception{
        if(lock.tryLock(4, TimeUnit.SECONDS)){
            thread.sleep(3500);
            runMethod(thread);
        }else {
            System.out.println("线程"+thread.getName()+"获取锁失败");
        }
    }

    //获取锁，若不成功，直到其他线程释放锁,如果线程正在等待获取锁，则这个线程能够响应中断，即中断线程的等待状态
    public void tryLockInterruptMethod(Thread thread) throws Exception{
        lock.lockInterruptibly();
        thread.sleep(3000);
        runMethod(thread);
    }

    private void runMethod(Thread thread){
        try{
            System.out.println("线程"+thread.getName()+"获取锁,开始:"+a);
            a++;
            System.out.println("线程"+thread.getName()+"获取锁,结束:"+a);
        }catch (Exception e){
            System.out.println("线程"+thread.getName()+"执行异常:"+e.getMessage());
        }finally {
            System.out.println("线程"+thread.getName()+"释放锁");
            lock.unlock();

        }
    }
}
