package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* access modifiers changed from: package-private */
public final class zzjj extends zzem {
    private final /* synthetic */ zzjh zzapx;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzjj(zzjh zzjh, zzhi zzhi) {
        super(zzhi);
        this.zzapx = zzjh;
    }

    @Override // com.google.android.gms.internal.measurement.zzem
    public final void run() {
        AppMethodBeat.i(1916);
        zzjh.zza(this.zzapx);
        AppMethodBeat.o(1916);
    }
}
