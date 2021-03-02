package com.tencent.midas.plugin;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.tencent.midas.comm.APLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public abstract class APPluginStatic {
    public static final String PARAM_CLASS_STATISTICS_UPLOADER = "clsUploader";
    public static final String PARAM_CLEAR_TOP = "cleartop";
    static final String PARAM_IS_IN_PLUGIN = "pluginsdk_IsPluginActivity";
    public static final String PARAM_LAUNCH_ACTIVITY = "pluginsdk_launchActivity";
    public static final String PARAM_PLUGIN_INTERNAL_ACTIVITIES_ONLY = "PARAM_PLUGIN_INTERNAL_ACTIVITIES_ONLY";
    public static final String PARAM_PLUGIN_IS_NEW_PROCESS = "pluginsdk_isNewProcess";
    public static final String PARAM_PLUGIN_LOCATION = "pluginsdk_pluginLocation";
    public static final String PARAM_PLUGIN_LOG_ENABLE = "pluginsdk_logEnable";
    public static final String PARAM_PLUGIN_NAME = "pluginsdk_pluginName";
    public static final String PARAM_PLUGIN_PATH = "pluginsdk_pluginpath";
    public static final String PARAM_PLUGIN_RECEIVER_CLASS_NAME = "pluginsdk_launchReceiver";
    private static final String TAG = "APPluginStatic";
    public static final int USER_QQ_RESOURCES_NO = -1;
    public static final int USER_QQ_RESOURCES_YES = 1;
    private static ArrayList<WeakReference<IAPPluginActivity>> sInstances = new ArrayList<>();
    static final ConcurrentHashMap<String, PackageInfo> sPackageInfoMap = new ConcurrentHashMap<>();

    public static void release() {
        APPluginLoader.release();
        sPackageInfoMap.clear();
        APLog.d(TAG, "release sInstances size: " + sInstances.size());
    }

    static List<WeakReference<IAPPluginActivity>> getActivitys() {
        return sInstances;
    }

    static void add(IAPPluginActivity iAPPluginActivity) {
        updateReference();
        synchronized (sInstances) {
            sInstances.add(new WeakReference<>(iAPPluginActivity));
        }
    }

    static void remove(IAPPluginActivity iAPPluginActivity) {
        updateReference();
        removeActivity(iAPPluginActivity);
    }

    public static void removeAll() {
        int i2;
        updateReference();
        synchronized (sInstances) {
            int i3 = 0;
            while (i3 < sInstances.size()) {
                IAPPluginActivity iAPPluginActivity = sInstances.get(i3).get();
                if (iAPPluginActivity != null) {
                    iAPPluginActivity.IFinish();
                    sInstances.remove(i3);
                    i2 = i3 - 1;
                } else {
                    i2 = i3;
                }
                i3 = i2 + 1;
            }
        }
    }

    public static ClassLoader getOrCreateClassLoader(Context context, String str) {
        return APPluginLoader.getOrCreateClassLoader(context, str);
    }

    static void updateReference() {
        int i2;
        synchronized (sInstances) {
            int i3 = 0;
            while (i3 < sInstances.size()) {
                if (sInstances.get(i3).get() == null) {
                    sInstances.remove(i3);
                    i2 = i3 - 1;
                } else {
                    i2 = i3;
                }
                i3 = i2 + 1;
            }
        }
    }

    private static boolean removeActivity(IAPPluginActivity iAPPluginActivity) {
        synchronized (sInstances) {
            for (int i2 = 0; i2 < sInstances.size(); i2++) {
                if (sInstances.get(i2).get() == iAPPluginActivity) {
                    sInstances.remove(i2);
                    return true;
                }
            }
            return false;
        }
    }
}
