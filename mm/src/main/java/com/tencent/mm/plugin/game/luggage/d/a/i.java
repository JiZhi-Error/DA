package com.tencent.mm.plugin.game.luggage.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.g.a;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.lite.jsapi.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadProxyEnum;
import org.json.JSONObject;

public class i extends b {
    @Override // com.tencent.mm.plugin.lite.jsapi.b
    public final int dTw() {
        return 1;
    }

    @Override // com.tencent.liteapp.jsapi.a
    public final void a(String str, JSONObject jSONObject) {
        AppMethodBeat.i(186915);
        long optLong = jSONObject.optLong("download_id");
        if (optLong <= 0) {
            Log.e("LiteAppJsApiPauseDownloadTask", "fail, invalid downloadId = ".concat(String.valueOf(optLong)));
            this.yEn.aCS("invalid_downloadid");
            AppMethodBeat.o(186915);
            return;
        }
        a Cw = d.Cw(optLong);
        if (Cw == null) {
            this.yEn.ecz();
            AppMethodBeat.o(186915);
            return;
        }
        int optInt = jSONObject.optInt("scene", 1000);
        int optInt2 = jSONObject.optInt("uiarea");
        int optInt3 = jSONObject.optInt("notice_id");
        int optInt4 = jSONObject.optInt(TPDownloadProxyEnum.USER_SSID);
        Cw.field_scene = optInt;
        Cw.field_uiarea = optInt2;
        Cw.field_noticeId = optInt3;
        Cw.field_ssid = optInt4;
        Cw.field_downloadInWifi = false;
        d.e(Cw);
        if (f.cBv().Cp(optLong)) {
            this.yEn.ecz();
            AppMethodBeat.o(186915);
            return;
        }
        this.yEn.aCS("fail");
        AppMethodBeat.o(186915);
    }
}
