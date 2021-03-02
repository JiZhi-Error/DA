package com.tencent.mm.plugin.lite.jsapi.a;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import com.google.android.gms.actions.SearchIntents;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.d;
import com.tencent.mm.av.q;
import com.tencent.mm.g.a.tt;
import com.tencent.mm.g.a.tw;
import com.tencent.mm.hellhoundlib.b.a;
import com.tencent.mm.model.ab;
import com.tencent.mm.opensdk.modelmsg.WXLiteAppObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.lite.jsapi.b;
import com.tencent.mm.plugin.lite.ui.WxaLiteAppApiProxyUI;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import org.json.JSONObject;

public class c extends b {
    private String appId;
    private JSONObject lnV;

    @Override // com.tencent.mm.plugin.lite.jsapi.b
    public final int dTw() {
        return 1;
    }

    @Override // com.tencent.liteapp.jsapi.a
    public final void a(String str, JSONObject jSONObject) {
        AppMethodBeat.i(198841);
        this.appId = str;
        this.lnV = jSONObject;
        String optString = jSONObject.optString("url");
        jSONObject.optString("path");
        if (optString.isEmpty()) {
            this.yEn.aCS("");
            AppMethodBeat.o(198841);
            return;
        }
        String optString2 = jSONObject.optString("thumbUrl");
        if (!Util.isNullOrNil(optString2) && optString2.startsWith("http")) {
            q.bcQ().a(optString2, null);
        }
        HashMap hashMap = new HashMap();
        if (optString2 == null) {
            optString2 = "";
        }
        hashMap.put("img_url", optString2);
        hashMap.put("desc", jSONObject.optString("desc"));
        hashMap.put("title", jSONObject.optString("title"));
        hashMap.put("url", optString);
        Intent intent = new Intent();
        intent.addFlags(268435456);
        intent.setClass(MMApplicationContext.getContext(), WxaLiteAppApiProxyUI.class);
        intent.putExtra("proxyui_action_code_key", 0);
        intent.putExtra("webview_params", hashMap);
        intent.putExtra("callback_id", com.tencent.mm.plugin.lite.c.a(this));
        Context context = MMApplicationContext.getContext();
        a bl = new a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/lite/jsapi/comms/LiteAppJsApiSendAppMessage", "invoke", "(Ljava/lang/String;Lorg/json/JSONObject;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        context.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/lite/jsapi/comms/LiteAppJsApiSendAppMessage", "invoke", "(Ljava/lang/String;Lorg/json/JSONObject;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(198841);
    }

    @Override // com.tencent.liteapp.jsapi.a
    public final void b(int i2, int i3, Intent intent) {
        AppMethodBeat.i(198842);
        if (i2 == 1) {
            switch (i3) {
                case -1:
                    String optString = this.lnV.optString("url");
                    String stringExtra = intent == null ? null : intent.getStringExtra("Select_Conv_User");
                    if (Util.isNullOrNil(stringExtra)) {
                        Log.e("LiteAppJsApiSendAppMessage", "mmOnActivityResult fail, toUser is null");
                        this.yEn.aCS("");
                        AppMethodBeat.o(198842);
                        return;
                    }
                    q.bcQ();
                    Bitmap EP = d.EP(this.lnV.optString("thumbUrl"));
                    String str = this.appId;
                    JSONObject jSONObject = this.lnV;
                    WXLiteAppObject wXLiteAppObject = new WXLiteAppObject();
                    wXLiteAppObject.userName = str;
                    wXLiteAppObject.path = jSONObject.optString("path");
                    wXLiteAppObject.webpageUrl = jSONObject.optString("url");
                    JSONObject optJSONObject = jSONObject.optJSONObject(SearchIntents.EXTRA_QUERY);
                    if (optJSONObject != null) {
                        wXLiteAppObject.query = optJSONObject.toString();
                    }
                    WXMediaMessage wXMediaMessage = new WXMediaMessage(wXLiteAppObject);
                    wXMediaMessage.title = jSONObject.optString("title");
                    wXMediaMessage.description = jSONObject.optString("desc");
                    if (EP != null && !EP.isRecycled()) {
                        Log.i("LiteAppJsApiSendAppMessage", "thumb image is not null");
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        EP.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                        wXMediaMessage.thumbData = byteArrayOutputStream.toByteArray();
                    }
                    String optString2 = this.lnV.optString("srcId");
                    g o = h.o(optString2, true, false);
                    tt ttVar = new tt();
                    ttVar.eaf.dCE = wXMediaMessage;
                    ttVar.eaf.toUser = stringExtra;
                    ttVar.eaf.dMG = 2;
                    ttVar.eaf.appId = optString2;
                    ttVar.eaf.appName = o == null ? "" : o.field_appName;
                    if (Util.isNullOrNil(this.lnV.optString("src_username"))) {
                        ttVar.eaf.eai = null;
                    } else {
                        ttVar.eaf.eag = this.lnV.optString("src_username");
                        ttVar.eaf.eah = this.lnV.optString("src_displayname");
                    }
                    ttVar.eaf.eak = optString;
                    ttVar.eaf.eaj = optString;
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
                    this.yEn.ecz();
                    AppMethodBeat.o(198842);
                    return;
                case 0:
                case 1:
                    this.yEn.aCS("cancel");
                    AppMethodBeat.o(198842);
                    return;
                default:
                    this.yEn.aCS("");
                    AppMethodBeat.o(198842);
                    return;
            }
        } else {
            this.yEn.aCS("");
            AppMethodBeat.o(198842);
        }
    }
}
