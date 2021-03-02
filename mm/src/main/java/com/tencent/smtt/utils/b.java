package com.tencent.smtt.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.TbsDownloadConfig;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import java.io.File;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.NetworkInterface;
import java.security.cert.Certificate;
import java.util.Collections;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class b {

    /* renamed from: a  reason: collision with root package name */
    public static String f2161a = "";

    /* renamed from: b  reason: collision with root package name */
    public static String f2162b = "";

    /* renamed from: c  reason: collision with root package name */
    public static String f2163c = "";

    /* renamed from: d  reason: collision with root package name */
    public static String f2164d = "";

    /* renamed from: e  reason: collision with root package name */
    public static String f2165e = "";

    public static String a(Context context) {
        AppMethodBeat.i(53959);
        String str = null;
        try {
            str = context.getPackageName();
        } catch (Exception e2) {
        }
        AppMethodBeat.o(53959);
        return str;
    }

    public static int b(Context context) {
        AppMethodBeat.i(53960);
        int i2 = Build.VERSION.SDK_INT;
        AppMethodBeat.o(53960);
        return i2;
    }

    public static String a() {
        AppMethodBeat.i(53966);
        try {
            String str = new String(Build.MODEL.getBytes(MimeTypeUtil.ContentType.DEFAULT_CHARSET), "ISO8859-1");
            AppMethodBeat.o(53966);
            return str;
        } catch (Exception e2) {
            String str2 = Build.MODEL;
            AppMethodBeat.o(53966);
            return str2;
        }
    }

    public static String c(Context context) {
        AppMethodBeat.i(53963);
        String str = null;
        try {
            str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Exception e2) {
        }
        AppMethodBeat.o(53963);
        return str;
    }

    public static int d(Context context) {
        int i2 = 0;
        AppMethodBeat.i(188548);
        try {
            i2 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (Exception e2) {
        }
        AppMethodBeat.o(188548);
        return i2;
    }

    public static String a(Context context, String str) {
        AppMethodBeat.i(53961);
        String str2 = null;
        try {
            try {
                str2 = String.valueOf(Integer.toHexString(Integer.parseInt(String.valueOf(context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.get(str)))));
            } catch (Exception e2) {
            }
        } catch (Exception e3) {
        }
        AppMethodBeat.o(53961);
        return str2;
    }

    public static void b(Context context, String str) {
        AppMethodBeat.i(53962);
        try {
            TbsDownloadConfig instance = TbsDownloadConfig.getInstance(context);
            instance.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_GUID, str);
            instance.commit();
            AppMethodBeat.o(53962);
        } catch (Exception e2) {
            AppMethodBeat.o(53962);
        }
    }

    public static String e(Context context) {
        AppMethodBeat.i(53965);
        String str = "";
        try {
            str = TbsDownloadConfig.getInstance(context).mPreferences.getString(TbsDownloadConfig.TbsConfigKey.KEY_GUID, "");
        } catch (Exception e2) {
        }
        AppMethodBeat.o(53965);
        return str;
    }

    public static String f(Context context) {
        String str;
        AppMethodBeat.i(53967);
        if (!QbSdk.isEnableSensitiveApi()) {
            TbsLog.i("AppUtil", "isEnableSensitiveApi = false");
            AppMethodBeat.o(53967);
            return "";
        }
        if (!TextUtils.isEmpty(f2161a)) {
            str = f2161a;
        } else {
            try {
                str = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
            } catch (Exception e2) {
                str = "";
            }
        }
        AppMethodBeat.o(53967);
        return str;
    }

    public static String g(Context context) {
        String str;
        AppMethodBeat.i(53969);
        if (!QbSdk.isEnableSensitiveApi()) {
            TbsLog.i("AppUtil", "isEnableSensitiveApi = false");
            AppMethodBeat.o(53969);
            return "";
        }
        if (!TextUtils.isEmpty(f2162b)) {
            str = f2162b;
        } else {
            try {
                str = ((TelephonyManager) context.getSystemService("phone")).getSubscriberId();
            } catch (Exception e2) {
                str = "";
            }
        }
        AppMethodBeat.o(53969);
        return str;
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0068 A[SYNTHETIC, Splitter:B:23:0x0068] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x006d A[SYNTHETIC, Splitter:B:26:0x006d] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0079 A[SYNTHETIC, Splitter:B:32:0x0079] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x007e A[SYNTHETIC, Splitter:B:35:0x007e] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String b() {
        /*
        // Method dump skipped, instructions count: 156
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.utils.b.b():java.lang.String");
    }

    public static String h(Context context) {
        AppMethodBeat.i(188549);
        if (!QbSdk.isEnableSensitiveApi()) {
            TbsLog.i("AppUtil", "isEnableSensitiveApi = false");
            AppMethodBeat.o(188549);
            return "";
        }
        if (TextUtils.isEmpty(f2164d)) {
            if (Build.VERSION.SDK_INT < 23) {
                try {
                    WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi");
                    WifiInfo connectionInfo = wifiManager == null ? null : wifiManager.getConnectionInfo();
                    f2164d = connectionInfo == null ? "" : connectionInfo.getMacAddress();
                } catch (Exception e2) {
                }
            } else {
                f2164d = c();
            }
        }
        String str = f2164d;
        AppMethodBeat.o(188549);
        return str;
    }

    public static String c() {
        AppMethodBeat.i(188550);
        try {
            if (!QbSdk.isEnableSensitiveApi()) {
                TbsLog.i("AppUtil", "isEnableSensitiveApi = false");
                AppMethodBeat.o(188550);
                return "";
            }
            for (NetworkInterface networkInterface : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                if (networkInterface.getName().equalsIgnoreCase("wlan0")) {
                    byte[] hardwareAddress = networkInterface.getHardwareAddress();
                    if (hardwareAddress == null) {
                        AppMethodBeat.o(188550);
                        return "";
                    }
                    StringBuilder sb = new StringBuilder();
                    int length = hardwareAddress.length;
                    for (int i2 = 0; i2 < length; i2++) {
                        sb.append(String.format("%02X:", Byte.valueOf(hardwareAddress[i2])));
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    String sb2 = sb.toString();
                    AppMethodBeat.o(188550);
                    return sb2;
                }
            }
            AppMethodBeat.o(188550);
            return "02:00:00:00:00:00";
        } catch (Exception e2) {
        }
    }

    private static String a(String str) {
        return str == null ? "" : str;
    }

    public static String i(Context context) {
        AppMethodBeat.i(188551);
        if (!QbSdk.isEnableSensitiveApi()) {
            TbsLog.i("AppUtil", "isEnableSensitiveApi = false");
            AppMethodBeat.o(188551);
            return "";
        } else if (!TextUtils.isEmpty(f2165e)) {
            String str = f2165e;
            AppMethodBeat.o(188551);
            return str;
        } else {
            try {
                f2165e = Settings.Secure.getString(context.getContentResolver(), "android_id");
            } catch (Exception e2) {
            }
            String str2 = f2165e;
            AppMethodBeat.o(188551);
            return str2;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0052 A[Catch:{ Throwable -> 0x007f }] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00aa  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00c1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(android.content.Context r5, boolean r6, java.io.File r7) {
        /*
        // Method dump skipped, instructions count: 235
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.utils.b.a(android.content.Context, boolean, java.io.File):java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0025 A[Catch:{ Exception -> 0x0047 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String a(android.content.Context r5, java.io.File r6, boolean r7) {
        /*
        // Method dump skipped, instructions count: 102
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.utils.b.a(android.content.Context, java.io.File, boolean):java.lang.String");
    }

    private static String a(File file) {
        String str;
        String str2;
        AppMethodBeat.i(53972);
        TbsLog.d("AppUtil", "[getSignatureFromApk]## file=".concat(String.valueOf(file)));
        try {
            JarFile jarFile = new JarFile(file);
            byte[] bArr = new byte[8192];
            String a2 = a(a(jarFile, jarFile.getJarEntry(ShareConstants.RES_MANIFEST), bArr)[0].getEncoded());
            Enumeration<JarEntry> entries = jarFile.entries();
            while (true) {
                if (!entries.hasMoreElements()) {
                    str = a2;
                    break;
                }
                JarEntry nextElement = entries.nextElement();
                String name = nextElement.getName();
                if (name != null) {
                    TbsLog.d("AppUtil", "[getSignatureFromApk]## loadCertificates & check:".concat(String.valueOf(name)));
                    Certificate[] a3 = a(jarFile, nextElement, bArr);
                    if (a3 != null) {
                        str2 = a(a3[0].getEncoded());
                    } else {
                        TbsLog.d("AppUtil", "[getSignatureFromApk]## certs2 is null!");
                        str2 = null;
                    }
                    if (str2 == null) {
                        TbsLog.d("AppUtil", "[getSignatureFromApk]## loadCertificates failed!");
                        if (!name.startsWith("META-INF/")) {
                            str = null;
                            break;
                        }
                    } else {
                        boolean equals = str2.equals(a2);
                        TbsLog.d("AppUtil", "[getSignatureFromApk]## loadCertificates check:".concat(String.valueOf(equals)));
                        if (!equals) {
                            str = null;
                            break;
                        }
                    }
                }
            }
        } catch (Exception e2) {
            str = null;
        }
        AppMethodBeat.o(53972);
        return str;
    }

    private static PackageInfo a(String str, int i2) {
        Class<?> cls;
        AppMethodBeat.i(53973);
        try {
            Class<?> cls2 = Class.forName("android.content.pm.PackageParser");
            Class<?>[] declaredClasses = cls2.getDeclaredClasses();
            int length = declaredClasses.length;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    cls = null;
                    break;
                }
                cls = declaredClasses[i3];
                if (cls.getName().compareTo("android.content.pm.PackageParser$Package") == 0) {
                    break;
                }
                i3++;
            }
            Constructor<?> constructor = cls2.getConstructor(String.class);
            Method declaredMethod = cls2.getDeclaredMethod("parsePackage", File.class, String.class, DisplayMetrics.class, Integer.TYPE);
            Method declaredMethod2 = cls2.getDeclaredMethod("collectCertificates", cls, Integer.TYPE);
            Method declaredMethod3 = cls2.getDeclaredMethod("generatePackageInfo", cls, int[].class, Integer.TYPE, Long.TYPE, Long.TYPE);
            constructor.setAccessible(true);
            declaredMethod.setAccessible(true);
            declaredMethod2.setAccessible(true);
            declaredMethod3.setAccessible(true);
            Object newInstance = constructor.newInstance(str);
            DisplayMetrics displayMetrics = new DisplayMetrics();
            displayMetrics.setToDefaults();
            Object invoke = declaredMethod.invoke(newInstance, new File(str), str, displayMetrics, 0);
            if (invoke == null) {
                AppMethodBeat.o(53973);
                return null;
            }
            if ((i2 & 64) != 0) {
                declaredMethod2.invoke(newInstance, invoke, 0);
            }
            PackageInfo packageInfo = (PackageInfo) declaredMethod3.invoke(null, invoke, null, Integer.valueOf(i2), 0, 0);
            AppMethodBeat.o(53973);
            return packageInfo;
        } catch (Exception e2) {
            AppMethodBeat.o(53973);
            return null;
        }
    }

    private static Certificate[] a(JarFile jarFile, JarEntry jarEntry, byte[] bArr) {
        AppMethodBeat.i(53974);
        InputStream inputStream = jarFile.getInputStream(jarEntry);
        do {
        } while (inputStream.read(bArr, 0, bArr.length) != -1);
        inputStream.close();
        if (jarEntry != null) {
            Certificate[] certificates = jarEntry.getCertificates();
            AppMethodBeat.o(53974);
            return certificates;
        }
        AppMethodBeat.o(53974);
        return null;
    }

    private static String a(byte[] bArr) {
        AppMethodBeat.i(53975);
        int length = bArr.length;
        char[] cArr = new char[(length * 2)];
        for (int i2 = 0; i2 < length; i2++) {
            byte b2 = bArr[i2];
            int i3 = (b2 >> 4) & 15;
            cArr[i2 * 2] = (char) (i3 >= 10 ? (i3 + 97) - 10 : i3 + 48);
            int i4 = b2 & 15;
            cArr[(i2 * 2) + 1] = (char) (i4 >= 10 ? (i4 + 97) - 10 : i4 + 48);
        }
        String str = new String(cArr);
        AppMethodBeat.o(53975);
        return str;
    }

    public static boolean d() {
        AppMethodBeat.i(188552);
        try {
            if (Build.VERSION.SDK_INT < 21) {
                AppMethodBeat.o(188552);
                return false;
            }
            Class<?> cls = Class.forName("dalvik.system.VMRuntime");
            if (cls == null) {
                AppMethodBeat.o(188552);
                return false;
            }
            Method declaredMethod = cls.getDeclaredMethod("getRuntime", new Class[0]);
            if (declaredMethod == null) {
                AppMethodBeat.o(188552);
                return false;
            }
            Object invoke = declaredMethod.invoke(null, new Object[0]);
            if (invoke == null) {
                AppMethodBeat.o(188552);
                return false;
            }
            Method declaredMethod2 = cls.getDeclaredMethod("is64Bit", new Class[0]);
            if (declaredMethod2 == null) {
                AppMethodBeat.o(188552);
                return false;
            }
            Object invoke2 = declaredMethod2.invoke(invoke, new Object[0]);
            if (invoke2 instanceof Boolean) {
                boolean booleanValue = ((Boolean) invoke2).booleanValue();
                AppMethodBeat.o(188552);
                return booleanValue;
            }
            AppMethodBeat.o(188552);
            return false;
        } catch (Throwable th) {
        }
    }
}
