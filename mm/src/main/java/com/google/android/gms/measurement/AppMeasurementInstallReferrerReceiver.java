package com.google.android.gms.measurement;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.internal.measurement.zzgb;
import com.google.android.gms.internal.measurement.zzge;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class AppMeasurementInstallReferrerReceiver extends BroadcastReceiver implements zzge {
    private zzgb zzadd;

    @Override // com.google.android.gms.internal.measurement.zzge
    public final BroadcastReceiver.PendingResult doGoAsync() {
        AppMethodBeat.i(87667);
        BroadcastReceiver.PendingResult goAsync = goAsync();
        AppMethodBeat.o(87667);
        return goAsync;
    }

    @Override // com.google.android.gms.internal.measurement.zzge
    public final void doStartService(Context context, Intent intent) {
    }

    public final void onReceive(Context context, Intent intent) {
        AppMethodBeat.i(87666);
        if (this.zzadd == null) {
            this.zzadd = new zzgb(this);
        }
        this.zzadd.onReceive(context, intent);
        AppMethodBeat.o(87666);
    }
}
