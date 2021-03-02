package com.tencent.mm.plugin.sns.data;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.view.View;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.sns.a.a;
import com.tencent.mm.plugin.sns.ad.d.a.a;
import com.tencent.mm.plugin.sns.device.appstore.d;
import com.tencent.mm.plugin.sns.device.appstore.e;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.storage.ADInfo;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ah;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ap;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.pluginsdk.model.app.al;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.protocal.protobuf.dzo;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.IntentUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public final class k {
    public static boolean d(TimeLineObject timeLineObject) {
        cnb cnb;
        AppMethodBeat.i(176239);
        if (timeLineObject == null || timeLineObject.ContentObj == null || timeLineObject.ContentObj.LoV == null || timeLineObject.ContentObj.LoV.size() <= 0 || (cnb = timeLineObject.ContentObj.LoV.get(0)) == null || cnb.MsB == null || cnb.MsB.Mto <= 0.0f || cnb.MsB.Mtp <= 0.0f) {
            AppMethodBeat.o(176239);
            return false;
        } else if (((int) cnb.MsB.Mtp) > ((int) cnb.MsB.Mto)) {
            AppMethodBeat.o(176239);
            return true;
        } else {
            AppMethodBeat.o(176239);
            return false;
        }
    }

    public static JSONObject aJ(Map<String, Object> map) {
        AppMethodBeat.i(176240);
        JSONObject jSONObject = new JSONObject();
        try {
            for (String str : map.keySet()) {
                jSONObject.put(str, map.get(str));
            }
        } catch (Exception e2) {
        }
        AppMethodBeat.o(176240);
        return jSONObject;
    }

    public static void jY(String str, String str2) {
        AppMethodBeat.i(176241);
        try {
            if (MMApplicationContext.isMainProcess()) {
                g gVar = new g(str, str2);
                com.tencent.mm.kernel.g.aAi();
                com.tencent.mm.kernel.g.aAg().hqi.a(gVar, 0);
                Log.i("SnsAdUtil", "adChannelCgiReport, main, channel=" + str + ", content=" + str2);
                AppMethodBeat.o(176241);
            } else if (MMApplicationContext.isToolsProcess()) {
                AdLandingPagesProxy.getInstance().onAdLandingPageClick(str, str2);
                Log.i("SnsAdUtil", "adChannelCgiReport, tools, channel=" + str + ", content=" + str2);
                AppMethodBeat.o(176241);
            } else {
                Log.e("SnsAdUtil", "adChannelCgiReport, process err");
                AppMethodBeat.o(176241);
            }
        } catch (Exception e2) {
            Log.e("SnsAdUtil", "adChannelCgiReport, exp=" + e2.toString());
            AppMethodBeat.o(176241);
        }
    }

    public static String fg(View view) {
        AppMethodBeat.i(176242);
        String str = "[" + view.getPaddingLeft() + "," + view.getPaddingTop() + "," + view.getPaddingRight() + "," + view.getPaddingBottom() + "]";
        AppMethodBeat.o(176242);
        return str;
    }

    public static void a(Context context, String str, ah ahVar, int i2, long j2, String str2) {
        AppMethodBeat.i(202592);
        try {
            Intent intent = new Intent();
            if (!TextUtils.isEmpty(ahVar.kZe) && !TextUtils.isEmpty(ahVar.aid)) {
                str = ap.n(str, "traceid=" + ahVar.kZe + "&aid=" + ahVar.aid);
            }
            String str3 = ahVar.DZW;
            if (TextUtils.isEmpty(str3)) {
                str3 = ahVar.uxInfo;
                Log.i("SnsAdUtil", "adLandingJumpWebPageUI, use orig_UxInfo:".concat(String.valueOf(str3)));
            } else {
                Log.i("SnsAdUtil", "adLandingJumpWebPageUI, use updated_UxInfo:".concat(String.valueOf(str3)));
            }
            String kb = r.kb(str, str3);
            r.h(intent, str3);
            String aND = a.aND(kb);
            Log.i("SnsAdUtil", "open url %s", aND);
            intent.putExtra("rawUrl", aND);
            intent.putExtra("useJs", true);
            intent.putExtra("type", -255);
            intent.putExtra("geta8key_scene", 2);
            if (ahVar.bizId == 0) {
                SnsAdClick snsAdClick = new SnsAdClick(i2, j2);
                Bundle bundle = new Bundle();
                bundle.putParcelable("KSnsAdTag", snsAdClick);
                if (!TextUtils.isEmpty(str3)) {
                    bundle.putString("KAnsUxInfo", str3);
                }
                intent.putExtra("jsapiargs", bundle);
            }
            if ((context instanceof Activity) && ahVar.bizId == 2) {
                String stringExtra = ((Activity) context).getIntent().getStringExtra("sns_landing_pages_sessionId");
                String stringExtra2 = ((Activity) context).getIntent().getStringExtra("sns_landing_pages_ad_buffer");
                if (!Util.isNullOrNil(stringExtra)) {
                    String valueOf = String.valueOf(System.currentTimeMillis() / 1000);
                    Object[] objArr = new Object[4];
                    if (Util.isNullOrNil(stringExtra2)) {
                        stringExtra2 = "";
                    }
                    objArr[0] = stringExtra2;
                    objArr[1] = stringExtra;
                    objArr[2] = str2;
                    objArr[3] = valueOf;
                    String format = String.format("official_mall_%s_%s_%s_%s", objArr);
                    intent.putExtra("prePublishId", format);
                    intent.putExtra("KPublisherId", format);
                    intent.putExtra("pay_channel", 47);
                }
            }
            c.b(context, "webview", ".ui.tools.WebViewUI", intent);
            AppMethodBeat.o(202592);
        } catch (Throwable th) {
            Log.e("SnsAdUtil", "adLandingJumpWebPageUI exp=" + th.toString());
            AppMethodBeat.o(202592);
        }
    }

    public static boolean a(SnsObject snsObject, String str) {
        boolean z;
        boolean z2;
        AppMethodBeat.i(202593);
        try {
            Iterator<dzo> it = snsObject.CommentUserList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                dzo next = it.next();
                if (next != null && !Util.isNullOrNil(next.Username) && next.Username.equals(str)) {
                    z = true;
                    break;
                }
            }
            Iterator<dzo> it2 = snsObject.LikeUserList.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    z2 = false;
                    break;
                }
                dzo next2 = it2.next();
                if (next2 != null && !Util.isNullOrNil(next2.Username) && next2.Username.equals(str)) {
                    z2 = true;
                    break;
                }
            }
            Log.i("SnsAdUtil", "isAdCommentOrLikedBySelf, snsId=" + r.Jb(snsObject.Id) + ", hasComment=" + z + ", hasLiked=" + z2);
            if (z || z2) {
                AppMethodBeat.o(202593);
                return true;
            }
            AppMethodBeat.o(202593);
            return false;
        } catch (Exception e2) {
            Log.e("SnsAdUtil", "isAdCommentOrLikedBySelf, exp=" + e2.toString());
            AppMethodBeat.o(202593);
            return false;
        }
    }

    public static long aOa(String str) {
        AppMethodBeat.i(202594);
        try {
            if (Util.isNullOrNil(str)) {
                AppMethodBeat.o(202594);
                return 0;
            } else if (str.startsWith("ad_table_")) {
                long safeParseLong = Util.safeParseLong(str.substring(9));
                AppMethodBeat.o(202594);
                return safeParseLong;
            } else if (str.startsWith("sns_table_")) {
                long safeParseLong2 = Util.safeParseLong(str.substring(10));
                AppMethodBeat.o(202594);
                return safeParseLong2;
            } else {
                long aOw = r.aOw(str);
                AppMethodBeat.o(202594);
                return aOw;
            }
        } catch (Throwable th) {
            Log.e("SnsAdUtil", th.toString());
            AppMethodBeat.o(202594);
            return 0;
        }
    }

    public static int r(SnsInfo snsInfo) {
        ADXml adXml;
        AppMethodBeat.i(202595);
        int i2 = 0;
        if (snsInfo != null) {
            try {
                if (snsInfo.isAd() && (adXml = snsInfo.getAdXml()) != null && !TextUtils.isEmpty(adXml.firstDownloadApkPkgName)) {
                    long currentTimeMillis = System.currentTimeMillis();
                    i2 = q.s(MMApplicationContext.getContext(), adXml.firstDownloadApkPkgName) ? 2 : 1;
                    Log.i("SnsAdUtil", "getAdAppInstallStatus, pkg=" + adXml.firstDownloadApkPkgName + ", installState=" + i2 + ", timeCost=" + (System.currentTimeMillis() - currentTimeMillis));
                }
            } catch (Throwable th) {
                Log.e("SnsAdUtil", "appInstalled exp=" + th.toString());
            }
        }
        AppMethodBeat.o(202595);
        return i2;
    }

    public static int s(SnsInfo snsInfo) {
        Throwable th;
        int i2;
        AppMethodBeat.i(202596);
        String str = "";
        try {
            String userName = snsInfo.getUserName();
            long currentTimeMillis = System.currentTimeMillis();
            if (snsInfo != null && snsInfo.isAd() && !TextUtils.isEmpty(userName)) {
                com.tencent.mm.kernel.g.aAi();
                as Kn = ((l) com.tencent.mm.kernel.g.af(l.class)).aSN().Kn(userName);
                if (Kn != null) {
                    if (((int) Kn.gMZ) <= 0 || !com.tencent.mm.contact.c.oR(Kn.field_type)) {
                        i2 = 1;
                    } else {
                        i2 = 2;
                    }
                    try {
                        str = Kn.arI();
                        Log.i("SnsAdUtil", "getAdUserFollowStatus, userName=" + userName + ", followStatus=" + i2 + ", displayName=" + str + ", timeCost=" + (System.currentTimeMillis() - currentTimeMillis));
                    } catch (Throwable th2) {
                        th = th2;
                        Log.e("SnsAdUtil", "isContact exp=" + th.toString());
                        AppMethodBeat.o(202596);
                        return i2;
                    }
                    AppMethodBeat.o(202596);
                    return i2;
                }
            }
            i2 = 1;
            Log.i("SnsAdUtil", "getAdUserFollowStatus, userName=" + userName + ", followStatus=" + i2 + ", displayName=" + str + ", timeCost=" + (System.currentTimeMillis() - currentTimeMillis));
        } catch (Throwable th3) {
            th = th3;
            i2 = 1;
            Log.e("SnsAdUtil", "isContact exp=" + th.toString());
            AppMethodBeat.o(202596);
            return i2;
        }
        AppMethodBeat.o(202596);
        return i2;
    }

    public static void a(SnsAdClick snsAdClick, com.tencent.mm.plugin.sns.ad.g.k kVar, SnsInfo snsInfo, int i2) {
        long j2 = 0;
        AppMethodBeat.i(202597);
        try {
            Log.d("SnsAdUtil", "appendSnsAdClickParams, snsAdStatistic==null?" + (kVar == null) + ", clickPos=" + i2);
            snsAdClick.jlb = kVar == null ? 0 : kVar.fr(snsInfo.getLocalid(), i2);
            if (kVar != null) {
                j2 = kVar.IV(snsInfo.field_snsId);
            }
            snsAdClick.jlc = j2;
            AppMethodBeat.o(202597);
        } catch (Exception e2) {
            Log.e("SnsAdUtil", "appendSnsAdClickParams exp=" + e2.toString() + ", clockPos=" + i2);
            AppMethodBeat.o(202597);
        }
    }

    public static boolean a(final Context context, final String str, final String str2, final String str3, String str4, final String str5, final String str6, final String str7, final int i2, final int i3) {
        String str8;
        AppMethodBeat.i(202598);
        Log.i("SnsAdUtil", "openApp, appId = " + str + ", uxInfo = " + str5 + ", adExtInfo = " + str6 + ", appPageUrl=" + str4 + ", pkgName=" + str2);
        if (context == null || TextUtils.isEmpty(str2)) {
            Log.e("SnsAdUtil", "openApp, failed");
            AppMethodBeat.o(202598);
            return false;
        }
        if (i3 != 2) {
            i.a(str7, str, 0, 2, str5, str6, i2);
        }
        if (!TextUtils.isEmpty(str4)) {
            final Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str4));
            intent.addFlags(268435456);
            List<ResolveInfo> queryIntentActivities = Util.queryIntentActivities(context, intent);
            if (queryIntentActivities == null || queryIntentActivities.isEmpty()) {
                Log.e("SnsAdUtil", "queryIntentActivities, empty");
            } else {
                if (!TextUtils.isEmpty(intent.getPackage()) || queryIntentActivities.size() != 1) {
                    str8 = intent.getPackage();
                } else {
                    str8 = h.b(queryIntentActivities.get(0));
                }
                Log.i("SnsAdUtil", "queryIntentActivities, pkg=".concat(String.valueOf(str8)));
                if (!Util.nullAsNil(MMApplicationContext.getPackageName()).equals(str8)) {
                    com.tencent.mm.ch.a.post(new Runnable() {
                        /* class com.tencent.mm.plugin.sns.data.k.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(202588);
                            h.a(context, intent, str3, i3, new al() {
                                /* class com.tencent.mm.plugin.sns.data.k.AnonymousClass1.AnonymousClass1 */

                                @Override // com.tencent.mm.pluginsdk.model.app.al
                                public final void v(boolean z, boolean z2) {
                                    AppMethodBeat.i(202587);
                                    Log.i("SnsAdUtil", "appPageUrl!=null, onLaunchApp=" + z + ", launchCancel=" + z2);
                                    if (z && i3 != 2) {
                                        i.a(str7, str, 1, 2, str5, str6, i2);
                                    }
                                    if (!z) {
                                        ap.hb(context);
                                    }
                                    AppMethodBeat.o(202587);
                                }
                            }, (Bundle) null);
                            AppMethodBeat.o(202588);
                        }
                    });
                } else {
                    Log.e("SnsAdUtil", "err queryIntent pkg equals mm");
                }
            }
        } else {
            com.tencent.mm.ch.a.post(new Runnable() {
                /* class com.tencent.mm.plugin.sns.data.k.AnonymousClass2 */

                public final void run() {
                    AppMethodBeat.i(202590);
                    h.a(context, context.getPackageManager().getLaunchIntentForPackage(str2), str3, i3, new al() {
                        /* class com.tencent.mm.plugin.sns.data.k.AnonymousClass2.AnonymousClass1 */

                        @Override // com.tencent.mm.pluginsdk.model.app.al
                        public final void v(boolean z, boolean z2) {
                            AppMethodBeat.i(202589);
                            Log.i("SnsAdUtil", "onLaunchApp=" + z + ", launchCancel=" + z2);
                            if (z && i3 != 2) {
                                i.a(str7, str, 1, 2, str5, str6, i2);
                            }
                            if (!z) {
                                ap.hb(context);
                            }
                            AppMethodBeat.o(202589);
                        }
                    }, (Bundle) null);
                    AppMethodBeat.o(202590);
                }
            });
        }
        AdLandingPagesProxy.getInstance().reportDownloadInfo(9, str);
        AppMethodBeat.o(202598);
        return true;
    }

    public static boolean a(Context context, SnsInfo snsInfo, ADInfo aDInfo, int i2, com.tencent.mm.plugin.sns.ad.g.k kVar) {
        boolean z;
        AppMethodBeat.i(202599);
        if (snsInfo == null || aDInfo == null) {
            AppMethodBeat.o(202599);
            return false;
        }
        try {
            if (a(context, snsInfo, aDInfo)) {
                Log.i("SnsAdUtil", "handleAdClickAction, checkOpenApp succ");
                SnsAdClick snsAdClick = new SnsAdClick(i2, i2 == 0 ? 1 : 2, snsInfo.field_snsId, 22, 34);
                a(snsAdClick, kVar, snsInfo, 22);
                r.a(snsAdClick);
                AppMethodBeat.o(202599);
                return true;
            } else if (a(context, snsInfo, aDInfo, 2)) {
                Log.i("SnsAdUtil", "handleAdClickAction, tryProcessAdAppMarket succ");
                SnsAdClick snsAdClick2 = new SnsAdClick(i2, i2 == 0 ? 1 : 2, snsInfo.field_snsId, 22, 36);
                a(snsAdClick2, kVar, snsInfo, 22);
                r.a(snsAdClick2);
                AppMethodBeat.o(202599);
                return true;
            } else {
                ADXml adXml = snsInfo.getAdXml();
                if (adXml == null || adXml.adScanJumpInfo == null || aDInfo == null || aDInfo.adActionType != 8) {
                    z = false;
                } else {
                    com.tencent.mm.plugin.sns.ad.e.k.a(context, adXml.adScanJumpInfo, aDInfo.uxInfo);
                    z = true;
                }
                if (z) {
                    Log.i("SnsAdUtil", "handleAdClickAction, checkJumpScan succ");
                    SnsAdClick snsAdClick3 = new SnsAdClick(i2, i2 == 0 ? 1 : 2, snsInfo.field_snsId, 22, 35);
                    a(snsAdClick3, kVar, snsInfo, 22);
                    r.a(snsAdClick3);
                    AppMethodBeat.o(202599);
                    return true;
                }
                if (snsInfo.isCardAd() && com.tencent.mm.plugin.sns.ad.e.h.a(context, snsInfo.getAdXml(), aDInfo, snsInfo.field_snsId, 3)) {
                    SnsAdClick snsAdClick4 = new SnsAdClick(i2, i2 == 0 ? 1 : 2, snsInfo.field_snsId, 22, 37);
                    a(snsAdClick4, kVar, snsInfo, 22);
                    r.a(snsAdClick4);
                    AppMethodBeat.o(202599);
                    return true;
                }
                AppMethodBeat.o(202599);
                return false;
            }
        } catch (Throwable th) {
            Log.e("SnsAdUtil", "handleAdClickAction, exp=" + th.toString());
        }
    }

    private static boolean a(Context context, SnsInfo snsInfo, ADInfo aDInfo) {
        AppMethodBeat.i(202600);
        if (!(snsInfo == null || aDInfo == null)) {
            try {
                if (aDInfo.actionExtAppJump != null) {
                    if (q.s(context, aDInfo.actionExtAppJump.LG)) {
                        Log.i("SnsAdUtil", "checkOpenApp isInstalled=true, " + aDInfo.actionExtAppJump.toString());
                        String str = "";
                        if (snsInfo.getAdXml() != null) {
                            str = snsInfo.getAdXml().adExtInfo;
                        }
                        if (a(context, aDInfo.actionExtAppJump.appId, aDInfo.actionExtAppJump.LG, aDInfo.actionExtAppJump.appName, aDInfo.actionExtAppJump.appPageUrl, aDInfo.uxInfo, str, String.valueOf(snsInfo.field_snsId), 2, 0)) {
                            AppMethodBeat.o(202600);
                            return true;
                        }
                        Log.e("SnsAdUtil", "checkOpenApp failed, " + aDInfo.actionExtAppJump.toString());
                        jZ(aDInfo.actionExtAppJump.LG, aDInfo.actionExtAppJump.appPageUrl);
                    } else {
                        Log.e("SnsAdUtil", "checkOpenApp isInstalled=false, " + aDInfo.actionExtAppJump.toString());
                        jZ(aDInfo.actionExtAppJump.LG, aDInfo.actionExtAppJump.appPageUrl);
                    }
                }
            } catch (Throwable th) {
                Log.e("SnsAdUtil", "checkOpenApp exp=" + th.toString());
            }
        }
        AppMethodBeat.o(202600);
        return false;
    }

    public static boolean b(Context context, SnsInfo snsInfo, ADInfo aDInfo) {
        boolean z = false;
        AppMethodBeat.i(202601);
        try {
            z = a(context, snsInfo, aDInfo, 0);
            AppMethodBeat.o(202601);
        } catch (Throwable th) {
            Log.w("SnsAdUtil", "processAdAppMarket has something wrong");
            AppMethodBeat.o(202601);
        }
        return z;
    }

    private static boolean a(Context context, SnsInfo snsInfo, ADInfo aDInfo, int i2) {
        String str;
        String str2;
        AppMethodBeat.i(202602);
        if (context == null || snsInfo == null || aDInfo == null) {
            Log.e("SnsAdUtil", "tryProcessAdAppMarket input param is wrong");
            AppMethodBeat.o(202602);
            return false;
        }
        String str3 = "";
        String str4 = "";
        String str5 = "";
        if (aDInfo.actionExtAppJump != null) {
            String str6 = aDInfo.actionExtAppJump.appName;
            str3 = aDInfo.actionExtAppJump.appId;
            str4 = aDInfo.actionExtAppJump.appPageUrl;
            str5 = aDInfo.actionExtAppJump.LG;
            str = str6;
        } else {
            str = "";
        }
        ADXml adXml = snsInfo.getAdXml();
        if (adXml == null || adXml.toAdMarket != 1) {
            AppMethodBeat.o(202602);
            return false;
        }
        String str7 = adXml.adExtInfo;
        Intent intent = adXml.appMarketIntent;
        if (!TextUtils.isEmpty(str5) || intent == null) {
            str2 = str5;
        } else {
            str2 = IntentUtil.getStringExtra(adXml.appMarketIntent, "target_app_id");
        }
        if (str2 == null) {
            Log.e("SnsAdUtil", "the target package is empty!");
            AppMethodBeat.o(202602);
            return false;
        }
        int i3 = i2 == 1 ? 2 : 0;
        if (q.s(context, str2)) {
            if (TextUtils.isEmpty(str)) {
                str = a.C1700a.by(context, str2);
            }
            a(context, str3, str2, str, str4, aDInfo.uxInfo, str7, String.valueOf(snsInfo.field_snsId), i2, i3);
        } else {
            if (com.tencent.mm.plugin.sns.device.appstore.a.aU(intent)) {
                b(String.valueOf(snsInfo.field_snsId), aDInfo.uxInfo, str7, 4, AppEventsConstants.EVENT_PARAM_VALUE_NO);
            } else {
                b(String.valueOf(snsInfo.field_snsId), aDInfo.uxInfo, str7, 4, "1");
            }
            if (com.tencent.mm.plugin.sns.device.appstore.a.aV(intent)) {
                b(String.valueOf(snsInfo.field_snsId), aDInfo.uxInfo, str7, 1, AppEventsConstants.EVENT_PARAM_VALUE_NO);
                a(context, intent, str2, String.valueOf(snsInfo.field_snsId), aDInfo.uxInfo, str7, i3);
            } else {
                b(String.valueOf(snsInfo.field_snsId), aDInfo.uxInfo, str7, 1, "1");
                AppMethodBeat.o(202602);
                return false;
            }
        }
        AppMethodBeat.o(202602);
        return true;
    }

    private static void a(Context context, Intent intent, final String str, final String str2, final String str3, final String str4, final int i2) {
        AppMethodBeat.i(202603);
        if (context == null || intent == null) {
            Log.e("SnsAdUtil", "startMarketActivity input param is error");
            AppMethodBeat.o(202603);
            return;
        }
        try {
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            ap.a(context, intent.getPackage(), "", intent, Util.nullAs(IntentUtil.getStringExtra(intent, "market_app_name"), ""), new al() {
                /* class com.tencent.mm.plugin.sns.data.k.AnonymousClass3 */

                @Override // com.tencent.mm.pluginsdk.model.app.al
                public final void v(boolean z, boolean z2) {
                    AppMethodBeat.i(202591);
                    if (z) {
                        if (i2 != 2) {
                            k.b(str2, str3, str4, 2, AppEventsConstants.EVENT_PARAM_VALUE_NO);
                        }
                        e C = e.C(str, str2, str3, str4);
                        if (C != null) {
                            d.a(C);
                        }
                        AppMethodBeat.o(202591);
                        return;
                    }
                    if (i2 != 2) {
                        k.b(str2, str3, str4, 2, "2");
                    }
                    AppMethodBeat.o(202591);
                }
            }, i2);
            AppMethodBeat.o(202603);
        } catch (Throwable th) {
            b(str2, str3, str4, 2, "1");
            AppMethodBeat.o(202603);
        }
    }

    public static void b(String str, String str2, String str3, int i2, String str4) {
        AppMethodBeat.i(202604);
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.put("outSns", 1);
        com.tencent.mm.plugin.sns.device.appstore.a.a(str, str2, str3, i2, str4, arrayMap);
        AppMethodBeat.o(202604);
    }

    public static void jZ(String str, String str2) {
        AppMethodBeat.i(202605);
        Log.i("SnsAdUtil", "writeDelayDeepLink, pkg=" + str + ", pageUrl=" + str2);
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            AppMethodBeat.o(202605);
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("wx_ad_pkgname", str);
            jSONObject.put("wx_ad_deeplink", str2);
            ClipboardHelper.setText(MMApplicationContext.getContext(), "wx_ad_deeplink", jSONObject.toString());
            AppMethodBeat.o(202605);
        } catch (Throwable th) {
            Log.e("SnsAdUtil", "writeDelayDeepLink exp=" + th.toString());
            AppMethodBeat.o(202605);
        }
    }

    public static String aoz() {
        AppMethodBeat.i(202606);
        try {
            String deviceId = ((TelephonyManager) MMApplicationContext.getContext().getSystemService("phone")).getDeviceId();
            AppMethodBeat.o(202606);
            return deviceId;
        } catch (Throwable th) {
            AppMethodBeat.o(202606);
            return "";
        }
    }

    public static boolean a(SnsInfo snsInfo, int i2) {
        ADInfo adInfo;
        AppMethodBeat.i(202607);
        if (i2 == 2) {
            adInfo = snsInfo.getAtAdInfo();
        } else {
            adInfo = snsInfo.getAdInfo();
        }
        if (adInfo == null || adInfo.actionExtWeApp == null) {
            AppMethodBeat.o(202607);
            return false;
        } else if (adInfo.adActionType != 4) {
            AppMethodBeat.o(202607);
            return false;
        } else if (Util.isNullOrNil(adInfo.actionExtWeApp.appUserName)) {
            AppMethodBeat.o(202607);
            return false;
        } else {
            AppMethodBeat.o(202607);
            return true;
        }
    }

    public static boolean t(SnsInfo snsInfo) {
        boolean z = true;
        AppMethodBeat.i(202608);
        if (snsInfo == null) {
            AppMethodBeat.o(202608);
            return false;
        }
        try {
            ADXml adXml = snsInfo.getAdXml();
            if (adXml.isValidJumpCanvas == 1) {
                AppMethodBeat.o(202608);
                return true;
            } else if (adXml.isValidJumpCanvas == 0) {
                AppMethodBeat.o(202608);
                return false;
            } else {
                if (!adXml.isLandingPagesAd() || !i.aQg(snsInfo.getAdSnsInfo().field_adxml)) {
                    z = false;
                }
                if (z) {
                    adXml.isValidJumpCanvas = 1;
                } else {
                    adXml.isValidJumpCanvas = 0;
                }
                AppMethodBeat.o(202608);
                return z;
            }
        } catch (Throwable th) {
            Log.e("SnsAdUtil", th.toString());
            AppMethodBeat.o(202608);
            return false;
        }
    }

    public static String aOb(String str) {
        AppMethodBeat.i(202609);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(202609);
            return "";
        }
        String[] split = str.split("\\|");
        if (split == null || split.length <= 0) {
            AppMethodBeat.o(202609);
            return "";
        }
        String str2 = split[0];
        AppMethodBeat.o(202609);
        return str2;
    }

    public static s aOc(String str) {
        String sb;
        AppMethodBeat.i(202610);
        s sVar = new s();
        try {
            JSONObject jSONObject = new JSONObject(str);
            sVar.pageId = jSONObject.optString("canvasId");
            sVar.uxInfo = jSONObject.optString("uxInfo");
            String str2 = sVar.uxInfo;
            if (Util.isNullOrNil(str2)) {
                Log.e("SnsAdUtil", "uxInfo is null");
                sb = "";
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("<ADInfo><uxInfo>").append(str2).append("</uxInfo></ADInfo>");
                sb = sb2.toString();
            }
            sVar.lAP = sb;
            Log.i("SnsAdUtil", "pageId = " + sVar.pageId + ", uxInfo = " + sVar.uxInfo + ", adInfoXml = " + sVar.lAP);
        } catch (Throwable th) {
            Log.e("SnsAdUtil", th.toString());
        }
        AppMethodBeat.o(202610);
        return sVar;
    }

    public static boolean aOd(String str) {
        AppMethodBeat.i(202611);
        if (TextUtils.isEmpty(str) || !str.contains("<usePreferedInfo>1</usePreferedInfo>")) {
            AppMethodBeat.o(202611);
            return false;
        }
        AppMethodBeat.o(202611);
        return true;
    }

    public static String ka(String str, String str2) {
        AppMethodBeat.i(202612);
        StringBuilder sb = new StringBuilder("isChatRoom=");
        if (str2 == null || (!str2.endsWith("@chatroom") && !str2.endsWith("@im.chatroom"))) {
            sb.append(AppEventsConstants.EVENT_PARAM_VALUE_NO);
        } else {
            sb.append("1");
        }
        sb.append("&fromUsername=").append(str);
        sb.append("&chatName=").append(str2);
        String sb2 = sb.toString();
        AppMethodBeat.o(202612);
        return sb2;
    }

    public static void c(int i2, int i3, int i4, String str) {
        AppMethodBeat.i(202613);
        Log.i("SnsAdUtil", "reportAdPicDownload, result=" + i2 + ", scene=" + i3 + ", downloader=" + i4 + ", imgUrl=" + str);
        if (!TextUtils.isEmpty(str)) {
            try {
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(21534, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str);
                if (i3 != 0) {
                    if (i3 == 1) {
                        if (i2 == 0) {
                            com.tencent.mm.plugin.report.service.h.INSTANCE.dN(1560, 3);
                            AppMethodBeat.o(202613);
                            return;
                        }
                        com.tencent.mm.plugin.report.service.h.INSTANCE.dN(1560, 4);
                    }
                    AppMethodBeat.o(202613);
                } else if (i2 == 0) {
                    com.tencent.mm.plugin.report.service.h.INSTANCE.dN(1560, 1);
                    AppMethodBeat.o(202613);
                } else {
                    com.tencent.mm.plugin.report.service.h.INSTANCE.dN(1560, 2);
                    AppMethodBeat.o(202613);
                }
            } catch (Throwable th) {
                Log.e("SnsAdUtil", "reportAdPicDownload, exp=" + th.toString());
                AppMethodBeat.o(202613);
            }
        } else {
            Log.e("SnsAdUtil", "reportAdPicDownload, url is empty");
            AppMethodBeat.o(202613);
        }
    }

    public static int aOe(String str) {
        String[] split;
        int i2 = 0;
        AppMethodBeat.i(202614);
        try {
            if (!TextUtils.isEmpty(str) && (split = str.split("-")) != null && split.length > 0) {
                i2 = Util.safeParseInt(split[0]);
                AppMethodBeat.o(202614);
                return i2;
            }
        } catch (Throwable th) {
            Log.e("SnsAdUtil", "getRawRequestType, exp=" + th.toString());
        }
        AppMethodBeat.o(202614);
        return i2;
    }

    public static String jV(String str, String str2) {
        AppMethodBeat.i(202615);
        String nullAsNil = Util.nullAsNil(str);
        try {
            if (!TextUtils.isEmpty(nullAsNil) && !TextUtils.isEmpty(str2)) {
                nullAsNil = String.format("#%02x%s", Integer.valueOf((int) (Util.safeParseDouble(str2) * 255.0d)), nullAsNil.substring(1));
            }
        } catch (Exception e2) {
            Log.e("SnsAdUtil", "parseColor exp=" + e2.toString());
        }
        AppMethodBeat.o(202615);
        return nullAsNil;
    }

    public static void it(int i2, int i3) {
        int i4 = 1;
        AppMethodBeat.i(202616);
        if (i2 == 1) {
            if (i3 != 0) {
                i4 = 2;
            }
        } else if (i2 == 2) {
            if (i3 == 0) {
                i4 = 3;
            } else {
                i4 = 4;
            }
        } else if (i2 != 3) {
            i4 = 0;
        } else if (i3 == 0) {
            i4 = 5;
        } else {
            i4 = 6;
        }
        try {
            Log.d("SnsAdUtil", "reportAdFinderTopicImageDownload scene is " + i2 + ", result is " + i4);
            if (i4 != 0) {
                com.tencent.mm.plugin.report.service.h.INSTANCE.dN(1606, i4);
            }
            AppMethodBeat.o(202616);
        } catch (Throwable th) {
            AppMethodBeat.o(202616);
        }
    }
}
