package com.tencent.mm.plugin.game.luggage.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.lite.jsapi.b;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public class c extends b {
    @Override // com.tencent.mm.plugin.lite.jsapi.b
    public final int dTw() {
        return 1;
    }

    @Override // com.tencent.liteapp.jsapi.a
    public final void a(String str, JSONObject jSONObject) {
        AppMethodBeat.i(186903);
        long optLong = jSONObject.optLong("download_id");
        if (optLong <= 0) {
            Log.e("LiteAppJsApiCancelDownloadTask", "fail, invalid downloadId = ".concat(String.valueOf(optLong)));
            this.yEn.aCS("invalid_downloadid");
            AppMethodBeat.o(186903);
        } else if (f.cBv().Cn(optLong) > 0) {
            this.yEn.ecz();
            AppMethodBeat.o(186903);
        } else {
            this.yEn.aCS("fail");
            AppMethodBeat.o(186903);
        }
    }
}
