package com.tencent.mm.plugin.appbrand.jsapi.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.m;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.plugin.appbrand.widget.input.o;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONException;
import org.json.JSONObject;

public final class c extends d {
    public static final int CTRL_INDEX = 70;
    public static final String NAME = "hideKeyboard";

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final void a(final f fVar, JSONObject jSONObject, final int i2) {
        AppMethodBeat.i(136257);
        final Integer num = null;
        try {
            num = Integer.valueOf(jSONObject.getInt("inputId"));
        } catch (JSONException e2) {
        }
        m.runOnUiThread(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.h.c.AnonymousClass1 */

            public final void run() {
                ac acVar;
                AppMethodBeat.i(136256);
                if (!fVar.isRunning()) {
                    AppMethodBeat.o(136256);
                    return;
                }
                f fVar = fVar;
                if (fVar instanceof ac) {
                    acVar = (ac) fVar;
                } else if (fVar instanceof s) {
                    acVar = ((s) fVar).getRuntime().brh().getCurrentPage().getCurrentPageView();
                } else {
                    Log.e("MicroMsg.JsApiHideKeyboard", "invalid component type while calling hide keyboard");
                    acVar = null;
                }
                fVar.i(i2, c.this.h(o.a(acVar, num) ? "ok" : "fail:input not exists", null));
                AppMethodBeat.o(136256);
            }
        });
        AppMethodBeat.o(136257);
    }
}
