package com.google.android.gms.internal.measurement;

import android.os.Handler;
import com.google.android.gms.common.internal.Preconditions;

/* access modifiers changed from: package-private */
public abstract class zzem {
    private static volatile Handler handler;
    private final zzhi zzafj;
    private final Runnable zzyd;
    private volatile long zzye;

    zzem(zzhi zzhi) {
        Preconditions.checkNotNull(zzhi);
        this.zzafj = zzhi;
        this.zzyd = new zzen(this, zzhi);
    }

    private final Handler getHandler() {
        Handler handler2;
        if (handler != null) {
            return handler;
        }
        synchronized (zzem.class) {
            if (handler == null) {
                handler = new Handler(this.zzafj.getContext().getMainLooper());
            }
            handler2 = handler;
        }
        return handler2;
    }

    /* access modifiers changed from: package-private */
    public final void cancel() {
        this.zzye = 0;
        getHandler().removeCallbacks(this.zzyd);
    }

    public abstract void run();

    public final boolean zzef() {
        return this.zzye != 0;
    }

    public final void zzh(long j2) {
        cancel();
        if (j2 >= 0) {
            this.zzye = this.zzafj.zzbt().currentTimeMillis();
            if (!getHandler().postDelayed(this.zzyd, j2)) {
                this.zzafj.zzge().zzim().zzg("Failed to schedule delayed post. time", Long.valueOf(j2));
            }
        }
    }
}
