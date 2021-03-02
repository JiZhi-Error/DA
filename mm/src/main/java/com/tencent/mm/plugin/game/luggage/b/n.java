package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import com.tencent.luggage.d.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.luggage.g.i;
import com.tencent.mm.plugin.webview.luggage.jsapi.br;
import com.tencent.mm.plugin.wepkg.model.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import org.json.JSONException;
import org.json.JSONObject;

public class n extends br<i> {
    @Override // com.tencent.luggage.d.b
    public final String name() {
        return "getLocalWePkgInfo";
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final int dTs() {
        return 1;
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final void b(b.a aVar) {
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final void a(Context context, String str, final br.a aVar) {
        AppMethodBeat.i(83072);
        Log.i("MicroMsg.JsApiGetLocalWePkgInfo", "invokeInMM");
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.game.luggage.b.n.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(83071);
                com.tencent.mm.plugin.wepkg.model.i.a(new i.a() {
                    /* class com.tencent.mm.plugin.game.luggage.b.n.AnonymousClass1.AnonymousClass1 */

                    @Override // com.tencent.mm.plugin.wepkg.model.i.a
                    public final void aR(JSONObject jSONObject) {
                        AppMethodBeat.i(83070);
                        JSONObject jSONObject2 = new JSONObject();
                        try {
                            jSONObject2.put("wepkg_info", jSONObject);
                        } catch (JSONException e2) {
                        }
                        aVar.i(null, jSONObject2);
                        AppMethodBeat.o(83070);
                    }
                });
                AppMethodBeat.o(83071);
            }
        });
        AppMethodBeat.o(83072);
    }
}
