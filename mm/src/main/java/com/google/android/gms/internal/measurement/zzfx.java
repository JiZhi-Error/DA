package com.google.android.gms.internal.measurement;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.PackageManagerWrapper;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public final class zzfx {
    private final zzgl zzacw;
    @VisibleForTesting
    volatile zzr zzakw;
    @VisibleForTesting
    private ServiceConnection zzakx;

    zzfx(zzgl zzgl) {
        this.zzacw = zzgl;
    }

    @VisibleForTesting
    private final boolean zzji() {
        AppMethodBeat.i(1498);
        try {
            PackageManagerWrapper packageManager = Wrappers.packageManager(this.zzacw.getContext());
            if (packageManager == null) {
                this.zzacw.zzge().zzir().log("Failed to retrieve Package Manager to check Play Store compatibility");
                AppMethodBeat.o(1498);
                return false;
            } else if (packageManager.getPackageInfo("com.android.vending", 128).versionCode >= 80837300) {
                AppMethodBeat.o(1498);
                return true;
            } else {
                AppMethodBeat.o(1498);
                return false;
            }
        } catch (Exception e2) {
            this.zzacw.zzge().zzir().zzg("Failed to retrieve Play Store version", e2);
            AppMethodBeat.o(1498);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public final void zzc(Bundle bundle) {
        AppMethodBeat.i(1500);
        this.zzacw.zzab();
        if (bundle == null) {
            AppMethodBeat.o(1500);
            return;
        }
        long j2 = bundle.getLong("install_begin_timestamp_seconds", 0) * 1000;
        if (j2 == 0) {
            this.zzacw.zzge().zzim().log("Service response is missing Install Referrer install timestamp");
            AppMethodBeat.o(1500);
            return;
        }
        String string = bundle.getString("install_referrer");
        if (string == null || string.isEmpty()) {
            this.zzacw.zzge().zzim().log("No referrer defined in install referrer response");
            AppMethodBeat.o(1500);
            return;
        }
        this.zzacw.zzge().zzit().zzg("InstallReferrer API result", string);
        zzka zzgb = this.zzacw.zzgb();
        String valueOf = String.valueOf(string);
        Bundle zza = zzgb.zza(Uri.parse(valueOf.length() != 0 ? "?".concat(valueOf) : new String("?")));
        if (zza == null) {
            this.zzacw.zzge().zzim().log("No campaign params defined in install referrer result");
            AppMethodBeat.o(1500);
            return;
        }
        String string2 = zza.getString(FirebaseAnalytics.b.MEDIUM);
        if (string2 != null && !"(not set)".equalsIgnoreCase(string2) && !"organic".equalsIgnoreCase(string2)) {
            long j3 = bundle.getLong("referrer_click_timestamp_seconds", 0) * 1000;
            if (j3 == 0) {
                this.zzacw.zzge().zzim().log("Install Referrer is missing click timestamp for ad campaign");
                AppMethodBeat.o(1500);
                return;
            }
            zza.putLong("click_timestamp", j3);
        }
        if (j2 == this.zzacw.zzgf().zzaka.get()) {
            this.zzacw.zzge().zzit().log("Campaign has already been logged");
            AppMethodBeat.o(1500);
            return;
        }
        zza.putString("_cis", "referrer API");
        this.zzacw.zzgf().zzaka.set(j2);
        this.zzacw.zzfu().logEvent("auto", "_cmp", zza);
        if (this.zzakx != null) {
            ConnectionTracker.getInstance().unbindService(this.zzacw.getContext(), this.zzakx);
        }
        AppMethodBeat.o(1500);
    }

    /* access modifiers changed from: protected */
    public final void zzjh() {
        AppMethodBeat.i(1497);
        this.zzacw.zzab();
        if (!zzji()) {
            this.zzacw.zzge().zzir().log("Install Referrer Reporter is not available");
            this.zzakx = null;
            AppMethodBeat.o(1497);
            return;
        }
        this.zzakx = new zzfz(this);
        this.zzacw.zzge().zzir().log("Install Referrer Reporter is initializing");
        this.zzacw.zzab();
        Intent intent = new Intent("com.google.android.finsky.BIND_GET_INSTALL_REFERRER_SERVICE");
        intent.setComponent(new ComponentName("com.android.vending", "com.google.android.finsky.externalreferrer.GetInstallReferrerService"));
        PackageManager packageManager = this.zzacw.getContext().getPackageManager();
        if (packageManager == null) {
            this.zzacw.zzge().zzip().log("Failed to obtain Package Manager to verify binding conditions");
            AppMethodBeat.o(1497);
            return;
        }
        List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, 0);
        if (queryIntentServices == null || queryIntentServices.isEmpty()) {
            this.zzacw.zzge().zzir().log("Play Service for fetching Install Referrer is unavailable on device");
            AppMethodBeat.o(1497);
            return;
        }
        ResolveInfo resolveInfo = queryIntentServices.get(0);
        if (resolveInfo.serviceInfo != null) {
            String str = resolveInfo.serviceInfo.packageName;
            if (resolveInfo.serviceInfo.name == null || this.zzakx == null || !"com.android.vending".equals(str) || !zzji()) {
                this.zzacw.zzge().zzir().log("Play Store missing or incompatible. Version 8.3.73 or later required");
            } else {
                try {
                    this.zzacw.zzge().zzir().zzg("Install Referrer Service is", ConnectionTracker.getInstance().bindService(this.zzacw.getContext(), new Intent(intent), this.zzakx, 1) ? "available" : "not available");
                    AppMethodBeat.o(1497);
                    return;
                } catch (Exception e2) {
                    this.zzacw.zzge().zzim().zzg("Exception occurred while binding to Install Referrer Service", e2.getMessage());
                    AppMethodBeat.o(1497);
                    return;
                }
            }
        }
        AppMethodBeat.o(1497);
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public final Bundle zzjj() {
        AppMethodBeat.i(1499);
        this.zzacw.zzab();
        if (this.zzakw == null) {
            this.zzacw.zzge().zzip().log("Attempting to use Install Referrer Service while it is not initialized");
            AppMethodBeat.o(1499);
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putString("package_name", this.zzacw.getContext().getPackageName());
        try {
            Bundle zza = this.zzakw.zza(bundle);
            if (zza == null) {
                this.zzacw.zzge().zzim().log("Install Referrer Service returned a null response");
                AppMethodBeat.o(1499);
                return null;
            }
            AppMethodBeat.o(1499);
            return zza;
        } catch (Exception e2) {
            this.zzacw.zzge().zzim().zzg("Exception occurred while retrieving the Install Referrer", e2.getMessage());
            AppMethodBeat.o(1499);
            return null;
        }
    }
}
