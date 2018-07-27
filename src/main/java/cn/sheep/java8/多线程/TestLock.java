package cn.sheep.java8.多线程;

/*
* 出现线程异常
* */

public class TestLock {
    public static void main(String[] args) {

        Ticket ticket = new Ticket();

        new Thread(ticket,"l窗口").start();
        new Thread(ticket,"2窗口").start();
        new Thread(ticket,"3窗口").start();

    }
}

class Ticket implements Runnable{
    private  int tick = 100;

    @Override
    public void run() {
        while (tick >0){
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "完成售票，余票为"+ --tick);
        }
    }
}