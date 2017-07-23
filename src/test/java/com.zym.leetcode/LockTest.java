package com.zym.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by damumu on 2017/7/22.
 */
public class LockTest {
    private List<Integer> list = new ArrayList<>();
    private Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        LockTest lockTest = new LockTest();
        new Thread() {
            @Override
            public void run() {
                lockTest.insert1(Thread.currentThread());
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                lockTest.insert1(Thread.currentThread());
            }
        }.start();
    }

    private void insert(Thread thread) {
        lock.lock();
        try {
            System.out.println(thread.getName() + "获得了锁");
            list.add(0);
        } catch (Exception e) {

        } finally {
            System.out.println(thread.getName() + "释放了锁");
            lock.unlock();
        }
    }

    private void insert1(Thread thread) {
        if (lock.tryLock()) {
            try {
                System.out.println(thread.getName() + "获得了锁");
                Thread.sleep(5);
                list.add(0);
            } catch (Exception e) {

            } finally {
                System.out.println(thread.getName() + "释放了锁");
                lock.unlock();
            }
        }else {
            System.out.println(thread.getName() + "获得锁失败");
        }
    }
}
