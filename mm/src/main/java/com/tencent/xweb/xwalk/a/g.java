package com.tencent.xweb.xwalk.a;

import android.content.SharedPreferences;
import com.tencent.xweb.util.BSpatch;
import com.tencent.xweb.util.d;
import com.tencent.xweb.util.h;
import com.tencent.xweb.xwalk.a.i;
import com.tencent.xweb.xwalk.updater.c;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;

public abstract class g {
    public int SHU = -1;

    public abstract int a(c cVar);

    public abstract String ca(int i2, boolean z);

    public abstract String getPluginName();

    public abstract boolean hvi();

    public abstract void hvj();

    public g() {
        hvl();
    }

    public final int hvk() {
        hvl();
        return this.SHU;
    }

    public final boolean atc(int i2) {
        boolean z = false;
        if (XWalkEnvironment.getApplicationContext() == null) {
            Log.e(getPluginName(), "setVer, context is null");
        } else {
            SharedPreferences sharedPreferencesForPluginVersionInfo = XWalkEnvironment.getSharedPreferencesForPluginVersionInfo(getPluginName());
            if (sharedPreferencesForPluginVersionInfo == null) {
                Log.e(getPluginName(), "setVer, sp is null");
            } else {
                SharedPreferences.Editor edit = sharedPreferencesForPluginVersionInfo.edit();
                edit.putInt(XWalkEnvironment.SP_KEY_PLUGIN_AVAILABLE_VERSION, i2);
                z = edit.commit();
                if (z) {
                    this.SHU = i2;
                }
                Log.i(getPluginName(), "setVer, version = " + i2 + ", isNow = true, ret = " + z);
            }
        }
        return z;
    }

    private void hvl() {
        if (XWalkEnvironment.getApplicationContext() == null) {
            Log.e(getPluginName(), "loadVer, context is null");
            return;
        }
        SharedPreferences sharedPreferencesForPluginVersionInfo = XWalkEnvironment.getSharedPreferencesForPluginVersionInfo(getPluginName());
        if (sharedPreferencesForPluginVersionInfo == null) {
            Log.e(getPluginName(), "loadVer, sp is null");
            return;
        }
        int i2 = this.SHU;
        this.SHU = sharedPreferencesForPluginVersionInfo.getInt(XWalkEnvironment.SP_KEY_PLUGIN_AVAILABLE_VERSION, -1);
        if (this.SHU == i2) {
            return;
        }
        if (i2 == -1) {
            Log.i(getPluginName(), "loadVer, version = " + this.SHU);
        } else {
            Log.i(getPluginName(), "loadVer, old version = " + i2 + ", new version = " + this.SHU);
        }
    }

    public final String atd(int i2) {
        if (XWalkEnvironment.getApplicationContext() == null) {
            Log.e(getPluginName(), "getVersionDir, context is null");
            return "";
        }
        String pluginBaseDir = XWalkEnvironment.getPluginBaseDir();
        if (pluginBaseDir.isEmpty()) {
            Log.e(getPluginName(), "getVersionDir, pluginBaseDir is null");
            return "";
        }
        String str = pluginBaseDir + File.separator + getPluginName() + "_" + i2;
        File file = new File(str);
        if (file.exists()) {
            return str;
        }
        file.mkdirs();
        return str;
    }

    public final String ate(int i2) {
        String atd = atd(i2);
        if (atd == null || atd.isEmpty()) {
            Log.e(getPluginName(), "getPrivateCacheDir, versionDir is empty");
            return "";
        }
        String str = atd + File.separator + "cache";
        File file = new File(str);
        if (file.exists()) {
            return str;
        }
        file.mkdirs();
        return str;
    }

    public final String atf(int i2) {
        String atd = atd(i2);
        if (atd.isEmpty()) {
            Log.e(getPluginName(), "getExtractDir, versionDir is empty");
            return "";
        }
        String str = atd + File.separator + "extracted";
        File file = new File(str);
        if (file.exists()) {
            return str;
        }
        file.mkdirs();
        return str;
    }

    public final String dA(int i2, String str) {
        if (str == null || str.isEmpty()) {
            Log.e(getPluginName(), "getExtractFile, fileName is empty");
            return "";
        }
        String atf = atf(i2);
        if (!atf.isEmpty()) {
            return atf + File.separator + str;
        }
        Log.e(getPluginName(), "getExtractFile, extractDir is empty");
        return "";
    }

    private String atg(int i2) {
        String atd = atd(i2);
        if (atd.isEmpty()) {
            Log.e(getPluginName(), "getPatchDir, versionDir is empty");
            return "";
        }
        String str = atd + File.separator + "patch_temp";
        File file = new File(str);
        if (file.exists()) {
            return str;
        }
        file.mkdirs();
        return str;
    }

    private String dB(int i2, String str) {
        if (str == null || str.isEmpty()) {
            Log.e(getPluginName(), "getPatchFile, fileName is empty");
            return "";
        }
        String atg = atg(i2);
        if (!atg.isEmpty()) {
            return atg + File.separator + str;
        }
        Log.e(getPluginName(), "getPatchFile, patchDir is null");
        return "";
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00e2  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x013b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean b(com.tencent.xweb.xwalk.updater.c r10) {
        /*
        // Method dump skipped, instructions count: 328
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.xweb.xwalk.a.g.b(com.tencent.xweb.xwalk.updater.c):boolean");
    }

    /* access modifiers changed from: protected */
    public final boolean c(c cVar) {
        int i2 = this.SHU;
        Log.i(getPluginName(), "doPatch current version = " + i2 + ", new version = " + cVar.version);
        if (i2 < 0) {
            Log.e(getPluginName(), "doPatch, current version invalid");
            return false;
        } else if (!cVar.SJc) {
            Log.e(getPluginName(), "doPatch, current download config is not patch");
            return false;
        } else {
            File file = new File(dB(cVar.version, "patch.config"));
            if (!file.exists()) {
                Log.e(getPluginName(), "doPatch, can not find patch config file");
                return false;
            }
            List<i.a> ao = i.ao(file);
            if (ao == null || ao.size() == 0) {
                Log.e(getPluginName(), "doPatch, patchConfigList = null");
                return false;
            } else if (!com.tencent.xweb.util.c.oh(atf(i2), atf(cVar.version))) {
                Log.e(getPluginName(), "doPatch, copy files failed");
                return false;
            } else {
                for (i.a aVar : ao) {
                    if (!(aVar.type == 1)) {
                        if (!(aVar.type == 3)) {
                            if (!(aVar.type == 2)) {
                                Log.e(getPluginName(), "doPatch, unknown op".concat(String.valueOf(aVar)));
                                return false;
                            } else if (BSpatch.bv(dA(cVar.version, aVar.originalFileName), dB(cVar.version, aVar.patchFileName), dA(cVar.version, aVar.originalFileName)) < 0) {
                                Log.e(getPluginName(), "doPatch, patch file error:".concat(String.valueOf(aVar)));
                                return false;
                            } else {
                                Log.i(getPluginName(), "doPatch, patch file:".concat(String.valueOf(aVar)));
                            }
                        } else if (!com.tencent.xweb.util.c.deleteFile(dA(cVar.version, aVar.originalFileName))) {
                            Log.e(getPluginName(), "doPatch, delete file error:".concat(String.valueOf(aVar)));
                        } else {
                            Log.i(getPluginName(), "doPatch, delete file:".concat(String.valueOf(aVar)));
                        }
                    } else if (!com.tencent.xweb.util.c.copyFile(dB(cVar.version, aVar.originalFileName), dA(cVar.version, aVar.originalFileName))) {
                        Log.e(getPluginName(), "doPatch, add file error: ".concat(String.valueOf(aVar)));
                        return false;
                    } else {
                        Log.i(getPluginName(), "doPatch, add file:".concat(String.valueOf(aVar)));
                    }
                }
                com.tencent.xweb.util.c.deleteFile(dA(cVar.version, XWalkEnvironment.XWALK_CORE_FILELIST_CONFIG_NAME));
                if (!com.tencent.xweb.util.c.copyFile(dB(cVar.version, XWalkEnvironment.XWALK_CORE_FILELIST_CONFIG_NAME), dA(cVar.version, XWalkEnvironment.XWALK_CORE_FILELIST_CONFIG_NAME))) {
                    Log.e(getPluginName(), "doPatch, copy filelist.config error");
                    return false;
                } else if (!cb(cVar.version, false)) {
                    Log.e(getPluginName(), "doPatch, check md5 failed");
                    return false;
                } else {
                    String atg = atg(cVar.version);
                    if (!atg.isEmpty()) {
                        com.tencent.xweb.util.c.bsB(atg);
                    }
                    return true;
                }
            }
        }
    }

    public final boolean cb(int i2, boolean z) {
        BufferedReader bufferedReader;
        Throwable th;
        Exception e2;
        Log.i(getPluginName(), "checkFileListConfig, version = ".concat(String.valueOf(i2)));
        if (i2 < 0) {
            Log.i(getPluginName(), "checkFileListConfig, version invalid");
            return false;
        }
        File file = new File(dA(i2, XWalkEnvironment.XWALK_CORE_FILELIST_CONFIG_NAME));
        if (file.exists()) {
            try {
                bufferedReader = new BufferedReader(new FileReader(file));
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            Log.i(getPluginName(), "checkFileListConfig success");
                            com.tencent.xweb.util.c.tryClose(bufferedReader);
                            return true;
                        } else if (!readLine.isEmpty()) {
                            String[] split = readLine.split(":");
                            if (split.length == 2 && split[0] != null && !split[0].isEmpty() && split[1] != null && !split[1].isEmpty()) {
                                String str = split[0];
                                if (!d.oi(dA(i2, str), split[1])) {
                                    Log.e(getPluginName(), "checkFileListConfig, md5 not match: ".concat(String.valueOf(str)));
                                    com.tencent.xweb.util.c.tryClose(bufferedReader);
                                    return false;
                                }
                            }
                        }
                    } catch (Exception e3) {
                        e2 = e3;
                        try {
                            Log.e(getPluginName(), "checkFileListConfig error: " + e2.getMessage());
                            com.tencent.xweb.util.c.tryClose(bufferedReader);
                            return false;
                        } catch (Throwable th2) {
                            th = th2;
                            com.tencent.xweb.util.c.tryClose(bufferedReader);
                            throw th;
                        }
                    }
                }
            } catch (Exception e4) {
                e2 = e4;
                bufferedReader = null;
                Log.e(getPluginName(), "checkFileListConfig error: " + e2.getMessage());
                com.tencent.xweb.util.c.tryClose(bufferedReader);
                return false;
            } catch (Throwable th3) {
                th = th3;
                bufferedReader = null;
                com.tencent.xweb.util.c.tryClose(bufferedReader);
                throw th;
            }
        } else if (z) {
            Log.i(getPluginName(), "checkFileListConfig, no filelist.config, skip");
            return true;
        } else {
            Log.e(getPluginName(), "checkFileListConfig, no filelist.config, return");
            return false;
        }
    }

    public final boolean hvm() {
        if (XWalkEnvironment.getApplicationContext() == null) {
            Log.e(getPluginName(), "clearPatchDownloadInfo, context is null");
            return false;
        }
        SharedPreferences sharedPreferencesForPluginVersionInfo = XWalkEnvironment.getSharedPreferencesForPluginVersionInfo(getPluginName());
        if (sharedPreferencesForPluginVersionInfo == null) {
            Log.e(getPluginName(), "clearPatchDownloadInfo, sp is null");
            return false;
        }
        Map<String, ?> all = sharedPreferencesForPluginVersionInfo.getAll();
        if (all == null || all.size() == 0) {
            return true;
        }
        SharedPreferences.Editor edit = sharedPreferencesForPluginVersionInfo.edit();
        for (String str : all.keySet()) {
            if (str != null && str.startsWith(XWalkEnvironment.SP_KEY_PLUGIN_PATCH_DOWNLOAD_COUNT_PREFIX)) {
                Log.i(getPluginName(), "clearPatchDownloadInfo, remove key ".concat(String.valueOf(str)));
                edit.remove(str);
            }
        }
        return edit.commit();
    }

    public final void mQ(int i2, int i3) {
        if (i2 <= 0) {
            Log.e(getPluginName(), "reportUsingVersion, reportVersion invalid");
            return;
        }
        SharedPreferences sharedPreferencesForPluginVersionInfo = XWalkEnvironment.getSharedPreferencesForPluginVersionInfo(getPluginName());
        if (sharedPreferencesForPluginVersionInfo == null) {
            Log.e(getPluginName(), "reportUsingVersion, sp is null");
            return;
        }
        int i4 = sharedPreferencesForPluginVersionInfo.getInt(XWalkEnvironment.SP_KEY_PLUGIN_LAST_REPORT_VERSION, -1);
        String string = sharedPreferencesForPluginVersionInfo.getString(XWalkEnvironment.SP_KEY_PLUGIN_LAST_REPORT_DATE, "");
        try {
            String format = new SimpleDateFormat("yyyyMMdd").format(new Date());
            if (i4 != i2 || !string.equals(format)) {
                int i5 = (i2 % 50) + 100;
                Log.d(getPluginName(), "reportUsingVersion, id:" + i3 + ", key:" + i5);
                h.s((long) i3, (long) i5, 1);
                SharedPreferences.Editor edit = sharedPreferencesForPluginVersionInfo.edit();
                if (edit != null) {
                    edit.putInt(XWalkEnvironment.SP_KEY_PLUGIN_LAST_REPORT_VERSION, i2);
                    edit.putString(XWalkEnvironment.SP_KEY_PLUGIN_LAST_REPORT_DATE, format);
                    edit.commit();
                    return;
                }
                Log.e(getPluginName(), "reportUsingVersion, editor is null");
            }
        } catch (Exception e2) {
            Log.e(getPluginName(), "reportUsingVersion, get cur date error: " + e2.getMessage());
        }
    }
}
