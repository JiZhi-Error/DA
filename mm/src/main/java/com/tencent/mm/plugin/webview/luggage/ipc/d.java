package com.tencent.mm.plugin.webview.luggage.ipc;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.jsapi.br;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public class d implements c {
    @Override // com.tencent.mm.plugin.webview.luggage.ipc.c
    public final void a(Context context, Bundle bundle, final a aVar) {
        AppMethodBeat.i(78494);
        String string = bundle.getString("jsapi_name");
        String string2 = bundle.getString("data");
        if (string == null) {
            Log.e("MicroMsg.JsApiMMActivityTask", "jsapi is null");
            aVar.v(new Bundle());
            AppMethodBeat.o(78494);
            return;
        }
        try {
            ((br) Class.forName(string).newInstance()).a(context, string2, new br.a() {
                /* class com.tencent.mm.plugin.webview.luggage.ipc.d.AnonymousClass1 */

                @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br.a
                public final void i(String str, JSONObject jSONObject) {
                    AppMethodBeat.i(78493);
                    Bundle bundle = new Bundle();
                    bundle.putString("err_msg", str);
                    bundle.putString("data", jSONObject != null ? jSONObject.toString() : "");
                    aVar.v(bundle);
                    AppMethodBeat.o(78493);
                }
            });
            AppMethodBeat.o(78494);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.JsApiMMActivityTask", e2, "", new Object[0]);
            aVar.v(new Bundle());
            AppMethodBeat.o(78494);
        }
    }
}
