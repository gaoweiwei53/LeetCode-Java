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
            // acquire()减少一个permit
            zeroSema.acquire();
            printNumber.accept(0);
            if ((i & 1) == 1) {//奇数
                // release()增加一个permit
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
    public static void main(String[] args) {
        Solution zeroEvenOdd = new Solution(6);
        new Thread(() -> {
            try {
                zeroEvenOdd.zero(System.out::print);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                zeroEvenOdd.even(System.out::print);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                zeroEvenOdd.odd(System.out::print);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
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

    private volatile int start = 1;

    private volatile int state;
    private Lock lock = new ReentrantLock();
    private Condition zero = lock.newCondition();
    private Condition even = lock.newCondition();
    private Condition odd = lock.newCondition();

    public Solution3(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        lock.lock();
        try {
            while (start <= n) {
                if (state != 0) {
                    zero.await();
                }
                printNumber.accept(0);
                if (start % 2 == 0) {
                    state = 2;
                    even.signal();
                } else {
                    state = 1;
                    odd.signal();
                }
                zero.await();
            }
            // 这里啥意思
            odd.signal();
            even.signal();
        } finally {
            lock.unlock();
        }
    }

    //偶数
    public void even(IntConsumer printNumber) throws InterruptedException {
        lock.lock();
        try {
            while (start <= n) {
                if (state != 2) {
                    even.await();
                } else {
                    printNumber.accept(start++);
                    state = 0;
                    zero.signal();
                }
            }
        } finally {
            lock.unlock();
        }
    }

    //基数
    public void odd(IntConsumer printNumber) throws InterruptedException {
        lock.lock();
        try {
            while (start <= n) {
                if (state != 1) {
                    odd.await();
                } else {
                    printNumber.accept(start++);
                    state = 0;
                    zero.signal();
                }
            }
        } finally {
            lock.unlock();
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