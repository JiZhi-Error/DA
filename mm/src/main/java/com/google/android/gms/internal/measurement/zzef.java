package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.ProcessUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.Wrappers;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.api.APMidasResponse;
import com.tencent.soter.core.biometric.FaceManager;
import java.lang.reflect.InvocationTargetException;

public final class zzef extends zzhg {
    private zzeh zzaet = zzeg.zzaeu;
    private Boolean zzxz;

    zzef(zzgl zzgl) {
        super(zzgl);
    }

    public static long zzhh() {
        AppMethodBeat.i(1127);
        long longValue = zzew.zzahl.get().longValue();
        AppMethodBeat.o(1127);
        return longValue;
    }

    public static long zzhi() {
        AppMethodBeat.i(1128);
        long longValue = zzew.zzagl.get().longValue();
        AppMethodBeat.o(1128);
        return longValue;
    }

    public static boolean zzhk() {
        AppMethodBeat.i(1130);
        boolean booleanValue = zzew.zzagh.get().booleanValue();
        AppMethodBeat.o(1130);
        return booleanValue;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg, com.google.android.gms.internal.measurement.zzec
    public final /* bridge */ /* synthetic */ Context getContext() {
        AppMethodBeat.i(1151);
        Context context = super.getContext();
        AppMethodBeat.o(1151);
        return context;
    }

    public final long zza(String str, zzex<Long> zzex) {
        AppMethodBeat.i(FaceManager.FACE_ACQUIRED_MULTI_FACE);
        if (str == null) {
            long longValue = zzex.get().longValue();
            AppMethodBeat.o(FaceManager.FACE_ACQUIRED_MULTI_FACE);
            return longValue;
        }
        String zze = this.zzaet.zze(str, zzex.getKey());
        if (TextUtils.isEmpty(zze)) {
            long longValue2 = zzex.get().longValue();
            AppMethodBeat.o(FaceManager.FACE_ACQUIRED_MULTI_FACE);
            return longValue2;
        }
        try {
            long longValue3 = zzex.get(Long.valueOf(Long.parseLong(zze))).longValue();
            AppMethodBeat.o(FaceManager.FACE_ACQUIRED_MULTI_FACE);
            return longValue3;
        } catch (NumberFormatException e2) {
            long longValue4 = zzex.get().longValue();
            AppMethodBeat.o(FaceManager.FACE_ACQUIRED_MULTI_FACE);
            return longValue4;
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzeh zzeh) {
        this.zzaet = zzeh;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ void zzab() {
        AppMethodBeat.i(1143);
        super.zzab();
        AppMethodBeat.o(1143);
    }

    public final int zzar(String str) {
        AppMethodBeat.i(FaceManager.FACE_ACQUIRED_MOUTH_OCCLUSION);
        int zzb = zzb(str, zzew.zzagw);
        AppMethodBeat.o(FaceManager.FACE_ACQUIRED_MOUTH_OCCLUSION);
        return zzb;
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public final Boolean zzas(String str) {
        AppMethodBeat.i(1125);
        Preconditions.checkNotEmpty(str);
        try {
            if (getContext().getPackageManager() == null) {
                zzge().zzim().log("Failed to load metadata: PackageManager is null");
                AppMethodBeat.o(1125);
                return null;
            }
            ApplicationInfo applicationInfo = Wrappers.packageManager(getContext()).getApplicationInfo(getContext().getPackageName(), 128);
            if (applicationInfo == null) {
                zzge().zzim().log("Failed to load metadata: ApplicationInfo is null");
                AppMethodBeat.o(1125);
                return null;
            } else if (applicationInfo.metaData == null) {
                zzge().zzim().log("Failed to load metadata: Metadata bundle is null");
                AppMethodBeat.o(1125);
                return null;
            } else if (!applicationInfo.metaData.containsKey(str)) {
                AppMethodBeat.o(1125);
                return null;
            } else {
                Boolean valueOf = Boolean.valueOf(applicationInfo.metaData.getBoolean(str));
                AppMethodBeat.o(1125);
                return valueOf;
            }
        } catch (PackageManager.NameNotFoundException e2) {
            zzge().zzim().zzg("Failed to load metadata: Package name not found", e2);
            AppMethodBeat.o(1125);
            return null;
        }
    }

    public final boolean zzat(String str) {
        AppMethodBeat.i(1131);
        boolean equals = "1".equals(this.zzaet.zze(str, "gaia_collection_enabled"));
        AppMethodBeat.o(1131);
        return equals;
    }

    public final boolean zzau(String str) {
        AppMethodBeat.i(1132);
        boolean equals = "1".equals(this.zzaet.zze(str, "measurement.event_sampling_enabled"));
        AppMethodBeat.o(1132);
        return equals;
    }

    /* access modifiers changed from: package-private */
    public final boolean zzav(String str) {
        AppMethodBeat.i(1133);
        boolean zzd = zzd(str, zzew.zzahu);
        AppMethodBeat.o(1133);
        return zzd;
    }

    /* access modifiers changed from: package-private */
    public final boolean zzaw(String str) {
        AppMethodBeat.i(1134);
        boolean zzd = zzd(str, zzew.zzahw);
        AppMethodBeat.o(1134);
        return zzd;
    }

    /* access modifiers changed from: package-private */
    public final boolean zzax(String str) {
        AppMethodBeat.i(1135);
        boolean zzd = zzd(str, zzew.zzahx);
        AppMethodBeat.o(1135);
        return zzd;
    }

    /* access modifiers changed from: package-private */
    public final boolean zzay(String str) {
        AppMethodBeat.i(1138);
        boolean zzd = zzd(str, zzew.zzahy);
        AppMethodBeat.o(1138);
        return zzd;
    }

    /* access modifiers changed from: package-private */
    public final boolean zzaz(String str) {
        AppMethodBeat.i(1139);
        boolean zzd = zzd(str, zzew.zzahz);
        AppMethodBeat.o(1139);
        return zzd;
    }

    public final int zzb(String str, zzex<Integer> zzex) {
        AppMethodBeat.i(1122);
        if (str == null) {
            int intValue = zzex.get().intValue();
            AppMethodBeat.o(1122);
            return intValue;
        }
        String zze = this.zzaet.zze(str, zzex.getKey());
        if (TextUtils.isEmpty(zze)) {
            int intValue2 = zzex.get().intValue();
            AppMethodBeat.o(1122);
            return intValue2;
        }
        try {
            int intValue3 = zzex.get(Integer.valueOf(Integer.parseInt(zze))).intValue();
            AppMethodBeat.o(1122);
            return intValue3;
        } catch (NumberFormatException e2) {
            int intValue4 = zzex.get().intValue();
            AppMethodBeat.o(1122);
            return intValue4;
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean zzba(String str) {
        AppMethodBeat.i(1140);
        boolean zzd = zzd(str, zzew.zzaic);
        AppMethodBeat.o(1140);
        return zzd;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg, com.google.android.gms.internal.measurement.zzec
    public final /* bridge */ /* synthetic */ Clock zzbt() {
        AppMethodBeat.i(1150);
        Clock zzbt = super.zzbt();
        AppMethodBeat.o(1150);
        return zzbt;
    }

    public final double zzc(String str, zzex<Double> zzex) {
        AppMethodBeat.i(1123);
        if (str == null) {
            double doubleValue = zzex.get().doubleValue();
            AppMethodBeat.o(1123);
            return doubleValue;
        }
        String zze = this.zzaet.zze(str, zzex.getKey());
        if (TextUtils.isEmpty(zze)) {
            double doubleValue2 = zzex.get().doubleValue();
            AppMethodBeat.o(1123);
            return doubleValue2;
        }
        try {
            double doubleValue3 = zzex.get(Double.valueOf(Double.parseDouble(zze))).doubleValue();
            AppMethodBeat.o(1123);
            return doubleValue3;
        } catch (NumberFormatException e2) {
            double doubleValue4 = zzex.get().doubleValue();
            AppMethodBeat.o(1123);
            return doubleValue4;
        }
    }

    public final boolean zzd(String str, zzex<Boolean> zzex) {
        AppMethodBeat.i(1124);
        if (str == null) {
            boolean booleanValue = zzex.get().booleanValue();
            AppMethodBeat.o(1124);
            return booleanValue;
        }
        String zze = this.zzaet.zze(str, zzex.getKey());
        if (TextUtils.isEmpty(zze)) {
            boolean booleanValue2 = zzex.get().booleanValue();
            AppMethodBeat.o(1124);
            return booleanValue2;
        }
        boolean booleanValue3 = zzex.get(Boolean.valueOf(Boolean.parseBoolean(zze))).booleanValue();
        AppMethodBeat.o(1124);
        return booleanValue3;
    }

    public final boolean zzds() {
        AppMethodBeat.i(FaceManager.FACE_ACQUIRED_NOSE_OCCLUSION);
        if (this.zzxz == null) {
            synchronized (this) {
                try {
                    if (this.zzxz == null) {
                        ApplicationInfo applicationInfo = getContext().getApplicationInfo();
                        String myProcessName = ProcessUtils.getMyProcessName();
                        if (applicationInfo != null) {
                            String str = applicationInfo.processName;
                            this.zzxz = Boolean.valueOf(str != null && str.equals(myProcessName));
                        }
                        if (this.zzxz == null) {
                            this.zzxz = Boolean.TRUE;
                            zzge().zzim().log("My process not in the list of running processes");
                        }
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(FaceManager.FACE_ACQUIRED_NOSE_OCCLUSION);
                    throw th;
                }
            }
        }
        boolean booleanValue = this.zzxz.booleanValue();
        AppMethodBeat.o(FaceManager.FACE_ACQUIRED_NOSE_OCCLUSION);
        return booleanValue;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ void zzfr() {
        AppMethodBeat.i(1141);
        super.zzfr();
        AppMethodBeat.o(1141);
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ void zzfs() {
        AppMethodBeat.i(1142);
        super.zzfs();
        AppMethodBeat.o(1142);
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzdu zzft() {
        AppMethodBeat.i(1144);
        zzdu zzft = super.zzft();
        AppMethodBeat.o(1144);
        return zzft;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzhk zzfu() {
        AppMethodBeat.i(1145);
        zzhk zzfu = super.zzfu();
        AppMethodBeat.o(1145);
        return zzfu;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzfb zzfv() {
        AppMethodBeat.i(1146);
        zzfb zzfv = super.zzfv();
        AppMethodBeat.o(1146);
        return zzfv;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzeo zzfw() {
        AppMethodBeat.i(1147);
        zzeo zzfw = super.zzfw();
        AppMethodBeat.o(1147);
        return zzfw;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzii zzfx() {
        AppMethodBeat.i(1148);
        zzii zzfx = super.zzfx();
        AppMethodBeat.o(1148);
        return zzfx;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzif zzfy() {
        AppMethodBeat.i(1149);
        zzif zzfy = super.zzfy();
        AppMethodBeat.o(1149);
        return zzfy;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzfc zzfz() {
        AppMethodBeat.i(1152);
        zzfc zzfz = super.zzfz();
        AppMethodBeat.o(1152);
        return zzfz;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzfe zzga() {
        AppMethodBeat.i(1153);
        zzfe zzga = super.zzga();
        AppMethodBeat.o(1153);
        return zzga;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzka zzgb() {
        AppMethodBeat.i(1154);
        zzka zzgb = super.zzgb();
        AppMethodBeat.o(1154);
        return zzgb;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzjh zzgc() {
        AppMethodBeat.i(1155);
        zzjh zzgc = super.zzgc();
        AppMethodBeat.o(1155);
        return zzgc;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg, com.google.android.gms.internal.measurement.zzec
    public final /* bridge */ /* synthetic */ zzgg zzgd() {
        AppMethodBeat.i(1156);
        zzgg zzgd = super.zzgd();
        AppMethodBeat.o(1156);
        return zzgd;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg, com.google.android.gms.internal.measurement.zzec
    public final /* bridge */ /* synthetic */ zzfg zzge() {
        AppMethodBeat.i(1157);
        zzfg zzge = super.zzge();
        AppMethodBeat.o(1157);
        return zzge;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzfr zzgf() {
        AppMethodBeat.i(1158);
        zzfr zzgf = super.zzgf();
        AppMethodBeat.o(1158);
        return zzgf;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzef zzgg() {
        AppMethodBeat.i(APMidasResponse.PAYRESULT_ALREADY_OWNED);
        zzef zzgg = super.zzgg();
        AppMethodBeat.o(APMidasResponse.PAYRESULT_ALREADY_OWNED);
        return zzgg;
    }

    public final boolean zzhg() {
        AppMethodBeat.i(1126);
        Boolean zzas = zzas("firebase_analytics_collection_deactivated");
        if (zzas == null || !zzas.booleanValue()) {
            AppMethodBeat.o(1126);
            return false;
        }
        AppMethodBeat.o(1126);
        return true;
    }

    public final String zzhj() {
        AppMethodBeat.i(1129);
        try {
            String str = (String) Class.forName("android.os.SystemProperties").getMethod("get", String.class, String.class).invoke(null, "debug.firebase.analytics.app", "");
            AppMethodBeat.o(1129);
            return str;
        } catch (ClassNotFoundException e2) {
            zzge().zzim().zzg("Could not find SystemProperties class", e2);
            AppMethodBeat.o(1129);
            return "";
        } catch (NoSuchMethodException e3) {
            zzge().zzim().zzg("Could not find SystemProperties.get() method", e3);
            AppMethodBeat.o(1129);
            return "";
        } catch (IllegalAccessException e4) {
            zzge().zzim().zzg("Could not access SystemProperties.get()", e4);
            AppMethodBeat.o(1129);
            return "";
        } catch (InvocationTargetException e5) {
            zzge().zzim().zzg("SystemProperties.get() threw an exception", e5);
            AppMethodBeat.o(1129);
            return "";
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean zzhl() {
        AppMethodBeat.i(1136);
        boolean zzd = zzd(zzfv().zzah(), zzew.zzahp);
        AppMethodBeat.o(1136);
        return zzd;
    }

    /* access modifiers changed from: package-private */
    public final String zzhm() {
        AppMethodBeat.i(1137);
        String zzah = zzfv().zzah();
        zzex<String> zzex = zzew.zzahq;
        if (zzah == null) {
            String str = zzex.get();
            AppMethodBeat.o(1137);
            return str;
        }
        String str2 = zzex.get(this.zzaet.zze(zzah, zzex.getKey()));
        AppMethodBeat.o(1137);
        return str2;
    }
}
