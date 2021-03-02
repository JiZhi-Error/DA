package android.arch.a.a;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class b extends c {
    private ExecutorService bO = Executors.newFixedThreadPool(2);
    private final Object mLock = new Object();
    private volatile Handler mMainHandler;

    @Override // android.arch.a.a.c
    public final void e(Runnable runnable) {
        this.bO.execute(runnable);
    }

    @Override // android.arch.a.a.c
    public final void postToMainThread(Runnable runnable) {
        if (this.mMainHandler == null) {
            synchronized (this.mLock) {
                if (this.mMainHandler == null) {
                    this.mMainHandler = new Handler(Looper.getMainLooper());
                }
            }
        }
        this.mMainHandler.post(runnable);
    }

    @Override // android.arch.a.a.c
    public final boolean isMainThread() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }
}
