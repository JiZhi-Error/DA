package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.measurement.AppMeasurement;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzfg extends zzhh {
    private long zzadu = -1;
    private char zzaim = 0;
    private String zzain;
    private final zzfi zzaio = new zzfi(this, 6, false, false);
    private final zzfi zzaip = new zzfi(this, 6, true, false);
    private final zzfi zzaiq = new zzfi(this, 6, false, true);
    private final zzfi zzair = new zzfi(this, 5, false, false);
    private final zzfi zzais = new zzfi(this, 5, true, false);
    private final zzfi zzait = new zzfi(this, 5, false, true);
    private final zzfi zzaiu = new zzfi(this, 4, false, false);
    private final zzfi zzaiv = new zzfi(this, 3, false, false);
    private final zzfi zzaiw = new zzfi(this, 2, false, false);

    zzfg(zzgl zzgl) {
        super(zzgl);
        AppMethodBeat.i(1393);
        AppMethodBeat.o(1393);
    }

    @VisibleForTesting
    private static String zza(boolean z, Object obj) {
        String className;
        AppMethodBeat.i(1400);
        if (obj == null) {
            AppMethodBeat.o(1400);
            return "";
        }
        Object valueOf = obj instanceof Integer ? Long.valueOf((long) ((Integer) obj).intValue()) : obj;
        if (valueOf instanceof Long) {
            if (!z) {
                String valueOf2 = String.valueOf(valueOf);
                AppMethodBeat.o(1400);
                return valueOf2;
            } else if (Math.abs(((Long) valueOf).longValue()) < 100) {
                String valueOf3 = String.valueOf(valueOf);
                AppMethodBeat.o(1400);
                return valueOf3;
            } else {
                String str = String.valueOf(valueOf).charAt(0) == '-' ? "-" : "";
                String valueOf4 = String.valueOf(Math.abs(((Long) valueOf).longValue()));
                String sb = new StringBuilder(String.valueOf(str).length() + 43 + String.valueOf(str).length()).append(str).append(Math.round(Math.pow(10.0d, (double) (valueOf4.length() - 1)))).append("...").append(str).append(Math.round(Math.pow(10.0d, (double) valueOf4.length()) - 1.0d)).toString();
                AppMethodBeat.o(1400);
                return sb;
            }
        } else if (valueOf instanceof Boolean) {
            String valueOf5 = String.valueOf(valueOf);
            AppMethodBeat.o(1400);
            return valueOf5;
        } else if (valueOf instanceof Throwable) {
            Throwable th = (Throwable) valueOf;
            StringBuilder sb2 = new StringBuilder(z ? th.getClass().getName() : th.toString());
            String zzbn = zzbn(AppMeasurement.class.getCanonicalName());
            String zzbn2 = zzbn(zzgl.class.getCanonicalName());
            StackTraceElement[] stackTrace = th.getStackTrace();
            int length = stackTrace.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                }
                StackTraceElement stackTraceElement = stackTrace[i2];
                if (!stackTraceElement.isNativeMethod() && (className = stackTraceElement.getClassName()) != null) {
                    String zzbn3 = zzbn(className);
                    if (zzbn3.equals(zzbn) || zzbn3.equals(zzbn2)) {
                        sb2.append(": ");
                        sb2.append(stackTraceElement);
                    }
                }
                i2++;
            }
            String sb3 = sb2.toString();
            AppMethodBeat.o(1400);
            return sb3;
        } else if (valueOf instanceof zzfj) {
            String zza = zzfj.zza((zzfj) valueOf);
            AppMethodBeat.o(1400);
            return zza;
        } else if (z) {
            AppMethodBeat.o(1400);
            return "-";
        } else {
            String valueOf6 = String.valueOf(valueOf);
            AppMethodBeat.o(1400);
            return valueOf6;
        }
    }

    static String zza(boolean z, String str, Object obj, Object obj2, Object obj3) {
        AppMethodBeat.i(1399);
        if (str == null) {
            str = "";
        }
        String zza = zza(z, obj);
        String zza2 = zza(z, obj2);
        String zza3 = zza(z, obj3);
        StringBuilder sb = new StringBuilder();
        String str2 = "";
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
            str2 = ": ";
        }
        if (!TextUtils.isEmpty(zza)) {
            sb.append(str2);
            sb.append(zza);
            str2 = ", ";
        }
        if (!TextUtils.isEmpty(zza2)) {
            sb.append(str2);
            sb.append(zza2);
            str2 = ", ";
        }
        if (!TextUtils.isEmpty(zza3)) {
            sb.append(str2);
            sb.append(zza3);
        }
        String sb2 = sb.toString();
        AppMethodBeat.o(1399);
        return sb2;
    }

    protected static Object zzbm(String str) {
        AppMethodBeat.i(1394);
        if (str == null) {
            AppMethodBeat.o(1394);
            return null;
        }
        zzfj zzfj = new zzfj(str);
        AppMethodBeat.o(1394);
        return zzfj;
    }

    private static String zzbn(String str) {
        AppMethodBeat.i(1401);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(1401);
            return "";
        }
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf == -1) {
            AppMethodBeat.o(1401);
            return str;
        }
        String substring = str.substring(0, lastIndexOf);
        AppMethodBeat.o(1401);
        return substring;
    }

    private final String zziu() {
        String str;
        AppMethodBeat.i(1398);
        synchronized (this) {
            try {
                if (this.zzain == null) {
                    this.zzain = zzew.zzagi.get();
                }
                str = this.zzain;
            } finally {
                AppMethodBeat.o(1398);
            }
        }
        return str;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg, com.google.android.gms.internal.measurement.zzec
    public final /* bridge */ /* synthetic */ Context getContext() {
        AppMethodBeat.i(1413);
        Context context = super.getContext();
        AppMethodBeat.o(1413);
        return context;
    }

    /* access modifiers changed from: protected */
    @VisibleForTesting
    public final boolean isLoggable(int i2) {
        AppMethodBeat.i(1396);
        boolean isLoggable = Log.isLoggable(zziu(), i2);
        AppMethodBeat.o(1396);
        return isLoggable;
    }

    /* access modifiers changed from: protected */
    @VisibleForTesting
    public final void zza(int i2, String str) {
        AppMethodBeat.i(1397);
        Log.println(i2, zziu(), str);
        AppMethodBeat.o(1397);
    }

    /* access modifiers changed from: protected */
    public final void zza(int i2, boolean z, boolean z2, String str, Object obj, Object obj2, Object obj3) {
        AppMethodBeat.i(1395);
        if (!z && isLoggable(i2)) {
            zza(i2, zza(false, str, obj, obj2, obj3));
        }
        if (!z2 && i2 >= 5) {
            Preconditions.checkNotNull(str);
            zzgg zzjq = this.zzacw.zzjq();
            if (zzjq == null) {
                zza(6, "Scheduler not set. Not logging error/warn");
                AppMethodBeat.o(1395);
                return;
            } else if (!zzjq.isInitialized()) {
                zza(6, "Scheduler not initialized. Not logging error/warn");
                AppMethodBeat.o(1395);
                return;
            } else {
                int i3 = i2 < 0 ? 0 : i2;
                if (i3 >= 9) {
                    i3 = 8;
                }
                zzjq.zzc(new zzfh(this, i3, str, obj, obj2, obj3));
            }
        }
        AppMethodBeat.o(1395);
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ void zzab() {
        AppMethodBeat.i(1405);
        super.zzab();
        AppMethodBeat.o(1405);
    }

    @Override // com.google.android.gms.internal.measurement.zzhg, com.google.android.gms.internal.measurement.zzec
    public final /* bridge */ /* synthetic */ Clock zzbt() {
        AppMethodBeat.i(1412);
        Clock zzbt = super.zzbt();
        AppMethodBeat.o(1412);
        return zzbt;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ void zzfr() {
        AppMethodBeat.i(1403);
        super.zzfr();
        AppMethodBeat.o(1403);
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ void zzfs() {
        AppMethodBeat.i(1404);
        super.zzfs();
        AppMethodBeat.o(1404);
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzdu zzft() {
        AppMethodBeat.i(1406);
        zzdu zzft = super.zzft();
        AppMethodBeat.o(1406);
        return zzft;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzhk zzfu() {
        AppMethodBeat.i(1407);
        zzhk zzfu = super.zzfu();
        AppMethodBeat.o(1407);
        return zzfu;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzfb zzfv() {
        AppMethodBeat.i(1408);
        zzfb zzfv = super.zzfv();
        AppMethodBeat.o(1408);
        return zzfv;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzeo zzfw() {
        AppMethodBeat.i(1409);
        zzeo zzfw = super.zzfw();
        AppMethodBeat.o(1409);
        return zzfw;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzii zzfx() {
        AppMethodBeat.i(1410);
        zzii zzfx = super.zzfx();
        AppMethodBeat.o(1410);
        return zzfx;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzif zzfy() {
        AppMethodBeat.i(1411);
        zzif zzfy = super.zzfy();
        AppMethodBeat.o(1411);
        return zzfy;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzfc zzfz() {
        AppMethodBeat.i(1414);
        zzfc zzfz = super.zzfz();
        AppMethodBeat.o(1414);
        return zzfz;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzfe zzga() {
        AppMethodBeat.i(1415);
        zzfe zzga = super.zzga();
        AppMethodBeat.o(1415);
        return zzga;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzka zzgb() {
        AppMethodBeat.i(1416);
        zzka zzgb = super.zzgb();
        AppMethodBeat.o(1416);
        return zzgb;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzjh zzgc() {
        AppMethodBeat.i(1417);
        zzjh zzgc = super.zzgc();
        AppMethodBeat.o(1417);
        return zzgc;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg, com.google.android.gms.internal.measurement.zzec
    public final /* bridge */ /* synthetic */ zzgg zzgd() {
        AppMethodBeat.i(1418);
        zzgg zzgd = super.zzgd();
        AppMethodBeat.o(1418);
        return zzgd;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg, com.google.android.gms.internal.measurement.zzec
    public final /* bridge */ /* synthetic */ zzfg zzge() {
        AppMethodBeat.i(1419);
        zzfg zzge = super.zzge();
        AppMethodBeat.o(1419);
        return zzge;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzfr zzgf() {
        AppMethodBeat.i(1420);
        zzfr zzgf = super.zzgf();
        AppMethodBeat.o(1420);
        return zzgf;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzef zzgg() {
        AppMethodBeat.i(1421);
        zzef zzgg = super.zzgg();
        AppMethodBeat.o(1421);
        return zzgg;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.zzhh
    public final boolean zzhf() {
        return false;
    }

    public final zzfi zzim() {
        return this.zzaio;
    }

    public final zzfi zzin() {
        return this.zzaip;
    }

    public final zzfi zzio() {
        return this.zzaiq;
    }

    public final zzfi zzip() {
        return this.zzair;
    }

    public final zzfi zziq() {
        return this.zzait;
    }

    public final zzfi zzir() {
        return this.zzaiu;
    }

    public final zzfi zzis() {
        return this.zzaiv;
    }

    public final zzfi zzit() {
        return this.zzaiw;
    }

    public final String zziv() {
        AppMethodBeat.i(1402);
        Pair<String, Long> zzfi = zzgf().zzajt.zzfi();
        if (zzfi == null || zzfi == zzfr.zzajs) {
            AppMethodBeat.o(1402);
            return null;
        }
        String valueOf = String.valueOf(zzfi.second);
        String str = (String) zzfi.first;
        String sb = new StringBuilder(String.valueOf(valueOf).length() + 1 + String.valueOf(str).length()).append(valueOf).append(":").append(str).toString();
        AppMethodBeat.o(1402);
        return sb;
    }
}
