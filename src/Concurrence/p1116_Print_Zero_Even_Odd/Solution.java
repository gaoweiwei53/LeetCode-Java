package p1116_Print_Zero_Even_Odd;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

// Semaphore
public class Solution {
    private int n;
    private Semaphore zeroSema = new Semaphore(1);
    private Semaphore oddSema = new Semaphore(0);//奇数
    private Semaphore evenSema = new Semaphore(0);//偶数

    public Solution(int n) {
        this.n = n;
    }

    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            zeroSema.acquire();
            printNumber.accept(0);
            if ((i & 1) == 1) {//奇数
                oddSema.release();
            } else {
                evenSema.release();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            if ((i & 1) == 0) {//偶数 打印偶数 并释放zero的线程
                evenSema.acquire();
                printNumber.accept(i);
                zeroSema.release();
            }
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            if ((i & 1) == 1) {//奇数，打印奇数，并释放zero的线程
                oddSema.acquire();
                printNumber.accept(i);
                zeroSema.release();
            }
        }
    }
}
// CountDownLatch
class Solution2{
    private int n;

    private CountDownLatch zeroLatch = new CountDownLatch(0);
    private CountDownLatch evenLatch = new CountDownLatch(1);//偶数
    private CountDownLatch oddLatch = new CountDownLatch(1);//奇数

    public Solution2(int n) {
        this.n = n;
    }

    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            zeroLatch.await();
            printNumber.accept(0);//打印0
            zeroLatch = new CountDownLatch(1);
            if ((i & 1) == 1) oddLatch.countDown();//如果是奇数，就打印奇数
            else evenLatch.countDown();

        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            if ((i & 1) == 0) {
                evenLatch.await();//开始打印偶数
                printNumber.accept(i);
                evenLatch = new CountDownLatch(1);
                zeroLatch.countDown();//是否zero线程
            }
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            if ((i & 1) == 1) {
                oddLatch.await();//开始打印奇数
                printNumber.accept(i);
                oddLatch = new CountDownLatch(1);
                zeroLatch.countDown();//是否zero线程
            }
        }
    }

}

// ReentrantLock
class Solution3{
    private int n;

    private volatile int curValue = 0;

    private Lock l = new ReentrantLock();
    private Condition z = l.newCondition();
    private Condition o = l.newCondition();
    private Condition e = l.newCondition();

    public Solution3(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        l.lock();
        try {
            for (int i = 1; i <= n; i++) {

                if (curValue != 0) {
                    z.await();
                }
                printNumber.accept(0);

                if (i % 2 == 1) {
                    curValue = 1;
                    o.signal();
                } else {
                    curValue = 2;
                    e.signal();
                }
            }
        } finally {
            l.unlock();
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {

        l.lock();
        try {
            for (int i = 2; i <= n; i += 2) {
                if (curValue != 2) {
                    e.await();
                }
                printNumber.accept(i);
                curValue = 0;
                z.signal();
            }
        } finally {
            l.unlock();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        l.lock();
        try {
            for (int i = 1; i <= n; i += 2) {

                if (curValue != 1) {
                    o.await();
                }

                printNumber.accept(i);
                curValue = 0;
                z.signal();
            }
        }finally {
            l.unlock();
        }
    }

}
// volatile
class Solution4{
    private int n;

    // 不用锁，直接用 volatile
    private volatile int curValue = 0;

    public Solution4(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {

        for (int i = 1; i <= n; i++) {
            while (curValue != 0) {
                Thread.yield();
            }

            printNumber.accept(0);

            if (i % 2 == 1) {
                curValue = 1;
            } else {
                curValue = 2;
            }

        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i += 2) {
            while (curValue != 2) {
                Thread.yield();
            }

            printNumber.accept(i);
            curValue = 0;
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i += 2) {
            while (curValue != 1) {
                Thread.yield();
            }

            printNumber.accept(i);
            curValue = 0;
        }
    }
}