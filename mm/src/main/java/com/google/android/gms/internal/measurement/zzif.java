package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.e.a;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.BuildConfig;
import java.util.Map;

public final class zzif extends zzhh {
    @VisibleForTesting
    protected zzie zzaol;
    private volatile zzie zzaom;
    private zzie zzaon;
    private long zzaoo;
    private final Map<Activity, zzie> zzaop = new a();
    private zzie zzaoq;
    private String zzaor;

    public zzif(zzgl zzgl) {
        super(zzgl);
        AppMethodBeat.i(1763);
        AppMethodBeat.o(1763);
    }

    private final void zza(Activity activity, zzie zzie, boolean z) {
        AppMethodBeat.i(1766);
        zzie zzie2 = this.zzaom == null ? this.zzaon : this.zzaom;
        if (zzie.zzaoi == null) {
            zzie = new zzie(zzie.zzul, zzca(activity.getClass().getCanonicalName()), zzie.zzaoj);
        }
        this.zzaon = this.zzaom;
        this.zzaoo = zzbt().elapsedRealtime();
        this.zzaom = zzie;
        zzgd().zzc(new zzig(this, z, zzie2, zzie));
        AppMethodBeat.o(1766);
    }

    private final void zza(zzie zzie) {
        AppMethodBeat.i(1767);
        zzft().zzk(zzbt().elapsedRealtime());
        if (zzgc().zzl(zzie.zzaok)) {
            zzie.zzaok = false;
        }
        AppMethodBeat.o(1767);
    }

    public static void zza(zzie zzie, Bundle bundle, boolean z) {
        AppMethodBeat.i(1768);
        if (bundle == null || zzie == null || (bundle.containsKey("_sc") && !z)) {
            if (bundle != null && zzie == null && z) {
                bundle.remove("_sn");
                bundle.remove("_sc");
                bundle.remove("_si");
            }
            AppMethodBeat.o(1768);
            return;
        }
        if (zzie.zzul != null) {
            bundle.putString("_sn", zzie.zzul);
        } else {
            bundle.remove("_sn");
        }
        bundle.putString("_sc", zzie.zzaoi);
        bundle.putLong("_si", zzie.zzaoj);
        AppMethodBeat.o(1768);
    }

    static /* synthetic */ void zza(zzif zzif, zzie zzie) {
        AppMethodBeat.i(1796);
        zzif.zza(zzie);
        AppMethodBeat.o(1796);
    }

    @VisibleForTesting
    private static String zzca(String str) {
        AppMethodBeat.i(1770);
        String[] split = str.split("\\.");
        String str2 = split.length > 0 ? split[split.length - 1] : "";
        if (str2.length() > 100) {
            String substring = str2.substring(0, 100);
            AppMethodBeat.o(1770);
            return substring;
        }
        AppMethodBeat.o(1770);
        return str2;
    }

    private final zzie zze(Activity activity) {
        AppMethodBeat.i(1771);
        Preconditions.checkNotNull(activity);
        zzie zzie = this.zzaop.get(activity);
        if (zzie == null) {
            zzie = new zzie(null, zzca(activity.getClass().getCanonicalName()), zzgb().zzlb());
            this.zzaop.put(activity, zzie);
        }
        AppMethodBeat.o(1771);
        return zzie;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg, com.google.android.gms.internal.measurement.zzec
    public final /* bridge */ /* synthetic */ Context getContext() {
        AppMethodBeat.i(1787);
        Context context = super.getContext();
        AppMethodBeat.o(1787);
        return context;
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        AppMethodBeat.i(1772);
        if (bundle == null) {
            AppMethodBeat.o(1772);
            return;
        }
        Bundle bundle2 = bundle.getBundle("com.google.firebase.analytics.screen_service");
        if (bundle2 == null) {
            AppMethodBeat.o(1772);
            return;
        }
        this.zzaop.put(activity, new zzie(bundle2.getString("name"), bundle2.getString("referrer_name"), bundle2.getLong("id")));
        AppMethodBeat.o(1772);
    }

    public final void onActivityDestroyed(Activity activity) {
        AppMethodBeat.i(1776);
        this.zzaop.remove(activity);
        AppMethodBeat.o(1776);
    }

    public final void onActivityPaused(Activity activity) {
        AppMethodBeat.i(1774);
        zzie zze = zze(activity);
        this.zzaon = this.zzaom;
        this.zzaoo = zzbt().elapsedRealtime();
        this.zzaom = null;
        zzgd().zzc(new zzih(this, zze));
        AppMethodBeat.o(1774);
    }

    public final void onActivityResumed(Activity activity) {
        AppMethodBeat.i(1773);
        zza(activity, zze(activity), false);
        zzdu zzft = zzft();
        zzft.zzgd().zzc(new zzdx(zzft, zzft.zzbt().elapsedRealtime()));
        AppMethodBeat.o(1773);
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        AppMethodBeat.i(1775);
        if (bundle == null) {
            AppMethodBeat.o(1775);
            return;
        }
        zzie zzie = this.zzaop.get(activity);
        if (zzie == null) {
            AppMethodBeat.o(1775);
            return;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putLong("id", zzie.zzaoj);
        bundle2.putString("name", zzie.zzul);
        bundle2.putString("referrer_name", zzie.zzaoi);
        bundle.putBundle("com.google.firebase.analytics.screen_service", bundle2);
        AppMethodBeat.o(1775);
    }

    public final void setCurrentScreen(Activity activity, String str, String str2) {
        AppMethodBeat.i(1765);
        zzgd();
        if (!zzgg.isMainThread()) {
            zzge().zzip().log("setCurrentScreen must be called from the main thread");
            AppMethodBeat.o(1765);
        } else if (this.zzaom == null) {
            zzge().zzip().log("setCurrentScreen cannot be called while no activity active");
            AppMethodBeat.o(1765);
        } else if (this.zzaop.get(activity) == null) {
            zzge().zzip().log("setCurrentScreen must be called with an activity in the activity lifecycle");
            AppMethodBeat.o(1765);
        } else {
            if (str2 == null) {
                str2 = zzca(activity.getClass().getCanonicalName());
            }
            boolean equals = this.zzaom.zzaoi.equals(str2);
            boolean zzs = zzka.zzs(this.zzaom.zzul, str);
            if (equals && zzs) {
                zzge().zziq().log("setCurrentScreen cannot be called with the same class and name");
                AppMethodBeat.o(1765);
            } else if (str != null && (str.length() <= 0 || str.length() > 100)) {
                zzge().zzip().zzg("Invalid screen name length in setCurrentScreen. Length", Integer.valueOf(str.length()));
                AppMethodBeat.o(1765);
            } else if (str2 == null || (str2.length() > 0 && str2.length() <= 100)) {
                zzge().zzit().zze("Setting current screen to name, class", str == null ? BuildConfig.COMMAND : str, str2);
                zzie zzie = new zzie(str, str2, zzgb().zzlb());
                this.zzaop.put(activity, zzie);
                zza(activity, zzie, true);
                AppMethodBeat.o(1765);
            } else {
                zzge().zzip().zzg("Invalid class name length in setCurrentScreen. Length", Integer.valueOf(str2.length()));
                AppMethodBeat.o(1765);
            }
        }
    }

    public final void zza(String str, zzie zzie) {
        AppMethodBeat.i(1769);
        zzab();
        synchronized (this) {
            try {
                if (this.zzaor == null || this.zzaor.equals(str) || zzie != null) {
                    this.zzaor = str;
                    this.zzaoq = zzie;
                }
            } finally {
                AppMethodBeat.o(1769);
            }
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ void zzab() {
        AppMethodBeat.i(1779);
        super.zzab();
        AppMethodBeat.o(1779);
    }

    @Override // com.google.android.gms.internal.measurement.zzhg, com.google.android.gms.internal.measurement.zzec
    public final /* bridge */ /* synthetic */ Clock zzbt() {
        AppMethodBeat.i(1786);
        Clock zzbt = super.zzbt();
        AppMethodBeat.o(1786);
        return zzbt;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ void zzfr() {
        AppMethodBeat.i(1777);
        super.zzfr();
        AppMethodBeat.o(1777);
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ void zzfs() {
        AppMethodBeat.i(1778);
        super.zzfs();
        AppMethodBeat.o(1778);
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzdu zzft() {
        AppMethodBeat.i(1780);
        zzdu zzft = super.zzft();
        AppMethodBeat.o(1780);
        return zzft;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzhk zzfu() {
        AppMethodBeat.i(1781);
        zzhk zzfu = super.zzfu();
        AppMethodBeat.o(1781);
        return zzfu;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzfb zzfv() {
        AppMethodBeat.i(1782);
        zzfb zzfv = super.zzfv();
        AppMethodBeat.o(1782);
        return zzfv;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzeo zzfw() {
        AppMethodBeat.i(1783);
        zzeo zzfw = super.zzfw();
        AppMethodBeat.o(1783);
        return zzfw;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzii zzfx() {
        AppMethodBeat.i(1784);
        zzii zzfx = super.zzfx();
        AppMethodBeat.o(1784);
        return zzfx;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzif zzfy() {
        AppMethodBeat.i(1785);
        zzif zzfy = super.zzfy();
        AppMethodBeat.o(1785);
        return zzfy;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzfc zzfz() {
        AppMethodBeat.i(1788);
        zzfc zzfz = super.zzfz();
        AppMethodBeat.o(1788);
        return zzfz;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzfe zzga() {
        AppMethodBeat.i(1789);
        zzfe zzga = super.zzga();
        AppMethodBeat.o(1789);
        return zzga;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzka zzgb() {
        AppMethodBeat.i(1790);
        zzka zzgb = super.zzgb();
        AppMethodBeat.o(1790);
        return zzgb;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzjh zzgc() {
        AppMethodBeat.i(1791);
        zzjh zzgc = super.zzgc();
        AppMethodBeat.o(1791);
        return zzgc;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg, com.google.android.gms.internal.measurement.zzec
    public final /* bridge */ /* synthetic */ zzgg zzgd() {
        AppMethodBeat.i(1792);
        zzgg zzgd = super.zzgd();
        AppMethodBeat.o(1792);
        return zzgd;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg, com.google.android.gms.internal.measurement.zzec
    public final /* bridge */ /* synthetic */ zzfg zzge() {
        AppMethodBeat.i(1793);
        zzfg zzge = super.zzge();
        AppMethodBeat.o(1793);
        return zzge;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzfr zzgf() {
        AppMethodBeat.i(1794);
        zzfr zzgf = super.zzgf();
        AppMethodBeat.o(1794);
        return zzgf;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzef zzgg() {
        AppMethodBeat.i(1795);
        zzef zzgg = super.zzgg();
        AppMethodBeat.o(1795);
        return zzgg;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.zzhh
    public final boolean zzhf() {
        return false;
    }

    public final zzie zzkc() {
        AppMethodBeat.i(1764);
        zzch();
        zzab();
        zzie zzie = this.zzaol;
        AppMethodBeat.o(1764);
        return zzie;
    }

    public final zzie zzkd() {
        return this.zzaom;
    }
}
