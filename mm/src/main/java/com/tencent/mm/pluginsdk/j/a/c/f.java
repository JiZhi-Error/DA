package com.tencent.mm.pluginsdk.j.a.c;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.j.a.c.f.b;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RunnableFuture;

public abstract class f<T extends b> {
    final Map<String, Future<?>> JZN = new ConcurrentHashMap();
    final Map<String, b> pendingRequests = new ConcurrentHashMap();

    public interface b {
        String gnA();
    }

    /* access modifiers changed from: protected */
    public abstract d a(T t);

    /* access modifiers changed from: protected */
    public abstract com.tencent.f.b gnM();

    /* access modifiers changed from: protected */
    public final void b(T t) {
        this.pendingRequests.put(t.gnA(), t);
        gnM().submit(a(t));
    }

    public final boolean bec(String str) {
        return this.JZN.containsKey(str);
    }

    public final synchronized boolean bed(String str) {
        return this.JZN.containsKey(str) || this.pendingRequests.containsKey(str);
    }

    /* access modifiers changed from: protected */
    public final void Zb(String str) {
        Future<?> remove = this.JZN.remove(str);
        if (remove != null) {
            remove.cancel(true);
        }
        this.pendingRequests.remove(str);
    }

    public class a extends com.tencent.f.b {
        public a(String str, int i2, int i3, BlockingQueue<Runnable> blockingQueue) {
            super(str, i2, i3, blockingQueue);
        }

        /* access modifiers changed from: protected */
        @Override // java.util.concurrent.AbstractExecutorService
        public final <V> RunnableFuture<V> newTaskFor(Runnable runnable, V v) {
            AppMethodBeat.i(152011);
            if (runnable instanceof d) {
                c cVar = new c(runnable, v, ((d) runnable).JZP);
                AppMethodBeat.o(152011);
                return cVar;
            }
            RunnableFuture<V> newTaskFor = super.newTaskFor(runnable, v);
            AppMethodBeat.o(152011);
            return newTaskFor;
        }

        @Override // com.tencent.f.b
        public final void terminated() {
            AppMethodBeat.i(152012);
            f.this.JZN.clear();
            super.terminated();
            AppMethodBeat.o(152012);
        }

        @Override // com.tencent.f.b
        public final void beforeExecute(Thread thread, Runnable runnable) {
            AppMethodBeat.i(152013);
            if (runnable instanceof c) {
                c cVar = (c) runnable;
                if (f.this.JZN.containsKey(cVar.JZP.gnA())) {
                    cVar.cancel(false);
                } else {
                    f.this.JZN.put(cVar.JZP.gnA(), cVar);
                    f.this.pendingRequests.remove(cVar.JZP.gnA());
                }
            } else {
                Log.i("MicroMsg.ResDownloader.IOWorker", "r = %s is not RequestFutureTask<?>", runnable.getClass().getSimpleName());
            }
            super.beforeExecute(thread, runnable);
            AppMethodBeat.o(152013);
        }

        @Override // com.tencent.f.b
        public final void afterExecute(Runnable runnable, Throwable th) {
            AppMethodBeat.i(152014);
            if (runnable instanceof c) {
                c cVar = (c) runnable;
                f.this.JZN.remove(cVar.JZP.gnA());
                f.this.pendingRequests.remove(cVar.JZP.gnA());
            } else {
                Log.i("MicroMsg.ResDownloader.IOWorker", "r = %s is not RequestFutureTask<?>", runnable.getClass().getSimpleName());
            }
            super.afterExecute(runnable, th);
            AppMethodBeat.o(152014);
        }
    }

    protected static class c<V> extends FutureTask<V> {
        protected final b JZP;

        public c(Runnable runnable, V v, b bVar) {
            super(runnable, v);
            this.JZP = bVar;
        }
    }

    public static abstract class d<Req extends b> implements Runnable {
        private final Req JZP;

        /* access modifiers changed from: protected */
        public Req bwt() {
            return this.JZP;
        }

        protected d(Req req) {
            this.JZP = req;
        }

        public void run() {
            if (Process.getThreadPriority(Process.myTid()) != 10) {
                Process.setThreadPriority(10);
            }
        }
    }
}
