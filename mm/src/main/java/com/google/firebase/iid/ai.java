package com.google.firebase.iid;

import android.content.Context;
import android.util.Log;
import com.google.android.gms.tasks.Task;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import javax.annotation.concurrent.GuardedBy;

public final class ai {
    @GuardedBy("MessengerIpcClient.class")
    private static ai bME;
    final Context bLv;
    final ScheduledExecutorService bMF;
    @GuardedBy("this")
    private aj bMG = new aj(this, (byte) 0);
    @GuardedBy("this")
    private int bMH = 1;

    private ai(Context context, ScheduledExecutorService scheduledExecutorService) {
        AppMethodBeat.i(4254);
        this.bMF = scheduledExecutorService;
        this.bLv = context.getApplicationContext();
        AppMethodBeat.o(4254);
    }

    public static synchronized ai as(Context context) {
        ai aiVar;
        synchronized (ai.class) {
            AppMethodBeat.i(4253);
            if (bME == null) {
                bME = new ai(context, Executors.newSingleThreadScheduledExecutor());
            }
            aiVar = bME;
            AppMethodBeat.o(4253);
        }
        return aiVar;
    }

    public final synchronized <T> Task<T> a(c<T> cVar) {
        Task<T> task;
        AppMethodBeat.i(4255);
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            String valueOf = String.valueOf(cVar);
            new StringBuilder(String.valueOf(valueOf).length() + 9).append("Queueing ").append(valueOf);
        }
        if (!this.bMG.b(cVar)) {
            this.bMG = new aj(this, (byte) 0);
            this.bMG.b(cVar);
        }
        task = cVar.bLt.getTask();
        AppMethodBeat.o(4255);
        return task;
    }

    public final synchronized int yw() {
        int i2;
        i2 = this.bMH;
        this.bMH = i2 + 1;
        return i2;
    }
}
