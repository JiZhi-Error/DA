package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* access modifiers changed from: package-private */
public final class zzwy extends zzws<Boolean> {
    zzwy(zzxc zzxc, String str, Boolean bool) {
        super(zzxc, str, bool, null);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.zzws
    public final /* synthetic */ Boolean zzey(String str) {
        AppMethodBeat.i(2291);
        if (zzwn.zzbmi.matcher(str).matches()) {
            Boolean bool = Boolean.TRUE;
            AppMethodBeat.o(2291);
            return bool;
        } else if (zzwn.zzbmj.matcher(str).matches()) {
            Boolean bool2 = Boolean.FALSE;
            AppMethodBeat.o(2291);
            return bool2;
        } else {
            String str2 = this.zzbnh;
            new StringBuilder(String.valueOf(str2).length() + 28 + String.valueOf(str).length()).append("Invalid boolean value for ").append(str2).append(": ").append(str);
            AppMethodBeat.o(2291);
            return null;
        }
    }
}
