package com.tencent.thumbplayer.core.common;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class TPNativeLibraryLoader {
    private static final String DEFAULT_LIB_PLAYER_CORE_VERSION = "2.10.0.1072.wechat";
    private static final String MAIN_PLAYER_CORE_VERSION = "2.10.0";
    private static boolean mIsLibLoaded = false;
    private static Object mIsLibLoadedLock = new Object();
    private static ITPNativeLibraryExternalLoader mLibLoader = null;
    private static final boolean mLibNameHasArchSuffix = false;
    private static final String mLibPlayerCorePrefix = "TPCore-master";

    private static native String _getPlayerCoreVersion();

    static {
        AppMethodBeat.i(189776);
        AppMethodBeat.o(189776);
    }

    public static void setLibLoader(ITPNativeLibraryExternalLoader iTPNativeLibraryExternalLoader) {
        mLibLoader = iTPNativeLibraryExternalLoader;
    }

    public static String getLibVersion() {
        AppMethodBeat.i(189769);
        String playerCoreVersion = getPlayerCoreVersion();
        AppMethodBeat.o(189769);
        return playerCoreVersion;
    }

    public static void loadLibIfNeeded(Context context) {
        AppMethodBeat.i(189770);
        synchronized (mIsLibLoadedLock) {
            try {
                if (!mIsLibLoaded) {
                    boolean loadLib = loadLib(context);
                    mIsLibLoaded = loadLib;
                    if (loadLib) {
                        TPNativeLog.printLog(2, "TPNativeLibraryLoader load lib successfully");
                    } else {
                        TPNativeLog.printLog(2, "TPNativeLibraryLoader load lib failed");
                    }
                }
                if (!mIsLibLoaded) {
                    UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Failed to load native library");
                    AppMethodBeat.o(189770);
                    throw unsupportedOperationException;
                }
            } finally {
                AppMethodBeat.o(189770);
            }
        }
    }

    public static boolean isLibLoaded() {
        boolean z;
        AppMethodBeat.i(189771);
        try {
            loadLibIfNeeded(null);
        } catch (Throwable th) {
            TPNativeLog.printLog(4, "TPNativeLibraryLoader isLibLoaded error:" + th.getMessage());
        }
        synchronized (mIsLibLoadedLock) {
            try {
                z = mIsLibLoaded;
            } finally {
                AppMethodBeat.o(189771);
            }
        }
        return z;
    }

    public static String getPlayerCoreVersion() {
        AppMethodBeat.i(189772);
        try {
            String _getPlayerCoreVersion = _getPlayerCoreVersion();
            AppMethodBeat.o(189772);
            return _getPlayerCoreVersion;
        } catch (Throwable th) {
            TPNativeLog.printLog(2, "getPlayerCoreVersion: *.so is not loaded yet, return the hard-coded version number:2.10.0.1072.wechat");
            AppMethodBeat.o(189772);
            return DEFAULT_LIB_PLAYER_CORE_VERSION;
        }
    }

    private static boolean loadLib(Context context) {
        boolean loadLibDefault;
        String playerCoreVersion;
        AppMethodBeat.i(189773);
        TPNativeLog.printLog(2, "loadLib cpu arch:" + TPSystemInfo.getCpuArchitecture());
        if (TPSystemInfo.getCpuArchitecture() == 3 || TPSystemInfo.getCpuArchitecture() == 4 || TPSystemInfo.getCpuArchitecture() == 0) {
            AppMethodBeat.o(189773);
            return false;
        }
        String concat = mLibPlayerCorePrefix.concat(String.valueOf(""));
        if (mLibLoader != null) {
            loadLibDefault = mLibLoader.loadLib(concat, DEFAULT_LIB_PLAYER_CORE_VERSION);
        } else {
            loadLibDefault = loadLibDefault(concat, context);
        }
        if (loadLibDefault && !(loadLibDefault = isMatchJavaAndPlayerCore(MAIN_PLAYER_CORE_VERSION, (playerCoreVersion = getPlayerCoreVersion())))) {
            TPNativeLog.printLog(4, "nativePlayerCoreVer(" + playerCoreVersion + ") doesn't match javaPlayerCoreVer:(2.10.0)");
        }
        if (loadLibDefault) {
            TPNativeLog.printLog(2, "Native libs loaded successfully");
        } else {
            TPNativeLog.printLog(4, "Failed to load native libs");
        }
        AppMethodBeat.o(189773);
        return loadLibDefault;
    }

    private static boolean loadLibDefault(String str, Context context) {
        boolean z;
        AppMethodBeat.i(189774);
        boolean z2 = false;
        try {
            TPNativeLog.printLog(2, "loadLibDefault loading ".concat(String.valueOf(str)));
            System.loadLibrary(str);
            z2 = true;
            TPNativeLog.printLog(2, "loadLibDefault " + str + " loaded successfully");
            z = true;
        } catch (Throwable th) {
            TPNativeLog.printLog(4, "loadLibDefault failed to load " + str + "," + th.getMessage());
            z = z2;
        }
        if (!z && context != null && TPSystemInfo.getCpuArchitecture() >= 6) {
            try {
                TPNativeLog.printLog(2, "loadLibDefault try to load " + str + " from APK");
                z = TPLoadLibFromApk.load(str, TPNativeLibraryLoader.class.getClassLoader(), context);
                if (z) {
                    TPNativeLog.printLog(2, "loadLibDefault loaded " + str + " from APK successfully");
                } else {
                    TPNativeLog.printLog(4, "loadLibDefault loaded " + str + " from APK failed");
                }
            } catch (Throwable th2) {
                TPNativeLog.printLog(4, "loadLibDefault loaded " + str + " from APK failed," + th2.getMessage());
            }
        }
        AppMethodBeat.o(189774);
        return z;
    }

    private static boolean isMatchJavaAndPlayerCore(String str, String str2) {
        boolean z = false;
        AppMethodBeat.i(189775);
        TPNativeLog.printLog(2, "javaVersion:" + str + ", coreVersion:" + str2);
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            String[] split = str.split("\\.");
            String[] split2 = str2.split("\\.");
            if (split.length >= 3 && split2.length >= 3) {
                int i2 = 0;
                while (true) {
                    if (i2 < 3) {
                        if (!split[i2].matches(split2[i2])) {
                            break;
                        }
                        i2++;
                    } else {
                        z = true;
                        break;
                    }
                }
            }
        }
        AppMethodBeat.o(189775);
        return z;
    }
}
