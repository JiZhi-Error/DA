package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.MetadataValueReader;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.StringResourceValueReader;
import com.google.android.gms.common.util.VisibleForTesting;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import javax.annotation.concurrent.GuardedBy;

@KeepForSdk
@Deprecated
public final class GoogleServices {
    private static final Object sLock = new Object();
    @GuardedBy("sLock")
    private static GoogleServices zzku;
    private final String zzkv;
    private final Status zzkw;
    private final boolean zzkx;
    private final boolean zzky;

    static {
        AppMethodBeat.i(4501);
        AppMethodBeat.o(4501);
    }

    @VisibleForTesting
    @KeepForSdk
    GoogleServices(Context context) {
        boolean z = true;
        AppMethodBeat.i(4492);
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("google_app_measurement_enable", "integer", resources.getResourcePackageName(R.string.common_google_play_services_unknown_issue));
        if (identifier != 0) {
            boolean z2 = resources.getInteger(identifier) != 0;
            this.zzky = z2 ? false : z;
            z = z2;
        } else {
            this.zzky = false;
        }
        this.zzkx = z;
        String googleAppId = MetadataValueReader.getGoogleAppId(context);
        googleAppId = googleAppId == null ? new StringResourceValueReader(context).getString("google_app_id") : googleAppId;
        if (TextUtils.isEmpty(googleAppId)) {
            this.zzkw = new Status(10, "Missing google app id value from from string resources with name google_app_id.");
            this.zzkv = null;
            AppMethodBeat.o(4492);
            return;
        }
        this.zzkv = googleAppId;
        this.zzkw = Status.RESULT_SUCCESS;
        AppMethodBeat.o(4492);
    }

    @VisibleForTesting
    @KeepForSdk
    GoogleServices(String str, boolean z) {
        AppMethodBeat.i(4493);
        this.zzkv = str;
        this.zzkw = Status.RESULT_SUCCESS;
        this.zzkx = z;
        this.zzky = !z;
        AppMethodBeat.o(4493);
    }

    @KeepForSdk
    private static GoogleServices checkInitialized(String str) {
        GoogleServices googleServices;
        AppMethodBeat.i(4500);
        synchronized (sLock) {
            try {
                if (zzku == null) {
                    IllegalStateException illegalStateException = new IllegalStateException(new StringBuilder(String.valueOf(str).length() + 34).append("Initialize must be called before ").append(str).append(".").toString());
                    AppMethodBeat.o(4500);
                    throw illegalStateException;
                }
                googleServices = zzku;
            } finally {
                AppMethodBeat.o(4500);
            }
        }
        return googleServices;
    }

    @VisibleForTesting
    @KeepForSdk
    static void clearInstanceForTest() {
        synchronized (sLock) {
            zzku = null;
        }
    }

    @KeepForSdk
    public static String getGoogleAppId() {
        AppMethodBeat.i(4497);
        String str = checkInitialized("getGoogleAppId").zzkv;
        AppMethodBeat.o(4497);
        return str;
    }

    @KeepForSdk
    public static Status initialize(Context context) {
        Status status;
        AppMethodBeat.i(4496);
        Preconditions.checkNotNull(context, "Context must not be null.");
        synchronized (sLock) {
            try {
                if (zzku == null) {
                    zzku = new GoogleServices(context);
                }
                status = zzku.zzkw;
            } finally {
                AppMethodBeat.o(4496);
            }
        }
        return status;
    }

    @KeepForSdk
    public static Status initialize(Context context, String str, boolean z) {
        Status status;
        AppMethodBeat.i(4494);
        Preconditions.checkNotNull(context, "Context must not be null.");
        Preconditions.checkNotEmpty(str, "App ID must be nonempty.");
        synchronized (sLock) {
            try {
                if (zzku != null) {
                    status = zzku.checkGoogleAppId(str);
                } else {
                    GoogleServices googleServices = new GoogleServices(str, z);
                    zzku = googleServices;
                    status = googleServices.zzkw;
                    AppMethodBeat.o(4494);
                }
            } finally {
                AppMethodBeat.o(4494);
            }
        }
        return status;
    }

    @KeepForSdk
    public static boolean isMeasurementEnabled() {
        AppMethodBeat.i(4498);
        GoogleServices checkInitialized = checkInitialized("isMeasurementEnabled");
        if (!checkInitialized.zzkw.isSuccess() || !checkInitialized.zzkx) {
            AppMethodBeat.o(4498);
            return false;
        }
        AppMethodBeat.o(4498);
        return true;
    }

    @KeepForSdk
    public static boolean isMeasurementExplicitlyDisabled() {
        AppMethodBeat.i(4499);
        boolean z = checkInitialized("isMeasurementExplicitlyDisabled").zzky;
        AppMethodBeat.o(4499);
        return z;
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    @KeepForSdk
    public final Status checkGoogleAppId(String str) {
        AppMethodBeat.i(4495);
        if (this.zzkv == null || this.zzkv.equals(str)) {
            Status status = Status.RESULT_SUCCESS;
            AppMethodBeat.o(4495);
            return status;
        }
        String str2 = this.zzkv;
        Status status2 = new Status(10, new StringBuilder(String.valueOf(str2).length() + 97).append("Initialize was called with two different Google App IDs.  Only the first app ID will be used: '").append(str2).append("'.").toString());
        AppMethodBeat.o(4495);
        return status2;
    }
}
