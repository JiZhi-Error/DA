package com.tencent.mm.sdk.platformtools;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.d;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.util.LinkedList;
import java.util.List;

public final class MMApplicationContext {
    public static final String INTENT_PROCESS_NAME = "_application_context_process_";
    private static final String TAG = "MicroMsg.MMApplicationContext";
    private static Context context = null;
    private static String launchName = "com.tencent.mm.ui.LauncherUI";
    private static ActivityManager mActivityManager = null;
    private static boolean mAppHasInitFlag = false;
    private static volatile Resources mResources = null;
    private static String pkgName = "com.tencent.mm";
    public static boolean sIsRevChange = false;
    private static String sourcePkgName = "com.tencent.mm";

    public static void setAppHasInitFlag(boolean z) {
        mAppHasInitFlag = z;
    }

    public static boolean isAppHasInit() {
        return mAppHasInitFlag;
    }

    public static String getLaunchName() {
        return launchName;
    }

    private MMApplicationContext() {
    }

    public static void setApplicationId(String str) {
        pkgName = str;
    }

    public static void setContext(Context context2) {
        AppMethodBeat.i(125270);
        context = context2;
        pkgName = context2.getPackageName();
        Log.d(TAG, "setup application context for package: " + pkgName);
        if (context2 instanceof Application) {
            ApplicationGlobal.attach((Application) context2);
        }
        AppMethodBeat.o(125270);
    }

    public static Context getContext() {
        return context;
    }

    public static String getApplicationId() {
        return pkgName;
    }

    @Deprecated
    public static String getPackageName() {
        return pkgName;
    }

    public static String getSourcePackageName() {
        return sourcePkgName;
    }

    public static String getDefaultPreferencePath() {
        AppMethodBeat.i(125271);
        String str = pkgName + "_preferences";
        AppMethodBeat.o(125271);
        return str;
    }

    public static String getToolsProcessPreferencePath() {
        AppMethodBeat.i(200901);
        String str = pkgName + "_preferences_tools";
        AppMethodBeat.o(200901);
        return str;
    }

    public static String getExdeviceProcessPreferencePath() {
        AppMethodBeat.i(200902);
        String str = pkgName + "_preferences_exdevice_";
        AppMethodBeat.o(200902);
        return str;
    }

    public static SharedPreferences getDefaultPreference() {
        AppMethodBeat.i(125272);
        if (context != null) {
            SharedPreferences sharedPreferences = context.getSharedPreferences(getDefaultPreferencePath(), 0);
            AppMethodBeat.o(125272);
            return sharedPreferences;
        }
        AppMethodBeat.o(125272);
        return null;
    }

    public static SharedPreferences getToolsProcesstPreference() {
        AppMethodBeat.i(125273);
        if (context != null) {
            SharedPreferences sharedPreferences = context.getSharedPreferences(getToolsProcessPreferencePath(), 0);
            AppMethodBeat.o(125273);
            return sharedPreferences;
        }
        AppMethodBeat.o(125273);
        return null;
    }

    public static SharedPreferences getExdeviceProcessPreference() {
        AppMethodBeat.i(200903);
        if (context == null) {
            AppMethodBeat.o(200903);
            return null;
        } else if (Build.VERSION.SDK_INT >= 11) {
            SharedPreferences sharedPreferences = context.getSharedPreferences(getExdeviceProcessPreferencePath(), 4);
            AppMethodBeat.o(200903);
            return sharedPreferences;
        } else {
            SharedPreferences sharedPreferences2 = context.getSharedPreferences(getExdeviceProcessPreferencePath(), 0);
            AppMethodBeat.o(200903);
            return sharedPreferences2;
        }
    }

    public static String getTmpPreferencePath() {
        AppMethodBeat.i(125274);
        String str = pkgName + "_tmp_preferences";
        AppMethodBeat.o(125274);
        return str;
    }

    public static SharedPreferences getTmpPreference() {
        AppMethodBeat.i(200904);
        if (context != null) {
            SharedPreferences sharedPreferences = context.getSharedPreferences(getTmpPreferencePath(), 0);
            AppMethodBeat.o(200904);
            return sharedPreferences;
        }
        AppMethodBeat.o(200904);
        return null;
    }

    public static String getProcessName() {
        return d.cQi;
    }

    public static boolean isMainProcess() {
        AppMethodBeat.i(125275);
        String str = d.cQi;
        if (str == null || str.length() == 0) {
            str = pkgName;
        }
        boolean equals = pkgName.equals(str);
        AppMethodBeat.o(125275);
        return equals;
    }

    @Deprecated
    public static boolean isMMProcess() {
        AppMethodBeat.i(125276);
        boolean isMainProcess = isMainProcess();
        AppMethodBeat.o(125276);
        return isMainProcess;
    }

    public static boolean isAppBrandProcess() {
        AppMethodBeat.i(125277);
        String processName = getProcessName();
        if (processName == null || processName.length() == 0) {
            processName = pkgName;
        }
        boolean startsWith = processName.startsWith(pkgName + ":appbrand");
        AppMethodBeat.o(125277);
        return startsWith;
    }

    public static boolean isPushProcess() {
        AppMethodBeat.i(125278);
        String processName = getProcessName();
        if (processName == null || processName.length() == 0) {
            processName = pkgName;
        }
        boolean equalsIgnoreCase = (pkgName + ":push").equalsIgnoreCase(processName);
        AppMethodBeat.o(125278);
        return equalsIgnoreCase;
    }

    public static boolean isToolsIsolatedProcess() {
        AppMethodBeat.i(125279);
        String str = d.cQi;
        if (str == null || str.length() == 0) {
            str = pkgName;
        }
        boolean equalsIgnoreCase = (pkgName + ":isolated_process0").equalsIgnoreCase(str);
        AppMethodBeat.o(125279);
        return equalsIgnoreCase;
    }

    public static boolean isToolsProcess() {
        AppMethodBeat.i(125280);
        String processName = getProcessName();
        if (processName == null || processName.length() == 0) {
            processName = pkgName;
        }
        boolean equalsIgnoreCase = (pkgName + ":tools").equalsIgnoreCase(processName);
        AppMethodBeat.o(125280);
        return equalsIgnoreCase;
    }

    public static boolean isToolsMpProcess() {
        AppMethodBeat.i(125281);
        String processName = getProcessName();
        if (processName == null || processName.length() == 0) {
            processName = pkgName;
        }
        boolean equalsIgnoreCase = (pkgName + ":toolsmp").equalsIgnoreCase(processName);
        AppMethodBeat.o(125281);
        return equalsIgnoreCase;
    }

    public static boolean isSandBoxProcess() {
        AppMethodBeat.i(125282);
        String processName = getProcessName();
        if (processName == null || processName.length() == 0) {
            processName = pkgName;
        }
        boolean equalsIgnoreCase = (pkgName + ":sandbox").equalsIgnoreCase(processName);
        AppMethodBeat.o(125282);
        return equalsIgnoreCase;
    }

    public static boolean isExdeviceProcess() {
        AppMethodBeat.i(125283);
        String processName = getProcessName();
        if (processName == null || processName.length() == 0) {
            processName = pkgName;
        }
        boolean equalsIgnoreCase = (pkgName + ":exdevice").equalsIgnoreCase(processName);
        AppMethodBeat.o(125283);
        return equalsIgnoreCase;
    }

    public static boolean isSwitchProcess() {
        AppMethodBeat.i(200905);
        String processName = getProcessName();
        if (processName == null || processName.length() == 0) {
            processName = pkgName;
        }
        boolean equalsIgnoreCase = (pkgName + ":switch").equalsIgnoreCase(processName);
        AppMethodBeat.o(200905);
        return equalsIgnoreCase;
    }

    public static boolean isHotpotDotDotProcess() {
        AppMethodBeat.i(200906);
        String processName = getProcessName();
        if (processName == null || processName.length() == 0) {
            processName = pkgName;
        }
        boolean equalsIgnoreCase = (pkgName + ":hotpot").equalsIgnoreCase(processName);
        AppMethodBeat.o(200906);
        return equalsIgnoreCase;
    }

    public static boolean isLiteProcess() {
        AppMethodBeat.i(200907);
        String processName = getProcessName();
        if (processName == null || processName.length() == 0) {
            processName = pkgName;
        }
        boolean equalsIgnoreCase = (pkgName + ":lite").equalsIgnoreCase(processName);
        AppMethodBeat.o(200907);
        return equalsIgnoreCase;
    }

    public static boolean isNoSpaceProcess() {
        AppMethodBeat.i(200908);
        String processName = getProcessName();
        if (processName == null || processName.length() == 0) {
            processName = pkgName;
        }
        boolean equalsIgnoreCase = (pkgName + ":nospace").equalsIgnoreCase(processName);
        AppMethodBeat.o(200908);
        return equalsIgnoreCase;
    }

    public static boolean isMMProcessExist() {
        AppMethodBeat.i(125284);
        boolean isProcessExist = isProcessExist(pkgName);
        AppMethodBeat.o(125284);
        return isProcessExist;
    }

    public static boolean isProcessExist(String str) {
        AppMethodBeat.i(125285);
        if (context == null || pkgName == null) {
            AppMethodBeat.o(125285);
            return false;
        }
        if (mActivityManager == null) {
            mActivityManager = (ActivityManager) context.getSystemService(EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        }
        try {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : mActivityManager.getRunningAppProcesses()) {
                if (runningAppProcessInfo.processName.equals(str)) {
                    AppMethodBeat.o(125285);
                    return true;
                }
            }
            AppMethodBeat.o(125285);
            return false;
        } catch (Exception e2) {
            Log.e(TAG, "isMMProcessExist Exception: " + e2.toString());
            AppMethodBeat.o(125285);
            return false;
        } catch (Error e3) {
            Log.e(TAG, "isMMProcessExist Error: " + e3.toString());
            AppMethodBeat.o(125285);
            return false;
        }
    }

    public static List<String> getAliveProcess() {
        AppMethodBeat.i(200909);
        LinkedList linkedList = new LinkedList();
        if (context == null || pkgName == null) {
            AppMethodBeat.o(200909);
            return linkedList;
        }
        if (mActivityManager == null) {
            mActivityManager = (ActivityManager) context.getSystemService(EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        }
        try {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : mActivityManager.getRunningAppProcesses()) {
                String str = runningAppProcessInfo.processName;
                linkedList.add(str + "@" + runningAppProcessInfo.pid);
            }
            AppMethodBeat.o(200909);
            return linkedList;
        } catch (Exception e2) {
            Log.e(TAG, "isMMProcessExist Exception: " + e2.toString());
            AppMethodBeat.o(200909);
            return linkedList;
        } catch (Error e3) {
            Log.e(TAG, "isMMProcessExist Error: " + e3.toString());
            AppMethodBeat.o(200909);
            return linkedList;
        }
    }

    public static Resources getResources() {
        return mResources;
    }

    public static void setResources(Resources resources) {
        mResources = resources;
    }
}
