package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.Preconditions;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* access modifiers changed from: package-private */
public final class zzl {
    private final int zzet;
    private final ConnectionResult zzeu;

    zzl(ConnectionResult connectionResult, int i2) {
        AppMethodBeat.i(11431);
        Preconditions.checkNotNull(connectionResult);
        this.zzeu = connectionResult;
        this.zzet = i2;
        AppMethodBeat.o(11431);
    }

    /* access modifiers changed from: package-private */
    public final ConnectionResult getConnectionResult() {
        return this.zzeu;
    }

    /* access modifiers changed from: package-private */
    public final int zzu() {
        return this.zzet;
    }
}
