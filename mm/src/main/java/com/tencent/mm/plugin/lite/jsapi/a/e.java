package com.tencent.mm.plugin.lite.jsapi.a;

import android.content.Intent;
import com.google.android.gms.actions.SearchIntents;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.plugin.lite.jsapi.b;
import com.tencent.mm.sdk.http.HttpWrapperBase;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import org.json.JSONObject;

public class e extends b {
    private String appId;
    private JSONObject lnV;

    @Override // com.tencent.mm.plugin.lite.jsapi.b
    public final int dTw() {
        return 1;
    }

    @Override // com.tencent.liteapp.jsapi.a
    public final void a(String str, JSONObject jSONObject) {
        AppMethodBeat.i(198844);
        this.appId = str;
        this.lnV = jSONObject;
        String optString = jSONObject.optString("url");
        String optString2 = jSONObject.optString("path");
        if (optString.isEmpty()) {
            this.yEn.aCS("");
            AppMethodBeat.o(198844);
            return;
        }
        String optString3 = jSONObject.optString("thumbUrl");
        String optString4 = jSONObject.optString("srcId");
        Intent intent = new Intent();
        intent.putExtra("Ksnsupload_link", optString);
        intent.putExtra("Ksnsupload_contentattribute", 0);
        intent.putExtra("Ksnsupload_source", 1);
        intent.putExtra("Ksnsupload_type", 1);
        intent.putExtra("need_result", true);
        intent.putExtra("ksnsis_liteapp", true);
        intent.putExtra("KsnsUpload_LiteAppId", str);
        intent.putExtra("KsnsUpload_LiteAppPath", optString2);
        intent.putExtra("KsnsUpload_LiteAppQuery", jSONObject.optString(SearchIntents.EXTRA_QUERY));
        intent.putExtra("Ksnsupload_title", jSONObject.optString("title"));
        if (optString4 != null && optString4.length() > 0) {
            intent.putExtra("Ksnsupload_appid", optString4);
        }
        if (optString3.startsWith(HttpWrapperBase.PROTOCAL_HTTP) || optString3.startsWith(HttpWrapperBase.PROTOCAL_HTTPS)) {
            intent.putExtra("Ksnsupload_imgurl", optString3);
        }
        c.b(MMApplicationContext.getContext(), "sns", ".ui.SnsUploadUI", intent);
        AppMethodBeat.o(198844);
    }
}
