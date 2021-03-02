package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* access modifiers changed from: package-private */
public final /* synthetic */ class zzwv implements zzxb {
    private final String zzbnp;
    private final boolean zzbnq = false;

    zzwv(String str, boolean z) {
        this.zzbnp = str;
    }

    @Override // com.google.android.gms.internal.measurement.zzxb
    public final Object zzsc() {
        AppMethodBeat.i(2286);
        Boolean bool = Boolean.valueOf(zzwn.zza(zzws.zzqx.getContentResolver(), this.zzbnp, this.zzbnq));
        AppMethodBeat.o(2286);
        return bool;
    }
}
