package com.google.android.gms.wearable.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzbk implements zzbs {
    private final /* synthetic */ zzbj zzcx;

    zzbk(zzbj zzbj) {
        this.zzcx = zzbj;
    }

    @Override // com.google.android.gms.wearable.internal.zzbs
    public final void zzb(zzav zzav) {
        AppMethodBeat.i(101070);
        this.zzcx.zza(zzav);
        AppMethodBeat.o(101070);
    }
}
