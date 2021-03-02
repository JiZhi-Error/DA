package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.os.Bundle;
import com.tencent.luggage.d.a;
import com.tencent.luggage.d.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.webview.luggage.ipc.JsApiMMTask;
import com.tencent.mm.plugin.webview.luggage.ipc.d;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import org.json.JSONObject;

public abstract class br<T extends com.tencent.luggage.d.a> extends b<T> {

    public static abstract class a {
        public abstract void i(String str, JSONObject jSONObject);
    }

    public abstract void a(Context context, String str, a aVar);

    public abstract void b(b<T>.a aVar);

    public abstract int dTs();

    @Override // com.tencent.luggage.d.b
    public void a(final b<T>.a aVar) {
        if (dTs() == 1) {
            JsApiMMTask jsApiMMTask = new JsApiMMTask();
            jsApiMMTask.IVw = aVar;
            jsApiMMTask.IVx = getClass().getName();
            jsApiMMTask.lEA = aVar.ctb.csi.toString();
            jsApiMMTask.bDJ();
            AppBrandMainProcessService.a(jsApiMMTask);
        } else if (dTs() == 2) {
            Bundle bundle = new Bundle();
            bundle.putString("jsapi_name", getClass().getName());
            bundle.putString("data", aVar.ctb.csi.toString());
            com.tencent.mm.plugin.webview.luggage.ipc.b.a((MMActivity) aVar.cta.getContext(), bundle, d.class, new com.tencent.mm.plugin.webview.luggage.ipc.a() {
                /* class com.tencent.mm.plugin.webview.luggage.jsapi.br.AnonymousClass1 */

                @Override // com.tencent.mm.plugin.webview.luggage.ipc.a
                public final void v(Bundle bundle) {
                    AppMethodBeat.i(78641);
                    String string = bundle.getString("err_msg");
                    String string2 = bundle.getString("data");
                    if (!Util.isNullOrNil(string)) {
                        aVar.c(string, null);
                        AppMethodBeat.o(78641);
                        return;
                    }
                    try {
                        aVar.c("", new JSONObject(string2));
                        AppMethodBeat.o(78641);
                    } catch (Exception e2) {
                        aVar.c("", null);
                        AppMethodBeat.o(78641);
                    }
                }
            });
        } else {
            b(aVar);
        }
    }
}
