package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.content.DialogInterface;
import com.tencent.luggage.d.b;
import com.tencent.luggage.d.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiResumeDownloadTask;
import com.tencent.mm.plugin.downloader.g.a;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.downloader.model.o;
import com.tencent.mm.plugin.webview.luggage.jsapi.br;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.ui.base.h;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadProxyEnum;
import org.json.JSONException;
import org.json.JSONObject;

public class ba extends br<s> {
    static /* synthetic */ void a(ba baVar, long j2, br.a aVar) {
        AppMethodBeat.i(78617);
        baVar.a(j2, aVar);
        AppMethodBeat.o(78617);
    }

    @Override // com.tencent.luggage.d.b
    public final String name() {
        return JsApiResumeDownloadTask.NAME;
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final int dTs() {
        return 2;
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final void b(b<s>.a aVar) {
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final void a(Context context, String str, final br.a aVar) {
        AppMethodBeat.i(78615);
        Log.i("MicroMsg.JsApiResumeDownloadTask", "invokeInMM");
        try {
            final JSONObject jSONObject = new JSONObject(str);
            final long optLong = jSONObject.optLong("download_id");
            if (optLong <= 0) {
                Log.e("MicroMsg.JsApiResumeDownloadTask", "fail, invalid downloadId = ".concat(String.valueOf(optLong)));
                aVar.i("invalid_downloadid", null);
                AppMethodBeat.o(78615);
                return;
            }
            int optInt = jSONObject.optInt("scene", 1000);
            int optInt2 = jSONObject.optInt("uiarea");
            int optInt3 = jSONObject.optInt("notice_id");
            int optInt4 = jSONObject.optInt(TPDownloadProxyEnum.USER_SSID);
            int optInt5 = jSONObject.optInt("download_type", 1);
            boolean z = jSONObject.optInt("ignoreNetwork", 0) == 1;
            a Cw = d.Cw(optLong);
            Cw.field_scene = optInt;
            Cw.field_uiarea = optInt2;
            Cw.field_noticeId = optInt3;
            Cw.field_ssid = optInt4;
            Cw.field_downloadType = optInt5;
            d.e(Cw);
            if (Cw != null) {
                com.tencent.mm.plugin.downloader.f.b bVar = new com.tencent.mm.plugin.downloader.f.b();
                bVar.k(Cw);
                bVar.costTime = 0;
                com.tencent.mm.plugin.downloader.f.a.a(10, bVar);
            }
            boolean optBoolean = jSONObject.optBoolean("use_downloader_widget", false);
            boolean optBoolean2 = jSONObject.optBoolean("download_in_wifi", false);
            if (optBoolean) {
                o.a(context, optLong, optBoolean2, z, new o.a() {
                    /* class com.tencent.mm.plugin.webview.luggage.jsapi.ba.AnonymousClass3 */

                    @Override // com.tencent.mm.plugin.downloader.model.o.a
                    public final void i(String str, JSONObject jSONObject) {
                        AppMethodBeat.i(78614);
                        aVar.i(str, jSONObject);
                        AppMethodBeat.o(78614);
                    }
                });
                com.tencent.mm.modelstat.d.d(10, "LuggageGameWebViewUI_resumeDownloadTask", hashCode());
                AppMethodBeat.o(78615);
            } else if (NetStatusUtil.isWifi(context)) {
                a(optLong, aVar);
                AppMethodBeat.o(78615);
            } else {
                h.a(context, context.getString(R.string.iyr), context.getString(R.string.iys), context.getString(R.string.iym), context.getString(R.string.sz), false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.webview.luggage.jsapi.ba.AnonymousClass1 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(78612);
                        ba.a(ba.this, optLong, aVar);
                        dialogInterface.dismiss();
                        AppMethodBeat.o(78612);
                    }
                }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.webview.luggage.jsapi.ba.AnonymousClass2 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(78613);
                        dialogInterface.dismiss();
                        aVar.i("fail_network_not_wifi", null);
                        AppMethodBeat.o(78613);
                    }
                }, (int) R.color.afp);
                AppMethodBeat.o(78615);
            }
        } catch (JSONException e2) {
            Log.e("MicroMsg.JsApiResumeDownloadTask", "paras data error: " + e2.getMessage());
            aVar.i("fail", null);
            AppMethodBeat.o(78615);
        }
    }

    private void a(long j2, br.a aVar) {
        AppMethodBeat.i(78616);
        a Cw = d.Cw(j2);
        if (Cw != null && Cw.field_fromDownloadApp) {
            Cw.field_fromDownloadApp = false;
            Cw.field_showNotification = true;
            d.e(Cw);
        }
        if (f.cBv().Cq(j2)) {
            aVar.i(null, null);
        } else {
            aVar.i("fail", null);
        }
        com.tencent.mm.modelstat.d.d(10, "LuggageGameWebViewUI_resumeDownloadTask", hashCode());
        AppMethodBeat.o(78616);
    }
}
