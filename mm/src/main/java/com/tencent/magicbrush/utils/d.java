package com.tencent.magicbrush.utils;

import com.tencent.magicbrush.a.c;
import com.tencent.magicbrush.handler.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract class d<R> {
    long begin;
    private Object lock = new Object();
    boolean manualFinish = false;
    private R result;
    private Runnable task = new Runnable() {
        /* class com.tencent.magicbrush.utils.d.AnonymousClass1 */

        /* JADX DEBUG: Multi-variable search result rejected for r0v3, resolved type: com.tencent.magicbrush.utils.d */
        /* JADX WARN: Multi-variable type inference failed */
        public final void run() {
            AppMethodBeat.i(161137);
            c.C0193c.i("MicroMsg.SDK.SyncTask", "task run manualFinish = " + d.this.manualFinish, new Object[0]);
            if (d.this.manualFinish) {
                d.this.run();
            } else {
                d.this.setResultFinish(d.this.run());
            }
            d.this.wait = h.ticksToNow(d.this.begin);
            AppMethodBeat.o(161137);
        }
    };
    private final long timeout;
    long wait;

    /* access modifiers changed from: protected */
    public abstract R run();

    public d(long j2) {
        this.timeout = j2;
        this.result = null;
        this.manualFinish = true;
    }

    public final void setResultFinish(R r) {
        c.C0193c.i("MicroMsg.SDK.SyncTask", "setResultFinish ", new Object[0]);
        this.result = r;
        synchronized (this.lock) {
            c.C0193c.i("MicroMsg.SDK.SyncTask", "setResultFinish synchronized", new Object[0]);
            this.lock.notify();
        }
    }

    public final R b(a aVar) {
        if (aVar == null) {
            c.C0193c.d("MicroMsg.SDK.SyncTask", "null handler, task in exec thread, return now", new Object[0]);
            return run();
        }
        c.C0193c.i("MicroMsg.SDK.SyncTask", "sync task exec...", new Object[0]);
        this.begin = h.currentTicks();
        try {
            synchronized (this.lock) {
                c.C0193c.i("MicroMsg.SDK.SyncTask", "sync task exec at synchronized", new Object[0]);
                aVar.a(this.task, false);
                this.lock.wait(this.timeout);
            }
        } catch (InterruptedException e2) {
            c.C0193c.printStackTrace("MicroMsg.SDK.SyncTask", e2, "", new Object[0]);
        }
        long ticksToNow = h.ticksToNow(this.begin);
        c.C0193c.i("MicroMsg.SDK.SyncTask", "sync task done, return=%s, cost=%d(wait=%d, run=%d)", new StringBuilder().append((Object) this.result).toString(), Long.valueOf(ticksToNow), Long.valueOf(this.wait), Long.valueOf(ticksToNow - this.wait));
        return this.result;
    }
}
