package com.tencent.map.tools.internal;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.map.tools.EncryptAesUtils;
import com.tencent.map.tools.Util;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class x {

    /* renamed from: a  reason: collision with root package name */
    public static String f1424a = t.f1404e;

    /* renamed from: b  reason: collision with root package name */
    public static String f1425b = t.f1405f;

    /* renamed from: c  reason: collision with root package name */
    public static String f1426c = t.f1406g;

    /* renamed from: d  reason: collision with root package name */
    public static final String f1427d = t.f1408i;

    /* renamed from: e  reason: collision with root package name */
    public static final String f1428e = t.f1409j;

    /* renamed from: f  reason: collision with root package name */
    public static String f1429f = "complist_loading";

    /* renamed from: g  reason: collision with root package name */
    public static String f1430g = BuildConfig.KINDA_DEFAULT;

    /* renamed from: h  reason: collision with root package name */
    private static String f1431h = x.class.getSimpleName();

    /* renamed from: i  reason: collision with root package name */
    private static HashMap<String, w> f1432i = new HashMap<>();

    static {
        AppMethodBeat.i(193589);
        AppMethodBeat.o(193589);
    }

    public static File a(Context context, String str) {
        AppMethodBeat.i(193553);
        File file = new File(context.getFilesDir(), str);
        if (!file.exists()) {
            file.mkdirs();
        }
        AppMethodBeat.o(193553);
        return file;
    }

    public static String b(Context context, String str) {
        AppMethodBeat.i(193554);
        String str2 = context.getFilesDir().getAbsolutePath() + File.separator + str;
        AppMethodBeat.o(193554);
        return str2;
    }

    private static w d(Context context, String str) {
        AppMethodBeat.i(193555);
        if (f1432i.containsKey(str)) {
            w wVar = f1432i.get(str);
            AppMethodBeat.o(193555);
            return wVar;
        }
        w wVar2 = new w(context.getFilesDir().getAbsolutePath() + FilePathGenerator.ANDROID_DIR_SEP + t.D + FilePathGenerator.ANDROID_DIR_SEP + str);
        f1432i.put(str, wVar2);
        AppMethodBeat.o(193555);
        return wVar2;
    }

    public static boolean a(Context context, String str, String str2) {
        AppMethodBeat.i(193556);
        boolean a2 = d(context, str).a(str2.getBytes());
        AppMethodBeat.o(193556);
        return a2;
    }

    public static boolean a(Context context, String str, Long l) {
        AppMethodBeat.i(193557);
        boolean a2 = d(context, str).a(String.valueOf(l).getBytes());
        AppMethodBeat.o(193557);
        return a2;
    }

    public static String b(Context context, String str, String str2) {
        AppMethodBeat.i(193558);
        String a2 = d(context, str).a(str2);
        AppMethodBeat.o(193558);
        return a2;
    }

    public static Long b(Context context, String str, Long l) {
        AppMethodBeat.i(193559);
        try {
            l = Long.valueOf(Long.parseLong(d(context, str).a(String.valueOf(l))));
        } catch (Exception e2) {
        }
        AppMethodBeat.o(193559);
        return l;
    }

    public static String a(Context context) {
        AppMethodBeat.i(193560);
        try {
            Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
            if (bundle != null) {
                if (bundle.containsKey(Util.META_NAME_API_KEY)) {
                    String string = bundle.getString(Util.META_NAME_API_KEY);
                    AppMethodBeat.o(193560);
                    return string;
                }
                AppMethodBeat.o(193560);
                return "";
            }
        } catch (Exception e2) {
        }
        AppMethodBeat.o(193560);
        return "";
    }

    public static String b(Context context) {
        String str;
        AppMethodBeat.i(193561);
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            str = packageInfo.versionName;
            int i2 = packageInfo.versionCode;
            if (str == null || str.trim().length() <= 0) {
                str = String.valueOf(i2);
                AppMethodBeat.o(193561);
                return str;
            }
        } catch (Exception e2) {
            str = "";
        }
        AppMethodBeat.o(193561);
        return str;
    }

    public static String c(Context context) {
        AppMethodBeat.i(193562);
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (Build.VERSION.SDK_INT > 28) {
                y.f1436d = g(context);
                if (!y.f1435c.equals("01234567890ABCDEF")) {
                    y.f1436d = y.f1435c;
                }
            } else if (Build.VERSION.SDK_INT >= 26) {
                y.f1436d = telephonyManager.getImei();
            } else {
                y.f1436d = telephonyManager.getDeviceId();
            }
        } catch (Throwable th) {
            y.f1436d = "01234567890ABCDEF";
        }
        String str = y.f1436d;
        AppMethodBeat.o(193562);
        return str;
    }

    private static String g(Context context) {
        AppMethodBeat.i(193563);
        try {
            String string = Settings.System.getString(context.getContentResolver(), "android_id");
            AppMethodBeat.o(193563);
            return string;
        } catch (Throwable th) {
            AppMethodBeat.o(193563);
            return "01234567890ABCDEF";
        }
    }

    public static String a() {
        AppMethodBeat.i(193564);
        try {
            String replaceAll = Build.MODEL.replaceAll("[_]", "");
            AppMethodBeat.o(193564);
            return replaceAll;
        } catch (Throwable th) {
            AppMethodBeat.o(193564);
            return "";
        }
    }

    public static String b() {
        AppMethodBeat.i(193565);
        try {
            String replaceAll = Build.MANUFACTURER.replaceAll("[_]", "");
            AppMethodBeat.o(193565);
            return replaceAll;
        } catch (Throwable th) {
            AppMethodBeat.o(193565);
            return "";
        }
    }

    public static int c() {
        return Build.VERSION.SDK_INT;
    }

    public static String a(File file) {
        AppMethodBeat.i(193566);
        if (!file.isFile()) {
            AppMethodBeat.o(193566);
            return null;
        }
        byte[] bArr = new byte[1024];
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            FileInputStream fileInputStream = new FileInputStream(file);
            while (true) {
                int read = fileInputStream.read(bArr, 0, 1024);
                if (read != -1) {
                    instance.update(bArr, 0, read);
                } else {
                    fileInputStream.close();
                    String b2 = b(instance.digest());
                    AppMethodBeat.o(193566);
                    return b2;
                }
            }
        } catch (Exception e2) {
            AppMethodBeat.o(193566);
            return null;
        }
    }

    private static String b(byte[] bArr) {
        AppMethodBeat.i(193567);
        if (bArr == null) {
            AppMethodBeat.o(193567);
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b2 : bArr) {
            String hexString = Integer.toHexString(b2 & 255);
            if (hexString.length() == 1) {
                stringBuffer.append(AppEventsConstants.EVENT_PARAM_VALUE_NO);
            }
            stringBuffer.append(hexString);
        }
        String lowerCase = stringBuffer.toString().toLowerCase();
        AppMethodBeat.o(193567);
        return lowerCase;
    }

    public static boolean a(List<p> list, List<p> list2) {
        boolean z;
        AppMethodBeat.i(193568);
        boolean z2 = true;
        for (p pVar : list) {
            Iterator<p> it = list2.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                p next = it.next();
                if (pVar.f1388a == next.f1388a && pVar.f1391d == next.f1391d && pVar.f1392e.equals(next.f1392e)) {
                    z = true;
                    break;
                }
            }
            z2 = !z ? false : z2;
        }
        AppMethodBeat.o(193568);
        return z2;
    }

    public static p a(int i2, List<p> list) {
        AppMethodBeat.i(193569);
        if (list == null || list.isEmpty()) {
            AppMethodBeat.o(193569);
            return null;
        }
        for (p pVar : list) {
            if (i2 == pVar.f1388a) {
                AppMethodBeat.o(193569);
                return pVar;
            }
        }
        AppMethodBeat.o(193569);
        return null;
    }

    private static String h(Context context) {
        AppMethodBeat.i(193570);
        try {
            int myPid = Process.myPid();
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService(EnvConsts.ACTIVITY_MANAGER_SRVNAME)).getRunningAppProcesses()) {
                if (runningAppProcessInfo.pid == myPid) {
                    String str = runningAppProcessInfo.processName;
                    AppMethodBeat.o(193570);
                    return str;
                }
            }
            BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("/proc/" + Process.myPid() + "/cmdline")));
            String trim = bufferedReader.readLine().trim();
            bufferedReader.close();
            AppMethodBeat.o(193570);
            return trim;
        } catch (Exception e2) {
            AppMethodBeat.o(193570);
            return null;
        }
    }

    public static int d(Context context) {
        boolean z = true;
        AppMethodBeat.i(193571);
        String b2 = b(context, t.A, BuildConfig.KINDA_DEFAULT);
        if (b2.equals(BuildConfig.KINDA_DEFAULT)) {
            AppMethodBeat.o(193571);
            return 1;
        }
        try {
            String[] split = b2.split("#");
            if (split != null && split.length > 0) {
                for (String str : split) {
                    String[] split2 = str.split("&");
                    if (split2 != null && split2.length == 2 && a(context, Integer.parseInt(split2[0]))) {
                        z = false;
                    }
                }
            }
            if (z) {
                AppMethodBeat.o(193571);
                return 3;
            }
        } catch (Exception e2) {
        }
        AppMethodBeat.o(193571);
        return 4;
    }

    private static boolean a(Context context, int i2) {
        AppMethodBeat.i(193572);
        try {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService(EnvConsts.ACTIVITY_MANAGER_SRVNAME)).getRunningAppProcesses()) {
                if (runningAppProcessInfo.pid == i2) {
                    AppMethodBeat.o(193572);
                    return true;
                }
            }
        } catch (Exception e2) {
        }
        AppMethodBeat.o(193572);
        return false;
    }

    public static void e(Context context) {
        AppMethodBeat.i(193573);
        String h2 = h(context);
        if (h2 == null) {
            AppMethodBeat.o(193573);
            return;
        }
        int myPid = Process.myPid();
        String b2 = b(context, t.A, BuildConfig.KINDA_DEFAULT);
        if (b2.equals(BuildConfig.KINDA_DEFAULT)) {
            a(context, t.A, myPid + "&" + h2 + "#");
            AppMethodBeat.o(193573);
            return;
        }
        try {
            String[] split = b2.split("#");
            if (split != null && split.length > 0) {
                boolean z = false;
                for (int i2 = 0; i2 < split.length; i2++) {
                    String[] split2 = split[i2].split("&");
                    if (split2 != null && split2.length == 2) {
                        String str = split2[1];
                        Integer.parseInt(split2[0]);
                        if (h2.equals(str)) {
                            split[i2] = myPid + "&" + h2;
                            z = true;
                        }
                    }
                }
                String str2 = "";
                for (int i3 = 0; i3 < split.length; i3++) {
                    str2 = str2 + split[i3] + "#";
                }
                a(context, t.A, !z ? str2 + myPid + "&" + h2 + "#" : str2);
            }
            AppMethodBeat.o(193573);
        } catch (Exception e2) {
            AppMethodBeat.o(193573);
        }
    }

    public static ArrayList<String> b(File file) {
        File[] listFiles;
        AppMethodBeat.i(193574);
        ArrayList<String> arrayList = null;
        if (file != null && file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
            arrayList = new ArrayList<>();
            for (File file2 : listFiles) {
                arrayList.add(file2.getName() + "," + file2.length() + "," + a(file2));
            }
        }
        AppMethodBeat.o(193574);
        return arrayList;
    }

    public static String a(List<p> list) {
        AppMethodBeat.i(193575);
        String str = "";
        for (int i2 = 0; i2 < list.size(); i2++) {
            p pVar = list.get(i2);
            if (a(pVar.f1388a) && !pVar.f1390c.endsWith(".so")) {
                pVar.f1390c += ".so";
            } else if (!a(pVar.f1388a) && !pVar.f1390c.endsWith(ShareConstants.DEX_SUFFIX)) {
                pVar.f1390c += ShareConstants.DEX_SUFFIX;
            }
            str = str + pVar.toString() + ";";
        }
        AppMethodBeat.o(193575);
        return str;
    }

    public static List<p> a(String str) {
        AppMethodBeat.i(193576);
        ArrayList arrayList = new ArrayList();
        try {
            for (String str2 : str.split(";")) {
                String[] split = str2.split(",");
                if (split.length >= 5) {
                    try {
                        p pVar = new p();
                        pVar.f1388a = Integer.valueOf(split[0]).intValue();
                        pVar.f1389b = split[1];
                        pVar.f1393f = split[2];
                        pVar.f1390c = split[2];
                        if (a(pVar.f1388a) && !pVar.f1390c.endsWith(".so")) {
                            pVar.f1390c += ".so";
                        } else if (!a(pVar.f1388a) && !pVar.f1390c.endsWith(ShareConstants.DEX_SUFFIX)) {
                            pVar.f1390c += ShareConstants.DEX_SUFFIX;
                        }
                        pVar.f1391d = Long.valueOf(split[3]).longValue();
                        pVar.f1392e = split[4];
                        arrayList.add(pVar);
                    } catch (Exception e2) {
                    }
                }
            }
        } catch (Exception e3) {
            arrayList.clear();
        }
        AppMethodBeat.o(193576);
        return arrayList;
    }

    public static int b(List<p> list) {
        boolean z;
        AppMethodBeat.i(193577);
        if (list == null || list.isEmpty()) {
            AppMethodBeat.o(193577);
            return -2;
        }
        Iterator<p> it = list.iterator();
        while (true) {
            if (it.hasNext()) {
                if (a(it.next().f1388a)) {
                    z = true;
                    break;
                }
            } else {
                z = false;
                break;
            }
        }
        if (z) {
            AppMethodBeat.o(193577);
            return 1;
        }
        AppMethodBeat.o(193577);
        return 0;
    }

    public static boolean f(Context context) {
        AppMethodBeat.i(193578);
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            AppMethodBeat.o(193578);
            return false;
        }
        try {
            NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
            if (networkInfo == null || !networkInfo.isConnected()) {
                AppMethodBeat.o(193578);
                return false;
            } else if (Build.VERSION.SDK_INT < 16 || connectivityManager.isActiveNetworkMetered()) {
                AppMethodBeat.o(193578);
                return true;
            } else {
                AppMethodBeat.o(193578);
                return true;
            }
        } catch (Throwable th) {
            AppMethodBeat.o(193578);
            return false;
        }
    }

    public static long d() {
        AppMethodBeat.i(193579);
        long j2 = 0;
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            j2 = ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
        } catch (Exception e2) {
        }
        AppMethodBeat.o(193579);
        return j2;
    }

    public static boolean a(int i2) {
        if (i2 < 2 || i2 > t.F.length - 1) {
            return false;
        }
        return true;
    }

    private static byte[] e(Context context, String str) {
        AppMethodBeat.i(193580);
        try {
            InputStream open = context.getResources().getAssets().open(str);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[2048];
            while (true) {
                int read = open.read(bArr);
                if (read > 0) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    byteArrayOutputStream.close();
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    open.close();
                    AppMethodBeat.o(193580);
                    return byteArray;
                }
            }
        } catch (Exception e2) {
            AppMethodBeat.o(193580);
            return null;
        }
    }

    public static boolean a(Context context, String str, String str2, boolean z, boolean z2) {
        byte[] b2;
        AppMethodBeat.i(193581);
        if (z) {
            try {
                b2 = e(context, str);
            } catch (Exception e2) {
                AppMethodBeat.o(193581);
                return false;
            }
        } else {
            b2 = b(str);
        }
        if (b2 == null) {
            AppMethodBeat.o(193581);
            return false;
        }
        if (z2) {
            b2 = a(EncryptAesUtils.decryptAes256(b2, "dwMmNhTC43xDnMGp", t.G));
        }
        if (b2 != null) {
            new w(str2).a(b2);
            AppMethodBeat.o(193581);
            return true;
        }
        AppMethodBeat.o(193581);
        return false;
    }

    public static String c(Context context, String str) {
        AppMethodBeat.i(193582);
        try {
            byte[] e2 = e(context, str);
            if (e2 == null) {
                AppMethodBeat.o(193582);
                return "";
            }
            String str2 = new String(e2);
            AppMethodBeat.o(193582);
            return str2;
        } catch (Exception e3) {
            AppMethodBeat.o(193582);
            return "";
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0063, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0064, code lost:
        r2 = r0;
        r3 = r1;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0063 A[ExcHandler: all (r0v1 'th' java.lang.Throwable A[CUSTOM_DECLARE]), PHI: r1 
      PHI: (r1v2 java.io.FileInputStream) = (r1v4 java.io.FileInputStream), (r1v4 java.io.FileInputStream), (r1v4 java.io.FileInputStream), (r1v4 java.io.FileInputStream), (r1v7 java.io.FileInputStream) binds: [B:10:0x0022, B:12:0x0025, B:13:?, B:11:?, B:4:0x0013] A[DONT_GENERATE, DONT_INLINE], Splitter:B:10:0x0022] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static byte[] b(java.lang.String r7) {
        /*
        // Method dump skipped, instructions count: 106
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.map.tools.internal.x.b(java.lang.String):byte[]");
    }

    public static boolean c(File file) {
        AppMethodBeat.i(193584);
        if (!file.exists()) {
            file.mkdirs();
            AppMethodBeat.o(193584);
        } else {
            File[] listFiles = file.listFiles();
            if (listFiles == null || listFiles.length == 0) {
                AppMethodBeat.o(193584);
            } else {
                for (File file2 : listFiles) {
                    if (file2.isDirectory()) {
                        c(file2.getAbsolutePath());
                        file2.delete();
                    } else {
                        file2.delete();
                    }
                }
                AppMethodBeat.o(193584);
            }
        }
        return true;
    }

    private static boolean c(String str) {
        AppMethodBeat.i(193585);
        File file = new File(str);
        if (!file.exists()) {
            AppMethodBeat.o(193585);
            return false;
        }
        String[] list = file.list();
        if (list == null || list.length == 0) {
            AppMethodBeat.o(193585);
            return false;
        }
        for (String str2 : list) {
            File file2 = new File(str, str2);
            if (file2.isDirectory()) {
                c(file2.getAbsolutePath());
                file2.delete();
            } else {
                file2.delete();
            }
        }
        AppMethodBeat.o(193585);
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0032 A[SYNTHETIC, Splitter:B:20:0x0032] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0037 A[Catch:{ Exception -> 0x0099 }] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x003c A[Catch:{ Exception -> 0x0099 }] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0059 A[SYNTHETIC, Splitter:B:34:0x0059] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x005e A[Catch:{ Exception -> 0x0067 }] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0063 A[Catch:{ Exception -> 0x0067 }] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0070 A[SYNTHETIC, Splitter:B:44:0x0070] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0075 A[Catch:{ Exception -> 0x0081 }] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x007a A[Catch:{ Exception -> 0x0081 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] a(byte[] r8) {
        /*
        // Method dump skipped, instructions count: 167
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.map.tools.internal.x.a(byte[]):byte[]");
    }

    public static Object a(Object obj, String str, Class[] clsArr, Object[] objArr) {
        Object obj2 = null;
        AppMethodBeat.i(193587);
        if (obj == null) {
            AppMethodBeat.o(193587);
        } else {
            try {
                Method a2 = a(obj.getClass(), str, clsArr);
                if (a2 != null) {
                    a2.setAccessible(true);
                    obj2 = a2.invoke(obj, objArr);
                    AppMethodBeat.o(193587);
                }
            } catch (IllegalAccessException | InvocationTargetException e2) {
            }
            AppMethodBeat.o(193587);
        }
        return obj2;
    }

    private static Method a(Class cls, String str, Class[] clsArr) {
        AppMethodBeat.i(193588);
        Method method = null;
        try {
            method = cls.getDeclaredMethod(str, clsArr);
        } catch (NoSuchMethodException e2) {
            if (cls.getSuperclass() != Object.class) {
                method = a(cls.getSuperclass(), str, clsArr);
            }
        }
        AppMethodBeat.o(193588);
        return method;
    }
}
