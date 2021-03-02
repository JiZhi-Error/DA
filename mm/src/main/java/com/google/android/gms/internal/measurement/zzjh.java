package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;

public final class zzjh extends zzhh {
    private Handler handler;
    @VisibleForTesting
    private long zzapu = zzbt().elapsedRealtime();
    private final zzem zzapv = new zzji(this, this.zzacw);
    private final zzem zzapw = new zzjj(this, this.zzacw);

    zzjh(zzgl zzgl) {
        super(zzgl);
        AppMethodBeat.i(1886);
        AppMethodBeat.o(1886);
    }

    static /* synthetic */ void zza(zzjh zzjh) {
        AppMethodBeat.i(1912);
        zzjh.zzkk();
        AppMethodBeat.o(1912);
    }

    static /* synthetic */ void zza(zzjh zzjh, long j2) {
        AppMethodBeat.i(1913);
        zzjh.zzaf(j2);
        AppMethodBeat.o(1913);
    }

    private final void zzaf(long j2) {
        AppMethodBeat.i(1889);
        zzab();
        zzki();
        this.zzapv.cancel();
        this.zzapw.cancel();
        zzge().zzit().zzg("Activity resumed, time", Long.valueOf(j2));
        this.zzapu = j2;
        if (zzbt().currentTimeMillis() - zzgf().zzakj.get() > zzgf().zzakl.get()) {
            zzgf().zzakk.set(true);
            zzgf().zzakm.set(0);
        }
        if (zzgf().zzakk.get()) {
            this.zzapv.zzh(Math.max(0L, zzgf().zzaki.get() - zzgf().zzakm.get()));
            AppMethodBeat.o(1889);
            return;
        }
        this.zzapw.zzh(Math.max(0L, Util.MILLSECONDS_OF_HOUR - zzgf().zzakm.get()));
        AppMethodBeat.o(1889);
    }

    private final void zzag(long j2) {
        AppMethodBeat.i(1890);
        zzab();
        zzki();
        this.zzapv.cancel();
        this.zzapw.cancel();
        zzge().zzit().zzg("Activity paused, time", Long.valueOf(j2));
        if (this.zzapu != 0) {
            zzgf().zzakm.set(zzgf().zzakm.get() + (j2 - this.zzapu));
        }
        AppMethodBeat.o(1890);
    }

    static /* synthetic */ void zzb(zzjh zzjh, long j2) {
        AppMethodBeat.i(1914);
        zzjh.zzag(j2);
        AppMethodBeat.o(1914);
    }

    private final void zzki() {
        AppMethodBeat.i(1887);
        synchronized (this) {
            try {
                if (this.handler == null) {
                    this.handler = new Handler(Looper.getMainLooper());
                }
            } finally {
                AppMethodBeat.o(1887);
            }
        }
    }

    private final void zzkk() {
        AppMethodBeat.i(1892);
        zzab();
        zzl(false);
        zzft().zzk(zzbt().elapsedRealtime());
        AppMethodBeat.o(1892);
    }

    @Override // com.google.android.gms.internal.measurement.zzhg, com.google.android.gms.internal.measurement.zzec
    public final /* bridge */ /* synthetic */ Context getContext() {
        AppMethodBeat.i(1903);
        Context context = super.getContext();
        AppMethodBeat.o(1903);
        return context;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ void zzab() {
        AppMethodBeat.i(1895);
        super.zzab();
        AppMethodBeat.o(1895);
    }

    @Override // com.google.android.gms.internal.measurement.zzhg, com.google.android.gms.internal.measurement.zzec
    public final /* bridge */ /* synthetic */ Clock zzbt() {
        AppMethodBeat.i(1902);
        Clock zzbt = super.zzbt();
        AppMethodBeat.o(1902);
        return zzbt;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ void zzfr() {
        AppMethodBeat.i(1893);
        super.zzfr();
        AppMethodBeat.o(1893);
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ void zzfs() {
        AppMethodBeat.i(1894);
        super.zzfs();
        AppMethodBeat.o(1894);
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzdu zzft() {
        AppMethodBeat.i(1896);
        zzdu zzft = super.zzft();
        AppMethodBeat.o(1896);
        return zzft;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzhk zzfu() {
        AppMethodBeat.i(1897);
        zzhk zzfu = super.zzfu();
        AppMethodBeat.o(1897);
        return zzfu;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzfb zzfv() {
        AppMethodBeat.i(1898);
        zzfb zzfv = super.zzfv();
        AppMethodBeat.o(1898);
        return zzfv;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzeo zzfw() {
        AppMethodBeat.i(1899);
        zzeo zzfw = super.zzfw();
        AppMethodBeat.o(1899);
        return zzfw;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzii zzfx() {
        AppMethodBeat.i(1900);
        zzii zzfx = super.zzfx();
        AppMethodBeat.o(1900);
        return zzfx;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzif zzfy() {
        AppMethodBeat.i(1901);
        zzif zzfy = super.zzfy();
        AppMethodBeat.o(1901);
        return zzfy;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzfc zzfz() {
        AppMethodBeat.i(1904);
        zzfc zzfz = super.zzfz();
        AppMethodBeat.o(1904);
        return zzfz;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzfe zzga() {
        AppMethodBeat.i(1905);
        zzfe zzga = super.zzga();
        AppMethodBeat.o(1905);
        return zzga;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzka zzgb() {
        AppMethodBeat.i(1906);
        zzka zzgb = super.zzgb();
        AppMethodBeat.o(1906);
        return zzgb;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzjh zzgc() {
        AppMethodBeat.i(1907);
        zzjh zzgc = super.zzgc();
        AppMethodBeat.o(1907);
        return zzgc;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg, com.google.android.gms.internal.measurement.zzec
    public final /* bridge */ /* synthetic */ zzgg zzgd() {
        AppMethodBeat.i(1908);
        zzgg zzgd = super.zzgd();
        AppMethodBeat.o(1908);
        return zzgd;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg, com.google.android.gms.internal.measurement.zzec
    public final /* bridge */ /* synthetic */ zzfg zzge() {
        AppMethodBeat.i(1909);
        zzfg zzge = super.zzge();
        AppMethodBeat.o(1909);
        return zzge;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzfr zzgf() {
        AppMethodBeat.i(1910);
        zzfr zzgf = super.zzgf();
        AppMethodBeat.o(1910);
        return zzgf;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzef zzgg() {
        AppMethodBeat.i(1911);
        zzef zzgg = super.zzgg();
        AppMethodBeat.o(1911);
        return zzgg;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.zzhh
    public final boolean zzhf() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public final void zzkj() {
        AppMethodBeat.i(1888);
        this.zzapv.cancel();
        this.zzapw.cancel();
        this.zzapu = 0;
        AppMethodBeat.o(1888);
    }

    public final boolean zzl(boolean z) {
        AppMethodBeat.i(1891);
        zzab();
        zzch();
        long elapsedRealtime = zzbt().elapsedRealtime();
        zzgf().zzakl.set(zzbt().currentTimeMillis());
        long j2 = elapsedRealtime - this.zzapu;
        if (z || j2 >= 1000) {
            zzgf().zzakm.set(j2);
            zzge().zzit().zzg("Recording user engagement, ms", Long.valueOf(j2));
            Bundle bundle = new Bundle();
            bundle.putLong("_et", j2);
            zzif.zza(zzfy().zzkc(), bundle, true);
            zzfu().logEvent("auto", "_e", bundle);
            this.zzapu = elapsedRealtime;
            this.zzapw.cancel();
            this.zzapw.zzh(Math.max(0L, Util.MILLSECONDS_OF_HOUR - zzgf().zzakm.get()));
            AppMethodBeat.o(1891);
            return true;
        }
        zzge().zzit().zzg("Screen exposed for less than 1000 ms. Event not sent. time", Long.valueOf(j2));
        AppMethodBeat.o(1891);
        return false;
    }
}
