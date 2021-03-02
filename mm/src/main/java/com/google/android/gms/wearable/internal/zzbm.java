package com.google.android.gms.wearable.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzbm implements zzbs {
    private final /* synthetic */ zzbl zzcz;

    zzbm(zzbl zzbl) {
        this.zzcz = zzbl;
    }

    @Override // com.google.android.gms.wearable.internal.zzbs
    public final void zzb(zzav zzav) {
        AppMethodBeat.i(101078);
        this.zzcz.zzc(zzav);
        AppMethodBeat.o(101078);
    }
}
