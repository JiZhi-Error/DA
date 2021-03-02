package com.google.android.gms.measurement;

import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import com.google.android.gms.internal.measurement.zzjc;
import com.google.android.gms.internal.measurement.zzjg;
import com.tencent.matrix.trace.core.AppMethodBeat;

@TargetApi(24)
public final class AppMeasurementJobService extends JobService implements zzjg {
    private zzjc<AppMeasurementJobService> zzade;

    private final zzjc<AppMeasurementJobService> zzfq() {
        AppMethodBeat.i(87668);
        if (this.zzade == null) {
            this.zzade = new zzjc<>(this);
        }
        zzjc<AppMeasurementJobService> zzjc = this.zzade;
        AppMethodBeat.o(87668);
        return zzjc;
    }

    @Override // com.google.android.gms.internal.measurement.zzjg
    public final boolean callServiceStopSelfResult(int i2) {
        AppMethodBeat.i(87674);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        AppMethodBeat.o(87674);
        throw unsupportedOperationException;
    }

    public final void onCreate() {
        AppMethodBeat.i(87669);
        super.onCreate();
        zzfq().onCreate();
        AppMethodBeat.o(87669);
    }

    public final void onDestroy() {
        AppMethodBeat.i(87670);
        zzfq().onDestroy();
        super.onDestroy();
        AppMethodBeat.o(87670);
    }

    public final void onRebind(Intent intent) {
        AppMethodBeat.i(87673);
        zzfq().onRebind(intent);
        AppMethodBeat.o(87673);
    }

    public final boolean onStartJob(JobParameters jobParameters) {
        AppMethodBeat.i(87671);
        boolean onStartJob = zzfq().onStartJob(jobParameters);
        AppMethodBeat.o(87671);
        return onStartJob;
    }

    public final boolean onStopJob(JobParameters jobParameters) {
        return false;
    }

    public final boolean onUnbind(Intent intent) {
        AppMethodBeat.i(87672);
        boolean onUnbind = zzfq().onUnbind(intent);
        AppMethodBeat.o(87672);
        return onUnbind;
    }

    @Override // com.google.android.gms.internal.measurement.zzjg
    @TargetApi(24)
    public final void zza(JobParameters jobParameters, boolean z) {
        AppMethodBeat.i(87675);
        jobFinished(jobParameters, false);
        AppMethodBeat.o(87675);
    }

    @Override // com.google.android.gms.internal.measurement.zzjg
    public final void zzb(Intent intent) {
    }
}
