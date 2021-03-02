package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.content.Intent;
import com.tencent.luggage.d.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.plugin.webview.luggage.jsapi.br;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import java.util.HashMap;

public class d extends bs<g> {
    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final int dTs() {
        return 0;
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final void a(Context context, String str, br.a aVar) {
    }

    @Override // com.tencent.luggage.d.b
    public final String name() {
        return "batchAddCard";
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final void b(final b<g>.a aVar) {
        AppMethodBeat.i(175740);
        String optString = aVar.ctb.csi.optString("card_list");
        String string = aVar.cta.mParams.getString("srcUsername");
        String url = aVar.cta.getUrl();
        String optString2 = aVar.ctb.csi.optString("consumedCardId");
        aVar.cta.mParams.getString("KTemplateId");
        Log.i("MicroMsg.JsApiBatchAddCard", "doBatchAddCard consumedCardId %s", optString2);
        Intent intent = new Intent();
        intent.putExtra("key_in_card_list", optString);
        intent.putExtra("key_from_scene", 7);
        intent.putExtra("src_username", string);
        intent.putExtra("js_url", url);
        intent.putExtra("key_consumed_card_id", optString2);
        ((MMActivity) aVar.cta.mContext).mmSetOnActivityResultCallback(new MMActivity.a() {
            /* class com.tencent.mm.plugin.webview.luggage.jsapi.d.AnonymousClass1 */

            @Override // com.tencent.mm.ui.MMActivity.a
            public final void d(int i2, int i3, Intent intent) {
                int i4;
                AppMethodBeat.i(175739);
                if (i2 == (d.this.hashCode() & 65535)) {
                    HashMap hashMap = new HashMap();
                    if (intent != null) {
                        hashMap.put("card_list", Util.nullAs(intent.getStringExtra("card_list"), ""));
                    }
                    if (i3 == -1) {
                        aVar.e("", hashMap);
                        AppMethodBeat.o(175739);
                        return;
                    }
                    if (intent != null) {
                        i4 = intent.getIntExtra("result_code", 2);
                    } else {
                        i4 = 2;
                    }
                    if (i4 == 2) {
                        aVar.e("fail", hashMap);
                        AppMethodBeat.o(175739);
                        return;
                    }
                    aVar.e("cancel", hashMap);
                }
                AppMethodBeat.o(175739);
            }
        });
        c.a(aVar.cta.mContext, "card", ".ui.CardAddEntranceUI", intent, hashCode() & 65535, false);
        AppMethodBeat.o(175740);
    }
}
