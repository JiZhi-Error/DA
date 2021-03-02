package com.tencent.mm.plugin.appbrand.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONException;
import org.json.JSONObject;

public final class j implements d {
    public boolean ivg;

    @Override // com.tencent.mm.plugin.appbrand.api.d
    public final String bua() {
        AppMethodBeat.i(194335);
        try {
            new JSONObject();
            String jSONObject = new JSONObject().put("isPrivateMessage", this.ivg).toString();
            AppMethodBeat.o(194335);
            return jSONObject;
        } catch (JSONException e2) {
            Log.printErrStackTrace("MicroMsg.WeAppPrivateMessageNativeExtraData", e2, "", new Object[0]);
            AppMethodBeat.o(194335);
            return "{}";
        }
    }
}
