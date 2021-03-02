package com.google.android.gms.iid;

import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* access modifiers changed from: package-private */
public final class zzj implements Runnable {
    private final /* synthetic */ zzg zzbj;
    private final /* synthetic */ zzi zzbk;

    zzj(zzi zzi, zzg zzg) {
        this.zzbk = zzi;
        this.zzbj = zzg;
    }

    public final void run() {
        AppMethodBeat.i(2522);
        Log.isLoggable("EnhancedIntentService", 3);
        this.zzbk.zzbi.handleIntent(this.zzbj.intent);
        this.zzbj.finish();
        AppMethodBeat.o(2522);
    }
}
