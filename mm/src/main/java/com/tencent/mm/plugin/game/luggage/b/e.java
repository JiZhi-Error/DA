package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import com.tencent.luggage.d.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.api.d;
import com.tencent.mm.plugin.game.luggage.g.i;
import com.tencent.mm.plugin.webview.luggage.jsapi.br;
import com.tencent.mm.plugin.webview.luggage.jsapi.bs;
import org.json.JSONArray;
import org.json.JSONObject;

public class e extends bs<i> {
    @Override // com.tencent.luggage.d.b
    public final String name() {
        return "cancelHaowanPublish";
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final int dTs() {
        return 1;
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final void b(b<i>.a aVar) {
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final void a(Context context, String str, br.a aVar) {
        AppMethodBeat.i(83054);
        JSONObject Zc = com.tencent.mm.plugin.webview.luggage.c.b.Zc(str);
        if (Zc == null) {
            aVar.i("empty_postId", null);
            AppMethodBeat.o(83054);
            return;
        }
        if (Zc.optBoolean("cancelAll")) {
            ((d) g.af(d.class)).c(null, true);
        } else {
            JSONArray optJSONArray = Zc.optJSONArray("postIdList");
            if (optJSONArray == null || optJSONArray.length() == 0) {
                aVar.i("empty_postId", null);
                AppMethodBeat.o(83054);
                return;
            }
            ((d) g.af(d.class)).c(optJSONArray, false);
        }
        aVar.i(null, null);
        AppMethodBeat.o(83054);
    }
}
