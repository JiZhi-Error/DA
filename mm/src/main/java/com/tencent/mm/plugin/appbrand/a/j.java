package com.tencent.mm.plugin.appbrand.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;

public abstract class j<R> {
    long begin;
    private final Object lock;
    public volatile MMHandler mHandler;
    boolean manualFinish;
    public R result;
    public final Runnable task;
    private final long timeout;
    long wait;

    /* access modifiers changed from: protected */
    public abstract R run();

    public j() {
        this(0, null);
    }

    public j(long j2, R r) {
        this.lock = new Object();
        this.manualFinish = false;
        this.task = new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.a.j.AnonymousClass1 */

            /* JADX DEBUG: Multi-variable search result rejected for r0v3, resolved type: com.tencent.mm.plugin.appbrand.a.j */
            /* JADX WARN: Multi-variable type inference failed */
            public final void run() {
                AppMethodBeat.i(162078);
                Log.i("MicroMsg.SDK.SyncTask", "task run manualFinish = " + j.this.manualFinish);
                if (j.this.manualFinish) {
                    j.this.run();
                } else {
                    j.this.setResultFinish(j.this.run());
                }
                j.this.wait = Util.ticksToNow(j.this.begin);
                AppMethodBeat.o(162078);
            }
        };
        this.timeout = j2;
        this.result = r;
    }

    public final void setResultFinish(R r) {
        Log.i("MicroMsg.SDK.SyncTask", "setResultFinish ");
        this.result = r;
        synchronized (this.lock) {
            Log.i("MicroMsg.SDK.SyncTask", "setResultFinish synchronized");
            this.lock.notify();
        }
    }

    public final R exec(MMHandler mMHandler) {
        this.mHandler = mMHandler;
        Log.i("MicroMsg.SDK.SyncTask", "sync task exec...");
        if (Thread.currentThread().getId() == mMHandler.getLooper().getThread().getId()) {
            Log.i("MicroMsg.SDK.SyncTask", "same tid, task in exec thread, return now");
            return run();
        }
        this.begin = Util.currentTicks();
        try {
            synchronized (this.lock) {
                Log.i("MicroMsg.SDK.SyncTask", "sync task exec at synchronized");
                mMHandler.post(this.task);
                this.lock.wait(this.timeout);
            }
        } catch (InterruptedException e2) {
            Log.printErrStackTrace("MicroMsg.SDK.SyncTask", e2, "", new Object[0]);
        }
        long ticksToNow = Util.ticksToNow(this.begin);
        Log.i("MicroMsg.SDK.SyncTask", "sync task done, return=%s, cost=%d(wait=%d, run=%d)", new StringBuilder().append((Object) this.result).toString(), Long.valueOf(ticksToNow), Long.valueOf(this.wait), Long.valueOf(ticksToNow - this.wait));
        return this.result;
    }
}
