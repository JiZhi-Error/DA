package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import java.util.Map;

/* access modifiers changed from: package-private */
public final class zzjt implements zzfm {
    private final /* synthetic */ zzjr zzaqu;

    zzjt(zzjr zzjr) {
        this.zzaqu = zzjr;
    }

    @Override // com.google.android.gms.internal.measurement.zzfm
    public final void zza(String str, int i2, Throwable th, byte[] bArr, Map<String, List<String>> map) {
        AppMethodBeat.i(2010);
        this.zzaqu.zzb(str, i2, th, bArr, map);
        AppMethodBeat.o(2010);
    }
}
