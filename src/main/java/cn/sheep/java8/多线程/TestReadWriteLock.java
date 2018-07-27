package cn.sheep.java8.多线程;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

//直接加lock，读写都加锁
//读之间不互斥
//写得互斥
//写操作独占线程
public class TestReadWriteLock {
    public static void main(String[] args) {

        ReadWriteLockDemo rw = new ReadWriteLockDemo();

        new Thread(new Runnable() {
            @Override
            public void run() {
                rw.set((int)(Math.random()*100));
            }
        },"write").start();

        for (int i = 0; i < 100; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    rw.get();
                }
            }).start();
        }

    }
}


class ReadWriteLockDemo{
    private int number = 0;

    private ReadWriteLock lock = new ReentrantReadWriteLock();

    //读
    public void get(){
        lock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+":"+number);
        }finally {
            lock.readLock().unlock();
        }
    }
    //写
    public void set(int number){
        lock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName());

            this.number=number;
        }finally {
            lock.writeLock().unlock();
        }
    }


}