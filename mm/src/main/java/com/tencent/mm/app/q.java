package com.tencent.mm.app;

import android.os.HandlerThread;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.vending.h.d;
import com.tencent.mm.vending.h.h;

public final class q {
    private static q dlh;
    HandlerThread dli;
    MMHandler handler = new MMHandler(this.dli.getLooper());
    d mScheduler;

    public static q Ws() {
        AppMethodBeat.i(19443);
        if (dlh == null) {
            dlh = new q("initThread");
        }
        q qVar = dlh;
        AppMethodBeat.o(19443);
        return qVar;
    }

    private q(String str) {
        AppMethodBeat.i(19444);
        this.dli = new HandlerThread(str, 10);
        this.dli.start();
        this.mScheduler = new h(com.tencent.mm.co.d.b(this.handler), str);
        AppMethodBeat.o(19444);
    }

    public final void setHighPriority() {
        AppMethodBeat.i(19445);
        if (this.dli == null || !this.dli.isAlive()) {
            Log.e("MicroMsg.InitThreadController", "setHighPriority failed thread is dead");
            AppMethodBeat.o(19445);
            return;
        }
        int threadId = this.dli.getThreadId();
        try {
            if (-8 == Process.getThreadPriority(threadId)) {
                Log.w("MicroMsg.InitThreadController", "setHighPriority No Need.");
                AppMethodBeat.o(19445);
                return;
            }
            Process.setThreadPriority(threadId, -8);
            Log.i("MicroMsg.InitThreadController", "InitThreadController:%d setHighPriority to %d", Integer.valueOf(threadId), Integer.valueOf(Process.getThreadPriority(threadId)));
            AppMethodBeat.o(19445);
        } catch (Exception e2) {
            Log.w("MicroMsg.InitThreadController", "thread:%d setHighPriority failed", Integer.valueOf(threadId));
            Log.printErrStackTrace("MicroMsg.InitThreadController", e2, "", new Object[0]);
            AppMethodBeat.o(19445);
        }
    }
}
