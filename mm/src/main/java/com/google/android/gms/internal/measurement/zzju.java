package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Callable;

/* access modifiers changed from: package-private */
public final class zzju implements Callable<String> {
    private final /* synthetic */ zzdz zzane;
    private final /* synthetic */ zzjr zzaqu;

    zzju(zzjr zzjr, zzdz zzdz) {
        this.zzaqu = zzjr;
        this.zzane = zzdz;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.concurrent.Callable
    public final /* synthetic */ String call() {
        AppMethodBeat.i(2011);
        zzdy zza = this.zzaqu.zzgg().zzaz(this.zzane.packageName) ? zzjr.zza(this.zzaqu, this.zzane) : this.zzaqu.zzix().zzbc(this.zzane.packageName);
        if (zza == null) {
            this.zzaqu.zzge().zzip().log("App info was null when attempting to get app instance id");
            AppMethodBeat.o(2011);
            return null;
        }
        String appInstanceId = zza.getAppInstanceId();
        AppMethodBeat.o(2011);
        return appInstanceId;
    }
}
