package com.tencent.mm.plugin.game.luggage.d.a;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader_app.api.a;
import com.tencent.mm.plugin.downloader_app.api.c;
import com.tencent.mm.plugin.lite.jsapi.b;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import org.json.JSONObject;

public class g extends b {
    @Override // com.tencent.mm.plugin.lite.jsapi.b
    public final int dTw() {
        return 1;
    }

    @Override // com.tencent.liteapp.jsapi.a
    public final void a(String str, JSONObject jSONObject) {
        AppMethodBeat.i(186910);
        String str2 = "";
        if (jSONObject != null) {
            str2 = jSONObject.optString("appId");
        }
        Intent intent = new Intent();
        intent.putExtra("appId", str2);
        intent.putExtra("view_task", true);
        intent.addFlags(268435456);
        ((c) com.tencent.mm.kernel.g.af(c.class)).a(MMApplicationContext.getContext(), intent, new a.c() {
            /* class com.tencent.mm.plugin.game.luggage.d.a.g.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.downloader_app.api.a.c
            public final void bEx() {
                AppMethodBeat.i(186909);
                g.this.yEn.ecz();
                AppMethodBeat.o(186909);
            }
        });
        AppMethodBeat.o(186910);
    }
}
