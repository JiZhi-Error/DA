package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import android.content.Intent;
import com.tencent.luggage.d.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.downloader_app.api.a;
import com.tencent.mm.plugin.downloader_app.api.c;
import com.tencent.mm.plugin.game.luggage.g.i;
import com.tencent.mm.plugin.webview.luggage.jsapi.br;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public class t extends br<i> {
    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final int dTs() {
        return 2;
    }

    @Override // com.tencent.luggage.d.b
    public final String name() {
        return "jumpDownloaderWidget";
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final void b(b<i>.a aVar) {
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final void a(Context context, String str, final br.a aVar) {
        JSONObject jSONObject;
        String str2;
        AppMethodBeat.i(83076);
        try {
            jSONObject = new JSONObject(str);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.JsApiJumpDownloaderWidget", e2, "", new Object[0]);
            jSONObject = null;
        }
        if (jSONObject != null) {
            str2 = jSONObject.optString("appId");
        } else {
            str2 = "";
        }
        Intent intent = new Intent();
        intent.putExtra("appId", str2);
        intent.putExtra("view_task", true);
        intent.addFlags(268435456);
        ((c) g.af(c.class)).a(context, intent, new a.c() {
            /* class com.tencent.mm.plugin.game.luggage.b.t.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.downloader_app.api.a.c
            public final void bEx() {
                AppMethodBeat.i(83075);
                aVar.i(null, null);
                AppMethodBeat.o(83075);
            }
        });
        AppMethodBeat.o(83076);
    }
}
