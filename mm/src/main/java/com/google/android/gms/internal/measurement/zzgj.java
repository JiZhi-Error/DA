package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.Preconditions;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MAlarmHandler;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/* access modifiers changed from: package-private */
public final class zzgj<V> extends FutureTask<V> implements Comparable<zzgj> {
    private final String zzaly;
    private final /* synthetic */ zzgg zzalz;
    private final long zzama = zzgg.zzalx.getAndIncrement();
    final boolean zzamb;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzgj(zzgg zzgg, Runnable runnable, boolean z, String str) {
        super(runnable, null);
        this.zzalz = zzgg;
        AppMethodBeat.i(1579);
        Preconditions.checkNotNull(str);
        this.zzaly = str;
        this.zzamb = false;
        if (this.zzama == MAlarmHandler.NEXT_FIRE_INTERVAL) {
            zzgg.zzge().zzim().log("Tasks index overflow");
        }
        AppMethodBeat.o(1579);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzgj(zzgg zzgg, Callable<V> callable, boolean z, String str) {
        super(callable);
        this.zzalz = zzgg;
        AppMethodBeat.i(1578);
        Preconditions.checkNotNull(str);
        this.zzaly = str;
        this.zzamb = z;
        if (this.zzama == MAlarmHandler.NEXT_FIRE_INTERVAL) {
            zzgg.zzge().zzim().log("Tasks index overflow");
        }
        AppMethodBeat.o(1578);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(zzgj zzgj) {
        AppMethodBeat.i(1581);
        zzgj zzgj2 = zzgj;
        if (this.zzamb != zzgj2.zzamb) {
            if (this.zzamb) {
                AppMethodBeat.o(1581);
                return -1;
            }
            AppMethodBeat.o(1581);
            return 1;
        } else if (this.zzama < zzgj2.zzama) {
            AppMethodBeat.o(1581);
            return -1;
        } else if (this.zzama > zzgj2.zzama) {
            AppMethodBeat.o(1581);
            return 1;
        } else {
            this.zzalz.zzge().zzin().zzg("Two tasks share the same index. index", Long.valueOf(this.zzama));
            AppMethodBeat.o(1581);
            return 0;
        }
    }

    /* access modifiers changed from: protected */
    public final void setException(Throwable th) {
        AppMethodBeat.i(1580);
        this.zzalz.zzge().zzim().zzg(this.zzaly, th);
        if (th instanceof zzgh) {
            Thread.getDefaultUncaughtExceptionHandler().uncaughtException(Thread.currentThread(), th);
        }
        super.setException(th);
        AppMethodBeat.o(1580);
    }
}
