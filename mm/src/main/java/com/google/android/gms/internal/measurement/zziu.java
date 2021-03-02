package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* access modifiers changed from: package-private */
public final class zziu implements Runnable {
    private final /* synthetic */ zzdz zzane;
    private final /* synthetic */ zzjx zzanl;
    private final /* synthetic */ zzii zzape;
    private final /* synthetic */ boolean zzaph;

    zziu(zzii zzii, boolean z, zzjx zzjx, zzdz zzdz) {
        this.zzape = zzii;
        this.zzaph = z;
        this.zzanl = zzjx;
        this.zzane = zzdz;
    }

    public final void run() {
        AppMethodBeat.i(1856);
        zzey zzey = this.zzape.zzaoy;
        if (zzey == null) {
            this.zzape.zzge().zzim().log("Discarding data. Failed to set user attribute");
            AppMethodBeat.o(1856);
            return;
        }
        this.zzape.zza(zzey, this.zzaph ? null : this.zzanl, this.zzane);
        zzii.zze(this.zzape);
        AppMethodBeat.o(1856);
    }
}
