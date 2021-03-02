package com.google.android.gms.common.api.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzai extends zzbe {
    private final /* synthetic */ zzag zzhh;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzai(zzag zzag, zzbc zzbc) {
        super(zzbc);
        this.zzhh = zzag;
    }

    @Override // com.google.android.gms.common.api.internal.zzbe
    public final void zzaq() {
        AppMethodBeat.i(11211);
        zzag.zza(this.zzhh).zzjf.zzb(null);
        AppMethodBeat.o(11211);
    }
}
