package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.content.pm.PackageManager;
import com.google.android.gms.common.util.Clock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Calendar;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public final class zzeo extends zzhh {
    private long zzafm;
    private String zzafn;
    private Boolean zzafo;

    zzeo(zzgl zzgl) {
        super(zzgl);
    }

    @Override // com.google.android.gms.internal.measurement.zzhg, com.google.android.gms.internal.measurement.zzec
    public final /* bridge */ /* synthetic */ Context getContext() {
        AppMethodBeat.i(1235);
        Context context = super.getContext();
        AppMethodBeat.o(1235);
        return context;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ void zzab() {
        AppMethodBeat.i(1227);
        super.zzab();
        AppMethodBeat.o(1227);
    }

    @Override // com.google.android.gms.internal.measurement.zzhg, com.google.android.gms.internal.measurement.zzec
    public final /* bridge */ /* synthetic */ Clock zzbt() {
        AppMethodBeat.i(1234);
        Clock zzbt = super.zzbt();
        AppMethodBeat.o(1234);
        return zzbt;
    }

    public final boolean zzf(Context context) {
        AppMethodBeat.i(1224);
        if (this.zzafo == null) {
            this.zzafo = Boolean.FALSE;
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager != null) {
                    packageManager.getPackageInfo("com.google.android.gms", 128);
                    this.zzafo = Boolean.TRUE;
                }
            } catch (PackageManager.NameNotFoundException e2) {
            }
        }
        boolean booleanValue = this.zzafo.booleanValue();
        AppMethodBeat.o(1224);
        return booleanValue;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ void zzfr() {
        AppMethodBeat.i(1225);
        super.zzfr();
        AppMethodBeat.o(1225);
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ void zzfs() {
        AppMethodBeat.i(1226);
        super.zzfs();
        AppMethodBeat.o(1226);
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzdu zzft() {
        AppMethodBeat.i(1228);
        zzdu zzft = super.zzft();
        AppMethodBeat.o(1228);
        return zzft;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzhk zzfu() {
        AppMethodBeat.i(1229);
        zzhk zzfu = super.zzfu();
        AppMethodBeat.o(1229);
        return zzfu;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzfb zzfv() {
        AppMethodBeat.i(1230);
        zzfb zzfv = super.zzfv();
        AppMethodBeat.o(1230);
        return zzfv;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzeo zzfw() {
        AppMethodBeat.i(1231);
        zzeo zzfw = super.zzfw();
        AppMethodBeat.o(1231);
        return zzfw;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzii zzfx() {
        AppMethodBeat.i(1232);
        zzii zzfx = super.zzfx();
        AppMethodBeat.o(1232);
        return zzfx;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzif zzfy() {
        AppMethodBeat.i(1233);
        zzif zzfy = super.zzfy();
        AppMethodBeat.o(1233);
        return zzfy;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzfc zzfz() {
        AppMethodBeat.i(1236);
        zzfc zzfz = super.zzfz();
        AppMethodBeat.o(1236);
        return zzfz;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzfe zzga() {
        AppMethodBeat.i(1237);
        zzfe zzga = super.zzga();
        AppMethodBeat.o(1237);
        return zzga;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzka zzgb() {
        AppMethodBeat.i(1238);
        zzka zzgb = super.zzgb();
        AppMethodBeat.o(1238);
        return zzgb;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzjh zzgc() {
        AppMethodBeat.i(1239);
        zzjh zzgc = super.zzgc();
        AppMethodBeat.o(1239);
        return zzgc;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg, com.google.android.gms.internal.measurement.zzec
    public final /* bridge */ /* synthetic */ zzgg zzgd() {
        AppMethodBeat.i(1240);
        zzgg zzgd = super.zzgd();
        AppMethodBeat.o(1240);
        return zzgd;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg, com.google.android.gms.internal.measurement.zzec
    public final /* bridge */ /* synthetic */ zzfg zzge() {
        AppMethodBeat.i(1241);
        zzfg zzge = super.zzge();
        AppMethodBeat.o(1241);
        return zzge;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzfr zzgf() {
        AppMethodBeat.i(1242);
        zzfr zzgf = super.zzgf();
        AppMethodBeat.o(1242);
        return zzgf;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzef zzgg() {
        AppMethodBeat.i(1243);
        zzef zzgg = super.zzgg();
        AppMethodBeat.o(1243);
        return zzgg;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.zzhh
    public final boolean zzhf() {
        AppMethodBeat.i(1221);
        Calendar instance = Calendar.getInstance();
        this.zzafm = TimeUnit.MINUTES.convert((long) (instance.get(16) + instance.get(15)), TimeUnit.MILLISECONDS);
        Locale locale = Locale.getDefault();
        String lowerCase = locale.getLanguage().toLowerCase(Locale.ENGLISH);
        String lowerCase2 = locale.getCountry().toLowerCase(Locale.ENGLISH);
        this.zzafn = new StringBuilder(String.valueOf(lowerCase).length() + 1 + String.valueOf(lowerCase2).length()).append(lowerCase).append("-").append(lowerCase2).toString();
        AppMethodBeat.o(1221);
        return false;
    }

    public final long zzic() {
        AppMethodBeat.i(1222);
        zzch();
        long j2 = this.zzafm;
        AppMethodBeat.o(1222);
        return j2;
    }

    public final String zzid() {
        AppMethodBeat.i(1223);
        zzch();
        String str = this.zzafn;
        AppMethodBeat.o(1223);
        return str;
    }
}
