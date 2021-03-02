package com.tencent.f.h;

import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.f.c.c;
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

public final class b extends a implements Handler.Callback {
    private final a RUp;
    private final Handler RUq = d.a("ColdPoolLeader", this);

    public b(int i2, int i3) {
        AppMethodBeat.i(183349);
        this.RUp = new a(i2, i3);
        AppMethodBeat.o(183349);
    }

    @Override // com.tencent.f.h.d
    public final String getName() {
        return "ColdPool";
    }

    @Override // com.tencent.f.h.d
    public final void i(k<?> kVar) {
        AppMethodBeat.i(183350);
        this.RUq.removeCallbacksAndMessages(kVar);
        this.RUp.remove(kVar);
        AppMethodBeat.o(183350);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.f.h.a
    public final void onShutdown() {
        AppMethodBeat.i(183351);
        this.RUp.shutdown();
        AppMethodBeat.o(183351);
    }

    public final List<String> hmx() {
        AppMethodBeat.i(183352);
        LinkedList linkedList = new LinkedList();
        for (Runnable runnable : this.RUp.getQueue()) {
            if (runnable instanceof k) {
                linkedList.add(((k) runnable).getKey());
            } else {
                linkedList.add(runnable.toString());
            }
        }
        AppMethodBeat.o(183352);
        return linkedList;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.f.h.a
    public final a.AbstractC0138a hmw() {
        return this.RUp;
    }

    public final boolean handleMessage(Message message) {
        AppMethodBeat.i(256673);
        Object obj = message.obj;
        if (obj instanceof k) {
            this.RUp.execute((k) obj);
            AppMethodBeat.o(256673);
            return true;
        }
        AppMethodBeat.o(256673);
        return false;
    }

    class a extends ThreadPoolExecutor implements a.AbstractC0138a {
        private int RUr;
        private int RUs = 1;
        private int dvP;

        a(int i2, int i3) {
            super(i2, i3, 10, TimeUnit.MINUTES, new LinkedBlockingQueue(), new ThreadFactory() {
                /* class com.tencent.f.h.b.a.AnonymousClass1 */
                AtomicInteger RUu = new AtomicInteger(0);

                {
                    AppMethodBeat.i(183341);
                    AppMethodBeat.o(183341);
                }

                public final Thread newThread(Runnable runnable) {
                    AppMethodBeat.i(183342);
                    Thread a2 = c.a("ColdPool#" + this.RUu.getAndIncrement(), runnable, 5);
                    AppMethodBeat.o(183342);
                    return a2;
                }
            }, new RejectedExecutionHandler() {
                /* class com.tencent.f.h.b.a.AnonymousClass2 */

                public final void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
                }
            });
            AppMethodBeat.i(183345);
            this.dvP = i2;
            this.RUr = i3;
            AppMethodBeat.o(183345);
        }

        @Override // com.tencent.f.h.a.AbstractC0138a
        public final void h(k<?> kVar) {
            AppMethodBeat.i(183347);
            long delay = kVar.getDelay(TimeUnit.MILLISECONDS);
            if (delay <= 0) {
                execute(kVar);
                AppMethodBeat.o(183347);
                return;
            }
            b.this.RUq.sendMessageAtTime(b.this.RUq.obtainMessage(0, kVar), delay + SystemClock.uptimeMillis());
            AppMethodBeat.o(183347);
        }

        public final void execute(Runnable runnable) {
            AppMethodBeat.i(256672);
            int corePoolSize = getCorePoolSize();
            if (getQueue().size() >= this.RUs * 10 && corePoolSize + 1 <= this.RUr) {
                setCorePoolSize(corePoolSize + 1);
                com.tencent.f.d.RSS.w("ColdPool", "increment to expand cold pool; queue size=%s currentCoreSize=%s bufferSizeFactor=%s", Integer.valueOf(getQueue().size()), Integer.valueOf(corePoolSize), Integer.valueOf(this.RUs));
                this.RUs++;
            }
            super.execute(runnable);
            AppMethodBeat.o(256672);
        }

        /* access modifiers changed from: protected */
        public final void afterExecute(Runnable runnable, Throwable th) {
            AppMethodBeat.i(183348);
            super.afterExecute(runnable, th);
            if (getQueue().isEmpty() && getCorePoolSize() > this.dvP) {
                setCorePoolSize(this.dvP);
                this.RUs = 1;
                com.tencent.f.d.RSS.w("ColdPool", "reset to corePoolSize(%s)", Integer.valueOf(this.dvP));
            }
            AppMethodBeat.o(183348);
        }
    }
}
