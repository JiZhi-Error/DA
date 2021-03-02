package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import android.os.Bundle;
import com.tencent.luggage.d.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.luggage.g.i;
import com.tencent.mm.plugin.webview.luggage.jsapi.br;
import com.tencent.mm.plugin.webview.luggage.jsapi.bs;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

public class ad extends bs<i> {
    @Override // com.tencent.luggage.d.b
    public final String name() {
        return "reportGamePageTime";
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final int dTs() {
        return 0;
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final void a(Context context, String str, br.a aVar) {
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final void b(b.a aVar) {
        boolean z;
        AppMethodBeat.i(83087);
        JSONObject jSONObject = aVar.ctb.csi;
        String optString = jSONObject.optString("reportId");
        boolean z2 = jSONObject.optInt("reportInstantly", 0) == 1;
        if (jSONObject.optInt("reportTimeBegin", 0) == 1) {
            z = true;
        } else {
            z = false;
        }
        String optString2 = jSONObject.optString("reportFormatData");
        String optString3 = jSONObject.optString("reportTabsFormatData");
        if (Util.isNullOrNil(optString)) {
            Log.e("MicroMsg.JsApiReportGamePageTime", "reportId is null or nil");
            aVar.c("invalid_reportId", null);
            AppMethodBeat.o(83087);
        } else if (!Util.isNullOrNil(optString2) || !Util.isNullOrNil(optString3)) {
            Log.i("MicroMsg.JsApiReportGamePageTime", "reportGamePageTime, reportId:%s, reportInstantly:%b, reportTimeBegin:%b, reportFormatData:(%s), reportTabsFormatData(%s)", optString, Boolean.valueOf(z2), Boolean.valueOf(z), optString2, optString3);
            Bundle bundle = new Bundle();
            bundle.putString("game_page_report_id", optString);
            bundle.putBoolean("game_page_report_instantly", z2);
            bundle.putBoolean("game_page_report_time_begin", z);
            bundle.putString("game_page_report_format_data", optString2);
            bundle.putString("game_page_report_tabs_format_data", optString3);
            aVar.cta.xyK.Jqh.bm(bundle);
            aVar.c("", null);
            AppMethodBeat.o(83087);
        } else {
            Log.e("MicroMsg.JsApiReportGamePageTime", "reportFormatData && reportTabsFormatData is null or nil");
            aVar.c("invalid_reportFormatData_reportTabsFormatData", null);
            AppMethodBeat.o(83087);
        }
    }
}
