package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* access modifiers changed from: package-private */
public final /* synthetic */ class zzwt implements zzxb {
    private final zzws zzbnn;
    private final zzwp zzbno;

    zzwt(zzws zzws, zzwp zzwp) {
        this.zzbnn = zzws;
        this.zzbno = zzwp;
    }

    @Override // com.google.android.gms.internal.measurement.zzxb
    public final Object zzsc() {
        AppMethodBeat.i(2284);
        String str = this.zzbno.zzrt().get(this.zzbnn.zzbnh);
        AppMethodBeat.o(2284);
        return str;
    }
}
