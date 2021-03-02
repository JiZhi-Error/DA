package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.plugin.appbrand.a;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.model.AdReportCgiHelper;
import org.json.JSONObject;

public final class al extends d {
    public static final int CTRL_INDEX = 435;
    public static final String NAME = "adDataReport";

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final void a(final f fVar, JSONObject jSONObject, final int i2) {
        String optString;
        AppMethodBeat.i(45432);
        AppBrandStatObject TS = a.TS(fVar.getAppId());
        if (TS != null) {
            optString = TS.scene + "," + TS.dCw + "," + TS.ecU + "," + TS.ecV + "," + jSONObject.optString("adInfo");
        } else {
            optString = jSONObject.optString("adInfo");
        }
        AdReportCgiHelper.a(15175, optString + "," + q.dr(false), new AdReportCgiHelper.a() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.al.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.appbrand.report.model.AdReportCgiHelper.a
            public final void onDone() {
                AppMethodBeat.i(45431);
                fVar.i(i2, al.this.h("ok", null));
                AppMethodBeat.o(45431);
            }
        });
        AppMethodBeat.o(45432);
    }
}
