package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* access modifiers changed from: package-private */
public final class zzfh implements Runnable {
    private final /* synthetic */ int zzaix;
    private final /* synthetic */ String zzaiy;
    private final /* synthetic */ Object zzaiz;
    private final /* synthetic */ Object zzaja;
    private final /* synthetic */ Object zzajb;
    private final /* synthetic */ zzfg zzajc;

    zzfh(zzfg zzfg, int i2, String str, Object obj, Object obj2, Object obj3) {
        this.zzajc = zzfg;
        this.zzaix = i2;
        this.zzaiy = str;
        this.zzaiz = obj;
        this.zzaja = obj2;
        this.zzajb = obj3;
    }

    public final void run() {
        AppMethodBeat.i(1422);
        zzfr zzgf = this.zzajc.zzacw.zzgf();
        if (!zzgf.isInitialized()) {
            this.zzajc.zza(6, "Persisted config not initialized. Not logging error/warn");
            AppMethodBeat.o(1422);
            return;
        }
        if (this.zzajc.zzaim == 0) {
            if (this.zzajc.zzgg().zzds()) {
                this.zzajc.zzaim = 'C';
            } else {
                this.zzajc.zzaim = 'c';
            }
        }
        if (this.zzajc.zzadu < 0) {
            this.zzajc.zzadu = 12451;
        }
        char charAt = "01VDIWEA?".charAt(this.zzaix);
        char c2 = this.zzajc.zzaim;
        long j2 = this.zzajc.zzadu;
        String zza = zzfg.zza(true, this.zzaiy, this.zzaiz, this.zzaja, this.zzajb);
        String sb = new StringBuilder(String.valueOf(zza).length() + 24).append("2").append(charAt).append(c2).append(j2).append(":").append(zza).toString();
        if (sb.length() > 1024) {
            sb = this.zzaiy.substring(0, 1024);
        }
        zzgf.zzajt.zzc(sb, 1);
        AppMethodBeat.o(1422);
    }
}
