package com.google.android.gms.internal.measurement;

import android.annotation.TargetApi;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.PersistableBundle;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.common.util.Clock;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzjn extends zzjq {
    private final zzem zzapy;
    private final AlarmManager zzyi = ((AlarmManager) getContext().getSystemService("alarm"));
    private Integer zzyj;

    protected zzjn(zzjr zzjr) {
        super(zzjr);
        AppMethodBeat.i(1922);
        this.zzapy = new zzjo(this, zzjr.zzla(), zzjr);
        AppMethodBeat.o(1922);
    }

    private final int getJobId() {
        AppMethodBeat.i(1926);
        if (this.zzyj == null) {
            String valueOf = String.valueOf(getContext().getPackageName());
            this.zzyj = Integer.valueOf((valueOf.length() != 0 ? "measurement".concat(valueOf) : new String("measurement")).hashCode());
        }
        int intValue = this.zzyj.intValue();
        AppMethodBeat.o(1926);
        return intValue;
    }

    private final PendingIntent zzek() {
        AppMethodBeat.i(1928);
        Intent className = new Intent().setClassName(getContext(), "com.google.android.gms.measurement.AppMeasurementReceiver");
        className.setAction("com.google.android.gms.measurement.UPLOAD");
        PendingIntent broadcast = PendingIntent.getBroadcast(getContext(), 0, className, 0);
        AppMethodBeat.o(1928);
        return broadcast;
    }

    @TargetApi(24)
    private final void zzkl() {
        AppMethodBeat.i(1924);
        zzge().zzit().zzg("Cancelling job. JobID", Integer.valueOf(getJobId()));
        ((JobScheduler) getContext().getSystemService("jobscheduler")).cancel(getJobId());
        AppMethodBeat.o(1924);
    }

    public final void cancel() {
        AppMethodBeat.i(1927);
        zzch();
        this.zzyi.cancel(zzek());
        this.zzapy.cancel();
        if (Build.VERSION.SDK_INT >= 24) {
            zzkl();
        }
        AppMethodBeat.o(1927);
    }

    @Override // com.google.android.gms.internal.measurement.zzhg, com.google.android.gms.internal.measurement.zzec
    public final /* bridge */ /* synthetic */ Context getContext() {
        AppMethodBeat.i(1941);
        Context context = super.getContext();
        AppMethodBeat.o(1941);
        return context;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ void zzab() {
        AppMethodBeat.i(1933);
        super.zzab();
        AppMethodBeat.o(1933);
    }

    @Override // com.google.android.gms.internal.measurement.zzhg, com.google.android.gms.internal.measurement.zzec
    public final /* bridge */ /* synthetic */ Clock zzbt() {
        AppMethodBeat.i(1940);
        Clock zzbt = super.zzbt();
        AppMethodBeat.o(1940);
        return zzbt;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ void zzfr() {
        AppMethodBeat.i(1931);
        super.zzfr();
        AppMethodBeat.o(1931);
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ void zzfs() {
        AppMethodBeat.i(1932);
        super.zzfs();
        AppMethodBeat.o(1932);
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzdu zzft() {
        AppMethodBeat.i(1934);
        zzdu zzft = super.zzft();
        AppMethodBeat.o(1934);
        return zzft;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzhk zzfu() {
        AppMethodBeat.i(1935);
        zzhk zzfu = super.zzfu();
        AppMethodBeat.o(1935);
        return zzfu;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzfb zzfv() {
        AppMethodBeat.i(1936);
        zzfb zzfv = super.zzfv();
        AppMethodBeat.o(1936);
        return zzfv;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzeo zzfw() {
        AppMethodBeat.i(1937);
        zzeo zzfw = super.zzfw();
        AppMethodBeat.o(1937);
        return zzfw;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzii zzfx() {
        AppMethodBeat.i(1938);
        zzii zzfx = super.zzfx();
        AppMethodBeat.o(1938);
        return zzfx;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzif zzfy() {
        AppMethodBeat.i(1939);
        zzif zzfy = super.zzfy();
        AppMethodBeat.o(1939);
        return zzfy;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzfc zzfz() {
        AppMethodBeat.i(1942);
        zzfc zzfz = super.zzfz();
        AppMethodBeat.o(1942);
        return zzfz;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzfe zzga() {
        AppMethodBeat.i(1943);
        zzfe zzga = super.zzga();
        AppMethodBeat.o(1943);
        return zzga;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzka zzgb() {
        AppMethodBeat.i(1944);
        zzka zzgb = super.zzgb();
        AppMethodBeat.o(1944);
        return zzgb;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzjh zzgc() {
        AppMethodBeat.i(1945);
        zzjh zzgc = super.zzgc();
        AppMethodBeat.o(1945);
        return zzgc;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg, com.google.android.gms.internal.measurement.zzec
    public final /* bridge */ /* synthetic */ zzgg zzgd() {
        AppMethodBeat.i(1946);
        zzgg zzgd = super.zzgd();
        AppMethodBeat.o(1946);
        return zzgd;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg, com.google.android.gms.internal.measurement.zzec
    public final /* bridge */ /* synthetic */ zzfg zzge() {
        AppMethodBeat.i(1947);
        zzfg zzge = super.zzge();
        AppMethodBeat.o(1947);
        return zzge;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzfr zzgf() {
        AppMethodBeat.i(1948);
        zzfr zzgf = super.zzgf();
        AppMethodBeat.o(1948);
        return zzgf;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzef zzgg() {
        AppMethodBeat.i(1949);
        zzef zzgg = super.zzgg();
        AppMethodBeat.o(1949);
        return zzgg;
    }

    public final void zzh(long j2) {
        AppMethodBeat.i(1925);
        zzch();
        if (!zzgb.zza(getContext())) {
            zzge().zzis().log("Receiver not registered/enabled");
        }
        if (!zzjc.zza(getContext(), false)) {
            zzge().zzis().log("Service not registered/enabled");
        }
        cancel();
        long elapsedRealtime = zzbt().elapsedRealtime() + j2;
        if (j2 < Math.max(0L, zzew.zzahf.get().longValue()) && !this.zzapy.zzef()) {
            zzge().zzit().log("Scheduling upload with DelayedRunnable");
            this.zzapy.zzh(j2);
        }
        if (Build.VERSION.SDK_INT >= 24) {
            zzge().zzit().log("Scheduling upload with JobScheduler");
            JobInfo.Builder builder = new JobInfo.Builder(getJobId(), new ComponentName(getContext(), "com.google.android.gms.measurement.AppMeasurementJobService"));
            builder.setMinimumLatency(j2);
            builder.setOverrideDeadline(j2 << 1);
            PersistableBundle persistableBundle = new PersistableBundle();
            persistableBundle.putString(NativeProtocol.WEB_DIALOG_ACTION, "com.google.android.gms.measurement.UPLOAD");
            builder.setExtras(persistableBundle);
            JobInfo build = builder.build();
            zzge().zzit().zzg("Scheduling job. JobID", Integer.valueOf(getJobId()));
            ((JobScheduler) getContext().getSystemService("jobscheduler")).schedule(build);
            AppMethodBeat.o(1925);
            return;
        }
        zzge().zzit().log("Scheduling upload with AlarmManager");
        this.zzyi.setInexactRepeating(2, elapsedRealtime, Math.max(zzew.zzaha.get().longValue(), j2), zzek());
        AppMethodBeat.o(1925);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.zzjq
    public final boolean zzhf() {
        AppMethodBeat.i(1923);
        this.zzyi.cancel(zzek());
        if (Build.VERSION.SDK_INT >= 24) {
            zzkl();
        }
        AppMethodBeat.o(1923);
        return false;
    }

    @Override // com.google.android.gms.internal.measurement.zzjp
    public final /* bridge */ /* synthetic */ zzeb zziw() {
        AppMethodBeat.i(1929);
        zzeb zziw = super.zziw();
        AppMethodBeat.o(1929);
        return zziw;
    }

    @Override // com.google.android.gms.internal.measurement.zzjp
    public final /* bridge */ /* synthetic */ zzei zzix() {
        AppMethodBeat.i(1930);
        zzei zzix = super.zzix();
        AppMethodBeat.o(1930);
        return zzix;
    }
}
