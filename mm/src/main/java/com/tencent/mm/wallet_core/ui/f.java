package com.tencent.mm.wallet_core.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Build;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.TouchDelegate;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.wq;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bu;
import com.tencent.mm.model.c.d;
import com.tencent.mm.model.cl;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.ui.span.o;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.LruCache;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.e;
import com.tencent.mm.wallet_core.c.ah;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.smtt.sdk.WebView;
import com.tencent.sqlitelint.util.SQLiteLintUtil;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.regex.Pattern;
import org.json.JSONObject;

public final class f {
    private static final String[] Ify = {"ABC_DEBIT", "ABC_CREDIT", "CITIC_CREDIT", "CMBC_DEBIT", "COMM_DEBIT", "HSBC_DEBIT"};
    protected static final Pattern KqP = Pattern.compile("((?:(http|https|Http|Https):\\/\\/(?:(?:[a-zA-Z0-9\\$\\-\\_\\.\\+\\!\\*\\'\\(\\)\\,\\;\\?\\&\\=]|(?:\\%[a-fA-F0-9]{2})){1,64}(?:\\:(?:[a-zA-Z0-9\\$\\-\\_\\.\\+\\!\\*\\'\\(\\)\\,\\;\\?\\&\\=]|(?:\\%[a-fA-F0-9]{2})){1,25})?\\@)?)?((?:(?:[a-zA-Z0-9][a-zA-Z0-9\\-\\_]{0,64}\\.)+(?:(?:aero|arpa|asia|a[cdefgilmnoqrstuwxz])|(?:biz|b[abdefghijmnorstvwyz])|(?:cat|com|coop|c[acdfghiklmnoruvxyz])|d[ejkmoz]|(?:edu|e[cegrstu])|f[ijkmor]|(?:gov|g[abdefghilmnpqrstuwy])|h[kmnrtu]|(?:info|int|i[delmnoqrst])|(?:jobs|j[emop])|k[eghimnrwyz]|l[abcikrstuvy]|(?:mil|mobi|museum|m[acdeghklmnopqrstuvwxyz])|(?:name|net|n[acefgilopruz])|(?:org|om)|(?:pro|p[aefghklmnrstwy])|qa|r[eouw]|s[abcdeghijklmnortuvyz]|(?:tel|travel|t[cdfghjklmnoprtvwz])|u[agkmsyz]|v[aceginu]|w[fs]|y[etu]|z[amw]))|(?:(?:25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9])\\.(?:25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(?:25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(?:25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[0-9])))(?:\\:\\d{1,5})?)(\\/(?:(?:[a-zA-Z0-9\\;\\/\\?\\:\\@\\&\\=\\#\\~\\-\\.\\+\\!\\*\\'\\(\\)\\,\\_])|(?:\\%[a-fA-F0-9]{2}))*)?");
    private static final LruCache<Integer, Typeface> RvB = new LruCache<>(4);
    private static SimpleDateFormat qDM = null;

    public interface a {
        void bb(Map<String, Object> map);
    }

    public interface b {
        void dy(Object obj);
    }

    static /* synthetic */ int bnl(String str) {
        AppMethodBeat.i(73053);
        int bpy = bpy(str);
        AppMethodBeat.o(73053);
        return bpy;
    }

    static {
        AppMethodBeat.i(73054);
        AppMethodBeat.o(73054);
    }

    public static Typeface gA(Context context) {
        AppMethodBeat.i(72989);
        Typeface aS = aS(context, 4);
        AppMethodBeat.o(72989);
        return aS;
    }

    public static Typeface aS(Context context, int i2) {
        AppMethodBeat.i(72991);
        if (i2 == 8) {
            Typeface typeface = Typeface.DEFAULT;
            AppMethodBeat.o(72991);
            return typeface;
        }
        try {
            if (Build.VERSION.SDK_INT > 23) {
                Typeface createFromAsset = Typeface.createFromAsset(context.getAssets(), aqk(i2));
                AppMethodBeat.o(72991);
                return createFromAsset;
            }
            Typeface typeface2 = RvB.get(Integer.valueOf(i2));
            if (typeface2 == null) {
                typeface2 = Typeface.createFromAsset(context.getAssets(), aqk(i2));
                RvB.put(Integer.valueOf(i2), typeface2);
            }
            AppMethodBeat.o(72991);
            return typeface2;
        } catch (Exception e2) {
            Log.e("MicroMsg.WalletBaseUtil ", "getWalletTypeface() Exception:%s %s", e2.getClass().getSimpleName(), e2.getMessage());
            Typeface typeface3 = Typeface.DEFAULT;
            AppMethodBeat.o(72991);
            return typeface3;
        }
    }

    public static String aqk(int i2) {
        switch (i2) {
            case 0:
                return "fonts/WeChatSansSS-Medium.ttf";
            case 1:
                return "fonts/WeChatSansSS-Bold.ttf";
            case 2:
                return "fonts/WeChatSansSS-Light.ttf";
            case 3:
                return "fonts/WeChatSansSS-Regular.ttf";
            case 4:
                return "fonts/WeChatSansStd-Medium.ttf";
            case 5:
                return "fonts/WeChatSansStd-Bold.ttf";
            case 6:
                return "fonts/WeChatSansStd-Light.ttf";
            case 7:
                return "fonts/WeChatSansStd-Regular.ttf";
            default:
                return "fonts/WeChatSansSS-Medium.ttf";
        }
    }

    public static void setNoSystemInputOnEditText(EditText editText) {
        AppMethodBeat.i(72992);
        if (Build.VERSION.SDK_INT < 11) {
            editText.setInputType(0);
            AppMethodBeat.o(72992);
            return;
        }
        try {
            Method method = EditText.class.getMethod("setShowSoftInputOnFocus", Boolean.TYPE);
            method.setAccessible(false);
            method.invoke(editText, Boolean.FALSE);
            AppMethodBeat.o(72992);
        } catch (NoSuchMethodException e2) {
            Log.e("erik", "setShowSoftInputOnFocus exception!");
            try {
                Method method2 = EditText.class.getMethod("setSoftInputShownOnFocus", Boolean.TYPE);
                method2.setAccessible(false);
                method2.invoke(editText, Boolean.FALSE);
                AppMethodBeat.o(72992);
            } catch (Exception e3) {
                editText.setInputType(0);
                Log.printErrStackTrace("MicroMsg.WalletBaseUtil ", e3, "", new Object[0]);
                AppMethodBeat.o(72992);
            }
        } catch (Exception e4) {
            Log.printErrStackTrace("MicroMsg.WalletBaseUtil ", e4, "", new Object[0]);
            AppMethodBeat.o(72992);
        }
    }

    public static void hhT() {
    }

    public static void a(WalletFormView[] walletFormViewArr) {
        AppMethodBeat.i(182534);
        if (walletFormViewArr.length == 0) {
            AppMethodBeat.o(182534);
            return;
        }
        int i2 = 0;
        for (WalletFormView walletFormView : walletFormViewArr) {
            i2 = Math.max(i2, (int) walletFormView.getTitleMeasuredWidth());
        }
        if (i2 > 0) {
            int i3 = i2 + 10;
            Log.i("MicroMsg.WalletBaseUtil ", "adjust max width: %s", Integer.valueOf(i3));
            for (WalletFormView walletFormView2 : walletFormViewArr) {
                walletFormView2.setTitleWidth(i3);
            }
        }
        AppMethodBeat.o(182534);
    }

    public static String d(double d2, String str) {
        AppMethodBeat.i(72993);
        if ("CNY".equals(str)) {
            String format = String.format("¥%.2f", Double.valueOf(d2));
            AppMethodBeat.o(72993);
            return format;
        } else if ("ZAR".equals(str)) {
            String format2 = String.format("R%.2f", Double.valueOf(d2));
            AppMethodBeat.o(72993);
            return format2;
        } else if ("1".equals(str) || Util.isNullOrNil(str)) {
            String format3 = String.format(ah.hhz() + "%.2f", Double.valueOf(d2));
            AppMethodBeat.o(72993);
            return format3;
        } else {
            String format4 = String.format(str + "%.2f", Double.valueOf(d2));
            AppMethodBeat.o(72993);
            return format4;
        }
    }

    public static String bpp(String str) {
        AppMethodBeat.i(72994);
        if ("CNY".equals(str)) {
            AppMethodBeat.o(72994);
            return "¥";
        } else if ("ZAR".equals(str)) {
            AppMethodBeat.o(72994);
            return "R";
        } else if ("1".equals(str) || Util.isNullOrNil(str)) {
            String hhz = ah.hhz();
            AppMethodBeat.o(72994);
            return hhz;
        } else {
            AppMethodBeat.o(72994);
            return str;
        }
    }

    public static String D(double d2) {
        AppMethodBeat.i(72995);
        String d3 = d(d2, "");
        AppMethodBeat.o(72995);
        return d3;
    }

    public static String formatMoney2f(double d2) {
        AppMethodBeat.i(72996);
        String format = String.format("%.2f", Double.valueOf(d2));
        AppMethodBeat.o(72996);
        return format;
    }

    public static String bpq(String str) {
        AppMethodBeat.i(72997);
        if ("CNY".equals(str) || "1".equals(str) || Util.isNullOrNil(str)) {
            AppMethodBeat.o(72997);
            return "¥";
        }
        AppMethodBeat.o(72997);
        return str;
    }

    public static String rZ(int i2) {
        AppMethodBeat.i(72998);
        if (qDM == null) {
            qDM = new SimpleDateFormat(SQLiteLintUtil.YYYY_MM_DD_HH_mm);
        }
        String format = qDM.format(new Date(((long) i2) * 1000));
        AppMethodBeat.o(72998);
        return format;
    }

    public static String aql(int i2) {
        AppMethodBeat.i(72999);
        String a2 = a(i2, new SimpleDateFormat("MM-dd HH:mm"), new SimpleDateFormat(SQLiteLintUtil.YYYY_MM_DD_HH_mm));
        AppMethodBeat.o(72999);
        return a2;
    }

    public static String a(int i2, SimpleDateFormat simpleDateFormat, SimpleDateFormat simpleDateFormat2) {
        AppMethodBeat.i(73000);
        long j2 = ((long) i2) * 1000;
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        GregorianCalendar gregorianCalendar2 = new GregorianCalendar();
        gregorianCalendar2.setTimeInMillis(j2);
        if (gregorianCalendar.get(1) == gregorianCalendar2.get(1)) {
            String format = simpleDateFormat.format(new Date(j2));
            AppMethodBeat.o(73000);
            return format;
        }
        String format2 = simpleDateFormat2.format(new Date(j2));
        AppMethodBeat.o(73000);
        return format2;
    }

    public static void an(Context context, String str) {
        AppMethodBeat.i(73001);
        if (TextUtils.isEmpty(str)) {
            Log.v("MicroMsg.WalletBaseUtil ", "username is null");
            AppMethodBeat.o(73001);
        } else if (ab.IS(str)) {
            ao(context, str);
            AppMethodBeat.o(73001);
        } else {
            am(context, str);
            AppMethodBeat.o(73001);
        }
    }

    public static void aA(Context context, Intent intent) {
        AppMethodBeat.i(182535);
        Intent intent2 = new Intent();
        intent2.putExtras(intent);
        intent2.putExtra("allow_mix_content_mode", false);
        com.tencent.mm.br.c.b(context, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent2);
        AppMethodBeat.o(182535);
    }

    public static void b(Context context, Intent intent, int i2) {
        AppMethodBeat.i(182536);
        Intent intent2 = new Intent();
        intent2.putExtras(intent);
        intent2.putExtra("allow_mix_content_mode", false);
        com.tencent.mm.br.c.b(context, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent2, i2);
        AppMethodBeat.o(182536);
    }

    public static void o(Context context, String str, boolean z) {
        AppMethodBeat.i(162283);
        Intent intent = new Intent();
        intent.putExtra("rawUrl", str);
        intent.putExtra("showShare", z);
        intent.putExtra(e.p.OzJ, true);
        intent.putExtra("allow_mix_content_mode", false);
        com.tencent.mm.br.c.b(context, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
        AppMethodBeat.o(162283);
    }

    public static void p(Context context, String str, boolean z) {
        AppMethodBeat.i(73002);
        Intent intent = new Intent();
        intent.putExtra("rawUrl", str);
        intent.putExtra("showShare", z);
        intent.putExtra("allow_mix_content_mode", false);
        com.tencent.mm.br.c.b(context, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
        AppMethodBeat.o(73002);
    }

    public static void bn(Context context, String str) {
        AppMethodBeat.i(182537);
        p(context, str, true);
        AppMethodBeat.o(182537);
    }

    public static void a(Context context, String str, boolean z, int i2) {
        AppMethodBeat.i(73003);
        Intent intent = new Intent();
        intent.putExtra("rawUrl", str);
        intent.putExtra("showShare", z);
        intent.putExtra("allow_mix_content_mode", false);
        com.tencent.mm.br.c.b(context, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent, i2);
        AppMethodBeat.o(73003);
    }

    public static void cL(Context context, String str) {
        AppMethodBeat.i(163888);
        if (TextUtils.isEmpty(str)) {
            Log.v("MicroMsg.WalletBaseUtil ", "username is null");
            AppMethodBeat.o(163888);
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("Contact_User", str);
        intent.putExtra("force_get_contact", true);
        com.tencent.mm.br.c.b(context, Scopes.PROFILE, ".ui.ContactInfoUI", intent, 2);
        AppMethodBeat.o(163888);
    }

    public static void am(Context context, String str) {
        AppMethodBeat.i(73004);
        if (TextUtils.isEmpty(str)) {
            Log.v("MicroMsg.WalletBaseUtil ", "username is null");
            AppMethodBeat.o(73004);
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("Contact_User", str);
        intent.putExtra("force_get_contact", true);
        com.tencent.mm.br.c.b(context, Scopes.PROFILE, ".ui.ContactInfoUI", intent);
        AppMethodBeat.o(73004);
    }

    public static void kR(Context context) {
        AppMethodBeat.i(73005);
        if (context == null) {
            Log.e("MicroMsg.WalletBaseUtil ", "hy: jump to preference error. context is null");
            AppMethodBeat.o(73005);
            return;
        }
        Intent intent = new Intent();
        intent.addFlags(67108864);
        intent.putExtra("preferred_tab", 3);
        com.tencent.mm.br.c.f(context, "com.tencent.mm.ui.LauncherUI", intent);
        AppMethodBeat.o(73005);
    }

    public static void ao(Context context, String str) {
        AppMethodBeat.i(73006);
        if (TextUtils.isEmpty(str)) {
            Log.v("MicroMsg.WalletBaseUtil ", "username is null");
            AppMethodBeat.o(73006);
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("Chat_User", str);
        intent.putExtra("finish_direct", true);
        com.tencent.mm.br.c.f(context, ".ui.chatting.ChattingUI", intent);
        AppMethodBeat.o(73006);
    }

    public static boolean bpr(String str) {
        AppMethodBeat.i(73007);
        if (!KqP.matcher(str).matches()) {
            AppMethodBeat.o(73007);
            return false;
        }
        AppMethodBeat.o(73007);
        return true;
    }

    public static String bps(String str) {
        AppMethodBeat.i(73008);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(73008);
            return str;
        }
        String str2 = "";
        for (int i2 = 0; i2 < str.length() - 1; i2++) {
            str2 = str2 + "*";
        }
        String str3 = str2 + str.substring(str.length() - 1, str.length());
        AppMethodBeat.o(73008);
        return str3;
    }

    public static boolean q(JSONObject jSONObject, String str) {
        AppMethodBeat.i(73009);
        boolean equals = "1".equals(jSONObject.optString(str, AppEventsConstants.EVENT_PARAM_VALUE_NO));
        AppMethodBeat.o(73009);
        return equals;
    }

    public static String getUsername() {
        AppMethodBeat.i(73010);
        g.aAf().azk();
        String aTY = z.aTY();
        AppMethodBeat.o(73010);
        return aTY;
    }

    public static String bpt(String str) {
        AppMethodBeat.i(73011);
        if (str == null || str.length() <= 8) {
            AppMethodBeat.o(73011);
            return str;
        }
        int length = str.length();
        String str2 = str.substring(0, length - 8) + "****" + str.substring(length - 4);
        AppMethodBeat.o(73011);
        return str2;
    }

    public static String bpu(String str) {
        AppMethodBeat.i(73012);
        if (str == null || str.length() <= 0) {
            AppMethodBeat.o(73012);
            return "";
        }
        String substring = str.substring(1, str.length());
        Log.d("MicroMsg.WalletBaseUtil ", "tail : ".concat(String.valueOf(substring)));
        String substring2 = str.substring(0, 1);
        Log.d("MicroMsg.WalletBaseUtil ", "head : ".concat(String.valueOf(substring2)));
        Log.d("MicroMsg.WalletBaseUtil ", "after : ".concat(String.valueOf(substring2)));
        String concat = "*".concat(String.valueOf(substring));
        AppMethodBeat.o(73012);
        return concat;
    }

    public static String bpv(String str) {
        AppMethodBeat.i(73013);
        if (str == null || str.length() < 2) {
            String bpu = bpu(str);
            AppMethodBeat.o(73013);
            return bpu;
        }
        String concat = "**".concat(String.valueOf(str.substring(str.length() - 1, str.length())));
        AppMethodBeat.o(73013);
        return concat;
    }

    public static void b(final Context context, final String str, String str2, boolean z, boolean z2) {
        AppMethodBeat.i(73014);
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        linkedList.add(context.getString(R.string.i8v));
        linkedList2.add(0);
        if (str != null && z2) {
            linkedList.add(context.getString(R.string.i8t));
            linkedList2.add(1);
        }
        if (z && !Util.isNullOrNil(str2)) {
            linkedList.add(context.getString(R.string.i8w, str2));
            linkedList2.add(2);
            linkedList.add(context.getString(R.string.i8x, str2));
            linkedList2.add(3);
        }
        h.a(context, "", linkedList, linkedList2, "", new h.e() {
            /* class com.tencent.mm.wallet_core.ui.f.AnonymousClass1 */

            @Override // com.tencent.mm.ui.base.h.e
            public final void cy(int i2, int i3) {
                AppMethodBeat.i(72981);
                Intent intent = new Intent();
                switch (i2) {
                    case 0:
                        intent.putExtra("rawUrl", context.getString(R.string.i5i, LocaleUtil.getApplicationLanguage()));
                        break;
                    case 1:
                        if (str != null) {
                            intent.putExtra("rawUrl", context.getString(R.string.i5g, LocaleUtil.getApplicationLanguage(), str));
                            break;
                        }
                        break;
                    case 2:
                        if (str != null) {
                            intent.putExtra("rawUrl", context.getString(R.string.i5j, LocaleUtil.getApplicationLanguage(), str));
                            break;
                        }
                        break;
                    case 3:
                        if (str != null) {
                            intent.putExtra("rawUrl", context.getString(R.string.i5k, LocaleUtil.getApplicationLanguage(), str));
                            break;
                        }
                        break;
                }
                intent.putExtra("showShare", false);
                intent.putExtra("allow_mix_content_mode", false);
                com.tencent.mm.br.c.b(context, "webview", ".ui.tools.WebViewUI", intent);
                AppMethodBeat.o(72981);
            }
        });
        AppMethodBeat.o(73014);
    }

    public static void d(MMActivity mMActivity, String str) {
        AppMethodBeat.i(73015);
        Intent intent = new Intent();
        intent.putExtra("BaseScanUI_select_scan_mode", 7);
        intent.putExtra("bank_card_owner", str);
        com.tencent.mm.br.c.b(mMActivity, "scanner", ".ui.ScanCardUI", intent);
        AppMethodBeat.o(73015);
    }

    public static String getDisplayName(String str) {
        String str2;
        AppMethodBeat.i(73016);
        g.aAi();
        as bjK = ((l) g.af(l.class)).aSN().bjK(str);
        if (bjK != null) {
            str2 = bjK.arJ();
        } else {
            str2 = null;
        }
        if (!Util.isNullOrNil(str2)) {
            str = str2;
        }
        AppMethodBeat.o(73016);
        return str;
    }

    public static void cM(Context context, String str) {
        AppMethodBeat.i(73017);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(73017);
            return;
        }
        Intent intent = new Intent("android.intent.action.DIAL", Uri.parse(WebView.SCHEME_TEL.concat(String.valueOf(str))));
        intent.addFlags(268435456);
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/wallet_core/ui/WalletBaseUtil", "dial", "(Landroid/content/Context;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        context.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/wallet_core/ui/WalletBaseUtil", "dial", "(Landroid/content/Context;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(73017);
    }

    public static long E(double d2) {
        AppMethodBeat.i(73018);
        long round = Math.round(100.0d * d2);
        AppMethodBeat.o(73018);
        return round;
    }

    public static void a(final c... cVarArr) {
        AppMethodBeat.i(73019);
        g.aAi();
        g.aAg().hqi.a(new bu(new bu.a() {
            /* class com.tencent.mm.wallet_core.ui.f.AnonymousClass3 */

            @Override // com.tencent.mm.model.bu.a
            public final void a(com.tencent.mm.network.g gVar) {
                AppMethodBeat.i(72983);
                if (gVar == null || gVar.aZh() == null) {
                    AppMethodBeat.o(72983);
                } else if (cVarArr == null || cVarArr.length == 0) {
                    Log.w("MicroMsg.WalletBaseUtil ", "hy: kvs is null or length is 0");
                    AppMethodBeat.o(72983);
                } else {
                    try {
                        c[] cVarArr = cVarArr;
                        for (c cVar : cVarArr) {
                            if (cVar != null && !Util.isNullOrNil(cVar.key)) {
                                gVar.aZh().i(cVar.key, f.ex(cVar.val));
                            }
                        }
                        AppMethodBeat.o(72983);
                    } catch (Exception e2) {
                        Log.e("MicroMsg.WalletBaseUtil ", "hy: serialize failed: %s", e2.toString());
                        AppMethodBeat.o(72983);
                    }
                }
            }
        }), 0);
        AppMethodBeat.o(73019);
    }

    public static void a(final String str, final b bVar) {
        AppMethodBeat.i(73020);
        g.aAi();
        g.aAg().hqi.a(new bu(new bu.a() {
            /* class com.tencent.mm.wallet_core.ui.f.AnonymousClass4 */

            @Override // com.tencent.mm.model.bu.a
            public final void a(com.tencent.mm.network.g gVar) {
                AppMethodBeat.i(72984);
                if (gVar == null || gVar.aZh() == null) {
                    AppMethodBeat.o(72984);
                } else if (Util.isNullOrNil(str)) {
                    Log.w("MicroMsg.WalletBaseUtil ", "hy: key is null");
                    AppMethodBeat.o(72984);
                } else {
                    try {
                        byte[] MC = gVar.aZh().MC(str);
                        if (bVar != null) {
                            if (MC != null) {
                                bVar.dy(f.cN(MC));
                                AppMethodBeat.o(72984);
                                return;
                            }
                            bVar.dy(null);
                        }
                        AppMethodBeat.o(72984);
                    } catch (Exception e2) {
                        Log.e("MicroMsg.WalletBaseUtil ", "hy: deserialize failed: %s", e2.toString());
                        if (bVar != null) {
                            bVar.dy(null);
                        }
                        AppMethodBeat.o(72984);
                    }
                }
            }
        }), 0);
        AppMethodBeat.o(73020);
    }

    public static void hhU() {
        AppMethodBeat.i(73021);
        g.aAi();
        g.aAg().hqi.a(new bu(new bu.a() {
            /* class com.tencent.mm.wallet_core.ui.f.AnonymousClass5 */

            @Override // com.tencent.mm.model.bu.a
            public final void a(com.tencent.mm.network.g gVar) {
                AppMethodBeat.i(72985);
                gVar.aZj();
                AppMethodBeat.o(72985);
            }
        }), 0);
        AppMethodBeat.o(73021);
    }

    public static String bpx(String str) {
        AppMethodBeat.i(73023);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(73023);
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int length = str.length() / 4;
        for (int i2 = 0; i2 < length; i2++) {
            int min = Math.min((i2 + 1) * 4, str.length());
            if (min + 4 > str.length()) {
                min = str.length();
            }
            sb.append(nD(str.substring(i2 * 4, min), " "));
            if (min - (i2 * 4) == 4) {
                for (int i3 = 0; i3 < 6; i3++) {
                    sb.append(" ");
                }
            }
        }
        String sb2 = sb.toString();
        AppMethodBeat.o(73023);
        return sb2;
    }

    public static void bu(ArrayList<Bitmap> arrayList) {
        AppMethodBeat.i(73024);
        if (arrayList != null && arrayList.size() > 0) {
            for (int size = arrayList.size() - 1; size > 0; size--) {
                Z(arrayList.remove(size));
            }
        }
        AppMethodBeat.o(73024);
    }

    public static void Z(Bitmap bitmap) {
        AppMethodBeat.i(73025);
        if (bitmap != null && !bitmap.isRecycled()) {
            bitmap.recycle();
        }
        AppMethodBeat.o(73025);
    }

    public static Bitmap Y(Bitmap bitmap) {
        boolean z = true;
        AppMethodBeat.i(73026);
        Matrix matrix = new Matrix();
        matrix.reset();
        matrix.setRotate(90.0f, (float) (bitmap.getWidth() / 2), (float) (bitmap.getHeight() / 2));
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        StringBuilder sb = new StringBuilder("resultBmp is null: ");
        if (createBitmap != null) {
            z = false;
        }
        Log.d("MicroMsg.WalletBaseUtil ", sb.append(z).append("  degree:90.0").toString());
        AppMethodBeat.o(73026);
        return createBitmap;
    }

    private static String nD(String str, String str2) {
        AppMethodBeat.i(73027);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(73027);
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < str.length(); i2++) {
            sb.append(str.substring(i2, i2 + 1));
            if (i2 != str.length() - 1) {
                sb.append(str2);
            }
        }
        String sb2 = sb.toString();
        AppMethodBeat.o(73027);
        return sb2;
    }

    public static void cO(Context context, String str) {
        AppMethodBeat.i(162284);
        Intent intent = new Intent();
        intent.putExtra("rawUrl", str);
        intent.putExtra("showShare", false);
        intent.putExtra("pay_channel", 1);
        intent.putExtra(e.p.OzJ, true);
        com.tencent.mm.br.c.b(context, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
        AppMethodBeat.o(162284);
    }

    public static void a(final String[] strArr, final a aVar) {
        AppMethodBeat.i(73029);
        g.aAi();
        g.aAg().hqi.a(new bu(new bu.a() {
            /* class com.tencent.mm.wallet_core.ui.f.AnonymousClass6 */

            @Override // com.tencent.mm.model.bu.a
            public final void a(com.tencent.mm.network.g gVar) {
                AppMethodBeat.i(72986);
                if (gVar == null || gVar.aZh() == null) {
                    AppMethodBeat.o(72986);
                } else if (strArr == null || strArr.length == 0) {
                    Log.w("MicroMsg.WalletBaseUtil ", "hy: keys is null");
                    AppMethodBeat.o(72986);
                } else {
                    HashMap hashMap = new HashMap();
                    for (int i2 = 0; i2 < strArr.length; i2++) {
                        try {
                            String str = strArr[i2];
                            if (!Util.isNullOrNil(str)) {
                                byte[] MC = gVar.aZh().MC(str);
                                if (MC != null) {
                                    hashMap.put(str, f.cN(MC));
                                }
                            } else {
                                Log.e("MicroMsg.WalletBaseUtil ", "hy: key is null");
                            }
                        } catch (Exception e2) {
                            Log.e("MicroMsg.WalletBaseUtil ", "hy: deserialize failed: %s", e2.toString());
                            if (aVar != null) {
                                aVar.bb(null);
                            }
                            AppMethodBeat.o(72986);
                            return;
                        }
                    }
                    if (aVar != null) {
                        aVar.bb(hashMap);
                    }
                    AppMethodBeat.o(72986);
                }
            }
        }), 0);
        AppMethodBeat.o(73029);
    }

    public static class c {
        public String key = null;
        public Object val = null;

        public c() {
        }

        public c(String str, Object obj) {
            this.key = str;
            this.val = obj;
        }
    }

    public static void aqm(int i2) {
        AppMethodBeat.i(73030);
        com.tencent.mm.plugin.report.service.h.INSTANCE.a(12719, Integer.valueOf(i2), 1);
        AppMethodBeat.o(73030);
    }

    public static void a(final TextView textView, final String str, String str2, final String str3) {
        AppMethodBeat.i(73031);
        if (textView == null) {
            Log.e("MicroMsg.WalletBaseUtil ", "hy: text view is null.");
            AppMethodBeat.o(73031);
        } else if (Util.isNullOrNil(str2)) {
            Log.w("MicroMsg.WalletBaseUtil ", "hy: msg is null. set text view to gone");
            textView.setVisibility(8);
            AppMethodBeat.o(73031);
        } else {
            textView.setVisibility(0);
            textView.setText(str2);
            com.tencent.mm.protocal.g.gH(bpy(str), 0);
            if (!Util.isNullOrNil(str3)) {
                textView.setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.wallet_core.ui.f.AnonymousClass7 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(72987);
                        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/wallet_core/ui/WalletBaseUtil$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        Log.i("MicroMsg.WalletBaseUtil ", "hy: on click banner");
                        Intent intent = new Intent();
                        intent.putExtra("rawUrl", str3);
                        intent.putExtra("showShare", true);
                        com.tencent.mm.br.c.b(textView.getContext(), "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
                        com.tencent.mm.protocal.g.gH(f.bnl(str), 1);
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/wallet_core/ui/WalletBaseUtil$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(72987);
                    }
                });
            }
            AppMethodBeat.o(73031);
        }
    }

    private static int bpy(String str) {
        AppMethodBeat.i(73032);
        if ("1".equals(str)) {
            AppMethodBeat.o(73032);
            return 0;
        } else if ("2".equals(str)) {
            AppMethodBeat.o(73032);
            return 4;
        } else if (TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL.equals(str)) {
            AppMethodBeat.o(73032);
            return 12;
        } else if ("4".equals(str)) {
            AppMethodBeat.o(73032);
            return 2;
        } else if ("5".equals(str)) {
            AppMethodBeat.o(73032);
            return 8;
        } else if ("6".equals(str)) {
            AppMethodBeat.o(73032);
            return 14;
        } else if ("7".equals(str)) {
            AppMethodBeat.o(73032);
            return 16;
        } else if ("8".equals(str)) {
            AppMethodBeat.o(73032);
            return 10;
        } else {
            AppMethodBeat.o(73032);
            return -1;
        }
    }

    public static void d(int i2, long j2, int i3) {
        AppMethodBeat.i(73033);
        com.tencent.mm.plugin.report.service.h.INSTANCE.a(13375, Integer.valueOf(i2), 1, Long.valueOf(j2), Integer.valueOf(i3));
        AppMethodBeat.o(73033);
    }

    public static String bpz(String str) {
        AppMethodBeat.i(73034);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(73034);
            return str;
        } else if (str.length() > 14) {
            String str2 = str.substring(0, 14) + "...";
            AppMethodBeat.o(73034);
            return str2;
        } else {
            AppMethodBeat.o(73034);
            return str;
        }
    }

    public static String hs(String str, int i2) {
        AppMethodBeat.i(73035);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(73035);
            return str;
        } else if (str.length() > i2) {
            String str2 = str.substring(0, i2) + "...";
            AppMethodBeat.o(73035);
            return str2;
        } else {
            AppMethodBeat.o(73035);
            return str;
        }
    }

    public static String ht(String str, int i2) {
        AppMethodBeat.i(73036);
        String hs = hs(getDisplayName(str), i2);
        AppMethodBeat.o(73036);
        return hs;
    }

    public static void i(TextView textView, String str) {
        AppMethodBeat.i(73037);
        textView.setText(com.tencent.mm.pluginsdk.ui.span.l.b(textView.getContext(), ht(str, 10), textView.getTextSize()));
        AppMethodBeat.o(73037);
    }

    public static long a(String str, String str2, RoundingMode roundingMode) {
        AppMethodBeat.i(73038);
        long longValue = b(str, str2, 0, roundingMode).longValue();
        AppMethodBeat.o(73038);
        return longValue;
    }

    public static double a(String str, String str2, int i2, RoundingMode roundingMode) {
        AppMethodBeat.i(214340);
        double doubleValue = b(str, str2, i2, roundingMode).doubleValue();
        AppMethodBeat.o(214340);
        return doubleValue;
    }

    public static BigDecimal b(String str, String str2, int i2, RoundingMode roundingMode) {
        AppMethodBeat.i(73040);
        try {
            BigDecimal divide = new BigDecimal(Util.getDouble(str, 0.0d) == 0.0d ? AppEventsConstants.EVENT_PARAM_VALUE_NO : str.trim()).divide(new BigDecimal(str2.trim()), i2, roundingMode);
            AppMethodBeat.o(73040);
            return divide;
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.WalletBaseUtil ", e2, "", new Object[0]);
            BigDecimal bigDecimal = new BigDecimal(0);
            AppMethodBeat.o(73040);
            return bigDecimal;
        }
    }

    public static double b(String str, String str2, RoundingMode roundingMode) {
        AppMethodBeat.i(73041);
        double doubleValue = c(str, str2, 2, roundingMode).doubleValue();
        AppMethodBeat.o(73041);
        return doubleValue;
    }

    public static int nE(String str, String str2) {
        AppMethodBeat.i(73042);
        int intValue = c(str, str2, 0, RoundingMode.HALF_UP).intValue();
        AppMethodBeat.o(73042);
        return intValue;
    }

    public static long nF(String str, String str2) {
        AppMethodBeat.i(73043);
        long longValue = c(str, str2, 0, RoundingMode.HALF_UP).longValue();
        AppMethodBeat.o(73043);
        return longValue;
    }

    public static BigDecimal c(String str, String str2, int i2, RoundingMode roundingMode) {
        AppMethodBeat.i(73044);
        try {
            BigDecimal scale = new BigDecimal(Util.getDouble(str, 0.0d) == 0.0d ? AppEventsConstants.EVENT_PARAM_VALUE_NO : str.trim()).multiply(new BigDecimal(Util.getDouble(str2, 0.0d) == 0.0d ? AppEventsConstants.EVENT_PARAM_VALUE_NO : str2.trim())).setScale(i2, roundingMode);
            AppMethodBeat.o(73044);
            return scale;
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.WalletBaseUtil ", e2, "", new Object[0]);
            BigDecimal bigDecimal = new BigDecimal(0);
            AppMethodBeat.o(73044);
            return bigDecimal;
        }
    }

    public static void aZ(final View view, final int i2) {
        AppMethodBeat.i(73045);
        final View view2 = (View) view.getParent();
        view2.post(new Runnable() {
            /* class com.tencent.mm.wallet_core.ui.f.AnonymousClass8 */

            public final void run() {
                AppMethodBeat.i(72988);
                Rect rect = new Rect();
                view.getHitRect(rect);
                rect.top -= i2;
                rect.bottom += i2;
                rect.left -= i2;
                rect.right += i2;
                view2.setTouchDelegate(new TouchDelegate(rect, view));
                AppMethodBeat.o(72988);
            }
        });
        AppMethodBeat.o(73045);
    }

    public static int bpA(String str) {
        int i2;
        AppMethodBeat.i(73046);
        if (Util.isNullOrNil(str) || str.length() < 2) {
            Log.w("MicroMsg.WalletBaseUtil ", "illegal reqkey: %s", str);
            AppMethodBeat.o(73046);
            return 0;
        }
        com.tencent.mm.storage.c Fu = d.aXu().Fu("100456");
        if (!Fu.isValid()) {
            Log.w("MicroMsg.WalletBaseUtil ", "invalid abtest value");
            AppMethodBeat.o(73046);
            return 0;
        } else if (Util.getInt(Fu.gzz().get(WeChatBrands.Business.GROUP_OPEN), 0) == 0) {
            Log.i("MicroMsg.WalletBaseUtil ", "abtest unopened");
            AppMethodBeat.o(73046);
            return 0;
        } else {
            if (str.startsWith("ts_wx") || str.startsWith("offline_wx") || str.startsWith("up_wx") || str.startsWith("wx")) {
                i2 = Util.getInt(str.substring(str.length() - 2), 0);
            } else {
                i2 = 0;
            }
            Log.d("MicroMsg.WalletBaseUtil ", "parse group id: %s, reqKey: %s", Integer.valueOf(i2), str);
            AppMethodBeat.o(73046);
            return i2;
        }
    }

    public static void bpB(String str) {
        AppMethodBeat.i(73047);
        if (Util.isNullOrNil(str)) {
            str = MMApplicationContext.getContext().getString(R.string.itf);
        }
        Toast.makeText(MMApplicationContext.getContext(), str, 1).show();
        AppMethodBeat.o(73047);
    }

    public static void cP(Context context, String str) {
        AppMethodBeat.i(73048);
        if (Util.isNullOrNil(str)) {
            str = MMApplicationContext.getContext().getString(R.string.itf);
        }
        h.d(context, str, "", new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.wallet_core.ui.f.AnonymousClass9 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
            }
        });
        AppMethodBeat.o(73048);
    }

    public static void ar(final Context context, String str) {
        AppMethodBeat.i(73049);
        AnonymousClass2 r0 = new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.wallet_core.ui.f.AnonymousClass2 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(72982);
                if (context instanceof Activity) {
                    ((Activity) context).finish();
                }
                AppMethodBeat.o(72982);
            }
        };
        if (Util.isNullOrNil(str)) {
            str = MMApplicationContext.getContext().getString(R.string.itf);
        }
        h.d(context, str, "", r0);
        AppMethodBeat.o(73049);
    }

    public static void u(String str, String str2, int i2, int i3) {
        AppMethodBeat.i(73050);
        wq wqVar = new wq();
        wqVar.ecI.userName = str;
        wqVar.ecI.ecK = Util.nullAs(str2, "");
        wqVar.ecI.appVersion = i2;
        wqVar.ecI.scene = i3;
        wqVar.ecI.ecL = 0;
        EventCenter.instance.publish(wqVar);
        AppMethodBeat.o(73050);
    }

    public static String hhV() {
        long aWy;
        AppMethodBeat.i(162285);
        if (((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_use_safe_time, 0) == 0) {
            aWy = cl.aWA();
        } else {
            aWy = cl.aWy();
        }
        String l = Long.toString(aWy / 1000);
        AppMethodBeat.o(162285);
        return l;
    }

    public static void a(TextView textView, String str, int i2, int i3, e eVar, Context context) {
        AppMethodBeat.i(214341);
        textView.setClickable(true);
        textView.setOnTouchListener(new o(context));
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(com.tencent.mm.pluginsdk.ui.span.l.c(context, str));
        spannableStringBuilder.setSpan(eVar, i2, i3, 18);
        textView.setText(spannableStringBuilder);
        AppMethodBeat.o(214341);
    }

    public static void G(TextView textView) {
        AppMethodBeat.i(214342);
        ao.a(textView.getPaint(), 0.8f);
        AppMethodBeat.o(214342);
    }

    public static Typeface cK(Context context, String str) {
        int i2 = 0;
        AppMethodBeat.i(72990);
        char c2 = 65535;
        switch (str.hashCode()) {
            case 1865844108:
                if (str.equals("sans_ss")) {
                    c2 = 0;
                    break;
                }
                break;
            case 2006592631:
                if (str.equals("sans_std")) {
                    c2 = 1;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                break;
            case 1:
                i2 = 4;
                break;
            default:
                i2 = 8;
                break;
        }
        Typeface aS = aS(context, i2);
        AppMethodBeat.o(72990);
        return aS;
    }

    public static String bpw(String str) {
        AppMethodBeat.i(73022);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(73022);
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int length = str.length() / 4;
        for (int i2 = 0; i2 < length + 1; i2++) {
            int min = Math.min((i2 + 1) * 4, str.length());
            sb.append(nD(str.substring(i2 * 4, min), ""));
            if (min - (i2 * 4) == 4) {
                for (int i3 = 0; i3 < 4; i3++) {
                    sb.append(" ");
                }
            }
        }
        String sb2 = sb.toString();
        AppMethodBeat.o(73022);
        return sb2;
    }

    public static void cN(Context context, String str) {
        AppMethodBeat.i(73028);
        Intent intent = new Intent();
        intent.putExtra("rawUrl", str);
        intent.putExtra("showShare", false);
        intent.putExtra("pay_channel", 1);
        com.tencent.mm.br.c.b(context, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
        AppMethodBeat.o(73028);
    }

    static /* synthetic */ byte[] ex(Object obj) {
        AppMethodBeat.i(73051);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        new ObjectOutputStream(byteArrayOutputStream).writeObject(obj);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        AppMethodBeat.o(73051);
        return byteArray;
    }

    static /* synthetic */ Object cN(byte[] bArr) {
        AppMethodBeat.i(73052);
        Object readObject = new ObjectInputStream(new ByteArrayInputStream(bArr)).readObject();
        AppMethodBeat.o(73052);
        return readObject;
    }
}
