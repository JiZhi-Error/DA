package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzjk implements Runnable {
    private final /* synthetic */ long zzadj;
    private final /* synthetic */ zzjh zzapx;

    zzjk(zzjh zzjh, long j2) {
        this.zzapx = zzjh;
        this.zzadj = j2;
    }

    public final void run() {
        AppMethodBeat.i(1917);
        zzjh.zza(this.zzapx, this.zzadj);
        AppMethodBeat.o(1917);
    }
}
