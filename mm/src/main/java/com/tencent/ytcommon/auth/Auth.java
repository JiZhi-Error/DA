package com.tencent.ytcommon.auth;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.InputStream;

public class Auth {
    private static final boolean FORQQ = false;
    private static final String LIC_FILE_NAME = ".youtu_common.lic";
    private static final boolean MACADDR = false;
    private static final String TAG = "youtu-common";
    private static String licensePath = "";

    public static native String getFailedReason(int i2);

    private static native boolean nativeCheck();

    private static native long nativeGetEndTime();

    private static native int nativeGetLicense(Context context, String str, String str2, String str3, int i2, boolean z, String str4);

    private static native int nativeGetVersion();

    private static native int nativeInitN(Context context, int i2, String str, AssetManager assetManager, String str2, boolean z, String str3);

    private static native int nativeSetSerial(String str);

    public static int initAuthForQQ(Context context) {
        return 5002;
    }

    public static int init(Context context, String str, String str2, int i2) {
        boolean z = false;
        AppMethodBeat.i(2627);
        if (Build.VERSION.SDK_INT < 29 && (Build.VERSION.SDK_INT < 23 || context.checkSelfPermission("android.permission.READ_PHONE_STATE") == 0)) {
            z = true;
        }
        if (i2 == 0) {
            try {
                InputStream open = context.getAssets().open(str, 0);
                if (open == null) {
                    AppMethodBeat.o(2627);
                    return -10;
                }
                open.close();
            } catch (Exception e2) {
                AppMethodBeat.o(2627);
                return -10;
            }
        } else if (i2 == 2 && !new File(str).exists()) {
            AppMethodBeat.o(2627);
            return -10;
        }
        int nativeInitN = nativeInitN(context, i2, str, context.getAssets(), str, z, str2);
        AppMethodBeat.o(2627);
        return nativeInitN;
    }

    public static int init(Context context, String str, String str2, int i2, String str3) {
        boolean z = false;
        AppMethodBeat.i(186316);
        if (licensePath.isEmpty()) {
            licensePath = context.getFilesDir().getPath() + File.separator + LIC_FILE_NAME;
        } else if (Build.VERSION.SDK_INT >= 23 && Build.VERSION.SDK_INT < 29 && context.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
            AppMethodBeat.o(186316);
            return 2004;
        }
        if (Build.VERSION.SDK_INT < 29 && (Build.VERSION.SDK_INT < 23 || context.checkSelfPermission("android.permission.READ_PHONE_STATE") == 0)) {
            z = true;
        }
        int nativeGetLicense = nativeGetLicense(context, str, str2, getLicensePath(), i2, z, str3);
        if (nativeGetLicense == 0) {
            int nativeInitN = nativeInitN(context, 2, getLicensePath(), context.getAssets(), getLicensePath(), z, str3);
            if (nativeInitN == 0 || (nativeInitN = nativeGetLicense(context, str, str2, getLicensePath(), 1, z, str3)) != 0) {
                AppMethodBeat.o(186316);
                return nativeInitN;
            }
            int nativeInitN2 = nativeInitN(context, 2, getLicensePath(), context.getAssets(), getLicensePath(), z, str3);
            AppMethodBeat.o(186316);
            return nativeInitN2;
        }
        AppMethodBeat.o(186316);
        return nativeGetLicense;
    }

    public static void setLicensePath(String str) {
        licensePath = str;
    }

    public static String getLicensePath() {
        return licensePath;
    }

    public static int getVersion() {
        AppMethodBeat.i(2628);
        int nativeGetVersion = nativeGetVersion();
        AppMethodBeat.o(2628);
        return nativeGetVersion;
    }

    public static long getEndTime() {
        AppMethodBeat.i(2630);
        long nativeGetEndTime = nativeGetEndTime();
        AppMethodBeat.o(2630);
        return nativeGetEndTime;
    }
}
