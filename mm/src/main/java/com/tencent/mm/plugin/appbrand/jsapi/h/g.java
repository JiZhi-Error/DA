package com.tencent.mm.plugin.appbrand.jsapi.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.plugin.appbrand.widget.input.o;
import org.json.JSONObject;

public final class g extends d<s> {
    private static final int CTRL_INDEX = 77;
    private static final String NAME = "setKeyboardValue";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(s sVar, JSONObject jSONObject, int i2) {
        Integer num;
        AppMethodBeat.i(136274);
        s sVar2 = sVar;
        ac currentPageView = sVar2.getCurrentPageView();
        if (currentPageView == null || !currentPageView.isRunning()) {
            sVar2.i(i2, h("fail current page not available", null));
            AppMethodBeat.o(136274);
            return;
        }
        try {
            String string = jSONObject.getString("value");
            try {
                num = Integer.valueOf(jSONObject.getInt("cursor"));
            } catch (Exception e2) {
                num = null;
            }
            o.a(currentPageView, string, num);
            sVar2.i(i2, h("ok", null));
            AppMethodBeat.o(136274);
        } catch (Exception e3) {
            sVar2.i(i2, h("fail:invalid data", null));
            AppMethodBeat.o(136274);
        }
    }
}
