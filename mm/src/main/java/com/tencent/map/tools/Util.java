package com.tencent.map.tools;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.ConfigurationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.security.MessageDigest;

public class Util {
    private static final boolean DEBUG = false;
    private static final int DEFAUlT_GlEsVersion = 65537;
    public static final String META_NAME_API_KEY = "TencentMapSDK";
    public static final int SMALL_SCREEN_THRESHOLD = 400;
    private static final String TAG = "Util";

    public static float getDensity(Context context) {
        AppMethodBeat.i(180753);
        if (context == null) {
            AppMethodBeat.o(180753);
            return 1.0f;
        }
        float f2 = context.getResources().getDisplayMetrics().density;
        AppMethodBeat.o(180753);
        return f2;
    }

    public static int getWindowWidth(Context context) {
        AppMethodBeat.i(180754);
        int i2 = context.getResources().getDisplayMetrics().widthPixels;
        AppMethodBeat.o(180754);
        return i2;
    }

    public static int getWindowHeight(Context context) {
        AppMethodBeat.i(180755);
        int i2 = context.getResources().getDisplayMetrics().heightPixels;
        AppMethodBeat.o(180755);
        return i2;
    }

    public static int getOpenglesVersion(Context context) {
        AppMethodBeat.i(180756);
        ConfigurationInfo deviceConfigurationInfo = ((ActivityManager) context.getSystemService(EnvConsts.ACTIVITY_MANAGER_SRVNAME)).getDeviceConfigurationInfo();
        if (deviceConfigurationInfo != null) {
            int i2 = deviceConfigurationInfo.reqGlEsVersion;
            AppMethodBeat.o(180756);
            return i2;
        }
        AppMethodBeat.o(180756);
        return 65537;
    }

    public static String getAppVersion(Context context) {
        AppMethodBeat.i(180757);
        if (context == null) {
            AppMethodBeat.o(180757);
            return "";
        }
        String str = "";
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            str = packageInfo.versionName + packageInfo.versionCode;
        } catch (Exception e2) {
        }
        AppMethodBeat.o(180757);
        return str;
    }

    public static String getMetaKey(Context context, String str) {
        AppMethodBeat.i(180758);
        if (context == null) {
            AppMethodBeat.o(180758);
            return "";
        }
        ApplicationInfo applicationInfo = null;
        try {
            applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
        } catch (PackageManager.NameNotFoundException e2) {
        }
        if (applicationInfo == null) {
            AppMethodBeat.o(180758);
            return "";
        } else if (applicationInfo.metaData == null) {
            AppMethodBeat.o(180758);
            return "";
        } else {
            String string = applicationInfo.metaData.getString(str);
            AppMethodBeat.o(180758);
            return string;
        }
    }

    @SuppressLint({"HardwareIds"})
    public static String getMacAddress(Context context) {
        AppMethodBeat.i(180759);
        WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi");
        if (wifiManager == null) {
            AppMethodBeat.o(180759);
            return "";
        }
        WifiInfo connectionInfo = wifiManager.getConnectionInfo();
        if (connectionInfo == null) {
            AppMethodBeat.o(180759);
            return "";
        }
        String macAddress = connectionInfo.getMacAddress();
        if (macAddress == null) {
            macAddress = "";
        }
        AppMethodBeat.o(180759);
        return macAddress;
    }

    @SuppressLint({"HardwareIds", "MissingPermission"})
    public static String getIMei(Context context) {
        String str;
        AppMethodBeat.i(180760);
        if (context == null) {
            AppMethodBeat.o(180760);
            return "";
        }
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager == null) {
            AppMethodBeat.o(180760);
            return "";
        }
        int phoneType = telephonyManager.getPhoneType();
        if (Build.VERSION.SDK_INT >= 23) {
            if (context.checkSelfPermission("android.permission.READ_PHONE_STATE") == 0) {
                if (Build.VERSION.SDK_INT < 29 || context.checkSelfPermission("android.permission.READ_PRIVILEGED_PHONE_STATE") != 0) {
                    str = telephonyManager.getDeviceId();
                } else if (phoneType == 1) {
                    try {
                        str = telephonyManager.getImei();
                    } catch (Exception e2) {
                        str = null;
                    }
                } else if (phoneType == 2) {
                    try {
                        str = telephonyManager.getMeid();
                    } catch (Exception e3) {
                        str = null;
                    }
                }
            }
            str = null;
        } else {
            try {
                str = telephonyManager.getDeviceId();
            } catch (Exception e4) {
            }
        }
        if (TextUtils.isEmpty(str)) {
            str = Settings.Secure.getString(context.getContentResolver(), "android_id");
        }
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        AppMethodBeat.o(180760);
        return str;
    }

    public static String getRawAppName(Context context) {
        CharSequence charSequence;
        AppMethodBeat.i(193520);
        if (context == null) {
            AppMethodBeat.o(193520);
            return "";
        }
        PackageManager packageManager = context.getPackageManager();
        ApplicationInfo applicationInfo = null;
        try {
            applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 128);
        } catch (PackageManager.NameNotFoundException e2) {
        }
        if (applicationInfo != null) {
            charSequence = applicationInfo.loadLabel(packageManager);
        } else {
            charSequence = "can't find app name";
        }
        String charSequence2 = charSequence.toString();
        AppMethodBeat.o(193520);
        return charSequence2;
    }

    public static String getAppName(Context context) {
        AppMethodBeat.i(180761);
        String rawAppName = getRawAppName(context);
        try {
            rawAppName = URLEncoder.encode(rawAppName, ProtocolPackage.ServerEncoding);
        } catch (Exception e2) {
        }
        AppMethodBeat.o(180761);
        return rawAppName;
    }

    public static String getResolution(Context context) {
        AppMethodBeat.i(180762);
        if (context == null) {
            AppMethodBeat.o(180762);
            return "";
        }
        String str = "";
        try {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            str = displayMetrics.widthPixels + "*" + displayMetrics.heightPixels;
        } catch (Exception e2) {
        }
        AppMethodBeat.o(180762);
        return str;
    }

    public static String filterBuilder(String... strArr) {
        String str;
        AppMethodBeat.i(180763);
        String str2 = "";
        if (strArr != null) {
            str2 = "category=";
            int i2 = 0;
            while (i2 < strArr.length) {
                if (i2 == 0) {
                    str = str2 + strArr[i2];
                } else {
                    str = str2 + "," + strArr[i2];
                }
                i2++;
                str2 = str;
            }
        }
        AppMethodBeat.o(180763);
        return str2;
    }

    public static <T> T newInstance(Class<T> cls, Object... objArr) {
        AppMethodBeat.i(180764);
        if (cls == null || cls.isEnum() || cls.isInterface() || cls.isAnnotation() || cls.isArray()) {
            AppMethodBeat.o(180764);
            return null;
        }
        Constructor<?>[] declaredConstructors = cls.getDeclaredConstructors();
        for (int i2 = 0; i2 < declaredConstructors.length; i2++) {
            if (isMatchClassTypes(declaredConstructors[i2].getParameterTypes(), objArr)) {
                try {
                    declaredConstructors[i2].setAccessible(true);
                    T t = (T) declaredConstructors[i2].newInstance(objArr);
                    AppMethodBeat.o(180764);
                    return t;
                } catch (IllegalAccessException | InstantiationException e2) {
                } catch (InvocationTargetException e3) {
                    RuntimeException runtimeException = new RuntimeException(e3.getTargetException());
                    AppMethodBeat.o(180764);
                    throw runtimeException;
                }
            }
        }
        try {
            T newInstance = cls.newInstance();
            AppMethodBeat.o(180764);
            return newInstance;
        } catch (IllegalAccessException e4) {
            AppMethodBeat.o(180764);
            return null;
        } catch (InstantiationException e5) {
            RuntimeException runtimeException2 = new RuntimeException(e5);
            AppMethodBeat.o(180764);
            throw runtimeException2;
        }
    }

    private static boolean isMatchClassTypes(Class<?>[] clsArr, Object[] objArr) {
        AppMethodBeat.i(180765);
        if (clsArr.length != objArr.length) {
            AppMethodBeat.o(180765);
            return false;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < clsArr.length; i3++) {
            if (clsArr[i3] == objArr[i3].getClass() || clsArr[i3].isAssignableFrom(objArr[i3].getClass())) {
                i2++;
            }
        }
        if (i2 == clsArr.length) {
            AppMethodBeat.o(180765);
            return true;
        }
        AppMethodBeat.o(180765);
        return false;
    }

    public static void setField(Object obj, String str, Object obj2) {
        AppMethodBeat.i(180766);
        if (obj == null) {
            AppMethodBeat.o(180766);
            return;
        }
        try {
            Field declaredField = obj.getClass().getDeclaredField(str);
            declaredField.setAccessible(true);
            declaredField.set(obj, obj2);
            AppMethodBeat.o(180766);
        } catch (NoSuchFieldException e2) {
            AppMethodBeat.o(180766);
        } catch (IllegalAccessException e3) {
            AppMethodBeat.o(180766);
        }
    }

    public static Object getField(Object obj, String str) {
        Object obj2 = null;
        AppMethodBeat.i(180767);
        if (obj == null) {
            AppMethodBeat.o(180767);
        } else {
            try {
                Field declaredField = obj.getClass().getDeclaredField(str);
                declaredField.setAccessible(true);
                obj2 = declaredField.get(obj);
                AppMethodBeat.o(180767);
            } catch (IllegalAccessException | NoSuchFieldException e2) {
                AppMethodBeat.o(180767);
            }
        }
        return obj2;
    }

    public static Object invokeMethod(Object obj, String str, Object... objArr) {
        AppMethodBeat.i(180768);
        if (obj == null) {
            AppMethodBeat.o(180768);
            return null;
        }
        Class[] clsArr = new Class[objArr.length];
        for (int i2 = 0; i2 < clsArr.length; i2++) {
            clsArr[i2] = objArr[i2].getClass();
        }
        try {
            Method findMethod = findMethod(obj.getClass(), str, clsArr);
            if (findMethod != null) {
                findMethod.setAccessible(true);
                Object invoke = findMethod.invoke(obj, objArr);
                AppMethodBeat.o(180768);
                return invoke;
            }
        } catch (IllegalAccessException e2) {
        } catch (InvocationTargetException e3) {
            RuntimeException runtimeException = new RuntimeException(e3.getTargetException());
            AppMethodBeat.o(180768);
            throw runtimeException;
        }
        AppMethodBeat.o(180768);
        return null;
    }

    public static Object invokeMethod(Object obj, String str, Class[] clsArr, Object[] objArr) {
        Object obj2 = null;
        AppMethodBeat.i(180769);
        if (obj == null) {
            AppMethodBeat.o(180769);
        } else {
            try {
                Method findMethod = findMethod(obj.getClass(), str, clsArr);
                if (findMethod != null) {
                    findMethod.setAccessible(true);
                    obj2 = findMethod.invoke(obj, objArr);
                    AppMethodBeat.o(180769);
                }
            } catch (IllegalAccessException e2) {
            } catch (InvocationTargetException e3) {
                RuntimeException runtimeException = new RuntimeException(e3.getTargetException());
                AppMethodBeat.o(180769);
                throw runtimeException;
            }
            AppMethodBeat.o(180769);
        }
        return obj2;
    }

    public static Object invokeStaticMethod(Class cls, String str, Class[] clsArr, Object[] objArr) {
        Object obj = null;
        AppMethodBeat.i(193521);
        if (cls == null) {
            AppMethodBeat.o(193521);
        } else {
            try {
                Method findMethod = findMethod(cls, str, clsArr);
                if (findMethod != null) {
                    findMethod.setAccessible(true);
                    obj = findMethod.invoke(cls, objArr);
                    AppMethodBeat.o(193521);
                }
            } catch (IllegalAccessException e2) {
            } catch (InvocationTargetException e3) {
                RuntimeException runtimeException = new RuntimeException(e3.getTargetException());
                AppMethodBeat.o(193521);
                throw runtimeException;
            }
            AppMethodBeat.o(193521);
        }
        return obj;
    }

    public static Method findMethod(Class cls, String str, Class[] clsArr) {
        AppMethodBeat.i(180770);
        Method method = null;
        try {
            method = cls.getDeclaredMethod(str, clsArr);
        } catch (NoSuchMethodException e2) {
            if (cls.getSuperclass() != Object.class) {
                method = findMethod(cls.getSuperclass(), str, clsArr);
            }
        }
        AppMethodBeat.o(180770);
        return method;
    }

    public static Class findClass(String str, ClassLoader classLoader) {
        AppMethodBeat.i(180771);
        try {
            Class<?> cls = Class.forName(str, false, classLoader);
            AppMethodBeat.o(180771);
            return cls;
        } catch (ClassNotFoundException e2) {
            AppMethodBeat.o(180771);
            return null;
        }
    }

    public static <T> Class<? extends T> findClass(String str, Class<T> cls, ClassLoader classLoader) {
        AppMethodBeat.i(180772);
        try {
            Class<? extends T> cls2 = (Class<? extends T>) Class.forName(str, false, classLoader);
            if (cls.isAssignableFrom(cls2)) {
                AppMethodBeat.o(180772);
                return cls2;
            }
        } catch (ClassNotFoundException e2) {
        }
        AppMethodBeat.o(180772);
        return null;
    }

    public static String getMD5String(String str) {
        AppMethodBeat.i(193522);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(193522);
            return "";
        }
        String mD5String = getMD5String(str.getBytes());
        AppMethodBeat.o(193522);
        return mD5String;
    }

    public static String getMD5String(byte[] bArr) {
        String str;
        AppMethodBeat.i(193523);
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(bArr);
            byte[] digest = instance.digest();
            char[] cArr2 = new char[32];
            int i2 = 0;
            int i3 = 0;
            while (i2 < 16) {
                byte b2 = digest[i2];
                int i4 = i3 + 1;
                cArr2[i3] = cArr[(b2 >>> 4) & 15];
                cArr2[i4] = cArr[b2 & 15];
                i2++;
                i3 = i4 + 1;
            }
            str = new String(cArr2);
        } catch (Exception e2) {
            str = null;
        }
        AppMethodBeat.o(193523);
        return str;
    }

    public static <T> void foreach(Iterable<T> iterable, Callback<T> callback) {
        AppMethodBeat.i(193524);
        if (iterable == null || callback == null) {
            AppMethodBeat.o(193524);
            return;
        }
        for (T t : iterable) {
            callback.callback(t);
        }
        AppMethodBeat.o(193524);
    }

    public static <T> void where(Iterable<T> iterable, ReturnCallback<Boolean, T> returnCallback) {
        AppMethodBeat.i(193525);
        if (iterable == null || returnCallback == null) {
            AppMethodBeat.o(193525);
            return;
        }
        for (T t : iterable) {
            if (returnCallback.callback(t).booleanValue()) {
                AppMethodBeat.o(193525);
                return;
            }
        }
        returnCallback.callback(null);
        AppMethodBeat.o(193525);
    }
}
