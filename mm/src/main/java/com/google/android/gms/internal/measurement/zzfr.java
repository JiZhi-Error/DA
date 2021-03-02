package com.google.android.gms.internal.measurement;

import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.util.VisibleForTesting;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Locale;

/* access modifiers changed from: package-private */
public final class zzfr extends zzhh {
    @VisibleForTesting
    static final Pair<String, Long> zzajs = new Pair<>("", 0L);
    private SharedPreferences zzabf;
    public zzfv zzajt;
    public final zzfu zzaju = new zzfu(this, "last_upload", 0);
    public final zzfu zzajv = new zzfu(this, "last_upload_attempt", 0);
    public final zzfu zzajw = new zzfu(this, "backoff", 0);
    public final zzfu zzajx = new zzfu(this, "last_delete_stale", 0);
    public final zzfu zzajy = new zzfu(this, "midnight_offset", 0);
    public final zzfu zzajz = new zzfu(this, "first_open_time", 0);
    public final zzfu zzaka = new zzfu(this, "app_install_time", 0);
    public final zzfw zzakb = new zzfw(this, "app_instance_id", null);
    private String zzakc;
    private boolean zzakd;
    private long zzake;
    private String zzakf;
    private long zzakg;
    private final Object zzakh = new Object();
    public final zzfu zzaki = new zzfu(this, "time_before_start", 10000);
    public final zzfu zzakj = new zzfu(this, "session_timeout", 1800000);
    public final zzft zzakk = new zzft(this, "start_new_session", true);
    public final zzfu zzakl = new zzfu(this, "last_pause_time", 0);
    public final zzfu zzakm = new zzfu(this, "time_active", 0);
    public boolean zzakn;

    static {
        AppMethodBeat.i(1482);
        AppMethodBeat.o(1482);
    }

    zzfr(zzgl zzgl) {
        super(zzgl);
        AppMethodBeat.i(1465);
        AppMethodBeat.o(1465);
    }

    static /* synthetic */ SharedPreferences zza(zzfr zzfr) {
        AppMethodBeat.i(1481);
        SharedPreferences zziy = zzfr.zziy();
        AppMethodBeat.o(1481);
        return zziy;
    }

    private final SharedPreferences zziy() {
        AppMethodBeat.i(1467);
        zzab();
        zzch();
        SharedPreferences sharedPreferences = this.zzabf;
        AppMethodBeat.o(1467);
        return sharedPreferences;
    }

    /* access modifiers changed from: package-private */
    public final void setMeasurementEnabled(boolean z) {
        AppMethodBeat.i(1475);
        zzab();
        zzge().zzit().zzg("Setting measurementEnabled", Boolean.valueOf(z));
        SharedPreferences.Editor edit = zziy().edit();
        edit.putBoolean("measurement_enabled", z);
        edit.apply();
        AppMethodBeat.o(1475);
    }

    /* access modifiers changed from: package-private */
    public final Pair<String, Boolean> zzbo(String str) {
        AppMethodBeat.i(1463);
        zzab();
        long elapsedRealtime = zzbt().elapsedRealtime();
        if (this.zzakc == null || elapsedRealtime >= this.zzake) {
            this.zzake = elapsedRealtime + zzgg().zza(str, zzew.zzagj);
            AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(true);
            try {
                AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(getContext());
                if (advertisingIdInfo != null) {
                    this.zzakc = advertisingIdInfo.getId();
                    this.zzakd = advertisingIdInfo.isLimitAdTrackingEnabled();
                }
                if (this.zzakc == null) {
                    this.zzakc = "";
                }
            } catch (Exception e2) {
                zzge().zzis().zzg("Unable to get advertising id", e2);
                this.zzakc = "";
            }
            AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(false);
            Pair<String, Boolean> pair = new Pair<>(this.zzakc, Boolean.valueOf(this.zzakd));
            AppMethodBeat.o(1463);
            return pair;
        }
        Pair<String, Boolean> pair2 = new Pair<>(this.zzakc, Boolean.valueOf(this.zzakd));
        AppMethodBeat.o(1463);
        return pair2;
    }

    /* access modifiers changed from: package-private */
    public final String zzbp(String str) {
        AppMethodBeat.i(1464);
        zzab();
        String str2 = (String) zzbo(str).first;
        MessageDigest messageDigest = zzka.getMessageDigest("MD5");
        if (messageDigest == null) {
            AppMethodBeat.o(1464);
            return null;
        }
        String format = String.format(Locale.US, "%032X", new BigInteger(1, messageDigest.digest(str2.getBytes())));
        AppMethodBeat.o(1464);
        return format;
    }

    /* access modifiers changed from: package-private */
    public final void zzbq(String str) {
        AppMethodBeat.i(1468);
        zzab();
        SharedPreferences.Editor edit = zziy().edit();
        edit.putString("gmp_app_id", str);
        edit.apply();
        AppMethodBeat.o(1468);
    }

    /* access modifiers changed from: package-private */
    public final void zzbr(String str) {
        AppMethodBeat.i(1470);
        synchronized (this.zzakh) {
            try {
                this.zzakf = str;
                this.zzakg = zzbt().elapsedRealtime();
            } finally {
                AppMethodBeat.o(1470);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzf(boolean z) {
        AppMethodBeat.i(1473);
        zzab();
        zzge().zzit().zzg("Setting useService", Boolean.valueOf(z));
        SharedPreferences.Editor edit = zziy().edit();
        edit.putBoolean("use_service", z);
        edit.apply();
        AppMethodBeat.o(1473);
    }

    /* access modifiers changed from: package-private */
    public final boolean zzg(boolean z) {
        AppMethodBeat.i(1476);
        zzab();
        boolean z2 = zziy().getBoolean("measurement_enabled", z);
        AppMethodBeat.o(1476);
        return z2;
    }

    /* access modifiers changed from: package-private */
    public final void zzh(boolean z) {
        AppMethodBeat.i(1478);
        zzab();
        zzge().zzit().zzg("Updating deferred analytics collection", Boolean.valueOf(z));
        SharedPreferences.Editor edit = zziy().edit();
        edit.putBoolean("deferred_analytics_collection", z);
        edit.apply();
        AppMethodBeat.o(1478);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.zzhh
    public final boolean zzhf() {
        return true;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.zzhh
    public final void zzih() {
        AppMethodBeat.i(1466);
        this.zzabf = getContext().getSharedPreferences("com.google.android.gms.measurement.prefs", 0);
        this.zzakn = this.zzabf.getBoolean("has_been_opened", false);
        if (!this.zzakn) {
            SharedPreferences.Editor edit = this.zzabf.edit();
            edit.putBoolean("has_been_opened", true);
            edit.apply();
        }
        this.zzajt = new zzfv(this, "health_monitor", Math.max(0L, zzew.zzagk.get().longValue()));
        AppMethodBeat.o(1466);
    }

    /* access modifiers changed from: package-private */
    public final String zziz() {
        AppMethodBeat.i(1469);
        zzab();
        String string = zziy().getString("gmp_app_id", null);
        AppMethodBeat.o(1469);
        return string;
    }

    /* access modifiers changed from: package-private */
    public final String zzja() {
        String str;
        AppMethodBeat.i(1471);
        synchronized (this.zzakh) {
            try {
                if (Math.abs(zzbt().elapsedRealtime() - this.zzakg) < 1000) {
                    str = this.zzakf;
                } else {
                    str = null;
                    AppMethodBeat.o(1471);
                }
            } finally {
                AppMethodBeat.o(1471);
            }
        }
        return str;
    }

    /* access modifiers changed from: package-private */
    public final Boolean zzjb() {
        AppMethodBeat.i(1472);
        zzab();
        if (!zziy().contains("use_service")) {
            AppMethodBeat.o(1472);
            return null;
        }
        Boolean valueOf = Boolean.valueOf(zziy().getBoolean("use_service", false));
        AppMethodBeat.o(1472);
        return valueOf;
    }

    /* access modifiers changed from: package-private */
    public final void zzjc() {
        boolean z = true;
        AppMethodBeat.i(1474);
        zzab();
        zzge().zzit().log("Clearing collection preferences.");
        boolean contains = zziy().contains("measurement_enabled");
        if (contains) {
            z = zzg(true);
        }
        SharedPreferences.Editor edit = zziy().edit();
        edit.clear();
        edit.apply();
        if (contains) {
            setMeasurementEnabled(z);
        }
        AppMethodBeat.o(1474);
    }

    /* access modifiers changed from: protected */
    public final String zzjd() {
        AppMethodBeat.i(1477);
        zzab();
        String string = zziy().getString("previous_os_version", null);
        zzfw().zzch();
        String str = Build.VERSION.RELEASE;
        if (!TextUtils.isEmpty(str) && !str.equals(string)) {
            SharedPreferences.Editor edit = zziy().edit();
            edit.putString("previous_os_version", str);
            edit.apply();
        }
        AppMethodBeat.o(1477);
        return string;
    }

    /* access modifiers changed from: package-private */
    public final boolean zzje() {
        AppMethodBeat.i(1479);
        zzab();
        boolean z = zziy().getBoolean("deferred_analytics_collection", false);
        AppMethodBeat.o(1479);
        return z;
    }

    /* access modifiers changed from: package-private */
    public final boolean zzjf() {
        AppMethodBeat.i(1480);
        boolean contains = this.zzabf.contains("deferred_analytics_collection");
        AppMethodBeat.o(1480);
        return contains;
    }
}
