package com.tencent.mm.plugin.card.d;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.model.f;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONException;
import org.json.JSONObject;

public final class i {
    public static f akc(String str) {
        AppMethodBeat.i(113804);
        if (TextUtils.isEmpty(str)) {
            Log.e("MicroMsg.CardMallItemParser", "parseCardMallItem jsonContent is null");
            AppMethodBeat.o(113804);
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            f fVar = new f();
            fVar.pTq = jSONObject.optString("empty_tips");
            fVar.pTr = jSONObject.optString("shoppingmall_title");
            fVar.pTs = jSONObject.optString("shoppingmall_url");
            fVar.pTt = jSONObject.optInt("is_show") != 0;
            AppMethodBeat.o(113804);
            return fVar;
        } catch (JSONException e2) {
            Log.printErrStackTrace("MicroMsg.CardMallItemParser", e2, "", new Object[0]);
            AppMethodBeat.o(113804);
            return null;
        }
    }
}
