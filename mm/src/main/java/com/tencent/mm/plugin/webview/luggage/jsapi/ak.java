package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.content.Intent;
import com.tencent.luggage.d.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.contact.c;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.webview.luggage.jsapi.br;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import org.json.JSONException;
import org.json.JSONObject;

public class ak extends br {
    @Override // com.tencent.luggage.d.b
    public final String name() {
        return "openBizChat";
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final int dTs() {
        return 1;
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final void b(b.a aVar) {
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final void a(Context context, String str, br.a aVar) {
        AppMethodBeat.i(78586);
        try {
            String optString = new JSONObject(str).optString(ch.COL_USERNAME);
            if (Util.isNullOrNil(optString)) {
                aVar.i("param_err", null);
                AppMethodBeat.o(78586);
                return;
            }
            as Kn = ((l) g.af(l.class)).aSN().Kn(optString);
            if (Kn == null || !Kn.gBM()) {
                aVar.i("not biz username", null);
                AppMethodBeat.o(78586);
            } else if (!c.oR(Kn.field_type)) {
                aVar.i("open_biz_chat", null);
                AppMethodBeat.o(78586);
            } else {
                Intent intent = new Intent();
                intent.putExtra("Chat_User", optString);
                intent.putExtra("finish_direct", true);
                com.tencent.mm.br.c.f(context, ".ui.chatting.ChattingUI", intent);
                aVar.i(null, null);
                AppMethodBeat.o(78586);
            }
        } catch (JSONException e2) {
            Log.e("MicroMsg.JsApiOpenBizChat", "parase json fail");
            aVar.i("fail", null);
            AppMethodBeat.o(78586);
        }
    }
}
