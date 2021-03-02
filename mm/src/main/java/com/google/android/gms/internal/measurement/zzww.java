package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* access modifiers changed from: package-private */
public final class zzww extends zzws<Long> {
    zzww(zzxc zzxc, String str, Long l) {
        super(zzxc, str, l, null);
    }

    private final Long zzez(String str) {
        AppMethodBeat.i(2287);
        try {
            Long valueOf = Long.valueOf(Long.parseLong(str));
            AppMethodBeat.o(2287);
            return valueOf;
        } catch (NumberFormatException e2) {
            String str2 = this.zzbnh;
            new StringBuilder(String.valueOf(str2).length() + 25 + String.valueOf(str).length()).append("Invalid long value for ").append(str2).append(": ").append(str);
            AppMethodBeat.o(2287);
            return null;
        }
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.zzws
    public final /* synthetic */ Long zzey(String str) {
        AppMethodBeat.i(2288);
        Long zzez = zzez(str);
        AppMethodBeat.o(2288);
        return zzez;
    }
}
