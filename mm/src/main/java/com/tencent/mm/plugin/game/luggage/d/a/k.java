package com.tencent.mm.plugin.game.luggage.d.a;

import android.content.Context;
import android.content.DialogInterface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.downloader.g.a;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.downloader.model.o;
import com.tencent.mm.plugin.lite.jsapi.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.ui.base.h;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadProxyEnum;
import org.json.JSONObject;

public class k extends b {
    static /* synthetic */ void a(k kVar, long j2) {
        AppMethodBeat.i(186926);
        kVar.GH(j2);
        AppMethodBeat.o(186926);
    }

    @Override // com.tencent.mm.plugin.lite.jsapi.b
    public final int dTw() {
        return 1;
    }

    @Override // com.tencent.liteapp.jsapi.a
    public final void a(String str, final JSONObject jSONObject) {
        AppMethodBeat.i(186924);
        final long optLong = jSONObject.optLong("download_id");
        if (optLong <= 0) {
            Log.e("LiteAppJsApiResumeDownloadTask", "fail, invalid downloadId = ".concat(String.valueOf(optLong)));
            this.yEn.aCS("invalid_downloadid");
            AppMethodBeat.o(186924);
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
        Context context = MMApplicationContext.getContext();
        if (optBoolean) {
            o.a(MMApplicationContext.getContext(), optLong, optBoolean2, z, new o.a() {
                /* class com.tencent.mm.plugin.game.luggage.d.a.k.AnonymousClass3 */

                @Override // com.tencent.mm.plugin.downloader.model.o.a
                public final void i(String str, JSONObject jSONObject) {
                    AppMethodBeat.i(186923);
                    if (str != null) {
                        k.this.yEn.aCS(str);
                        AppMethodBeat.o(186923);
                        return;
                    }
                    k.this.yEn.aW(jSONObject);
                    AppMethodBeat.o(186923);
                }
            });
            com.tencent.mm.modelstat.d.d(10, "LuggageGameWebViewUI_resumeDownloadTask", hashCode());
            AppMethodBeat.o(186924);
        } else if (NetStatusUtil.isWifi(context)) {
            GH(optLong);
            AppMethodBeat.o(186924);
        } else {
            h.a(context, context.getString(R.string.iyr), context.getString(R.string.iys), context.getString(R.string.iym), context.getString(R.string.sz), false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.game.luggage.d.a.k.AnonymousClass1 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(186921);
                    k.a(k.this, optLong);
                    dialogInterface.dismiss();
                    AppMethodBeat.o(186921);
                }
            }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.game.luggage.d.a.k.AnonymousClass2 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(186922);
                    dialogInterface.dismiss();
                    k.this.yEn.aCS("fail_network_not_wifi");
                    AppMethodBeat.o(186922);
                }
            }, (int) R.color.afp);
            AppMethodBeat.o(186924);
        }
    }

    private void GH(long j2) {
        AppMethodBeat.i(186925);
        a Cw = d.Cw(j2);
        if (Cw != null && Cw.field_fromDownloadApp) {
            Cw.field_fromDownloadApp = false;
            Cw.field_showNotification = true;
            d.e(Cw);
        }
        if (f.cBv().Cq(j2)) {
            this.yEn.ecz();
        } else {
            this.yEn.aCS("fail");
        }
        com.tencent.mm.modelstat.d.d(10, "LuggageGameWebViewUI_resumeDownloadTask", hashCode());
        AppMethodBeat.o(186925);
    }
}
