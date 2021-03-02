package c.t.m.sapp.c;

import android.annotation.SuppressLint;
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
import com.tencent.map.tools.Util;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.zip.GZIPOutputStream;
import org.json.JSONArray;
import org.json.JSONObject;

public class q {

    /* renamed from: a  reason: collision with root package name */
    public static final Object f93a = new Object();

    /* renamed from: b  reason: collision with root package name */
    public static String f94b = "TencentLocation_sapp/comp";

    /* renamed from: c  reason: collision with root package name */
    public static String f95c = "TencentLocation_sapp/odex";

    /* renamed from: d  reason: collision with root package name */
    public static String f96d = "complist_loading_sapp";

    /* renamed from: e  reason: collision with root package name */
    public static long f97e = 0;

    /* renamed from: f  reason: collision with root package name */
    public static String f98f = "01234567890ABCDEF";

    /* renamed from: g  reason: collision with root package name */
    public static HashMap<String, r> f99g = new HashMap<>();

    static {
        AppMethodBeat.i(223061);
        AppMethodBeat.o(223061);
    }

    public static double a(double d2) {
        return (3.141592653589793d * d2) / 180.0d;
    }

    public static r a(Context context, String str) {
        AppMethodBeat.i(223020);
        if (f99g.containsKey(str)) {
            r rVar = f99g.get(str);
            AppMethodBeat.o(223020);
            return rVar;
        }
        r rVar2 = new r(context.getFilesDir().getAbsolutePath() + "/TencentLocation_sapp/conf/" + str);
        f99g.put(str, rVar2);
        AppMethodBeat.o(223020);
        return rVar2;
    }

    public static boolean b(Context context, String str, String str2) {
        AppMethodBeat.i(223021);
        boolean a2 = a(context, str).a(str2.getBytes(), false);
        AppMethodBeat.o(223021);
        return a2;
    }

    public static String c(Context context) {
        String str;
        AppMethodBeat.i(223027);
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            str = packageInfo.versionName;
            int i2 = packageInfo.versionCode;
            if (str == null || str.trim().length() <= 0) {
                String str2 = "" + i2;
                AppMethodBeat.o(223027);
                return str2;
            }
        } catch (Exception e2) {
            str = "";
        }
        AppMethodBeat.o(223027);
        return str;
    }

    public static String d(Context context) {
        AppMethodBeat.i(223028);
        String str = context.getFilesDir().getAbsolutePath() + File.separator + f94b;
        AppMethodBeat.o(223028);
        return str;
    }

    public static String e() {
        AppMethodBeat.i(223033);
        try {
            String replaceAll = Build.MANUFACTURER.replaceAll("[_]", "");
            AppMethodBeat.o(223033);
            return replaceAll;
        } catch (Throwable th) {
            AppMethodBeat.o(223033);
            return "";
        }
    }

    public static String f() {
        AppMethodBeat.i(223032);
        try {
            String replaceAll = Build.MODEL.replaceAll("[_]", "");
            AppMethodBeat.o(223032);
            return replaceAll;
        } catch (Throwable th) {
            AppMethodBeat.o(223032);
            return "";
        }
    }

    public static int g() {
        AppMethodBeat.i(223038);
        int myPid = Process.myPid();
        AppMethodBeat.o(223038);
        return myPid;
    }

    @SuppressLint({"MissingPermission"})
    public static String h(Context context) {
        AppMethodBeat.i(223039);
        String str = f98f;
        if (str == null || str.length() == 0 || "01234567890ABCDEF".equals(f98f)) {
            try {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                if (Build.VERSION.SDK_INT > 28) {
                    f98f = b(context);
                } else if (Build.VERSION.SDK_INT >= 26) {
                    f98f = telephonyManager.getImei();
                } else {
                    f98f = telephonyManager.getDeviceId();
                }
            } catch (Throwable th) {
                f98f = "01234567890ABCDEF";
            }
            String str2 = f98f;
            AppMethodBeat.o(223039);
            return str2;
        }
        String str3 = f98f;
        AppMethodBeat.o(223039);
        return str3;
    }

    public static String i(Context context) {
        AppMethodBeat.i(223029);
        String str = context.getFilesDir().getAbsolutePath() + File.separator + f95c;
        AppMethodBeat.o(223029);
        return str;
    }

    public static boolean j(Context context) {
        NetworkInfo activeNetworkInfo;
        AppMethodBeat.i(223044);
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (!(connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || activeNetworkInfo.getType() != 1)) {
                AppMethodBeat.o(223044);
                return true;
            }
        } catch (Exception e2) {
        }
        AppMethodBeat.o(223044);
        return false;
    }

    public static boolean k(Context context) {
        AppMethodBeat.i(223060);
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager == null) {
                AppMethodBeat.o(223060);
                return false;
            } else if (telephonyManager.getSimState() == 5) {
                AppMethodBeat.o(223060);
                return true;
            } else {
                AppMethodBeat.o(223060);
                return false;
            }
        } catch (Exception e2) {
            AppMethodBeat.o(223060);
            return false;
        }
    }

    public static String l(Context context) {
        AppMethodBeat.i(223031);
        try {
            Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
            if (bundle != null) {
                if (bundle.containsKey("TencentGeoLocationSDK")) {
                    String string = bundle.getString("TencentGeoLocationSDK");
                    AppMethodBeat.o(223031);
                    return string;
                } else if (bundle.containsKey(Util.META_NAME_API_KEY)) {
                    String string2 = bundle.getString(Util.META_NAME_API_KEY);
                    AppMethodBeat.o(223031);
                    return string2;
                } else {
                    AppMethodBeat.o(223031);
                    return "";
                }
            }
        } catch (Exception e2) {
        }
        AppMethodBeat.o(223031);
        return "";
    }

    public static long d() {
        AppMethodBeat.i(223043);
        long j2 = 0;
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            j2 = ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
        } catch (Exception e2) {
        }
        AppMethodBeat.o(223043);
        return j2;
    }

    public static String e(Context context) {
        AppMethodBeat.i(223035);
        String f2 = f(context);
        if (f2 == null) {
            f2 = c();
        }
        AppMethodBeat.o(223035);
        return f2;
    }

    public static String f(Context context) {
        AppMethodBeat.i(223036);
        try {
            int myPid = Process.myPid();
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService(EnvConsts.ACTIVITY_MANAGER_SRVNAME)).getRunningAppProcesses()) {
                if (runningAppProcessInfo.pid == myPid) {
                    String str = runningAppProcessInfo.processName;
                    AppMethodBeat.o(223036);
                    return str;
                }
            }
        } catch (Exception e2) {
            String str2 = j.f77a;
        }
        AppMethodBeat.o(223036);
        return null;
    }

    public static boolean b(Context context, String str, Long l) {
        AppMethodBeat.i(223022);
        boolean a2 = a(context, str).a(String.valueOf(l).getBytes(), false);
        AppMethodBeat.o(223022);
        return a2;
    }

    public static List<a> e(String str) {
        AppMethodBeat.i(223049);
        ArrayList arrayList = new ArrayList();
        try {
            for (String str2 : str.split(";")) {
                String[] split = str2.split(",");
                if (split.length >= 5) {
                    try {
                        a aVar = new a();
                        aVar.f32a = Integer.valueOf(split[0]).intValue();
                        aVar.f33b = split[1];
                        aVar.f34c = split[2];
                        aVar.f35d = Integer.valueOf(split[3]).intValue();
                        aVar.f36e = split[4];
                        if (split.length > 5) {
                            aVar.f37f = split[5];
                        }
                        arrayList.add(aVar);
                    } catch (Exception e2) {
                    }
                }
            }
        } catch (Exception e3) {
        }
        AppMethodBeat.o(223049);
        return arrayList;
    }

    public static String a(Context context, String str, String str2) {
        AppMethodBeat.i(223023);
        String a2 = a(context, str).a(str2);
        AppMethodBeat.o(223023);
        return a2;
    }

    public static int b() {
        return Build.VERSION.SDK_INT;
    }

    public static String d(String str) {
        AppMethodBeat.i(223050);
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString("status");
            e.b().a("DRG", "statucode:" + string);
            if (string.equals("-3")) {
                AppMethodBeat.o(223050);
                return null;
            } else if (string.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                String str2 = "";
                JSONArray jSONArray = jSONObject.getJSONArray("compList");
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                    str2 = str2 + jSONObject2.getInt("compId") + "," + jSONObject2.getString("compVer") + "," + jSONObject2.getString("compName") + "," + jSONObject2.getInt("size") + "," + jSONObject2.getString("md5") + ",;";
                }
                AppMethodBeat.o(223050);
                return str2;
            } else if (string.equals("-1")) {
                AppMethodBeat.o(223050);
                return null;
            } else if (string.equals("-2")) {
                AppMethodBeat.o(223050);
                return null;
            } else if (string.equals("-4")) {
                AppMethodBeat.o(223050);
                return null;
            } else {
                if (string.equals("-5")) {
                    AppMethodBeat.o(223050);
                    return null;
                }
                AppMethodBeat.o(223050);
                return null;
            }
        } catch (Exception e2) {
            e.b().a("DRG", "statucode:" + e2.toString());
        }
    }

    public static String b(Context context) {
        AppMethodBeat.i(223034);
        try {
            String string = Settings.System.getString(context.getContentResolver(), "android_id");
            AppMethodBeat.o(223034);
            return string;
        } catch (Throwable th) {
            AppMethodBeat.o(223034);
            return "01234567890ABCDEF";
        }
    }

    public static String c() {
        AppMethodBeat.i(223037);
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("/proc/" + Process.myPid() + "/cmdline")));
            String trim = bufferedReader.readLine().trim();
            bufferedReader.close();
            AppMethodBeat.o(223037);
            return trim;
        } catch (Exception e2) {
            String str = j.f77a;
            AppMethodBeat.o(223037);
            return null;
        }
    }

    public static Long a(Context context, String str, Long l) {
        AppMethodBeat.i(223024);
        try {
            l = Long.valueOf(Long.parseLong(a(context, str).a(String.valueOf(l))));
        } catch (Exception e2) {
        }
        AppMethodBeat.o(223024);
        return l;
    }

    public static byte[] b(byte[] bArr) {
        byte[] bArr2;
        AppMethodBeat.i(223047);
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(bArr.length);
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            bArr2 = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th) {
            }
        } catch (Throwable th2) {
            bArr2 = null;
        }
        AppMethodBeat.o(223047);
        return bArr2;
    }

    public static void a() {
        AppMethodBeat.i(223025);
        long currentTimeMillis = System.currentTimeMillis();
        f94b = "TencentLocation/comp";
        f95c = "TencentLocation/odex";
        f94b += "_atuo_" + currentTimeMillis;
        f95c += "_atuo_" + currentTimeMillis;
        AppMethodBeat.o(223025);
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x003b A[SYNTHETIC, Splitter:B:18:0x003b] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x005e  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0093  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0096  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0099  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x009e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int g(android.content.Context r11) {
        /*
        // Method dump skipped, instructions count: 176
        */
        throw new UnsupportedOperationException("Method not decompiled: c.t.m.sapp.c.q.g(android.content.Context):int");
    }

    public static String c(String str) {
        AppMethodBeat.i(223041);
        try {
            str = a(MessageDigest.getInstance("MD5").digest(str.getBytes()));
            AppMethodBeat.o(223041);
        } catch (Exception e2) {
            AppMethodBeat.o(223041);
        }
        return str;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0037, code lost:
        if (r3 != null) goto L_0x0073;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0071, code lost:
        if (r3 == null) goto L_0x0039;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0073, code lost:
        r3.close();
     */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x002f A[SYNTHETIC, Splitter:B:19:0x002f] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0034 A[Catch:{ Exception -> 0x0077 }] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0051 A[SYNTHETIC, Splitter:B:33:0x0051] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0056 A[Catch:{ Exception -> 0x009c }] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x005b A[Catch:{ Exception -> 0x009c }] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x006e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] c(byte[] r8) {
        /*
        // Method dump skipped, instructions count: 160
        */
        throw new UnsupportedOperationException("Method not decompiled: c.t.m.sapp.c.q.c(byte[]):byte[]");
    }

    public static boolean b(String str) {
        AppMethodBeat.i(223054);
        File file = new File(str);
        if (!file.exists()) {
            AppMethodBeat.o(223054);
            return false;
        }
        String[] list = file.list();
        if (list == null || list.length == 0) {
            AppMethodBeat.o(223054);
            return true;
        }
        for (String str2 : list) {
            File file2 = new File(str, str2);
            if (file2.isDirectory()) {
                b(file2.getAbsolutePath());
                file2.delete();
            } else {
                file2.delete();
            }
        }
        AppMethodBeat.o(223054);
        return true;
    }

    public static void a(Context context) {
        AppMethodBeat.i(223026);
        if (context == null) {
            AppMethodBeat.o(223026);
            return;
        }
        File[] listFiles = new File(context.getFilesDir().getAbsolutePath() + "/TencentLocation").listFiles();
        if (listFiles != null && listFiles.length > 0) {
            for (File file : listFiles) {
                String name = file.getName();
                if (file.isDirectory() && name.contains("_atuo_") && !f94b.contains(name)) {
                    b(file.getAbsolutePath());
                    file.delete();
                }
            }
        }
        AppMethodBeat.o(223026);
    }

    public static boolean b(Context context, String str, String str2, String str3, long j2, byte[] bArr) {
        boolean z = false;
        AppMethodBeat.i(223055);
        String str4 = str2 + File.separator + str3;
        File file = new File(str2);
        if (!file.exists()) {
            file.mkdir();
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(str);
            FileOutputStream fileOutputStream = new FileOutputStream(str4);
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read <= 0) {
                    break;
                }
                fileOutputStream.write(bArr, 0, read);
            }
            fileOutputStream.close();
            z = true;
            fileInputStream.close();
        } catch (Exception e2) {
        }
        AppMethodBeat.o(223055);
        return z;
    }

    public static List<String> a(Context context, File file) {
        File[] listFiles;
        AppMethodBeat.i(223030);
        ArrayList arrayList = null;
        String str = "";
        if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
            arrayList = new ArrayList();
            for (File file2 : listFiles) {
                arrayList.add(file2.getName() + "," + file2.length() + "," + a(file2));
                str = str + file2.getName() + "," + file2.length() + "," + a(file2) + ";";
            }
        }
        j.a("before check ,private dir files:".concat(String.valueOf(str)));
        AppMethodBeat.o(223030);
        return arrayList;
    }

    public static String a(File file) {
        AppMethodBeat.i(223040);
        if (!file.isFile()) {
            AppMethodBeat.o(223040);
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
                    String a2 = a(instance.digest());
                    AppMethodBeat.o(223040);
                    return a2;
                }
            }
        } catch (Exception e2) {
            AppMethodBeat.o(223040);
            return null;
        }
    }

    public static String b(Context context, String str) {
        AppMethodBeat.i(223057);
        StringBuilder sb = new StringBuilder();
        try {
            InputStream open = context.getAssets().open(str);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(open, MimeTypeUtil.ContentType.DEFAULT_CHARSET));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                sb.append(readLine);
            }
            bufferedReader.close();
            open.close();
        } catch (IOException | UnsupportedEncodingException e2) {
        }
        String sb2 = sb.toString();
        AppMethodBeat.o(223057);
        return sb2;
    }

    public static String a(byte[] bArr) {
        AppMethodBeat.i(223042);
        if (bArr == null) {
            AppMethodBeat.o(223042);
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
        AppMethodBeat.o(223042);
        return lowerCase;
    }

    public static void a(long j2) {
        AppMethodBeat.i(223045);
        try {
            Thread.sleep(j2);
            AppMethodBeat.o(223045);
        } catch (InterruptedException e2) {
            AppMethodBeat.o(223045);
        }
    }

    public static byte[] a(int i2) {
        AppMethodBeat.i(223048);
        byte[] bArr = new byte[2];
        for (int i3 = 0; i3 < 2; i3++) {
            bArr[i3] = Integer.valueOf(i2 & 255).byteValue();
            i2 >>= 8;
        }
        AppMethodBeat.o(223048);
        return bArr;
    }

    public static String a(List<a> list) {
        AppMethodBeat.i(223051);
        StringBuilder sb = new StringBuilder();
        for (a aVar : list) {
            sb.append(aVar.f32a).append(",");
            sb.append(aVar.f33b).append(",");
            if (!aVar.f34c.contains(ShareConstants.DEX_SUFFIX)) {
                aVar.f34c += ShareConstants.DEX_SUFFIX;
            }
            sb.append(aVar.f34c).append(",");
            sb.append(aVar.f35d).append(",");
            sb.append(aVar.f36e).append(",");
            sb.append(aVar.f37f).append(";");
        }
        String sb2 = sb.toString();
        AppMethodBeat.o(223051);
        return sb2;
    }

    public static boolean a(Context context, List<a> list) {
        AppMethodBeat.i(223052);
        List<a> e2 = e(a(context, "__SP_UPDATE_TencentLoc_COMP_INFO__sapp_", ""));
        if (list.size() == 0) {
            AppMethodBeat.o(223052);
            return false;
        } else if (e2.size() == 0) {
            boolean b2 = b(context, "__SP_UPDATE_TencentLoc_COMP_INFO__sapp_", a(list));
            AppMethodBeat.o(223052);
            return b2;
        } else {
            for (int i2 = 0; i2 < e2.size(); i2++) {
                a aVar = e2.get(i2);
                int i3 = 0;
                while (true) {
                    if (i3 >= list.size()) {
                        break;
                    }
                    a aVar2 = list.get(i3);
                    if (aVar2.f32a == aVar.f32a) {
                        aVar.f34c = aVar2.f34c;
                        aVar.f33b = aVar2.f33b;
                        aVar.f35d = aVar2.f35d;
                        aVar.f36e = aVar2.f36e;
                        break;
                    }
                    i3++;
                }
            }
            boolean b3 = b(context, "__SP_UPDATE_TencentLoc_COMP_INFO__sapp_", a(e2));
            AppMethodBeat.o(223052);
            return b3;
        }
    }

    public static boolean a(Context context, String str, String str2, String str3, long j2, byte[] bArr) {
        Exception e2;
        boolean z = false;
        AppMethodBeat.i(223053);
        String str4 = str2 + File.separator + str3;
        File file = new File(str2);
        if (!file.exists()) {
            file.mkdir();
        }
        try {
            InputStream open = context.getResources().getAssets().open(str);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            open.available();
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(str4, true), 1024);
            while (true) {
                int read = open.read(bArr);
                if (read <= 0) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
            byteArrayOutputStream.close();
            byte[] c2 = c(m.a(byteArrayOutputStream.toByteArray(), "sE0zy%DVqLnXA$hmNZ8NBwcg7FDrvi!q"));
            if (c2 != null) {
                bufferedOutputStream.write(c2);
                bufferedOutputStream.close();
                z = true;
            }
            try {
                open.close();
            } catch (Exception e3) {
                e2 = e3;
            }
        } catch (Exception e4) {
            e2 = e4;
            j.a("copy base to private dir", e2);
            AppMethodBeat.o(223053);
            return z;
        }
        AppMethodBeat.o(223053);
        return z;
    }

    public static boolean a(String str) {
        AppMethodBeat.i(223056);
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
            AppMethodBeat.o(223056);
        } else {
            String[] list = file.list();
            if (list == null || list.length == 0) {
                AppMethodBeat.o(223056);
            } else {
                for (String str2 : list) {
                    File file2 = new File(str, str2);
                    if (file2.isDirectory()) {
                        b(file2.getAbsolutePath());
                        file2.delete();
                    } else {
                        file2.delete();
                    }
                }
                AppMethodBeat.o(223056);
            }
        }
        return true;
    }

    public static double a(double d2, double d3, double d4, double d5) {
        AppMethodBeat.i(223058);
        double a2 = a(d2);
        double a3 = a(d4);
        double round = (((double) Math.round(((Math.asin(Math.sqrt(((Math.cos(a2) * Math.cos(a3)) * Math.pow(Math.sin((a(d3) - a(d5)) / 2.0d), 2.0d)) + Math.pow(Math.sin((a2 - a3) / 2.0d), 2.0d))) * 2.0d) * 6378.137d) * 10000.0d)) / 10000.0d) * 1000.0d;
        AppMethodBeat.o(223058);
        return round;
    }
}
