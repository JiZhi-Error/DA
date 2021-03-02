package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.d.b;
import com.tencent.luggage.d.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiInstallDownloadTask;
import com.tencent.mm.plugin.downloader.g.a;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.webview.luggage.jsapi.br;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadProxyEnum;
import org.json.JSONException;
import org.json.JSONObject;

public class ac extends br<s> {
    @Override // com.tencent.luggage.d.b
    public final String name() {
        return JsApiInstallDownloadTask.NAME;
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final int dTs() {
        return 1;
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final void b(b<s>.a aVar) {
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final void a(Context context, String str, final br.a aVar) {
        AppMethodBeat.i(78567);
        Log.i("MicroMsg.JsApiInstallDownloadTask", "invokeInOwn");
        try {
            JSONObject jSONObject = new JSONObject(str);
            long optLong = jSONObject.optLong("download_id");
            if (optLong <= 0) {
                Log.i("MicroMsg.JsApiInstallDownloadTask", "data is null");
                aVar.i("fail_invalid_data", null);
                AppMethodBeat.o(78567);
                return;
            }
            FileDownloadTaskInfo Co = f.cBv().Co(optLong);
            if (Co.status == -1) {
                Log.e("MicroMsg.JsApiInstallDownloadTask", "installDownloadTask fail, apilevel not supported");
                aVar.i("fail", null);
                AppMethodBeat.o(78567);
            } else if (Co.status != 3) {
                Log.e("MicroMsg.JsApiInstallDownloadTask", "installDownloadTask fail, invalid status = " + Co.status);
                aVar.i("fail", null);
                AppMethodBeat.o(78567);
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
                    /* class com.tencent.mm.plugin.webview.luggage.jsapi.ac.AnonymousClass1 */

                    @Override // com.tencent.mm.pluginsdk.permission.a
                    public final void hk(boolean z) {
                        AppMethodBeat.i(78566);
                        if (z) {
                            aVar.i(null, null);
                            AppMethodBeat.o(78566);
                            return;
                        }
                        aVar.i("fail", null);
                        AppMethodBeat.o(78566);
                    }
                });
                AppMethodBeat.o(78567);
            }
        } catch (JSONException e2) {
            Log.e("MicroMsg.JsApiInstallDownloadTask", "paras data error: " + e2.getMessage());
            aVar.i("fail", null);
            AppMethodBeat.o(78567);
        }
    }
}
