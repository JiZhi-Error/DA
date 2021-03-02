package com.tencent.mm.plugin.appbrand.jsapi.r;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import org.json.JSONObject;

public final class f extends a {
    public static final int CTRL_INDEX = 84;
    public static final String NAME = "showDatePickerView";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.r.a, com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(h hVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(137581);
        b(hVar, jSONObject, i2);
        AppMethodBeat.o(137581);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.r.a
    public final void b(h hVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(137580);
        String optString = jSONObject.optString("mode");
        if (FFmpegMetadataRetriever.METADATA_KEY_DATE.equals(optString)) {
            new b().a(this, hVar, jSONObject, i2, this.mmD);
            AppMethodBeat.o(137580);
        } else if ("time".equals(optString)) {
            new k().a(this, hVar, jSONObject, i2, this.mmD);
            AppMethodBeat.o(137580);
        } else {
            hVar.i(i2, h("fail:invalid data", null));
            AppMethodBeat.o(137580);
        }
    }
}
