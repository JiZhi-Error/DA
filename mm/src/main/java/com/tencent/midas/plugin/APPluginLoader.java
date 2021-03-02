package com.tencent.midas.plugin;

import android.content.Context;
import android.text.TextUtils;
import com.pay.tool.APMidasTools;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.APLog;
import com.tencent.midas.data.APPluginReportManager;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.util.HashMap;

public class APPluginLoader {
    private static DexClassLoader parentClassLoader = null;
    private static final HashMap<String, DexClassLoader> sClassLoaderMap = new HashMap<>();

    static {
        AppMethodBeat.i(193029);
        AppMethodBeat.o(193029);
    }

    public static void setParentClassLoader(DexClassLoader dexClassLoader) {
        parentClassLoader = dexClassLoader;
    }

    public static synchronized ClassLoader getClassLoader(String str, String str2) {
        DexClassLoader dexClassLoader;
        synchronized (APPluginLoader.class) {
            AppMethodBeat.i(193024);
            dexClassLoader = sClassLoaderMap.get(str + "_" + str2);
            AppMethodBeat.o(193024);
        }
        return dexClassLoader;
    }

    public static synchronized ClassLoader getOrCreateClassLoader(Context context, String str) {
        DexClassLoader orCreateClassLoaderByPath;
        synchronized (APPluginLoader.class) {
            AppMethodBeat.i(193025);
            orCreateClassLoaderByPath = getOrCreateClassLoaderByPath(context, str, APPluginInstallerAndUpdater.getInstallPath(context, str).getCanonicalPath());
            APLog.d("APPluginStatic", "getClassLoader getOrCreateClassLoader midasClassLoader: " + orCreateClassLoaderByPath.hashCode());
            AppMethodBeat.o(193025);
        }
        return orCreateClassLoaderByPath;
    }

    static void release() {
        AppMethodBeat.i(193026);
        sClassLoaderMap.clear();
        AppMethodBeat.o(193026);
    }

    static synchronized DexClassLoader getOrCreateClassLoaderByPath(Context context, String str, String str2) {
        DexClassLoader dexClassLoader;
        synchronized (APPluginLoader.class) {
            AppMethodBeat.i(193027);
            String mD5FromPath = APPluginUtils.getMD5FromPath(str2);
            String str3 = str + "_" + mD5FromPath;
            dexClassLoader = sClassLoaderMap.get(str3);
            APLog.d("APPluginStatic", "getOrCreateClassLoader apkFilePath: " + str2 + ", MD5: " + mD5FromPath + ", key: " + str3 + ", dexClassLoader: " + dexClassLoader);
            if (dexClassLoader != null) {
                AppMethodBeat.o(193027);
            } else {
                String canonicalPath = APPluginConfig.getOptimizedDexPath(context).getCanonicalPath();
                long currentTimeMillis = System.currentTimeMillis();
                APPluginUtils.extractLibs(str2, APPluginConfig.getLibPath(context).getCanonicalPath());
                APPluginReportManager.getInstance().insertTimeDataEx(APMidasTools.getCurrentThreadName(Thread.currentThread()), APPluginReportManager.MIDASPLUGIN_TIMENAME_UNZIP_SO, currentTimeMillis);
                String canonicalPath2 = APPluginConfig.getLibPath(context).getCanonicalPath();
                if (parentClassLoader != null) {
                    dexClassLoader = new DexClassLoader(str2, canonicalPath, canonicalPath2, parentClassLoader);
                } else {
                    dexClassLoader = new DexClassLoader(str2, canonicalPath, canonicalPath2, context.getClassLoader());
                }
                APLog.d("APPluginStatic", "getOrCreateClassLoader new DexClassLoader cache: " + canonicalPath + " libDir: " + canonicalPath2);
                sClassLoaderMap.put(str3, dexClassLoader);
                AppMethodBeat.o(193027);
            }
        }
        return dexClassLoader;
    }

    public static synchronized void preCreateClassLoaderByPath(Context context) {
        synchronized (APPluginLoader.class) {
            AppMethodBeat.i(193028);
            String str = "";
            String str2 = "";
            File pluginPath = APPluginConfig.getPluginPath(context);
            if (pluginPath != null) {
                File[] listFiles = pluginPath.listFiles();
                int i2 = 0;
                while (true) {
                    if (i2 >= listFiles.length) {
                        break;
                    }
                    File file = listFiles[i2];
                    if (file.getName().startsWith("MidasPay")) {
                        str = "MidasPay";
                        str2 = file.getCanonicalPath();
                        break;
                    }
                    i2++;
                }
            }
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                getOrCreateClassLoaderByPath(context, str, str2);
            }
            AppMethodBeat.o(193028);
        }
    }
}
