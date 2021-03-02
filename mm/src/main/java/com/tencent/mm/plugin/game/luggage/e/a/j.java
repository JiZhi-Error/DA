package com.tencent.mm.plugin.game.luggage.e.a;

import android.content.Context;
import com.tencent.luggage.d.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.plugin.webview.luggage.jsapi.bb;
import com.tencent.mm.protocal.protobuf.coq;
import org.json.JSONObject;

public final class j extends a {
    public j() {
        super(3);
    }

    @Override // com.tencent.mm.plugin.game.luggage.e.a.a
    public final void a(Context context, g gVar, coq coq) {
        AppMethodBeat.i(83115);
        bb.afY(0);
        gVar.ctS.a(new d() {
            /* class com.tencent.mm.plugin.game.luggage.e.a.j.AnonymousClass1 */

            @Override // com.tencent.luggage.d.d
            public final String name() {
                return "menu:share:appmessage";
            }

            @Override // com.tencent.luggage.d.d
            public final JSONObject Ld() {
                return null;
            }
        });
        AppMethodBeat.o(83115);
    }
}
