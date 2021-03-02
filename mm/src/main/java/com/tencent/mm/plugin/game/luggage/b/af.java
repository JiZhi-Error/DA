package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import com.tencent.luggage.d.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.av.d;
import com.tencent.mm.av.q;
import com.tencent.mm.br.c;
import com.tencent.mm.g.a.tt;
import com.tencent.mm.g.a.tw;
import com.tencent.mm.model.ab;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.game.luggage.g.i;
import com.tencent.mm.plugin.webview.luggage.jsapi.br;
import com.tencent.mm.plugin.webview.luggage.jsapi.bs;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import org.json.JSONObject;

public class af extends bs<i> {
    @Override // com.tencent.luggage.d.b
    public final String name() {
        return "sendGameNameCard";
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final int dTs() {
        return 2;
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final void b(b<i>.a aVar) {
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final void a(final Context context, String str, final br.a aVar) {
        final JSONObject jSONObject;
        AppMethodBeat.i(186883);
        Log.d("MicroMsg.JsApiSendGameNameCard", "invokeInMM");
        try {
            jSONObject = new JSONObject(str);
        } catch (Exception e2) {
            jSONObject = null;
        }
        if (jSONObject == null) {
            aVar.i("data is null", null);
            AppMethodBeat.o(186883);
            return;
        }
        com.tencent.mm.plugin.webview.ui.tools.jsapi.i.baY(jSONObject.optString("img_url"));
        HashMap hashMap = new HashMap();
        hashMap.put("img_url", jSONObject.optString("img_url"));
        hashMap.put("desc", jSONObject.optString("desc"));
        hashMap.put("title", jSONObject.optString("title"));
        hashMap.put("url", jSONObject.optString("shareUrl"));
        hashMap.put("nickname", jSONObject.optString("card_nick_name"));
        Intent intent = new Intent();
        intent.putExtra("Select_Conv_Type", 3);
        intent.putExtra("scene_from", 2);
        intent.putExtra("mutil_select_is_ret", true);
        intent.putExtra("webview_params", hashMap);
        intent.putExtra("is_game_card", true);
        intent.putExtra("Retr_Msg_Type", 2);
        c.a((MMActivity) context, ".ui.transmit.SelectConversationUI", intent, 1, new MMActivity.a() {
            /* class com.tencent.mm.plugin.game.luggage.b.af.AnonymousClass1 */

            /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
            @Override // com.tencent.mm.ui.MMActivity.a
            public final void d(int i2, int i3, Intent intent) {
                String stringExtra;
                AppMethodBeat.i(186882);
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
                                Log.e("MicroMsg.JsApiSendGameNameCard", "mmOnActivityResult fail, toUser is null");
                                aVar.i("fail", null);
                                AppMethodBeat.o(186882);
                                return;
                            } else if (Util.isNullOrNil(stringExtra)) {
                                Log.e("MicroMsg.JsApiSendGameNameCard", "toUser is null");
                                AppMethodBeat.o(186882);
                                return;
                            } else {
                                q.bcQ();
                                Bitmap EP = d.EP(jSONObject.optString("img_url"));
                                WXMediaMessage aS = af.aS(jSONObject);
                                if (EP != null && !EP.isRecycled()) {
                                    Log.i("MicroMsg.JsApiSendGameNameCard", "thumb image is not null");
                                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                                    EP.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                                    aS.thumbData = byteArrayOutputStream.toByteArray();
                                }
                                g o = h.o(optString, true, false);
                                tt ttVar = new tt();
                                ttVar.eaf.dCE = aS;
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
                                AppMethodBeat.o(186882);
                                return;
                            }
                        case 0:
                        case 1:
                            aVar.i("cancel", null);
                            AppMethodBeat.o(186882);
                            return;
                        default:
                            aVar.i("fail", null);
                            break;
                    }
                }
                AppMethodBeat.o(186882);
            }
        });
        AppMethodBeat.o(186883);
    }

    static /* synthetic */ WXMediaMessage aS(JSONObject jSONObject) {
        AppMethodBeat.i(186884);
        com.tencent.mm.plugin.game.luggage.f.b bVar = new com.tencent.mm.plugin.game.luggage.f.b();
        bVar.webpageUrl = jSONObject.optString("link");
        bVar.extInfo = jSONObject.optString("review_data");
        bVar.iconUrl = jSONObject.optString("card_image_url");
        bVar.nickName = jSONObject.optString("card_nick_name");
        bVar.desc = jSONObject.optString("card_desc");
        bVar.xxN = jSONObject.optString("card_tail");
        bVar.jumpUrl = jSONObject.optString("card_link");
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.mediaObject = bVar;
        wXMediaMessage.title = jSONObject.optString("title");
        wXMediaMessage.description = jSONObject.optString("desc");
        AppMethodBeat.o(186884);
        return wXMediaMessage;
    }
}
