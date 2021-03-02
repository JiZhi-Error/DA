package com.tencent.mm.plugin.appbrand.jsapi.video.b.e;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.StatFs;
import android.text.TextUtils;
import com.google.android.gms.common.internal.ImagesContract;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.a;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.a.e;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.a.g;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.c.l;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.xwalk.core.XWalkEnvironment;

public final class h {
    private static final AtomicInteger QH = new AtomicInteger(1);
    public static final int SDK_INT = Build.VERSION.SDK_INT;
    private static String mzX = "<html";
    public static HashMap<String, String> mzY = new HashMap<>();
    private static HashMap<String, Boolean> mzZ = new HashMap<>();

    static {
        AppMethodBeat.i(234882);
        AppMethodBeat.o(234882);
    }

    public static boolean isNetworkAvailable() {
        AppMethodBeat.i(234851);
        ConnectivityManager connectivityManager = (ConnectivityManager) a.bJK().appContext.getSystemService("connectivity");
        if (connectivityManager != null) {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                AppMethodBeat.o(234851);
                return false;
            }
            AppMethodBeat.o(234851);
            return true;
        }
        a(5, "PlayerUtils", "isNetworkAvailable cant access ConnectivityManager missing permission?", null);
        AppMethodBeat.o(234851);
        return false;
    }

    public static void a(HttpURLConnection httpURLConnection, long j2) {
        AppMethodBeat.i(234852);
        if (SDK_INT == 19 || SDK_INT == 20) {
            try {
                InputStream inputStream = httpURLConnection.getInputStream();
                if (j2 == -1) {
                    if (inputStream.read() == -1) {
                        AppMethodBeat.o(234852);
                        return;
                    }
                } else if (j2 <= 2048) {
                    AppMethodBeat.o(234852);
                    return;
                }
                String name = inputStream.getClass().getName();
                if (name.equals("com.android.okhttp.internal.http.HttpTransport$ChunkedInputStream") || name.equals("com.android.okhttp.internal.http.HttpTransport$FixedLengthInputStream")) {
                    Method declaredMethod = inputStream.getClass().getSuperclass().getDeclaredMethod("unexpectedEndOfInput", new Class[0]);
                    declaredMethod.setAccessible(true);
                    declaredMethod.invoke(inputStream, new Object[0]);
                }
                AppMethodBeat.o(234852);
            } catch (IOException e2) {
                AppMethodBeat.o(234852);
            } catch (Exception e3) {
                AppMethodBeat.o(234852);
            }
        } else {
            AppMethodBeat.o(234852);
        }
    }

    public static long abi(String str) {
        AppMethodBeat.i(234853);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(234853);
            return -1;
        }
        try {
            StatFs statFs = new StatFs(str);
            long availableBlocks = ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
            AppMethodBeat.o(234853);
            return availableBlocks;
        } catch (Exception e2) {
            AppMethodBeat.o(234853);
            return -1;
        }
    }

    public static long abj(String str) {
        long j2 = 0;
        AppMethodBeat.i(234854);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(234854);
            return 0;
        }
        o oVar = new o(str);
        if (oVar.isFile()) {
            long length = oVar.length();
            AppMethodBeat.o(234854);
            return length;
        }
        o[] het = oVar.het();
        if (het != null) {
            for (o oVar2 : het) {
                if (oVar2 != null) {
                    j2 += abj(aa.z(oVar2.her()));
                }
            }
        }
        AppMethodBeat.o(234854);
        return j2;
    }

    private static List<String> abk(String str) {
        AppMethodBeat.i(234855);
        ArrayList arrayList = new ArrayList(((str.length() + 1000) - 1) / 1000);
        for (int i2 = 0; i2 < str.length(); i2 += 1000) {
            arrayList.add(str.substring(i2, Math.min(str.length(), i2 + 1000)));
        }
        AppMethodBeat.o(234855);
        return arrayList;
    }

    public static String abl(String str) {
        AppMethodBeat.i(234856);
        if (!TextUtils.isEmpty(str)) {
            String str2 = mzY.get(str);
            if (!TextUtils.isEmpty(str2)) {
                AppMethodBeat.o(234856);
                return str2;
            }
        }
        e eVar = a.bJK().mxq;
        if (eVar == null) {
            eVar = new g();
        }
        String generate = eVar.generate(str);
        mzY.put(str, generate);
        AppMethodBeat.o(234856);
        return generate;
    }

    public static int bKd() {
        int bKe;
        AppMethodBeat.i(234857);
        try {
            bKe = bKe();
            AppMethodBeat.o(234857);
        } catch (IllegalStateException e2) {
            for (int i2 = 0; i2 < 5; i2++) {
                try {
                    bKe = bKe();
                    AppMethodBeat.o(234857);
                } catch (IllegalStateException e3) {
                    a(5, "PlayerUtils", "retry findFreePort i=".concat(String.valueOf(i2)), null);
                }
            }
            IllegalStateException illegalStateException = new IllegalStateException("Could not find a free TCP/IP port to start video proxy, maxRetry=5");
            AppMethodBeat.o(234857);
            throw illegalStateException;
        }
        return bKe;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0046, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0047, code lost:
        r2 = r1;
        r3 = r0;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0023 A[SYNTHETIC, Splitter:B:15:0x0023] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0037 A[SYNTHETIC, Splitter:B:22:0x0037] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0046 A[ExcHandler: all (r1v4 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:4:0x000e] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int bKe() {
        /*
            r4 = 234858(0x3956a, float:3.29106E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r4)
            r1 = 0
            java.net.ServerSocket r0 = new java.net.ServerSocket     // Catch:{ IOException -> 0x001f, all -> 0x0032 }
            r2 = 0
            r0.<init>(r2)     // Catch:{ IOException -> 0x001f, all -> 0x0032 }
            r1 = 1
            r0.setReuseAddress(r1)     // Catch:{ IOException -> 0x004a, all -> 0x0046 }
            int r1 = r0.getLocalPort()     // Catch:{ IOException -> 0x004a, all -> 0x0046 }
            r0.close()     // Catch:{ IOException -> 0x003e, all -> 0x0046 }
        L_0x0018:
            r0.close()     // Catch:{ IOException -> 0x0040 }
        L_0x001b:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
            return r1
        L_0x001f:
            r0 = move-exception
            r0 = r1
        L_0x0021:
            if (r0 == 0) goto L_0x0026
            r0.close()     // Catch:{ IOException -> 0x0042 }
        L_0x0026:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "Could not find a free TCP/IP port to start video proxy"
            r0.<init>(r1)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
            throw r0
        L_0x0032:
            r0 = move-exception
            r2 = r0
            r3 = r1
        L_0x0035:
            if (r3 == 0) goto L_0x003a
            r3.close()     // Catch:{ IOException -> 0x0044 }
        L_0x003a:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
            throw r2
        L_0x003e:
            r2 = move-exception
            goto L_0x0018
        L_0x0040:
            r0 = move-exception
            goto L_0x001b
        L_0x0042:
            r0 = move-exception
            goto L_0x0026
        L_0x0044:
            r0 = move-exception
            goto L_0x003a
        L_0x0046:
            r1 = move-exception
            r2 = r1
            r3 = r0
            goto L_0x0035
        L_0x004a:
            r1 = move-exception
            goto L_0x0021
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h.bKe():int");
    }

    private static long bI(List<String> list) {
        AppMethodBeat.i(234859);
        if (list != null && !list.isEmpty()) {
            String str = list.get(0);
            if (!TextUtils.isEmpty(str)) {
                try {
                    long parseLong = Long.parseLong(str);
                    AppMethodBeat.o(234859);
                    return parseLong;
                } catch (NumberFormatException e2) {
                    a(6, "PlayerUtils", "getSubErrorCode: long string is ill-format", null);
                }
            }
        }
        AppMethodBeat.o(234859);
        return -1;
    }

    public static long U(Map<String, List<String>> map) {
        AppMethodBeat.i(234860);
        if (map != null) {
            long bI = bI(map.get("x-server-error"));
            if (bI == -1 || bI == 0) {
                long bI2 = bI(map.get("x-proxy-error"));
                if (bI2 != -1) {
                    long j2 = bI2 - 20000;
                    AppMethodBeat.o(234860);
                    return j2;
                }
                long bI3 = bI(map.get("error"));
                if (bI3 != -1) {
                    AppMethodBeat.o(234860);
                    return bI3;
                }
            } else {
                AppMethodBeat.o(234860);
                return bI;
            }
        }
        AppMethodBeat.o(234860);
        return -99999;
    }

    public static long G(long j2, long j3) {
        AppMethodBeat.i(234861);
        int i2 = -2;
        String[] bKf = bKf();
        if (bKf != null) {
            i2 = -3;
            a(4, "PlayerUtils", "proxy setting " + a(Arrays.asList(bKf).iterator(), "|"), null);
        }
        long j4 = ((long) (i2 * XWalkEnvironment.TEST_APK_START_VERSION)) + (100000 * j2) + j3;
        AppMethodBeat.o(234861);
        return j4;
    }

    public static long H(long j2, long j3) {
        AppMethodBeat.i(234862);
        int i2 = -2;
        String[] bKf = bKf();
        if (bKf != null) {
            i2 = -3;
            a(4, "PlayerUtils", "proxy setting " + a(Arrays.asList(bKf).iterator(), "|"), null);
        }
        long j4 = ((j2 - j3) - ((long) (i2 * XWalkEnvironment.TEST_APK_START_VERSION))) / 100000;
        AppMethodBeat.o(234862);
        return j4;
    }

    public static String abm(String str) {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.i(234863);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(234863);
            return null;
        }
        if (TextUtils.isEmpty(str) || (!str.startsWith(FilePathGenerator.ANDROID_DIR_SEP) && !str.startsWith("file:"))) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            AppMethodBeat.o(234863);
            return ImagesContract.LOCAL;
        }
        if (TextUtils.isEmpty(str) || str.startsWith(l.bJT().myF.bJU())) {
            z2 = false;
        }
        if (z2) {
            AppMethodBeat.o(234863);
            return "noproxy";
        }
        Map<String, String> abf = f.abf(str);
        if (abf == null || abf.isEmpty()) {
            a(6, "PlayerUtils", "getVideoUuidFromVideoUrl fail ".concat(String.valueOf(str)), null);
            AppMethodBeat.o(234863);
            return null;
        }
        String str2 = abf.get("id");
        AppMethodBeat.o(234863);
        return str2;
    }

    private static String a(Iterator<String> it, String str) {
        AppMethodBeat.i(234864);
        String str2 = "";
        if (it != null) {
            while (it.hasNext()) {
                str2 = str2 + it.next();
                if (it.hasNext()) {
                    str2 = str2 + str;
                }
            }
        }
        AppMethodBeat.o(234864);
        return str2;
    }

    public static String bJ(List<String> list) {
        AppMethodBeat.i(234865);
        String a2 = a(list.iterator(), "|");
        AppMethodBeat.o(234865);
        return a2;
    }

    public static boolean aN(byte[] bArr) {
        AppMethodBeat.i(234866);
        if (bArr == null || bArr.length <= 100) {
            AppMethodBeat.o(234866);
            return false;
        }
        byte[] bArr2 = new byte[100];
        System.arraycopy(bArr, 0, bArr2, 0, 100);
        boolean contains = new String(bArr2).toLowerCase().replaceAll("\\s", "").contains(mzX);
        AppMethodBeat.o(234866);
        return contains;
    }

    public static boolean c(URL url) {
        String str;
        InetAddress inetAddress = null;
        AppMethodBeat.i(234867);
        try {
            str = url.getHost();
        } catch (Exception e2) {
            str = null;
        }
        if (str == null) {
            AppMethodBeat.o(234867);
            return false;
        }
        try {
            inetAddress = InetAddress.getByName(str);
        } catch (UnknownHostException e3) {
        }
        if (inetAddress == null) {
            AppMethodBeat.o(234867);
            return false;
        } else if (inetAddress.isAnyLocalAddress() || inetAddress.isLoopbackAddress()) {
            AppMethodBeat.o(234867);
            return true;
        } else {
            try {
                if (NetworkInterface.getByInetAddress(inetAddress) != null) {
                    AppMethodBeat.o(234867);
                    return true;
                }
                AppMethodBeat.o(234867);
                return false;
            } catch (SocketException e4) {
                AppMethodBeat.o(234867);
                return false;
            }
        }
    }

    private static String[] bKf() {
        AppMethodBeat.i(234868);
        try {
            try {
                Object invoke = ConnectivityManager.class.getMethod("getProxy", new Class[0]).invoke((ConnectivityManager) a.bJK().appContext.getSystemService("connectivity"), new Object[0]);
                if (invoke == null) {
                    AppMethodBeat.o(234868);
                    return null;
                }
                Class<?> cls = Class.forName("android.net.ProxyProperties");
                String[] strArr = {(String) cls.getMethod("getHost", new Class[0]).invoke(invoke, new Object[0]), String.valueOf((Integer) cls.getMethod("getPort", new Class[0]).invoke(invoke, new Object[0])), (String) cls.getMethod("getExclusionList", new Class[0]).invoke(invoke, new Object[0])};
                if (strArr[0] != null) {
                    AppMethodBeat.o(234868);
                    return strArr;
                }
                AppMethodBeat.o(234868);
                return null;
            } catch (Exception e2) {
                AppMethodBeat.o(234868);
                return null;
            }
        } catch (NoSuchMethodException e3) {
            AppMethodBeat.o(234868);
            return null;
        } catch (Exception e4) {
            AppMethodBeat.o(234868);
            return null;
        }
    }

    public static boolean aaW(String str) {
        boolean z;
        AppMethodBeat.i(234869);
        if (mzZ.containsKey(str)) {
            z = mzZ.get(str).booleanValue();
        } else {
            z = str.contains("m3u8") || str.contains("m3u");
            mzZ.put(str, Boolean.valueOf(z));
        }
        AppMethodBeat.o(234869);
        return z;
    }

    public static String dR(String str, String str2) {
        AppMethodBeat.i(234870);
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            AppMethodBeat.o(234870);
            return str;
        } else if (str2.startsWith("http")) {
            AppMethodBeat.o(234870);
            return str2;
        } else {
            try {
                String url = new URL(new URL(str), str2).toString();
                AppMethodBeat.o(234870);
                return url;
            } catch (MalformedURLException e2) {
                if (str.endsWith(FilePathGenerator.ANDROID_DIR_SEP)) {
                    str = str.substring(0, str.length() - 1);
                }
                int lastIndexOf = str.lastIndexOf(47);
                if (lastIndexOf > 0) {
                    str = str.substring(0, lastIndexOf);
                }
                String str3 = str + str2;
                AppMethodBeat.o(234870);
                return str3;
            }
        }
    }

    public static String abn(String str) {
        AppMethodBeat.i(234871);
        String str2 = "";
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(234871);
        } else if (!str.startsWith("#")) {
            AppMethodBeat.o(234871);
        } else {
            int indexOf = str.indexOf(":");
            if (indexOf == -1) {
                AppMethodBeat.o(234871);
            } else {
                str2 = str.substring(indexOf + 1);
                if (str.lastIndexOf(",") != -1) {
                    str2 = str2.substring(0, str2.length() - 1);
                }
                AppMethodBeat.o(234871);
            }
        }
        return str2;
    }

    public static int abo(String str) {
        int i2;
        AppMethodBeat.i(234872);
        String abn = abn(str);
        if (TextUtils.isEmpty(abn)) {
            AppMethodBeat.o(234872);
            return -1;
        }
        try {
            i2 = Integer.parseInt(abn);
        } catch (Exception e2) {
            a(6, "PlayerUtils", "parseM3u8Number error ".concat(String.valueOf(e2)), null);
            i2 = -1;
        }
        if (i2 == -1) {
            try {
                i2 = (int) Float.parseFloat(abn);
            } catch (Exception e3) {
                a(6, "PlayerUtils", "parseM3u8Number error ".concat(String.valueOf(e3)), null);
            }
        }
        AppMethodBeat.o(234872);
        return i2;
    }

    public static String abp(String str) {
        AppMethodBeat.i(234873);
        if (TextUtils.isEmpty(str) || !str.startsWith(FilePathGenerator.ANDROID_DIR_SEP)) {
            AppMethodBeat.o(234873);
            return str;
        }
        String concat = "file://".concat(String.valueOf(str));
        AppMethodBeat.o(234873);
        return concat;
    }

    public static boolean abq(String str) {
        AppMethodBeat.i(234874);
        if (TextUtils.isEmpty(str) || !str.startsWith("file:///android_asset")) {
            AppMethodBeat.o(234874);
            return false;
        }
        AppMethodBeat.o(234874);
        return true;
    }

    public static boolean abr(String str) {
        AppMethodBeat.i(234875);
        if (TextUtils.isEmpty(str) || !str.startsWith("android.resource://")) {
            AppMethodBeat.o(234875);
            return false;
        }
        AppMethodBeat.o(234875);
        return true;
    }

    public static String abs(String str) {
        AppMethodBeat.i(234876);
        if (str != null) {
            String replaceAll = str.replaceAll("\\r\\n", "|").replaceAll("\\r|\\n", "|");
            AppMethodBeat.o(234876);
            return replaceAll;
        }
        AppMethodBeat.o(234876);
        return str;
    }

    public static String i(Throwable th) {
        AppMethodBeat.i(234877);
        String a2 = a(th, false);
        AppMethodBeat.o(234877);
        return a2;
    }

    private static String a(Throwable th, boolean z) {
        AppMethodBeat.i(234878);
        if (th == null) {
            AppMethodBeat.o(234878);
            return "";
        }
        Thread currentThread = Thread.currentThread();
        StringBuilder sb = new StringBuilder();
        if (!z) {
            sb.append("Exception in thread \"");
            sb.append(currentThread.getName());
            sb.append("\"");
            sb.append(th.toString());
        }
        StackTraceElement[] stackTrace = th.getStackTrace();
        for (StackTraceElement stackTraceElement : stackTrace) {
            sb.append("\tat ");
            sb.append(stackTraceElement);
            sb.append("\n");
        }
        Throwable targetException = th instanceof InvocationTargetException ? ((InvocationTargetException) th).getTargetException() : th.getCause();
        if (targetException != null) {
            sb.append("caused by: ");
            sb.append(targetException.toString());
            sb.append("\n");
            sb.append(a(targetException, true));
        }
        String sb2 = sb.toString();
        AppMethodBeat.o(234878);
        return sb2;
    }

    private static void a(int i2, String str, List<String> list) {
        AppMethodBeat.i(234879);
        for (String str2 : list) {
            a(i2, str, str2, null);
        }
        AppMethodBeat.o(234879);
    }

    public static void log(int i2, String str, String str2) {
        AppMethodBeat.i(263551);
        a(i2, str, str2, null);
        AppMethodBeat.o(263551);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public static void a(int i2, String str, String str2, Throwable th) {
        AppMethodBeat.i(234881);
        if (th != null) {
            str2 = str2 + ":" + i(th);
        }
        if (str2.length() > 1000) {
            a(i2, str, abk(str2));
            AppMethodBeat.o(234881);
            return;
        }
        j jVar = a.bJK().mxo;
        if (jVar == null) {
            switch (i2) {
                case 2:
                    AppMethodBeat.o(234881);
                    return;
                case 3:
                    AppMethodBeat.o(234881);
                    return;
                case 4:
                    AppMethodBeat.o(234881);
                    return;
                case 5:
                    AppMethodBeat.o(234881);
                    return;
                case 6:
                    AppMethodBeat.o(234881);
                    return;
                default:
                    AppMethodBeat.o(234881);
                    return;
            }
        } else {
            switch (i2) {
                case 2:
                    jVar.v(str, str2);
                    AppMethodBeat.o(234881);
                    return;
                case 3:
                    jVar.d(str, str2);
                    AppMethodBeat.o(234881);
                    return;
                case 4:
                    jVar.i(str, str2);
                    AppMethodBeat.o(234881);
                    return;
                case 5:
                    jVar.w(str, str2);
                    break;
                case 6:
                    jVar.e(str, str2);
                    AppMethodBeat.o(234881);
                    return;
            }
            AppMethodBeat.o(234881);
        }
    }
}
