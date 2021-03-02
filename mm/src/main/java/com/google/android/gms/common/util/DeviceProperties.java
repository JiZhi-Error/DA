package com.google.android.gms.common.util;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.internal.Objects;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tinker.loader.hotplug.EnvConsts;

public final class DeviceProperties {
    public static final String FEATURE_AUTO = "android.hardware.type.automotive";
    public static final String FEATURE_CHROME_OS = "org.chromium.arc";
    public static final String FEATURE_EMBEDDED = "android.hardware.type.embedded";
    public static final String FEATURE_IOT = "android.hardware.type.iot";
    public static final String FEATURE_LATCHSKY = "cn.google.services";
    public static final String FEATURE_PIXEL = "com.google.android.feature.PIXEL_EXPERIENCE";
    public static final String FEATURE_SIDEWINDER = "cn.google";
    public static final String FEATURE_TV_1 = "com.google.android.tv";
    public static final String FEATURE_TV_2 = "android.hardware.type.television";
    public static final String FEATURE_TV_3 = "android.software.leanback";
    private static Boolean zzzl;
    private static Boolean zzzm;
    private static Boolean zzzn;
    private static Boolean zzzo;
    private static Boolean zzzp;
    private static Boolean zzzq;
    private static Boolean zzzr;
    private static Boolean zzzs;
    private static Boolean zzzt;
    private static Boolean zzzu;
    private static Boolean zzzv;

    private DeviceProperties() {
    }

    public static boolean isAuto(Context context) {
        AppMethodBeat.i(5196);
        if (zzzt == null) {
            zzzt = Boolean.valueOf(PlatformVersion.isAtLeastO() && context.getPackageManager().hasSystemFeature(FEATURE_AUTO));
        }
        boolean booleanValue = zzzt.booleanValue();
        AppMethodBeat.o(5196);
        return booleanValue;
    }

    public static boolean isChromeOsDevice(Context context) {
        AppMethodBeat.i(5200);
        if (zzzs == null) {
            zzzs = Boolean.valueOf(context.getPackageManager().hasSystemFeature(FEATURE_CHROME_OS));
        }
        boolean booleanValue = zzzs.booleanValue();
        AppMethodBeat.o(5200);
        return booleanValue;
    }

    public static boolean isIoT(Context context) {
        AppMethodBeat.i(5195);
        if (zzzr == null) {
            zzzr = Boolean.valueOf(context.getPackageManager().hasSystemFeature(FEATURE_IOT) || context.getPackageManager().hasSystemFeature(FEATURE_EMBEDDED));
        }
        boolean booleanValue = zzzr.booleanValue();
        AppMethodBeat.o(5195);
        return booleanValue;
    }

    public static boolean isLatchsky(Context context) {
        AppMethodBeat.i(5194);
        if (zzzp == null) {
            zzzp = Boolean.valueOf(PlatformVersion.isAtLeastM() && context.getPackageManager().hasSystemFeature(FEATURE_LATCHSKY));
        }
        boolean booleanValue = zzzp.booleanValue();
        AppMethodBeat.o(5194);
        return booleanValue;
    }

    public static boolean isLowRamOrPreKitKat(Context context) {
        ActivityManager activityManager;
        AppMethodBeat.i(5199);
        if (Build.VERSION.SDK_INT < 19) {
            AppMethodBeat.o(5199);
            return true;
        }
        if (zzzq == null && (activityManager = (ActivityManager) context.getSystemService(EnvConsts.ACTIVITY_MANAGER_SRVNAME)) != null) {
            zzzq = Boolean.valueOf(activityManager.isLowRamDevice());
        }
        boolean equal = Objects.equal(zzzq, Boolean.TRUE);
        AppMethodBeat.o(5199);
        return equal;
    }

    public static boolean isPixelDevice(Context context) {
        AppMethodBeat.i(5201);
        if (zzzv == null) {
            zzzv = Boolean.valueOf(context.getPackageManager().hasSystemFeature(FEATURE_PIXEL));
        }
        boolean booleanValue = zzzv.booleanValue();
        AppMethodBeat.o(5201);
        return booleanValue;
    }

    @TargetApi(21)
    public static boolean isSidewinder(Context context) {
        AppMethodBeat.i(5193);
        if (zzzo == null) {
            zzzo = Boolean.valueOf(PlatformVersion.isAtLeastLollipop() && context.getPackageManager().hasSystemFeature("cn.google"));
        }
        boolean booleanValue = zzzo.booleanValue();
        AppMethodBeat.o(5193);
        return booleanValue;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0040, code lost:
        if (com.google.android.gms.common.util.DeviceProperties.zzzm.booleanValue() != false) goto L_0x0042;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean isTablet(android.content.res.Resources r6) {
        /*
            r5 = 3
            r4 = 5190(0x1446, float:7.273E-42)
            r1 = 1
            r2 = 0
            com.tencent.matrix.trace.core.AppMethodBeat.i(r4)
            if (r6 != 0) goto L_0x000e
            com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
        L_0x000d:
            return r2
        L_0x000e:
            java.lang.Boolean r0 = com.google.android.gms.common.util.DeviceProperties.zzzl
            if (r0 != 0) goto L_0x0049
            android.content.res.Configuration r0 = r6.getConfiguration()
            int r0 = r0.screenLayout
            r0 = r0 & 15
            if (r0 <= r5) goto L_0x0053
            r0 = r1
        L_0x001d:
            if (r0 != 0) goto L_0x0042
            java.lang.Boolean r0 = com.google.android.gms.common.util.DeviceProperties.zzzm
            if (r0 != 0) goto L_0x003a
            android.content.res.Configuration r0 = r6.getConfiguration()
            int r3 = r0.screenLayout
            r3 = r3 & 15
            if (r3 > r5) goto L_0x0055
            int r0 = r0.smallestScreenWidthDp
            r3 = 600(0x258, float:8.41E-43)
            if (r0 < r3) goto L_0x0055
            r0 = r1
        L_0x0034:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            com.google.android.gms.common.util.DeviceProperties.zzzm = r0
        L_0x003a:
            java.lang.Boolean r0 = com.google.android.gms.common.util.DeviceProperties.zzzm
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x0043
        L_0x0042:
            r2 = r1
        L_0x0043:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r2)
            com.google.android.gms.common.util.DeviceProperties.zzzl = r0
        L_0x0049:
            java.lang.Boolean r0 = com.google.android.gms.common.util.DeviceProperties.zzzl
            boolean r2 = r0.booleanValue()
            com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
            goto L_0x000d
        L_0x0053:
            r0 = r2
            goto L_0x001d
        L_0x0055:
            r0 = r2
            goto L_0x0034
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.util.DeviceProperties.isTablet(android.content.res.Resources):boolean");
    }

    public static boolean isTv(Context context) {
        AppMethodBeat.i(5197);
        if (zzzu == null) {
            PackageManager packageManager = context.getPackageManager();
            zzzu = Boolean.valueOf(packageManager.hasSystemFeature(FEATURE_TV_1) || packageManager.hasSystemFeature(FEATURE_TV_2) || packageManager.hasSystemFeature(FEATURE_TV_3));
        }
        boolean booleanValue = zzzu.booleanValue();
        AppMethodBeat.o(5197);
        return booleanValue;
    }

    public static boolean isUserBuild() {
        AppMethodBeat.i(5198);
        if (GooglePlayServicesUtilLight.sIsTestMode) {
            boolean z = GooglePlayServicesUtilLight.sTestIsUserBuild;
            AppMethodBeat.o(5198);
            return z;
        }
        boolean equals = "user".equals(Build.TYPE);
        AppMethodBeat.o(5198);
        return equals;
    }

    @TargetApi(20)
    public static boolean isWearable(Context context) {
        AppMethodBeat.i(5191);
        if (zzzn == null) {
            zzzn = Boolean.valueOf(PlatformVersion.isAtLeastKitKatWatch() && context.getPackageManager().hasSystemFeature("android.hardware.type.watch"));
        }
        boolean booleanValue = zzzn.booleanValue();
        AppMethodBeat.o(5191);
        return booleanValue;
    }

    @TargetApi(24)
    public static boolean isWearableWithoutPlayStore(Context context) {
        AppMethodBeat.i(5192);
        if ((!PlatformVersion.isAtLeastN() || isSidewinder(context)) && isWearable(context)) {
            AppMethodBeat.o(5192);
            return true;
        }
        AppMethodBeat.o(5192);
        return false;
    }

    @VisibleForTesting
    public static void resetForTest() {
        zzzm = null;
        zzzl = null;
        zzzn = null;
        zzzo = null;
        zzzp = null;
        zzzq = null;
        zzzr = null;
        zzzs = null;
        zzzt = null;
        zzzu = null;
        zzzv = null;
    }

    @VisibleForTesting
    public static void setIsAutoForTest(boolean z) {
        AppMethodBeat.i(5206);
        zzzt = Boolean.valueOf(z);
        AppMethodBeat.o(5206);
    }

    @VisibleForTesting
    public static void setIsIoTForTest(boolean z) {
        AppMethodBeat.i(5205);
        zzzr = Boolean.valueOf(z);
        AppMethodBeat.o(5205);
    }

    @VisibleForTesting
    public static void setIsLatchskyForTest(boolean z) {
        AppMethodBeat.i(5204);
        zzzp = Boolean.valueOf(z);
        AppMethodBeat.o(5204);
    }

    @VisibleForTesting
    public static void setIsLowRamForTest(boolean z) {
        AppMethodBeat.i(5208);
        zzzq = Boolean.valueOf(z);
        AppMethodBeat.o(5208);
    }

    @VisibleForTesting
    public static void setIsPixelForTest(boolean z) {
        AppMethodBeat.i(5209);
        zzzv = Boolean.valueOf(z);
        AppMethodBeat.o(5209);
    }

    @VisibleForTesting
    public static void setIsSideWinderForTest(boolean z) {
        AppMethodBeat.i(5203);
        zzzo = Boolean.valueOf(z);
        AppMethodBeat.o(5203);
    }

    @VisibleForTesting
    public static void setIsTvForTest(boolean z) {
        AppMethodBeat.i(5207);
        zzzu = Boolean.valueOf(z);
        AppMethodBeat.o(5207);
    }

    @VisibleForTesting
    public static void setIsWearableForTest(boolean z) {
        AppMethodBeat.i(5202);
        zzzn = Boolean.valueOf(z);
        AppMethodBeat.o(5202);
    }
}
