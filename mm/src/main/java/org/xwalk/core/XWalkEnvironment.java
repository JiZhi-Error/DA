package org.xwalk.core;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Looper;
import android.os.Process;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.xweb.ISharedPreferenceProvider;
import com.tencent.xweb.WebView;
import com.tencent.xweb.ai;
import com.tencent.xweb.b;
import com.tencent.xweb.internal.l;
import com.tencent.xweb.util.c;
import com.tencent.xweb.util.f;
import com.tencent.xweb.xwalk.a.h;
import com.tencent.xweb.y;
import java.io.Closeable;
import java.io.File;
import java.lang.reflect.Method;
import java.net.URI;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public class XWalkEnvironment {
    private static final String APK_DIR = "apk";
    public static final String[] DEFAULT_MANDATORY_RESOURCES = {"classes.dex", "icudtl.dat", "xwalk.pak", "xwalk_100_percent.pak", "xweb_fullscreen_video.js"};
    public static final String DOWNLOAD_CONFIG_URL = "https://dldir1.qq.com/weixin/android/wxweb/updateConfig.xml";
    public static final String DOWNLOAD_CONFIG_URL_THIRD_PARD = "https://dldir1.qq.com/weixin/android/wxweb/updateConfig_public.xml";
    public static final String DOWNLOAD_PLUGIN_UPDATE_CONFIG_URL = "https://dldir1.qq.com/weixin/android/wxweb/plugin/pluginUpdateConfig.xml";
    public static final String DOWNLOAD_PLUGIN_UPDATE_CONFIG_URL_THIRD_PARD = "https://dldir1.qq.com/weixin/android/wxweb/plugin/pluginUpdateConfig_public.xml";
    public static final String DOWNLOAD_PLUGIN_UPDATE_TEST_CONFIG_DEFAULT_URL = "https://dldir1.qq.com/weixin/android/wxweb/plugin/pluginUpdateConfig_test.xml";
    public static final String DOWNLOAD_X86_CONFIG_URL = "https://dldir1.qq.com/weixin/android/wxweb/updateConfig_x86.xml";
    public static final String LOCAL_TEST_ZIP_NAME = "runtime_package.zip";
    private static final String META_XWALK_DOWNCONFIG_URL = "xwalk_downconfig_url";
    public static final String MM_PACKAGE_NAME = "com.tencent.mm";
    private static final String OPTIMIZED_DEX_DIR = "dex";
    private static final String PACKAGE_RE = "[a-z]+\\.[a-z0-9]+\\.[a-z0-9]+.*";
    private static final String PATCH_ZIP_TEMP_DECOMPRESS_DIR = "patch_temp_decompress";
    public static final String RUNTIME_ABI_ARM32_STR = "armeabi-v7a";
    public static final String RUNTIME_ABI_ARM64_STR = "arm64-v8a";
    public static final int SDK_SUPPORT_INVOKE_NOTIFY_MIN_APKVERSION = 153;
    public static final int SDK_SUPPORT_INVOKE_RUNTIME_MIN_APKVERSION = 255;
    public static final int SDK_SUPPORT_MIN_APKVERSION = 49;
    public static final int SDK_VERSION = 201201;
    private static final int SPECIAL_TEST_USER_ID = 10001;
    public static final String SP_KEY_DEVICE_RD = "sNDeviceRd";
    public static final String SP_KEY_FILE_READER_POSTFIX_COUNT = "_count";
    public static final String SP_KEY_FILE_READER_POSTFIX_REPORT_UV_DATE = "_report_uv_date";
    public static final String SP_KEY_FILE_READER_POSTFIX_TIME = "_time";
    private static final String SP_KEY_GRAY_VALUE = "GRAY_VALUE";
    private static final String SP_KEY_GRAY_VALUE_TEST = "TEST_GRAY_VALUE";
    private static final String SP_KEY_IP_TYPE = "IP_TYPE";
    public static final String SP_KEY_PLUGIN_AVAILABLE_VERSION = "availableVersion";
    public static final String SP_KEY_PLUGIN_LAST_REPORT_DATE = "lastReportDate";
    public static final String SP_KEY_PLUGIN_LAST_REPORT_VERSION = "lastReportVersion";
    public static final String SP_KEY_PLUGIN_PATCH_DOWNLOAD_COUNT_PREFIX = "patchDownloadCount_";
    public static final String SP_KEY_PLUGIN_SUPPORT_FORMATS = "supportFormats";
    private static final String SP_KEY_PLUGIN_TEST_CONFIG_URL = "XWEB_PLUGIN_TEST_CONFIG_URL";
    public static final String SP_KEY_PLUGIN_UPDATE_CONFIG_LAST_FETCH_TIME = "nLastFetchPluginConfigTime";
    public static final String SP_KEY_PLUGIN_UPDATE_PROCESS_ID = "nUpdatingProcessId";
    public static final String SP_NAME_FILE_READER_RECORD = "xwalk_reader_record";
    private static final String SP_NAME_PLUGIN_UPDATE_INFO = "xwalk_plugin_update_info";
    private static final String SP_NAME_PLUGIN_VERSION_INFO_PREFIX = "xwalk_plugin_version_info_";
    public static final String SP_NAME_VERSION_INFO = "XWALKINFOS";
    private static final String TAG = "XWalkEnvironment";
    public static final int TEST_APK_START_VERSION = 100000000;
    public static String UPDATEINFOTAG = "xwalk_update_info";
    public static final String XWALK_CORE_APK_NAME = "base.apk";
    public static final String XWALK_CORE_CLASSES_DEX = "classes.dex";
    private static final String XWALK_CORE_EXTRACTED_DIR = "extracted_xwalkcore";
    public static final String XWALK_CORE_FILELIST_CONFIG_NAME = "filelist.config";
    private static final String XWALK_CORE_NAME_PREFIX = "xwalk_";
    private static final String XWALK_CORE_PATCH_CONFIG_NAME = "patch.config";
    private static final String XWALK_CORE_PATCH_NAME = "patch.zip";
    public static final String[] XWALK_CORE_PROVIDER_LIST = {"com.tencent.mm"};
    private static final String XWALK_CORE_RES_FILELIST_CONFIG_NAME = "reslist.config";
    private static final String XWALK_CORE_ZIP_NAME = "base.zip";
    public static final String XWALK_ENV_MAP_KEY_ISGPVERSION = "isgpversion";
    public static final String XWALK_ENV_MAP_KEY_PROCESSNAME = "processname";
    public static final int XWALK_GET_FROM_PROVIDER_MAX_COUNT = 2;
    private static final String XWALK_PLUGIN_BASE_DIR = "xwalkplugin";
    public static final String XWALK_PLUGIN_NAME_EXCEL = "XFilesExcelReader";
    public static final String XWALK_PLUGIN_NAME_FULL_SCREEN_VIDEO = "FullScreenVideo";
    public static final String XWALK_PLUGIN_NAME_OFFICE = "XFilesOfficeReader";
    public static final String XWALK_PLUGIN_NAME_PDF = "XFilesPDFReader";
    public static final String XWALK_PLUGIN_NAME_PPT = "XFilesPPTReader";
    public static final String XWALK_PLUGIN_NAME_WORD = "XFilesWordReader";
    private static final String XWALK_PLUGIN_UPDATE_CONFIG_NAME = "pluginUpdateConfig.xml";
    public static final int XWALK_PLUGIN_UPDATE_PERIOD_DEFAULT = 90000000;
    private static final String XWALK_UPDATE_CONFIG_DIR = "xwalkconfig";
    private static final String ZIP_DIR = "zip";
    private static boolean isTurnOnKVLog = false;
    private static int sAppClientVersion = 0;
    private static Set<String> sAppInfos = new HashSet();
    private static Context sApplicationContext;
    private static String sApplicationName;
    static boolean sBHasInitedSafePsProvider = false;
    static boolean sBIsIpTypeChanged = false;
    static long sConfigPerios = 0;
    private static String sDeviceAbi;
    private static int sForceDarkBehavior = 2;
    private static Boolean sIsDownloadMode = Boolean.TRUE;
    private static Boolean sIsDownloadModeUpdate = Boolean.TRUE;
    private static boolean sIsForceDarkMode = false;
    private static boolean sIsPluginInited = false;
    private static Boolean sIsXWalkVerify;
    static Method sMMKVMethod;
    static int sNChromiuVersion = -1;
    public static int sNDeviceRd = 0;
    static int sPid = Process.myPid();
    private static String sRuntimeAbi;
    static ISharedPreferenceProvider sSPProvider = null;
    static String sStrCurentProcessName;
    static String sStrDeviceId = null;
    private static String sStrTempPluginUpdateConfigUrl;
    private static String sStrTempUpdateConfigUrl;
    private static int sTempPluginUpdatePeriod = -1;
    private static boolean sUsingCustomContext = false;
    private static String sXWalkApkUrl;
    private static String sXWalkDownConfigUrl;
    static HashMap<String, Object> sXWebArgs;
    private static XWebCoreInfo sXWebCoreInfo;
    static int s_grayValue = 0;
    static String s_todayDate = "";
    static int s_todayGrayValue = 0;

    static {
        AppMethodBeat.i(157334);
        AppMethodBeat.o(157334);
    }

    public enum ForceDarkBehavior {
        FORCE_DARK_ONLY,
        MEDIA_QUERY_ONLY,
        PREFER_MEDIA_QUERY_OVER_FORCE_DARK;

        public static ForceDarkBehavior valueOf(String str) {
            AppMethodBeat.i(157222);
            ForceDarkBehavior forceDarkBehavior = (ForceDarkBehavior) Enum.valueOf(ForceDarkBehavior.class, str);
            AppMethodBeat.o(157222);
            return forceDarkBehavior;
        }

        static {
            AppMethodBeat.i(157223);
            AppMethodBeat.o(157223);
        }
    }

    public static synchronized void init(Context context) {
        synchronized (XWalkEnvironment.class) {
            AppMethodBeat.i(157224);
            if (context == null || sApplicationContext != null) {
                AppMethodBeat.o(157224);
            } else {
                sApplicationContext = context.getApplicationContext();
                String runtimeAbi = getRuntimeAbi();
                Log.i(TAG, "current abi is ".concat(String.valueOf(runtimeAbi)));
                XWebCoreInfo backupCoreInfo = XWebCoreInfo.getBackupCoreInfo(runtimeAbi);
                if (backupCoreInfo.ver <= 0) {
                    if (!getSharedPreferencesForVersionInfo().getBoolean("transported_version", false)) {
                        int i2 = getSharedPreferencesForVersionInfo().getInt(SP_KEY_PLUGIN_AVAILABLE_VERSION, -1);
                        String string = getSharedPreferencesForVersionInfo().getString("versionDetail", "");
                        backupCoreInfo.strAbi = runtimeAbi;
                        backupCoreInfo.ver = i2;
                        backupCoreInfo.verDetail = string;
                    }
                    if (XWebCoreInfo.setVersionForAbi(backupCoreInfo)) {
                        getSharedPreferencesForVersionInfo().edit().putBoolean("transported_version", true).commit();
                    }
                }
                sXWebCoreInfo = backupCoreInfo;
                if (!sIsPluginInited) {
                    sIsPluginInited = initXWalkPlugins();
                }
                y.lC(context);
                initTurnOnKVLog();
                AppMethodBeat.o(157224);
            }
        }
    }

    public static void refreshVerInfo() {
        AppMethodBeat.i(185177);
        sXWebCoreInfo = XWebCoreInfo.getBackupCoreInfo(getRuntimeAbi());
        AppMethodBeat.o(185177);
    }

    public static void initTurnOnKVLog() {
        AppMethodBeat.i(157225);
        try {
            isTurnOnKVLog = y.hsF().hsJ();
            AppMethodBeat.o(157225);
        } catch (Exception e2) {
            Log.e(TAG, "init log failed");
            AppMethodBeat.o(157225);
        }
    }

    public static void resetForDebug() {
        sApplicationContext = null;
        sXWebCoreInfo = null;
        sIsPluginInited = false;
    }

    private static boolean initXWalkPlugins() {
        AppMethodBeat.i(157226);
        boolean hvn = h.hvn();
        AppMethodBeat.o(157226);
        return hvn;
    }

    public static boolean isForbidDownloadCode() {
        AppMethodBeat.i(219106);
        boolean htj = ai.htj();
        AppMethodBeat.o(219106);
        return htj;
    }

    public static void setIsForbidDownloadCode(boolean z) {
        AppMethodBeat.i(157227);
        ai.El(z);
        AppMethodBeat.o(157227);
    }

    static void initSafePsProvider() {
        AppMethodBeat.i(157228);
        if (sBHasInitedSafePsProvider) {
            AppMethodBeat.o(157228);
            return;
        }
        try {
            sMMKVMethod = Class.forName("com.tencent.mm.cr.c").getMethod("getMMKV", Context.class, String.class, Integer.TYPE, Boolean.TYPE);
        } catch (Exception e2) {
        }
        if (sMMKVMethod == null) {
            com.tencent.xweb.util.h.OQ(178);
            Log.e(TAG, "initSafePsProvider failed");
        } else {
            Log.i(TAG, "initSafePsProvider suscsess");
        }
        sBHasInitedSafePsProvider = true;
        AppMethodBeat.o(157228);
    }

    public static synchronized void setXWebInitArgs(HashMap hashMap) {
        synchronized (XWalkEnvironment.class) {
            sXWebArgs = hashMap;
        }
    }

    public static synchronized Object getXWebInitArgs(String str) {
        Object obj;
        synchronized (XWalkEnvironment.class) {
            AppMethodBeat.i(157229);
            if (sXWebArgs == null || !sXWebArgs.containsKey(str)) {
                obj = null;
                AppMethodBeat.o(157229);
            } else {
                obj = sXWebArgs.get(str);
                AppMethodBeat.o(157229);
            }
        }
        return obj;
    }

    public static synchronized String getXWebInitArgs(String str, String str2) {
        String str3;
        synchronized (XWalkEnvironment.class) {
            AppMethodBeat.i(219107);
            Object xWebInitArgs = getXWebInitArgs(str);
            if (xWebInitArgs == null || !(xWebInitArgs instanceof String)) {
                AppMethodBeat.o(219107);
                str3 = str2;
            } else {
                str3 = (String) xWebInitArgs;
                AppMethodBeat.o(219107);
            }
        }
        return str3;
    }

    public static synchronized boolean getXWebInitArgs(String str, boolean z) {
        synchronized (XWalkEnvironment.class) {
            AppMethodBeat.i(157230);
            Object xWebInitArgs = getXWebInitArgs(str);
            if (xWebInitArgs == null) {
                AppMethodBeat.o(157230);
            } else {
                try {
                    z = Boolean.valueOf(xWebInitArgs.toString()).booleanValue();
                    AppMethodBeat.o(157230);
                } catch (Exception e2) {
                    Log.e(TAG, "getXWebInitArgs boolean parse failed");
                    AppMethodBeat.o(157230);
                }
            }
        }
        return z;
    }

    public static SharedPreferences getProcessSafePreferences(String str, int i2) {
        AppMethodBeat.i(157231);
        SharedPreferences sharedPreferences = sApplicationContext.getSharedPreferences(str, i2);
        AppMethodBeat.o(157231);
        return sharedPreferences;
    }

    public static synchronized void setSharedPreferenceProvider(ISharedPreferenceProvider iSharedPreferenceProvider) {
        synchronized (XWalkEnvironment.class) {
            if (iSharedPreferenceProvider != null) {
                sSPProvider = iSharedPreferenceProvider;
            }
        }
    }

    public static SharedPreferences getMMKVSharedPreferences(String str) {
        AppMethodBeat.i(157232);
        SharedPreferences mMKVSharedPreferencesEx = getMMKVSharedPreferencesEx(str, 4, false);
        AppMethodBeat.o(157232);
        return mMKVSharedPreferencesEx;
    }

    public static SharedPreferences getMMKVSharedTransportOld(String str) {
        AppMethodBeat.i(157233);
        SharedPreferences mMKVSharedPreferencesEx = getMMKVSharedPreferencesEx(str, 4, true);
        AppMethodBeat.o(157233);
        return mMKVSharedPreferencesEx;
    }

    public static SharedPreferences getMMKVSharedPreferencesEx(String str, int i2, boolean z) {
        SharedPreferences sharedPreferences;
        AppMethodBeat.i(157234);
        if (sSPProvider != null) {
            try {
                ISharedPreferenceProvider iSharedPreferenceProvider = sSPProvider;
                getApplicationContext();
                sharedPreferences = iSharedPreferenceProvider.C(str, i2, z);
            } catch (Exception e2) {
                Log.e(TAG, "got sp from mmkv callback failed " + e2.getMessage());
                sharedPreferences = null;
            }
            if (sharedPreferences != null) {
                AppMethodBeat.o(157234);
                return sharedPreferences;
            }
            com.tencent.xweb.util.h.OQ(176);
        } else {
            com.tencent.xweb.util.h.OQ(177);
        }
        initSafePsProvider();
        if (sMMKVMethod == null) {
            SharedPreferences sharedPreferences2 = sApplicationContext.getSharedPreferences(str, i2);
            AppMethodBeat.o(157234);
            return sharedPreferences2;
        }
        try {
            Object invoke = sMMKVMethod.invoke(null, getApplicationContext(), str, Integer.valueOf(i2), Boolean.valueOf(z));
            if (invoke == null || !(invoke instanceof SharedPreferences)) {
                Log.e(TAG, "get mmmkv from reflection failed");
                com.tencent.xweb.util.h.OQ(179);
                SharedPreferences sharedPreferences3 = sApplicationContext.getSharedPreferences(str, i2);
                AppMethodBeat.o(157234);
                return sharedPreferences3;
            }
            SharedPreferences sharedPreferences4 = (SharedPreferences) invoke;
            AppMethodBeat.o(157234);
            return sharedPreferences4;
        } catch (Exception e3) {
        }
    }

    public static SharedPreferences getSharedPreferencesForUpdateConfig() {
        AppMethodBeat.i(157235);
        SharedPreferences processSafePreferences = getProcessSafePreferences("UPDATEINFOTAG", 4);
        AppMethodBeat.o(157235);
        return processSafePreferences;
    }

    public static SharedPreferences getSharedPreferencesForVersionInfo() {
        AppMethodBeat.i(157236);
        SharedPreferences sharedPreferences = sApplicationContext.getSharedPreferences(SP_NAME_VERSION_INFO, 4);
        AppMethodBeat.o(157236);
        return sharedPreferences;
    }

    public static SharedPreferences getSharedPreferencesForLog() {
        AppMethodBeat.i(157237);
        if (sApplicationContext == null) {
            AppMethodBeat.o(157237);
            return null;
        }
        SharedPreferences mMKVSharedPreferencesEx = getMMKVSharedPreferencesEx("UPDATELOG", 4, true);
        AppMethodBeat.o(157237);
        return mMKVSharedPreferencesEx;
    }

    public static SharedPreferences getSharedPreferencesForPluginUpdateInfo() {
        AppMethodBeat.i(157238);
        if (sApplicationContext == null) {
            AppMethodBeat.o(157238);
            return null;
        }
        SharedPreferences processSafePreferences = getProcessSafePreferences(SP_NAME_PLUGIN_UPDATE_INFO, 4);
        AppMethodBeat.o(157238);
        return processSafePreferences;
    }

    public static SharedPreferences getSharedPreferencesForPluginVersionInfo(String str) {
        AppMethodBeat.i(157239);
        if (sApplicationContext == null) {
            AppMethodBeat.o(157239);
            return null;
        }
        SharedPreferences processSafePreferences = getProcessSafePreferences(SP_NAME_PLUGIN_VERSION_INFO_PREFIX.concat(String.valueOf(str)), 4);
        AppMethodBeat.o(157239);
        return processSafePreferences;
    }

    public static int getInstalledPluginVersion(Context context, String str) {
        AppMethodBeat.i(157240);
        if (context == null) {
            Log.e(TAG, "getInstalledPluginVersion, context is null");
            AppMethodBeat.o(157240);
            return -2;
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences(SP_NAME_PLUGIN_VERSION_INFO_PREFIX.concat(String.valueOf(str)), 4);
        if (sharedPreferences == null) {
            Log.e(TAG, "getInstalledPluginVersion, sp is null");
            AppMethodBeat.o(157240);
            return -3;
        }
        int i2 = sharedPreferences.getInt(SP_KEY_PLUGIN_AVAILABLE_VERSION, -1);
        AppMethodBeat.o(157240);
        return i2;
    }

    public static SharedPreferences getSharedPreferencesForFileReaderRecord() {
        AppMethodBeat.i(157241);
        if (sApplicationContext == null) {
            AppMethodBeat.o(157241);
            return null;
        }
        SharedPreferences processSafePreferences = getProcessSafePreferences(SP_NAME_FILE_READER_RECORD, 4);
        AppMethodBeat.o(157241);
        return processSafePreferences;
    }

    public static String getPluginUpdateConfigFilePath() {
        AppMethodBeat.i(157242);
        if (sApplicationContext == null) {
            AppMethodBeat.o(157242);
            return "";
        }
        String str = getUpdateConfigDir() + File.separator + XWALK_PLUGIN_UPDATE_CONFIG_NAME;
        AppMethodBeat.o(157242);
        return str;
    }

    public static String getPluginBaseDir() {
        AppMethodBeat.i(157243);
        if (sApplicationContext == null) {
            AppMethodBeat.o(157243);
            return "";
        }
        String absolutePath = sApplicationContext.getDir(XWALK_PLUGIN_BASE_DIR, 0).getAbsolutePath();
        AppMethodBeat.o(157243);
        return absolutePath;
    }

    public static Context getApplicationContext() {
        return sApplicationContext;
    }

    public static SharedPreferences getSharedPreferences() {
        AppMethodBeat.i(157244);
        SharedPreferences sharedPreferences = sApplicationContext.getSharedPreferences("libxwalkcore", 4);
        AppMethodBeat.o(157244);
        return sharedPreferences;
    }

    public static boolean isCurrentVersionSupportExtendPluginForAppbrand() {
        AppMethodBeat.i(157245);
        if (!hasAvailableVersion() || getAvailableVersion() < 300) {
            AppMethodBeat.o(157245);
            return false;
        }
        AppMethodBeat.o(157245);
        return true;
    }

    public static boolean isCurrentVersionSupportMapExtendPluginForAppbrand() {
        AppMethodBeat.i(157246);
        if (!hasAvailableVersion() || !getFeatureSupport(1011)) {
            AppMethodBeat.o(157246);
            return false;
        }
        AppMethodBeat.o(157246);
        return true;
    }

    public static boolean isCurrentVersionSupportCustomContext() {
        AppMethodBeat.i(157247);
        if (!hasAvailableVersion() || !getFeatureSupport(1020)) {
            AppMethodBeat.o(157247);
            return false;
        }
        AppMethodBeat.o(157247);
        return true;
    }

    public static boolean isCurrentVersionSupportCustomTextAreaForAppbrand() {
        AppMethodBeat.i(157248);
        if (!hasAvailableVersion() || !getFeatureSupport(1012)) {
            AppMethodBeat.o(157248);
            return false;
        }
        AppMethodBeat.o(157248);
        return true;
    }

    public static boolean isCurrentVersionSupportForceDarkMode() {
        AppMethodBeat.i(157249);
        if (!hasAvailableVersion() || !getFeatureSupport(1021)) {
            AppMethodBeat.o(157249);
            return false;
        }
        AppMethodBeat.o(157249);
        return true;
    }

    public static boolean isCurrentVersionSupportNativeView() {
        AppMethodBeat.i(183534);
        if (!hasAvailableVersion() || !getFeatureSupport(1013)) {
            AppMethodBeat.o(183534);
            return false;
        }
        AppMethodBeat.o(183534);
        return true;
    }

    public static boolean isCurrentVersionSupportScreenshotForSameLayer() {
        AppMethodBeat.i(183535);
        if (!hasAvailableVersion() || !getFeatureSupport(2010)) {
            AppMethodBeat.o(183535);
            return false;
        }
        AppMethodBeat.o(183535);
        return true;
    }

    public static void setForceDarkMode(boolean z) {
        AppMethodBeat.i(157250);
        sIsForceDarkMode = z;
        Log.i(TAG, "setForceDarkMode forceDarkMode:".concat(String.valueOf(z)));
        l.g(WebView.c.WV_KIND_CW).excute("STR_CMD_FORCE_DARK_MODE_COMMAND", new Object[]{Boolean.valueOf(sIsForceDarkMode)});
        AppMethodBeat.o(157250);
    }

    public static boolean getForceDarkMode() {
        return sIsForceDarkMode;
    }

    public static void setForceDarkBehavior(ForceDarkBehavior forceDarkBehavior) {
        AppMethodBeat.i(157251);
        switch (forceDarkBehavior) {
            case FORCE_DARK_ONLY:
                sForceDarkBehavior = 0;
                break;
            case MEDIA_QUERY_ONLY:
                sForceDarkBehavior = 1;
                break;
            case PREFER_MEDIA_QUERY_OVER_FORCE_DARK:
                sForceDarkBehavior = 2;
                break;
        }
        Log.i(TAG, "setForceDarkMode forceDarkBehavior:".concat(String.valueOf(forceDarkBehavior)));
        l.g(WebView.c.WV_KIND_CW).excute("STR_CMD_FORCE_DARK_MODE_BEHAVIOR_COMMAND", new Object[]{Integer.valueOf(sForceDarkBehavior)});
        AppMethodBeat.o(157251);
    }

    public static int getForceDarkBehavior() {
        return sForceDarkBehavior;
    }

    public static void setUsingCustomContext(boolean z) {
        AppMethodBeat.i(157252);
        sUsingCustomContext = z;
        Log.i(TAG, "setUsingCustomContext usingCustomContext:".concat(String.valueOf(z)));
        AppMethodBeat.o(157252);
    }

    public static boolean getUsingCustomContext() {
        return sUsingCustomContext;
    }

    private static boolean getFeatureSupport(int i2) {
        AppMethodBeat.i(157253);
        boolean booleanValue = ((Boolean) l.g(WebView.c.WV_KIND_CW).excute("STR_CMD_FEATURE_SUPPORT", new Object[]{Integer.valueOf(i2)})).booleanValue();
        AppMethodBeat.o(157253);
        return booleanValue;
    }

    public static boolean hasAvailableVersion() {
        AppMethodBeat.i(157254);
        if (49 > getAvailableVersion()) {
            AppMethodBeat.o(157254);
            return false;
        }
        AppMethodBeat.o(157254);
        return true;
    }

    public static boolean hasInstalledAvailableVersion() {
        AppMethodBeat.i(219108);
        if (49 > getInstalledNewstVersionForCurAbi()) {
            AppMethodBeat.o(219108);
            return false;
        }
        AppMethodBeat.o(219108);
        return true;
    }

    public static int getAvailableVersion() {
        if (sXWebCoreInfo == null) {
            return -1;
        }
        return sXWebCoreInfo.ver;
    }

    public static int getInstalledNewstVersion(String str) {
        AppMethodBeat.i(157255);
        int i2 = XWebCoreInfo.getBackupCoreInfo(str).ver;
        AppMethodBeat.o(157255);
        return i2;
    }

    public static int getInstalledNewstVersionForCurAbi() {
        AppMethodBeat.i(157256);
        int installedNewstVersion = getInstalledNewstVersion(getRuntimeAbi());
        AppMethodBeat.o(157256);
        return installedNewstVersion;
    }

    public static int getInstalledNewstVersionForPredownAbi() {
        AppMethodBeat.i(219109);
        String runtimeAbi = getRuntimeAbi();
        String str = RUNTIME_ABI_ARM32_STR;
        if (RUNTIME_ABI_ARM32_STR.equalsIgnoreCase(runtimeAbi)) {
            str = RUNTIME_ABI_ARM64_STR;
        }
        int installedNewstVersion = getInstalledNewstVersion(str);
        AppMethodBeat.o(219109);
        return installedNewstVersion;
    }

    public static int getInstalledNewstVersion(Context context) {
        AppMethodBeat.i(157257);
        if (context == null) {
            AppMethodBeat.o(157257);
            return 0;
        }
        int curAbiInstalledNewestVersion = XWebCoreInfo.getCurAbiInstalledNewestVersion(context);
        AppMethodBeat.o(157257);
        return curAbiInstalledNewestVersion;
    }

    public static String getAvailableVersionDetail() {
        if (sXWebCoreInfo != null) {
            return sXWebCoreInfo.verDetail;
        }
        return "";
    }

    public static boolean setAvailableVersion(int i2, String str, String str2) {
        AppMethodBeat.i(157258);
        boolean versionForAbi = XWebCoreInfo.setVersionForAbi(i2, str, str2);
        AppMethodBeat.o(157258);
        return versionForAbi;
    }

    public static void refreshAvailableVersion() {
        AppMethodBeat.i(219110);
        XWebCoreInfo backupCoreInfo = XWebCoreInfo.getBackupCoreInfo(getRuntimeAbi());
        sXWebCoreInfo = backupCoreInfo;
        if (backupCoreInfo.ver != -1) {
            getSharedPreferences().edit().putString("XWALK_CORE_EXTRACTED_DIR", getExtractedCoreDir(sXWebCoreInfo.ver)).commit();
        }
        AppMethodBeat.o(219110);
    }

    public static String getVesionDir(int i2) {
        AppMethodBeat.i(157259);
        String absolutePath = sApplicationContext.getDir(XWALK_CORE_NAME_PREFIX.concat(String.valueOf(i2)), 0).getAbsolutePath();
        File file = new File(absolutePath);
        if (!file.exists()) {
            file.mkdirs();
        }
        AppMethodBeat.o(157259);
        return absolutePath;
    }

    public static void clearAllVersion(Context context) {
        AppMethodBeat.i(157260);
        if (context == null || context.getApplicationInfo() == null || context.getApplicationInfo().dataDir == null) {
            AppMethodBeat.o(157260);
            return;
        }
        File[] listFiles = new File(context.getApplicationInfo().dataDir).listFiles();
        if (listFiles == null) {
            AppMethodBeat.o(157260);
            return;
        }
        for (File file : listFiles) {
            if (file.getName().startsWith("app_xwalk_") && file.isDirectory()) {
                c.bsB(file.getAbsolutePath());
            }
        }
        setAvailableVersion(-1, "", RUNTIME_ABI_ARM32_STR);
        setAvailableVersion(-1, "", RUNTIME_ABI_ARM64_STR);
        AppMethodBeat.o(157260);
    }

    public static void addXWalkInitializeLog(String str, String str2) {
        AppMethodBeat.i(157261);
        addXWalkInitializeLog(str + ": " + str2);
        AppMethodBeat.o(157261);
    }

    public static void addXWalkInitializeLog(String str) {
        AppMethodBeat.i(157262);
        if (str == null || str.isEmpty()) {
            AppMethodBeat.o(157262);
            return;
        }
        Log.i("XWalkUpdater", str);
        if (!isTurnOnKVLog) {
            AppMethodBeat.o(157262);
            return;
        }
        SharedPreferences sharedPreferencesForLog = getSharedPreferencesForLog();
        String str2 = (sPid + getModuleName() + ":" + new SimpleDateFormat("MM-dd hh:mm:ss").format(new Date()) + " : " + str) + "\n" + sharedPreferencesForLog.getString("log", "");
        if (str2.length() > 10240) {
            str2 = str2.substring(0, 5120);
        }
        sharedPreferencesForLog.edit().putString("log", str2).apply();
        AppMethodBeat.o(157262);
    }

    public static int getGrayValue() {
        AppMethodBeat.i(157263);
        if (s_grayValue != 0) {
            int i2 = s_grayValue;
            AppMethodBeat.o(157263);
            return i2;
        }
        try {
            int i3 = getSharedPreferences().getInt(SP_KEY_GRAY_VALUE_TEST, -1);
            s_grayValue = i3;
            if (i3 <= 0) {
                s_grayValue = getSharedPreferences().getInt(SP_KEY_GRAY_VALUE, -1);
            }
            if (s_grayValue <= 0) {
                s_grayValue = getDeviceRd();
            }
        } catch (Exception e2) {
            Log.e(TAG, "match gray rate exception: " + e2.getMessage());
        }
        int i4 = s_grayValue;
        AppMethodBeat.o(157263);
        return i4;
    }

    public static void setTodayGrayValueForTest(int i2) {
        AppMethodBeat.i(219111);
        s_todayGrayValue = i2;
        s_todayDate = new SimpleDateFormat("yyyyMMdd").format(new Date());
        AppMethodBeat.o(219111);
    }

    public static int getTodayGrayValue() {
        AppMethodBeat.i(219112);
        String format = new SimpleDateFormat("yyyyMMdd").format(new Date());
        if (s_todayGrayValue == 0 || !format.equals(s_todayDate)) {
            s_todayDate = format;
            int userId = getUserId();
            if (userId == 0) {
                userId = getGrayValue();
            }
            try {
                byte[] digest = MessageDigest.getInstance("MD5").digest(((Util.MAX_32BIT_VALUE & ((long) userId)) + "@" + format).getBytes());
                if (digest == null || digest.length <= 3) {
                    s_todayGrayValue = userId;
                    AppMethodBeat.o(219112);
                    return userId;
                }
                int i2 = ((digest[0] & Byte.MAX_VALUE) << 24) | (digest[3] & 255) | ((digest[2] & 255) << 8) | ((digest[1] & 255) << 16);
                if (i2 == 0) {
                    s_todayGrayValue = userId;
                    AppMethodBeat.o(219112);
                    return userId;
                }
                s_todayGrayValue = (i2 % 10000) + 1;
                int i3 = s_todayGrayValue;
                AppMethodBeat.o(219112);
                return i3;
            } catch (Exception e2) {
                s_todayGrayValue = userId;
            }
        } else {
            int i4 = s_todayGrayValue;
            AppMethodBeat.o(219112);
            return i4;
        }
    }

    public static int getTodayGrayValueByKey(String str) {
        AppMethodBeat.i(219113);
        String format = new SimpleDateFormat("yyyyMMdd").format(new Date());
        int userId = getUserId();
        if (userId == 0) {
            userId = getGrayValue();
        }
        try {
            byte[] digest = MessageDigest.getInstance("MD5").digest(((Util.MAX_32BIT_VALUE & ((long) userId)) + "@" + format + "key=" + str).getBytes());
            if (digest == null || digest.length <= 3) {
                int i2 = s_todayGrayValue;
                AppMethodBeat.o(219113);
                return i2;
            }
            int i3 = ((digest[0] & Byte.MAX_VALUE) << 24) | (digest[3] & 255) | ((digest[2] & 255) << 8) | ((digest[1] & 255) << 16);
            if (i3 == 0) {
                int i4 = s_todayGrayValue;
                AppMethodBeat.o(219113);
                return i4;
            }
            int i5 = (i3 % 10000) + 1;
            AppMethodBeat.o(219113);
            return i5;
        } catch (Exception e2) {
            int i6 = s_todayGrayValue;
            AppMethodBeat.o(219113);
            return i6;
        }
    }

    public static String getXWalkInitializeLog() {
        AppMethodBeat.i(157264);
        SharedPreferences sharedPreferencesForLog = getSharedPreferencesForLog();
        if (sharedPreferencesForLog == null) {
            AppMethodBeat.o(157264);
            return "";
        }
        String string = sharedPreferencesForLog.getString("log", "");
        AppMethodBeat.o(157264);
        return string;
    }

    public static String getUpdateConfigDir() {
        AppMethodBeat.i(157265);
        String absolutePath = sApplicationContext.getDir(XWALK_UPDATE_CONFIG_DIR, 0).getAbsolutePath();
        AppMethodBeat.o(157265);
        return absolutePath;
    }

    public static String getUpdateConfigFullPath() {
        AppMethodBeat.i(157266);
        String str = getUpdateConfigDir() + File.separator + "updateConfg.xml";
        AppMethodBeat.o(157266);
        return str;
    }

    public static String getExtractedCoreDir(int i2) {
        AppMethodBeat.i(157267);
        String str = getVesionDir(i2) + File.separator + XWALK_CORE_EXTRACTED_DIR;
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        AppMethodBeat.o(157267);
        return str;
    }

    public static String getExtractedCoreFile(int i2, String str) {
        AppMethodBeat.i(157268);
        String str2 = getVesionDir(i2) + File.separator + XWALK_CORE_EXTRACTED_DIR;
        File file = new File(str2);
        if (!file.exists()) {
            file.mkdirs();
        }
        String str3 = str2 + File.separator + str;
        AppMethodBeat.o(157268);
        return str3;
    }

    public static String getOptimizedDexDir(int i2) {
        AppMethodBeat.i(157269);
        String str = getVesionDir(i2) + File.separator + "dex";
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        AppMethodBeat.o(157269);
        return str;
    }

    public static String getDownloadZipDir(int i2) {
        AppMethodBeat.i(157270);
        String str = getVesionDir(i2) + File.separator + ZIP_DIR;
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        String str2 = str + File.separator + XWALK_CORE_ZIP_NAME;
        AppMethodBeat.o(157270);
        return str2;
    }

    public static String getPatchZipTempDecompressPath(int i2) {
        AppMethodBeat.i(157271);
        String str = getVesionDir(i2) + File.separator + PATCH_ZIP_TEMP_DECOMPRESS_DIR;
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        AppMethodBeat.o(157271);
        return str;
    }

    public static String getPatchZipTempDecompressFilePath(int i2, String str) {
        AppMethodBeat.i(157272);
        String str2 = getVesionDir(i2) + File.separator + PATCH_ZIP_TEMP_DECOMPRESS_DIR;
        File file = new File(str2);
        if (!file.exists()) {
            file.mkdirs();
        }
        String str3 = str2 + File.separator + str;
        AppMethodBeat.o(157272);
        return str3;
    }

    public static String getDownloadZipFileListConfig(int i2) {
        AppMethodBeat.i(157273);
        String extractedCoreFile = getExtractedCoreFile(i2, XWALK_CORE_FILELIST_CONFIG_NAME);
        AppMethodBeat.o(157273);
        return extractedCoreFile;
    }

    public static String getDownloadResFileListConfig(int i2) {
        AppMethodBeat.i(157274);
        String extractedCoreFile = getExtractedCoreFile(i2, XWALK_CORE_RES_FILELIST_CONFIG_NAME);
        AppMethodBeat.o(157274);
        return extractedCoreFile;
    }

    public static String getPatchFileListConfig(int i2) {
        AppMethodBeat.i(157275);
        String patchZipTempDecompressFilePath = getPatchZipTempDecompressFilePath(i2, XWALK_CORE_FILELIST_CONFIG_NAME);
        AppMethodBeat.o(157275);
        return patchZipTempDecompressFilePath;
    }

    public static String getPatchConfig(int i2) {
        AppMethodBeat.i(157276);
        String patchZipTempDecompressFilePath = getPatchZipTempDecompressFilePath(i2, XWALK_CORE_PATCH_CONFIG_NAME);
        AppMethodBeat.o(157276);
        return patchZipTempDecompressFilePath;
    }

    public static String getDownloadApkDir(int i2) {
        AppMethodBeat.i(157277);
        String str = getVesionDir(i2) + File.separator + APK_DIR;
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        AppMethodBeat.o(157277);
        return str;
    }

    public static String getDownloadApkPath(int i2) {
        AppMethodBeat.i(157278);
        String str = getVesionDir(i2) + File.separator + APK_DIR;
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        String str2 = str + File.separator + XWALK_CORE_APK_NAME;
        AppMethodBeat.o(157278);
        return str2;
    }

    public static String getDownloadPatchPath(int i2) {
        AppMethodBeat.i(157279);
        String str = getVesionDir(i2) + File.separator + APK_DIR;
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        String str2 = str + File.separator + XWALK_CORE_PATCH_NAME;
        AppMethodBeat.o(157279);
        return str2;
    }

    public static String getClassDexFilePath(int i2) {
        AppMethodBeat.i(157280);
        String str = getExtractedCoreDir(i2) + File.separator + "classes.dex";
        AppMethodBeat.o(157280);
        return str;
    }

    public static boolean isInTestMode() {
        AppMethodBeat.i(157281);
        String testDownLoadUrl = getTestDownLoadUrl(getApplicationContext());
        if (testDownLoadUrl == null || testDownLoadUrl.isEmpty()) {
            AppMethodBeat.o(157281);
            return false;
        }
        AppMethodBeat.o(157281);
        return true;
    }

    public static int getChromiunVersion() {
        AppMethodBeat.i(157282);
        if (sNChromiuVersion < 0) {
            sNChromiuVersion = _getChromiunVersion();
        }
        int i2 = sNChromiuVersion;
        AppMethodBeat.o(157282);
        return i2;
    }

    public static int safeGetChromiunVersion() {
        int verFromVersionName;
        AppMethodBeat.i(157283);
        if (sNChromiuVersion < 0) {
            try {
                PackageInfo packageInfo = getApplicationContext().getPackageManager().getPackageInfo("com.google.android.webview", 0);
                if (packageInfo != null && (verFromVersionName = getVerFromVersionName(packageInfo.versionName)) > 0) {
                    sNChromiuVersion = verFromVersionName;
                    AppMethodBeat.o(157283);
                    return verFromVersionName;
                }
            } catch (Exception e2) {
                Log.e(TAG, "Android System WebView is not found");
            }
        }
        int i2 = sNChromiuVersion;
        AppMethodBeat.o(157283);
        return i2;
    }

    static boolean runnintOnUiThread() {
        AppMethodBeat.i(219114);
        if (Looper.getMainLooper() == Looper.myLooper()) {
            AppMethodBeat.o(219114);
            return true;
        }
        AppMethodBeat.o(219114);
        return false;
    }

    static int _getChromiunVersion() {
        int verFromVersionName;
        AppMethodBeat.i(157284);
        try {
            PackageInfo packageInfo = getApplicationContext().getPackageManager().getPackageInfo("com.google.android.webview", 0);
            if (packageInfo != null && (verFromVersionName = getVerFromVersionName(packageInfo.versionName)) > 0) {
                AppMethodBeat.o(157284);
                return verFromVersionName;
            }
        } catch (Exception e2) {
            Log.e(TAG, "Android System WebView is not found");
        }
        try {
            if (!runnintOnUiThread()) {
                Log.e(TAG, "_getChromiunVersion NOT IN UI THREAD");
                AppMethodBeat.o(157284);
                return 0;
            }
            String userAgentString = new android.webkit.WebView(getApplicationContext()).getSettings().getUserAgentString();
            if (userAgentString != null) {
                String[] split = userAgentString.split("Chrome/");
                if (split == null || split.length == 0 || (split.length == 1 && split[0].length() == userAgentString.length())) {
                    AppMethodBeat.o(157284);
                    return 0;
                }
                int verFromVersionName2 = getVerFromVersionName(split[1]);
                AppMethodBeat.o(157284);
                return verFromVersionName2;
            }
            AppMethodBeat.o(157284);
            return 0;
        } catch (Exception e3) {
            Log.e(TAG, "Android System WebView is not found " + e3.getMessage());
        }
    }

    static int getVerFromVersionName(String str) {
        int i2 = 0;
        AppMethodBeat.i(157285);
        if (str == null || str.isEmpty()) {
            AppMethodBeat.o(157285);
        } else {
            try {
                i2 = Integer.parseInt(str.split("\\.")[0]);
                AppMethodBeat.o(157285);
            } catch (Exception e2) {
                Log.e(TAG, "parse to int error str is :".concat(String.valueOf(str)));
                AppMethodBeat.o(157285);
            }
        }
        return i2;
    }

    public static String getTestDownLoadUrl(Context context) {
        AppMethodBeat.i(157286);
        String string = getMMKVSharedTransportOld("TESTXWEB").getString("XWEB_TEST_CONFIG_URL", "");
        AppMethodBeat.o(157286);
        return string;
    }

    public static void setTestDownLoadUrl(Context context, String str) {
        AppMethodBeat.i(157287);
        sXWalkDownConfigUrl = null;
        if (str == null || str.isEmpty()) {
            getMMKVSharedTransportOld("TESTXWEB").edit().putString("XWEB_TEST_CONFIG_URL", "").commit();
            getXWalkUpdateConfigUrl();
            AppMethodBeat.o(157287);
            return;
        }
        getMMKVSharedTransportOld("TESTXWEB").edit().putString("XWEB_TEST_CONFIG_URL", str).commit();
        getXWalkUpdateConfigUrl();
        AppMethodBeat.o(157287);
    }

    public static synchronized void setTempUpdateConfigUrl(String str) {
        synchronized (XWalkEnvironment.class) {
            sStrTempUpdateConfigUrl = str;
        }
    }

    public static synchronized boolean setTempUpdateConfigUrl(String str, String str2) {
        boolean z = false;
        synchronized (XWalkEnvironment.class) {
            AppMethodBeat.i(219115);
            if (!TextUtils.isEmpty(str2)) {
                try {
                    if (new Date().after(new SimpleDateFormat("yyyyMMdd").parse(str2))) {
                        Log.i(TAG, "today is after enddate set tempConfig failed ");
                        AppMethodBeat.o(219115);
                    }
                } catch (Exception e2) {
                    Log.e(TAG, "parse strEndDate failed , set url failed  ");
                    AppMethodBeat.o(219115);
                }
            }
            sStrTempUpdateConfigUrl = str;
            z = true;
            AppMethodBeat.o(219115);
        }
        return z;
    }

    public static synchronized String getTempUpdateConfigUrl() {
        String str;
        synchronized (XWalkEnvironment.class) {
            str = sStrTempUpdateConfigUrl;
        }
        return str;
    }

    public static boolean isValidConfigHost(String str) {
        AppMethodBeat.i(157288);
        if (str == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str.trim())) {
            AppMethodBeat.o(157288);
            return false;
        }
        try {
            URI uri = new URI(str.trim());
            if (!uri.getScheme().equals("https")) {
                AppMethodBeat.o(157288);
                return false;
            } else if (!uri.getHost().equals("dldir1.qq.com")) {
                AppMethodBeat.o(157288);
                return false;
            } else {
                AppMethodBeat.o(157288);
                return true;
            }
        } catch (Exception e2) {
            Log.e(TAG, "java.net.URI new crashed ");
            AppMethodBeat.o(157288);
            return false;
        }
    }

    public static String getXWalkUpdateConfigUrl() {
        AppMethodBeat.i(157289);
        String testDownLoadUrl = getTestDownLoadUrl(getApplicationContext());
        sXWalkDownConfigUrl = testDownLoadUrl;
        if (isValidConfigHost(testDownLoadUrl)) {
            addXWalkInitializeLog("use test config url : " + sXWalkDownConfigUrl);
        } else {
            String tempUpdateConfigUrl = getTempUpdateConfigUrl();
            sXWalkDownConfigUrl = tempUpdateConfigUrl;
            if (isValidConfigHost(tempUpdateConfigUrl)) {
                addXWalkInitializeLog("use temp config url : " + sXWalkDownConfigUrl);
            } else if (isIaDevice()) {
                sXWalkDownConfigUrl = DOWNLOAD_X86_CONFIG_URL;
            } else {
                sXWalkDownConfigUrl = DOWNLOAD_CONFIG_URL;
            }
        }
        Log.i(TAG, "use update config url = " + sXWalkDownConfigUrl);
        String str = sXWalkDownConfigUrl;
        AppMethodBeat.o(157289);
        return str;
    }

    public static SharedPreferences getSharedPreferencesForTestXWeb() {
        AppMethodBeat.i(157290);
        if (sApplicationContext == null) {
            Log.e(TAG, "getSharedPreferencesForTestXWeb context is null");
            AppMethodBeat.o(157290);
            return null;
        }
        SharedPreferences sharedPreferences = sApplicationContext.getSharedPreferences("TESTXWEB", 4);
        AppMethodBeat.o(157290);
        return sharedPreferences;
    }

    public static synchronized int getTempPluginUpdatePeriod() {
        int i2;
        synchronized (XWalkEnvironment.class) {
            i2 = sTempPluginUpdatePeriod;
        }
        return i2;
    }

    public static synchronized void setTempPluginUpdatePeriod(int i2) {
        synchronized (XWalkEnvironment.class) {
            sTempPluginUpdatePeriod = i2;
        }
    }

    public static int getPluginUpdatePeriod() {
        AppMethodBeat.i(157291);
        int tempPluginUpdatePeriod = getTempPluginUpdatePeriod();
        if (tempPluginUpdatePeriod > 0) {
            addXWalkInitializeLog("getPluginUpdatePeriod use tempPeriod = ".concat(String.valueOf(tempPluginUpdatePeriod)));
            AppMethodBeat.o(157291);
            return tempPluginUpdatePeriod;
        }
        int hsl = b.hsl();
        if (hsl > 0) {
            addXWalkInitializeLog("getPluginUpdatePeriod use cmdPeriod = ".concat(String.valueOf(hsl)));
            AppMethodBeat.o(157291);
            return hsl;
        }
        addXWalkInitializeLog("getPluginUpdatePeriod use defaultPeriod = 90000000");
        AppMethodBeat.o(157291);
        return XWALK_PLUGIN_UPDATE_PERIOD_DEFAULT;
    }

    public static synchronized String getTempPluginUpdateConfigUrl() {
        String str;
        synchronized (XWalkEnvironment.class) {
            str = sStrTempPluginUpdateConfigUrl;
        }
        return str;
    }

    public static synchronized void setTempPluginUpdateConfigUrl(String str) {
        synchronized (XWalkEnvironment.class) {
            sStrTempPluginUpdateConfigUrl = str;
        }
    }

    public static synchronized boolean setTempPluginUpdateConfigUrl(String str, String str2) {
        boolean z = false;
        synchronized (XWalkEnvironment.class) {
            AppMethodBeat.i(219116);
            if (!TextUtils.isEmpty(str2)) {
                try {
                    if (new Date().after(new SimpleDateFormat("yyyyMMdd").parse(str2))) {
                        Log.i(TAG, "today is after enddate set tempConfig failed ");
                        AppMethodBeat.o(219116);
                    }
                } catch (Exception e2) {
                    Log.e(TAG, "parse strEndDate failed , set url failed  ");
                    AppMethodBeat.o(219116);
                }
            }
            sStrTempPluginUpdateConfigUrl = str;
            z = true;
            AppMethodBeat.o(219116);
        }
        return z;
    }

    public static String getPluginConfigUrl() {
        AppMethodBeat.i(157292);
        String pluginTestConfigUrl = getPluginTestConfigUrl();
        if (isValidConfigHost(pluginTestConfigUrl)) {
            addXWalkInitializeLog("plugin use test config url: ".concat(String.valueOf(pluginTestConfigUrl)));
            AppMethodBeat.o(157292);
            return pluginTestConfigUrl;
        }
        String tempPluginUpdateConfigUrl = getTempPluginUpdateConfigUrl();
        if (isValidConfigHost(tempPluginUpdateConfigUrl)) {
            addXWalkInitializeLog("plugin use temp config url: ".concat(String.valueOf(tempPluginUpdateConfigUrl)));
            AppMethodBeat.o(157292);
            return tempPluginUpdateConfigUrl;
        }
        addXWalkInitializeLog("plugin use release config url: ".concat(String.valueOf(DOWNLOAD_PLUGIN_UPDATE_CONFIG_URL)));
        AppMethodBeat.o(157292);
        return DOWNLOAD_PLUGIN_UPDATE_CONFIG_URL;
    }

    public static String getPluginTestConfigUrl() {
        AppMethodBeat.i(157293);
        SharedPreferences sharedPreferencesForTestXWeb = getSharedPreferencesForTestXWeb();
        if (sharedPreferencesForTestXWeb == null) {
            Log.e(TAG, "hasPluginTestConfigUrl sp is null");
            AppMethodBeat.o(157293);
            return "";
        }
        String string = sharedPreferencesForTestXWeb.getString(SP_KEY_PLUGIN_TEST_CONFIG_URL, "");
        if (string == null) {
            AppMethodBeat.o(157293);
            return "";
        }
        String trim = string.trim();
        if (trim.isEmpty()) {
            AppMethodBeat.o(157293);
            return "";
        }
        AppMethodBeat.o(157293);
        return trim;
    }

    public static boolean setPluginTestConfigUrl(String str) {
        AppMethodBeat.i(157294);
        SharedPreferences sharedPreferencesForTestXWeb = getSharedPreferencesForTestXWeb();
        if (sharedPreferencesForTestXWeb == null) {
            Log.e(TAG, "setPluginTestConfigUrl sp is null");
            AppMethodBeat.o(157294);
            return false;
        }
        SharedPreferences.Editor edit = sharedPreferencesForTestXWeb.edit();
        if (str == null || str.trim().isEmpty()) {
            edit.remove(SP_KEY_PLUGIN_TEST_CONFIG_URL);
        } else {
            edit.putString(SP_KEY_PLUGIN_TEST_CONFIG_URL, str.trim());
        }
        boolean commit = edit.commit();
        AppMethodBeat.o(157294);
        return commit;
    }

    public static String getApplicationName() {
        AppMethodBeat.i(157295);
        if (sApplicationName == null) {
            try {
                PackageManager packageManager = sApplicationContext.getPackageManager();
                sApplicationName = (String) packageManager.getApplicationLabel(packageManager.getApplicationInfo(sApplicationContext.getPackageName(), 0));
            } catch (PackageManager.NameNotFoundException e2) {
            }
            if (sApplicationName == null || sApplicationName.isEmpty() || sApplicationName.matches(PACKAGE_RE)) {
                sApplicationName = "this application";
            }
            Log.d(TAG, "Crosswalk application name: " + sApplicationName);
        }
        String str = sApplicationName;
        AppMethodBeat.o(157295);
        return str;
    }

    public static boolean isDownloadMode() {
        AppMethodBeat.i(157296);
        boolean booleanValue = sIsDownloadMode.booleanValue();
        AppMethodBeat.o(157296);
        return booleanValue;
    }

    public static boolean isDownloadModeUpdate() {
        AppMethodBeat.i(157297);
        boolean booleanValue = sIsDownloadModeUpdate.booleanValue();
        AppMethodBeat.o(157297);
        return booleanValue;
    }

    public static boolean isIaDevice() {
        AppMethodBeat.i(157298);
        String deviceAbi = getDeviceAbi();
        if (deviceAbi.equals("x86") || deviceAbi.equals("x86_64")) {
            AppMethodBeat.o(157298);
            return true;
        }
        AppMethodBeat.o(157298);
        return false;
    }

    public static boolean is64bitDevice() {
        AppMethodBeat.i(157299);
        String deviceAbi = getDeviceAbi();
        if (deviceAbi.equals(RUNTIME_ABI_ARM64_STR) || deviceAbi.equals("x86_64")) {
            AppMethodBeat.o(157299);
            return true;
        }
        AppMethodBeat.o(157299);
        return false;
    }

    public static boolean is64bitApp() {
        AppMethodBeat.i(157300);
        String runtimeAbi = getRuntimeAbi();
        if (runtimeAbi.equals(RUNTIME_ABI_ARM64_STR) || runtimeAbi.equals("x86_64")) {
            AppMethodBeat.o(157300);
            return true;
        }
        AppMethodBeat.o(157300);
        return false;
    }

    public static boolean is64BitRuntime() {
        AppMethodBeat.i(157301);
        String runtimeAbi = getRuntimeAbi();
        if (RUNTIME_ABI_ARM64_STR.equalsIgnoreCase(runtimeAbi) || "x86_64".equalsIgnoreCase(runtimeAbi) || "mips64".equalsIgnoreCase(runtimeAbi)) {
            AppMethodBeat.o(157301);
            return true;
        }
        AppMethodBeat.o(157301);
        return false;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public static String getRuntimeAbi() {
        char c2;
        char c3;
        AppMethodBeat.i(157302);
        if (sRuntimeAbi == null) {
            try {
                String lowerCase = Build.CPU_ABI.toLowerCase();
                switch (lowerCase.hashCode()) {
                    case -806050265:
                        if (lowerCase.equals("x86_64")) {
                            c3 = 4;
                            break;
                        }
                        c3 = 65535;
                        break;
                    case -738963905:
                        if (lowerCase.equals("armeabi")) {
                            c3 = 0;
                            break;
                        }
                        c3 = 65535;
                        break;
                    case 117110:
                        if (lowerCase.equals("x86")) {
                            c3 = 3;
                            break;
                        }
                        c3 = 65535;
                        break;
                    case 145444210:
                        if (lowerCase.equals(RUNTIME_ABI_ARM32_STR)) {
                            c3 = 1;
                            break;
                        }
                        c3 = 65535;
                        break;
                    case 1431565292:
                        if (lowerCase.equals(RUNTIME_ABI_ARM64_STR)) {
                            c3 = 2;
                            break;
                        }
                        c3 = 65535;
                        break;
                    default:
                        c3 = 65535;
                        break;
                }
                switch (c3) {
                    case 0:
                    case 1:
                        sRuntimeAbi = RUNTIME_ABI_ARM32_STR;
                        break;
                    case 2:
                        sRuntimeAbi = RUNTIME_ABI_ARM64_STR;
                        break;
                    case 3:
                        sRuntimeAbi = "x86";
                        break;
                    case 4:
                        sRuntimeAbi = "x86_64";
                        break;
                    default:
                        sRuntimeAbi = lowerCase;
                        break;
                }
            } catch (Exception e2) {
                Log.e(TAG, "get abi from cpu_abi failed , err = " + e2.getMessage());
            }
            if (TextUtils.isEmpty(sRuntimeAbi)) {
                try {
                    String lowerCase2 = System.getProperty("os.arch").toLowerCase();
                    switch (lowerCase2.hashCode()) {
                        case -1409295825:
                            if (lowerCase2.equals("armv7l")) {
                                c2 = 6;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case -1221096139:
                            if (lowerCase2.equals("aarch64")) {
                                c2 = '\t';
                                break;
                            }
                            c2 = 65535;
                            break;
                        case -806050265:
                            if (lowerCase2.equals("x86_64")) {
                                c2 = 5;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case -738963905:
                            if (lowerCase2.equals("armeabi")) {
                                c2 = 7;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case 117046:
                            if (lowerCase2.equals("x64")) {
                                c2 = 4;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case 117110:
                            if (lowerCase2.equals("x86")) {
                                c2 = 0;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case 3178856:
                            if (lowerCase2.equals("i386")) {
                                c2 = 2;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case 3181739:
                            if (lowerCase2.equals("i686")) {
                                c2 = 1;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case 3222903:
                            if (lowerCase2.equals("ia32")) {
                                c2 = 3;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case 93084186:
                            if (lowerCase2.equals("arm64")) {
                                c2 = 11;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case 93086174:
                            if (lowerCase2.equals("armv8")) {
                                c2 = '\n';
                                break;
                            }
                            c2 = 65535;
                            break;
                        case 145444210:
                            if (lowerCase2.equals(RUNTIME_ABI_ARM32_STR)) {
                                c2 = '\b';
                                break;
                            }
                            c2 = 65535;
                            break;
                        default:
                            c2 = 65535;
                            break;
                    }
                    switch (c2) {
                        case 0:
                        case 1:
                        case 2:
                        case 3:
                            sRuntimeAbi = "x86";
                            break;
                        case 4:
                        case 5:
                            if (!is64bitDevice()) {
                                sRuntimeAbi = "x86";
                                break;
                            } else {
                                sRuntimeAbi = "x86_64";
                                break;
                            }
                        case 6:
                        case 7:
                        case '\b':
                            sRuntimeAbi = RUNTIME_ABI_ARM32_STR;
                            break;
                        case '\t':
                        case '\n':
                        case 11:
                            if (!is64bitDevice()) {
                                sRuntimeAbi = RUNTIME_ABI_ARM32_STR;
                                break;
                            } else {
                                sRuntimeAbi = RUNTIME_ABI_ARM64_STR;
                                break;
                            }
                        default:
                            sRuntimeAbi = "arch:".concat(String.valueOf(lowerCase2));
                            break;
                    }
                } catch (Exception e3) {
                    Log.e(TAG, "get abi from os.arch failed , err = " + e3.getMessage());
                }
            }
            if (sRuntimeAbi.equals(RUNTIME_ABI_ARM32_STR)) {
                if (isIaDevice()) {
                    sRuntimeAbi = "x86";
                }
            } else if (sRuntimeAbi.equals(RUNTIME_ABI_ARM64_STR) && isIaDevice()) {
                sRuntimeAbi = "x86_64";
            }
            Log.i(TAG, "Runtime ABI: " + sRuntimeAbi);
        }
        String str = sRuntimeAbi;
        AppMethodBeat.o(157302);
        return str;
    }

    public static int getDeviceRd() {
        AppMethodBeat.i(157303);
        if (sNDeviceRd <= 0) {
            int i2 = getSharedPreferences().getInt(SP_KEY_DEVICE_RD, -1);
            sNDeviceRd = i2;
            if (i2 <= 0) {
                sNDeviceRd = new Random().nextInt(10000000) + 1;
                getSharedPreferences().edit().putInt(SP_KEY_DEVICE_RD, sNDeviceRd).apply();
            }
        }
        int i3 = (sNDeviceRd % 10000) + 1;
        AppMethodBeat.o(157303);
        return i3;
    }

    public static void setGrayValueForTest(int i2) {
        AppMethodBeat.i(157304);
        if (i2 != 10001) {
            s_grayValue = i2 % 10000;
        }
        getSharedPreferences().edit().putInt(SP_KEY_GRAY_VALUE_TEST, s_grayValue).commit();
        AppMethodBeat.o(157304);
    }

    public static void setIpType(int i2) {
        AppMethodBeat.i(157305);
        int ipType = getIpType();
        if (i2 != ipType) {
            getSharedPreferences().edit().putInt(SP_KEY_IP_TYPE, i2).commit();
            addXWalkInitializeLog("setIpType", " to  ".concat(String.valueOf(i2)));
            if (ipType == 0 && i2 == 1) {
                com.tencent.xweb.util.h.OQ(197);
            } else if (ipType == 1 && i2 == 0) {
                com.tencent.xweb.util.h.OQ(198);
            }
            if (ipType > 0 || i2 > 0) {
                sBIsIpTypeChanged = true;
                l.g(WebView.c.WV_KIND_CW).excute("STR_CMD_SET_RECHECK_COMMAND", null);
            }
        }
        AppMethodBeat.o(157305);
    }

    public static int getIpType() {
        AppMethodBeat.i(157306);
        int i2 = getSharedPreferences().getInt(SP_KEY_IP_TYPE, -2);
        AppMethodBeat.o(157306);
        return i2;
    }

    public static int getUserType() {
        AppMethodBeat.i(157307);
        int ipType = getIpType();
        AppMethodBeat.o(157307);
        return ipType;
    }

    public static int getUserId() {
        AppMethodBeat.i(219117);
        int i2 = getMMKVSharedPreferences("XWEB_USER_INFO").getInt("USER_ID", 0);
        AppMethodBeat.o(219117);
        return i2;
    }

    public static void setUserId(int i2) {
        AppMethodBeat.i(219118);
        getMMKVSharedPreferences("XWEB_USER_INFO").edit().putInt("USER_ID", i2).commit();
        AppMethodBeat.o(219118);
    }

    public static void setGrayValueByUserId(int i2) {
        AppMethodBeat.i(157308);
        if (i2 == 0) {
            AppMethodBeat.o(157308);
            return;
        }
        setUserId(i2);
        try {
            byte[] digest = MessageDigest.getInstance("MD5").digest("xweb_gray_value".concat(String.valueOf(Util.MAX_32BIT_VALUE & ((long) i2))).getBytes());
            if (digest == null || digest.length <= 3) {
                AppMethodBeat.o(157308);
                return;
            }
            int i3 = ((digest[0] & Byte.MAX_VALUE) << 24) | (digest[3] & 255) | ((digest[2] & 255) << 8) | ((digest[1] & 255) << 16);
            if (i3 == 0) {
                AppMethodBeat.o(157308);
                return;
            }
            s_grayValue = (i3 % 10000) + 1;
            int i4 = getSharedPreferences().getInt(SP_KEY_GRAY_VALUE, -1);
            getSharedPreferences().edit().putInt(SP_KEY_GRAY_VALUE, s_grayValue).commit();
            if (i4 != s_grayValue) {
                Log.i(TAG, "gray value changed to " + s_grayValue);
                l.g(WebView.c.WV_KIND_CW).excute("STR_CMD_SET_RECHECK_COMMAND", null);
            }
            AppMethodBeat.o(157308);
        } catch (Exception e2) {
            s_grayValue = 0;
        }
    }

    public static String getDeviceId() {
        AppMethodBeat.i(157309);
        if (sStrDeviceId == null) {
            try {
                TelephonyManager telephonyManager = (TelephonyManager) getApplicationContext().getSystemService("phone");
                if (telephonyManager == null) {
                    sStrDeviceId = "";
                } else {
                    sStrDeviceId = telephonyManager.getDeviceId();
                }
            } catch (Exception e2) {
                sStrDeviceId = "";
                Log.e(TAG, "getDeviceId failed " + e2.getMessage());
            }
        }
        String str = sStrDeviceId;
        AppMethodBeat.o(157309);
        return str;
    }

    static void tryClose(Closeable closeable) {
        AppMethodBeat.i(157310);
        if (closeable == null) {
            AppMethodBeat.o(157310);
            return;
        }
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception e2) {
                Log.e(TAG, "closeable close  failed " + e2.getMessage());
                AppMethodBeat.o(157310);
                return;
            }
        }
        AppMethodBeat.o(157310);
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00d6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getDeviceAbi() {
        /*
        // Method dump skipped, instructions count: 230
        */
        throw new UnsupportedOperationException("Method not decompiled: org.xwalk.core.XWalkEnvironment.getDeviceAbi():java.lang.String");
    }

    private static String getApplicationMetaData(String str) {
        AppMethodBeat.i(157312);
        try {
            String obj = sApplicationContext.getPackageManager().getApplicationInfo(sApplicationContext.getPackageName(), 128).metaData.get(str).toString();
            AppMethodBeat.o(157312);
            return obj;
        } catch (PackageManager.NameNotFoundException | NullPointerException e2) {
            AppMethodBeat.o(157312);
            return null;
        }
    }

    public static boolean checkApiVersionBaseApkExist(int i2) {
        AppMethodBeat.i(157315);
        if (new File(getDownloadApkPath(i2)).exists()) {
            AppMethodBeat.o(157315);
            return true;
        }
        AppMethodBeat.o(157315);
        return false;
    }

    public static boolean delApiVersion(int i2) {
        AppMethodBeat.i(157317);
        boolean bsB = c.bsB(getVesionDir(i2));
        AppMethodBeat.o(157317);
        return bsB;
    }

    public static String getModuleName() {
        AppMethodBeat.i(157318);
        String processName = getProcessName();
        if (processName == null) {
            AppMethodBeat.o(157318);
            return "";
        } else if (processName.contains(":")) {
            String lowerCase = processName.substring(processName.lastIndexOf(":") + 1).toLowerCase();
            AppMethodBeat.o(157318);
            return lowerCase;
        } else if (processName.contains(".")) {
            String lowerCase2 = processName.substring(processName.lastIndexOf(".") + 1).toLowerCase();
            AppMethodBeat.o(157318);
            return lowerCase2;
        } else {
            AppMethodBeat.o(157318);
            return processName;
        }
    }

    public static String getSafeModuleForCommand(String str) {
        AppMethodBeat.i(219119);
        try {
            String moduleName = getModuleName();
            if ("tools".equalsIgnoreCase(moduleName) || "toolsmp".equalsIgnoreCase(moduleName) || "mm".equalsIgnoreCase(moduleName) || "support".equalsIgnoreCase(moduleName)) {
                Log.i(TAG, "getSafeModuleForCommand ".concat(String.valueOf(moduleName)));
                AppMethodBeat.o(219119);
                return moduleName;
            } else if (moduleName.startsWith("appbrand")) {
                Log.i(TAG, "getSafeModuleForCommand appbrand");
                AppMethodBeat.o(219119);
                return "appbrand";
            } else {
                Log.i(TAG, "getSafeModuleForCommand unknown " + moduleName + ", use defaultVal " + str);
                AppMethodBeat.o(219119);
                return str;
            }
        } catch (Exception e2) {
            Log.e(TAG, "getSafeModuleForCommand error, use defaultVal " + str + ", error info: ", e2);
            AppMethodBeat.o(219119);
            return str;
        }
    }

    public static String getProcessName() {
        AppMethodBeat.i(157319);
        if (!TextUtils.isEmpty(sStrCurentProcessName)) {
            String str = sStrCurentProcessName;
            AppMethodBeat.o(157319);
            return str;
        }
        Object xWebInitArgs = getXWebInitArgs(XWALK_ENV_MAP_KEY_PROCESSNAME);
        if (xWebInitArgs != null) {
            String obj = xWebInitArgs.toString();
            sStrCurentProcessName = obj;
            AppMethodBeat.o(157319);
            return obj;
        }
        getApplicationContext();
        String htT = f.htT();
        sStrCurentProcessName = htT;
        AppMethodBeat.o(157319);
        return htT;
    }

    public static ContentResolver getContentResolver() {
        AppMethodBeat.i(157320);
        if (sApplicationContext == null) {
            Log.e(TAG, "getContentResolver sApplicationContext is null");
            AppMethodBeat.o(157320);
            return null;
        }
        ContentResolver contentResolver = sApplicationContext.getContentResolver();
        AppMethodBeat.o(157320);
        return contentResolver;
    }

    public static Context getPackageContext(String str) {
        Context context = null;
        AppMethodBeat.i(157321);
        if (sApplicationContext == null) {
            Log.e(TAG, "getTargetPackageContext sApplicationContext is null");
            AppMethodBeat.o(157321);
        } else {
            try {
                context = sApplicationContext.createPackageContext(str, 2);
            } catch (Exception e2) {
                Log.e(TAG, e2.getMessage());
            }
            AppMethodBeat.o(157321);
        }
        return context;
    }

    public static boolean isSelfProvider() {
        AppMethodBeat.i(157322);
        if (sApplicationContext == null) {
            Log.e(TAG, "isSelfProvider sApplicationContext is null");
            AppMethodBeat.o(157322);
            return true;
        }
        boolean isProvider = isProvider(sApplicationContext.getPackageName());
        AppMethodBeat.o(157322);
        return isProvider;
    }

    public static boolean isProvider(String str) {
        AppMethodBeat.i(157323);
        if (str == null || str.isEmpty()) {
            Log.e(TAG, "isProvider packageName is null or empty");
            AppMethodBeat.o(157323);
            return false;
        }
        for (String str2 : XWALK_CORE_PROVIDER_LIST) {
            if (str2.equals(str)) {
                AppMethodBeat.o(157323);
                return true;
            }
        }
        AppMethodBeat.o(157323);
        return false;
    }

    public static String getPackageName() {
        AppMethodBeat.i(157324);
        if (sApplicationContext == null) {
            Log.e(TAG, "getPackageName sApplicationContext is null");
            AppMethodBeat.o(157324);
            return "";
        }
        String packageName = sApplicationContext.getPackageName();
        AppMethodBeat.o(157324);
        return packageName;
    }

    public static String getVesionDir(Context context, int i2) {
        AppMethodBeat.i(157325);
        if (context == null) {
            Log.e(TAG, "getVersionDir with context, context is null");
            AppMethodBeat.o(157325);
            return "";
        }
        String absolutePath = context.getDir(XWALK_CORE_NAME_PREFIX.concat(String.valueOf(i2)), 0).getAbsolutePath();
        AppMethodBeat.o(157325);
        return absolutePath;
    }

    public static String getDownloadApkPath(Context context, int i2) {
        AppMethodBeat.i(157326);
        if (context == null) {
            Log.e(TAG, "getDownloadApkPath with context, context is null");
            AppMethodBeat.o(157326);
            return "";
        }
        String vesionDir = getVesionDir(context, i2);
        if (vesionDir.isEmpty()) {
            Log.e(TAG, "getDownloadApkPath with context, versionDir is empty");
            AppMethodBeat.o(157326);
            return "";
        }
        String str = vesionDir + File.separator + APK_DIR + File.separator + XWALK_CORE_APK_NAME;
        AppMethodBeat.o(157326);
        return str;
    }

    public static String getExtractedCoreFile(Context context, int i2, String str) {
        AppMethodBeat.i(157327);
        if (context == null) {
            Log.e(TAG, "getExtractedCoreFile with context, context is null");
            AppMethodBeat.o(157327);
            return "";
        }
        String vesionDir = getVesionDir(context, i2);
        if (vesionDir.isEmpty()) {
            Log.e(TAG, "getExtractedCoreFile with context, versionDir is empty");
            AppMethodBeat.o(157327);
            return "";
        }
        String str2 = vesionDir + File.separator + XWALK_CORE_EXTRACTED_DIR + File.separator + str;
        AppMethodBeat.o(157327);
        return str2;
    }

    public static String getPatchZipTempDecompressFilePath(Context context, int i2, String str) {
        AppMethodBeat.i(157328);
        if (context == null) {
            Log.e(TAG, "getPatchZipTempDecompressFilePath with context, context is null");
            AppMethodBeat.o(157328);
            return "";
        }
        String vesionDir = getVesionDir(context, i2);
        if (vesionDir.isEmpty()) {
            Log.e(TAG, "getPatchZipTempDecompressFilePath with context, versionDir is empty");
            AppMethodBeat.o(157328);
            return "";
        }
        String str2 = vesionDir + File.separator + PATCH_ZIP_TEMP_DECOMPRESS_DIR + File.separator + str;
        AppMethodBeat.o(157328);
        return str2;
    }

    public static String getDownloadZipFileListConfig(Context context, int i2) {
        AppMethodBeat.i(157329);
        String extractedCoreFile = getExtractedCoreFile(context, i2, XWALK_CORE_FILELIST_CONFIG_NAME);
        AppMethodBeat.o(157329);
        return extractedCoreFile;
    }

    public static String getPatchFileListConfig(Context context, int i2) {
        AppMethodBeat.i(157330);
        String patchZipTempDecompressFilePath = getPatchZipTempDecompressFilePath(context, i2, XWALK_CORE_FILELIST_CONFIG_NAME);
        AppMethodBeat.o(157330);
        return patchZipTempDecompressFilePath;
    }

    public static int readAvailableVersionFromSP(Context context) {
        AppMethodBeat.i(157331);
        if (context == null) {
            Log.e(TAG, "readAvailableVersionFromSP context is null");
            AppMethodBeat.o(157331);
            return -1;
        }
        int curAbiInstalledNewestVersion = XWebCoreInfo.getCurAbiInstalledNewestVersion(context);
        AppMethodBeat.o(157331);
        return curAbiInstalledNewestVersion;
    }

    public static boolean isTestVersion(int i2) {
        return i2 >= 100000000;
    }

    public static SharedPreferences getSharedPreferencesForXWEBUpdater() {
        AppMethodBeat.i(157332);
        SharedPreferences mMKVSharedPreferencesEx = getMMKVSharedPreferencesEx("XWEB_UPDATER", 4, false);
        AppMethodBeat.o(157332);
        return mMKVSharedPreferencesEx;
    }

    public static Activity activityFromContext(Context context) {
        AppMethodBeat.i(157333);
        while (!(context instanceof Activity)) {
            if (context instanceof ContextWrapper) {
                context = ((ContextWrapper) context).getBaseContext();
                if (context == context) {
                    AppMethodBeat.o(157333);
                    return null;
                }
            } else {
                AppMethodBeat.o(157333);
                return null;
            }
        }
        Activity activity = (Activity) context;
        AppMethodBeat.o(157333);
        return activity;
    }

    public static void setConfigFetchPeriod(long j2) {
        sConfigPerios = j2;
    }

    public static long getConfigFetchPeriod() {
        return sConfigPerios;
    }

    public static synchronized void appendAppInfo(String str) {
        synchronized (XWalkEnvironment.class) {
            AppMethodBeat.i(219120);
            if (!sAppInfos.contains(str)) {
                sAppInfos.add(str);
            }
            AppMethodBeat.o(219120);
        }
    }

    public static String dumpAppInfo() {
        AppMethodBeat.i(219121);
        String str = "";
        Iterator<String> it = sAppInfos.iterator();
        while (it.hasNext()) {
            str = str + it.next() + ";";
        }
        AppMethodBeat.o(219121);
        return str;
    }

    public static synchronized boolean containsAppInfo(String str) {
        boolean z = false;
        synchronized (XWalkEnvironment.class) {
            AppMethodBeat.i(219122);
            String[] split = str.split("&");
            if (split != null && split.length != 0) {
                int length = split.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        AppMethodBeat.o(219122);
                        z = true;
                        break;
                    }
                    String str2 = split[i2];
                    if (!TextUtils.isEmpty(str2) && !sAppInfos.contains(str2.trim())) {
                        AppMethodBeat.o(219122);
                        break;
                    }
                    i2++;
                }
            } else {
                AppMethodBeat.o(219122);
                z = true;
            }
        }
        return z;
    }

    public static synchronized void setAppClientVersion(int i2) {
        synchronized (XWalkEnvironment.class) {
            sAppClientVersion = i2;
        }
    }

    public static synchronized int getAppClientVersion() {
        int i2;
        synchronized (XWalkEnvironment.class) {
            i2 = sAppClientVersion;
        }
        return i2;
    }
}
