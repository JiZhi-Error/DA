package com.tencent.mm.plugin.game.luggage.d.a;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.aa;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.q;
import com.tencent.mm.b.g;
import com.tencent.mm.g.a.lp;
import com.tencent.mm.ipcinvoker.p;
import com.tencent.mm.opensdk.constants.Build;
import com.tencent.mm.opensdk.modelmsg.WXAppExtendObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.lite.jsapi.b;
import com.tencent.mm.pluginsdk.model.app.am;
import com.tencent.mm.protocal.protobuf.cea;
import com.tencent.mm.protocal.protobuf.ceb;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.sqlitelint.behaviour.persistence.IssueStorage;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import org.json.JSONObject;

public class h extends b {
    @Override // com.tencent.mm.plugin.lite.jsapi.b
    public final int dTw() {
        return 1;
    }

    @Override // com.tencent.liteapp.jsapi.a
    public final void a(String str, JSONObject jSONObject) {
        AppMethodBeat.i(186914);
        final String optString = jSONObject.optString("appID");
        final String optString2 = jSONObject.optString("schemeUrl");
        final String optString3 = jSONObject.optString("parameter");
        final String optString4 = jSONObject.optString(AssistantStore.DownloadInfos.DownloadInfoColumns.PACKAGENAME);
        final String optString5 = jSONObject.optString("signature");
        int optInt = jSONObject.optInt("alertType");
        final String optString6 = jSONObject.optString(IssueStorage.COLUMN_EXT_INFO);
        Log.i("LiteAppJsApiLaunchApplication", "doLaunchApplication, appid : %s, scheme : %s, extinfo:[%s], parameter : %s, pkg:%s, signature:%s", optString, optString2, optString6, optString3, optString4, optString5);
        if (!Util.isNullOrNil(optString) || !Util.isNullOrNil(optString2) || !Util.isNullOrNil(optString4)) {
            String optString7 = jSONObject.optString("preVerifyAppId");
            String optString8 = jSONObject.optString("currentUrl");
            final Bundle bundle = new Bundle();
            try {
                bundle.putString("current_page_url", URLEncoder.encode(optString8, MimeTypeUtil.ContentType.DEFAULT_CHARSET));
            } catch (UnsupportedEncodingException e2) {
            }
            bundle.putString("current_page_appid", optString7);
            d.a aVar = new d.a();
            aVar.iLN = new cea();
            aVar.iLO = new ceb();
            aVar.uri = "/cgi-bin/mmbiz-bin/checklaunchapp";
            aVar.funcId = 1125;
            d aXF = aVar.aXF();
            cea cea = (cea) aXF.iLK.iLR;
            cea.dNI = optString7;
            cea.MjD = optString;
            cea.scene = 0;
            cea.url = optString8;
            cea.MjE = optString2;
            cea.qwp = optInt;
            cea.LEg = 0;
            cea.packageName = optString4;
            Log.i("LiteAppJsApiLaunchApplication", "run cgi to check(appId : %s, toAppId : %s, scene : %s, url : %s, schemeUrl : %s, alertType : %s)", optString7, optString, Integer.valueOf(cea.scene), cea.url, cea.MjE, Integer.valueOf(cea.qwp));
            aa.a(aXF, new aa.a() {
                /* class com.tencent.mm.plugin.game.luggage.d.a.h.AnonymousClass1 */

                @Override // com.tencent.mm.ak.aa.a
                public final int a(final int i2, final int i3, final String str, final d dVar, q qVar) {
                    AppMethodBeat.i(186913);
                    p.post(new Runnable() {
                        /* class com.tencent.mm.plugin.game.luggage.d.a.h.AnonymousClass1.AnonymousClass1 */

                        public final void run() {
                            boolean z;
                            String str;
                            Signature[] cj;
                            String str2;
                            AppMethodBeat.i(186912);
                            Log.d("LiteAppJsApiLaunchApplication", "on RunCgi callback errType:%d errCode:%d msg:%s", Integer.valueOf(i2), Integer.valueOf(i3), str);
                            if (i2 == 0 && i3 == 0) {
                                ceb ceb = (ceb) dVar.iLL.iLR;
                                switch (ceb.dIZ) {
                                    case 0:
                                        am amVar = new am(new am.a() {
                                            /* class com.tencent.mm.plugin.game.luggage.d.a.h.AnonymousClass1.AnonymousClass1.AnonymousClass1 */

                                            @Override // com.tencent.mm.pluginsdk.model.app.am.a
                                            public final void u(boolean z, boolean z2) {
                                                AppMethodBeat.i(186911);
                                                Log.i("LiteAppJsApiLaunchApplication", "onLaunchAppCallback(launchRet : %s, launchSuccess : %s)", Boolean.valueOf(z), Boolean.valueOf(z2));
                                                if (z) {
                                                    h.this.yEn.ecz();
                                                    AppMethodBeat.o(186911);
                                                    return;
                                                }
                                                h.this.yEn.aCS("fail");
                                                AppMethodBeat.o(186911);
                                            }
                                        });
                                        Log.i("LiteAppJsApiLaunchApplication", "launchApplication check result(showType : %d, errCode : %d)", Integer.valueOf(ceb.xGz), Integer.valueOf(ceb.dIZ));
                                        Context context = MMApplicationContext.getContext();
                                        if (!Util.isNullOrNil(optString2)) {
                                            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(optString2));
                                            intent.addFlags(268435456);
                                            List<ResolveInfo> queryIntentActivities = Util.queryIntentActivities(context, intent);
                                            if (queryIntentActivities != null && !queryIntentActivities.isEmpty()) {
                                                if (!TextUtils.isEmpty(intent.getPackage()) || queryIntentActivities.size() != 1) {
                                                    str2 = intent.getPackage();
                                                } else {
                                                    str2 = com.tencent.mm.pluginsdk.model.app.h.b(queryIntentActivities.get(0));
                                                }
                                                if (!Util.nullAsNil(MMApplicationContext.getPackageName()).equals(str2)) {
                                                    amVar.hj(com.tencent.mm.pluginsdk.model.app.h.a(context, intent, (String) null, ceb.xGz, amVar, bundle));
                                                    AppMethodBeat.o(186912);
                                                    return;
                                                }
                                            }
                                        }
                                        if (!Util.isNullOrNil(optString4) && !Util.isNullOrNil(optString5) && (cj = com.tencent.mm.pluginsdk.model.app.q.cj(context, optString4)) != null && cj[0] != null) {
                                            String messageDigest = g.getMessageDigest(cj[0].toByteArray());
                                            if (messageDigest == null || !messageDigest.equalsIgnoreCase(optString5)) {
                                                Log.i("LiteAppJsApiLaunchApplication", "launchApplication signature not match");
                                            } else {
                                                try {
                                                    Intent launchIntentForPackage = MMApplicationContext.getContext().getPackageManager().getLaunchIntentForPackage(optString4);
                                                    if (launchIntentForPackage != null) {
                                                        Bundle bundle = new Bundle();
                                                        com.tencent.mm.pluginsdk.model.app.q.k(bundle, optString3);
                                                        launchIntentForPackage.putExtras(bundle);
                                                        launchIntentForPackage.addFlags(268435456);
                                                        amVar.hj(com.tencent.mm.pluginsdk.model.app.h.a(context, launchIntentForPackage, null, amVar, bundle));
                                                        AppMethodBeat.o(186912);
                                                        return;
                                                    }
                                                } catch (Exception e2) {
                                                    Log.e("LiteAppJsApiLaunchApplication", "launchApplication getLaunchIntentForPackage, %s", e2.getMessage());
                                                }
                                            }
                                        }
                                        WXAppExtendObject wXAppExtendObject = new WXAppExtendObject();
                                        wXAppExtendObject.extInfo = optString6;
                                        WXMediaMessage wXMediaMessage = new WXMediaMessage(wXAppExtendObject);
                                        wXMediaMessage.sdkVer = Build.SDK_INT;
                                        wXMediaMessage.messageExt = optString6;
                                        lp lpVar = new lp();
                                        lpVar.dQT.dCE = wXMediaMessage;
                                        lpVar.dQT.appId = optString;
                                        lpVar.dQT.dDG = ceb.xGz;
                                        lpVar.dQT.context = context;
                                        lpVar.dQT.dFP = bundle;
                                        lpVar.dQT.dQV = amVar;
                                        EventCenter.instance.publish(lpVar);
                                        boolean z2 = lpVar.dQU.dQW;
                                        if (!z2 && !Util.isNullOrNil(optString) && !Util.isNullOrNil(optString3)) {
                                            String str3 = optString + "://" + optString3;
                                            Intent intent2 = new Intent("android.intent.action.VIEW", Uri.parse(str3));
                                            Log.i("LiteAppJsApiLaunchApplication", "launchApplication by opensdk failed, try to launch by scheme(%s).", str3);
                                            intent2.addFlags(268435456);
                                            List<ResolveInfo> queryIntentActivities2 = Util.queryIntentActivities(context, intent2);
                                            if (queryIntentActivities2 != null && !queryIntentActivities2.isEmpty()) {
                                                if (!TextUtils.isEmpty(intent2.getPackage()) || queryIntentActivities2.size() != 1) {
                                                    str = intent2.getPackage();
                                                } else {
                                                    str = com.tencent.mm.pluginsdk.model.app.h.b(queryIntentActivities2.get(0));
                                                }
                                                if (!Util.nullAsNil(MMApplicationContext.getPackageName()).equals(str)) {
                                                    amVar.reset();
                                                    z = com.tencent.mm.pluginsdk.model.app.h.a(context, intent2, null, amVar, bundle);
                                                    amVar.hj(z);
                                                    AppMethodBeat.o(186912);
                                                    return;
                                                }
                                            }
                                        }
                                        z = z2;
                                        amVar.hj(z);
                                        AppMethodBeat.o(186912);
                                        return;
                                    case 1:
                                    default:
                                        h.this.yEn.aCS("check fail");
                                        AppMethodBeat.o(186912);
                                        return;
                                    case 2:
                                        h.this.yEn.aCS("check fail forbidden scene");
                                        AppMethodBeat.o(186912);
                                        return;
                                }
                            } else {
                                h.this.yEn.aCS("check fail");
                                AppMethodBeat.o(186912);
                            }
                        }
                    });
                    AppMethodBeat.o(186913);
                    return 0;
                }
            });
            AppMethodBeat.o(186914);
            return;
        }
        Log.e("LiteAppJsApiLaunchApplication", "appid and scheme is null or nil");
        this.yEn.aCS("fail");
        AppMethodBeat.o(186914);
    }
}
