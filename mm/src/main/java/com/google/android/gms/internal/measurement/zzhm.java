package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* access modifiers changed from: package-private */
public final class zzhm implements Runnable {
    private final /* synthetic */ String val$name;
    private final /* synthetic */ String zzanh;
    private final /* synthetic */ zzhk zzanw;
    private final /* synthetic */ Object zzanx;
    private final /* synthetic */ long zzany;

    zzhm(zzhk zzhk, String str, String str2, Object obj, long j2) {
        this.zzanw = zzhk;
        this.zzanh = str;
        this.val$name = str2;
        this.zzanx = obj;
        this.zzany = j2;
    }

    public final void run() {
        AppMethodBeat.i(1741);
        zzhk.zza(this.zzanw, this.zzanh, this.val$name, this.zzanx, this.zzany);
        AppMethodBeat.o(1741);
    }
}
