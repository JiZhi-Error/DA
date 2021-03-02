package com.tencent.xweb.xwalk.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.util.c;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;

public final class h {
    private static Map<String, g> SHV = new HashMap();

    static {
        AppMethodBeat.i(157195);
        AppMethodBeat.o(157195);
    }

    public static boolean hvn() {
        AppMethodBeat.i(157187);
        if (SHV.size() == 0) {
            Log.i("XWalkPluginMgr", "initPlugins");
            SHV.put(XWalkEnvironment.XWALK_PLUGIN_NAME_FULL_SCREEN_VIDEO, new c());
            SHV.put(XWalkEnvironment.XWALK_PLUGIN_NAME_PDF, new e());
            SHV.put(XWalkEnvironment.XWALK_PLUGIN_NAME_PPT, new f());
            SHV.put(XWalkEnvironment.XWALK_PLUGIN_NAME_WORD, new n());
            SHV.put(XWalkEnvironment.XWALK_PLUGIN_NAME_EXCEL, new b());
            d dVar = new d();
            SHV.put(dVar.getPluginName(), dVar);
        }
        AppMethodBeat.o(157187);
        return true;
    }

    public static Map<String, Integer> lI(Context context) {
        AppMethodBeat.i(157188);
        HashMap hashMap = new HashMap();
        hashMap.put(XWalkEnvironment.XWALK_PLUGIN_NAME_FULL_SCREEN_VIDEO, Integer.valueOf(XWalkEnvironment.getInstalledPluginVersion(context, XWalkEnvironment.XWALK_PLUGIN_NAME_FULL_SCREEN_VIDEO)));
        hashMap.put(XWalkEnvironment.XWALK_PLUGIN_NAME_PDF, Integer.valueOf(XWalkEnvironment.getInstalledPluginVersion(context, XWalkEnvironment.XWALK_PLUGIN_NAME_PDF)));
        hashMap.put(XWalkEnvironment.XWALK_PLUGIN_NAME_PPT, Integer.valueOf(XWalkEnvironment.getInstalledPluginVersion(context, XWalkEnvironment.XWALK_PLUGIN_NAME_PPT)));
        hashMap.put(XWalkEnvironment.XWALK_PLUGIN_NAME_WORD, Integer.valueOf(XWalkEnvironment.getInstalledPluginVersion(context, XWalkEnvironment.XWALK_PLUGIN_NAME_WORD)));
        hashMap.put(XWalkEnvironment.XWALK_PLUGIN_NAME_EXCEL, Integer.valueOf(XWalkEnvironment.getInstalledPluginVersion(context, XWalkEnvironment.XWALK_PLUGIN_NAME_EXCEL)));
        hashMap.put(XWalkEnvironment.XWALK_PLUGIN_NAME_OFFICE, Integer.valueOf(XWalkEnvironment.getInstalledPluginVersion(context, XWalkEnvironment.XWALK_PLUGIN_NAME_OFFICE)));
        AppMethodBeat.o(157188);
        return hashMap;
    }

    public static g brX(String str) {
        AppMethodBeat.i(157189);
        if (str == null || str.isEmpty()) {
            AppMethodBeat.o(157189);
            return null;
        }
        g gVar = SHV.get(str);
        AppMethodBeat.o(157189);
        return gVar;
    }

    public static List<g> hvo() {
        AppMethodBeat.i(157190);
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, g> entry : SHV.entrySet()) {
            arrayList.add(entry.getValue());
        }
        AppMethodBeat.o(157190);
        return arrayList;
    }

    public static String hvp() {
        AppMethodBeat.i(157191);
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, g> entry : SHV.entrySet()) {
            g value = entry.getValue();
            if (value != null) {
                sb.append(value.getPluginName()).append(" = ").append(value.SHU).append(", ");
            }
        }
        String sb2 = sb.toString();
        AppMethodBeat.o(157191);
        return sb2;
    }

    public static void hvj() {
        AppMethodBeat.i(157192);
        if (SHV.size() == 0) {
            Log.e("XWalkPluginMgr", "checkFiles error, sPluginMap size is 0");
            AppMethodBeat.o(157192);
            return;
        }
        for (Map.Entry<String, g> entry : SHV.entrySet()) {
            entry.getValue().hvj();
        }
        AppMethodBeat.o(157192);
    }

    /* access modifiers changed from: package-private */
    public static class a {
        String CZj;
        int SHW;

        a(String str, int i2) {
            this.CZj = str;
            this.SHW = i2;
        }
    }

    private static a an(File file) {
        AppMethodBeat.i(157193);
        if (file == null) {
            Log.e("XWalkPluginMgr", "getPluginInfoFromDir dirFile is null");
            AppMethodBeat.o(157193);
            return null;
        } else if (!file.exists() || !file.isDirectory()) {
            Log.e("XWalkPluginMgr", "getPluginInfoFromDir dirFile is invalid");
            AppMethodBeat.o(157193);
            return null;
        } else {
            String name = file.getName();
            int lastIndexOf = name.lastIndexOf(95);
            if (lastIndexOf < 0 || lastIndexOf >= name.length() - 1) {
                Log.e("XWalkPluginMgr", "getPluginInfoFromDir can not find _");
                AppMethodBeat.o(157193);
                return null;
            }
            try {
                a aVar = new a(name.substring(0, lastIndexOf), Integer.parseInt(name.substring(lastIndexOf + 1)));
                AppMethodBeat.o(157193);
                return aVar;
            } catch (Exception e2) {
                Log.e("XWalkPluginMgr", "getPluginInfoFromDir error: " + e2.getMessage());
                AppMethodBeat.o(157193);
                return null;
            }
        }
    }

    public static void hvq() {
        int i2;
        AppMethodBeat.i(157194);
        if (SHV.size() == 0) {
            Log.e("XWalkPluginMgr", "clearOldVersions error, sPluginMap size is 0");
            AppMethodBeat.o(157194);
            return;
        }
        String pluginBaseDir = XWalkEnvironment.getPluginBaseDir();
        if (pluginBaseDir == null || pluginBaseDir.isEmpty()) {
            Log.e("XWalkPluginMgr", "clearOldVersions clear other, pluginBaseDir is null, return");
            AppMethodBeat.o(157194);
            return;
        }
        File[] listFiles = new File(pluginBaseDir).listFiles();
        if (listFiles == null || listFiles.length <= 0) {
            Log.i("XWalkPluginMgr", "clearOldVersions, dir is empty, return");
            AppMethodBeat.o(157194);
            return;
        }
        for (File file : listFiles) {
            if (file != null) {
                a an = an(file);
                if (an == null) {
                    Log.e("XWalkPluginMgr", "clearOldVersions can not get plugin info, delete " + file.getAbsolutePath());
                    c.bsB(file.getAbsolutePath());
                } else {
                    g gVar = SHV.get(an.CZj);
                    if (gVar == null) {
                        Log.e("XWalkPluginMgr", "clearOldVersions invalid plugin info, delete " + file.getAbsolutePath());
                        c.bsB(file.getAbsolutePath());
                    } else {
                        int i3 = gVar.SHU;
                        if (i3 < 0) {
                            i2 = gVar.hvk();
                        } else {
                            i2 = i3;
                        }
                        if (i2 < 0) {
                            Log.e("XWalkPluginMgr", "clearOldVersions can not get availableVersion, skip " + file.getAbsolutePath());
                        } else if (an.SHW < i2) {
                            Log.i("XWalkPluginMgr", "clearOldVersions is old version, delete " + file.getAbsolutePath());
                            c.bsB(file.getAbsolutePath());
                        }
                    }
                }
            }
        }
        AppMethodBeat.o(157194);
    }
}
