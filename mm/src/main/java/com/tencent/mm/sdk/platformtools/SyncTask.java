package com.tencent.mm.sdk.platformtools;

import com.tencent.f.j.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract class SyncTask<R> {
    private static final String TAG = "MicroMsg.SDK.SyncTask";
    private long begin;
    private Object lock;
    private boolean manualFinish;
    private R result;
    private Runnable task;
    private final long timeout;
    private long wait;

    /* access modifiers changed from: protected */
    public abstract R run();

    public SyncTask() {
        this(0, null);
    }

    public SyncTask(long j2, R r, boolean z) {
        this.lock = new Object();
        this.manualFinish = false;
        this.task = new Runnable() {
            /* class com.tencent.mm.sdk.platformtools.SyncTask.AnonymousClass1 */

            /* JADX DEBUG: Multi-variable search result rejected for r0v3, resolved type: com.tencent.mm.sdk.platformtools.SyncTask */
            /* JADX WARN: Multi-variable type inference failed */
            public void run() {
                AppMethodBeat.i(157837);
                Log.i(SyncTask.TAG, "task run manualFinish = " + SyncTask.this.manualFinish);
                if (SyncTask.this.manualFinish) {
                    SyncTask.this.run();
                } else {
                    SyncTask.this.setResultFinish(SyncTask.this.run());
                }
                SyncTask.this.wait = Util.ticksToNow(SyncTask.this.begin);
                AppMethodBeat.o(157837);
            }
        };
        this.timeout = j2;
        this.result = r;
        this.manualFinish = z;
    }

    public SyncTask(long j2, R r) {
        this.lock = new Object();
        this.manualFinish = false;
        this.task = new Runnable() {
            /* class com.tencent.mm.sdk.platformtools.SyncTask.AnonymousClass1 */

            /* JADX DEBUG: Multi-variable search result rejected for r0v3, resolved type: com.tencent.mm.sdk.platformtools.SyncTask */
            /* JADX WARN: Multi-variable type inference failed */
            public void run() {
                AppMethodBeat.i(157837);
                Log.i(SyncTask.TAG, "task run manualFinish = " + SyncTask.this.manualFinish);
                if (SyncTask.this.manualFinish) {
                    SyncTask.this.run();
                } else {
                    SyncTask.this.setResultFinish(SyncTask.this.run());
                }
                SyncTask.this.wait = Util.ticksToNow(SyncTask.this.begin);
                AppMethodBeat.o(157837);
            }
        };
        this.timeout = j2;
        this.result = r;
    }

    public void setResultFinish(R r) {
        Log.i(TAG, "setResultFinish ");
        this.result = r;
        synchronized (this.lock) {
            Log.i(TAG, "setResultFinish synchronized");
            this.lock.notify();
        }
    }

    public R exec(MMHandler mMHandler) {
        boolean equals;
        if (mMHandler == null) {
            Log.d(TAG, "null handler, task in exec thread, return now");
            return run();
        }
        Log.i(TAG, "sync task exec...");
        if (mMHandler.getLooper() != null) {
            equals = Thread.currentThread().getId() == mMHandler.getLooper().getThread().getId();
        } else {
            equals = mMHandler.getSerialTag().equals(a.hmF());
        }
        if (equals) {
            Log.i(TAG, "same tid, task in exec thread, return now");
            return run();
        }
        this.begin = Util.currentTicks();
        try {
            synchronized (this.lock) {
                Log.i(TAG, "sync task exec at synchronized");
                mMHandler.post(this.task);
                this.lock.wait(this.timeout);
            }
        } catch (InterruptedException e2) {
            Log.printErrStackTrace(TAG, e2, "", new Object[0]);
        }
        long ticksToNow = Util.ticksToNow(this.begin);
        Log.i(TAG, "sync task done, return=%s, cost=%d(wait=%d, run=%d)", new StringBuilder().append((Object) this.result).toString(), Long.valueOf(ticksToNow), Long.valueOf(this.wait), Long.valueOf(ticksToNow - this.wait));
        return this.result;
    }
}
