package com.tencent.f.h;

import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.f.e.d;
import com.tencent.f.h.a;
import com.tencent.f.i.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public final class c extends a implements Handler.Callback {
    private final Handler RUq = d.a("HotPoolLeader", this);
    private final a RUw;

    public c(int i2) {
        AppMethodBeat.i(183358);
        this.RUw = new a(i2);
        AppMethodBeat.o(183358);
    }

    @Override // com.tencent.f.h.d
    public final String getName() {
        return "HotPool";
    }

    @Override // com.tencent.f.h.d
    public final void i(k<?> kVar) {
        AppMethodBeat.i(183359);
        this.RUq.removeCallbacksAndMessages(kVar);
        this.RUw.remove(kVar);
        AppMethodBeat.o(183359);
    }

    public final boolean isBusy() {
        AppMethodBeat.i(183360);
        if (this.RUw.getQueue().size() > 0) {
            AppMethodBeat.o(183360);
            return true;
        }
        AppMethodBeat.o(183360);
        return false;
    }

    public final List<String> hmx() {
        AppMethodBeat.i(183361);
        LinkedList linkedList = new LinkedList();
        for (Runnable runnable : this.RUw.getQueue()) {
            if (runnable instanceof k) {
                linkedList.add(((k) runnable).getKey());
            }
        }
        AppMethodBeat.o(183361);
        return linkedList;
    }

    public final boolean handleMessage(Message message) {
        AppMethodBeat.i(256674);
        Object obj = message.obj;
        if (obj instanceof k) {
            this.RUw.execute((k) obj);
            AppMethodBeat.o(256674);
            return true;
        }
        AppMethodBeat.o(256674);
        return false;
    }

    @Override // com.tencent.f.h.a
    public final void onShutdown() {
        AppMethodBeat.i(183362);
        this.RUw.shutdownNow();
        AppMethodBeat.o(183362);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.f.h.a
    public final a.AbstractC0138a hmw() {
        return this.RUw;
    }

    class a extends ThreadPoolExecutor implements a.AbstractC0138a {
        a(int i2) {
            super(i2, i2, 2147483647L, TimeUnit.HOURS, new LinkedBlockingQueue(), new ThreadFactory() {
                /* class com.tencent.f.h.c.a.AnonymousClass1 */
                AtomicInteger RUu = new AtomicInteger(0);

                {
                    AppMethodBeat.i(183353);
                    AppMethodBeat.o(183353);
                }

                public final Thread newThread(Runnable runnable) {
                    AppMethodBeat.i(183354);
                    Thread a2 = com.tencent.f.c.c.a("HotPool#" + this.RUu.getAndIncrement(), runnable, 7);
                    AppMethodBeat.o(183354);
                    return a2;
                }
            }, new RejectedExecutionHandler() {
                /* class com.tencent.f.h.c.a.AnonymousClass2 */

                public final void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
                }
            });
            AppMethodBeat.i(183355);
            AppMethodBeat.o(183355);
        }

        @Override // com.tencent.f.h.a.AbstractC0138a
        public final void h(k<?> kVar) {
            AppMethodBeat.i(183357);
            long delay = kVar.getDelay(TimeUnit.MILLISECONDS);
            if (delay <= 0) {
                execute(kVar);
                AppMethodBeat.o(183357);
                return;
            }
            c.this.RUq.sendMessageAtTime(c.this.RUq.obtainMessage(0, kVar), delay + SystemClock.uptimeMillis());
            AppMethodBeat.o(183357);
        }
    }
}
