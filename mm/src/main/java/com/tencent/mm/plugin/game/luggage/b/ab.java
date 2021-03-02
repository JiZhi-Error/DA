package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import com.facebook.share.internal.ShareConstants;
import com.tencent.luggage.d.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.api.d;
import com.tencent.mm.plugin.game.luggage.g.i;
import com.tencent.mm.plugin.webview.luggage.jsapi.br;
import com.tencent.mm.plugin.webview.luggage.jsapi.bs;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ab extends bs<i> {
    @Override // com.tencent.luggage.d.b
    public final String name() {
        return "publishHaowanEdition";
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
        String a2;
        AppMethodBeat.i(83085);
        Log.i("MicroMsg.JsApiPublishHaowanEdition", "invokeInMM");
        JSONObject Zc = com.tencent.mm.plugin.webview.luggage.c.b.Zc(str);
        if (Zc == null) {
            aVar.i("invalid_data", null);
            AppMethodBeat.o(83085);
            return;
        }
        String optString = Zc.optString(ShareConstants.RESULT_POST_ID);
        boolean optBoolean = Zc.optBoolean("compressImg", true);
        if (!Util.isNullOrNil(optString)) {
            a2 = ((d) g.af(d.class)).azm(optString);
        } else {
            JSONArray optJSONArray = Zc.optJSONArray("localIds");
            a2 = ((d) g.af(d.class)).a(Zc.optInt("from"), Zc.optInt("postType"), optJSONArray, Zc.optString("extra"), optBoolean, Zc.optInt("sourceSceneId"));
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(ShareConstants.RESULT_POST_ID, a2);
        } catch (JSONException e2) {
        }
        aVar.i(null, jSONObject);
        AppMethodBeat.o(83085);
    }
}
