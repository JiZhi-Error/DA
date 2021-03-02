package com.tencent.mm.sdk.vendor;

import android.content.Context;
import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.reflect.InvocationTargetException;

public class Huawei {
    private static final String HUAWEI_SYSTEM_EMUI10_START = "EmotionUI_10";
    private static final String HUAWEI_SYSTEM_EMUI8_START = "EmotionUI_8";
    private static final String HUAWEI_SYSTEM_EMUI9_START = "EmotionUI_9";
    private static final String HUAWEI_SYSTEM_NOT_BELOW_EMUI10_START = "EmotionUI_1";
    private static final String HUAWEI_SYSTEM_STRING = "ro.build.version.emui";
    private static final String TAG = "MicroMsg.Vendor.Huawei";
    private static Boolean ifHUAWEI = null;
    private static String systemName = null;

    public static boolean huaweihasCutOut(Context context) {
        AppMethodBeat.i(153472);
        if (context == null) {
            AppMethodBeat.o(153472);
            return false;
        }
        try {
            Class<?> loadClass = context.getClassLoader().loadClass("com.huawei.android.util.HwNotchSizeUtil");
            boolean booleanValue = ((Boolean) loadClass.getMethod("hasNotchInScreen", new Class[0]).invoke(loadClass, new Object[0])).booleanValue();
            Log.d(TAG, "huawei hasCutOut: %s", Boolean.valueOf(booleanValue));
            AppMethodBeat.o(153472);
            return booleanValue;
        } catch (ClassNotFoundException e2) {
            Log.e(TAG, "hasCutOut, ClassNotFoundException!!");
            Log.d(TAG, "huawei hasCutOut: %s", Boolean.FALSE);
            AppMethodBeat.o(153472);
            return false;
        } catch (NoSuchMethodException e3) {
            Log.e(TAG, "hasCutOut, NoSuchMethodException!!");
            Log.d(TAG, "huawei hasCutOut: %s", Boolean.FALSE);
            AppMethodBeat.o(153472);
            return false;
        } catch (IllegalAccessException e4) {
            Log.e(TAG, "hasCutOut, IllegalAccessException!!");
            Log.d(TAG, "huawei hasCutOut: %s", Boolean.FALSE);
            AppMethodBeat.o(153472);
            return false;
        } catch (InvocationTargetException e5) {
            Log.e(TAG, "hasCutOut, InvocationTargetException!!");
            Log.d(TAG, "huawei hasCutOut: %s", Boolean.FALSE);
            AppMethodBeat.o(153472);
            return false;
        } catch (Throwable th) {
            Log.d(TAG, "huawei hasCutOut: %s", Boolean.FALSE);
            AppMethodBeat.o(153472);
            return false;
        }
    }

    public static boolean ifHUAWEI() {
        AppMethodBeat.i(153473);
        if (ifHUAWEI == null) {
            String str = Build.BRAND;
            Log.i(TAG, "Build.BRAND = %s", str);
            if ("HONOR".equalsIgnoreCase(str)) {
                ifHUAWEI = Boolean.TRUE;
            } else if ("HUAWEI".equalsIgnoreCase(str)) {
                ifHUAWEI = Boolean.TRUE;
            } else {
                ifHUAWEI = Boolean.FALSE;
            }
        }
        boolean booleanValue = ifHUAWEI.booleanValue();
        AppMethodBeat.o(153473);
        return booleanValue;
    }

    public static boolean isEMUI8() {
        AppMethodBeat.i(214369);
        if (getProperty().startsWith(HUAWEI_SYSTEM_EMUI8_START.toLowerCase())) {
            AppMethodBeat.o(214369);
            return true;
        }
        AppMethodBeat.o(214369);
        return false;
    }

    public static boolean isEMUI9() {
        AppMethodBeat.i(214370);
        if (getProperty().startsWith(HUAWEI_SYSTEM_EMUI9_START.toLowerCase())) {
            AppMethodBeat.o(214370);
            return true;
        }
        AppMethodBeat.o(214370);
        return false;
    }

    public static boolean isEMUI10() {
        AppMethodBeat.i(214371);
        if (getProperty().startsWith(HUAWEI_SYSTEM_EMUI10_START.toLowerCase())) {
            AppMethodBeat.o(214371);
            return true;
        }
        AppMethodBeat.o(214371);
        return false;
    }

    public static boolean isNotBelowEMUI10() {
        AppMethodBeat.i(214372);
        if (getProperty().startsWith(HUAWEI_SYSTEM_NOT_BELOW_EMUI10_START.toLowerCase())) {
            AppMethodBeat.o(214372);
            return true;
        }
        AppMethodBeat.o(214372);
        return false;
    }

    private static String getProperty() {
        String str;
        AppMethodBeat.i(214373);
        if (!Util.isNullOrNil(systemName)) {
            String str2 = systemName;
            AppMethodBeat.o(214373);
            return str2;
        }
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            str = (String) cls.getMethod("get", String.class, String.class).invoke(cls, HUAWEI_SYSTEM_STRING, "unknown");
        } catch (Exception e2) {
            Log.e(TAG, "getProperty() Exception:%s", e2.getMessage());
            str = "unknown";
        }
        String lowerCase = Util.nullAs(str, "").toLowerCase();
        systemName = lowerCase;
        AppMethodBeat.o(214373);
        return lowerCase;
    }
}
