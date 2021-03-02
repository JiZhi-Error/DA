package com.tencent.smtt.sdk.c;

import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Point;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.http.HttpWrapperBase;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.smtt.sdk.TbsConfig;
import com.tencent.smtt.sdk.WebView;
import java.io.File;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class c {
    private byte _hellAccFlag_;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f2032a = -1;

        /* renamed from: b  reason: collision with root package name */
        public int f2033b = -1;

        /* renamed from: c  reason: collision with root package name */
        public String f2034c = "";

        /* renamed from: d  reason: collision with root package name */
        public String f2035d = AppEventsConstants.EVENT_PARAM_VALUE_NO;

        /* renamed from: e  reason: collision with root package name */
        public String f2036e = null;
    }

    /* access modifiers changed from: package-private */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public String f2037a;

        /* renamed from: b  reason: collision with root package name */
        public String f2038b;

        private b() {
            this.f2037a = "";
            this.f2038b = "";
        }
    }

    public static boolean a(Context context, String str, int i2, String str2, HashMap<String, String> hashMap, Bundle bundle) {
        Set<String> keySet;
        AppMethodBeat.i(188204);
        try {
            Intent intent = new Intent("com.tencent.QQBrowser.action.sdk.document");
            if (!(hashMap == null || (keySet = hashMap.keySet()) == null)) {
                for (String str3 : keySet) {
                    String str4 = hashMap.get(str3);
                    if (!TextUtils.isEmpty(str4)) {
                        intent.putExtra(str3, str4);
                    }
                }
            }
            new File(str);
            intent.putExtra("key_reader_sdk_id", 3);
            intent.putExtra("key_reader_sdk_type", i2);
            if (i2 == 0) {
                intent.putExtra("key_reader_sdk_path", str);
            } else if (i2 == 1) {
                intent.putExtra("key_reader_sdk_url", str);
            }
            intent.putExtra("key_reader_sdk_format", str2);
            if (context != null && context.getApplicationInfo().targetSdkVersion >= 24 && Build.VERSION.SDK_INT >= 24) {
                intent.addFlags(1);
            }
            Uri a2 = a(context, str);
            if (a2 == null) {
                AppMethodBeat.o(188204);
                return false;
            }
            intent.setDataAndType(a2, "mtt/".concat(String.valueOf(str2)));
            intent.putExtra("loginType", d(context.getApplicationContext()));
            if (bundle != null) {
                intent.putExtra("key_reader_sdk_extrals", bundle);
            }
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/smtt/sdk/c/c", "a", "(Landroid/content/Context;Ljava/lang/String;ILjava/lang/String;Ljava/util/HashMap;Landroid/os/Bundle;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            context.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/smtt/sdk/c/c", "a", "(Landroid/content/Context;Ljava/lang/String;ILjava/lang/String;Ljava/util/HashMap;Landroid/os/Bundle;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(188204);
            return true;
        } catch (Exception e2) {
            AppMethodBeat.o(188204);
            return false;
        }
    }

    private static Uri a(Context context, String str) {
        AppMethodBeat.i(188205);
        Uri fromFile = Uri.fromFile(new File(str));
        AppMethodBeat.o(188205);
        return fromFile;
    }

    public static boolean a(Context context, String str, HashMap<String, String> hashMap) {
        boolean z;
        Set<String> keySet;
        AppMethodBeat.i(188206);
        Uri parse = Uri.parse(str);
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setFlags(268435456);
        intent.setDataAndType(parse, "video/*");
        if (!(hashMap == null || (keySet = hashMap.keySet()) == null)) {
            for (String str2 : keySet) {
                String str3 = hashMap.get(str2);
                if (!TextUtils.isEmpty(str3)) {
                    intent.putExtra(str2, str3);
                }
            }
        }
        try {
            intent.putExtra("loginType", d(context));
            intent.setComponent(new ComponentName(TbsConfig.APP_QB, "com.tencent.mtt.browser.video.H5VideoThrdcallActivity"));
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/smtt/sdk/c/c", "a", "(Landroid/content/Context;Ljava/lang/String;Ljava/util/HashMap;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            context.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/smtt/sdk/c/c", "a", "(Landroid/content/Context;Ljava/lang/String;Ljava/util/HashMap;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            z = true;
        } catch (Throwable th) {
            z = false;
        }
        if (!z) {
            try {
                intent.setComponent(null);
                com.tencent.mm.hellhoundlib.b.a bl2 = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                com.tencent.mm.hellhoundlib.a.a.a(context, bl2.axQ(), "com/tencent/smtt/sdk/c/c", "a", "(Landroid/content/Context;Ljava/lang/String;Ljava/util/HashMap;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                context.startActivity((Intent) bl2.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/smtt/sdk/c/c", "a", "(Landroid/content/Context;Ljava/lang/String;Ljava/util/HashMap;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            } catch (Throwable th2) {
                AppMethodBeat.o(188206);
                return false;
            }
        }
        AppMethodBeat.o(188206);
        return true;
    }

    public static int a(Context context, String str, HashMap<String, String> hashMap, String str2, WebView webView) {
        boolean z;
        boolean z2;
        PackageInfo packageInfo;
        boolean z3 = false;
        AppMethodBeat.i(188207);
        StringBuilder sb = new StringBuilder();
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null || (packageInfo = packageManager.getPackageInfo(TbsConfig.APP_QB, 0)) == null || packageInfo.versionCode <= 601000) {
                z2 = false;
            } else {
                z2 = true;
            }
            z = z2;
        } catch (Throwable th) {
            z = false;
        }
        try {
            String encode = URLEncoder.encode(str, MimeTypeUtil.ContentType.DEFAULT_CHARSET);
            if (z) {
                str = encode;
            }
            z3 = z;
        } catch (Exception e2) {
        }
        sb.append("mttbrowser://url=").append(str).append(",product=TBS,packagename=").append(context.getPackageName()).append(",from=").append(str2).append(",version=4.4.0.0006").append(z3 ? ",encoded=1" : "");
        int a2 = a(context, sb.toString(), hashMap, webView);
        AppMethodBeat.o(188207);
        return a2;
    }

    public static int a(Context context, String str, HashMap<String, String> hashMap, WebView webView) {
        Intent intent;
        Set<String> keySet;
        AppMethodBeat.i(188208);
        if (context == null) {
            AppMethodBeat.o(188208);
            return 3;
        }
        if (!a(str)) {
            str = HttpWrapperBase.PROTOCAL_HTTP.concat(String.valueOf(str));
        }
        try {
            Uri parse = Uri.parse(str);
            if (parse == null) {
                AppMethodBeat.o(188208);
                return 2;
            }
            a a2 = a(context);
            if (a2.f2032a == -1) {
                AppMethodBeat.o(188208);
                return 4;
            } else if (a2.f2032a != 2 || a2.f2033b >= 33) {
                Intent intent2 = new Intent("android.intent.action.VIEW");
                if (a2.f2032a == 2) {
                    if (a2.f2033b >= 33 && a2.f2033b <= 39) {
                        intent2.setClassName(TbsConfig.APP_QB, "com.tencent.mtt.MainActivity");
                        intent = intent2;
                    } else if (a2.f2033b < 40 || a2.f2033b > 45) {
                        if (a2.f2033b >= 46) {
                            Intent intent3 = new Intent("com.tencent.QQBrowser.action.VIEW");
                            b a3 = a(context, parse);
                            if (a3 != null && !TextUtils.isEmpty(a3.f2037a)) {
                                intent3.setClassName(a3.f2038b, a3.f2037a);
                            }
                            intent = intent3;
                        }
                        intent = intent2;
                    } else {
                        intent2.setClassName(TbsConfig.APP_QB, "com.tencent.mtt.SplashActivity");
                        intent = intent2;
                    }
                } else if (a2.f2032a == 1) {
                    if (a2.f2033b == 1) {
                        intent2.setClassName("com.tencent.qbx5", "com.tencent.qbx5.MainActivity");
                        intent = intent2;
                    } else {
                        if (a2.f2033b == 2) {
                            intent2.setClassName("com.tencent.qbx5", "com.tencent.qbx5.SplashActivity");
                            intent = intent2;
                        }
                        intent = intent2;
                    }
                } else if (a2.f2032a != 0) {
                    Intent intent4 = new Intent("com.tencent.QQBrowser.action.VIEW");
                    b a4 = a(context, parse);
                    if (a4 != null && !TextUtils.isEmpty(a4.f2037a)) {
                        intent4.setClassName(a4.f2038b, a4.f2037a);
                    }
                    intent = intent4;
                } else if (a2.f2033b < 4 || a2.f2033b > 6) {
                    if (a2.f2033b > 6) {
                        Intent intent5 = new Intent("com.tencent.QQBrowser.action.VIEW");
                        b a5 = a(context, parse);
                        if (a5 != null && !TextUtils.isEmpty(a5.f2037a)) {
                            intent5.setClassName(a5.f2038b, a5.f2037a);
                        }
                        intent = intent5;
                    }
                    intent = intent2;
                } else {
                    intent2.setClassName("com.tencent.qbx", "com.tencent.qbx.SplashActivity");
                    intent = intent2;
                }
                intent.setData(parse);
                if (!(hashMap == null || (keySet = hashMap.keySet()) == null)) {
                    for (String str2 : keySet) {
                        String str3 = hashMap.get(str2);
                        if (!TextUtils.isEmpty(str3)) {
                            intent.putExtra(str2, str3);
                        }
                    }
                }
                try {
                    intent.putExtra("loginType", d(context));
                    intent.addFlags(268435456);
                    if (webView != null) {
                        intent.putExtra("AnchorPoint", new Point(webView.getScrollX(), webView.getScrollY()));
                        intent.putExtra("ContentSize", new Point(webView.getContentWidth(), webView.getContentHeight()));
                    }
                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                    com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/smtt/sdk/c/c", "a", "(Landroid/content/Context;Ljava/lang/String;Ljava/util/HashMap;Lcom/tencent/smtt/sdk/WebView;)I", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    context.startActivity((Intent) bl.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/smtt/sdk/c/c", "a", "(Landroid/content/Context;Ljava/lang/String;Ljava/util/HashMap;Lcom/tencent/smtt/sdk/WebView;)I", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    AppMethodBeat.o(188208);
                    return 0;
                } catch (ActivityNotFoundException e2) {
                    AppMethodBeat.o(188208);
                    return 4;
                }
            } else {
                AppMethodBeat.o(188208);
                return 5;
            }
        } catch (Exception e3) {
            AppMethodBeat.o(188208);
            return 2;
        }
    }

    private static int d(Context context) {
        AppMethodBeat.i(188209);
        int i2 = 26;
        String str = context.getApplicationInfo().processName;
        if (str.equals(TbsConfig.APP_QQ)) {
            i2 = 13;
        } else if (str.equals(TbsConfig.APP_QZONE)) {
            i2 = 14;
        } else if (str.equals("com.tencent.WBlog")) {
            i2 = 15;
        } else if (str.equals("com.tencent.mm")) {
            i2 = 24;
        }
        AppMethodBeat.o(188209);
        return i2;
    }

    private static b a(Context context, Uri uri) {
        AppMethodBeat.i(188210);
        Intent intent = new Intent("com.tencent.QQBrowser.action.VIEW");
        intent.setData(uri);
        List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
        if (queryIntentActivities.size() <= 0) {
            AppMethodBeat.o(188210);
            return null;
        }
        b bVar = new b();
        for (ResolveInfo resolveInfo : queryIntentActivities) {
            String str = resolveInfo.activityInfo.packageName;
            if (str.contains(TbsConfig.APP_QB)) {
                bVar.f2037a = resolveInfo.activityInfo.name;
                bVar.f2038b = resolveInfo.activityInfo.packageName;
                AppMethodBeat.o(188210);
                return bVar;
            } else if (str.contains("com.tencent.qbx")) {
                bVar.f2037a = resolveInfo.activityInfo.name;
                bVar.f2038b = resolveInfo.activityInfo.packageName;
            }
        }
        AppMethodBeat.o(188210);
        return bVar;
    }

    public static a a(Context context) {
        AppMethodBeat.i(188211);
        boolean z = context.getApplicationContext().getSharedPreferences("x5_proxy_setting", 0).getBoolean("qb_install_status", false);
        a aVar = new a();
        if (z) {
            AppMethodBeat.o(188211);
            return aVar;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            PackageInfo packageInfo = null;
            try {
                packageInfo = packageManager.getPackageInfo(TbsConfig.APP_QB, 0);
                aVar.f2032a = 2;
                aVar.f2036e = TbsConfig.APP_QB;
                aVar.f2034c = "ADRQB_";
                if (packageInfo != null && packageInfo.versionCode > 420000) {
                    aVar.f2033b = packageInfo.versionCode;
                    aVar.f2034c += packageInfo.versionName.replaceAll("\\.", "");
                    aVar.f2035d = packageInfo.versionName.replaceAll("\\.", "");
                    AppMethodBeat.o(188211);
                    return aVar;
                }
            } catch (PackageManager.NameNotFoundException e2) {
            }
            try {
                packageInfo = packageManager.getPackageInfo("com.tencent.qbx", 0);
                aVar.f2032a = 0;
                aVar.f2036e = "com.tencent.qbx";
                aVar.f2034c = "ADRQBX_";
            } catch (PackageManager.NameNotFoundException e3) {
                try {
                    packageInfo = packageManager.getPackageInfo("com.tencent.qbx5", 0);
                    aVar.f2032a = 1;
                    aVar.f2036e = "com.tencent.qbx5";
                    aVar.f2034c = "ADRQBX5_";
                } catch (PackageManager.NameNotFoundException e4) {
                    try {
                        packageInfo = packageManager.getPackageInfo(TbsConfig.APP_QB, 0);
                        aVar.f2036e = TbsConfig.APP_QB;
                        aVar.f2032a = 2;
                        aVar.f2034c = "ADRQB_";
                    } catch (PackageManager.NameNotFoundException e5) {
                        try {
                            packageInfo = packageManager.getPackageInfo("com.tencent.mtt.x86", 0);
                            aVar.f2036e = "com.tencent.mtt.x86";
                            aVar.f2032a = 2;
                            aVar.f2034c = "ADRQB_";
                        } catch (Exception e6) {
                            try {
                                b a2 = a(context, Uri.parse("https://mdc.html5.qq.com/mh?channel_id=50079&u="));
                                if (a2 != null && !TextUtils.isEmpty(a2.f2038b)) {
                                    packageInfo = packageManager.getPackageInfo(a2.f2038b, 0);
                                    aVar.f2036e = a2.f2038b;
                                    aVar.f2032a = 2;
                                    aVar.f2034c = "ADRQB_";
                                }
                            } catch (Exception e7) {
                            }
                        }
                    }
                }
            }
            if (packageInfo != null) {
                aVar.f2033b = packageInfo.versionCode;
                aVar.f2034c += packageInfo.versionName.replaceAll("\\.", "");
                aVar.f2035d = packageInfo.versionName.replaceAll("\\.", "");
            }
        } catch (Exception e8) {
        }
        AppMethodBeat.o(188211);
        return aVar;
    }

    private static boolean a(String str) {
        AppMethodBeat.i(188212);
        if (str == null || str.length() == 0) {
            AppMethodBeat.o(188212);
            return false;
        }
        String trim = str.trim();
        int indexOf = trim.toLowerCase().indexOf("://");
        int indexOf2 = trim.toLowerCase().indexOf(46);
        if (indexOf <= 0 || indexOf2 <= 0 || indexOf <= indexOf2) {
            boolean contains = trim.toLowerCase().contains("://");
            AppMethodBeat.o(188212);
            return contains;
        }
        AppMethodBeat.o(188212);
        return false;
    }

    public static boolean b(Context context) {
        AppMethodBeat.i(188213);
        if (a(context).f2032a == -1) {
            AppMethodBeat.o(188213);
            return false;
        }
        AppMethodBeat.o(188213);
        return true;
    }

    public static boolean c(Context context) {
        boolean z = true;
        AppMethodBeat.i(188214);
        a a2 = a(context);
        boolean z2 = false;
        try {
            if (Long.valueOf(a2.f2035d).longValue() >= 6001500) {
                z2 = true;
            }
        } catch (NumberFormatException e2) {
        }
        if (a2.f2033b < 601500) {
            z = z2;
        }
        AppMethodBeat.o(188214);
        return z;
    }

    public static boolean a(Context context, long j2, long j3) {
        boolean z = true;
        AppMethodBeat.i(188215);
        a a2 = a(context);
        boolean z2 = false;
        try {
            if (Long.valueOf(a2.f2035d).longValue() >= j2) {
                z2 = true;
            }
        } catch (NumberFormatException e2) {
        }
        if (((long) a2.f2033b) < j3) {
            z = z2;
        }
        AppMethodBeat.o(188215);
        return z;
    }
}
