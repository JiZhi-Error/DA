package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.content.Intent;
import com.tencent.luggage.d.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.plugin.webview.luggage.jsapi.br;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import org.json.JSONException;
import org.json.JSONObject;

public class f extends bs<g> {
    @Override // com.tencent.luggage.d.b
    public final String name() {
        return "batchViewCard";
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
        AppMethodBeat.i(78523);
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("card_list");
            String optString2 = jSONObject.optString("tempalate_id");
            Intent intent = new Intent();
            intent.putExtra("card_list", optString);
            intent.putExtra("key_template_id", optString2);
            intent.putExtra("key_from_scene", 7);
            ((MMActivity) context).mmSetOnActivityResultCallback(new MMActivity.a() {
                /* class com.tencent.mm.plugin.webview.luggage.jsapi.f.AnonymousClass1 */

                @Override // com.tencent.mm.ui.MMActivity.a
                public final void d(int i2, int i3, Intent intent) {
                    AppMethodBeat.i(78522);
                    if (i2 == (f.this.hashCode() & 65535)) {
                        if (i3 == -1) {
                            aVar.i(null, null);
                            AppMethodBeat.o(78522);
                            return;
                        }
                        aVar.i("fail", null);
                    }
                    AppMethodBeat.o(78522);
                }
            });
            c.a(context, "card", ".ui.CardViewEntranceUI", intent, 65535 & hashCode(), false);
            AppMethodBeat.o(78523);
        } catch (JSONException e2) {
            Log.e("MicroMsg.JsApiBatchViewCard", "paras data error: " + e2.getMessage());
            aVar.i("fail", null);
            AppMethodBeat.o(78523);
        }
    }
}
