package com.tencent.mm.pluginsdk.model;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.pluginsdk.model.u;
import com.tencent.mm.sdk.http.HttpWrapperBase;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.TbsConfig;
import java.net.URLEncoder;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class r extends t {
    public static final String[] JVr = {"application/msword", "application/vnd.ms-powerpoint", "application/vnd.ms-excel", "application/pdf", "application/epub+zip", "text/plain", "application/vnd.openxmlformats-officedocument.wordprocessingml.document", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet", "application/vnd.openxmlformats-officedocument.presentationml.presentation", "application/zip", "application/rar"};
    public static final int[] JVs = {R.raw.app_attach_file_icon_word, R.raw.app_attach_file_icon_ppt, R.raw.app_attach_file_icon_excel, R.raw.app_attach_file_icon_pdf, R.raw.app_attach_file_icon_epub, R.raw.app_attach_file_icon_txt, R.raw.app_attach_file_icon_word, R.raw.app_attach_file_icon_excel, R.raw.app_attach_file_icon_ppt, R.raw.app_attach_file_icon_rar, R.raw.app_attach_file_icon_rar};
    public static final int[] JVt = {R.raw.app_attach_file_icon_word, R.raw.app_attach_file_icon_ppt, R.raw.app_attach_file_icon_excel, R.raw.app_attach_file_icon_pdf, R.raw.app_attach_file_icon_epub, R.raw.app_attach_file_icon_txt, R.raw.app_attach_file_icon_word, R.raw.app_attach_file_icon_excel, R.raw.app_attach_file_icon_ppt, R.raw.app_attach_file_icon_rar, R.raw.app_attach_file_icon_rar};

    public static class a {
        public int JVv = -1;
        public String JVw = "";
        public int ver = -1;
    }

    @Override // com.tencent.mm.pluginsdk.model.t
    public final boolean in(Context context) {
        AppMethodBeat.i(109463);
        a ip = ip(context);
        if (ip.JVv == -1) {
            AppMethodBeat.o(109463);
            return false;
        } else if (ip.JVv != 2 || ip.ver >= 33) {
            AppMethodBeat.o(109463);
            return true;
        } else {
            AppMethodBeat.o(109463);
            return false;
        }
    }

    public static boolean io(Context context) {
        AppMethodBeat.i(109464);
        if (ip(context).JVv == -1) {
            AppMethodBeat.o(109464);
            return false;
        }
        AppMethodBeat.o(109464);
        return true;
    }

    @Override // com.tencent.mm.pluginsdk.model.t
    public final boolean bdn(String str) {
        AppMethodBeat.i(109465);
        if (TbsConfig.APP_QB.equals(str) || "com.tencent.qbx".equals(str) || "com.tencent.mtt.x86".equals(str) || "com.tencent.qbx5".equals(str)) {
            AppMethodBeat.o(109465);
            return true;
        }
        AppMethodBeat.o(109465);
        return false;
    }

    @Override // com.tencent.mm.pluginsdk.model.t
    public final String blB() {
        return "http://appchannel.html5.qq.com/directdown?app=qqbrowser&channel=10318";
    }

    @Override // com.tencent.mm.pluginsdk.model.t
    public final String gmq() {
        return "qq_browser.apk";
    }

    @Override // com.tencent.mm.pluginsdk.model.t
    public final u.a gmr() {
        AppMethodBeat.i(109466);
        u.a aVar = new u.a();
        aVar.JVB = R.string.fr0;
        aVar.JVD = R.string.fr1;
        aVar.JVA = R.drawable.icon_qqbrowser;
        AppMethodBeat.o(109466);
        return aVar;
    }

    @Override // com.tencent.mm.pluginsdk.model.t
    public final String c(Context context, ResolveInfo resolveInfo) {
        AppMethodBeat.i(109467);
        if (context == null || resolveInfo == null || resolveInfo.activityInfo == null || resolveInfo.activityInfo.packageName == null) {
            AppMethodBeat.o(109467);
            return null;
        }
        String str = resolveInfo.activityInfo.packageName;
        if ("com.qihoo.browser".equals(str)) {
            AppMethodBeat.o(109467);
            return "360浏览器";
        } else if ("com.mx.browser".equals(str)) {
            AppMethodBeat.o(109467);
            return "傲游云浏览器";
        } else if ("com.dolphin.browser.xf".equals(str)) {
            AppMethodBeat.o(109467);
            return "海豚浏览器";
        } else if ("com.UCMobile".equals(str)) {
            AppMethodBeat.o(109467);
            return "UC浏览器";
        } else if ("com.baidu.browser.apps".equals(str)) {
            AppMethodBeat.o(109467);
            return "百度浏览器";
        } else if ("sogou.mobile.explorer".equals(str)) {
            AppMethodBeat.o(109467);
            return "搜狗浏览器";
        } else if ("com.ijinshan.browser".equals(str)) {
            AppMethodBeat.o(109467);
            return "猎豹浏览器";
        } else if ("com.mediawoz.xbrowser".equals(str)) {
            AppMethodBeat.o(109467);
            return "GO浏览器";
        } else if ("com.oupeng.browser".equals(str)) {
            AppMethodBeat.o(109467);
            return "欧朋浏览器";
        } else if ("com.tiantianmini.android.browser".equals(str)) {
            AppMethodBeat.o(109467);
            return "天天浏览器";
        } else {
            CharSequence loadLabel = resolveInfo.activityInfo.loadLabel(context.getPackageManager());
            if (loadLabel != null) {
                Matcher matcher = Pattern.compile("\\(.*推荐.*\\)", 2).matcher(loadLabel.toString());
                if (matcher.find()) {
                    String replaceAll = matcher.replaceAll("");
                    AppMethodBeat.o(109467);
                    return replaceAll;
                }
            }
            String charSequence = resolveInfo.activityInfo.loadLabel(context.getPackageManager()).toString();
            AppMethodBeat.o(109467);
            return charSequence;
        }
    }

    public final int cg(Context context, String str) {
        boolean z;
        boolean z2;
        AppMethodBeat.i(109468);
        if (context == null) {
            AppMethodBeat.o(109468);
            return 3;
        }
        if (str == null || str.length() == 0) {
            z = false;
        } else {
            String trim = str.trim();
            int indexOf = trim.toLowerCase().indexOf("://");
            int indexOf2 = trim.toLowerCase().indexOf(46);
            if (indexOf <= 0 || indexOf2 <= 0 || indexOf <= indexOf2) {
                z = trim.toLowerCase().contains("://");
            } else {
                z = false;
            }
        }
        if (!z) {
            str = HttpWrapperBase.PROTOCAL_HTTP.concat(String.valueOf(str));
        }
        try {
            Uri parse = Uri.parse(str);
            if (parse == null) {
                AppMethodBeat.o(109468);
                return 2;
            }
            if (parse.getScheme().toLowerCase().equals("qb")) {
                a ip = ip(context);
                if (ip.JVv == -1) {
                    z2 = false;
                } else if (ip.JVv != 2 || ip.ver >= 42) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (!z2) {
                    parse = Uri.parse("http://appchannel.html5.qq.com/directdown?app=qqbrowser&channel=10375" + URLEncoder.encode(str, MimeTypeUtil.ContentType.DEFAULT_CHARSET));
                }
            }
            a ip2 = ip(context);
            if (ip2.JVv == -1) {
                AppMethodBeat.o(109468);
                return 4;
            } else if (ip2.JVv != 2 || ip2.ver >= 33) {
                Intent intent = new Intent("android.intent.action.VIEW");
                if (ip2.JVv == 2) {
                    if (ip2.ver >= 33 && ip2.ver <= 39) {
                        intent.setClassName(TbsConfig.APP_QB, "com.tencent.mtt.PhotoEditUI");
                    } else if (ip2.ver >= 40 && ip2.ver <= 45) {
                        intent.setClassName(TbsConfig.APP_QB, "com.tencent.mtt.SplashActivity");
                    } else if (ip2.ver >= 46) {
                        intent = new Intent("com.tencent.QQBrowser.action.VIEW");
                        b j2 = j(context, parse);
                        if (j2 != null && !TextUtils.isEmpty(j2.classname)) {
                            intent.setClassName(j2.JVx, j2.classname);
                        }
                    }
                } else if (ip2.JVv == 1) {
                    if (ip2.ver == 1) {
                        intent.setClassName("com.tencent.qbx5", "com.tencent.qbx5.PhotoEditUI");
                    } else if (ip2.ver == 2) {
                        intent.setClassName("com.tencent.qbx5", "com.tencent.qbx5.SplashActivity");
                    }
                } else if (ip2.JVv != 0) {
                    intent = new Intent("com.tencent.QQBrowser.action.VIEW");
                    b j3 = j(context, parse);
                    if (j3 != null && !TextUtils.isEmpty(j3.classname)) {
                        intent.setClassName(j3.JVx, j3.classname);
                    }
                } else if (ip2.ver >= 4 && ip2.ver <= 6) {
                    intent.setClassName("com.tencent.qbx", "com.tencent.qbx.SplashActivity");
                } else if (ip2.ver > 6) {
                    intent = new Intent("com.tencent.QQBrowser.action.VIEW");
                    b j4 = j(context, parse);
                    if (j4 != null && !TextUtils.isEmpty(j4.classname)) {
                        intent.setClassName(j4.JVx, j4.classname);
                    }
                }
                intent.setData(parse);
                try {
                    intent.putExtra("loginType", 24);
                    intent.putExtra(QbSdk.LOGIN_TYPE_KEY_PARTNER_ID, "com.tencent.mm");
                    intent.putExtra(QbSdk.LOGIN_TYPE_KEY_PARTNER_CALL_POS, 0);
                    if (d.oD(29)) {
                        PendingIntent.getActivity(context, 0, intent, 134217728).send(context, 1, null, new PendingIntent.OnFinished() {
                            /* class com.tencent.mm.pluginsdk.model.r.AnonymousClass1 */

                            public final void onSendFinished(PendingIntent pendingIntent, Intent intent, int i2, String str, Bundle bundle) {
                                AppMethodBeat.i(204762);
                                Log.i("MicroMsg.QQBrowserHelper", "onSendFinished resultCode: %d, , resultData: %s", Integer.valueOf(i2), str);
                                AppMethodBeat.o(204762);
                            }
                        }, null);
                    } else {
                        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/pluginsdk/model/QQBrowserHelper", "loadUrl", "(Landroid/content/Context;Ljava/lang/String;)I", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        context.startActivity((Intent) bl.pG(0));
                        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/pluginsdk/model/QQBrowserHelper", "loadUrl", "(Landroid/content/Context;Ljava/lang/String;)I", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    }
                    AppMethodBeat.o(109468);
                    return 0;
                } catch (Exception e2) {
                    Log.e("MicroMsg.QQBrowserHelper", "open in browser failed : %s", e2.getMessage());
                    AppMethodBeat.o(109468);
                    return 4;
                }
            } else {
                AppMethodBeat.o(109468);
                return 5;
            }
        } catch (Exception e3) {
            AppMethodBeat.o(109468);
            return 2;
        }
    }

    private static a ip(Context context) {
        AppMethodBeat.i(109469);
        a aVar = new a();
        try {
            PackageManager packageManager = context.getPackageManager();
            PackageInfo packageInfo = null;
            try {
                packageInfo = packageManager.getPackageInfo(TbsConfig.APP_QB, 0);
                aVar.JVv = 2;
                aVar.JVw = "ADRQB_";
                if (packageInfo != null && packageInfo.versionCode > 420000) {
                    aVar.ver = packageInfo.versionCode;
                    aVar.JVw += packageInfo.versionName.replaceAll("\\.", "");
                    AppMethodBeat.o(109469);
                    return aVar;
                }
            } catch (PackageManager.NameNotFoundException e2) {
            }
            try {
                packageInfo = packageManager.getPackageInfo("com.tencent.qbx", 0);
                aVar.JVv = 0;
                aVar.JVw = "ADRQBX_";
            } catch (PackageManager.NameNotFoundException e3) {
                try {
                    packageInfo = packageManager.getPackageInfo("com.tencent.qbx5", 0);
                    aVar.JVv = 1;
                    aVar.JVw = "ADRQBX5_";
                } catch (PackageManager.NameNotFoundException e4) {
                    try {
                        packageInfo = packageManager.getPackageInfo(TbsConfig.APP_QB, 0);
                        aVar.JVv = 2;
                        aVar.JVw = "ADRQB_";
                    } catch (PackageManager.NameNotFoundException e5) {
                        try {
                            packageInfo = packageManager.getPackageInfo("com.tencent.mtt.x86", 0);
                            aVar.JVv = 2;
                            aVar.JVw = "ADRQB_";
                        } catch (Exception e6) {
                            try {
                                b j2 = j(context, Uri.parse("http://appchannel.html5.qq.com/directdown?app=qqbrowser&channel=10375"));
                                if (j2 != null && !TextUtils.isEmpty(j2.JVx)) {
                                    packageInfo = packageManager.getPackageInfo(j2.JVx, 0);
                                    aVar.JVv = 2;
                                    aVar.JVw = "ADRQB_";
                                }
                            } catch (Exception e7) {
                            }
                        }
                    }
                }
            }
            if (packageInfo != null) {
                aVar.ver = packageInfo.versionCode;
                aVar.JVw += packageInfo.versionName.replaceAll("\\.", "");
            }
        } catch (Exception e8) {
        }
        AppMethodBeat.o(109469);
        return aVar;
    }

    private static b j(Context context, Uri uri) {
        AppMethodBeat.i(109470);
        Intent intent = new Intent("com.tencent.QQBrowser.action.VIEW");
        intent.setData(uri);
        List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
        if (queryIntentActivities.size() <= 0) {
            AppMethodBeat.o(109470);
            return null;
        }
        b bVar = new b((byte) 0);
        for (ResolveInfo resolveInfo : queryIntentActivities) {
            String str = resolveInfo.activityInfo.packageName;
            if (str.contains(TbsConfig.APP_QB)) {
                bVar.classname = resolveInfo.activityInfo.name;
                bVar.JVx = resolveInfo.activityInfo.packageName;
                AppMethodBeat.o(109470);
                return bVar;
            } else if (str.contains("com.tencent.qbx")) {
                bVar.classname = resolveInfo.activityInfo.name;
                bVar.JVx = resolveInfo.activityInfo.packageName;
            }
        }
        AppMethodBeat.o(109470);
        return bVar;
    }

    @Override // com.tencent.mm.pluginsdk.model.t
    public final boolean aw(Context context, Intent intent) {
        AppMethodBeat.i(109471);
        List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
        if (queryIntentActivities != null && queryIntentActivities.size() > 0) {
            for (ResolveInfo resolveInfo : queryIntentActivities) {
                String str = resolveInfo.activityInfo.packageName;
                if (str.contains(TbsConfig.APP_QB)) {
                    AppMethodBeat.o(109471);
                    return true;
                } else if (str.contains("com.tencent.qbx")) {
                    AppMethodBeat.o(109471);
                    return true;
                }
            }
        }
        AppMethodBeat.o(109471);
        return false;
    }

    /* access modifiers changed from: package-private */
    public static class b {
        public String JVx;
        public String classname;

        private b() {
            this.classname = "";
            this.JVx = "";
        }

        /* synthetic */ b(byte b2) {
            this();
        }
    }

    public static int bdt(String str) {
        AppMethodBeat.i(109472);
        String str2 = null;
        if (str != null && str.length() > 0) {
            str2 = MimeTypeMap.getSingleton().getMimeTypeFromExtension(str);
        }
        if (str2 == null || str2.length() == 0) {
            str2 = "*/".concat(String.valueOf(str));
        }
        int i2 = -1;
        for (int i3 = 0; i3 < JVr.length; i3++) {
            if (JVr[i3].equals(str2)) {
                i2 = i3;
            }
        }
        if (i2 != -1) {
            int i4 = JVs[i2];
            AppMethodBeat.o(109472);
            return i4;
        }
        AppMethodBeat.o(109472);
        return R.raw.app_attach_file_icon_unknow;
    }
}
