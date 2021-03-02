package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* access modifiers changed from: package-private */
public final class zzio extends zzem {
    private final /* synthetic */ zzii zzape;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzio(zzii zzii, zzhi zzhi) {
        super(zzhi);
        this.zzape = zzii;
    }

    @Override // com.google.android.gms.internal.measurement.zzem
    public final void run() {
        AppMethodBeat.i(1850);
        this.zzape.zzge().zzip().log("Tasks have been queued for a long time");
        AppMethodBeat.o(1850);
    }
}
