package com.tencent.mm.plugin.game.luggage.e.a;

import android.content.Context;
import com.tencent.luggage.d.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.protocal.protobuf.coq;
import org.json.JSONObject;

public final class e extends a {
    public e() {
        super(10);
    }

    @Override // com.tencent.mm.plugin.game.luggage.e.a.a
    public final void a(Context context, g gVar, final coq coq) {
        AppMethodBeat.i(83108);
        gVar.ctS.a(new d() {
            /* class com.tencent.mm.plugin.game.luggage.e.a.e.AnonymousClass1 */

            @Override // com.tencent.luggage.d.d
            public final String name() {
                return "onCustomGameMenuClicked";
            }

            @Override // com.tencent.luggage.d.d
            public final JSONObject Ld() {
                AppMethodBeat.i(83107);
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("itemId", coq.MuO);
                    AppMethodBeat.o(83107);
                    return jSONObject;
                } catch (Exception e2) {
                    AppMethodBeat.o(83107);
                    return null;
                }
            }
        });
        AppMethodBeat.o(83108);
    }
}
