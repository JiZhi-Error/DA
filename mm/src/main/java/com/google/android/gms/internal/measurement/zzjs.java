package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import java.util.Map;

/* access modifiers changed from: package-private */
public final class zzjs implements zzfm {
    private final /* synthetic */ String zzaqt;
    private final /* synthetic */ zzjr zzaqu;

    zzjs(zzjr zzjr, String str) {
        this.zzaqu = zzjr;
        this.zzaqt = str;
    }

    @Override // com.google.android.gms.internal.measurement.zzfm
    public final void zza(String str, int i2, Throwable th, byte[] bArr, Map<String, List<String>> map) {
        AppMethodBeat.i(2009);
        this.zzaqu.zza(i2, th, bArr, this.zzaqt);
        AppMethodBeat.o(2009);
    }
}
