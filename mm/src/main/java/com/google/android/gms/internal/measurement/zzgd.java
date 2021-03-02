package com.google.android.gms.internal.measurement;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.measurement.AppMeasurement;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzgd implements Runnable {
    private final /* synthetic */ Context val$context;
    private final /* synthetic */ zzgl zzalb;
    private final /* synthetic */ zzfg zzalc;
    private final /* synthetic */ long zzald;
    private final /* synthetic */ Bundle zzale;
    private final /* synthetic */ BroadcastReceiver.PendingResult zzqu;

    zzgd(zzgb zzgb, zzgl zzgl, long j2, Bundle bundle, Context context, zzfg zzfg, BroadcastReceiver.PendingResult pendingResult) {
        this.zzalb = zzgl;
        this.zzald = j2;
        this.zzale = bundle;
        this.val$context = context;
        this.zzalc = zzfg;
        this.zzqu = pendingResult;
    }

    public final void run() {
        AppMethodBeat.i(1508);
        long j2 = this.zzalb.zzgf().zzajz.get();
        long j3 = this.zzald;
        if (j2 > 0 && (j3 >= j2 || j3 <= 0)) {
            j3 = j2 - 1;
        }
        if (j3 > 0) {
            this.zzale.putLong("click_timestamp", j3);
        }
        this.zzale.putString("_cis", "referrer broadcast");
        AppMeasurement.getInstance(this.val$context).logEventInternal("auto", "_cmp", this.zzale);
        this.zzalc.zzit().log("Install campaign recorded");
        if (this.zzqu != null) {
            this.zzqu.finish();
        }
        AppMethodBeat.o(1508);
    }
}
