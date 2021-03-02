package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* access modifiers changed from: package-private */
public final class zzij extends zzem {
    private final /* synthetic */ zzii zzape;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzij(zzii zzii, zzhi zzhi) {
        super(zzhi);
        this.zzape = zzii;
    }

    @Override // com.google.android.gms.internal.measurement.zzem
    public final void run() {
        AppMethodBeat.i(1845);
        zzii.zzc(this.zzape);
        AppMethodBeat.o(1845);
    }
}
