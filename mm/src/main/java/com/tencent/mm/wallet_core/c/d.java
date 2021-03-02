package com.tencent.mm.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

public final class d {
    public String Rtr = "";
    public String Rts = "";
    public String Rtt = "";
    public String dNA = "";
    public String title = "";

    public d(String str) {
        AppMethodBeat.i(72741);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(72741);
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.title = jSONObject.optString("title");
            this.Rtr = jSONObject.optString("body1");
            this.Rts = jSONObject.optString("body2");
            this.Rtt = jSONObject.optString("button");
            AppMethodBeat.o(72741);
        } catch (Exception e2) {
            Log.e("MicroMsg.CrtRtnWoding", "crtwoding error %s", e2.getMessage());
            AppMethodBeat.o(72741);
        }
    }

    public d() {
    }
}
