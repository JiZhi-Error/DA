package com.tencent.midas.jsbridge;

import android.content.Context;
import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.APLog;
import com.tencent.midas.data.APPluginDataInterface;
import com.tencent.midas.data.APPluginReportManager;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class APX5 {
    public static void initX5(Context context) {
        AppMethodBeat.i(192822);
        APLog.e("APX5", ">>>>>>> initX5 Start <<<<<<<");
        if (!isX5Enabled(context)) {
            APLog.e("APX5", ">>>>>>> X5 is missed or disabled, use native WebView");
            AppMethodBeat.o(192822);
            return;
        }
        APLog.e("APX5", ">>>>>>> initX5 End <<<<<<<");
        AppMethodBeat.o(192822);
    }

    private static boolean initTbs(Context context) {
        boolean z = false;
        AppMethodBeat.i(192823);
        APLog.e("APX5", "init Tbs Start");
        APPluginReportManager.getInstance().insertData(APPluginDataInterface.singleton().getLaunchInterface(), APPluginReportManager.MIDASPLUGIN_X5_INIT, "", "");
        try {
            String tbsVersion = getTbsVersion();
            APLog.e("APX5", "get tbs version: ".concat(String.valueOf(tbsVersion)));
            if (hasInitX5Method()) {
                APLog.e("APX5", "tbs has initX5 method");
                initX5Environment(context);
                z = true;
                APLog.e("APX5", "init Tbs Success. use X5 instead of Native WebView");
            } else {
                APLog.e("APX5", "tbs has no initX5 method");
                APLog.e("APX5", "unsupported tbs, version: ".concat(String.valueOf(tbsVersion)));
            }
        } catch (Throwable th) {
            APLog.e("APX5", "init tbs failed, use native WebView!");
            APLog.e("APX5", "unsupported tbs: exception: " + th.getMessage());
        }
        APLog.e("APX5", "initTbs End");
        APPluginReportManager.getInstance().insertData(APPluginDataInterface.singleton().getLaunchInterface(), z ? APPluginReportManager.MIDASPLUGIN_X5_INIT_SUCCESS : APPluginReportManager.MIDASPLUGIN_X5_INIT_FAIL, "", "");
        AppMethodBeat.o(192823);
        return z;
    }

    public static boolean isX5Enabled(Context context) {
        boolean z;
        AppMethodBeat.i(192824);
        Context applicationContext = context.getApplicationContext();
        String string = applicationContext.getSharedPreferences(APPluginDataInterface.SHARE_PREFERENCE_NAME, 4).getString("enableX5", "1");
        if (!TextUtils.isEmpty(string)) {
            z = !string.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO);
        } else {
            z = true;
        }
        APLog.e("APX5", "is enable X5: ".concat(String.valueOf(string)));
        if (!z || !initTbs(applicationContext)) {
            AppMethodBeat.o(192824);
            return false;
        }
        AppMethodBeat.o(192824);
        return true;
    }

    private static boolean hasInitX5Method() {
        AppMethodBeat.i(192825);
        try {
            if (Class.forName("com.tencent.smtt.sdk.QbSdk").getMethod("initX5Environment", Context.class, Class.forName("com.tencent.smtt.sdk.QbSdk$PreInitCallback")) != null) {
                AppMethodBeat.o(192825);
                return true;
            }
            AppMethodBeat.o(192825);
            return false;
        } catch (ClassNotFoundException | NoSuchMethodException e2) {
            AppMethodBeat.o(192825);
            return false;
        }
    }

    private static void initX5Environment(final Context context) {
        AppMethodBeat.i(192826);
        new Thread(new Runnable() {
            /* class com.tencent.midas.jsbridge.APX5.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(192811);
                try {
                    Method method = Class.forName("com.tencent.smtt.sdk.QbSdk").getMethod("initX5Environment", Context.class, Class.forName("com.tencent.smtt.sdk.QbSdk$PreInitCallback"));
                    if (method != null) {
                        method.setAccessible(true);
                        method.invoke(null, context.getApplicationContext(), null);
                    }
                    AppMethodBeat.o(192811);
                } catch (Exception e2) {
                    AppMethodBeat.o(192811);
                }
            }
        }).start();
        AppMethodBeat.o(192826);
    }

    private static boolean needDownloadTbs(Context context) {
        AppMethodBeat.i(192827);
        try {
            Method method = Class.forName("com.tencent.smtt.sdk.TbsDownloader").getMethod("needDownload", Context.class);
            if (method != null) {
                method.setAccessible(true);
                boolean booleanValue = ((Boolean) method.invoke(null, context)).booleanValue();
                AppMethodBeat.o(192827);
                return booleanValue;
            }
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e2) {
        }
        AppMethodBeat.o(192827);
        return false;
    }

    private static void preInit(Context context) {
        AppMethodBeat.i(192828);
        try {
            Method method = Class.forName("com.tencent.smtt.sdk.QbSdk").getMethod("preInit", Context.class);
            if (method != null) {
                method.setAccessible(true);
                method.invoke(null, context);
            }
            AppMethodBeat.o(192828);
        } catch (ClassNotFoundException e2) {
            AppMethodBeat.o(192828);
        } catch (NoSuchMethodException e3) {
            AppMethodBeat.o(192828);
        } catch (InvocationTargetException e4) {
            AppMethodBeat.o(192828);
        } catch (IllegalAccessException e5) {
            AppMethodBeat.o(192828);
        }
    }

    private static String getTbsVersion() {
        AppMethodBeat.i(192829);
        try {
            Class<?> cls = Class.forName("com.tencent.smtt.sdk.TbsConfig");
            Field field = cls.getField("TBS_SDK_VERSIONNAME");
            field.setAccessible(true);
            String str = (String) field.get(cls);
            AppMethodBeat.o(192829);
            return str;
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException e2) {
            AppMethodBeat.o(192829);
            return "unknown";
        }
    }
}
