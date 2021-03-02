package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.DexLoader;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.k;
import java.io.File;
import java.io.IOException;

public class TbsExtensionFunctionManager {
    public static final String BUGLY_SWITCH_FILE_NAME = "bugly_switch.txt";
    public static final String COOKIE_SWITCH_FILE_NAME = "cookie_switch.txt";
    public static final String DISABLE_GET_APK_VERSION_SWITCH_FILE_NAME = "disable_get_apk_version_switch.txt";
    public static final String DISABLE_UNPREINIT = "disable_unpreinit.txt";
    public static final String DISABLE_USE_HOST_BACKUP_CORE = "disable_use_host_backup_core.txt";
    public static final String SP_KEY_COOKIE_DB_VERSION = "cookie_db_version";
    public static final String SP_NAME_FOR_COOKIE = "cookie_compatiable";
    public static final int SWITCH_BYTE_COOKIE = 1;
    public static final int SWITCH_BYTE_DISABLE_GET_APK_VERSION = 2;
    public static final int SWITCH_BYTE_DISABLE_UNPREINIT = 4;
    public static final int SWITCH_BYTE_DISABLE_USE_HOST_BACKUPCORE = 8;
    public static final String USEX5_FILE_NAME = "usex5.txt";

    /* renamed from: b  reason: collision with root package name */
    private static TbsExtensionFunctionManager f1808b;

    /* renamed from: a  reason: collision with root package name */
    private boolean f1809a;

    private TbsExtensionFunctionManager() {
    }

    public static TbsExtensionFunctionManager getInstance() {
        AppMethodBeat.i(54674);
        if (f1808b == null) {
            synchronized (TbsExtensionFunctionManager.class) {
                try {
                    if (f1808b == null) {
                        f1808b = new TbsExtensionFunctionManager();
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(54674);
                    throw th;
                }
            }
        }
        TbsExtensionFunctionManager tbsExtensionFunctionManager = f1808b;
        AppMethodBeat.o(54674);
        return tbsExtensionFunctionManager;
    }

    public synchronized void initTbsBuglyIfNeed(Context context) {
        String absolutePath;
        AppMethodBeat.i(54675);
        if (this.f1809a) {
            AppMethodBeat.o(54675);
        } else if (!canUseFunction(context, BUGLY_SWITCH_FILE_NAME)) {
            TbsLog.i("TbsExtensionFunMana", "bugly is forbiden!!");
            AppMethodBeat.o(54675);
        } else {
            if (TbsShareManager.isThirdPartyApp(context)) {
                absolutePath = TbsShareManager.c(context);
            } else {
                File r = q.a().r(context);
                if (r == null) {
                    TbsLog.i("TbsExtensionFunMana", "getTbsCoreShareDir is null");
                }
                if (r.listFiles() == null || r.listFiles().length <= 0) {
                    TbsLog.i("TbsExtensionFunMana", "getTbsCoreShareDir is empty!");
                    AppMethodBeat.o(54675);
                } else {
                    absolutePath = r.getAbsolutePath();
                }
            }
            if (TextUtils.isEmpty(absolutePath)) {
                TbsLog.i("TbsExtensionFunMana", "bugly init ,corePath is null");
                AppMethodBeat.o(54675);
            } else {
                File r2 = q.a().r(context);
                if (r2 == null) {
                    TbsLog.i("TbsExtensionFunMana", "bugly init ,optDir is null");
                    AppMethodBeat.o(54675);
                } else {
                    File file = new File(absolutePath, "tbs_bugly_dex.jar");
                    TbsLog.d("TbsExtensionFunMana", "optDir:" + r2 + ",tbsCorePath:" + absolutePath + ",dexFile:" + file.getAbsolutePath());
                    try {
                        k.a(new DexLoader(file.getParent(), context, new String[]{file.getAbsolutePath()}, r2.getAbsolutePath(), QbSdk.getSettings()).loadClass("com.tencent.smtt.tbs.bugly.TBSBuglyManager"), "initBugly", (Class<?>[]) new Class[]{Context.class, String.class, String.class, String.class}, context, absolutePath, String.valueOf(WebView.getTbsSDKVersion(context)), String.valueOf(WebView.getTbsCoreVersion(context)));
                        this.f1809a = true;
                        TbsLog.i("TbsExtensionFunMana", "initTbsBuglyIfNeed success!");
                        AppMethodBeat.o(54675);
                    } catch (Throwable th) {
                        TbsLog.i("TbsExtensionFunMana", "bugly init ,try init bugly failed(need new core):" + Log.getStackTraceString(th));
                        AppMethodBeat.o(54675);
                    }
                }
            }
        }
    }

    public synchronized boolean setFunctionEnable(Context context, String str, boolean z) {
        boolean z2 = false;
        synchronized (this) {
            AppMethodBeat.i(54676);
            if (context == null) {
                AppMethodBeat.o(54676);
            } else {
                File file = new File(context.getFilesDir(), str);
                TbsLog.d("TbsExtensionFunMana", file.getAbsolutePath());
                if (z) {
                    if (!file.exists()) {
                        try {
                            if (file.createNewFile()) {
                                AppMethodBeat.o(54676);
                                z2 = true;
                            }
                        } catch (IOException e2) {
                            TbsLog.e("TbsExtensionFunMana", "setFunctionEnable,createNewFile fail:".concat(String.valueOf(str)));
                            AppMethodBeat.o(54676);
                        }
                    }
                } else if (file.exists()) {
                    if (file.delete()) {
                        AppMethodBeat.o(54676);
                        z2 = true;
                    } else {
                        TbsLog.e("TbsExtensionFunMana", "setFunctionEnable,file.delete fail:".concat(String.valueOf(str)));
                        AppMethodBeat.o(54676);
                    }
                }
                AppMethodBeat.o(54676);
                z2 = true;
            }
        }
        return z2;
    }

    public synchronized boolean canUseFunction(Context context, String str) {
        boolean z;
        AppMethodBeat.i(54677);
        File file = new File(context.getFilesDir(), str);
        if (!file.exists() || !file.isFile()) {
            z = false;
            AppMethodBeat.o(54677);
        } else {
            z = true;
            AppMethodBeat.o(54677);
        }
        return z;
    }

    public synchronized int getRomCookieDBVersion(Context context) {
        SharedPreferences sharedPreferences;
        int i2 = -1;
        synchronized (this) {
            AppMethodBeat.i(54678);
            if (Build.VERSION.SDK_INT >= 11) {
                sharedPreferences = context.getSharedPreferences(SP_NAME_FOR_COOKIE, 4);
            } else {
                sharedPreferences = context.getSharedPreferences(SP_NAME_FOR_COOKIE, 0);
            }
            if (sharedPreferences == null) {
                AppMethodBeat.o(54678);
            } else {
                i2 = sharedPreferences.getInt(SP_KEY_COOKIE_DB_VERSION, -1);
                AppMethodBeat.o(54678);
            }
        }
        return i2;
    }
}
