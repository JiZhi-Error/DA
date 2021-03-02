package com.google.android.gms.internal.measurement;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.common.api.internal.GoogleServices;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicReference;

public class zzgl extends zzjr implements zzhi {
    private static volatile zzgl zzame;
    private final long zzaem;
    private final zzef zzamf;
    private final zzfr zzamg;
    private final zzfg zzamh;
    private final zzgg zzami;
    private final zzjh zzamj;
    private final AppMeasurement zzamk;
    private final FirebaseAnalytics zzaml;
    private final zzka zzamm;
    private final zzfe zzamn;
    private final zzif zzamo;
    private final zzhk zzamp;
    private final zzdu zzamq;
    private zzfc zzamr;
    private zzii zzams;
    private zzeo zzamt;
    private zzfb zzamu;
    private zzfx zzamv;
    private Boolean zzamw;
    private long zzamx;
    private int zzamy;
    private int zzamz;
    private final Context zzqx;
    private final Clock zzro;
    private boolean zzvo = false;

    private zzgl(zzhj zzhj) {
        AppMethodBeat.i(1586);
        Preconditions.checkNotNull(zzhj);
        zza(this);
        this.zzqx = zzhj.zzqx;
        zzws.init(this.zzqx);
        this.zzaqs = -1;
        this.zzro = DefaultClock.getInstance();
        this.zzaem = this.zzro.currentTimeMillis();
        this.zzamf = new zzef(this);
        zzfr zzfr = new zzfr(this);
        zzfr.zzm();
        this.zzamg = zzfr;
        zzfg zzfg = new zzfg(this);
        zzfg.zzm();
        this.zzamh = zzfg;
        zzka zzka = new zzka(this);
        zzka.zzm();
        this.zzamm = zzka;
        zzfe zzfe = new zzfe(this);
        zzfe.zzm();
        this.zzamn = zzfe;
        this.zzamq = new zzdu(this);
        zzif zzif = new zzif(this);
        zzif.zzm();
        this.zzamo = zzif;
        zzhk zzhk = new zzhk(this);
        zzhk.zzm();
        this.zzamp = zzhk;
        this.zzamk = new AppMeasurement(this);
        this.zzaml = new FirebaseAnalytics(this);
        zzjh zzjh = new zzjh(this);
        zzjh.zzm();
        this.zzamj = zzjh;
        zzgg zzgg = new zzgg(this);
        zzgg.zzm();
        this.zzami = zzgg;
        if (this.zzqx.getApplicationContext() instanceof Application) {
            zzhk zzfu = zzfu();
            if (zzfu.getContext().getApplicationContext() instanceof Application) {
                Application application = (Application) zzfu.getContext().getApplicationContext();
                if (zzfu.zzanp == null) {
                    zzfu.zzanp = new zzid(zzfu, null);
                }
                application.unregisterActivityLifecycleCallbacks(zzfu.zzanp);
                application.registerActivityLifecycleCallbacks(zzfu.zzanp);
                zzfu.zzge().zzit().log("Registered activity lifecycle callback");
            }
        } else {
            zzge().zzip().log("Application context is not an Application");
        }
        zzfk zzfk = new zzfk(this);
        zzfk.zzm();
        this.zzaqb = zzfk;
        zzgf zzgf = new zzgf(this);
        zzgf.zzm();
        this.zzaqa = zzgf;
        this.zzami.zzc(new zzgm(this, zzhj));
        AppMethodBeat.o(1586);
    }

    private static void zza(zzhg zzhg) {
        AppMethodBeat.i(1607);
        if (zzhg == null) {
            IllegalStateException illegalStateException = new IllegalStateException("Component not created");
            AppMethodBeat.o(1607);
            throw illegalStateException;
        }
        AppMethodBeat.o(1607);
    }

    private static void zza(zzhh zzhh) {
        AppMethodBeat.i(1606);
        if (zzhh == null) {
            IllegalStateException illegalStateException = new IllegalStateException("Component not created");
            AppMethodBeat.o(1606);
            throw illegalStateException;
        } else if (!zzhh.isInitialized()) {
            String valueOf = String.valueOf(zzhh.getClass());
            IllegalStateException illegalStateException2 = new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 27).append("Component not initialized: ").append(valueOf).toString());
            AppMethodBeat.o(1606);
            throw illegalStateException2;
        } else {
            AppMethodBeat.o(1606);
        }
    }

    private final void zzch() {
        AppMethodBeat.i(1605);
        if (!this.zzvo) {
            IllegalStateException illegalStateException = new IllegalStateException("AppMeasurement is not initialized");
            AppMethodBeat.o(1605);
            throw illegalStateException;
        }
        AppMethodBeat.o(1605);
    }

    static void zzfr() {
        AppMethodBeat.i(1610);
        IllegalStateException illegalStateException = new IllegalStateException("Unexpected call on client side");
        AppMethodBeat.o(1610);
        throw illegalStateException;
    }

    public static zzgl zzg(Context context) {
        AppMethodBeat.i(1604);
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(context.getApplicationContext());
        if (zzame == null) {
            synchronized (zzgl.class) {
                try {
                    if (zzame == null) {
                        zzame = new zzgl(new zzhj(context));
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(1604);
                    throw th;
                }
            }
        }
        zzgl zzgl = zzame;
        AppMethodBeat.o(1604);
        return zzgl;
    }

    @Override // com.google.android.gms.internal.measurement.zzec, com.google.android.gms.internal.measurement.zzjr
    public final Context getContext() {
        return this.zzqx;
    }

    public final boolean isEnabled() {
        boolean z = false;
        AppMethodBeat.i(1608);
        zzab();
        zzch();
        if (zzgg().zzhg()) {
            AppMethodBeat.o(1608);
            return false;
        }
        Boolean zzas = zzgg().zzas("firebase_analytics_collection_enabled");
        if (zzas != null) {
            z = zzas.booleanValue();
        } else if (!GoogleServices.isMeasurementExplicitlyDisabled()) {
            z = true;
        }
        boolean zzg = zzgf().zzg(z);
        AppMethodBeat.o(1608);
        return zzg;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.zzjr
    public final void start() {
        boolean z = false;
        AppMethodBeat.i(1588);
        zzab();
        if (zzgf().zzaju.get() == 0) {
            zzgf().zzaju.set(zzbt().currentTimeMillis());
        }
        if (zzgf().zzajz.get() == 0) {
            zzge().zzit().zzg("Persisting first open", Long.valueOf(this.zzaem));
            zzgf().zzajz.set(this.zzaem);
        }
        if (zzjv()) {
            if (!TextUtils.isEmpty(zzfv().getGmpAppId())) {
                String zziz = zzgf().zziz();
                if (zziz == null) {
                    zzgf().zzbq(zzfv().getGmpAppId());
                } else if (!zziz.equals(zzfv().getGmpAppId())) {
                    zzge().zzir().log("Rechecking which service to use due to a GMP App Id change");
                    zzgf().zzjc();
                    this.zzams.disconnect();
                    this.zzams.zzdf();
                    zzgf().zzbq(zzfv().getGmpAppId());
                    zzgf().zzajz.set(this.zzaem);
                    zzgf().zzakb.zzbs(null);
                }
            }
            zzfu().zzbr(zzgf().zzakb.zzjg());
            if (!TextUtils.isEmpty(zzfv().getGmpAppId())) {
                boolean isEnabled = isEnabled();
                if (!zzgf().zzjf() && !zzgg().zzhg()) {
                    zzfr zzgf = zzgf();
                    if (!isEnabled) {
                        z = true;
                    }
                    zzgf.zzh(z);
                }
                if (!zzgg().zzaz(zzfv().zzah()) || isEnabled) {
                    zzfu().zzkb();
                }
                zzfx().zza(new AtomicReference<>());
            }
        } else if (isEnabled()) {
            if (!zzgb().zzx("android.permission.INTERNET")) {
                zzge().zzim().log("App is missing INTERNET permission");
            }
            if (!zzgb().zzx("android.permission.ACCESS_NETWORK_STATE")) {
                zzge().zzim().log("App is missing ACCESS_NETWORK_STATE permission");
            }
            if (!Wrappers.packageManager(getContext()).isCallerInstantApp()) {
                if (!zzgb.zza(getContext())) {
                    zzge().zzim().log("AppMeasurementReceiver not registered/enabled");
                }
                if (!zzjc.zza(getContext(), false)) {
                    zzge().zzim().log("AppMeasurementService not registered/enabled");
                }
            }
            zzge().zzim().log("Uploading is not possible. App measurement disabled");
        }
        super.start();
        AppMethodBeat.o(1588);
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzhj zzhj) {
        zzfi zzir;
        String concat;
        AppMethodBeat.i(1587);
        zzab();
        zzeo zzeo = new zzeo(this);
        zzeo.zzm();
        this.zzamt = zzeo;
        zzfb zzfb = new zzfb(this);
        zzfb.zzm();
        this.zzamu = zzfb;
        zzfc zzfc = new zzfc(this);
        zzfc.zzm();
        this.zzamr = zzfc;
        zzii zzii = new zzii(this);
        zzii.zzm();
        this.zzams = zzii;
        this.zzamm.zzjw();
        this.zzamg.zzjw();
        this.zzamv = new zzfx(this);
        this.zzamu.zzjw();
        zzge().zzir().zzg("App measurement is starting up, version", 12451L);
        zzge().zzir().log("To enable debug logging run: adb shell setprop log.tag.FA VERBOSE");
        String zzah = zzfb.zzah();
        if (zzgb().zzcj(zzah)) {
            zzir = zzge().zzir();
            concat = "Faster debug mode event logging enabled. To disable, run:\n  adb shell setprop debug.firebase.analytics.app .none.";
        } else {
            zzir = zzge().zzir();
            String valueOf = String.valueOf(zzah);
            concat = valueOf.length() != 0 ? "To enable faster debug mode event logging run:\n  adb shell setprop debug.firebase.analytics.app ".concat(valueOf) : new String("To enable faster debug mode event logging run:\n  adb shell setprop debug.firebase.analytics.app ");
        }
        zzir.log(concat);
        zzge().zzis().log("Debug-level message logging enabled");
        if (this.zzamy != this.zzamz) {
            zzge().zzim().zze("Not all components initialized", Integer.valueOf(this.zzamy), Integer.valueOf(this.zzamz));
        }
        super.zza((zzjw) zzhj);
        this.zzvo = true;
        AppMethodBeat.o(1587);
    }

    @Override // com.google.android.gms.internal.measurement.zzjr
    public final void zzab() {
        AppMethodBeat.i(1603);
        zzgd().zzab();
        AppMethodBeat.o(1603);
    }

    /* access modifiers changed from: package-private */
    public final void zzb(zzhh zzhh) {
        this.zzamy++;
    }

    @Override // com.google.android.gms.internal.measurement.zzec, com.google.android.gms.internal.measurement.zzjr
    public final Clock zzbt() {
        return this.zzro;
    }

    public final zzdu zzft() {
        AppMethodBeat.i(1602);
        zza(this.zzamq);
        zzdu zzdu = this.zzamq;
        AppMethodBeat.o(1602);
        return zzdu;
    }

    public final zzhk zzfu() {
        AppMethodBeat.i(1594);
        zza((zzhh) this.zzamp);
        zzhk zzhk = this.zzamp;
        AppMethodBeat.o(1594);
        return zzhk;
    }

    public final zzfb zzfv() {
        AppMethodBeat.i(1601);
        zza((zzhh) this.zzamu);
        zzfb zzfb = this.zzamu;
        AppMethodBeat.o(1601);
        return zzfb;
    }

    @Override // com.google.android.gms.internal.measurement.zzjr
    public final zzeo zzfw() {
        AppMethodBeat.i(1600);
        zza((zzhh) this.zzamt);
        zzeo zzeo = this.zzamt;
        AppMethodBeat.o(1600);
        return zzeo;
    }

    public final zzii zzfx() {
        AppMethodBeat.i(1599);
        zza((zzhh) this.zzams);
        zzii zzii = this.zzams;
        AppMethodBeat.o(1599);
        return zzii;
    }

    public final zzif zzfy() {
        AppMethodBeat.i(1598);
        zza((zzhh) this.zzamo);
        zzif zzif = this.zzamo;
        AppMethodBeat.o(1598);
        return zzif;
    }

    public final zzfc zzfz() {
        AppMethodBeat.i(1597);
        zza((zzhh) this.zzamr);
        zzfc zzfc = this.zzamr;
        AppMethodBeat.o(1597);
        return zzfc;
    }

    @Override // com.google.android.gms.internal.measurement.zzjr
    public final zzfe zzga() {
        AppMethodBeat.i(1596);
        zza((zzhg) this.zzamn);
        zzfe zzfe = this.zzamn;
        AppMethodBeat.o(1596);
        return zzfe;
    }

    @Override // com.google.android.gms.internal.measurement.zzjr
    public final zzka zzgb() {
        AppMethodBeat.i(1595);
        zza((zzhg) this.zzamm);
        zzka zzka = this.zzamm;
        AppMethodBeat.o(1595);
        return zzka;
    }

    public final zzjh zzgc() {
        AppMethodBeat.i(1593);
        zza((zzhh) this.zzamj);
        zzjh zzjh = this.zzamj;
        AppMethodBeat.o(1593);
        return zzjh;
    }

    @Override // com.google.android.gms.internal.measurement.zzec, com.google.android.gms.internal.measurement.zzjr
    public final zzgg zzgd() {
        AppMethodBeat.i(1592);
        zza((zzhh) this.zzami);
        zzgg zzgg = this.zzami;
        AppMethodBeat.o(1592);
        return zzgg;
    }

    @Override // com.google.android.gms.internal.measurement.zzec, com.google.android.gms.internal.measurement.zzjr
    public final zzfg zzge() {
        AppMethodBeat.i(1590);
        zza((zzhh) this.zzamh);
        zzfg zzfg = this.zzamh;
        AppMethodBeat.o(1590);
        return zzfg;
    }

    @Override // com.google.android.gms.internal.measurement.zzjr
    public final zzfr zzgf() {
        AppMethodBeat.i(1589);
        zza((zzhg) this.zzamg);
        zzfr zzfr = this.zzamg;
        AppMethodBeat.o(1589);
        return zzfr;
    }

    @Override // com.google.android.gms.internal.measurement.zzjr
    public final zzef zzgg() {
        return this.zzamf;
    }

    public final zzfg zzjo() {
        AppMethodBeat.i(1591);
        if (this.zzamh == null || !this.zzamh.isInitialized()) {
            AppMethodBeat.o(1591);
            return null;
        }
        zzfg zzfg = this.zzamh;
        AppMethodBeat.o(1591);
        return zzfg;
    }

    public final zzfx zzjp() {
        return this.zzamv;
    }

    /* access modifiers changed from: package-private */
    public final zzgg zzjq() {
        return this.zzami;
    }

    public final AppMeasurement zzjr() {
        return this.zzamk;
    }

    public final FirebaseAnalytics zzjs() {
        return this.zzaml;
    }

    /* access modifiers changed from: package-private */
    public final long zzjt() {
        AppMethodBeat.i(1609);
        Long valueOf = Long.valueOf(zzgf().zzajz.get());
        if (valueOf.longValue() == 0) {
            long j2 = this.zzaem;
            AppMethodBeat.o(1609);
            return j2;
        }
        long min = Math.min(this.zzaem, valueOf.longValue());
        AppMethodBeat.o(1609);
        return min;
    }

    /* access modifiers changed from: package-private */
    public final void zzju() {
        this.zzamz++;
    }

    /* access modifiers changed from: protected */
    public final boolean zzjv() {
        boolean z = false;
        AppMethodBeat.i(1611);
        zzch();
        zzab();
        if (this.zzamw == null || this.zzamx == 0 || (this.zzamw != null && !this.zzamw.booleanValue() && Math.abs(zzbt().elapsedRealtime() - this.zzamx) > 1000)) {
            this.zzamx = zzbt().elapsedRealtime();
            if (zzgb().zzx("android.permission.INTERNET") && zzgb().zzx("android.permission.ACCESS_NETWORK_STATE") && (Wrappers.packageManager(getContext()).isCallerInstantApp() || (zzgb.zza(getContext()) && zzjc.zza(getContext(), false)))) {
                z = true;
            }
            this.zzamw = Boolean.valueOf(z);
            if (this.zzamw.booleanValue()) {
                this.zzamw = Boolean.valueOf(zzgb().zzcg(zzfv().getGmpAppId()));
            }
        }
        boolean booleanValue = this.zzamw.booleanValue();
        AppMethodBeat.o(1611);
        return booleanValue;
    }
}
