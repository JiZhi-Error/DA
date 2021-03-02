package com.tencent.mm.plugin.appbrand.jsapi.share;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.menu.u;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public final class c extends d<com.tencent.mm.plugin.appbrand.service.c> {
    public static final int CTRL_INDEX = 795;
    public static final String NAME = "hideShareTimelineMenu";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(com.tencent.mm.plugin.appbrand.service.c cVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(180265);
        com.tencent.mm.plugin.appbrand.service.c cVar2 = cVar;
        Log.i("MicroMsg.JsApiHideShareTimelineMenu", "invoke hideShareTimelineMenu");
        if (cVar2 == null) {
            cVar2.i(i2, h("fail", null));
            AppMethodBeat.o(180265);
        } else if (cVar2.bsz() == null) {
            cVar2.i(i2, h("fail", null));
            AppMethodBeat.o(180265);
        } else if (cVar2.bsz().yK(u.ShareToTimeLine.ordinal()) == null) {
            cVar2.i(i2, h("fail", null));
            AppMethodBeat.o(180265);
        } else {
            cVar2.bsz().yK(u.ShareToTimeLine.ordinal()).neT = true;
            cVar2.i(i2, h("ok", null));
            AppMethodBeat.o(180265);
        }
    }
}
