package com.tencent.mm.plugin.multitalk.d;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ab.i;
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.b.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.sdk.http.HttpWrapperBase;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.ui.base.h;
import java.security.MessageDigest;

public final class b {
    private static final String zYQ = (HttpWrapperBase.PROTOCAL_HTTPS + WeChatHosts.domainString(R.string.e1v) + "/mobile/wx-entry.html#/?scene=");
    private static final String zYR = (HttpWrapperBase.PROTOCAL_HTTPS + WeChatHosts.domainString(R.string.e2o) + "/nl/meeting_intro_wxwork?scene=");

    static {
        AppMethodBeat.i(239509);
        AppMethodBeat.o(239509);
    }

    public static boolean epM() {
        AppMethodBeat.i(164065);
        if (epN() || epO() || epP()) {
            AppMethodBeat.o(164065);
            return true;
        }
        AppMethodBeat.o(164065);
        return false;
    }

    public static boolean epN() {
        AppMethodBeat.i(164066);
        if (((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_multitalk_ad_type1, 0) == 1) {
            AppMethodBeat.o(164066);
            return true;
        }
        AppMethodBeat.o(164066);
        return false;
    }

    public static boolean epO() {
        AppMethodBeat.i(164067);
        if (((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_multitalk_ad_type1, 0) == 2) {
            AppMethodBeat.o(164067);
            return true;
        }
        AppMethodBeat.o(164067);
        return false;
    }

    private static boolean epP() {
        AppMethodBeat.i(164068);
        if (((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_multitalk_ad_type1, 0) == 3) {
            AppMethodBeat.o(164068);
            return true;
        }
        AppMethodBeat.o(164068);
        return false;
    }

    public static String getIconUrl() {
        AppMethodBeat.i(164069);
        String a2 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_multitalk_ad_icon1, "");
        AppMethodBeat.o(164069);
        return a2;
    }

    private static String epQ() {
        AppMethodBeat.i(164070);
        String a2 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_multitalk_ad_wording1, "");
        if (!Util.isNullOrNil(a2)) {
            try {
                i iVar = new i(a2);
                String applicationLanguage = LocaleUtil.getApplicationLanguage();
                Log.i("MicroMsg.MeetingLinkHelper", "getLocalConfigWording, langCode:%s", applicationLanguage);
                String optString = iVar.optString(applicationLanguage);
                AppMethodBeat.o(164070);
                return optString;
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.MeetingLinkHelper", e2, "getLocalConfigWording error", new Object[0]);
            }
        }
        AppMethodBeat.o(164070);
        return null;
    }

    private static String epR() {
        AppMethodBeat.i(164071);
        String epQ = epQ();
        if (!Util.isNullOrNil(epQ)) {
            try {
                String optString = new i(epQ).optString("dialog");
                AppMethodBeat.o(164071);
                return optString;
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.MeetingLinkHelper", e2, "getConfigDialogContentWording error", new Object[0]);
            }
        }
        AppMethodBeat.o(164071);
        return null;
    }

    private static String epS() {
        AppMethodBeat.i(164072);
        String epQ = epQ();
        if (!Util.isNullOrNil(epQ)) {
            try {
                String optString = new i(epQ).optString("dialog_goto");
                AppMethodBeat.o(164072);
                return optString;
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.MeetingLinkHelper", e2, "getConfigDialogGotoWording error", new Object[0]);
            }
        }
        AppMethodBeat.o(164072);
        return null;
    }

    public static String epT() {
        AppMethodBeat.i(164073);
        String epQ = epQ();
        if (!Util.isNullOrNil(epQ)) {
            try {
                String optString = new i(epQ).optString("banner_title");
                AppMethodBeat.o(164073);
                return optString;
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.MeetingLinkHelper", e2, "getConfigBannerTitleWording error", new Object[0]);
            }
        }
        AppMethodBeat.o(164073);
        return null;
    }

    public static String epU() {
        AppMethodBeat.i(164074);
        String epQ = epQ();
        if (!Util.isNullOrNil(epQ)) {
            try {
                String optString = new i(epQ).optString("banner_content");
                AppMethodBeat.o(164074);
                return optString;
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.MeetingLinkHelper", e2, "getConfigBannerContentWording error", new Object[0]);
            }
        }
        AppMethodBeat.o(164074);
        return null;
    }

    public static void gG(final Context context) {
        AppMethodBeat.i(239508);
        if (epM()) {
            String str = "";
            String str2 = "";
            if (!Util.isNullOrNil(epR()) && !Util.isNullOrNil(epS())) {
                str = epR();
                str2 = epS();
            } else if (epN()) {
                str = context.getString(R.string.f6l);
                str2 = context.getString(R.string.f6c);
            } else if (epO()) {
                str = context.getString(R.string.f6m);
                str2 = context.getString(R.string.f6d);
            }
            if (Util.isNullOrNil(str) || Util.isNullOrNil(str2)) {
                Log.e("MicroMsg.MeetingLinkHelper", "cannot get dialog wording, ignore");
                AppMethodBeat.o(239508);
                return;
            }
            h.a(context, str, "", str2, context.getString(R.string.sz), new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.multitalk.d.b.AnonymousClass1 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(164063);
                    b.bi(context, "dlg");
                    c.a(b.epW(), 0, 0, 0, 0, 0, 0, 0, 0, null, 1);
                    AppMethodBeat.o(164063);
                }
            }, new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.multitalk.d.b.AnonymousClass2 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(164064);
                    c.a(b.epW(), 0, 0, 1, 0, 0, 0, 0, 0, null, 0);
                    dialogInterface.cancel();
                    AppMethodBeat.o(164064);
                }
            }, (int) R.color.Link);
            c.a(epW(), 0, 1, 0, 0, 0, 0, 0, 0, "", 0);
            AppMethodBeat.o(239508);
            return;
        }
        Toast.makeText(context, MMApplicationContext.getContext().getString(R.string.f6z, Integer.valueOf(e.epZ())), 0).show();
        AppMethodBeat.o(239508);
    }

    private static String epV() {
        AppMethodBeat.i(164075);
        String a2 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_multitalk_ad_url1, "");
        if (Util.isNullOrNil(a2)) {
            if (epN()) {
                a2 = zYQ;
            } else if (epO()) {
                a2 = zYR;
            }
        }
        AppMethodBeat.o(164075);
        return a2;
    }

    public static int epW() {
        AppMethodBeat.i(164076);
        if (epN()) {
            AppMethodBeat.o(164076);
            return 1;
        } else if (epO()) {
            AppMethodBeat.o(164076);
            return 2;
        } else if (epP()) {
            AppMethodBeat.o(164076);
            return 3;
        } else {
            AppMethodBeat.o(164076);
            return 0;
        }
    }

    private static boolean iQ(String str, String str2) {
        boolean z;
        String stringBuffer;
        AppMethodBeat.i(164077);
        try {
            PackageInfo packageInfo = MMApplicationContext.getContext().getPackageManager().getPackageInfo(str, 64);
            if (packageInfo != null) {
                byte[] byteArray = packageInfo.signatures[0].toByteArray();
                MessageDigest instance = MessageDigest.getInstance("MD5");
                instance.update(byteArray);
                byte[] digest = instance.digest();
                if (digest == null) {
                    stringBuffer = null;
                } else {
                    StringBuffer stringBuffer2 = new StringBuffer(digest.length);
                    for (byte b2 : digest) {
                        String hexString = Integer.toHexString(b2 & 255);
                        if (hexString.length() < 2) {
                            stringBuffer2.append(0);
                        }
                        stringBuffer2.append(hexString.toLowerCase());
                    }
                    stringBuffer = stringBuffer2.toString();
                }
                if (Util.isEqual(stringBuffer, str2.toUpperCase()) || Util.isEqual(stringBuffer, str2.toLowerCase())) {
                    z = true;
                    Log.i("MicroMsg.MeetingLinkHelper", "checkPackageInstalled result:%s", Boolean.valueOf(z));
                    AppMethodBeat.o(164077);
                    return z;
                }
            }
            z = false;
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.MeetingLinkHelper", e2, "checkPackageInstalled Exception: %s", e2.getMessage());
            z = false;
        }
        Log.i("MicroMsg.MeetingLinkHelper", "checkPackageInstalled result:%s", Boolean.valueOf(z));
        AppMethodBeat.o(164077);
        return z;
    }

    private static String getAppName(Context context, String str) {
        AppMethodBeat.i(164078);
        PackageManager packageManager = context.getPackageManager();
        try {
            String charSequence = packageManager.getApplicationInfo(str, 0).loadLabel(packageManager).toString();
            AppMethodBeat.o(164078);
            return charSequence;
        } catch (PackageManager.NameNotFoundException e2) {
            AppMethodBeat.o(164078);
            return null;
        }
    }

    private static boolean a(Context context, String str, String str2, boolean z) {
        AppMethodBeat.i(164079);
        Log.i("MicroMsg.MeetingLinkHelper", "jumpApp, packageName:%s, schema:%s", str, str2);
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.setData(Uri.parse(str2));
        intent.setPackage(str);
        intent.setFlags(268435456);
        if (context instanceof Activity) {
            if (z) {
                try {
                    boolean b2 = com.tencent.mm.pluginsdk.model.app.h.b(context, intent, getAppName(context, str));
                    AppMethodBeat.o(164079);
                    return b2;
                } catch (Exception e2) {
                    AppMethodBeat.o(164079);
                    return false;
                }
            } else {
                a bl = new a().bl(intent);
                com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/multitalk/utils/MeetingLinkHelper", "jumpApp", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Z)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                context.startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/multitalk/utils/MeetingLinkHelper", "jumpApp", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Z)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                ((Activity) context).overridePendingTransition(R.anim.ei, -1);
            }
        }
        AppMethodBeat.o(164079);
        return true;
    }

    private static i epX() {
        AppMethodBeat.i(164080);
        String a2 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_multitalk_ad_extraconfig1, "");
        if (!Util.isNullOrNil(a2)) {
            try {
                i iVar = new i(a2);
                AppMethodBeat.o(164080);
                return iVar;
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.MeetingLinkHelper", e2, "getConfigExtraInfoJsonObject error", new Object[0]);
            }
        }
        AppMethodBeat.o(164080);
        return null;
    }

    private static String epY() {
        AppMethodBeat.i(164081);
        i epX = epX();
        if (epX != null) {
            String optString = epX.optString("package_name");
            AppMethodBeat.o(164081);
            return optString;
        }
        AppMethodBeat.o(164081);
        return null;
    }

    public static void bi(Context context, String str) {
        boolean z;
        String str2;
        int i2;
        int i3;
        String str3 = null;
        AppMethodBeat.i(164084);
        Log.i("MicroMsg.MeetingLinkHelper", "handleMeetingLinkClick, isAllowedToShowMeetingLink:%s, isAllowedToShowWorkWeChat:%s", Boolean.valueOf(epN()), Boolean.valueOf(epO()));
        if (epM()) {
            if (epN()) {
                boolean iQ = iQ("com.tencent.wemeet.app", "EF1B5A11844923BB7515E6F6AFCBC45F");
                Log.i("MicroMsg.MeetingLinkHelper", "check meetting install result::%s", Boolean.valueOf(iQ));
                z = iQ;
            } else if (epO()) {
                boolean iQ2 = iQ("com.tencent.wework", "011a40266c8c75d181ddd8e4ddc50075");
                Log.i("MicroMsg.MeetingLinkHelper", "check wework install result:%s", Boolean.valueOf(iQ2));
                z = iQ2;
            } else {
                if (epP()) {
                    String epY = epY();
                    i epX = epX();
                    if (epX != null) {
                        str2 = epX.optString("md5");
                    } else {
                        str2 = null;
                    }
                    Log.i("MicroMsg.MeetingLinkHelper", "other app, packageName:%s, md5:%s", epY, str2);
                    if (!Util.isNullOrNil(epY) && !Util.isNullOrNil(str2)) {
                        boolean iQ3 = iQ(epY, str2);
                        Log.i("MicroMsg.MeetingLinkHelper", "check wework install result:%s", Boolean.valueOf(iQ3));
                        z = iQ3;
                    }
                }
                z = false;
            }
            int epW = epW();
            if (!z) {
                String epV = epV();
                if (str.equals("list")) {
                    i2 = 2;
                } else {
                    i2 = 1;
                }
                c.a(epW, 0, 0, 0, i2, 0, 0, 0, 0, epV, 0);
                Log.i("MicroMsg.MeetingLinkHelper", "not installed, jump download url, ");
                String str4 = epV() + str;
                Log.i("MicroMsg.MeetingLinkHelper", "not installed, jump download url:%s", str4);
                Intent intent = new Intent();
                intent.putExtra("rawUrl", str4);
                try {
                    c.b(context, "webview", ".ui.tools.WebViewUI", intent);
                    AppMethodBeat.o(164084);
                    return;
                } catch (Exception e2) {
                    String epV2 = epV();
                    if (str.equals("list")) {
                        i3 = 2;
                    } else {
                        i3 = 1;
                    }
                    c.a(epW, 0, 0, 0, 0, i3, 0, 0, 0, epV2, 0);
                    AppMethodBeat.o(164084);
                    return;
                }
            } else {
                Log.i("MicroMsg.MeetingLinkHelper", "already installed, jump app");
                if (epN()) {
                    if (a(context, "com.tencent.wemeet.app", "wemeet://launch?referer=wechat&from=".concat(String.valueOf(str)), str.equals("list"))) {
                        c.aH(epW, str.equals("list"));
                        AppMethodBeat.o(164084);
                        return;
                    }
                    c.aI(epW, str.equals("list"));
                    AppMethodBeat.o(164084);
                    return;
                } else if (epO()) {
                    if (a(context, "com.tencent.wework", "wxwork://jump?target=jump_to_third_app&businessid=10085&src=wx&scene=".concat(String.valueOf(str)), str.equals("list"))) {
                        c.aH(epW, str.equals("list"));
                        AppMethodBeat.o(164084);
                        return;
                    }
                    c.aI(epW, str.equals("list"));
                    AppMethodBeat.o(164084);
                    return;
                } else if (epP()) {
                    String epY2 = epY();
                    i epX2 = epX();
                    if (epX2 != null) {
                        str3 = epX2.optString("schema");
                    }
                    if (!Util.isNullOrNil(epY2) && !Util.isNullOrNil(str3)) {
                        if (a(context, epY2, str3 + str, str.equals("list"))) {
                            c.aH(epW, str.equals("list"));
                            AppMethodBeat.o(164084);
                            return;
                        }
                        c.aI(epW, str.equals("list"));
                    }
                }
            }
        }
        AppMethodBeat.o(164084);
    }
}
