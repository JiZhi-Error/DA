package com.tencent.xweb.xwalk;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.facebook.internal.ServerProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.o.b.d;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import com.tencent.xweb.WebView;
import com.tencent.xweb.ah;
import com.tencent.xweb.internal.b;
import com.tencent.xweb.util.c;
import com.tencent.xweb.util.h;
import com.tencent.xweb.w;
import com.tencent.xweb.xwalk.updater.Scheduler;
import com.tencent.xweb.xwalk.updater.e;
import com.tencent.xweb.xwalk.updater.g;
import com.tencent.xweb.y;
import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkDecompressor;
import org.xwalk.core.XWalkEnvironment;
import org.xwalk.core.XWalkInitializer;
import org.xwalk.core.XWalkUpdater;

public class p implements XWalkInitializer.XWalkInitListener, XWalkUpdater.XWalkBackgroundUpdateListener {
    static p SHH;
    XWalkInitializer SHI;
    XWalkUpdater SHJ;
    protected Context mContext;

    public static class a implements w.b {
        @Override // com.tencent.xweb.w.b
        public final void b(Context context, HashMap<String, String> hashMap) {
            AppMethodBeat.i(154457);
            p.b(context, hashMap);
            AppMethodBeat.o(154457);
        }

        @Override // com.tencent.xweb.w.b
        public final boolean isBusy() {
            AppMethodBeat.i(154458);
            boolean isBusy = p.isBusy();
            AppMethodBeat.o(154458);
            return isBusy;
        }
    }

    public static void b(Context context, HashMap<String, String> hashMap) {
        AppMethodBeat.i(154459);
        if (SHH == null) {
            SHH = new p(context);
        }
        h.htW();
        String str = null;
        if (hashMap != null) {
            str = hashMap.get("UpdaterCheckType");
        }
        if ("4".equals(str)) {
            XWalkEnvironment.addXWalkInitializeLog("XWalkUpdaterImp", "check emebedinstall only");
            XWalkUpdater.tryInstallFromEmebed();
            AppMethodBeat.o(154459);
            return;
        }
        XWalkUpdater.tryInstallFromEmebed();
        SHH.C(hashMap);
        e.lJ(context);
        AppMethodBeat.o(154459);
    }

    public static void L(Context context, boolean z) {
        int i2;
        int i3;
        String[] split;
        AppMethodBeat.i(154460);
        SharedPreferences sharedPreferencesForUpdateConfig = XWalkEnvironment.getSharedPreferencesForUpdateConfig();
        if (sharedPreferencesForUpdateConfig == null) {
            AppMethodBeat.o(154460);
            return;
        }
        long j2 = sharedPreferencesForUpdateConfig.getLong("LAST_TRY_CLEAR_APK_TIME", 0);
        long currentTimeMillis = System.currentTimeMillis();
        if (z || currentTimeMillis < j2 || currentTimeMillis - j2 > 259200000) {
            if (context != null) {
                try {
                    if (!(context.getApplicationInfo() == null || context.getApplicationInfo().dataDir == null)) {
                        File[] listFiles = new File(context.getApplicationInfo().dataDir).listFiles();
                        if (listFiles == null) {
                            Log.e("XWalkUpdaterImp", "clearOldXWebCore failed , null == files ");
                        } else {
                            String nS = com.tencent.xweb.a.nS("KEEP_XWEB_CORE_LIST", "tools");
                            Log.i("XWalkUpdaterImp", "dump KEEP_XWEB_CORE_LIST: ".concat(String.valueOf(nS)));
                            HashSet hashSet = new HashSet();
                            if (!TextUtils.isEmpty(nS) && (split = nS.split(";")) != null) {
                                for (String str : split) {
                                    if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str.trim())) {
                                        hashSet.add(str.trim());
                                    }
                                }
                            }
                            int i4 = 0;
                            int i5 = 0;
                            int installedNewstVersionForCurAbi = XWalkEnvironment.getInstalledNewstVersionForCurAbi();
                            int length = listFiles.length;
                            int i6 = 0;
                            while (i6 < length) {
                                int am = am(listFiles[i6]);
                                if (am >= 0 && am != installedNewstVersionForCurAbi) {
                                    if (am >= i4) {
                                        i2 = i4;
                                        i3 = am;
                                    } else if (am >= i5) {
                                        i2 = am;
                                        i3 = i4;
                                    }
                                    i6++;
                                    i5 = i2;
                                    i4 = i3;
                                }
                                i2 = i5;
                                i3 = i4;
                                i6++;
                                i5 = i2;
                                i4 = i3;
                            }
                            int installedNewstVersion = XWalkEnvironment.getInstalledNewstVersion(XWalkEnvironment.RUNTIME_ABI_ARM32_STR);
                            int installedNewstVersion2 = XWalkEnvironment.getInstalledNewstVersion(XWalkEnvironment.RUNTIME_ABI_ARM64_STR);
                            for (File file : listFiles) {
                                int am2 = am(file);
                                if (!hashSet.contains(String.valueOf(am2)) && am2 > 0 && am2 < i5 && am2 != XWalkEnvironment.getAvailableVersion() && am2 != installedNewstVersion && am2 != installedNewstVersion2) {
                                    try {
                                        c.bsB(file.getAbsolutePath());
                                        XWalkEnvironment.addXWalkInitializeLog("XWalkUpdaterImp", "cleared version = ".concat(String.valueOf(am2)));
                                        h.s(577, 65, 1);
                                    } catch (Exception e2) {
                                        XWalkEnvironment.addXWalkInitializeLog("XWalkUpdaterImp", " FileUtils.deleteAll failed " + e2.getMessage());
                                        h.s(577, 66, 1);
                                    }
                                }
                            }
                        }
                        sharedPreferencesForUpdateConfig.edit().putLong("LAST_TRY_CLEAR_APK_TIME", currentTimeMillis).commit();
                    }
                } catch (Exception e3) {
                    Log.e("XWalkUpdaterImp", "tryClearOldXWebCore failed " + e3.getMessage());
                }
            }
            Log.e("XWalkUpdaterImp", "clearOldXWebCore failed , context");
            sharedPreferencesForUpdateConfig.edit().putLong("LAST_TRY_CLEAR_APK_TIME", currentTimeMillis).commit();
        }
        AppMethodBeat.o(154460);
    }

    private static boolean asX(int i2) {
        AppMethodBeat.i(154462);
        Log.i("XWalkUpdaterImp", "clearVersion start , nVersion = ".concat(String.valueOf(i2)));
        if (i2 <= 0) {
            Log.e("XWalkUpdaterImp", "clearVersion failed , nVersion is not valid ");
            AppMethodBeat.o(154462);
            return false;
        }
        Context applicationContext = XWalkEnvironment.getApplicationContext();
        if (applicationContext == null || applicationContext.getApplicationInfo() == null || applicationContext.getApplicationInfo().dataDir == null) {
            Log.e("XWalkUpdaterImp", "clearVersion failed , context = null");
            AppMethodBeat.o(154462);
            return false;
        }
        File[] listFiles = new File(applicationContext.getApplicationInfo().dataDir).listFiles();
        if (listFiles == null) {
            Log.e("XWalkUpdaterImp", "clearVersion failed , null == files ");
            AppMethodBeat.o(154462);
            return false;
        }
        for (File file : listFiles) {
            int am = am(file);
            if (am > 0 && am == i2 && c.bsB(file.getAbsolutePath())) {
                XWalkEnvironment.addXWalkInitializeLog("XWalkUpdaterImp", "cleared version = ".concat(String.valueOf(am)));
                AppMethodBeat.o(154462);
                return true;
            }
        }
        AppMethodBeat.o(154462);
        return false;
    }

    public static void lG(Context context) {
        AppMethodBeat.i(154463);
        Log.i("XWalkUpdaterImp", "try clear test setings");
        if (com.tencent.xweb.internal.c.cl("clear_test_settings", 2592000000L)) {
            Log.i("XWalkUpdaterImp", "do start clear test setings");
            try {
                y.hsF().a("tools", WebView.c.WV_KIND_NONE);
                y.hsF().a("appbrand", WebView.c.WV_KIND_NONE);
                y.hsF().a("support", WebView.c.WV_KIND_NONE);
                y.hsF().a("mm", WebView.c.WV_KIND_NONE);
                y.hsF().a("toolsmp", WebView.c.WV_KIND_NONE);
                y.hsF().b("tools", WebView.c.WV_KIND_NONE);
                y.hsF().b("appbrand", WebView.c.WV_KIND_NONE);
                y.hsF().b("support", WebView.c.WV_KIND_NONE);
                y.hsF().b("mm", WebView.c.WV_KIND_NONE);
                y.hsF().b("toolsmp", WebView.c.WV_KIND_NONE);
                XWalkEnvironment.setTestDownLoadUrl(context, null);
                XWalkEnvironment.setPluginTestConfigUrl("");
                AppMethodBeat.o(154463);
                return;
            } catch (Exception e2) {
                Log.e("XWalkUpdaterImp", "do start clear test setings got exp = " + e2.getMessage());
            }
        }
        AppMethodBeat.o(154463);
    }

    public static void huW() {
        AppMethodBeat.i(207310);
        if (!com.tencent.xweb.internal.c.cl("should_try_generate_jar", 172800000)) {
            AppMethodBeat.o(207310);
            return;
        }
        XWalkUpdater.try_generate_jar_for_dex_in_dir(XWalkEnvironment.getExtractedCoreDir(XWalkEnvironment.getInstalledNewstVersionForCurAbi()), false);
        AppMethodBeat.o(207310);
    }

    public static int aX(Context context, int i2) {
        int i3;
        boolean z = true;
        AppMethodBeat.i(154464);
        if (context == null || context.getApplicationInfo() == null || context.getApplicationInfo().dataDir == null) {
            XWalkEnvironment.addXWalkInitializeLog("revertToApkVer failed: bad context");
            AppMethodBeat.o(154464);
            return -1;
        }
        File[] listFiles = new File(context.getApplicationInfo().dataDir).listFiles();
        if (listFiles == null) {
            XWalkEnvironment.addXWalkInitializeLog("revertToApkVer failed files is null");
            AppMethodBeat.o(154464);
            return -1;
        }
        int installedNewstVersionForCurAbi = XWalkEnvironment.getInstalledNewstVersionForCurAbi();
        int length = listFiles.length;
        int i4 = 0;
        int i5 = -1;
        boolean z2 = false;
        while (i4 < length) {
            int am = am(listFiles[i4]);
            if (am >= 0) {
                if (am == i2) {
                    z2 = true;
                }
                if (am <= i2 && am >= 49 && am != installedNewstVersionForCurAbi && am > i5) {
                    i4++;
                    i5 = am;
                }
            }
            am = i5;
            i4++;
            i5 = am;
        }
        if (i5 <= 0) {
            z = false;
        }
        if (!z2) {
            XWalkEnvironment.addXWalkInitializeLog("revertToApkVer did not find target version:".concat(String.valueOf(i2)));
            if (!asY(i5)) {
                XWalkEnvironment.addXWalkInitializeLog("revertToApkVer nAvailableOldVer targetApk not exist");
                i3 = -1;
            }
            i3 = i5;
        } else if (asY(i2)) {
            XWalkEnvironment.addXWalkInitializeLog("revertToApkVer checkApkExist targetApk exist");
            i3 = i2;
        } else {
            if (!asY(i5)) {
                XWalkEnvironment.addXWalkInitializeLog("revertToApkVer nAvailableOldVer targetApk not exist");
                i3 = -1;
            }
            i3 = i5;
        }
        if (i3 == i2) {
            h.OQ(89);
        } else if (i3 > 0) {
            h.OQ(90);
        } else if (z) {
            h.OQ(92);
        } else {
            h.OQ(91);
        }
        XWalkEnvironment.addXWalkInitializeLog("revert from:" + XWalkEnvironment.getInstalledNewstVersionForCurAbi() + " to:" + i3);
        XWalkEnvironment.setAvailableVersion(i3, "revert from:" + XWalkEnvironment.getInstalledNewstVersionForCurAbi() + " to:" + i3, XWalkEnvironment.getRuntimeAbi());
        AppMethodBeat.o(154464);
        return i3;
    }

    private static boolean asY(int i2) {
        AppMethodBeat.i(154465);
        File asZ = asZ(i2);
        if (asZ == null) {
            Log.e("XWalkUpdaterImp", "checkfiles no config file");
            AppMethodBeat.o(154465);
            return false;
        }
        boolean checkFileListMd5 = XWalkUpdater.FileListMD5Checker.checkFileListMd5(i2, asZ);
        AppMethodBeat.o(154465);
        return checkFileListMd5;
    }

    private static int am(File file) {
        int i2 = -1;
        AppMethodBeat.i(154466);
        if (file == null) {
            AppMethodBeat.o(154466);
        } else {
            String name = file.getName();
            if (name != null && name.startsWith("app_xwalk_") && file.isDirectory()) {
                String substring = name.substring(10);
                try {
                    i2 = Integer.parseInt(substring);
                    AppMethodBeat.o(154466);
                } catch (Exception e2) {
                    Log.e("XWalkUpdaterImp", "get apk version strApkVer  is ".concat(String.valueOf(substring)));
                }
            }
            AppMethodBeat.o(154466);
        }
        return i2;
    }

    private static void ba(String str, int i2, int i3) {
        AppMethodBeat.i(154467);
        Log.i("XWalkUpdaterImp", "tryAbandonThisVersion scene  is ".concat(String.valueOf(str)));
        long j2 = b.c(str, WebView.c.WV_KIND_CW).SDy;
        if (!ServerProtocol.DIALOG_RETURN_SCOPES_TRUE.equalsIgnoreCase(com.tencent.xweb.a.nS("enable_reinstall_for_crash_at_".concat(String.valueOf(str)), "tools"))) {
            AppMethodBeat.o(154467);
            return;
        }
        if (j2 >= 15) {
            String str2 = "LAST_" + str + "_ABANDON_COUNT";
            long j3 = XWalkEnvironment.getSharedPreferencesForXWEBUpdater().getLong(str2, 100000);
            Log.i("XWalkUpdaterImp", "tryAbandonThisVersion try count = " + j2 + ",  last abandon count = " + j3);
            if (j2 < j3) {
                Log.i("XWalkUpdaterImp", "tryAbandonThisVersion should abandon this version ");
                try {
                    asX(XWalkEnvironment.getInstalledNewstVersionForCurAbi());
                    XWalkEnvironment.setAvailableVersion(-1, "", XWalkEnvironment.getRuntimeAbi());
                    XWalkEnvironment.getSharedPreferencesForXWEBUpdater().edit().putLong(str2, j2).commit();
                    h.OQ((long) i2);
                    AppMethodBeat.o(154467);
                    return;
                } catch (Exception e2) {
                    Log.e("XWalkUpdaterImp", "clear version failed , errmsg:" + e2.getMessage());
                    AppMethodBeat.o(154467);
                    return;
                }
            } else if (j2 - 2 > j3) {
                Log.i("XWalkUpdaterImp", "tryAbandonThisVersion cant not fix ");
                h.OQ((long) i3);
            }
        }
        AppMethodBeat.o(154467);
    }

    static void huX() {
        AppMethodBeat.i(154468);
        ba("LOAD_CORE", d.CTRL_INDEX, 244);
        ba("CREATE_WEBVIEW", 245, 246);
        AppMethodBeat.o(154468);
    }

    private static void bsP(String str) {
        AppMethodBeat.i(207312);
        File file = new File(str);
        if (!file.isDirectory()) {
            AppMethodBeat.o(207312);
            return;
        }
        File[] listFiles = file.listFiles();
        for (File file2 : listFiles) {
            if (file2 != null) {
                if (ShareConstants.ANDROID_O_DEX_OPTIMIZE_PATH.equalsIgnoreCase(file2.getName())) {
                    c.ak(file2);
                    Log.i("XWalkUpdaterImp", "removeOptDexRecursively remove oat dir " + file2.getAbsolutePath());
                } else if (file2.getName().endsWith(ShareConstants.ODEX_SUFFIX)) {
                    c.ak(file2);
                    Log.i("XWalkUpdaterImp", "removeOptDexRecursively remove odex file " + file2.getAbsolutePath());
                } else if (file2.getName().endsWith(".vdex")) {
                    c.ak(file2);
                    Log.i("XWalkUpdaterImp", "removeOptDexRecursively remove vdex file " + file2.getAbsolutePath());
                } else if (file2.isDirectory()) {
                    bsP(file2.getAbsolutePath());
                }
            }
        }
        AppMethodBeat.o(207312);
    }

    private static boolean huZ() {
        AppMethodBeat.i(154469);
        XWalkUpdater.try_generate_jar_for_dex_in_dir(XWalkEnvironment.getExtractedCoreDir(XWalkEnvironment.getInstalledNewstVersionForCurAbi()), true);
        if (!com.tencent.xweb.a.hsb().nT("DIS_REMOVE_ODEX_IN_DEX_CRRUPTION", "tools")) {
            bsP(XWalkEnvironment.getVesionDir(XWalkEnvironment.getInstalledNewstVersionForCurAbi()));
        }
        if (c.bsB(XWalkEnvironment.getOptimizedDexDir(XWalkEnvironment.getInstalledNewstVersionForCurAbi()))) {
            XWalkEnvironment.addXWalkInitializeLog("tryRemoveOptDex suc");
            AppMethodBeat.o(154469);
            return true;
        }
        XWalkEnvironment.addXWalkInitializeLog("tryRemoveOptDex failed");
        AppMethodBeat.o(154469);
        return false;
    }

    public static boolean hva() {
        boolean z;
        AppMethodBeat.i(154470);
        int installedNewstVersionForCurAbi = XWalkEnvironment.getInstalledNewstVersionForCurAbi();
        if (installedNewstVersionForCurAbi <= 0) {
            Log.i("XWalkUpdaterImp", "doFixDex stopped , because no xweb currently");
            AppMethodBeat.o(154470);
            return false;
        }
        Log.i("XWalkUpdaterImp", "doFixDex start");
        File asZ = asZ(installedNewstVersionForCurAbi);
        if (asZ == null) {
            Log.e("XWalkUpdaterImp", "doFixDex checkfiles no config file");
            AppMethodBeat.o(154470);
            return false;
        } else if (!XWalkUpdater.FileListMD5Checker.checkFileListMd5(installedNewstVersionForCurAbi, asZ)) {
            Log.e("XWalkUpdaterImp", "doFixDex checkFileListMd5 failed");
            AppMethodBeat.o(154470);
            return false;
        } else {
            String extractedCoreDir = XWalkEnvironment.getExtractedCoreDir(installedNewstVersionForCurAbi);
            String str = XWalkEnvironment.getExtractedCoreDir(installedNewstVersionForCurAbi) + "_bk";
            File file = new File(str);
            if (!file.exists()) {
                file.mkdirs();
            }
            if (!XWalkDecompressor.extractResource(XWalkEnvironment.getDownloadApkPath(installedNewstVersionForCurAbi), str, XWalkUpdater.getResFileList(installedNewstVersionForCurAbi))) {
                XWalkInitializer.addXWalkInitializeLog("XWalkUpdaterImp", " doFixDex extract faield");
            }
            String str2 = extractedCoreDir + File.separator + "classes.dex";
            String str3 = str + File.separator + "classes.dex";
            String md5 = com.tencent.xweb.util.d.getMD5(str2);
            if (TextUtils.isEmpty(md5)) {
                md5 = "";
            }
            if (!md5.equalsIgnoreCase(com.tencent.xweb.util.d.getMD5(str3))) {
                h.OQ(253);
                XWalkInitializer.addXWalkInitializeLog("XWalkUpdaterImp", " doFixDex dex cruppted");
                if (!c.bsB(str2)) {
                    h.OQ(250);
                    XWalkInitializer.addXWalkInitializeLog("XWalkUpdaterImp", " doFixDex delete cruppted dex failed");
                    z = false;
                } else if (c.copyFile(str3, str2)) {
                    XWalkInitializer.addXWalkInitializeLog("XWalkUpdaterImp", " doFixDex copy dex to replace suc");
                    z = true;
                } else {
                    h.OQ(249);
                    XWalkInitializer.addXWalkInitializeLog("XWalkUpdaterImp", " doFixDex copy dex to replace failed");
                    z = false;
                }
                huZ();
            } else if (huZ()) {
                h.OQ(254);
                XWalkInitializer.addXWalkInitializeLog("XWalkUpdaterImp", "doFixDex try remove  opt dex suc");
                z = true;
            } else {
                XWalkInitializer.addXWalkInitializeLog("XWalkUpdaterImp", "doFixDex try remove  opt dex failed");
                h.OQ(255);
                z = false;
            }
            AppMethodBeat.o(154470);
            return z;
        }
    }

    public static void Et(boolean z) {
        boolean z2 = true;
        AppMethodBeat.i(154471);
        int availableVersion = XWalkEnvironment.getAvailableVersion();
        if (availableVersion <= 0) {
            AppMethodBeat.o(154471);
            return;
        }
        SharedPreferences sharedPreferencesForUpdateConfig = XWalkEnvironment.getSharedPreferencesForUpdateConfig();
        if (sharedPreferencesForUpdateConfig == null) {
            AppMethodBeat.o(154471);
        } else if (z || com.tencent.xweb.internal.c.cl("CHECK_FILES_MD5_TIME_KEY", 7200000)) {
            Log.i("XWalkUpdaterImp", "checkFiles start check resfiles");
            boolean checkExtractResFileLengtgAndMd5 = XWalkUpdater.checkExtractResFileLengtgAndMd5(XWalkEnvironment.getDownloadResFileListConfig(availableVersion), XWalkEnvironment.getExtractedCoreDir(availableVersion), availableVersion);
            if (!checkExtractResFileLengtgAndMd5) {
                int i2 = sharedPreferencesForUpdateConfig.getInt("LAST_CHECK_RES_VERSION", -1);
                sharedPreferencesForUpdateConfig.edit().putInt("LAST_CHECK_RES_VERSION", -1).commit();
                if (i2 != availableVersion) {
                    h.OQ(77);
                    XWalkEnvironment.addXWalkInitializeLog("XWalkUpdaterImp", "some res corrupted at first time");
                } else {
                    XWalkEnvironment.addXWalkInitializeLog("XWalkUpdaterImp", "some res corrupted");
                }
                h.OQ(76);
            }
            Log.i("XWalkUpdaterImp", "checkFiles start check installed files");
            File asZ = asZ(availableVersion);
            if (asZ != null) {
                z2 = XWalkUpdater.FileListMD5Checker.checkFileListMd5(availableVersion, asZ);
            } else if (!XWalkEnvironment.isTestVersion(availableVersion)) {
                Log.e("XWalkUpdaterImp", "checkfiles no config file");
                h.OQ(78);
                if (ServerProtocol.DIALOG_RETURN_SCOPES_TRUE.equalsIgnoreCase(com.tencent.xweb.a.nS("dis_config_file_check", "tools"))) {
                    XWalkInitializer.addXWalkInitializeLog("XWalkUpdaterImp", "dis_config_file_check ");
                } else {
                    z2 = false;
                }
            }
            if (!z2) {
                int i3 = sharedPreferencesForUpdateConfig.getInt("LAST_CHECK_VERSION", -1);
                sharedPreferencesForUpdateConfig.edit().putInt("LAST_CHECK_VERSION", -1).commit();
                if (i3 != availableVersion) {
                    h.OQ(64);
                    XWalkEnvironment.addXWalkInitializeLog("XWalkUpdaterImp", "some files corrupted at first time");
                } else {
                    XWalkEnvironment.addXWalkInitializeLog("XWalkUpdaterImp", "some files corrupted");
                }
                h.OQ(63);
            }
            if (!ServerProtocol.DIALOG_RETURN_SCOPES_TRUE.equalsIgnoreCase(com.tencent.xweb.a.nS("disable_res_check", "tools"))) {
                z2 &= checkExtractResFileLengtgAndMd5;
            } else {
                XWalkEnvironment.addXWalkInitializeLog("XWalkUpdaterImp", "ignore res files check");
            }
            if (!z2) {
                XWalkEnvironment.setAvailableVersion(-1, null, XWalkEnvironment.getRuntimeAbi());
                AppMethodBeat.o(154471);
                return;
            }
            sharedPreferencesForUpdateConfig.edit().putInt("LAST_CHECK_VERSION", availableVersion).commit();
            Log.i("XWalkUpdaterImp", "checkfiles parse");
            AppMethodBeat.o(154471);
        } else {
            AppMethodBeat.o(154471);
        }
    }

    private static File asZ(int i2) {
        AppMethodBeat.i(154473);
        try {
            File file = new File(XWalkEnvironment.getPatchFileListConfig(i2));
            if (file.exists()) {
                AppMethodBeat.o(154473);
                return file;
            }
            File file2 = new File(XWalkEnvironment.getDownloadZipFileListConfig(i2));
            if (file2.exists()) {
                AppMethodBeat.o(154473);
                return file2;
            }
            AppMethodBeat.o(154473);
            return null;
        } catch (Exception e2) {
            AppMethodBeat.o(154473);
            return null;
        }
    }

    public static boolean isBusy() {
        AppMethodBeat.i(154474);
        if (SHH == null) {
            AppMethodBeat.o(154474);
            return false;
        } else if (g.hvR() || e.isBusy()) {
            AppMethodBeat.o(154474);
            return true;
        } else {
            AppMethodBeat.o(154474);
            return false;
        }
    }

    public p(Context context) {
        AppMethodBeat.i(154475);
        this.mContext = context;
        this.SHI = new XWalkInitializer(this, context);
        this.SHJ = new XWalkUpdater(this, context);
        AppMethodBeat.o(154475);
    }

    public final boolean C(HashMap<String, String> hashMap) {
        AppMethodBeat.i(154476);
        new g(this.SHJ, hashMap).execute(new String[0]);
        AppMethodBeat.o(154476);
        return false;
    }

    @Override // org.xwalk.core.XWalkInitializer.XWalkInitListener
    public void onXWalkInitStarted() {
    }

    @Override // org.xwalk.core.XWalkInitializer.XWalkInitListener
    public void onXWalkInitCancelled() {
    }

    @Override // org.xwalk.core.XWalkInitializer.XWalkInitListener
    public void onXWalkInitFailed() {
    }

    @Override // org.xwalk.core.XWalkInitializer.XWalkInitListener
    public void onXWalkInitCompleted() {
    }

    public static void hQ(String str, int i2) {
        AppMethodBeat.i(185201);
        Intent intent = new Intent();
        intent.setAction("com.tencent.xweb.update");
        intent.putExtra("stage", str);
        intent.putExtra("extra_data", i2);
        XWalkEnvironment.getApplicationContext().sendBroadcast(intent);
        AppMethodBeat.o(185201);
    }

    @Override // org.xwalk.core.XWalkUpdater.XWalkBackgroundUpdateListener
    public void onXWalkUpdateStarted() {
        AppMethodBeat.i(154477);
        hQ("start", 0);
        g.hvS();
        ah.hte();
        AppMethodBeat.o(154477);
    }

    @Override // org.xwalk.core.XWalkUpdater.XWalkBackgroundUpdateListener
    public void onXWalkUpdateProgress(int i2) {
        AppMethodBeat.i(154478);
        hQ("updating", i2);
        c hte = ah.hte();
        if (hte != null) {
            hte.zq(i2);
        }
        AppMethodBeat.o(154478);
    }

    @Override // org.xwalk.core.XWalkUpdater.XWalkBackgroundUpdateListener
    public void onXWalkUpdateCancelled() {
        AppMethodBeat.i(154479);
        hQ("finished", -2);
        g.hvT();
        c hte = ah.hte();
        if (hte != null) {
            hte.bXL();
        }
        AppMethodBeat.o(154479);
    }

    @Override // org.xwalk.core.XWalkUpdater.XWalkBackgroundUpdateListener
    public void onXWalkUpdateFailed(int i2, Scheduler scheduler) {
        AppMethodBeat.i(207313);
        hQ("finished", -1);
        g.a(i2, scheduler);
        c hte = ah.hte();
        if (hte != null) {
            hte.bXL();
        }
        AppMethodBeat.o(207313);
    }

    @Override // org.xwalk.core.XWalkUpdater.XWalkBackgroundUpdateListener
    public void onXWalkUpdateCompleted(Scheduler scheduler) {
        AppMethodBeat.i(207314);
        hQ("finished", 0);
        g.a(scheduler);
        c hte = ah.hte();
        if (hte != null) {
            hte.bXM();
        }
        AppMethodBeat.o(207314);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0064, code lost:
        if (com.facebook.internal.ServerProtocol.DIALOG_RETURN_SCOPES_TRUE.equalsIgnoreCase(com.tencent.xweb.a.nS("enable_check_dex_new_web", "tools")) == false) goto L_0x0066;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0032, code lost:
        if (com.facebook.internal.ServerProtocol.DIALOG_RETURN_SCOPES_TRUE.equalsIgnoreCase(com.tencent.xweb.a.nS("enable_check_dex", "tools")) != false) goto L_0x0034;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void huY() {
        /*
        // Method dump skipped, instructions count: 156
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.xweb.xwalk.p.huY():void");
    }
}
