package com.tencent.mm.plugin.appbrand.jsapi.appdownload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.game.preload.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.o.a.b;
import com.tencent.mm.plugin.appbrand.s.b;
import com.tencent.mm.plugin.appbrand.s.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;
import org.json.JSONObject;

public final class e extends b {
    public static final int CTRL_INDEX = 269;
    public static final String NAME = "createDownloadTask";

    public e(b.AbstractC0793b bVar) {
        super(bVar);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.o.a.b
    public final com.tencent.mm.plugin.appbrand.jsapi.o.a.a a(b.AbstractC0793b bVar) {
        AppMethodBeat.i(180202);
        a aVar = new a(bVar, this.mgb);
        AppMethodBeat.o(180202);
        return aVar;
    }

    static class a extends com.tencent.mm.plugin.appbrand.jsapi.o.a.a {
        public a(b.AbstractC0793b bVar, com.tencent.mm.plugin.appbrand.jsapi.base.a aVar) {
            super(bVar, aVar);
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.o.a.a
        public final void a(f fVar, com.tencent.mm.plugin.appbrand.s.a aVar, boolean z, JSONObject jSONObject, int i2, Map<String, String> map, b.a aVar2, String str) {
            m mVar;
            AppMethodBeat.i(180201);
            String optString = jSONObject.optString("url");
            if (Util.isNullOrNil(optString)) {
                Log.i("MicroMsg.JsApiCreateDownloadTaskGame", "url is null");
                b(fVar, str, "url is null or nil");
                AppMethodBeat.o(180201);
                return;
            }
            d bDu = d.bDu();
            if (bDu == null || !bDu.YQ(optString) || (mVar = bDu.ltR) == null) {
                super.a(fVar, aVar, z, jSONObject, i2, map, aVar2, str);
                AppMethodBeat.o(180201);
                return;
            }
            mVar.a(jSONObject, i2, map, z ? aVar.cyW : null, aVar.lcM, aVar2, str, "createDownloadTask");
            AppMethodBeat.o(180201);
        }
    }
}
