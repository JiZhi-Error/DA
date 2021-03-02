package com.tencent.mm.plugin.appbrand.jsapi.ag.e.b;

import com.tencent.luggage.xweb_ext.extendplugin.component.e;
import com.tencent.luggage.xweb_ext.extendplugin.component.i;
import com.tencent.luggage.xweb_ext.extendplugin.component.video.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.h.b;
import com.tencent.mm.plugin.appbrand.jsapi.ag.a;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public final class g extends d {
    private static final int CTRL_INDEX = 819;
    public static final String NAME = "operateXWebVideoBackground";

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final void a(f fVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(215905);
        b bVar = new b(i2, jSONObject, fVar, this);
        a f2 = e.f(bVar);
        if (f2 == null) {
            Log.w("MicroMsg.AppBrand.JsApiOperateXWebVideoBackground", "audioOfVideoBackgroundPlayManager is null");
            fVar.i(i2, h("fail:audioOfVideoBackgroundPlayManager is null", null));
            AppMethodBeat.o(215905);
            return;
        }
        i bLP = f2.bLP();
        if (bLP == null) {
            Log.w("MicroMsg.AppBrand.JsApiOperateXWebVideoBackground", "videoPlayer is null");
            fVar.i(i2, h("fail:videoPlayer is null", null));
            AppMethodBeat.o(215905);
        } else if (!(bLP instanceof c)) {
            Log.w("MicroMsg.AppBrand.JsApiOperateXWebVideoBackground", "videoPlayer is not VideoPluginHandler");
            fVar.i(i2, h("fail:videoPlayer is not for XwebVideo", null));
            AppMethodBeat.o(215905);
        } else {
            ((c) bLP).h(bVar);
            AppMethodBeat.o(215905);
        }
    }
}
