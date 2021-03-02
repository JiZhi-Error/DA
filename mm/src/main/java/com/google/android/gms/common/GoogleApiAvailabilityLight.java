package com.google.android.gms.common;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.google.android.gms.common.internal.GmsIntents;
import com.google.android.gms.common.util.DeviceProperties;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.Wrappers;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class GoogleApiAvailabilityLight {
    public static final String GOOGLE_PLAY_SERVICES_PACKAGE = "com.google.android.gms";
    public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE = GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
    public static final String GOOGLE_PLAY_STORE_PACKAGE = "com.android.vending";
    private static final GoogleApiAvailabilityLight zzaw = new GoogleApiAvailabilityLight();

    static {
        AppMethodBeat.i(4399);
        AppMethodBeat.o(4399);
    }

    GoogleApiAvailabilityLight() {
    }

    public static GoogleApiAvailabilityLight getInstance() {
        return zzaw;
    }

    @VisibleForTesting
    private static String zza(Context context, String str) {
        AppMethodBeat.i(4398);
        StringBuilder sb = new StringBuilder();
        sb.append("gcore_");
        sb.append(GOOGLE_PLAY_SERVICES_VERSION_CODE);
        sb.append("-");
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
        }
        sb.append("-");
        if (context != null) {
            sb.append(context.getPackageName());
        }
        sb.append("-");
        if (context != null) {
            try {
                sb.append(Wrappers.packageManager(context).getPackageInfo(context.getPackageName(), 0).versionCode);
            } catch (PackageManager.NameNotFoundException e2) {
            }
        }
        String sb2 = sb.toString();
        AppMethodBeat.o(4398);
        return sb2;
    }

    public void cancelAvailabilityErrorNotifications(Context context) {
        AppMethodBeat.i(4391);
        GooglePlayServicesUtilLight.cancelAvailabilityErrorNotifications(context);
        AppMethodBeat.o(4391);
    }

    public int getApkVersion(Context context) {
        AppMethodBeat.i(4393);
        int apkVersion = GooglePlayServicesUtilLight.getApkVersion(context);
        AppMethodBeat.o(4393);
        return apkVersion;
    }

    public int getClientVersion(Context context) {
        AppMethodBeat.i(4392);
        int clientVersion = GooglePlayServicesUtilLight.getClientVersion(context);
        AppMethodBeat.o(4392);
        return clientVersion;
    }

    @Deprecated
    public Intent getErrorResolutionIntent(int i2) {
        AppMethodBeat.i(4387);
        Intent errorResolutionIntent = getErrorResolutionIntent(null, i2, null);
        AppMethodBeat.o(4387);
        return errorResolutionIntent;
    }

    public Intent getErrorResolutionIntent(Context context, int i2, String str) {
        AppMethodBeat.i(4388);
        switch (i2) {
            case 1:
            case 2:
                if (context == null || !DeviceProperties.isWearableWithoutPlayStore(context)) {
                    Intent createPlayStoreIntent = GmsIntents.createPlayStoreIntent("com.google.android.gms", zza(context, str));
                    AppMethodBeat.o(4388);
                    return createPlayStoreIntent;
                }
                Intent createAndroidWearUpdateIntent = GmsIntents.createAndroidWearUpdateIntent();
                AppMethodBeat.o(4388);
                return createAndroidWearUpdateIntent;
            case 3:
                Intent createSettingsIntent = GmsIntents.createSettingsIntent("com.google.android.gms");
                AppMethodBeat.o(4388);
                return createSettingsIntent;
            default:
                AppMethodBeat.o(4388);
                return null;
        }
    }

    public PendingIntent getErrorResolutionPendingIntent(Context context, int i2, int i3) {
        AppMethodBeat.i(4389);
        PendingIntent errorResolutionPendingIntent = getErrorResolutionPendingIntent(context, i2, i3, null);
        AppMethodBeat.o(4389);
        return errorResolutionPendingIntent;
    }

    public PendingIntent getErrorResolutionPendingIntent(Context context, int i2, int i3, String str) {
        AppMethodBeat.i(4390);
        Intent errorResolutionIntent = getErrorResolutionIntent(context, i2, str);
        if (errorResolutionIntent == null) {
            AppMethodBeat.o(4390);
            return null;
        }
        PendingIntent activity = PendingIntent.getActivity(context, i3, errorResolutionIntent, 134217728);
        AppMethodBeat.o(4390);
        return activity;
    }

    public String getErrorString(int i2) {
        AppMethodBeat.i(4397);
        String errorString = GooglePlayServicesUtilLight.getErrorString(i2);
        AppMethodBeat.o(4397);
        return errorString;
    }

    public int isGooglePlayServicesAvailable(Context context) {
        AppMethodBeat.i(4382);
        int isGooglePlayServicesAvailable = isGooglePlayServicesAvailable(context, GOOGLE_PLAY_SERVICES_VERSION_CODE);
        AppMethodBeat.o(4382);
        return isGooglePlayServicesAvailable;
    }

    public int isGooglePlayServicesAvailable(Context context, int i2) {
        AppMethodBeat.i(4383);
        int isGooglePlayServicesAvailable = GooglePlayServicesUtilLight.isGooglePlayServicesAvailable(context, i2);
        if (GooglePlayServicesUtilLight.isPlayServicesPossiblyUpdating(context, isGooglePlayServicesAvailable)) {
            isGooglePlayServicesAvailable = 18;
        }
        AppMethodBeat.o(4383);
        return isGooglePlayServicesAvailable;
    }

    public boolean isPlayServicesPossiblyUpdating(Context context, int i2) {
        AppMethodBeat.i(4394);
        boolean isPlayServicesPossiblyUpdating = GooglePlayServicesUtilLight.isPlayServicesPossiblyUpdating(context, i2);
        AppMethodBeat.o(4394);
        return isPlayServicesPossiblyUpdating;
    }

    public boolean isPlayStorePossiblyUpdating(Context context, int i2) {
        AppMethodBeat.i(4395);
        boolean isPlayStorePossiblyUpdating = GooglePlayServicesUtilLight.isPlayStorePossiblyUpdating(context, i2);
        AppMethodBeat.o(4395);
        return isPlayStorePossiblyUpdating;
    }

    public boolean isUninstalledAppPossiblyUpdating(Context context, String str) {
        AppMethodBeat.i(4396);
        boolean isUninstalledAppPossiblyUpdating = GooglePlayServicesUtilLight.isUninstalledAppPossiblyUpdating(context, str);
        AppMethodBeat.o(4396);
        return isUninstalledAppPossiblyUpdating;
    }

    public boolean isUserResolvableError(int i2) {
        AppMethodBeat.i(4386);
        boolean isUserRecoverableError = GooglePlayServicesUtilLight.isUserRecoverableError(i2);
        AppMethodBeat.o(4386);
        return isUserRecoverableError;
    }

    public void verifyGooglePlayServicesIsAvailable(Context context) {
        AppMethodBeat.i(4384);
        GooglePlayServicesUtilLight.ensurePlayServicesAvailable(context);
        AppMethodBeat.o(4384);
    }

    public void verifyGooglePlayServicesIsAvailable(Context context, int i2) {
        AppMethodBeat.i(4385);
        GooglePlayServicesUtilLight.ensurePlayServicesAvailable(context, i2);
        AppMethodBeat.o(4385);
    }
}
