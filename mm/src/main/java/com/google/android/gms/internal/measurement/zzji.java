package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* access modifiers changed from: package-private */
public final class zzji extends zzem {
    private final /* synthetic */ zzjh zzapx;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzji(zzjh zzjh, zzhi zzhi) {
        super(zzhi);
        this.zzapx = zzjh;
    }

    @Override // com.google.android.gms.internal.measurement.zzem
    public final void run() {
        AppMethodBeat.i(1915);
        zzjh zzjh = this.zzapx;
        zzjh.zzab();
        zzjh.zzge().zzit().zzg("Session started, time", Long.valueOf(zzjh.zzbt().elapsedRealtime()));
        zzjh.zzgf().zzakk.set(false);
        zzjh.zzfu().zza("auto", "_s", new Bundle());
        zzjh.zzgf().zzakl.set(zzjh.zzbt().currentTimeMillis());
        AppMethodBeat.o(1915);
    }
}
