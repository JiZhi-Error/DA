package org.xwalk.core;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.util.h;

public class XWebCoreInfo {
    private static final String TAG = "XWebCoreInfo";
    public String strAbi;
    public int ver;
    public String verDetail;

    public boolean isValid() {
        if (this.ver <= 0) {
            return false;
        }
        return true;
    }

    public static XWebCoreInfo getBackupCoreInfo(String str) {
        AppMethodBeat.i(157335);
        XWebCoreInfo xWebCoreInfo = new XWebCoreInfo();
        xWebCoreInfo.strAbi = str;
        SharedPreferences sharedPreferencesForVersionInfo = XWalkEnvironment.getSharedPreferencesForVersionInfo();
        xWebCoreInfo.ver = sharedPreferencesForVersionInfo.getInt(getBackupKey(str, "version"), -1);
        xWebCoreInfo.verDetail = sharedPreferencesForVersionInfo.getString(getBackupKey(str, "versionDetail"), "");
        AppMethodBeat.o(157335);
        return xWebCoreInfo;
    }

    public static boolean setVersionForAbi(int i2, String str, String str2) {
        AppMethodBeat.i(157336);
        SharedPreferences.Editor edit = XWalkEnvironment.getSharedPreferencesForVersionInfo().edit();
        edit.putInt(getBackupKey(str2, "version"), i2);
        edit.putString(getBackupKey(str2, "versionDetail"), str);
        boolean commit = edit.commit();
        if (commit && i2 > 0 && !XWalkEnvironment.getRuntimeAbi().equalsIgnoreCase(str2)) {
            if (XWalkEnvironment.RUNTIME_ABI_ARM32_STR.equalsIgnoreCase(str2)) {
                h.s(577, 238, 1);
            } else if (XWalkEnvironment.RUNTIME_ABI_ARM64_STR.equalsIgnoreCase(str2)) {
                h.s(577, 239, 1);
            }
        }
        XWalkEnvironment.addXWalkInitializeLog(TAG, "set xwalk version to " + i2 + " suc = " + commit + " abi = " + str2);
        AppMethodBeat.o(157336);
        return commit;
    }

    public static boolean setVersionForAbi(XWebCoreInfo xWebCoreInfo) {
        AppMethodBeat.i(157337);
        if (xWebCoreInfo == null) {
            Log.e(TAG, "setVersionForAbi info is null");
            AppMethodBeat.o(157337);
            return false;
        }
        boolean versionForAbi = setVersionForAbi(xWebCoreInfo.ver, xWebCoreInfo.verDetail, xWebCoreInfo.strAbi);
        AppMethodBeat.o(157337);
        return versionForAbi;
    }

    public static int getCurAbiInstalledNewestVersion(Context context) {
        AppMethodBeat.i(157338);
        if (context == null) {
            AppMethodBeat.o(157338);
            return -5;
        }
        if (XWalkEnvironment.getApplicationContext() == null) {
            XWalkEnvironment.init(context);
        }
        int i2 = XWalkEnvironment.getSharedPreferencesForVersionInfo().getInt(getBackupKey(XWalkEnvironment.getRuntimeAbi(), "version"), -1);
        AppMethodBeat.o(157338);
        return i2;
    }

    private static String getBackupKey(String str, String str2) {
        AppMethodBeat.i(157339);
        String str3 = "back_core_" + str2 + "_for_" + str;
        AppMethodBeat.o(157339);
        return str3;
    }

    private static boolean isValidAbi(String str) {
        AppMethodBeat.i(157340);
        if (!TextUtils.isEmpty(str)) {
            AppMethodBeat.o(157340);
            return true;
        }
        AppMethodBeat.o(157340);
        return false;
    }
}
