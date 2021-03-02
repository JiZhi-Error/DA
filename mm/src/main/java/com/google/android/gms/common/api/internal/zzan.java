package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import com.tencent.matrix.trace.core.AppMethodBeat;
import javax.annotation.concurrent.GuardedBy;

final class zzan extends zzbe {
    private final /* synthetic */ ConnectionResult zzhy;
    private final /* synthetic */ zzam zzhz;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzan(zzam zzam, zzbc zzbc, ConnectionResult connectionResult) {
        super(zzbc);
        this.zzhz = zzam;
        this.zzhy = connectionResult;
    }

    @Override // com.google.android.gms.common.api.internal.zzbe
    @GuardedBy("mLock")
    public final void zzaq() {
        AppMethodBeat.i(11245);
        zzaj.zza(this.zzhz.zzhv, this.zzhy);
        AppMethodBeat.o(11245);
    }
}
