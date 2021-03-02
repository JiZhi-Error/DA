package com.tencent.smtt.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.smtt.sdk.TbsConfig;
import com.tencent.smtt.sdk.WebView;

public class l {

    /* renamed from: a  reason: collision with root package name */
    private static String f2263a = null;

    /* renamed from: b  reason: collision with root package name */
    private static String f2264b = "GA";

    /* renamed from: c  reason: collision with root package name */
    private static String f2265c = "GE";

    /* renamed from: d  reason: collision with root package name */
    private static String f2266d = "9422";

    /* renamed from: e  reason: collision with root package name */
    private static String f2267e = AppEventsConstants.EVENT_PARAM_VALUE_NO;

    /* renamed from: f  reason: collision with root package name */
    private static String f2268f = "";

    /* renamed from: g  reason: collision with root package name */
    private static boolean f2269g = false;

    /* renamed from: h  reason: collision with root package name */
    private static boolean f2270h = false;

    /* renamed from: i  reason: collision with root package name */
    private static boolean f2271i = false;

    public static String a(Context context) {
        AppMethodBeat.i(53920);
        if (!TextUtils.isEmpty(f2263a)) {
            String str = f2263a;
            AppMethodBeat.o(53920);
            return str;
        }
        String a2 = a(context, String.valueOf(WebView.getTbsSDKVersion(context)), AppEventsConstants.EVENT_PARAM_VALUE_NO, f2264b, f2265c, f2266d, f2267e, f2268f, f2269g);
        f2263a = a2;
        AppMethodBeat.o(53920);
        return a2;
    }

    private static String a(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7, boolean z) {
        String str8;
        String str9;
        String str10;
        AppMethodBeat.i(53921);
        String str11 = "";
        StringBuilder sb = new StringBuilder();
        String str12 = b(context) + "*" + c(context);
        try {
            ApplicationInfo applicationInfo = context.getApplicationContext().getApplicationInfo();
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(applicationInfo.packageName, 0);
            str11 = applicationInfo.packageName;
            if (TextUtils.isEmpty(str7)) {
                str7 = packageInfo.versionName;
            }
        } catch (PackageManager.NameNotFoundException e2) {
            str7 = "";
        }
        String a2 = a(str11);
        if ("QB".equals(a2)) {
            if (z) {
                str8 = "PAD";
            }
            str8 = "PHONE";
        } else {
            if (d(context)) {
                str8 = "PAD";
            }
            str8 = "PHONE";
        }
        sb.append("QV=3");
        a(sb, "PL", "ADR");
        a(sb, "PR", a2);
        a(sb, "PP", str11);
        a(sb, "PPVN", str7);
        if (!TextUtils.isEmpty(str)) {
            a(sb, "TBSVC", str);
        }
        a(sb, "CO", "SYS");
        if (!TextUtils.isEmpty(str2)) {
            a(sb, "COVC", str2);
        }
        a(sb, "PB", str4);
        a(sb, "VE", str3);
        a(sb, "DE", str8);
        if (TextUtils.isEmpty(str6)) {
            str6 = AppEventsConstants.EVENT_PARAM_VALUE_NO;
        }
        a(sb, "CHID", str6);
        a(sb, "LCID", str5);
        String a3 = a();
        try {
            str9 = new String(a3.getBytes(MimeTypeUtil.ContentType.DEFAULT_CHARSET), "ISO8859-1");
        } catch (Exception e3) {
            str9 = a3;
        }
        if (!TextUtils.isEmpty(str9)) {
            a(sb, "MO", str9);
        }
        a(sb, "RL", str12);
        String str13 = Build.VERSION.RELEASE;
        try {
            str10 = new String(str13.getBytes(MimeTypeUtil.ContentType.DEFAULT_CHARSET), "ISO8859-1");
        } catch (Exception e4) {
            str10 = str13;
        }
        if (!TextUtils.isEmpty(str10)) {
            a(sb, "OS", str10);
        }
        a(sb, "API", new StringBuilder().append(Build.VERSION.SDK_INT).toString());
        String sb2 = sb.toString();
        AppMethodBeat.o(53921);
        return sb2;
    }

    private static void a(StringBuilder sb, String str, String str2) {
        AppMethodBeat.i(53922);
        sb.append("&").append(str).append("=").append(str2);
        AppMethodBeat.o(53922);
    }

    private static String a(String str) {
        AppMethodBeat.i(53923);
        if ("com.tencent.mm".equals(str)) {
            AppMethodBeat.o(53923);
            return "WX";
        } else if (TbsConfig.APP_QQ.equals(str)) {
            AppMethodBeat.o(53923);
            return "QQ";
        } else if (TbsConfig.APP_QZONE.equals(str)) {
            AppMethodBeat.o(53923);
            return "QZ";
        } else if (TbsConfig.APP_QB.equals(str)) {
            AppMethodBeat.o(53923);
            return "QB";
        } else {
            AppMethodBeat.o(53923);
            return "TRD";
        }
    }

    private static int b(Context context) {
        AppMethodBeat.i(53924);
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        if (defaultDisplay != null) {
            int width = defaultDisplay.getWidth();
            AppMethodBeat.o(53924);
            return width;
        }
        AppMethodBeat.o(53924);
        return -1;
    }

    private static int c(Context context) {
        AppMethodBeat.i(53925);
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        if (defaultDisplay != null) {
            int height = defaultDisplay.getHeight();
            AppMethodBeat.o(53925);
            return height;
        }
        AppMethodBeat.o(53925);
        return -1;
    }

    private static String a() {
        AppMethodBeat.i(53926);
        String str = " " + Build.MODEL.replaceAll("[ |\\/|\\_|\\&|\\|]", "") + " ";
        AppMethodBeat.o(53926);
        return str;
    }

    private static boolean d(Context context) {
        boolean z = true;
        AppMethodBeat.i(53927);
        if (f2270h) {
            boolean z2 = f2271i;
            AppMethodBeat.o(53927);
            return z2;
        }
        try {
            if ((Math.min(b(context), c(context)) * 160) / e(context) < 700) {
                z = false;
            }
            f2271i = z;
            f2270h = true;
            boolean z3 = f2271i;
            AppMethodBeat.o(53927);
            return z3;
        } catch (Throwable th) {
            AppMethodBeat.o(53927);
            return false;
        }
    }

    private static int e(Context context) {
        AppMethodBeat.i(53928);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        if (defaultDisplay != null) {
            defaultDisplay.getMetrics(displayMetrics);
            int i2 = displayMetrics.densityDpi;
            AppMethodBeat.o(53928);
            return i2;
        }
        AppMethodBeat.o(53928);
        return 160;
    }
}
