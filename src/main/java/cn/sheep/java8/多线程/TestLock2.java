package cn.sheep.java8.多线程;

/*
* 出现线程异常
* */

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestLock2 {
    public static void main(String[] args) {

        Ticket2 ticket = new Ticket2();

        new Thread(ticket,"l窗口").start();
        new Thread(ticket,"2窗口").start();
        new Thread(ticket,"3窗口").start();

    }
}

class Ticket2 implements Runnable{
    private  int tick = 100;

    private Lock lock = new ReentrantLock();

    @Override
    public void run() {
        while (tick >0){
            lock.lock();
            try {
                Thread.sleep(200);
                System.out.println(Thread.currentThread().getName() + "完成售票，余票为"+ --tick);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }
    }
}