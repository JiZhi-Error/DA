package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzhf implements Runnable {
    private final /* synthetic */ zzgn zzanf;
    private final /* synthetic */ String zzanj;
    private final /* synthetic */ String zzanm;
    private final /* synthetic */ String zzann;
    private final /* synthetic */ long zzano;

    zzhf(zzgn zzgn, String str, String str2, String str3, long j2) {
        this.zzanf = zzgn;
        this.zzanm = str;
        this.zzanj = str2;
        this.zzann = str3;
        this.zzano = j2;
    }

    public final void run() {
        AppMethodBeat.i(1650);
        if (this.zzanm == null) {
            zzgn.zza(this.zzanf).zzla().zzfy().zza(this.zzanj, (zzie) null);
            AppMethodBeat.o(1650);
            return;
        }
        zzgn.zza(this.zzanf).zzla().zzfy().zza(this.zzanj, new zzie(this.zzann, this.zzanm, this.zzano));
        AppMethodBeat.o(1650);
    }
}
