package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.content.DialogInterface;
import android.widget.Toast;
import com.tencent.luggage.d.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.g.a.iv;
import com.tencent.mm.modelstat.d;
import com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiAddDownloadTaskStraight;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.downloader.model.g;
import com.tencent.mm.plugin.downloader.model.h;
import com.tencent.mm.plugin.downloader.model.o;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.plugin.webview.luggage.jsapi.br;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.sqlitelint.behaviour.persistence.IssueStorage;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadProxyEnum;
import org.json.JSONException;
import org.json.JSONObject;

public class a extends bs<g> {
    static /* synthetic */ void a(a aVar, JSONObject jSONObject, br.a aVar2) {
        AppMethodBeat.i(78512);
        aVar.a(jSONObject, aVar2);
        AppMethodBeat.o(78512);
    }

    @Override // com.tencent.luggage.d.b
    public final String name() {
        return JsApiAddDownloadTaskStraight.NAME;
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final int dTs() {
        return 2;
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final void b(b<g>.a aVar) {
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final void a(final Context context, String str, final br.a aVar) {
        AppMethodBeat.i(78510);
        Log.i("MicroMsg.JsApiAddDownloadTaskStraight", "invokeInMM");
        try {
            final JSONObject jSONObject = new JSONObject(str);
            final String optString = jSONObject.optString("task_url");
            long optLong = jSONObject.optLong("task_size");
            if (Util.isNullOrNil(optString)) {
                Log.e("MicroMsg.JsApiAddDownloadTaskStraight", "url is null");
                aVar.i("fail", null);
                AppMethodBeat.o(78510);
                return;
            }
            final String optString2 = jSONObject.optString("appid");
            int optInt = jSONObject.optInt("scene", 1000);
            int optInt2 = jSONObject.optInt("download_type", 1);
            int optInt3 = jSONObject.optInt(TPDownloadProxyEnum.USER_SSID);
            com.tencent.mm.plugin.downloader.f.a.a(9, new com.tencent.mm.plugin.downloader.f.b(optString2, optInt, jSONObject.optString(IssueStorage.COLUMN_EXT_INFO), jSONObject.optInt("uiarea"), optInt3, jSONObject.optInt("notice_id"), optInt2));
            final String optString3 = jSONObject.optString("currentUrl");
            if (jSONObject.optBoolean("use_downloader_widget", false)) {
                o.a(context, com.tencent.mm.plugin.downloader_app.a.a.aK(jSONObject), new o.a() {
                    /* class com.tencent.mm.plugin.webview.luggage.jsapi.a.AnonymousClass6 */

                    @Override // com.tencent.mm.plugin.downloader.model.o.a
                    public final void i(String str, JSONObject jSONObject) {
                        AppMethodBeat.i(78509);
                        aVar.i(str, jSONObject);
                        AppMethodBeat.o(78509);
                    }
                });
                d.d(10, "LuggageGameWebViewUI_addDownloadTask", hashCode());
                AppMethodBeat.o(78510);
            } else if (!NetStatusUtil.isNetworkConnected(context)) {
                aVar.i("fail_network_not_connected", null);
                com.tencent.mm.plugin.webview.luggage.c.b.runOnUiThread(new Runnable() {
                    /* class com.tencent.mm.plugin.webview.luggage.jsapi.a.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(78504);
                        Toast.makeText(context, context.getString(R.string.dom), 0).show();
                        AppMethodBeat.o(78504);
                    }
                });
                Log.i("MicroMsg.JsApiAddDownloadTaskStraight", " fail, network not ready");
                AppMethodBeat.o(78510);
            } else if (!e.apn()) {
                aVar.i("sdcard_not_ready", null);
                com.tencent.mm.plugin.webview.luggage.c.b.runOnUiThread(new Runnable() {
                    /* class com.tencent.mm.plugin.webview.luggage.jsapi.a.AnonymousClass2 */

                    public final void run() {
                        AppMethodBeat.i(78505);
                        Toast.makeText(context, context.getString(R.string.doq), 0).show();
                        AppMethodBeat.o(78505);
                    }
                });
                Log.i("MicroMsg.JsApiAddDownloadTaskStraight", " fail, sdcard not ready");
                AppMethodBeat.o(78510);
            } else if (optLong > 0 && !h.CF(optLong) && !h.CE(optLong)) {
                aVar.i("has_not_enough_space", null);
                com.tencent.mm.plugin.webview.luggage.c.b.runOnUiThread(new Runnable() {
                    /* class com.tencent.mm.plugin.webview.luggage.jsapi.a.AnonymousClass3 */

                    public final void run() {
                        AppMethodBeat.i(78506);
                        Toast.makeText(context, context.getString(R.string.don), 0).show();
                        AppMethodBeat.o(78506);
                    }
                });
                Log.i("MicroMsg.JsApiAddDownloadTaskStraight", "fail, not enough space, require size = ".concat(String.valueOf(optLong)));
                AppMethodBeat.o(78510);
            } else if (NetStatusUtil.isWifi(context)) {
                a(jSONObject, aVar);
                AppMethodBeat.o(78510);
            } else {
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(14217, optString2, 4, optString3, optString, 3);
                com.tencent.mm.ui.base.h.a(context, context.getString(R.string.iyr), context.getString(R.string.iys), context.getString(R.string.iym), context.getString(R.string.sz), false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.webview.luggage.jsapi.a.AnonymousClass4 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(78507);
                        com.tencent.mm.plugin.report.service.h.INSTANCE.a(14217, optString2, 5, optString3, optString, 3);
                        a.a(a.this, jSONObject, aVar);
                        dialogInterface.dismiss();
                        AppMethodBeat.o(78507);
                    }
                }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.webview.luggage.jsapi.a.AnonymousClass5 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(78508);
                        com.tencent.mm.plugin.report.service.h.INSTANCE.a(14217, optString2, 6, optString3, optString, 3);
                        dialogInterface.dismiss();
                        aVar.i("network_not_wifi", null);
                        AppMethodBeat.o(78508);
                    }
                }, (int) R.color.afp);
                AppMethodBeat.o(78510);
            }
        } catch (JSONException e2) {
            Log.e("MicroMsg.JsApiAddDownloadTaskStraight", "paras data error: " + e2.getMessage());
            aVar.i("fail", null);
            AppMethodBeat.o(78510);
        }
    }

    private void a(JSONObject jSONObject, br.a aVar) {
        long a2;
        AppMethodBeat.i(78511);
        iv ivVar = new iv();
        String optString = jSONObject.optString("task_name");
        String optString2 = jSONObject.optString("task_url");
        String optString3 = jSONObject.optString("alternative_url");
        long optLong = jSONObject.optLong("task_size");
        String optString4 = jSONObject.optString("file_md5");
        String optString5 = jSONObject.optString(IssueStorage.COLUMN_EXT_INFO);
        String optString6 = jSONObject.optString("fileType");
        String optString7 = jSONObject.optString("appid");
        String optString8 = jSONObject.optString("package_name");
        int optInt = jSONObject.optInt("scene", 1000);
        int optInt2 = jSONObject.optInt("downloader_type", 1);
        int optInt3 = jSONObject.optInt("download_type", 1);
        int optInt4 = jSONObject.optInt(TPDownloadProxyEnum.USER_SSID);
        int optInt5 = jSONObject.optInt("uiarea");
        int optInt6 = jSONObject.optInt("notice_id");
        ivVar.dNx.url = optString2;
        ivVar.dNx.md5 = optString4;
        ivVar.dNx.extInfo = optString5;
        ivVar.dNx.appId = optString7;
        ivVar.dNx.scene = optInt;
        EventCenter.instance.publish(ivVar);
        g.a aVar2 = new g.a();
        aVar2.alj(optString2);
        aVar2.alk(optString3);
        aVar2.setFileSize(optLong);
        aVar2.all(optString);
        aVar2.setFileMD5(optString4);
        aVar2.setAppId(optString7);
        aVar2.gm(optString8);
        aVar2.kS(true);
        aVar2.Fl(Util.getInt(optString6, 1));
        aVar2.setScene(optInt);
        aVar2.Fp(optInt3);
        aVar2.Fm(optInt4);
        aVar2.Fn(optInt5);
        aVar2.Fo(optInt6);
        com.tencent.mm.plugin.downloader.model.g gVar = aVar2.qIY;
        if (optInt2 == 1) {
            a2 = f.cBv().b(gVar);
        } else {
            a2 = f.cBv().a(gVar);
        }
        d.d(10, "LuggageGameWebViewUI_addDownloadTask", hashCode());
        if (a2 <= 0) {
            aVar.i("fail", null);
            AppMethodBeat.o(78511);
            return;
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("download_id", a2);
            aVar.i(null, jSONObject2);
            AppMethodBeat.o(78511);
        } catch (JSONException e2) {
            aVar.i(null, null);
            AppMethodBeat.o(78511);
        }
    }
}
