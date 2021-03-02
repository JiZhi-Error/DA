package com.tencent.midas.plugin;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.APLog;
import com.tencent.midas.control.APMidasPayHelper;
import com.tencent.midas.data.APPluginReportManager;
import java.lang.reflect.Method;

public class APPluginInterfaceManager {
    public static final String TAG = "APPluginInterfaceManager";

    public static Object initPluginInterface(Context context, String str, String str2, String str3, Object[] objArr) {
        AppMethodBeat.i(193206);
        APLog.d(TAG, "Call into initPluginInterface  plugin = " + str + " interfaceClass = " + str2 + " methodName = " + str3 + " " + Thread.currentThread().getStackTrace()[3].toString());
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            APLog.i("APPLuginProxyActivity", "initPluginInterface objClass param is null");
            AppMethodBeat.o(193206);
            return null;
        }
        Class<?> objectClass = getObjectClass(context, str, str2, str3);
        if (objectClass == null) {
            APPluginReportManager.getInstance().insertData(APPluginReportManager.MIDASPLUGIN_TIMENAME_LAUNCHPAY, APPluginReportManager.MIDASPLUGIN_FORMAT_APKLOAD_FAIL, str, "objClassIsNull");
            if (APMidasPayHelper.MED_DISTRIBUTE_PAY.equals(str3)) {
                APLog.d(TAG, "initPluginInterface objClass is null, current method name = " + str3 + " we need to jump to pure h5 pay!");
                APPluginUtils.showLaunchPluginFail(context.getApplicationContext(), "", true);
            } else {
                APLog.d(TAG, "initPluginInterface objClass is null, current method name = " + str3 + " no need to jump to pure h5 pay!");
                APPluginUtils.showLaunchPluginFail(context.getApplicationContext(), "", false);
            }
            APPluginStatic.removeAll();
            APPluginInstallerAndUpdater.unInstallPlugin(context);
            AppMethodBeat.o(193206);
            return null;
        }
        Method method = objectClass.getMethod(str3, getParamsType(objArr));
        method.setAccessible(true);
        long currentTimeMillis = System.currentTimeMillis();
        Object invoke = method.invoke(objectClass, objArr);
        APLog.i("APPLuginProxyActivity", "initPluginInterface method=" + method + " obj=" + invoke + " time=" + (System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.o(193206);
        return invoke;
    }

    private static Class<?>[] getParamsType(Object[] objArr) {
        AppMethodBeat.i(193207);
        Class<?>[] clsArr = null;
        if (objArr != null) {
            int length = objArr.length;
            clsArr = new Class[length];
            for (int i2 = 0; i2 < length; i2++) {
                if (objArr[i2] != null) {
                    if (Activity.class.isAssignableFrom(objArr[i2].getClass())) {
                        clsArr[i2] = Activity.class;
                    } else {
                        clsArr[i2] = objArr[i2].getClass();
                    }
                }
            }
        }
        AppMethodBeat.o(193207);
        return clsArr;
    }

    public static Object initPluginInterface2(Context context, String str, String str2, String str3, Object[] objArr) {
        AppMethodBeat.i(193208);
        APLog.i("APPLuginProxyActivity", "initPluginInterface2 pluginName=".concat(String.valueOf(str)));
        APLog.i("APPLuginProxyActivity", "initPluginInterface2 interfaceClass=".concat(String.valueOf(str2)));
        APLog.i("APPLuginProxyActivity", "initPluginInterface2 methodName=".concat(String.valueOf(str3)));
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            APLog.i("APPLuginProxyActivity", "initPluginInterface2 objClass param is null");
            AppMethodBeat.o(193208);
            return null;
        }
        Class<?> objectClass = getObjectClass(context, str, str2, str3);
        if (objectClass == null) {
            APLog.i("APPLuginProxyActivity", "initPluginInterface2 objClass is null");
            APPluginReportManager.getInstance().insertData(APPluginReportManager.MIDASPLUGIN_TIMENAME_LAUNCHPAY, APPluginReportManager.MIDASPLUGIN_FORMAT_APKLOAD_FAIL, str, "objClassIsNull");
            APPluginUtils.showLaunchPluginFail(context.getApplicationContext(), "", false);
            APPluginStatic.removeAll();
            APPluginInstallerAndUpdater.unInstallPlugin(context);
            AppMethodBeat.o(193208);
            return null;
        }
        Class<?>[] clsArr = {objArr[0].getClass(), objArr[1].getClass(), objArr[2].getClass()};
        APLog.i("APPLuginProxyActivity", "initPluginInterface2 getMethod Name:".concat(String.valueOf(str3)));
        APLog.i("APPLuginProxyActivity", "initPluginInterface2 getMethod objClass:".concat(String.valueOf(objectClass)));
        for (int i2 = 0; i2 < 3; i2++) {
            APLog.i("APPLuginProxyActivity", "initPluginInterface2 getMethod paraTypes:" + clsArr[i2]);
        }
        Method method = objectClass.getMethod(str3, clsArr);
        APLog.i("APPLuginProxyActivity", "initPluginInterface2 getMethod method:".concat(String.valueOf(method)));
        method.setAccessible(true);
        Object invoke = method.invoke(objectClass, objArr);
        APLog.i("APPLuginProxyActivity", "initPluginInterface2 obj=".concat(String.valueOf(invoke)));
        AppMethodBeat.o(193208);
        return invoke;
    }

    public static Object initPluginInterface(Context context, String str, String str2, String str3, Object[] objArr, Class<?>[] clsArr) {
        AppMethodBeat.i(193209);
        APLog.i("APPLuginProxyActivity", "initPluginInterface2 pluginName=".concat(String.valueOf(str)));
        APLog.i("APPLuginProxyActivity", "initPluginInterface2 interfaceClass=".concat(String.valueOf(str2)));
        APLog.i("APPLuginProxyActivity", "initPluginInterface2 methodName=".concat(String.valueOf(str3)));
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            APLog.i("APPLuginProxyActivity", "initPluginInterface2 objClass param is null");
            AppMethodBeat.o(193209);
            return null;
        }
        Class<?> objectClass = getObjectClass(context, str, str2, str3);
        if (objectClass == null) {
            APLog.i("APPLuginProxyActivity", "initPluginInterface2 objClass is null");
            APPluginReportManager.getInstance().insertData(APPluginReportManager.MIDASPLUGIN_TIMENAME_LAUNCHPAY, APPluginReportManager.MIDASPLUGIN_FORMAT_APKLOAD_FAIL, str, "objClassIsNull");
            APPluginUtils.showLaunchPluginFail(context.getApplicationContext(), "", false);
            APPluginStatic.removeAll();
            APPluginInstallerAndUpdater.unInstallPlugin(context);
            AppMethodBeat.o(193209);
            return null;
        }
        APLog.i("APPLuginProxyActivity", "initPluginInterface2 getMethod Name:".concat(String.valueOf(str3)));
        APLog.i("APPLuginProxyActivity", "initPluginInterface2 getMethod objClass:".concat(String.valueOf(objectClass)));
        for (int i2 = 0; i2 < clsArr.length; i2++) {
            APLog.i("APPLuginProxyActivity", "initPluginInterface2 getMethod paraTypes:" + clsArr[i2]);
        }
        Method method = objectClass.getMethod(str3, clsArr);
        APLog.i("APPLuginProxyActivity", "initPluginInterface2 getMethod method:".concat(String.valueOf(method)));
        method.setAccessible(true);
        Object invoke = method.invoke(objectClass, objArr);
        APLog.i("APPLuginProxyActivity", "initPluginInterface2 obj=".concat(String.valueOf(invoke)));
        AppMethodBeat.o(193209);
        return invoke;
    }

    private static Class<?> getObjectClass(Context context, String str, String str2, String str3) {
        String str4;
        Class<?> cls;
        AppMethodBeat.i(193210);
        try {
            str4 = APPluginInstallerAndUpdater.getInstallPath(context, str).getCanonicalPath();
        } catch (Exception e2) {
            str4 = "";
        }
        try {
            if (APPluginStatic.sPackageInfoMap.get(str4) == null) {
                PackageInfo packageInfo = APApkFileParser.getPackageInfo(context, str4, 1);
                if (packageInfo == null) {
                    AppMethodBeat.o(193210);
                    return null;
                }
                APPluginStatic.sPackageInfoMap.put(str4, packageInfo);
            }
            cls = APPluginLoader.getOrCreateClassLoaderByPath(context, str, str4).loadClass(str2);
        } catch (Exception e3) {
            cls = null;
        }
        AppMethodBeat.o(193210);
        return cls;
    }
}
