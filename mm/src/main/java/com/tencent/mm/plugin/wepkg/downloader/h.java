package com.tencent.mm.plugin.wepkg.downloader;

import com.tencent.f.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RunnableFuture;

public final class h extends b {
    public h(String str, BlockingQueue<Runnable> blockingQueue) {
        super(str, 3, 3, blockingQueue);
    }

    /* access modifiers changed from: protected */
    @Override // java.util.concurrent.AbstractExecutorService
    public final <V> RunnableFuture<V> newTaskFor(Runnable runnable, V v) {
        AppMethodBeat.i(110620);
        if (runnable instanceof c) {
            e eVar = new e(runnable, v, (c) runnable);
            AppMethodBeat.o(110620);
            return eVar;
        }
        RunnableFuture<V> newTaskFor = super.newTaskFor(runnable, v);
        AppMethodBeat.o(110620);
        return newTaskFor;
    }

    @Override // com.tencent.f.b
    public final void terminated() {
        AppMethodBeat.i(110621);
        d gkL = d.gkL();
        if (gkL.JMi != null) {
            gkL.JMi.clear();
        }
        super.terminated();
        AppMethodBeat.o(110621);
    }

    @Override // com.tencent.f.b
    public final void beforeExecute(Thread thread, Runnable runnable) {
        AppMethodBeat.i(110622);
        super.beforeExecute(thread, runnable);
        Log.i("MicroMsg.Wepkg.WePkgThreadPoolExecutor", "beforeExecute");
        AppMethodBeat.o(110622);
    }

    @Override // com.tencent.f.b
    public final void afterExecute(Runnable runnable, Throwable th) {
        AppMethodBeat.i(110623);
        if (runnable instanceof e) {
            e eVar = (e) runnable;
            if (!(eVar.JMw == null || eVar.JMw.JLZ == null)) {
                d.gkL().bcv(eVar.JMw.JLZ.JMx);
                Log.i("MicroMsg.Wepkg.WePkgThreadPoolExecutor", "remove download task");
            }
        }
        Log.i("MicroMsg.Wepkg.WePkgThreadPoolExecutor", "afterExecute");
        super.afterExecute(runnable, th);
        AppMethodBeat.o(110623);
    }
}
