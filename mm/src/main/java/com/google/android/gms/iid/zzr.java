package com.google.android.gms.iid;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.tasks.Task;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import javax.annotation.concurrent.GuardedBy;

public final class zzr {
    private final ScheduledExecutorService zzbz;
    @GuardedBy("this")
    private zzt zzca;
    @GuardedBy("this")
    private int zzcb;
    private final Context zzk;

    public zzr(Context context) {
        this(context, Executors.newSingleThreadScheduledExecutor());
        AppMethodBeat.i(2553);
        AppMethodBeat.o(2553);
    }

    private zzr(Context context, ScheduledExecutorService scheduledExecutorService) {
        AppMethodBeat.i(2554);
        this.zzca = new zzt(this);
        this.zzcb = 1;
        this.zzk = context.getApplicationContext();
        this.zzbz = scheduledExecutorService;
        AppMethodBeat.o(2554);
    }

    private final synchronized <T> Task<T> zzd(zzz<T> zzz) {
        Task<T> task;
        AppMethodBeat.i(2556);
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            String valueOf = String.valueOf(zzz);
            new StringBuilder(String.valueOf(valueOf).length() + 9).append("Queueing ").append(valueOf);
        }
        if (!this.zzca.zze(zzz)) {
            this.zzca = new zzt(this);
            this.zzca.zze(zzz);
        }
        task = zzz.zzcl.getTask();
        AppMethodBeat.o(2556);
        return task;
    }

    private final synchronized int zzq() {
        int i2;
        i2 = this.zzcb;
        this.zzcb = i2 + 1;
        return i2;
    }

    public final Task<Bundle> zzd(int i2, Bundle bundle) {
        AppMethodBeat.i(2555);
        Task<Bundle> zzd = zzd(new zzab(zzq(), 1, bundle));
        AppMethodBeat.o(2555);
        return zzd;
    }
}
