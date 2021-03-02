package com.tencent.mm.plugin.appbrand.jsapi.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.m;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.widget.input.o;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

public final class e extends d<ac> {
    private static final int CTRL_INDEX = 119;
    private static final String NAME = "removeTextArea";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(ac acVar, JSONObject jSONObject, final int i2) {
        AppMethodBeat.i(136271);
        ac acVar2 = acVar;
        try {
            final int i3 = jSONObject.getInt("inputId");
            final WeakReference weakReference = new WeakReference(acVar2);
            m.runOnUiThread(new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.h.e.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(136270);
                    ac acVar = (ac) weakReference.get();
                    if (acVar == null) {
                        AppMethodBeat.o(136270);
                        return;
                    }
                    if (acVar.bRf() != null) {
                        acVar.bRf().hideVKB();
                    }
                    acVar.i(i2, e.this.h(o.b(acVar, i3) ? "ok" : "fail", null));
                    AppMethodBeat.o(136270);
                }
            });
            AppMethodBeat.o(136271);
        } catch (JSONException e2) {
            acVar2.i(i2, h("fail:invalid data", null));
            AppMethodBeat.o(136271);
        }
    }
}
