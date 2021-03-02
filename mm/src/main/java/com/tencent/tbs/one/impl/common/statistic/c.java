package com.tencent.tbs.one.impl.common.statistic;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.tbs.b.a;
import com.tencent.tbs.one.impl.a.f;
import java.util.Map;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    private static String f2614a = "";

    /* renamed from: b  reason: collision with root package name */
    private static String f2615b = "";

    /* renamed from: c  reason: collision with root package name */
    private static String f2616c = "";

    public static int a(Context context) {
        int i2;
        AppMethodBeat.i(174217);
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (a(context, "android.permission.ACCESS_NETWORK_STATE")) {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting()) {
                    switch (activeNetworkInfo.getType()) {
                        case 0:
                            switch (activeNetworkInfo.getSubtype()) {
                                case 1:
                                case 2:
                                case 4:
                                case 7:
                                case 11:
                                    i2 = 1;
                                    break;
                                case 3:
                                case 5:
                                case 6:
                                case 8:
                                case 9:
                                case 10:
                                case 12:
                                case 14:
                                case 15:
                                    i2 = 2;
                                    break;
                                case 13:
                                    i2 = 4;
                                    break;
                                default:
                                    i2 = 0;
                                    break;
                            }
                        case 1:
                            i2 = 3;
                            break;
                    }
                    AppMethodBeat.o(174217);
                    return i2;
                }
                i2 = 0;
                AppMethodBeat.o(174217);
                return i2;
            }
            f.b("Require \"ACCESS_NETWORK_STATE\" permission for reading apn type!", new Object[0]);
            AppMethodBeat.o(174217);
            return 0;
        } catch (Exception e2) {
            i2 = 0;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0068 A[SYNTHETIC, Splitter:B:23:0x0068] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x006d A[SYNTHETIC, Splitter:B:26:0x006d] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0079 A[SYNTHETIC, Splitter:B:32:0x0079] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x007e A[SYNTHETIC, Splitter:B:35:0x007e] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a() {
        /*
        // Method dump skipped, instructions count: 156
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tbs.one.impl.common.statistic.c.a():java.lang.String");
    }

    private static String a(String str) {
        return str == null ? "" : str;
    }

    private static boolean a(Context context, String str) {
        AppMethodBeat.i(174216);
        if (context.getPackageManager().checkPermission(str, context.getPackageName()) == 0) {
            AppMethodBeat.o(174216);
            return true;
        }
        AppMethodBeat.o(174216);
        return false;
    }

    public static String b() {
        AppMethodBeat.i(174223);
        try {
            String str = new String(Build.MODEL.getBytes(MimeTypeUtil.ContentType.DEFAULT_CHARSET), "ISO8859-1");
            AppMethodBeat.o(174223);
            return str;
        } catch (Exception e2) {
            String str2 = Build.MODEL;
            AppMethodBeat.o(174223);
            return str2;
        }
    }

    public static String b(Context context) {
        AppMethodBeat.i(174218);
        String str = null;
        try {
            str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Exception e2) {
            f.c("Get app version name exception!", e2);
        }
        AppMethodBeat.o(174218);
        return str;
    }

    public static int c(Context context) {
        int i2 = 0;
        AppMethodBeat.i(174219);
        try {
            i2 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (Exception e2) {
        }
        AppMethodBeat.o(174219);
        return i2;
    }

    public static String c() {
        AppMethodBeat.i(174225);
        try {
            Map<String, Integer> map = a.RSp;
            StringBuilder sb = new StringBuilder();
            for (String str : map.keySet()) {
                sb.append(str).append(":").append(map.get(str)).append(";");
            }
            String sb2 = sb.toString();
            AppMethodBeat.o(174225);
            return sb2;
        } catch (Throwable th) {
            AppMethodBeat.o(174225);
            return "";
        }
    }

    public static String d(Context context) {
        AppMethodBeat.i(174220);
        String e2 = e(context);
        if (!TextUtils.isEmpty(e2)) {
            AppMethodBeat.o(174220);
            return e2;
        }
        String f2 = f(context);
        if (!TextUtils.isEmpty(f2)) {
            AppMethodBeat.o(174220);
            return f2;
        }
        AppMethodBeat.o(174220);
        return "unknown";
    }

    public static String e(Context context) {
        String str;
        AppMethodBeat.i(174221);
        if (!TextUtils.isEmpty(f2614a)) {
            str = f2614a;
        } else {
            try {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                if (a(context, "android.permission.READ_PHONE_STATE")) {
                    str = telephonyManager.getDeviceId();
                } else {
                    f.b("Require \"READ_PHONE_STATE\" permission for reading imei!", new Object[0]);
                    str = "";
                }
            } catch (Exception e2) {
                str = "";
            }
        }
        AppMethodBeat.o(174221);
        return str;
    }

    public static String f(Context context) {
        AppMethodBeat.i(174224);
        if (!TextUtils.isEmpty(f2616c)) {
            String str = f2616c;
            AppMethodBeat.o(174224);
            return str;
        }
        try {
            f2616c = Settings.Secure.getString(context.getContentResolver(), "android_id");
        } catch (Exception e2) {
        }
        String str2 = f2616c;
        AppMethodBeat.o(174224);
        return str2;
    }
}
