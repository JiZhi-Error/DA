package com.tencent.mm.plugin.game.luggage.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.g.a;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.plugin.lite.jsapi.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadProxyEnum;
import org.json.JSONObject;

public class f extends b {
    @Override // com.tencent.mm.plugin.lite.jsapi.b
    public final int dTw() {
        return 1;
    }

    @Override // com.tencent.liteapp.jsapi.a
    public final void a(String str, JSONObject jSONObject) {
        AppMethodBeat.i(186908);
        long optLong = jSONObject.optLong("download_id");
        if (optLong <= 0) {
            Log.i("LiteAppJsApiInstallDownloadTask", "data is null");
            this.yEn.aCS("fail_invalid_data");
            AppMethodBeat.o(186908);
            return;
        }
        FileDownloadTaskInfo Co = com.tencent.mm.plugin.downloader.model.f.cBv().Co(optLong);
        if (Co.status == -1) {
            Log.e("LiteAppJsApiInstallDownloadTask", "installDownloadTask fail, apilevel not supported");
            this.yEn.aCS("fail");
            AppMethodBeat.o(186908);
        } else if (Co.status != 3) {
            Log.e("LiteAppJsApiInstallDownloadTask", "installDownloadTask fail, invalid status = " + Co.status);
            this.yEn.aCS("fail");
            AppMethodBeat.o(186908);
        } else {
            a Cw = d.Cw(optLong);
            if (Cw != null) {
                int optInt = jSONObject.optInt("scene");
                int optInt2 = jSONObject.optInt("uiarea");
                int optInt3 = jSONObject.optInt("notice_id");
                int optInt4 = jSONObject.optInt(TPDownloadProxyEnum.USER_SSID);
                Cw.field_scene = optInt;
                Cw.field_uiarea = optInt2;
                Cw.field_noticeId = optInt3;
                Cw.field_ssid = optInt4;
                d.e(Cw);
            }
            com.tencent.mm.plugin.downloader.i.a.a(Co.id, false, new com.tencent.mm.pluginsdk.permission.a() {
                /* class com.tencent.mm.plugin.game.luggage.d.a.f.AnonymousClass1 */

                @Override // com.tencent.mm.pluginsdk.permission.a
                public final void hk(boolean z) {
                    AppMethodBeat.i(186907);
                    if (z) {
                        f.this.yEn.ecz();
                        AppMethodBeat.o(186907);
                        return;
                    }
                    f.this.yEn.aCS("fail");
                    AppMethodBeat.o(186907);
                }
            });
            AppMethodBeat.o(186908);
        }
    }
}
