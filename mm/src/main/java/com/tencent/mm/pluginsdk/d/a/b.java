package com.tencent.mm.pluginsdk.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public final class b {
    private CountDownLatch JTq = null;

    public final void countDown() {
        AppMethodBeat.i(30933);
        if (this.JTq != null) {
            this.JTq.countDown();
            this.JTq = null;
        }
        AppMethodBeat.o(30933);
    }

    public final void c(long j2, Runnable runnable) {
        AppMethodBeat.i(30934);
        Log.i("MicroMsg.SyncJob", "doAsSyncJob");
        if (this.JTq == null) {
            this.JTq = new CountDownLatch(1);
        }
        MMHandlerThread.postToMainThread(runnable);
        Log.i("MicroMsg.SyncJob", "doAsSyncJob postToMainThread");
        if (this.JTq != null) {
            try {
                this.JTq.await(j2, TimeUnit.MILLISECONDS);
                AppMethodBeat.o(30934);
                return;
            } catch (InterruptedException e2) {
                Log.w("MicroMsg.SyncJob", e2.getMessage());
                Log.printErrStackTrace("MicroMsg.SyncJob", e2, "", new Object[0]);
            }
        }
        AppMethodBeat.o(30934);
    }
}
