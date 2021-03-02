package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.content.Intent;
import android.content.pm.Signature;
import android.os.Bundle;
import com.tencent.luggage.d.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.lp;
import com.tencent.mm.opensdk.constants.Build;
import com.tencent.mm.opensdk.modelmsg.WXAppExtendObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.webview.a.a;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.plugin.webview.luggage.jsapi.br;
import com.tencent.mm.pluginsdk.model.app.al;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.sqlitelint.behaviour.persistence.IssueStorage;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore;
import org.json.JSONObject;

public class af extends bs<g> {
    @Override // com.tencent.luggage.d.b
    public final String name() {
        return "launch3rdApp";
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final int dTs() {
        return 2;
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final void b(b<g>.a aVar) {
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final void a(Context context, String str, final br.a aVar) {
        String messageDigest;
        AppMethodBeat.i(78573);
        Log.i("MicroMsg.JsApiLaunch3RdApp", "invokeInMM");
        JSONObject Zc = com.tencent.mm.plugin.webview.luggage.c.b.Zc(str);
        if (Zc == null) {
            aVar.i("invalid_data", null);
            AppMethodBeat.o(78573);
            return;
        }
        int optInt = Zc.optInt("type");
        String optString = Zc.optString("appID");
        if (optInt == 0) {
            String optString2 = Zc.optString(IssueStorage.COLUMN_EXT_INFO);
            Log.i("MicroMsg.JsApiLaunch3RdApp", "appid:[%s], extinfo:[%s]", optString, optString2);
            if (Util.isNullOrNil(optString)) {
                Log.e("MicroMsg.JsApiLaunch3RdApp", "appid is null or nil");
                aVar.i("fail", null);
                AppMethodBeat.o(78573);
            } else if (!a.jRu.s(MMApplicationContext.getContext(), optString)) {
                Log.e("MicroMsg.JsApiLaunch3RdApp", "app is not installed, appid:[%s]", optString);
                aVar.i("fail", null);
                AppMethodBeat.o(78573);
            } else {
                WXAppExtendObject wXAppExtendObject = new WXAppExtendObject();
                wXAppExtendObject.extInfo = optString2;
                WXMediaMessage wXMediaMessage = new WXMediaMessage(wXAppExtendObject);
                wXMediaMessage.sdkVer = Build.SDK_INT;
                wXMediaMessage.messageExt = optString2;
                lp lpVar = new lp();
                lpVar.dQT.dCE = wXMediaMessage;
                lpVar.dQT.appId = optString;
                lpVar.dQT.context = context;
                lpVar.dQT.dQV = new al() {
                    /* class com.tencent.mm.plugin.webview.luggage.jsapi.af.AnonymousClass1 */

                    @Override // com.tencent.mm.pluginsdk.model.app.al
                    public final void v(boolean z, boolean z2) {
                        AppMethodBeat.i(210945);
                        aVar.i(null, null);
                        AppMethodBeat.o(210945);
                    }
                };
                EventCenter.instance.publish(lpVar);
                AppMethodBeat.o(78573);
            }
        } else if (optInt == 1) {
            String optString3 = Zc.optString("signature");
            String optString4 = Zc.optString(AssistantStore.DownloadInfos.DownloadInfoColumns.PACKAGENAME);
            String optString5 = Zc.optString("param");
            Log.i("MicroMsg.JsApiLaunch3RdApp", "doLaunch3RdApp, signature:[%s], packageName:[%s], param:[%s]", optString3, optString4, optString5);
            if (Util.isNullOrNil(optString3) || Util.isNullOrNil(optString4)) {
                Log.e("MicroMsg.JsApiLaunch3RdApp", "doLaunch3RdApp invalid_args");
                aVar.i("invalid_args", null);
                AppMethodBeat.o(78573);
            } else if (!q.s(context, optString4)) {
                Log.e("MicroMsg.JsApiLaunch3RdApp", "doLaunch3RdApp not_install");
                aVar.i("not_install", null);
                AppMethodBeat.o(78573);
            } else {
                Signature[] cj = q.cj(context, optString4);
                if (cj == null || cj[0] == null || (messageDigest = com.tencent.mm.b.g.getMessageDigest(cj[0].toByteArray())) == null || !messageDigest.equalsIgnoreCase(optString3)) {
                    Log.e("MicroMsg.JsApiLaunch3RdApp", "doLaunch3RdApp signature_mismatch");
                    aVar.i("signature_mismatch", null);
                    AppMethodBeat.o(78573);
                    return;
                }
                String optString6 = Zc.optString("currentUrl");
                String optString7 = Zc.optString("preVerifyAppId");
                try {
                    Intent launchIntentForPackage = MMApplicationContext.getContext().getPackageManager().getLaunchIntentForPackage(optString4);
                    if (launchIntentForPackage != null) {
                        Bundle bundle = new Bundle();
                        q.k(bundle, optString5);
                        launchIntentForPackage.putExtras(bundle);
                        launchIntentForPackage.addFlags(268435456);
                        Bundle bundle2 = new Bundle();
                        bundle2.putString("current_page_url", optString6);
                        bundle2.putString("current_page_appid", optString7);
                        h.a(context, launchIntentForPackage, null, new al() {
                            /* class com.tencent.mm.plugin.webview.luggage.jsapi.af.AnonymousClass2 */

                            @Override // com.tencent.mm.pluginsdk.model.app.al
                            public final void v(boolean z, boolean z2) {
                                AppMethodBeat.i(210946);
                                aVar.i(null, null);
                                AppMethodBeat.o(210946);
                            }
                        }, bundle2);
                        AppMethodBeat.o(78573);
                        return;
                    }
                } catch (Exception e2) {
                    Log.e("MicroMsg.JsApiLaunch3RdApp", "doLaunch3RdApp getLaunchIntentForPackage, %s", e2.getMessage());
                }
                aVar.i("fail", null);
                AppMethodBeat.o(78573);
            }
        } else {
            aVar.i("invalid_type", null);
            AppMethodBeat.o(78573);
        }
    }
}
