package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzjl implements Runnable {
    private final /* synthetic */ long zzadj;
    private final /* synthetic */ zzjh zzapx;

    zzjl(zzjh zzjh, long j2) {
        this.zzapx = zzjh;
        this.zzadj = j2;
    }

    public final void run() {
        AppMethodBeat.i(1918);
        zzjh.zzb(this.zzapx, this.zzadj);
        AppMethodBeat.o(1918);
    }
}
