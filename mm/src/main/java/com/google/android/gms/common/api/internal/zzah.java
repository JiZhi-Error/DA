package com.google.android.gms.common.api.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzah extends zzbe {
    private final /* synthetic */ zzag zzhh;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzah(zzag zzag, zzbc zzbc) {
        super(zzbc);
        this.zzhh = zzag;
    }

    @Override // com.google.android.gms.common.api.internal.zzbe
    public final void zzaq() {
        AppMethodBeat.i(11210);
        this.zzhh.onConnectionSuspended(1);
        AppMethodBeat.o(11210);
    }
}
