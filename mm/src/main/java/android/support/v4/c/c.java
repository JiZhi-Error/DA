package android.support.v4.c;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public final class c {
    private Handler.Callback NI = new Handler.Callback() {
        /* class android.support.v4.c.c.AnonymousClass1 */

        public final boolean handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    c cVar = c.this;
                    synchronized (cVar.mLock) {
                        if (!cVar.mHandler.hasMessages(1)) {
                            cVar.mThread.quit();
                            cVar.mThread = null;
                            cVar.mHandler = null;
                            break;
                        } else {
                            break;
                        }
                    }
                case 1:
                    c cVar2 = c.this;
                    ((Runnable) message.obj).run();
                    synchronized (cVar2.mLock) {
                        cVar2.mHandler.removeMessages(0);
                        cVar2.mHandler.sendMessageDelayed(cVar2.mHandler.obtainMessage(0), (long) cVar2.NJ);
                    }
                    break;
            }
            return true;
        }
    };
    final int NJ;
    private int mGeneration;
    Handler mHandler;
    final Object mLock = new Object();
    private final int mPriority;
    HandlerThread mThread;
    private final String mThreadName;

    public interface a<T> {
        void D(T t);
    }

    public c(String str) {
        this.mThreadName = str;
        this.mPriority = 10;
        this.NJ = 10000;
        this.mGeneration = 0;
    }

    /* access modifiers changed from: package-private */
    public final void post(Runnable runnable) {
        synchronized (this.mLock) {
            if (this.mThread == null) {
                this.mThread = new HandlerThread(this.mThreadName, this.mPriority);
                this.mThread.start();
                this.mHandler = new Handler(this.mThread.getLooper(), this.NI);
                this.mGeneration++;
            }
            this.mHandler.removeMessages(0);
            this.mHandler.sendMessage(this.mHandler.obtainMessage(1, runnable));
        }
    }

    public final <T> T a(final Callable<T> callable, int i2) {
        final ReentrantLock reentrantLock = new ReentrantLock();
        final Condition newCondition = reentrantLock.newCondition();
        final AtomicReference atomicReference = new AtomicReference();
        final AtomicBoolean atomicBoolean = new AtomicBoolean(true);
        post(new Runnable() {
            /* class android.support.v4.c.c.AnonymousClass3 */

            public final void run() {
                try {
                    atomicReference.set(callable.call());
                } catch (Exception e2) {
                }
                reentrantLock.lock();
                try {
                    atomicBoolean.set(false);
                    newCondition.signal();
                } finally {
                    reentrantLock.unlock();
                }
            }
        });
        reentrantLock.lock();
        try {
            if (!atomicBoolean.get()) {
                return (T) atomicReference.get();
            }
            long nanos = TimeUnit.MILLISECONDS.toNanos((long) i2);
            do {
                try {
                    nanos = newCondition.awaitNanos(nanos);
                } catch (InterruptedException e2) {
                }
                if (!atomicBoolean.get()) {
                    T t = (T) atomicReference.get();
                    reentrantLock.unlock();
                    return t;
                }
            } while (nanos > 0);
            throw new InterruptedException("timeout");
        } finally {
            reentrantLock.unlock();
        }
    }
}
