package com.google.android.gms.internal.measurement;

import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzjg;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzjc<T extends Context & zzjg> {
    private final T zzabm;

    public zzjc(T t) {
        AppMethodBeat.i(1870);
        Preconditions.checkNotNull(t);
        this.zzabm = t;
        AppMethodBeat.o(1870);
    }

    public static boolean zza(Context context, boolean z) {
        AppMethodBeat.i(1871);
        Preconditions.checkNotNull(context);
        if (Build.VERSION.SDK_INT >= 24) {
            boolean zzc = zzka.zzc(context, "com.google.android.gms.measurement.AppMeasurementJobService");
            AppMethodBeat.o(1871);
            return zzc;
        }
        boolean zzc2 = zzka.zzc(context, "com.google.android.gms.measurement.AppMeasurementService");
        AppMethodBeat.o(1871);
        return zzc2;
    }

    private final void zzb(Runnable runnable) {
        AppMethodBeat.i(1875);
        zzgl zzg = zzgl.zzg(this.zzabm);
        zzg.zzgd().zzc(new zzjf(this, zzg, runnable));
        AppMethodBeat.o(1875);
    }

    private final zzfg zzge() {
        AppMethodBeat.i(1880);
        zzfg zzge = zzgl.zzg(this.zzabm).zzge();
        AppMethodBeat.o(1880);
        return zzge;
    }

    public final IBinder onBind(Intent intent) {
        AppMethodBeat.i(1876);
        if (intent == null) {
            zzge().zzim().log("onBind called with null intent");
            AppMethodBeat.o(1876);
            return null;
        }
        String action = intent.getAction();
        if ("com.google.android.gms.measurement.START".equals(action)) {
            zzgn zzgn = new zzgn(zzgl.zzg(this.zzabm));
            AppMethodBeat.o(1876);
            return zzgn;
        }
        zzge().zzip().zzg("onBind received unknown action", action);
        AppMethodBeat.o(1876);
        return null;
    }

    public final void onCreate() {
        AppMethodBeat.i(1872);
        zzgl.zzg(this.zzabm).zzge().zzit().log("Local AppMeasurementService is starting up");
        AppMethodBeat.o(1872);
    }

    public final void onDestroy() {
        AppMethodBeat.i(1873);
        zzgl.zzg(this.zzabm).zzge().zzit().log("Local AppMeasurementService is shutting down");
        AppMethodBeat.o(1873);
    }

    public final void onRebind(Intent intent) {
        AppMethodBeat.i(1879);
        if (intent == null) {
            zzge().zzim().log("onRebind called with null intent");
            AppMethodBeat.o(1879);
            return;
        }
        zzge().zzit().zzg("onRebind called. action", intent.getAction());
        AppMethodBeat.o(1879);
    }

    public final int onStartCommand(Intent intent, int i2, int i3) {
        AppMethodBeat.i(1874);
        zzfg zzge = zzgl.zzg(this.zzabm).zzge();
        if (intent == null) {
            zzge.zzip().log("AppMeasurementService started with null intent");
            AppMethodBeat.o(1874);
        } else {
            String action = intent.getAction();
            zzge.zzit().zze("Local AppMeasurementService called. startId, action", Integer.valueOf(i3), action);
            if ("com.google.android.gms.measurement.UPLOAD".equals(action)) {
                zzb(new zzjd(this, i3, zzge, intent));
            }
            AppMethodBeat.o(1874);
        }
        return 2;
    }

    @TargetApi(24)
    public final boolean onStartJob(JobParameters jobParameters) {
        AppMethodBeat.i(1878);
        zzfg zzge = zzgl.zzg(this.zzabm).zzge();
        String string = jobParameters.getExtras().getString(NativeProtocol.WEB_DIALOG_ACTION);
        zzge.zzit().zzg("Local AppMeasurementJobService called. action", string);
        if ("com.google.android.gms.measurement.UPLOAD".equals(string)) {
            zzb(new zzje(this, zzge, jobParameters));
        }
        AppMethodBeat.o(1878);
        return true;
    }

    public final boolean onUnbind(Intent intent) {
        AppMethodBeat.i(1877);
        if (intent == null) {
            zzge().zzim().log("onUnbind called with null intent");
            AppMethodBeat.o(1877);
        } else {
            zzge().zzit().zzg("onUnbind called for intent. action", intent.getAction());
            AppMethodBeat.o(1877);
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(int i2, zzfg zzfg, Intent intent) {
        AppMethodBeat.i(1882);
        if (this.zzabm.callServiceStopSelfResult(i2)) {
            zzfg.zzit().zzg("Local AppMeasurementService processed last upload request. StartId", Integer.valueOf(i2));
            zzge().zzit().log("Completed wakeful intent.");
            this.zzabm.zzb(intent);
        }
        AppMethodBeat.o(1882);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(zzfg zzfg, JobParameters jobParameters) {
        AppMethodBeat.i(1881);
        zzfg.zzit().log("AppMeasurementJobService processed last upload request.");
        this.zzabm.zza(jobParameters, false);
        AppMethodBeat.o(1881);
    }
}
