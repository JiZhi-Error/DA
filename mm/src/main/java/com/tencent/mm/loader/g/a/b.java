package com.tencent.mm.loader.g.a;

import com.tencent.mm.loader.g.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public final class b extends com.tencent.f.b implements a {
    private ReentrantLock ibI = new ReentrantLock();
    private Condition ibJ = this.ibI.newCondition();
    private BlockingQueue<Runnable> ibK;
    private boolean isPaused;

    public b(String str, int i2, int i3, BlockingQueue<Runnable> blockingQueue) {
        super(str, i2, i3, blockingQueue);
        this.ibK = blockingQueue;
    }

    @Override // com.tencent.f.b
    public final void beforeExecute(Thread thread, Runnable runnable) {
        super.beforeExecute(thread, runnable);
        this.ibI.lock();
        while (this.isPaused) {
            try {
                this.ibJ.await();
            } catch (Exception e2) {
                thread.interrupt();
                Log.w("MicroMsg.Loader.imageloader.DefaultThreadPoolExecutor", "[cpan] before execute exception:%s", e2.toString());
                return;
            } finally {
                this.ibI.unlock();
            }
        }
    }

    @Override // com.tencent.f.b
    public final void execute(Runnable runnable) {
        super.execute(runnable);
    }
}
