package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* access modifiers changed from: package-private */
public final /* synthetic */ class zzwu implements zzxb {
    private final zzws zzbnn;

    zzwu(zzws zzws) {
        this.zzbnn = zzws;
    }

    @Override // com.google.android.gms.internal.measurement.zzxb
    public final Object zzsc() {
        AppMethodBeat.i(2285);
        String zzsb = this.zzbnn.zzsb();
        AppMethodBeat.o(2285);
        return zzsb;
    }
}
