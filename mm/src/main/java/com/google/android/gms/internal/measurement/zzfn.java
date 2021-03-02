package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.Preconditions;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import java.util.Map;

final class zzfn implements Runnable {
    private final String packageName;
    private final int status;
    private final zzfm zzajh;
    private final Throwable zzaji;
    private final byte[] zzajj;
    private final Map<String, List<String>> zzajk;

    private zzfn(String str, zzfm zzfm, int i2, Throwable th, byte[] bArr, Map<String, List<String>> map) {
        AppMethodBeat.i(1453);
        Preconditions.checkNotNull(zzfm);
        this.zzajh = zzfm;
        this.status = i2;
        this.zzaji = th;
        this.zzajj = bArr;
        this.packageName = str;
        this.zzajk = map;
        AppMethodBeat.o(1453);
    }

    public final void run() {
        AppMethodBeat.i(1454);
        this.zzajh.zza(this.packageName, this.status, this.zzaji, this.zzajj, this.zzajk);
        AppMethodBeat.o(1454);
    }
}
