package com.tencent.mm.plugin.game.luggage.d.a;

import android.content.Context;
import android.content.DialogInterface;
import android.widget.Toast;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.g.a.iv;
import com.tencent.mm.modelstat.d;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.downloader.model.g;
import com.tencent.mm.plugin.downloader.model.o;
import com.tencent.mm.plugin.lite.jsapi.b;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.sqlitelint.behaviour.persistence.IssueStorage;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadProxyEnum;
import org.json.JSONException;
import org.json.JSONObject;

public class a extends b {
    static /* synthetic */ void a(a aVar, JSONObject jSONObject) {
        AppMethodBeat.i(186898);
        aVar.aT(jSONObject);
        AppMethodBeat.o(186898);
    }

    @Override // com.tencent.mm.plugin.lite.jsapi.b
    public final int dTw() {
        return 1;
    }

    @Override // com.tencent.liteapp.jsapi.a
    public final void a(String str, final JSONObject jSONObject) {
        AppMethodBeat.i(186896);
        final String optString = jSONObject.optString("task_url");
        long optLong = jSONObject.optLong("task_size");
        if (Util.isNullOrNil(optString)) {
            Log.e("LiteAppJsApiAddDownloadTaskStraight", "url is null");
            this.yEn.aCS("uri is null");
            AppMethodBeat.o(186896);
            return;
        }
        final String optString2 = jSONObject.optString("appid");
        int optInt = jSONObject.optInt("scene", 1000);
        int optInt2 = jSONObject.optInt("download_type", 1);
        int optInt3 = jSONObject.optInt(TPDownloadProxyEnum.USER_SSID);
        com.tencent.mm.plugin.downloader.f.a.a(9, new com.tencent.mm.plugin.downloader.f.b(optString2, optInt, jSONObject.optString(IssueStorage.COLUMN_EXT_INFO), jSONObject.optInt("uiarea"), optInt3, jSONObject.optInt("notice_id"), optInt2));
        final String optString3 = jSONObject.optString("currentUrl");
        if (jSONObject.optBoolean("use_downloader_widget", false)) {
            o.a(MMApplicationContext.getContext(), com.tencent.mm.plugin.downloader_app.a.a.aK(jSONObject), new o.a() {
                /* class com.tencent.mm.plugin.game.luggage.d.a.a.AnonymousClass6 */

                @Override // com.tencent.mm.plugin.downloader.model.o.a
                public final void i(String str, JSONObject jSONObject) {
                    AppMethodBeat.i(186895);
                    if (str != null) {
                        a.this.yEn.aCS(str);
                        AppMethodBeat.o(186895);
                        return;
                    }
                    a.this.yEn.aW(jSONObject);
                    AppMethodBeat.o(186895);
                }
            });
            d.d(10, "LuggageGameWebViewUI_addDownloadTask", hashCode());
            AppMethodBeat.o(186896);
            return;
        }
        final Context context = MMApplicationContext.getContext();
        if (!NetStatusUtil.isNetworkConnected(context)) {
            this.yEn.aCS("fail_network_not_connected");
            h.RTc.aV(new Runnable() {
                /* class com.tencent.mm.plugin.game.luggage.d.a.a.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(186890);
                    Toast.makeText(context, context.getString(R.string.dom), 0).show();
                    AppMethodBeat.o(186890);
                }
            });
            Log.i("LiteAppJsApiAddDownloadTaskStraight", " fail, network not ready");
            AppMethodBeat.o(186896);
        } else if (!e.apn()) {
            this.yEn.aCS("sdcard_not_ready");
            h.RTc.aV(new Runnable() {
                /* class com.tencent.mm.plugin.game.luggage.d.a.a.AnonymousClass2 */

                public final void run() {
                    AppMethodBeat.i(186891);
                    Toast.makeText(context, context.getString(R.string.doq), 0).show();
                    AppMethodBeat.o(186891);
                }
            });
            Log.i("LiteAppJsApiAddDownloadTaskStraight", " fail, sdcard not ready");
            AppMethodBeat.o(186896);
        } else if (optLong > 0 && !com.tencent.mm.plugin.downloader.model.h.CF(optLong) && !com.tencent.mm.plugin.downloader.model.h.CE(optLong)) {
            this.yEn.aCS("has_not_enough_space");
            h.RTc.aV(new Runnable() {
                /* class com.tencent.mm.plugin.game.luggage.d.a.a.AnonymousClass3 */

                public final void run() {
                    AppMethodBeat.i(186892);
                    Toast.makeText(context, context.getString(R.string.don), 0).show();
                    AppMethodBeat.o(186892);
                }
            });
            Log.i("LiteAppJsApiAddDownloadTaskStraight", "fail, not enough space, require size = ".concat(String.valueOf(optLong)));
            AppMethodBeat.o(186896);
        } else if (NetStatusUtil.isWifi(context)) {
            aT(jSONObject);
            AppMethodBeat.o(186896);
        } else {
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(14217, optString2, 4, optString3, optString, 3);
            com.tencent.mm.ui.base.h.a(context, context.getString(R.string.iyr), context.getString(R.string.iys), context.getString(R.string.iym), context.getString(R.string.sz), false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.game.luggage.d.a.a.AnonymousClass4 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(186893);
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(14217, optString2, 5, optString3, optString, 3);
                    a.a(a.this, jSONObject);
                    dialogInterface.dismiss();
                    AppMethodBeat.o(186893);
                }
            }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.game.luggage.d.a.a.AnonymousClass5 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(186894);
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(14217, optString2, 6, optString3, optString, 3);
                    dialogInterface.dismiss();
                    a.this.yEn.aCS("network_not_wifi");
                    AppMethodBeat.o(186894);
                }
            }, (int) R.color.afp);
            AppMethodBeat.o(186896);
        }
    }

    private void aT(JSONObject jSONObject) {
        long a2;
        AppMethodBeat.i(186897);
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
        g.a aVar = new g.a();
        aVar.alj(optString2);
        aVar.alk(optString3);
        aVar.setFileSize(optLong);
        aVar.all(optString);
        aVar.setFileMD5(optString4);
        aVar.setAppId(optString7);
        aVar.gm(optString8);
        aVar.kS(true);
        aVar.Fl(Util.getInt(optString6, 1));
        aVar.setScene(optInt);
        aVar.Fp(optInt3);
        aVar.Fm(optInt4);
        aVar.Fn(optInt5);
        aVar.Fo(optInt6);
        g gVar = aVar.qIY;
        if (optInt2 == 1) {
            a2 = f.cBv().b(gVar);
        } else {
            a2 = f.cBv().a(gVar);
        }
        d.d(10, "LuggageGameWebViewUI_addDownloadTask", hashCode());
        if (a2 <= 0) {
            this.yEn.aCS("fail");
            AppMethodBeat.o(186897);
            return;
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("download_id", a2);
            this.yEn.aW(jSONObject2);
            AppMethodBeat.o(186897);
        } catch (JSONException e2) {
            this.yEn.aCS("exception");
            AppMethodBeat.o(186897);
        }
    }
}
