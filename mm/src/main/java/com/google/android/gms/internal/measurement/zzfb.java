package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import com.facebook.internal.AnalyticsEvents;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.GoogleServices;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.wrappers.InstantApps;
import com.google.firebase.iid.FirebaseInstanceId;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.math.BigInteger;
import java.util.Locale;

public final class zzfb extends zzhh {
    private String zzadm;
    private String zzadt;
    private long zzadx;
    private int zzaen;
    private int zzaie;
    private long zzaif;
    private String zztg;
    private String zzth;
    private String zzti;

    zzfb(zzgl zzgl) {
        super(zzgl);
    }

    @Override // com.google.android.gms.internal.measurement.zzhg, com.google.android.gms.internal.measurement.zzec
    public final /* bridge */ /* synthetic */ Context getContext() {
        AppMethodBeat.i(1316);
        Context context = super.getContext();
        AppMethodBeat.o(1316);
        return context;
    }

    /* access modifiers changed from: package-private */
    public final String getGmpAppId() {
        AppMethodBeat.i(1303);
        zzch();
        String str = this.zzadm;
        AppMethodBeat.o(1303);
        return str;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ void zzab() {
        AppMethodBeat.i(1308);
        super.zzab();
        AppMethodBeat.o(1308);
    }

    /* access modifiers changed from: package-private */
    public final String zzah() {
        AppMethodBeat.i(1302);
        zzch();
        String str = this.zzti;
        AppMethodBeat.o(1302);
        return str;
    }

    /* access modifiers changed from: package-private */
    public final zzdz zzbi(String str) {
        AppMethodBeat.i(1299);
        zzab();
        String zzah = zzah();
        String gmpAppId = getGmpAppId();
        zzch();
        String str2 = this.zzth;
        long zzij = (long) zzij();
        zzch();
        String str3 = this.zzadt;
        zzch();
        zzab();
        if (this.zzaif == 0) {
            this.zzaif = this.zzacw.zzgb().zzd(getContext(), getContext().getPackageName());
        }
        long j2 = this.zzaif;
        boolean isEnabled = this.zzacw.isEnabled();
        boolean z = !zzgf().zzakn;
        String zzgj = zzgj();
        zzch();
        long zzjt = this.zzacw.zzjt();
        int zzik = zzik();
        Boolean zzas = zzgg().zzas("google_analytics_adid_collection_enabled");
        boolean z2 = zzas == null || zzas.booleanValue();
        Boolean zzas2 = zzgg().zzas("google_analytics_ssaid_collection_enabled");
        zzdz zzdz = new zzdz(zzah, gmpAppId, str2, zzij, str3, 12451, j2, str, isEnabled, z, zzgj, 0, zzjt, zzik, z2, zzas2 == null || zzas2.booleanValue(), zzgf().zzje());
        AppMethodBeat.o(1299);
        return zzdz;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg, com.google.android.gms.internal.measurement.zzec
    public final /* bridge */ /* synthetic */ Clock zzbt() {
        AppMethodBeat.i(1315);
        Clock zzbt = super.zzbt();
        AppMethodBeat.o(1315);
        return zzbt;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ void zzfr() {
        AppMethodBeat.i(1306);
        super.zzfr();
        AppMethodBeat.o(1306);
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ void zzfs() {
        AppMethodBeat.i(1307);
        super.zzfs();
        AppMethodBeat.o(1307);
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzdu zzft() {
        AppMethodBeat.i(1309);
        zzdu zzft = super.zzft();
        AppMethodBeat.o(1309);
        return zzft;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzhk zzfu() {
        AppMethodBeat.i(1310);
        zzhk zzfu = super.zzfu();
        AppMethodBeat.o(1310);
        return zzfu;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzfb zzfv() {
        AppMethodBeat.i(1311);
        zzfb zzfv = super.zzfv();
        AppMethodBeat.o(1311);
        return zzfv;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzeo zzfw() {
        AppMethodBeat.i(1312);
        zzeo zzfw = super.zzfw();
        AppMethodBeat.o(1312);
        return zzfw;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzii zzfx() {
        AppMethodBeat.i(1313);
        zzii zzfx = super.zzfx();
        AppMethodBeat.o(1313);
        return zzfx;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzif zzfy() {
        AppMethodBeat.i(1314);
        zzif zzfy = super.zzfy();
        AppMethodBeat.o(1314);
        return zzfy;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzfc zzfz() {
        AppMethodBeat.i(1317);
        zzfc zzfz = super.zzfz();
        AppMethodBeat.o(1317);
        return zzfz;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzfe zzga() {
        AppMethodBeat.i(1318);
        zzfe zzga = super.zzga();
        AppMethodBeat.o(1318);
        return zzga;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzka zzgb() {
        AppMethodBeat.i(1319);
        zzka zzgb = super.zzgb();
        AppMethodBeat.o(1319);
        return zzgb;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzjh zzgc() {
        AppMethodBeat.i(1320);
        zzjh zzgc = super.zzgc();
        AppMethodBeat.o(1320);
        return zzgc;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg, com.google.android.gms.internal.measurement.zzec
    public final /* bridge */ /* synthetic */ zzgg zzgd() {
        AppMethodBeat.i(1321);
        zzgg zzgd = super.zzgd();
        AppMethodBeat.o(1321);
        return zzgd;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg, com.google.android.gms.internal.measurement.zzec
    public final /* bridge */ /* synthetic */ zzfg zzge() {
        AppMethodBeat.i(1322);
        zzfg zzge = super.zzge();
        AppMethodBeat.o(1322);
        return zzge;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzfr zzgf() {
        AppMethodBeat.i(1323);
        zzfr zzgf = super.zzgf();
        AppMethodBeat.o(1323);
        return zzgf;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzef zzgg() {
        AppMethodBeat.i(1324);
        zzef zzgg = super.zzgg();
        AppMethodBeat.o(1324);
        return zzgg;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.zzhh
    public final boolean zzhf() {
        return true;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.zzhh
    public final void zzih() {
        boolean z;
        int i2 = 1;
        AppMethodBeat.i(1298);
        String str = "unknown";
        String str2 = AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
        int i3 = Integer.MIN_VALUE;
        String str3 = AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
        String packageName = getContext().getPackageName();
        PackageManager packageManager = getContext().getPackageManager();
        if (packageManager == null) {
            zzge().zzim().zzg("PackageManager is null, app identity information might be inaccurate. appId", zzfg.zzbm(packageName));
        } else {
            try {
                str = packageManager.getInstallerPackageName(packageName);
            } catch (IllegalArgumentException e2) {
                zzge().zzim().zzg("Error retrieving app installer package name. appId", zzfg.zzbm(packageName));
            }
            if (str == null) {
                str = "manual_install";
            } else if ("com.android.vending".equals(str)) {
                str = "";
            }
            try {
                PackageInfo packageInfo = packageManager.getPackageInfo(getContext().getPackageName(), 0);
                if (packageInfo != null) {
                    CharSequence applicationLabel = packageManager.getApplicationLabel(packageInfo.applicationInfo);
                    if (!TextUtils.isEmpty(applicationLabel)) {
                        str3 = applicationLabel.toString();
                    }
                    str2 = packageInfo.versionName;
                    i3 = packageInfo.versionCode;
                }
            } catch (PackageManager.NameNotFoundException e3) {
                zzge().zzim().zze("Error retrieving package info. appId, appName", zzfg.zzbm(packageName), str3);
            }
        }
        this.zzti = packageName;
        this.zzadt = str;
        this.zzth = str2;
        this.zzaie = i3;
        this.zztg = str3;
        this.zzaif = 0;
        Status initialize = GoogleServices.initialize(getContext());
        boolean z2 = initialize != null && initialize.isSuccess();
        if (!z2) {
            if (initialize == null) {
                zzge().zzim().log("GoogleService failed to initialize (no status)");
            } else {
                zzge().zzim().zze("GoogleService failed to initialize, status", Integer.valueOf(initialize.getStatusCode()), initialize.getStatusMessage());
            }
        }
        if (z2) {
            Boolean zzas = zzgg().zzas("firebase_analytics_collection_enabled");
            if (zzgg().zzhg()) {
                zzge().zzir().log("Collection disabled with firebase_analytics_collection_deactivated=1");
                z = false;
            } else if (zzas != null && !zzas.booleanValue()) {
                zzge().zzir().log("Collection disabled with firebase_analytics_collection_enabled=0");
                z = false;
            } else if (zzas != null || !GoogleServices.isMeasurementExplicitlyDisabled()) {
                zzge().zzit().log("Collection enabled");
                z = true;
            } else {
                zzge().zzir().log("Collection disabled with google_app_measurement_enable=0");
                z = false;
            }
        } else {
            z = false;
        }
        this.zzadm = "";
        this.zzadx = 0;
        try {
            String googleAppId = GoogleServices.getGoogleAppId();
            if (TextUtils.isEmpty(googleAppId)) {
                googleAppId = "";
            }
            this.zzadm = googleAppId;
            if (z) {
                zzge().zzit().zze("App package, google app id", this.zzti, this.zzadm);
            }
        } catch (IllegalStateException e4) {
            zzge().zzim().zze("getGoogleAppId or isMeasurementEnabled failed with exception. appId", zzfg.zzbm(packageName), e4);
        }
        if (Build.VERSION.SDK_INT >= 16) {
            if (!InstantApps.isInstantApp(getContext())) {
                i2 = 0;
            }
            this.zzaen = i2;
            AppMethodBeat.o(1298);
            return;
        }
        this.zzaen = 0;
        AppMethodBeat.o(1298);
    }

    /* access modifiers changed from: package-private */
    public final String zzii() {
        AppMethodBeat.i(1300);
        byte[] bArr = new byte[16];
        zzgb().zzlc().nextBytes(bArr);
        String format = String.format(Locale.US, "%032x", new BigInteger(1, bArr));
        AppMethodBeat.o(1300);
        return format;
    }

    /* access modifiers changed from: package-private */
    public final int zzij() {
        AppMethodBeat.i(1304);
        zzch();
        int i2 = this.zzaie;
        AppMethodBeat.o(1304);
        return i2;
    }

    /* access modifiers changed from: package-private */
    public final int zzik() {
        AppMethodBeat.i(1305);
        zzch();
        int i2 = this.zzaen;
        AppMethodBeat.o(1305);
        return i2;
    }

    private final String zzgj() {
        String str = null;
        AppMethodBeat.i(1301);
        zzab();
        if (!zzgg().zzay(this.zzti) || this.zzacw.isEnabled()) {
            try {
                FirebaseInstanceId.yc().yd();
                str = FirebaseInstanceId.zzf();
                AppMethodBeat.o(1301);
            } catch (IllegalStateException e2) {
                zzge().zzip().log("Failed to retrieve Firebase Instance Id");
                AppMethodBeat.o(1301);
            }
        } else {
            AppMethodBeat.o(1301);
        }
        return str;
    }
}
