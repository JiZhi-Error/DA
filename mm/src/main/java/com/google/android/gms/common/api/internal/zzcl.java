package com.google.android.gms.common.api.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* access modifiers changed from: package-private */
public final class zzcl implements zzcn {
    private final /* synthetic */ zzck zzmq;

    zzcl(zzck zzck) {
        this.zzmq = zzck;
    }

    @Override // com.google.android.gms.common.api.internal.zzcn
    public final void zzc(BasePendingResult<?> basePendingResult) {
        AppMethodBeat.i(11388);
        this.zzmq.zzmo.remove(basePendingResult);
        AppMethodBeat.o(11388);
    }
}
