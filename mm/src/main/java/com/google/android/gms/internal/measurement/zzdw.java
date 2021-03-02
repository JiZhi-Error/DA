package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzdw implements Runnable {
    private final /* synthetic */ String zzadi;
    private final /* synthetic */ long zzadj;
    private final /* synthetic */ zzdu zzadk;

    zzdw(zzdu zzdu, String str, long j2) {
        this.zzadk = zzdu;
        this.zzadi = str;
        this.zzadj = j2;
    }

    public final void run() {
        AppMethodBeat.i(1046);
        zzdu.zzb(this.zzadk, this.zzadi, this.zzadj);
        AppMethodBeat.o(1046);
    }
}
