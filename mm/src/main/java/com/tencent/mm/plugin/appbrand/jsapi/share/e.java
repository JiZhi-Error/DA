package com.tencent.mm.plugin.appbrand.jsapi.share;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.share.JsApiShareAppMessageBase;

public class e extends JsApiShareAppMessageBase<JsApiShareAppMessageBase.d> {
    public static final int CTRL_INDEX = 240;
    public static final String NAME = "shareAppMessageDirectly";

    public e() {
        AppMethodBeat.i(163990);
        AppMethodBeat.o(163990);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.share.JsApiShareAppMessageBase
    public final JsApiShareAppMessageBase.d bIJ() {
        AppMethodBeat.i(174909);
        JsApiShareAppMessageBase.d dVar = new JsApiShareAppMessageBase.d();
        AppMethodBeat.o(174909);
        return dVar;
    }
}
