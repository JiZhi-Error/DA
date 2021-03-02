package com.tencent.mm.plugin.base.stub;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.Signature;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.ServerProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.aa;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.app.o;
import com.tencent.mm.b.g;
import com.tencent.mm.br.c;
import com.tencent.mm.g.a.cr;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.bg;
import com.tencent.mm.modelsimple.ac;
import com.tencent.mm.opensdk.channel.MMessageActV2;
import com.tencent.mm.opensdk.modelbiz.WXLaunchWxaRedirectingPage;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.launching.b.a.a;
import com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.jsapi.h;
import com.tencent.mm.plugin.appbrand.service.z;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.pluginsdk.ui.tools.n;
import com.tencent.mm.protocal.protobuf.eg;
import com.tencent.mm.protocal.protobuf.ekp;
import com.tencent.mm.protocal.protobuf.ekq;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.mm.vending.g.d;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public final class f {
    private static o.a appForegroundListener = null;
    private static Map<String, e> pdU = new HashMap();
    private static Intent pdV;
    public static final Set<Long> pdW = new HashSet();
    private static int pdX = -1;
    private static boolean pdY = false;
    private static long pdZ = 0;
    private static boolean pea = true;
    private static final String[] peb = {"sdk_openAppProfile", "sdk_openFeedback", "sdk_openGrowthCare", h.NAME};

    public static void a(final Activity activity, Uri uri, int i2, String str, String str2, final Runnable runnable) {
        AppMethodBeat.i(22231);
        Log.d("MicroMsg.WXBizLogic", "dealWithHandleScanResult: callPackage=%s, packageSignature=%s", str, str2);
        if (Util.isNullOrNil(str) || Util.isNullOrNil(str2)) {
            Log.e("MicroMsg.WXBizLogic", "dealWithHandleScanResult:packageName or signature null");
            AppMethodBeat.o(22231);
            return;
        }
        LinkedList linkedList = new LinkedList();
        eg egVar = new eg();
        Log.i("MicroMsg.WXBizLogic", "dealWithHandleScanResult package name = %s", str);
        egVar.qGp = str;
        egVar.signature = str2;
        linkedList.add(egVar);
        ac acVar = new ac(uri.toString(), i2, linkedList);
        bg.azz().a(1200, new i() {
            /* class com.tencent.mm.plugin.base.stub.f.AnonymousClass1 */

            @Override // com.tencent.mm.ak.i
            public final void onSceneEnd(int i2, int i3, String str, q qVar) {
                AppMethodBeat.i(22227);
                bg.azz().b(1200, this);
                Log.i("MicroMsg.WXBizLogic", "dealWithHandleScanResult translateLink: errType = %d; errCode = %d; errMsg = %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
                if (i2 == 0 && i3 == 0) {
                    String bfC = ((ac) qVar).bfC();
                    Log.i("MicroMsg.WXBizLogic", "dealWithHandleScanResult respUriStr=%s", bfC);
                    try {
                        Uri parse = Uri.parse(bfC);
                        if (parse == null) {
                            Log.e("MicroMsg.WXBizLogic", "dealWithHandleScanResult: respUri null");
                            f.L(activity);
                            AppMethodBeat.o(22227);
                            return;
                        }
                        String queryParameter = parse.getQueryParameter("result");
                        if (queryParameter != null) {
                            String decode = URLDecoder.decode(queryParameter);
                            Log.d("MicroMsg.WXBizLogic", "dealWithHandleScanResult: result=%s", decode);
                            cr crVar = new cr();
                            crVar.dFK.activity = activity;
                            crVar.dFK.dDX = decode;
                            crVar.dFK.dFL = 19;
                            crVar.dFK.from = 3;
                            crVar.dFK.dFN = parse.getQueryParameter("appid");
                            crVar.dFK.dFP = activity.getIntent().getBundleExtra("_stat_obj");
                            EventCenter.instance.publish(crVar);
                            if (runnable != null) {
                                runnable.run();
                            }
                            MMHandlerThread.postToMainThreadDelayed(new Runnable() {
                                /* class com.tencent.mm.plugin.base.stub.f.AnonymousClass1.AnonymousClass1 */

                                public final void run() {
                                    AppMethodBeat.i(22226);
                                    activity.finish();
                                    AppMethodBeat.o(22226);
                                }
                            }, 100);
                        }
                        AppMethodBeat.o(22227);
                    } catch (Exception e2) {
                        Log.e("MicroMsg.WXBizLogic", "dealWithHandleScanResult: respUri parse exp=%s", e2);
                        f.L(activity);
                        AppMethodBeat.o(22227);
                    }
                } else {
                    Log.i("MicroMsg.WXBizLogic", "dealWithHandleScanResult: translate failed");
                    f.L(activity);
                    AppMethodBeat.o(22227);
                }
            }
        });
        bg.azz().a(acVar, 0);
        AppMethodBeat.o(22231);
    }

    public static boolean a(Context context, String[] strArr, String[] strArr2) {
        AppMethodBeat.i(22232);
        if (context == null) {
            Log.e("MicroMsg.WXBizLogic", "context is null");
            AppMethodBeat.o(22232);
            return false;
        }
        String str = null;
        String str2 = null;
        if (strArr2 != null && strArr2.length > 0) {
            str = strArr2[0];
            str2 = g.getMessageDigest(com.tencent.mm.pluginsdk.model.app.q.cj(context, strArr2[0])[0].toByteArray());
        }
        Log.i("MicroMsg.WXBizLogic", "openBusinessWebview packageName = %s, sig = %s", str, str2);
        if (strArr == null || strArr.length < 3) {
            Log.e("MicroMsg.WXBizLogic", "args is null");
            AppMethodBeat.o(22232);
            return false;
        }
        String str3 = strArr[0];
        if (Util.isNullOrNil(str3)) {
            Log.e("MicroMsg.WXBizLogic", "appId is null");
            AppMethodBeat.o(22232);
            return false;
        }
        int i2 = Util.getInt(strArr[1], 0);
        if (i2 <= 0) {
            Log.e("MicroMsg.WXBizLogic", "businessType(%d) invalid", Integer.valueOf(i2));
            AppMethodBeat.o(22232);
            return false;
        }
        String nullAsNil = Util.nullAsNil(strArr[2]);
        Log.i("MicroMsg.WXBizLogic", "openBusinessWebview, appid = %s, businessType = %d, queryInfo = %s", str3, Integer.valueOf(i2), nullAsNil);
        String str4 = "";
        try {
            str4 = URLEncoder.encode(Util.nullAsNil(nullAsNil), MimeTypeUtil.ContentType.DEFAULT_CHARSET);
        } catch (UnsupportedEncodingException e2) {
            Log.printErrStackTrace("MicroMsg.WXBizLogic", e2, "", new Object[0]);
        }
        String format = String.format("weixin://dl/openbusinesswebview/link?appid=%s&type=%d&query=%s", str3, Integer.valueOf(i2), str4);
        Log.i("MicroMsg.WXBizLogic", "openBusinessWebview url format = %s", format);
        Intent intent = new Intent(context, WXBizEntryActivity.class);
        intent.setData(Uri.parse(format));
        intent.addFlags(268435456);
        intent.putExtra("key_package_name", str);
        intent.putExtra("key_app_id", str3);
        intent.putExtra("translate_link_scene", 1);
        intent.putExtra("key_package_signature", str2);
        intent.putExtra("key_command_id", 25);
        u(intent, context);
        AppMethodBeat.o(22232);
        return true;
    }

    public static boolean b(Context context, String[] strArr, String[] strArr2) {
        int i2;
        AppMethodBeat.i(22233);
        if (context == null) {
            Log.e("MicroMsg.WXBizLogic", "context is null");
            AppMethodBeat.o(22233);
            return false;
        }
        String str = null;
        String str2 = null;
        if (strArr2 != null && strArr2.length > 0) {
            str = strArr2[0];
            str2 = g.getMessageDigest(com.tencent.mm.pluginsdk.model.app.q.cj(context, strArr2[0])[0].toByteArray());
        }
        Log.i("MicroMsg.WXBizLogic", "openBusinessView packageName = %s, sig = %s", str, str2);
        if (strArr == null || strArr.length < 4) {
            Log.e("MicroMsg.WXBizLogic", "args is null");
            AppMethodBeat.o(22233);
            return false;
        }
        String str3 = strArr[0];
        if (Util.isNullOrNil(str3)) {
            Log.e("MicroMsg.WXBizLogic", "appId is null");
            AppMethodBeat.o(22233);
            return false;
        }
        String str4 = strArr[1];
        if (Util.isNullOrNil(str4)) {
            Log.e("MicroMsg.WXBizLogic", "businessType isEmpty");
            AppMethodBeat.o(22233);
            return false;
        }
        String nullAsNil = Util.nullAsNil(strArr[2]);
        String nullAsNil2 = Util.nullAsNil(strArr[3]);
        if (strArr.length > 4) {
            n.Kwp = strArr[4];
        }
        String str5 = "";
        if (strArr.length > 5) {
            str5 = strArr[5];
            com.tencent.mm.pluginsdk.model.app.h.o(str3, true, false);
        }
        boolean startsWith = str4.startsWith(AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_NATIVE);
        Object[] objArr = new Object[3];
        objArr[0] = startsWith ? "openNativeView" : "jumpFakeWxa";
        objArr[1] = str3;
        objArr[2] = str4;
        String format = String.format("weixin://dl/%s/?appid=%s&businessType=%s", objArr);
        Log.i("MicroMsg.WXBizLogic", "openBusinessView url format = %s,query=%s,extInfo=%s", format, nullAsNil, nullAsNil2);
        if (!startsWith && !Util.isNullOrNil(nullAsNil2)) {
            try {
                i2 = new com.tencent.mm.ab.i(nullAsNil2).optInt("miniProgramType", 0);
                if (i2 < 0 || i2 > 2) {
                    i2 = 0;
                }
            } catch (Exception e2) {
            }
            Intent intent = new Intent(context, WXBizEntryActivity.class);
            intent.setData(Uri.parse(format));
            intent.addFlags(268435456);
            intent.putExtra("key_package_name", str);
            intent.putExtra("key_app_id", str3);
            intent.putExtra("key_business_type", str4);
            intent.putExtra("translate_link_scene", 1);
            intent.putExtra("key_package_signature", str2);
            intent.putExtra("key_command_id", 26);
            u(intent, context);
            ad.b G = ad.aVe().G("key_data_center_session_id", true);
            G.l("key_launch_miniprogram_type", Integer.valueOf(i2));
            G.l("key_launch_miniprogram_query_info", nullAsNil);
            G.l("key_open_business_view_ext_info", nullAsNil2);
            G.l("key_launch_mini_program_open_id", str5);
            AppMethodBeat.o(22233);
            return true;
        }
        i2 = 0;
        Intent intent2 = new Intent(context, WXBizEntryActivity.class);
        intent2.setData(Uri.parse(format));
        intent2.addFlags(268435456);
        intent2.putExtra("key_package_name", str);
        intent2.putExtra("key_app_id", str3);
        intent2.putExtra("key_business_type", str4);
        intent2.putExtra("translate_link_scene", 1);
        intent2.putExtra("key_package_signature", str2);
        intent2.putExtra("key_command_id", 26);
        u(intent2, context);
        ad.b G2 = ad.aVe().G("key_data_center_session_id", true);
        G2.l("key_launch_miniprogram_type", Integer.valueOf(i2));
        G2.l("key_launch_miniprogram_query_info", nullAsNil);
        G2.l("key_open_business_view_ext_info", nullAsNil2);
        G2.l("key_launch_mini_program_open_id", str5);
        AppMethodBeat.o(22233);
        return true;
    }

    public static boolean d(Context context, String[] strArr, String[] strArr2) {
        AppMethodBeat.i(258837);
        if (context == null) {
            Log.e("MicroMsg.WXBizLogic", "context is null");
            AppMethodBeat.o(258837);
            return false;
        }
        String str = null;
        String str2 = null;
        if (strArr2 != null && strArr2.length > 0) {
            str = strArr2[0];
            Signature[] cj = com.tencent.mm.pluginsdk.model.app.q.cj(context, strArr2[0]);
            if (cj != null) {
                str2 = g.getMessageDigest(cj[0].toByteArray());
            }
        }
        Log.i("MicroMsg.WXBizLogic", "finderShareVideo packageName = %s, sig = %s", str, str2);
        if (strArr == null || strArr.length < 2) {
            Log.e("MicroMsg.WXBizLogic", "args is null");
            AppMethodBeat.o(258837);
            return false;
        }
        String str3 = strArr[0];
        if (Util.isNullOrNil(str3)) {
            Log.e("MicroMsg.WXBizLogic", "appId is null");
            AppMethodBeat.o(258837);
            return false;
        }
        String str4 = strArr[1];
        if (Util.isNullOrNil(str4)) {
            Log.e("MicroMsg.WXBizLogic", "videoPath isEmpty");
            AppMethodBeat.o(258837);
            return false;
        }
        String str5 = "";
        if (strArr.length >= 3) {
            str5 = strArr[2];
        }
        String str6 = "";
        if (strArr.length >= 4) {
            str6 = strArr[3];
        }
        String str7 = "";
        if (strArr.length >= 5) {
            str7 = strArr[4];
        }
        String str8 = "";
        String str9 = "";
        try {
            str8 = URLEncoder.encode(str5, MimeTypeUtil.ContentType.DEFAULT_CHARSET);
            str9 = URLEncoder.encode(str6, MimeTypeUtil.ContentType.DEFAULT_CHARSET);
        } catch (UnsupportedEncodingException e2) {
            Log.printErrStackTrace("MicroMsg.WXBizLogic", e2, "", new Object[0]);
        }
        String format = String.format("weixin://dl/channels/shareVideo/?appid=%s&title=%s&url=%s", str3, str8, str9);
        Log.i("MicroMsg.WXBizLogic", "finderShareVideo: appid = %s, videoPath = %s, title = %s, url = %s, extData = %s", str3, str4, str5, str6, str7);
        Intent intent = new Intent(context, WXBizEntryActivity.class);
        intent.setData(Uri.parse(format));
        intent.addFlags(268435456);
        intent.putExtra("key_app_id", str3);
        intent.putExtra("key_package_name", str);
        intent.putExtra("translate_link_scene", 1);
        intent.putExtra("key_package_signature", str2);
        intent.putExtra("key_command_id", 33);
        intent.putExtra("key_finder_video_path", str4);
        u(intent, context);
        AppMethodBeat.o(258837);
        return true;
    }

    public static boolean e(Context context, String[] strArr, String[] strArr2) {
        String str;
        String str2;
        AppMethodBeat.i(258838);
        if (context == null) {
            Log.e("MicroMsg.WXBizLogic", "context is null");
            AppMethodBeat.o(258838);
            return false;
        }
        if (strArr2 == null || strArr2.length <= 0) {
            str = null;
            str2 = null;
        } else {
            str2 = strArr2[0];
            Signature[] cj = com.tencent.mm.pluginsdk.model.app.q.cj(context, strArr2[0]);
            str = cj != null ? g.getMessageDigest(cj[0].toByteArray()) : null;
        }
        Log.i("MicroMsg.WXBizLogic", "finderOpenProfile packageName = %s, sig = %s", str2, str);
        if (strArr == null || strArr.length < 2) {
            Log.e("MicroMsg.WXBizLogic", "args is null");
            AppMethodBeat.o(258838);
            return false;
        }
        String str3 = strArr[0];
        if (Util.isNullOrNil(str3)) {
            Log.e("MicroMsg.WXBizLogic", "appId is null");
            AppMethodBeat.o(258838);
            return false;
        }
        String str4 = strArr[1];
        if (Util.isNullOrNil(str4)) {
            Log.e("MicroMsg.WXBizLogic", "username isEmpty");
            AppMethodBeat.o(258838);
            return false;
        }
        String str5 = "";
        try {
            str5 = URLEncoder.encode(str4, MimeTypeUtil.ContentType.DEFAULT_CHARSET);
        } catch (UnsupportedEncodingException e2) {
            Log.printErrStackTrace("MicroMsg.WXBizLogic", e2, "", new Object[0]);
        }
        String format = String.format("weixin://dl/channels/profile/?appid=%s&username=%s", str3, str5);
        Log.i("MicroMsg.WXBizLogic", "finderOpenProfile: appid = %s, username = %s", str3, str4);
        Intent intent = new Intent(context, WXBizEntryActivity.class);
        intent.setData(Uri.parse(format));
        intent.addFlags(268435456);
        intent.putExtra("key_app_id", str3);
        intent.putExtra("key_package_name", str2);
        intent.putExtra("translate_link_scene", 1);
        intent.putExtra("key_package_signature", str);
        intent.putExtra("key_command_id", 34);
        u(intent, context);
        AppMethodBeat.o(258838);
        return true;
    }

    public static boolean f(Context context, String[] strArr, String[] strArr2) {
        AppMethodBeat.i(258839);
        if (context == null) {
            Log.e("MicroMsg.WXBizLogic", "context is null");
            AppMethodBeat.o(258839);
            return false;
        }
        String str = null;
        String str2 = null;
        if (strArr2 != null && strArr2.length > 0) {
            str = strArr2[0];
            Signature[] cj = com.tencent.mm.pluginsdk.model.app.q.cj(context, strArr2[0]);
            if (cj != null) {
                str2 = g.getMessageDigest(cj[0].toByteArray());
            }
        }
        Log.i("MicroMsg.WXBizLogic", "finderOpenLive packageName = %s, sig = %s", str, str2);
        if (strArr == null || strArr.length < 3) {
            Log.e("MicroMsg.WXBizLogic", "args is null");
            AppMethodBeat.o(258839);
            return false;
        }
        String str3 = strArr[0];
        if (Util.isNullOrNil(str3)) {
            Log.e("MicroMsg.WXBizLogic", "appId is null");
            AppMethodBeat.o(258839);
            return false;
        }
        String str4 = strArr[1];
        if (Util.isNullOrNil(str4)) {
            Log.e("MicroMsg.WXBizLogic", "feedID isEmpty");
            AppMethodBeat.o(258839);
            return false;
        }
        String str5 = strArr[2];
        if (Util.isNullOrNil(str5)) {
            Log.e("MicroMsg.WXBizLogic", "nonceID isEmpty");
            AppMethodBeat.o(258839);
            return false;
        }
        String str6 = "";
        String str7 = "";
        try {
            str6 = URLEncoder.encode(str4, MimeTypeUtil.ContentType.DEFAULT_CHARSET);
            str7 = URLEncoder.encode(str5, MimeTypeUtil.ContentType.DEFAULT_CHARSET);
        } catch (UnsupportedEncodingException e2) {
            Log.printErrStackTrace("MicroMsg.WXBizLogic", e2, "", new Object[0]);
        }
        String format = String.format("weixin://dl/channels/live/?appid=%s&feedID=%s&nonceID=%s", str3, str6, str7);
        Log.i("MicroMsg.WXBizLogic", "finderOpenLive: appid = %s, feedID = %s, nonceID = %s", str3, str4, str5);
        Intent intent = new Intent(context, WXBizEntryActivity.class);
        intent.setData(Uri.parse(format));
        intent.addFlags(268435456);
        intent.putExtra("key_app_id", str3);
        intent.putExtra("key_package_name", str);
        intent.putExtra("translate_link_scene", 1);
        intent.putExtra("key_package_signature", str2);
        intent.putExtra("key_command_id", 35);
        u(intent, context);
        AppMethodBeat.o(258839);
        return true;
    }

    public static boolean g(Context context, String[] strArr, String[] strArr2) {
        AppMethodBeat.i(258840);
        if (context == null) {
            Log.e("MicroMsg.WXBizLogic", "context is null");
            AppMethodBeat.o(258840);
            return false;
        }
        String str = null;
        String str2 = null;
        if (strArr2 != null && strArr2.length > 0) {
            str = strArr2[0];
            Signature[] cj = com.tencent.mm.pluginsdk.model.app.q.cj(context, strArr2[0]);
            if (cj != null) {
                str2 = g.getMessageDigest(cj[0].toByteArray());
            }
        }
        Log.i("MicroMsg.WXBizLogic", "finderOpenFeed packageName = %s, sig = %s", str, str2);
        if (strArr == null || strArr.length < 3) {
            Log.e("MicroMsg.WXBizLogic", "args is null");
            AppMethodBeat.o(258840);
            return false;
        }
        String str3 = strArr[0];
        if (Util.isNullOrNil(str3)) {
            Log.e("MicroMsg.WXBizLogic", "appId is null");
            AppMethodBeat.o(258840);
            return false;
        }
        String str4 = strArr[1];
        if (Util.isNullOrNil(str4)) {
            Log.e("MicroMsg.WXBizLogic", "feedID isEmpty");
            AppMethodBeat.o(258840);
            return false;
        }
        String str5 = strArr[2];
        if (Util.isNullOrNil(str5)) {
            Log.e("MicroMsg.WXBizLogic", "nonceID isEmpty");
            AppMethodBeat.o(258840);
            return false;
        }
        String str6 = "";
        if (strArr.length > 3) {
            str6 = strArr[3];
        }
        int i2 = str6.equals(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE) ? 1 : 0;
        String str7 = "";
        String str8 = "";
        try {
            str7 = URLEncoder.encode(str4, MimeTypeUtil.ContentType.DEFAULT_CHARSET);
            str8 = URLEncoder.encode(str5, MimeTypeUtil.ContentType.DEFAULT_CHARSET);
        } catch (UnsupportedEncodingException e2) {
            Log.printErrStackTrace("MicroMsg.WXBizLogic", e2, "", new Object[0]);
        }
        String format = String.format("weixin://dl/channels/feed/?appid=%s&feedID=%s&nonceID=%s&nonGetRelatedList=%d", str3, str7, str8, Integer.valueOf(i2));
        Log.i("MicroMsg.WXBizLogic", "finderOpenFeed: appid = %s, feedID = %s, nonceID = %s, nonGetRelatedList", str3, str4, str5, str6);
        Intent intent = new Intent(context, WXBizEntryActivity.class);
        intent.setData(Uri.parse(format));
        intent.addFlags(268435456);
        intent.putExtra("key_app_id", str3);
        intent.putExtra("key_package_name", str);
        intent.putExtra("translate_link_scene", 1);
        intent.putExtra("key_package_signature", str2);
        intent.putExtra("key_command_id", 36);
        u(intent, context);
        AppMethodBeat.o(258840);
        return true;
    }

    public static boolean u(String[] strArr) {
        AppMethodBeat.i(22234);
        if (strArr == null || strArr.length < 6 || !Util.getBoolean(strArr[5], false)) {
            AppMethodBeat.o(22234);
            return false;
        }
        AppMethodBeat.o(22234);
        return true;
    }

    public static MatrixCursor a(Context context, String[] strArr, String[] strArr2, boolean z, boolean z2, boolean z3) {
        AppMethodBeat.i(22235);
        MatrixCursor a2 = a(context, strArr, strArr2, z, z2, z3, false);
        AppMethodBeat.o(22235);
        return a2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:44:0x0136 A[SYNTHETIC, Splitter:B:44:0x0136] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x015c  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0194  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0203  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0212  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.database.MatrixCursor a(android.content.Context r18, java.lang.String[] r19, java.lang.String[] r20, boolean r21, boolean r22, boolean r23, boolean r24) {
        /*
        // Method dump skipped, instructions count: 1060
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.base.stub.f.a(android.content.Context, java.lang.String[], java.lang.String[], boolean, boolean, boolean, boolean):android.database.MatrixCursor");
    }

    static {
        AppMethodBeat.i(22242);
        AppMethodBeat.o(22242);
    }

    public static void a(String str, int i2, String str2, String str3, int i3, String str4, long j2) {
        AppMethodBeat.i(22236);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(22236);
            return;
        }
        String c2 = c(str, i2, str2, str3, i3);
        e eVar = new e();
        eVar.iVn = System.currentTimeMillis();
        eVar.pdt = str4;
        if (j2 > 0) {
            eVar.pdu = 1000 * j2;
        }
        pdU.put(c2, eVar);
        AppMethodBeat.o(22236);
    }

    private static String c(String str, int i2, String str2, String str3, int i3) {
        AppMethodBeat.i(22237);
        String mD5String = MD5Util.getMD5String(String.format("%s_%d_%s_%s_%d", str, Integer.valueOf(i2), str2, str3, Integer.valueOf(i3)));
        AppMethodBeat.o(22237);
        return mD5String;
    }

    public static void CD(int i2) {
        AppMethodBeat.i(22238);
        com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(1194, (long) i2, 1, false);
        AppMethodBeat.o(22238);
    }

    public static void cjS() {
        AppMethodBeat.i(179576);
        Log.i("MicroMsg.WXBizLogic", "alvinluo reportGetCallingPackageNull");
        com.tencent.mm.plugin.report.service.h.INSTANCE.n(1194, 50, 1);
        AppMethodBeat.o(179576);
    }

    public static void cjT() {
        AppMethodBeat.i(179577);
        Log.i("MicroMsg.WXBizLogic", "alvinluo reportGetPackagesForUidMoreThanOne");
        com.tencent.mm.plugin.report.service.h.INSTANCE.n(1194, 51, 1);
        AppMethodBeat.o(179577);
    }

    public static void cjU() {
        AppMethodBeat.i(231619);
        com.tencent.mm.plugin.report.service.h.INSTANCE.a(1194, 60, 1);
        AppMethodBeat.o(231619);
    }

    private static MatrixCursor a(final String str, final String str2, final String str3, final int i2, final int i3, final boolean z) {
        AppMethodBeat.i(22239);
        if (Util.isNullOrNil(str2) || Util.isNullOrNil(str3)) {
            Log.e("MicroMsg.WXBizLogic", "doMiniProgramTranslateLink:packageName or signature null");
            AppMethodBeat.o(22239);
            return null;
        }
        LinkedList<eg> linkedList = new LinkedList<>();
        eg egVar = new eg();
        Log.i("MicroMsg.WXBizLogic", "doMiniProgramTranslateLink package name = %s, cgiType=%d", str2, Integer.valueOf(i3));
        egVar.qGp = str2;
        egVar.signature = str3;
        linkedList.add(egVar);
        d.a aVar = new d.a();
        aVar.iLN = new ekp();
        aVar.iLO = new ekq();
        aVar.uri = "/cgi-bin/mmbiz-bin/translatelink";
        aVar.funcId = 1200;
        d aXF = aVar.aXF();
        ekp ekp = (ekp) aXF.iLK.iLR;
        ekp.link = str + (1 == i3 ? "&preload=1" : "");
        ekp.link += (2 == i3 ? "&jsForReport=1" : "");
        ekp.scene = 1;
        ekp.NjP = linkedList;
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        final MatrixCursor matrixCursor = new MatrixCursor(new String[]{"downloadUrl", "fileMd5", "expireTime", "extraBytes"});
        aa.a(aXF, new aa.a() {
            /* class com.tencent.mm.plugin.base.stub.f.AnonymousClass2 */
            final /* synthetic */ int peg = 1;

            @Override // com.tencent.mm.ak.aa.a
            public final int a(int i2, int i3, String str, d dVar, q qVar) {
                AppMethodBeat.i(22228);
                Log.i("MicroMsg.WXBizLogic", "doMiniProgramTranslateLink, %d, %d, %s, cgiType=%d", Integer.valueOf(i2), Integer.valueOf(i3), str, Integer.valueOf(i3));
                if (i2 == 0 && i3 == 0) {
                    f.z(true, i3);
                    String str2 = ((ekq) dVar.iLL.iLR).NjQ;
                    Uri parse = Uri.parse(str2);
                    parse.getQueryParameter("appid");
                    String queryParameter = parse.getQueryParameter("userName");
                    String queryParameter2 = parse.getQueryParameter("path");
                    f.a(str, this.peg, str2, str3, i2, str2, Util.safeParseLong(parse.getQueryParameter("validTime")));
                    if (i3 != 1) {
                        AppMethodBeat.o(22228);
                        return 0;
                    }
                    ((a) com.tencent.mm.kernel.g.af(a.class)).ek(queryParameter, queryParameter2);
                    if (z) {
                        f.a(queryParameter, queryParameter2, matrixCursor, countDownLatch);
                    } else {
                        ((a) com.tencent.mm.kernel.g.af(a.class)).a(queryParameter, new android.arch.a.c.a<WxaAttributes, Void>() {
                            /* class com.tencent.mm.plugin.base.stub.f.AnonymousClass2.AnonymousClass1 */

                            /* Return type fixed from 'java.lang.Object' to match base method */
                            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                            @Override // android.arch.a.c.a
                            public final /* synthetic */ Void apply(WxaAttributes wxaAttributes) {
                                AppMethodBeat.i(231611);
                                Void l = l(wxaAttributes);
                                AppMethodBeat.o(231611);
                                return l;
                            }

                            private static Void l(WxaAttributes wxaAttributes) {
                                AppMethodBeat.i(231610);
                                if (wxaAttributes != null) {
                                    try {
                                        if (wxaAttributes.bAn().NA()) {
                                            ((com.tencent.mm.plugin.appbrand.service.f) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.appbrand.service.f.class)).c(z.OPEN_SDK_API_PRELOAD);
                                        } else if (wxaAttributes.bAn().bAt()) {
                                            ((com.tencent.mm.plugin.appbrand.service.f) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.appbrand.service.f.class)).a(z.OPEN_SDK_API_PRELOAD);
                                        } else {
                                            ((com.tencent.mm.plugin.appbrand.service.f) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.appbrand.service.f.class)).b(z.OPEN_SDK_API_PRELOAD);
                                        }
                                    } catch (Exception e2) {
                                        Log.printErrStackTrace("MicroMsg.WXBizLogic", e2, "prefetchWxaAttrs-preloadEnv", new Object[0]);
                                    }
                                }
                                AppMethodBeat.o(231610);
                                return null;
                            }
                        });
                    }
                    AppMethodBeat.o(22228);
                    return 0;
                }
                f.z(false, i3);
                AppMethodBeat.o(22228);
                return 0;
            }
        });
        if (z) {
            try {
                countDownLatch.await(10, TimeUnit.SECONDS);
            } catch (InterruptedException e2) {
                Log.e("MicroMsg.WXBizLogic", e2.getMessage());
            }
        }
        if (z) {
            AppMethodBeat.o(22239);
            return matrixCursor;
        }
        AppMethodBeat.o(22239);
        return null;
    }

    public static boolean cjV() {
        AppMethodBeat.i(161300);
        if (pdX != -1) {
            if (pdX == 1) {
                AppMethodBeat.o(161300);
                return true;
            }
            AppMethodBeat.o(161300);
            return false;
        } else if (BuildInfo.DEBUG) {
            AppMethodBeat.o(161300);
            return true;
        } else if (Build.VERSION.SDK_INT < 29) {
            AppMethodBeat.o(161300);
            return false;
        } else {
            pdX = ((b) com.tencent.mm.kernel.g.af(b.class)).a(b.a.clicfg_open_jump_biz_entry_retry, 1);
            Log.i("MicroMsg.WXBizLogic", "reTryOpenWXBizEntry open %d", Integer.valueOf(pdX));
            if (pdX == 1) {
                AppMethodBeat.o(161300);
                return true;
            }
            AppMethodBeat.o(161300);
            return false;
        }
    }

    public static synchronized void u(Intent intent, Context context) {
        synchronized (f.class) {
            AppMethodBeat.i(161301);
            ac(intent);
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/base/stub/WXBizLogic", "safeStartWXBizEntry", "(Landroid/content/Intent;Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            context.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/base/stub/WXBizLogic", "safeStartWXBizEntry", "(Landroid/content/Intent;Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(161301);
        }
    }

    private static synchronized void ac(Intent intent) {
        synchronized (f.class) {
            AppMethodBeat.i(161302);
            if (cjV()) {
                CD(31);
                long currentTimeMillis = System.currentTimeMillis();
                Log.i("MicroMsg.WXBizLogic", "Safe Launch WXBizEntry saveWXBizEntryIntent enterId=%d", Long.valueOf(currentTimeMillis));
                intent.putExtra("__BIZ_ENTRY_ENTER_ID", currentTimeMillis);
                pdV = intent;
                cjX();
            }
            AppMethodBeat.o(161302);
        }
    }

    private static synchronized void cjW() {
        synchronized (f.class) {
            pdV = null;
        }
    }

    private static void cjX() {
        AppMethodBeat.i(169736);
        if (appForegroundListener == null) {
            AnonymousClass6 r0 = new o.a() {
                /* class com.tencent.mm.plugin.base.stub.f.AnonymousClass6 */

                @Override // com.tencent.mm.app.o
                public final void onAppForeground(String str) {
                    AppMethodBeat.i(231615);
                    boolean unused = f.pdY = true;
                    long unused2 = f.pdZ = SystemClock.elapsedRealtime();
                    Log.d("MicroMsg.WXBizLogic", "turn onAppForeground");
                    if (f.pdV != null && com.tencent.mm.kernel.g.aAc()) {
                        Log.d("MicroMsg.WXBizLogic", "Safe Launch WXBizEntry onAppForeground");
                        f.cjZ();
                    }
                    AppMethodBeat.o(231615);
                }

                @Override // com.tencent.mm.app.o
                public final void onAppBackground(String str) {
                    AppMethodBeat.i(231616);
                    Log.d("MicroMsg.WXBizLogic", "turn onAppBackground");
                    boolean unused = f.pdY = false;
                    AppMethodBeat.o(231616);
                }
            };
            appForegroundListener = r0;
            r0.alive();
        }
        AppMethodBeat.o(169736);
    }

    public static void cjY() {
        AppMethodBeat.i(161303);
        pdY = true;
        pdZ = SystemClock.elapsedRealtime();
        cjZ();
        AppMethodBeat.o(161303);
    }

    public static void cjZ() {
        AppMethodBeat.i(169737);
        cjX();
        if (pdV == null || !cjV()) {
            AppMethodBeat.o(169737);
            return;
        }
        MMHandlerThread.postToMainThreadDelayed(new Runnable() {
            /* class com.tencent.mm.plugin.base.stub.f.AnonymousClass7 */

            public final void run() {
                AppMethodBeat.i(231617);
                f.cka();
                AppMethodBeat.o(231617);
            }
        }, 50);
        AppMethodBeat.o(169737);
    }

    public static synchronized void cka() {
        synchronized (f.class) {
            AppMethodBeat.i(161304);
            Log.d("MicroMsg.WXBizLogic", "Safe Launch WXBizEntry checkStartWXBizEntry");
            if (pdV == null) {
                AppMethodBeat.o(161304);
            } else {
                long currentTimeMillis = System.currentTimeMillis() - pdV.getLongExtra("__BIZ_ENTRY_ENTER_ID", 0);
                if (!ae(pdV) && Math.abs(currentTimeMillis) < 5000) {
                    Log.i("MicroMsg.WXBizLogic", "Safe Launch WXBizEntry checkStartWXBizEntry startActivity costTime %d", Long.valueOf(currentTimeMillis));
                    pdV.putExtra("__BIZ_ENTRY_FROM_RETRY", true);
                    Context context = MMApplicationContext.getContext();
                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(pdV);
                    com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/base/stub/WXBizLogic", "doCheckStartWXBizEntry", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    context.startActivity((Intent) bl.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/base/stub/WXBizLogic", "doCheckStartWXBizEntry", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    cjW();
                    CD(30);
                }
                AppMethodBeat.o(161304);
            }
        }
    }

    public static synchronized void ad(Intent intent) {
        synchronized (f.class) {
            AppMethodBeat.i(161305);
            if (!cjV()) {
                AppMethodBeat.o(161305);
            } else {
                long longExtra = intent.getLongExtra("__BIZ_ENTRY_ENTER_ID", 0);
                if (longExtra != 0) {
                    pdW.add(Long.valueOf(longExtra));
                }
                cjW();
                Log.d("MicroMsg.WXBizLogic", "Safe Launch WXBizEntry addToConsumedSet %d", Long.valueOf(longExtra));
                AppMethodBeat.o(161305);
            }
        }
    }

    public static synchronized boolean ae(Intent intent) {
        boolean contains;
        synchronized (f.class) {
            AppMethodBeat.i(161306);
            long longExtra = intent.getLongExtra("__BIZ_ENTRY_ENTER_ID", 0);
            Log.d("MicroMsg.WXBizLogic", "Safe Launch WXBizEntry isInConsumedSet %d", Long.valueOf(longExtra));
            contains = pdW.contains(Long.valueOf(longExtra));
            AppMethodBeat.o(161306);
        }
        return contains;
    }

    public static void ckb() {
        AppMethodBeat.i(179578);
        try {
            int a2 = ((b) com.tencent.mm.kernel.g.af(b.class)).a(b.a.clicfg_opensdk_content_provider_use_getcallingpackage, 1);
            pea = a2 != 0;
            Log.i("MicroMsg.WXBizLogic", "alvinluo updateGetCallingPackageStatus config: %d, %b", Integer.valueOf(a2), Boolean.valueOf(pea));
            AppMethodBeat.o(179578);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.WXBizLogic", e2, "alvinluo updateGetCallingPackageStatus exception", new Object[0]);
            pea = true;
            AppMethodBeat.o(179578);
        }
    }

    public static boolean ckc() {
        return pea;
    }

    static void CE(int i2) {
        AppMethodBeat.i(231620);
        com.tencent.mm.plugin.report.service.h.INSTANCE.dN(1405, i2);
        AppMethodBeat.o(231620);
    }

    static void c(Context context, String[] strArr, String[] strArr2) {
        AppMethodBeat.i(231621);
        Object[] objArr = new Object[3];
        objArr[0] = Boolean.valueOf(context == null);
        objArr[1] = Arrays.toString(strArr);
        objArr[2] = Arrays.toString(strArr2);
        Log.i("MicroMsg.WXBizLogic", "doLaunchWxaRedirectingPage, context==null[%b], args[%s], packages[%s]", objArr);
        CE(1);
        if (context == null || strArr2 == null || strArr2[0].length() <= 0) {
            CE(2);
            AppMethodBeat.o(231621);
            return;
        }
        WXLaunchWxaRedirectingPage.Req req = new WXLaunchWxaRedirectingPage.Req();
        try {
            String str = strArr[0];
            if (TextUtils.isEmpty(str)) {
                CE(2);
                AppMethodBeat.o(231621);
                return;
            }
            req.fromArray((String[]) org.apache.commons.b.a.g(strArr, strArr.length));
            Intent intent = new Intent(context, WXBizEntryActivity.class);
            intent.setData(Uri.parse(String.format(Locale.ENGLISH, "weixin://dl/wmpf/sdk?appid=%s&ticket=%s", str, req.invokeTicket)));
            intent.addFlags(268435456);
            intent.putExtra("translate_link_scene", 1);
            intent.putExtra("key_package_name", strArr2[0]);
            Signature[] cj = com.tencent.mm.pluginsdk.model.app.q.cj(context, strArr2[0]);
            if (cj != null && cj.length > 0) {
                intent.putExtra("key_package_signature", g.getMessageDigest(cj[0].toByteArray()));
            }
            Bundle bundle = new Bundle();
            req.toBundle(bundle);
            intent.putExtra("key_launch_wxa_redirecting_page_req", bundle);
            intent.putExtra("key_command_id", 30);
            u(intent, context);
            AppMethodBeat.o(231621);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.WXBizLogic", e2, "doLaunchWxaFRedirectingPage args[%s] packages[%s]", Arrays.toString(strArr), Arrays.toString(strArr2));
            CE(2);
            AppMethodBeat.o(231621);
        }
    }

    static void a(Context context, WXLaunchWxaRedirectingPage.Req req, String str, int i2, String str2) {
        AppMethodBeat.i(231622);
        WXLaunchWxaRedirectingPage.Resp resp = new WXLaunchWxaRedirectingPage.Resp(Bundle.EMPTY);
        resp.invokeTicket = req.invokeTicket;
        resp.callbackActivity = req.callbackActivity;
        resp.errCode = i2;
        resp.errStr = str2;
        Bundle bundle = new Bundle();
        resp.toBundle(bundle);
        com.tencent.mm.pluginsdk.model.app.q.bo(bundle);
        com.tencent.mm.pluginsdk.model.app.q.bp(bundle);
        MMessageActV2.Args args = new MMessageActV2.Args();
        args.targetPkgName = str;
        args.bundle = bundle;
        MMessageActV2.send(context, args);
        if (context instanceof WXBizEntryActivity) {
            ((WXBizEntryActivity) context).finish();
        }
        AppMethodBeat.o(231622);
    }

    static MatrixCursor v(String[] strArr) {
        String[] strArr2;
        String[] strArr3;
        MatrixCursor matrixCursor;
        String str;
        String[] strArr4;
        AppMethodBeat.i(231623);
        if (strArr == null || strArr.length == 0) {
            MatrixCursor matrixCursor2 = new MatrixCursor(new String[0], 0);
            AppMethodBeat.o(231623);
            return matrixCursor2;
        }
        MatrixCursor matrixCursor3 = new MatrixCursor(new String[]{"feature", "support"}, strArr.length);
        for (String str2 : strArr) {
            if (TextUtils.isEmpty(str2)) {
                String[] strArr5 = new String[2];
                strArr5[0] = str2;
                strArr2 = strArr5;
                strArr3 = strArr5;
                matrixCursor = matrixCursor3;
            } else {
                String[] strArr6 = new String[2];
                strArr6[0] = str2;
                if (org.apache.commons.b.a.contains(peb, str2)) {
                    str = "1";
                    strArr4 = strArr6;
                    strArr3 = strArr6;
                    matrixCursor = matrixCursor3;
                    strArr4[1] = str;
                    matrixCursor.addRow(strArr3);
                } else {
                    strArr2 = strArr6;
                    strArr3 = strArr6;
                    matrixCursor = matrixCursor3;
                }
            }
            str = AppEventsConstants.EVENT_PARAM_VALUE_NO;
            strArr4 = strArr2;
            strArr4[1] = str;
            matrixCursor.addRow(strArr3);
        }
        AppMethodBeat.o(231623);
        return matrixCursor3;
    }

    static /* synthetic */ void L(Activity activity) {
        AppMethodBeat.i(22240);
        Intent intent = new Intent();
        intent.setFlags(268435456);
        intent.setClassName(MMApplicationContext.getContext(), "com.tencent.mm.plugin.webview.ui.tools.WebViewUI");
        intent.putExtra("rawUrl", com.tencent.mm.pluginsdk.g.JSL);
        intent.putExtra("showShare", false);
        c.b(MMApplicationContext.getContext(), "webview", ".ui.tools.WebViewUI", intent);
        if (activity != null) {
            activity.finish();
        }
        AppMethodBeat.o(22240);
    }

    static /* synthetic */ void z(boolean z, int i2) {
        int i3;
        AppMethodBeat.i(231624);
        if (i2 == 1 || i2 == 2) {
            CD(z ? 11 : 12);
            AppMethodBeat.o(231624);
            return;
        }
        if (i2 == 3) {
            if (z) {
                i3 = 14;
            } else {
                i3 = 15;
            }
            CD(i3);
        }
        AppMethodBeat.o(231624);
    }

    static /* synthetic */ void a(String str, String str2, final MatrixCursor matrixCursor, final CountDownLatch countDownLatch) {
        AppMethodBeat.i(231625);
        ((a) com.tencent.mm.kernel.g.af(a.class)).a(str, str2, z.OPEN_SDK_API_PRELOAD).a(new d.b<List<a.C0735a>>() {
            /* class com.tencent.mm.plugin.base.stub.f.AnonymousClass5 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.vending.g.d.b
            public final /* synthetic */ void bz(List<a.C0735a> list) {
                AppMethodBeat.i(231614);
                List<a.C0735a> list2 = list;
                if (list2 == null || list2.isEmpty()) {
                    Log.e("MicroMsg.WXBizLogic", "prefetchPkgDownloadInfos is null ");
                } else {
                    for (a.C0735a aVar : list2) {
                        Log.i("MicroMsg.WXBizLogic", "fetchPkgInfo addRow %s", aVar);
                        try {
                            String encodeHexString = Util.encodeHexString(aVar.bNX());
                            matrixCursor.addRow(new Object[]{aVar.mYd, aVar.mYc, Long.valueOf(aVar.mYe), encodeHexString});
                        } catch (IOException e2) {
                            Log.e("MicroMsg.WXBizLogic", "fetchPkgInfo metaToByteArray e=%s", e2);
                        }
                    }
                }
                countDownLatch.countDown();
                AppMethodBeat.o(231614);
            }
        }).a(new d.a() {
            /* class com.tencent.mm.plugin.base.stub.f.AnonymousClass4 */

            @Override // com.tencent.mm.vending.g.d.a
            public final void cn(Object obj) {
                AppMethodBeat.i(231613);
                Log.e("MicroMsg.WXBizLogic", "onInterrupt error");
                countDownLatch.countDown();
                AppMethodBeat.o(231613);
            }
        });
        AppMethodBeat.o(231625);
    }
}
