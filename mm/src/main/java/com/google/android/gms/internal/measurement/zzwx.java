package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* access modifiers changed from: package-private */
public final class zzwx extends zzws<Integer> {
    zzwx(zzxc zzxc, String str, Integer num) {
        super(zzxc, str, num, null);
    }

    private final Integer zzfa(String str) {
        AppMethodBeat.i(2289);
        try {
            Integer valueOf = Integer.valueOf(Integer.parseInt(str));
            AppMethodBeat.o(2289);
            return valueOf;
        } catch (NumberFormatException e2) {
            String str2 = this.zzbnh;
            new StringBuilder(String.valueOf(str2).length() + 28 + String.valueOf(str).length()).append("Invalid integer value for ").append(str2).append(": ").append(str);
            AppMethodBeat.o(2289);
            return null;
        }
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.zzws
    public final /* synthetic */ Integer zzey(String str) {
        AppMethodBeat.i(2290);
        Integer zzfa = zzfa(str);
        AppMethodBeat.o(2290);
        return zzfa;
    }
}
