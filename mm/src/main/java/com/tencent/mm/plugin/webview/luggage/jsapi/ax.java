package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.d.b;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.luggage.jsapi.br;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class ax extends br {
    @Override // com.tencent.luggage.d.b
    public final String name() {
        return "reportIDKey";
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final int dTs() {
        return 0;
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final void a(Context context, String str, br.a aVar) {
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final void b(b.a aVar) {
        AppMethodBeat.i(78611);
        JSONArray optJSONArray = aVar.ctb.csi.optJSONArray("idKeyDataInfo");
        if (optJSONArray == null || optJSONArray.length() == 0) {
            Log.e("MicroMsg.JsApiReportIDKey", "idkey data is null");
            aVar.c("invaild_parms", null);
            AppMethodBeat.o(78611);
            return;
        }
        ArrayList<IDKey> arrayList = new ArrayList<>();
        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
            IDKey iDKey = new IDKey();
            iDKey.SetID(Util.getInt(optJSONObject.optString("id"), 0));
            iDKey.SetKey(Util.getInt(optJSONObject.optString("key"), 0));
            iDKey.SetValue((long) Util.getInt(optJSONObject.optString("value"), 0));
            arrayList.add(iDKey);
        }
        if (arrayList.size() > 0) {
            h.INSTANCE.b(arrayList, true);
        }
        aVar.c("", null);
        AppMethodBeat.o(78611);
    }
}
