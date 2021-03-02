package com.google.android.gms.common.api.internal;

import android.os.IBinder;
import com.google.android.gms.common.api.zzc;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.util.NoSuchElementException;

/* access modifiers changed from: package-private */
public final class zzcm implements IBinder.DeathRecipient, zzcn {
    private final WeakReference<BasePendingResult<?>> zzmr;
    private final WeakReference<zzc> zzms;
    private final WeakReference<IBinder> zzmt;

    private zzcm(BasePendingResult<?> basePendingResult, zzc zzc, IBinder iBinder) {
        AppMethodBeat.i(11389);
        this.zzms = new WeakReference<>(zzc);
        this.zzmr = new WeakReference<>(basePendingResult);
        this.zzmt = new WeakReference<>(iBinder);
        AppMethodBeat.o(11389);
    }

    /* synthetic */ zzcm(BasePendingResult basePendingResult, zzc zzc, IBinder iBinder, zzcl zzcl) {
        this(basePendingResult, null, iBinder);
    }

    private final void zzcf() {
        AppMethodBeat.i(11392);
        BasePendingResult<?> basePendingResult = this.zzmr.get();
        zzc zzc = this.zzms.get();
        if (!(zzc == null || basePendingResult == null)) {
            zzc.remove(basePendingResult.zzo().intValue());
        }
        IBinder iBinder = this.zzmt.get();
        if (iBinder != null) {
            try {
                iBinder.unlinkToDeath(this, 0);
                AppMethodBeat.o(11392);
                return;
            } catch (NoSuchElementException e2) {
            }
        }
        AppMethodBeat.o(11392);
    }

    public final void binderDied() {
        AppMethodBeat.i(11391);
        zzcf();
        AppMethodBeat.o(11391);
    }

    @Override // com.google.android.gms.common.api.internal.zzcn
    public final void zzc(BasePendingResult<?> basePendingResult) {
        AppMethodBeat.i(11390);
        zzcf();
        AppMethodBeat.o(11390);
    }
}
