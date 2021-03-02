package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* access modifiers changed from: package-private */
public final class zzab implements PendingResult.StatusListener {
    private final /* synthetic */ BasePendingResult zzgy;
    private final /* synthetic */ zzaa zzgz;

    zzab(zzaa zzaa, BasePendingResult basePendingResult) {
        this.zzgz = zzaa;
        this.zzgy = basePendingResult;
    }

    @Override // com.google.android.gms.common.api.PendingResult.StatusListener
    public final void onComplete(Status status) {
        AppMethodBeat.i(11175);
        this.zzgz.zzgw.remove(this.zzgy);
        AppMethodBeat.o(11175);
    }
}
