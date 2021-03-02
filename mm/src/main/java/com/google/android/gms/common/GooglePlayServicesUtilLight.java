package com.google.android.gms.common;

import android.annotation.TargetApi;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageInstaller;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.UserManager;
import android.util.Log;
import com.facebook.internal.ServerProtocol;
import com.google.android.gms.common.internal.MetadataValueReader;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.ClientLibraryUtils;
import com.google.android.gms.common.util.DeviceProperties;
import com.google.android.gms.common.util.GmsVersionParser;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.util.UidVerifier;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.Wrappers;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import java.io.InputStream;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

public class GooglePlayServicesUtilLight {
    public static final String FEATURE_SIDEWINDER = "cn.google";
    public static final String GOOGLE_PLAY_GAMES_PACKAGE = "com.google.android.play.games";
    @Deprecated
    public static final String GOOGLE_PLAY_SERVICES_PACKAGE = "com.google.android.gms";
    @Deprecated
    public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE = 12451000;
    public static final String GOOGLE_PLAY_STORE_GAMES_URI_STRING = "http://play.google.com/store/apps/category/GAME";
    public static final String GOOGLE_PLAY_STORE_PACKAGE = "com.android.vending";
    public static final String GOOGLE_PLAY_STORE_URI_STRING = "http://play.google.com/store/apps/";
    public static final boolean HONOR_DEBUG_CERTIFICATES = false;
    public static final String KEY_METADATA_GOOGLE_PLAY_SERVICES_VERSION = "com.google.android.gms.version";
    public static final int MAX_ATTEMPTS_NO_SUCH_ALGORITHM = 2;
    @VisibleForTesting
    public static boolean sIsTestMode = false;
    @VisibleForTesting
    public static boolean sTestIsUserBuild = false;
    private static boolean zzbr = false;
    @VisibleForTesting
    private static boolean zzbs = false;
    @VisibleForTesting
    static final AtomicBoolean zzbt = new AtomicBoolean();
    private static final AtomicBoolean zzbu = new AtomicBoolean();

    static {
        AppMethodBeat.i(4440);
        AppMethodBeat.o(4440);
    }

    GooglePlayServicesUtilLight() {
    }

    @Deprecated
    public static void cancelAvailabilityErrorNotifications(Context context) {
        AppMethodBeat.i(4429);
        if (zzbt.getAndSet(true)) {
            AppMethodBeat.o(4429);
            return;
        }
        try {
            NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
            if (notificationManager != null) {
                notificationManager.cancel(10436);
            }
            AppMethodBeat.o(4429);
        } catch (SecurityException e2) {
            AppMethodBeat.o(4429);
        }
    }

    public static void enableUsingApkIndependentContext() {
        AppMethodBeat.i(4415);
        zzbu.set(true);
        AppMethodBeat.o(4415);
    }

    @Deprecated
    public static void ensurePlayServicesAvailable(Context context) {
        AppMethodBeat.i(4420);
        ensurePlayServicesAvailable(context, GOOGLE_PLAY_SERVICES_VERSION_CODE);
        AppMethodBeat.o(4420);
    }

    @Deprecated
    public static void ensurePlayServicesAvailable(Context context, int i2) {
        AppMethodBeat.i(4421);
        int isGooglePlayServicesAvailable = GoogleApiAvailabilityLight.getInstance().isGooglePlayServicesAvailable(context, i2);
        if (isGooglePlayServicesAvailable != 0) {
            Intent errorResolutionIntent = GoogleApiAvailabilityLight.getInstance().getErrorResolutionIntent(context, isGooglePlayServicesAvailable, "e");
            new StringBuilder(57).append("GooglePlayServices not available due to error ").append(isGooglePlayServicesAvailable);
            if (errorResolutionIntent == null) {
                GooglePlayServicesNotAvailableException googlePlayServicesNotAvailableException = new GooglePlayServicesNotAvailableException(isGooglePlayServicesAvailable);
                AppMethodBeat.o(4421);
                throw googlePlayServicesNotAvailableException;
            }
            GooglePlayServicesRepairableException googlePlayServicesRepairableException = new GooglePlayServicesRepairableException(isGooglePlayServicesAvailable, "Google Play Services not available", errorResolutionIntent);
            AppMethodBeat.o(4421);
            throw googlePlayServicesRepairableException;
        }
        AppMethodBeat.o(4421);
    }

    @Deprecated
    public static int getApkVersion(Context context) {
        AppMethodBeat.i(4434);
        try {
            int i2 = context.getPackageManager().getPackageInfo("com.google.android.gms", 0).versionCode;
            AppMethodBeat.o(4434);
            return i2;
        } catch (PackageManager.NameNotFoundException e2) {
            AppMethodBeat.o(4434);
            return 0;
        }
    }

    @Deprecated
    public static int getClientVersion(Context context) {
        AppMethodBeat.i(4433);
        Preconditions.checkState(true);
        int clientVersion = ClientLibraryUtils.getClientVersion(context, context.getPackageName());
        AppMethodBeat.o(4433);
        return clientVersion;
    }

    @Deprecated
    public static PendingIntent getErrorPendingIntent(int i2, Context context, int i3) {
        AppMethodBeat.i(4428);
        PendingIntent errorResolutionPendingIntent = GoogleApiAvailabilityLight.getInstance().getErrorResolutionPendingIntent(context, i2, i3);
        AppMethodBeat.o(4428);
        return errorResolutionPendingIntent;
    }

    @VisibleForTesting
    @Deprecated
    public static String getErrorString(int i2) {
        AppMethodBeat.i(4416);
        String zza = ConnectionResult.zza(i2);
        AppMethodBeat.o(4416);
        return zza;
    }

    @Deprecated
    public static Intent getGooglePlayServicesAvailabilityRecoveryIntent(int i2) {
        AppMethodBeat.i(4424);
        Intent errorResolutionIntent = GoogleApiAvailabilityLight.getInstance().getErrorResolutionIntent(null, i2, null);
        AppMethodBeat.o(4424);
        return errorResolutionIntent;
    }

    @Deprecated
    public static String getOpenSourceSoftwareLicenseInfo(Context context) {
        AppMethodBeat.i(4430);
        try {
            InputStream openInputStream = context.getContentResolver().openInputStream(new Uri.Builder().scheme("android.resource").authority("com.google.android.gms").appendPath(ShareConstants.DEXMODE_RAW).appendPath("oss_notice").build());
            try {
                String next = new Scanner(openInputStream).useDelimiter("\\A").next();
                if (openInputStream != null) {
                    openInputStream.close();
                }
                AppMethodBeat.o(4430);
                return next;
            } catch (NoSuchElementException e2) {
                if (openInputStream != null) {
                    openInputStream.close();
                }
                AppMethodBeat.o(4430);
                return null;
            } catch (Throwable th) {
                if (openInputStream != null) {
                    openInputStream.close();
                }
                AppMethodBeat.o(4430);
                throw th;
            }
        } catch (Exception e3) {
            AppMethodBeat.o(4430);
            return null;
        }
    }

    public static Context getRemoteContext(Context context) {
        AppMethodBeat.i(4432);
        try {
            Context createPackageContext = context.createPackageContext("com.google.android.gms", 3);
            AppMethodBeat.o(4432);
            return createPackageContext;
        } catch (PackageManager.NameNotFoundException e2) {
            AppMethodBeat.o(4432);
            return null;
        }
    }

    public static Resources getRemoteResource(Context context) {
        AppMethodBeat.i(4431);
        try {
            Resources resourcesForApplication = context.getPackageManager().getResourcesForApplication("com.google.android.gms");
            AppMethodBeat.o(4431);
            return resourcesForApplication;
        } catch (PackageManager.NameNotFoundException e2) {
            AppMethodBeat.o(4431);
            return null;
        }
    }

    public static boolean honorsDebugCertificates(Context context) {
        AppMethodBeat.i(4427);
        if (isTestKeysBuild(context) || !isUserBuildDevice()) {
            AppMethodBeat.o(4427);
            return true;
        }
        AppMethodBeat.o(4427);
        return false;
    }

    @Deprecated
    public static int isGooglePlayServicesAvailable(Context context) {
        AppMethodBeat.i(4417);
        int isGooglePlayServicesAvailable = isGooglePlayServicesAvailable(context, GOOGLE_PLAY_SERVICES_VERSION_CODE);
        AppMethodBeat.o(4417);
        return isGooglePlayServicesAvailable;
    }

    @Deprecated
    public static int isGooglePlayServicesAvailable(Context context, int i2) {
        AppMethodBeat.i(4418);
        try {
            context.getResources().getString(R.string.common_google_play_services_unknown_issue);
        } catch (Throwable th) {
        }
        if (!"com.google.android.gms".equals(context.getPackageName()) && !zzbu.get()) {
            int googlePlayServicesVersion = MetadataValueReader.getGooglePlayServicesVersion(context);
            if (googlePlayServicesVersion == 0) {
                IllegalStateException illegalStateException = new IllegalStateException("A required meta-data tag in your app's AndroidManifest.xml does not exist.  You must have the following declaration within the <application> element:     <meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />");
                AppMethodBeat.o(4418);
                throw illegalStateException;
            } else if (googlePlayServicesVersion != GOOGLE_PLAY_SERVICES_VERSION_CODE) {
                IllegalStateException illegalStateException2 = new IllegalStateException(new StringBuilder(320).append("The meta-data tag in your app's AndroidManifest.xml does not have the right value.  Expected ").append(GOOGLE_PLAY_SERVICES_VERSION_CODE).append(" but found ").append(googlePlayServicesVersion).append(".  You must have the following declaration within the <application> element:     <meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />").toString());
                AppMethodBeat.o(4418);
                throw illegalStateException2;
            }
        }
        int zza = zza(context, !DeviceProperties.isWearableWithoutPlayStore(context) && !DeviceProperties.isIoT(context), i2);
        AppMethodBeat.o(4418);
        return zza;
    }

    @Deprecated
    public static boolean isGooglePlayServicesUid(Context context, int i2) {
        AppMethodBeat.i(4422);
        boolean isGooglePlayServicesUid = UidVerifier.isGooglePlayServicesUid(context, i2);
        AppMethodBeat.o(4422);
        return isGooglePlayServicesUid;
    }

    @Deprecated
    public static boolean isPlayServicesPossiblyUpdating(Context context, int i2) {
        AppMethodBeat.i(4436);
        if (i2 == 18) {
            AppMethodBeat.o(4436);
            return true;
        } else if (i2 == 1) {
            boolean isUninstalledAppPossiblyUpdating = isUninstalledAppPossiblyUpdating(context, "com.google.android.gms");
            AppMethodBeat.o(4436);
            return isUninstalledAppPossiblyUpdating;
        } else {
            AppMethodBeat.o(4436);
            return false;
        }
    }

    @Deprecated
    public static boolean isPlayStorePossiblyUpdating(Context context, int i2) {
        AppMethodBeat.i(4437);
        if (i2 == 9) {
            boolean isUninstalledAppPossiblyUpdating = isUninstalledAppPossiblyUpdating(context, "com.android.vending");
            AppMethodBeat.o(4437);
            return isUninstalledAppPossiblyUpdating;
        }
        AppMethodBeat.o(4437);
        return false;
    }

    @TargetApi(18)
    public static boolean isRestrictedUserProfile(Context context) {
        Bundle applicationRestrictions;
        AppMethodBeat.i(4439);
        if (!PlatformVersion.isAtLeastJellyBeanMR2() || (applicationRestrictions = ((UserManager) context.getSystemService("user")).getApplicationRestrictions(context.getPackageName())) == null || !ServerProtocol.DIALOG_RETURN_SCOPES_TRUE.equals(applicationRestrictions.getString("restricted_profile"))) {
            AppMethodBeat.o(4439);
            return false;
        }
        AppMethodBeat.o(4439);
        return true;
    }

    @VisibleForTesting
    @Deprecated
    public static boolean isSidewinderDevice(Context context) {
        AppMethodBeat.i(4435);
        boolean isSidewinder = DeviceProperties.isSidewinder(context);
        AppMethodBeat.o(4435);
        return isSidewinder;
    }

    public static boolean isTestKeysBuild(Context context) {
        AppMethodBeat.i(4426);
        if (!zzbs) {
            try {
                PackageInfo packageInfo = Wrappers.packageManager(context).getPackageInfo("com.google.android.gms", 64);
                GoogleSignatureVerifier instance = GoogleSignatureVerifier.getInstance(context);
                if (packageInfo == null || instance.isGooglePublicSignedPackage(packageInfo, false) || !instance.isGooglePublicSignedPackage(packageInfo, true)) {
                    zzbr = false;
                } else {
                    zzbr = true;
                }
                zzbs = true;
            } catch (PackageManager.NameNotFoundException e2) {
                zzbs = true;
            } catch (Throwable th) {
                zzbs = true;
                AppMethodBeat.o(4426);
                throw th;
            }
        }
        boolean z = zzbr;
        AppMethodBeat.o(4426);
        return z;
    }

    @TargetApi(21)
    static boolean isUninstalledAppPossiblyUpdating(Context context, String str) {
        AppMethodBeat.i(4438);
        boolean equals = str.equals("com.google.android.gms");
        if (PlatformVersion.isAtLeastLollipop()) {
            try {
                for (PackageInstaller.SessionInfo sessionInfo : context.getPackageManager().getPackageInstaller().getAllSessions()) {
                    if (str.equals(sessionInfo.getAppPackageName())) {
                        AppMethodBeat.o(4438);
                        return true;
                    }
                }
            } catch (Exception e2) {
                AppMethodBeat.o(4438);
                return false;
            }
        }
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(str, 8192);
            if (equals) {
                boolean z = applicationInfo.enabled;
                AppMethodBeat.o(4438);
                return z;
            } else if (!applicationInfo.enabled || isRestrictedUserProfile(context)) {
                AppMethodBeat.o(4438);
                return false;
            } else {
                AppMethodBeat.o(4438);
                return true;
            }
        } catch (PackageManager.NameNotFoundException e3) {
            AppMethodBeat.o(4438);
            return false;
        }
    }

    @Deprecated
    public static boolean isUserBuildDevice() {
        AppMethodBeat.i(4425);
        boolean isUserBuild = DeviceProperties.isUserBuild();
        AppMethodBeat.o(4425);
        return isUserBuild;
    }

    @Deprecated
    public static boolean isUserRecoverableError(int i2) {
        switch (i2) {
            case 1:
            case 2:
            case 3:
            case 9:
                return true;
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            default:
                return false;
        }
    }

    @TargetApi(19)
    @Deprecated
    public static boolean uidHasPackageName(Context context, int i2, String str) {
        AppMethodBeat.i(4423);
        boolean uidHasPackageName = UidVerifier.uidHasPackageName(context, i2, str);
        AppMethodBeat.o(4423);
        return uidHasPackageName;
    }

    @VisibleForTesting
    private static int zza(Context context, boolean z, int i2) {
        AppMethodBeat.i(4419);
        Preconditions.checkArgument(i2 >= 0);
        PackageManager packageManager = context.getPackageManager();
        PackageInfo packageInfo = null;
        if (z) {
            try {
                packageInfo = packageManager.getPackageInfo("com.android.vending", 8256);
            } catch (PackageManager.NameNotFoundException e2) {
                AppMethodBeat.o(4419);
                return 9;
            }
        }
        try {
            PackageInfo packageInfo2 = packageManager.getPackageInfo("com.google.android.gms", 64);
            GoogleSignatureVerifier instance = GoogleSignatureVerifier.getInstance(context);
            if (!instance.isGooglePublicSignedPackage(packageInfo2, true)) {
                AppMethodBeat.o(4419);
                return 9;
            } else if (z && (!instance.isGooglePublicSignedPackage(packageInfo, true) || !packageInfo.signatures[0].equals(packageInfo2.signatures[0]))) {
                AppMethodBeat.o(4419);
                return 9;
            } else if (GmsVersionParser.parseBuildVersion(packageInfo2.versionCode) < GmsVersionParser.parseBuildVersion(i2)) {
                new StringBuilder(77).append("Google Play services out of date.  Requires ").append(i2).append(" but found ").append(packageInfo2.versionCode);
                AppMethodBeat.o(4419);
                return 2;
            } else {
                ApplicationInfo applicationInfo = packageInfo2.applicationInfo;
                if (applicationInfo == null) {
                    try {
                        applicationInfo = packageManager.getApplicationInfo("com.google.android.gms", 0);
                    } catch (PackageManager.NameNotFoundException e3) {
                        Log.wtf("GooglePlayServicesUtil", "Google Play services missing when getting application info.", e3);
                        AppMethodBeat.o(4419);
                        return 1;
                    }
                }
                if (!applicationInfo.enabled) {
                    AppMethodBeat.o(4419);
                    return 3;
                }
                AppMethodBeat.o(4419);
                return 0;
            }
        } catch (PackageManager.NameNotFoundException e4) {
            AppMethodBeat.o(4419);
            return 1;
        }
    }
}
