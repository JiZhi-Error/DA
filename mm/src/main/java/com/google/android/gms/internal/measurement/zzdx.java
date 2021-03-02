package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* access modifiers changed from: package-private */
public final class zzdx implements Runnable {
    private final /* synthetic */ long zzadj;
    private final /* synthetic */ zzdu zzadk;

    zzdx(zzdu zzdu, long j2) {
        this.zzadk = zzdu;
        this.zzadj = j2;
    }

    public final void run() {
        AppMethodBeat.i(1047);
        zzdu.zza(this.zzadk, this.zzadj);
        AppMethodBeat.o(1047);
    }
}
