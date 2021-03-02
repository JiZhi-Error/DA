package com.google.android.gms.internal.measurement;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteException;
import android.support.v4.e.a;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.util.Map;

public final class zzgf extends zzjq implements zzeh {
    @VisibleForTesting
    private static int zzalf = 65535;
    @VisibleForTesting
    private static int zzalg = 2;
    private final Map<String, Map<String, String>> zzalh = new a();
    private final Map<String, Map<String, Boolean>> zzali = new a();
    private final Map<String, Map<String, Boolean>> zzalj = new a();
    private final Map<String, zzkk> zzalk = new a();
    private final Map<String, Map<String, Integer>> zzall = new a();
    private final Map<String, String> zzalm = new a();

    zzgf(zzjr zzjr) {
        super(zzjr);
        AppMethodBeat.i(1509);
        AppMethodBeat.o(1509);
    }

    private final zzkk zza(String str, byte[] bArr) {
        AppMethodBeat.i(1522);
        if (bArr == null) {
            zzkk zzkk = new zzkk();
            AppMethodBeat.o(1522);
            return zzkk;
        }
        zzabv zza = zzabv.zza(bArr, 0, bArr.length);
        zzkk zzkk2 = new zzkk();
        try {
            zzkk2.zzb(zza);
            zzge().zzit().zze("Parsed config. version, gmp_app_id", zzkk2.zzasp, zzkk2.zzadm);
            AppMethodBeat.o(1522);
            return zzkk2;
        } catch (IOException e2) {
            zzge().zzip().zze("Unable to merge remote config. appId", zzfg.zzbm(str), e2);
            zzkk zzkk3 = new zzkk();
            AppMethodBeat.o(1522);
            return zzkk3;
        }
    }

    private static Map<String, String> zza(zzkk zzkk) {
        AppMethodBeat.i(1516);
        a aVar = new a();
        if (!(zzkk == null || zzkk.zzasr == null)) {
            zzkl[] zzklArr = zzkk.zzasr;
            for (zzkl zzkl : zzklArr) {
                if (zzkl != null) {
                    aVar.put(zzkl.zzny, zzkl.value);
                }
            }
        }
        AppMethodBeat.o(1516);
        return aVar;
    }

    private final void zza(String str, zzkk zzkk) {
        AppMethodBeat.i(1517);
        a aVar = new a();
        a aVar2 = new a();
        a aVar3 = new a();
        if (!(zzkk == null || zzkk.zzass == null)) {
            zzkj[] zzkjArr = zzkk.zzass;
            for (zzkj zzkj : zzkjArr) {
                if (TextUtils.isEmpty(zzkj.name)) {
                    zzge().zzip().log("EventConfig contained null event name");
                } else {
                    String zzak = AppMeasurement.Event.zzak(zzkj.name);
                    if (!TextUtils.isEmpty(zzak)) {
                        zzkj.name = zzak;
                    }
                    aVar.put(zzkj.name, zzkj.zzasm);
                    aVar2.put(zzkj.name, zzkj.zzasn);
                    if (zzkj.zzaso != null) {
                        if (zzkj.zzaso.intValue() < zzalg || zzkj.zzaso.intValue() > zzalf) {
                            zzge().zzip().zze("Invalid sampling rate. Event name, sample rate", zzkj.name, zzkj.zzaso);
                        } else {
                            aVar3.put(zzkj.name, zzkj.zzaso);
                        }
                    }
                }
            }
        }
        this.zzali.put(str, aVar);
        this.zzalj.put(str, aVar2);
        this.zzall.put(str, aVar3);
        AppMethodBeat.o(1517);
    }

    private final void zzbt(String str) {
        AppMethodBeat.i(1510);
        zzch();
        zzab();
        Preconditions.checkNotEmpty(str);
        if (this.zzalk.get(str) == null) {
            byte[] zzbe = zzix().zzbe(str);
            if (zzbe == null) {
                this.zzalh.put(str, null);
                this.zzali.put(str, null);
                this.zzalj.put(str, null);
                this.zzalk.put(str, null);
                this.zzalm.put(str, null);
                this.zzall.put(str, null);
                AppMethodBeat.o(1510);
                return;
            }
            zzkk zza = zza(str, zzbe);
            this.zzalh.put(str, zza(zza));
            zza(str, zza);
            this.zzalk.put(str, zza);
            this.zzalm.put(str, null);
        }
        AppMethodBeat.o(1510);
    }

    @Override // com.google.android.gms.internal.measurement.zzhg, com.google.android.gms.internal.measurement.zzec
    public final /* bridge */ /* synthetic */ Context getContext() {
        AppMethodBeat.i(1537);
        Context context = super.getContext();
        AppMethodBeat.o(1537);
        return context;
    }

    /* access modifiers changed from: protected */
    public final boolean zza(String str, byte[] bArr, String str2) {
        AppMethodBeat.i(1518);
        zzch();
        zzab();
        Preconditions.checkNotEmpty(str);
        zzkk zza = zza(str, bArr);
        if (zza == null) {
            AppMethodBeat.o(1518);
            return false;
        }
        zza(str, zza);
        this.zzalk.put(str, zza);
        this.zzalm.put(str, str2);
        this.zzalh.put(str, zza(zza));
        zzeb zziw = zziw();
        zzkd[] zzkdArr = zza.zzast;
        Preconditions.checkNotNull(zzkdArr);
        for (zzkd zzkd : zzkdArr) {
            zzke[] zzkeArr = zzkd.zzarn;
            for (zzke zzke : zzkeArr) {
                String zzak = AppMeasurement.Event.zzak(zzke.zzarq);
                if (zzak != null) {
                    zzke.zzarq = zzak;
                }
                zzkf[] zzkfArr = zzke.zzarr;
                for (zzkf zzkf : zzkfArr) {
                    String zzak2 = AppMeasurement.Param.zzak(zzkf.zzary);
                    if (zzak2 != null) {
                        zzkf.zzary = zzak2;
                    }
                }
            }
            zzkh[] zzkhArr = zzkd.zzarm;
            for (zzkh zzkh : zzkhArr) {
                String zzak3 = AppMeasurement.UserProperty.zzak(zzkh.zzasf);
                if (zzak3 != null) {
                    zzkh.zzasf = zzak3;
                }
            }
        }
        zziw.zzix().zza(str, zzkdArr);
        try {
            zza.zzast = null;
            byte[] bArr2 = new byte[zza.zzvm()];
            zza.zza(zzabw.zzb(bArr2, 0, bArr2.length));
            bArr = bArr2;
        } catch (IOException e2) {
            zzge().zzip().zze("Unable to serialize reduced-size config. Storing full config instead. appId", zzfg.zzbm(str), e2);
        }
        zzei zzix = zzix();
        Preconditions.checkNotEmpty(str);
        zzix.zzab();
        zzix.zzch();
        ContentValues contentValues = new ContentValues();
        contentValues.put("remote_config", bArr);
        try {
            if (((long) zzix.getWritableDatabase().update("apps", contentValues, "app_id = ?", new String[]{str})) == 0) {
                zzix.zzge().zzim().zzg("Failed to update remote config (got 0). appId", zzfg.zzbm(str));
            }
        } catch (SQLiteException e3) {
            zzix.zzge().zzim().zze("Error storing remote config. appId", zzfg.zzbm(str), e3);
        }
        AppMethodBeat.o(1518);
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ void zzab() {
        AppMethodBeat.i(1529);
        super.zzab();
        AppMethodBeat.o(1529);
    }

    @Override // com.google.android.gms.internal.measurement.zzhg, com.google.android.gms.internal.measurement.zzec
    public final /* bridge */ /* synthetic */ Clock zzbt() {
        AppMethodBeat.i(1536);
        Clock zzbt = super.zzbt();
        AppMethodBeat.o(1536);
        return zzbt;
    }

    /* access modifiers changed from: protected */
    public final zzkk zzbu(String str) {
        AppMethodBeat.i(1511);
        zzch();
        zzab();
        Preconditions.checkNotEmpty(str);
        zzbt(str);
        zzkk zzkk = this.zzalk.get(str);
        AppMethodBeat.o(1511);
        return zzkk;
    }

    /* access modifiers changed from: protected */
    public final String zzbv(String str) {
        AppMethodBeat.i(1512);
        zzab();
        String str2 = this.zzalm.get(str);
        AppMethodBeat.o(1512);
        return str2;
    }

    /* access modifiers changed from: protected */
    public final void zzbw(String str) {
        AppMethodBeat.i(1513);
        zzab();
        this.zzalm.put(str, null);
        AppMethodBeat.o(1513);
    }

    /* access modifiers changed from: package-private */
    public final void zzbx(String str) {
        AppMethodBeat.i(1514);
        zzab();
        this.zzalk.remove(str);
        AppMethodBeat.o(1514);
    }

    /* access modifiers changed from: package-private */
    public final boolean zzby(String str) {
        AppMethodBeat.i(1523);
        boolean equals = "1".equals(zze(str, "measurement.upload.blacklist_internal"));
        AppMethodBeat.o(1523);
        return equals;
    }

    /* access modifiers changed from: package-private */
    public final boolean zzbz(String str) {
        AppMethodBeat.i(1524);
        boolean equals = "1".equals(zze(str, "measurement.upload.blacklist_public"));
        AppMethodBeat.o(1524);
        return equals;
    }

    @Override // com.google.android.gms.internal.measurement.zzeh
    public final String zze(String str, String str2) {
        AppMethodBeat.i(1515);
        zzab();
        zzbt(str);
        Map<String, String> map = this.zzalh.get(str);
        if (map != null) {
            String str3 = map.get(str2);
            AppMethodBeat.o(1515);
            return str3;
        }
        AppMethodBeat.o(1515);
        return null;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ void zzfr() {
        AppMethodBeat.i(1527);
        super.zzfr();
        AppMethodBeat.o(1527);
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ void zzfs() {
        AppMethodBeat.i(1528);
        super.zzfs();
        AppMethodBeat.o(1528);
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzdu zzft() {
        AppMethodBeat.i(1530);
        zzdu zzft = super.zzft();
        AppMethodBeat.o(1530);
        return zzft;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzhk zzfu() {
        AppMethodBeat.i(1531);
        zzhk zzfu = super.zzfu();
        AppMethodBeat.o(1531);
        return zzfu;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzfb zzfv() {
        AppMethodBeat.i(1532);
        zzfb zzfv = super.zzfv();
        AppMethodBeat.o(1532);
        return zzfv;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzeo zzfw() {
        AppMethodBeat.i(1533);
        zzeo zzfw = super.zzfw();
        AppMethodBeat.o(1533);
        return zzfw;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzii zzfx() {
        AppMethodBeat.i(1534);
        zzii zzfx = super.zzfx();
        AppMethodBeat.o(1534);
        return zzfx;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzif zzfy() {
        AppMethodBeat.i(1535);
        zzif zzfy = super.zzfy();
        AppMethodBeat.o(1535);
        return zzfy;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzfc zzfz() {
        AppMethodBeat.i(1538);
        zzfc zzfz = super.zzfz();
        AppMethodBeat.o(1538);
        return zzfz;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzfe zzga() {
        AppMethodBeat.i(1539);
        zzfe zzga = super.zzga();
        AppMethodBeat.o(1539);
        return zzga;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzka zzgb() {
        AppMethodBeat.i(1540);
        zzka zzgb = super.zzgb();
        AppMethodBeat.o(1540);
        return zzgb;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzjh zzgc() {
        AppMethodBeat.i(1541);
        zzjh zzgc = super.zzgc();
        AppMethodBeat.o(1541);
        return zzgc;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg, com.google.android.gms.internal.measurement.zzec
    public final /* bridge */ /* synthetic */ zzgg zzgd() {
        AppMethodBeat.i(1542);
        zzgg zzgd = super.zzgd();
        AppMethodBeat.o(1542);
        return zzgd;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg, com.google.android.gms.internal.measurement.zzec
    public final /* bridge */ /* synthetic */ zzfg zzge() {
        AppMethodBeat.i(1543);
        zzfg zzge = super.zzge();
        AppMethodBeat.o(1543);
        return zzge;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzfr zzgf() {
        AppMethodBeat.i(1544);
        zzfr zzgf = super.zzgf();
        AppMethodBeat.o(1544);
        return zzgf;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzef zzgg() {
        AppMethodBeat.i(1545);
        zzef zzgg = super.zzgg();
        AppMethodBeat.o(1545);
        return zzgg;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.zzjq
    public final boolean zzhf() {
        return false;
    }

    @Override // com.google.android.gms.internal.measurement.zzjp
    public final /* bridge */ /* synthetic */ zzeb zziw() {
        AppMethodBeat.i(1525);
        zzeb zziw = super.zziw();
        AppMethodBeat.o(1525);
        return zziw;
    }

    @Override // com.google.android.gms.internal.measurement.zzjp
    public final /* bridge */ /* synthetic */ zzei zzix() {
        AppMethodBeat.i(1526);
        zzei zzix = super.zzix();
        AppMethodBeat.o(1526);
        return zzix;
    }

    /* access modifiers changed from: package-private */
    public final boolean zzn(String str, String str2) {
        AppMethodBeat.i(1519);
        zzab();
        zzbt(str);
        if (zzby(str) && zzka.zzci(str2)) {
            AppMethodBeat.o(1519);
            return true;
        } else if (!zzbz(str) || !zzka.zzcc(str2)) {
            Map<String, Boolean> map = this.zzali.get(str);
            if (map != null) {
                Boolean bool = map.get(str2);
                if (bool == null) {
                    AppMethodBeat.o(1519);
                    return false;
                }
                boolean booleanValue = bool.booleanValue();
                AppMethodBeat.o(1519);
                return booleanValue;
            }
            AppMethodBeat.o(1519);
            return false;
        } else {
            AppMethodBeat.o(1519);
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean zzo(String str, String str2) {
        AppMethodBeat.i(1520);
        zzab();
        zzbt(str);
        if (FirebaseAnalytics.a.ECOMMERCE_PURCHASE.equals(str2)) {
            AppMethodBeat.o(1520);
            return true;
        }
        Map<String, Boolean> map = this.zzalj.get(str);
        if (map != null) {
            Boolean bool = map.get(str2);
            if (bool == null) {
                AppMethodBeat.o(1520);
                return false;
            }
            boolean booleanValue = bool.booleanValue();
            AppMethodBeat.o(1520);
            return booleanValue;
        }
        AppMethodBeat.o(1520);
        return false;
    }

    /* access modifiers changed from: package-private */
    public final int zzp(String str, String str2) {
        AppMethodBeat.i(1521);
        zzab();
        zzbt(str);
        Map<String, Integer> map = this.zzall.get(str);
        if (map != null) {
            Integer num = map.get(str2);
            if (num == null) {
                AppMethodBeat.o(1521);
                return 1;
            }
            int intValue = num.intValue();
            AppMethodBeat.o(1521);
            return intValue;
        }
        AppMethodBeat.o(1521);
        return 1;
    }
}
