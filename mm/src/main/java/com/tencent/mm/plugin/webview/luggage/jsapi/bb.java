package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import com.tencent.luggage.d.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.av.d;
import com.tencent.mm.av.q;
import com.tencent.mm.g.a.cz;
import com.tencent.mm.g.a.tt;
import com.tencent.mm.g.a.tw;
import com.tencent.mm.model.ab;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.plugin.webview.luggage.jsapi.br;
import com.tencent.mm.plugin.webview.model.c;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.i;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.snackbar.a;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import org.json.JSONObject;

public class bb extends bs<g> {
    private static int ehW;

    public static void afY(int i2) {
        ehW = i2;
    }

    public static int gcm() {
        return ehW;
    }

    public static void gcn() {
        ehW = 0;
    }

    @Override // com.tencent.luggage.d.b
    public final String name() {
        return "sendAppMessage";
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final int dTs() {
        return 2;
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final void b(b<g>.a aVar) {
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final void a(final Context context, String str, final br.a aVar) {
        final JSONObject jSONObject;
        AppMethodBeat.i(78620);
        Log.d("MicroMsg.JsApiSendAppMessage", "invokeInMM");
        try {
            jSONObject = new JSONObject(str);
        } catch (Exception e2) {
            jSONObject = null;
        }
        if (jSONObject == null) {
            aVar.i("data is null", null);
            AppMethodBeat.o(78620);
            return;
        }
        switch (jSONObject.optInt("sendAppMessageScene", 0)) {
            case 1:
                Log.i("MicroMsg.JsApiSendAppMessage", "favoriteUrl");
                cz czVar = new cz();
                c.a aVar2 = new c.a();
                aVar2.url = jSONObject.optString("shareUrl");
                aVar2.thumbUrl = jSONObject.optString("img_url");
                aVar2.title = jSONObject.optString("title");
                aVar2.desc = jSONObject.optString("desc");
                aVar2.dNI = jSONObject.optString("appid");
                if (context != null && (context instanceof MMActivity)) {
                    czVar.dFZ.activity = (Activity) context;
                    czVar.dFZ.dGf = 36;
                }
                czVar.dFZ.dGh = new a.c() {
                    /* class com.tencent.mm.plugin.webview.luggage.jsapi.bb.AnonymousClass1 */

                    @Override // com.tencent.mm.ui.widget.snackbar.a.c
                    public final void onShow() {
                    }

                    @Override // com.tencent.mm.ui.widget.snackbar.a.c
                    public final void onHide() {
                        AppMethodBeat.i(78618);
                        Log.d("MicroMsg.JsApiSendAppMessage", "onHide");
                        aVar.i(null, null);
                        AppMethodBeat.o(78618);
                    }

                    @Override // com.tencent.mm.ui.widget.snackbar.a.c
                    public final void bDY() {
                    }
                };
                c.a(czVar, aVar2);
                EventCenter.instance.publish(czVar);
                if (czVar.dGa.ret != 0) {
                    aVar.i("fail", null);
                }
                AppMethodBeat.o(78620);
                return;
            default:
                i.baY(jSONObject.optString("img_url"));
                HashMap hashMap = new HashMap();
                hashMap.put("img_url", jSONObject.optString("img_url"));
                hashMap.put("desc", jSONObject.optString("desc"));
                hashMap.put("title", jSONObject.optString("title"));
                hashMap.put("url", jSONObject.optString("shareUrl"));
                Intent intent = new Intent();
                intent.putExtra("Select_Conv_Type", 3);
                intent.putExtra("scene_from", 2);
                intent.putExtra("mutil_select_is_ret", true);
                intent.putExtra("webview_params", hashMap);
                intent.putExtra("Retr_Msg_Type", 2);
                com.tencent.mm.br.c.a((MMActivity) context, ".ui.transmit.SelectConversationUI", intent, 1, new MMActivity.a() {
                    /* class com.tencent.mm.plugin.webview.luggage.jsapi.bb.AnonymousClass2 */

                    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
                    @Override // com.tencent.mm.ui.MMActivity.a
                    public final void d(int i2, int i3, Intent intent) {
                        String stringExtra;
                        AppMethodBeat.i(78619);
                        if (i2 == 1) {
                            String optString = jSONObject.optString("appid");
                            switch (i3) {
                                case -1:
                                    if (intent == null) {
                                        stringExtra = null;
                                    } else {
                                        stringExtra = intent.getStringExtra("Select_Conv_User");
                                    }
                                    if (stringExtra == null || stringExtra.length() == 0) {
                                        Log.e("MicroMsg.JsApiSendAppMessage", "mmOnActivityResult fail, toUser is null");
                                        aVar.i("fail", null);
                                        AppMethodBeat.o(78619);
                                        return;
                                    } else if (Util.isNullOrNil(stringExtra)) {
                                        Log.e("MicroMsg.JsApiSendAppMessage", "toUser is null");
                                        AppMethodBeat.o(78619);
                                        return;
                                    } else {
                                        q.bcQ();
                                        Bitmap EP = d.EP(jSONObject.optString("img_url"));
                                        WXMediaMessage bZ = bb.bZ(jSONObject);
                                        if (EP != null && !EP.isRecycled()) {
                                            Log.i("MicroMsg.JsApiSendAppMessage", "thumb image is not null");
                                            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                                            EP.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                                            bZ.thumbData = byteArrayOutputStream.toByteArray();
                                        }
                                        com.tencent.mm.pluginsdk.model.app.g o = h.o(optString, true, false);
                                        tt ttVar = new tt();
                                        ttVar.eaf.dCE = bZ;
                                        ttVar.eaf.appId = optString;
                                        ttVar.eaf.appName = o == null ? "" : o.field_appName;
                                        ttVar.eaf.toUser = stringExtra;
                                        ttVar.eaf.dMG = 2;
                                        if (Util.isNullOrNil(jSONObject.optString("src_username"))) {
                                            ttVar.eaf.eai = null;
                                        } else {
                                            ttVar.eaf.eag = jSONObject.optString("src_username");
                                            ttVar.eaf.eah = jSONObject.optString("src_displayname");
                                        }
                                        ttVar.eaf.eaj = jSONObject.optString("shareUrl");
                                        ttVar.eaf.eak = jSONObject.optString("currentUrl");
                                        ttVar.eaf.eal = jSONObject.optString("preVerifyAppId");
                                        EventCenter.instance.publish(ttVar);
                                        String stringExtra2 = intent.getStringExtra("custom_send_text");
                                        if (!Util.isNullOrNil(stringExtra2)) {
                                            tw twVar = new tw();
                                            twVar.eaq.dkV = stringExtra;
                                            twVar.eaq.content = stringExtra2;
                                            twVar.eaq.type = ab.JG(stringExtra);
                                            twVar.eaq.flags = 0;
                                            EventCenter.instance.publish(twVar);
                                        }
                                        com.tencent.mm.ui.base.h.cD(context, context.getResources().getString(R.string.z0));
                                        aVar.i(null, null);
                                        AppMethodBeat.o(78619);
                                        return;
                                    }
                                case 0:
                                case 1:
                                    aVar.i("cancel", null);
                                    AppMethodBeat.o(78619);
                                    return;
                                default:
                                    aVar.i("fail", null);
                                    break;
                            }
                        }
                        AppMethodBeat.o(78619);
                    }
                });
                AppMethodBeat.o(78620);
                return;
        }
    }

    static /* synthetic */ WXMediaMessage bZ(JSONObject jSONObject) {
        AppMethodBeat.i(78621);
        WXWebpageObject wXWebpageObject = new WXWebpageObject();
        wXWebpageObject.webpageUrl = jSONObject.optString("link");
        wXWebpageObject.extInfo = jSONObject.optString("review_data");
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.mediaObject = wXWebpageObject;
        wXMediaMessage.title = jSONObject.optString("title");
        wXMediaMessage.description = jSONObject.optString("desc");
        AppMethodBeat.o(78621);
        return wXMediaMessage;
    }
}
