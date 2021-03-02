package com.google.android.gms.measurement;

import android.app.Service;
import android.app.job.JobParameters;
import android.content.Intent;
import android.os.IBinder;
import com.google.android.gms.internal.measurement.zzjc;
import com.google.android.gms.internal.measurement.zzjg;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class AppMeasurementService extends Service implements zzjg {
    private zzjc<AppMeasurementService> zzade;

    private final zzjc<AppMeasurementService> zzfq() {
        AppMethodBeat.i(87679);
        if (this.zzade == null) {
            this.zzade = new zzjc<>(this);
        }
        zzjc<AppMeasurementService> zzjc = this.zzade;
        AppMethodBeat.o(87679);
        return zzjc;
    }

    @Override // com.google.android.gms.internal.measurement.zzjg
    public final boolean callServiceStopSelfResult(int i2) {
        AppMethodBeat.i(87686);
        boolean stopSelfResult = stopSelfResult(i2);
        AppMethodBeat.o(87686);
        return stopSelfResult;
    }

    public final IBinder onBind(Intent intent) {
        AppMethodBeat.i(87683);
        IBinder onBind = zzfq().onBind(intent);
        AppMethodBeat.o(87683);
        return onBind;
    }

    public final void onCreate() {
        AppMethodBeat.i(87680);
        super.onCreate();
        zzfq().onCreate();
        AppMethodBeat.o(87680);
    }

    public final void onDestroy() {
        AppMethodBeat.i(87681);
        zzfq().onDestroy();
        super.onDestroy();
        AppMethodBeat.o(87681);
    }

    public final void onRebind(Intent intent) {
        AppMethodBeat.i(87685);
        zzfq().onRebind(intent);
        AppMethodBeat.o(87685);
    }

    public final int onStartCommand(Intent intent, int i2, int i3) {
        AppMethodBeat.i(87682);
        int onStartCommand = zzfq().onStartCommand(intent, i2, i3);
        AppMethodBeat.o(87682);
        return onStartCommand;
    }

    public final boolean onUnbind(Intent intent) {
        AppMethodBeat.i(87684);
        boolean onUnbind = zzfq().onUnbind(intent);
        AppMethodBeat.o(87684);
        return onUnbind;
    }

    @Override // com.google.android.gms.internal.measurement.zzjg
    public final void zza(JobParameters jobParameters, boolean z) {
        AppMethodBeat.i(87687);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        AppMethodBeat.o(87687);
        throw unsupportedOperationException;
    }

    @Override // com.google.android.gms.internal.measurement.zzjg
    public final void zzb(Intent intent) {
        AppMethodBeat.i(87688);
        AppMeasurementReceiver.completeWakefulIntent(intent);
        AppMethodBeat.o(87688);
    }
}
