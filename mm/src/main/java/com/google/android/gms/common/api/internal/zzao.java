package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.tencent.matrix.trace.core.AppMethodBeat;
import javax.annotation.concurrent.GuardedBy;

final class zzao extends zzbe {
    private final /* synthetic */ BaseGmsClient.ConnectionProgressReportCallbacks zzia;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzao(zzam zzam, zzbc zzbc, BaseGmsClient.ConnectionProgressReportCallbacks connectionProgressReportCallbacks) {
        super(zzbc);
        this.zzia = connectionProgressReportCallbacks;
    }

    @Override // com.google.android.gms.common.api.internal.zzbe
    @GuardedBy("mLock")
    public final void zzaq() {
        AppMethodBeat.i(11246);
        this.zzia.onReportServiceBinding(new ConnectionResult(16, null));
        AppMethodBeat.o(11246);
    }
}
