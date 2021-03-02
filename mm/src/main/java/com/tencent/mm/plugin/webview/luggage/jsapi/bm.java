package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.content.Intent;
import com.tencent.luggage.d.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.appbrand.jsapi.share.l;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.plugin.webview.luggage.jsapi.br;
import com.tencent.mm.sdk.http.HttpWrapperBase;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import org.json.JSONObject;

public class bm extends bs<g> {
    @Override // com.tencent.luggage.d.b
    public final String name() {
        return l.NAME;
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final int dTs() {
        return 0;
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final void b(final b<g>.a aVar) {
        AppMethodBeat.i(78635);
        Log.i("MicroMsg.JsApiShareTimeLine", "invoke");
        final MMActivity mMActivity = (MMActivity) aVar.cta.mContext;
        if (mMActivity == null || mMActivity.isFinishing()) {
            Log.w("MicroMsg.JsApiShareTimeLine", "activity is null or finish");
            AppMethodBeat.o(78635);
            return;
        }
        JSONObject jSONObject = aVar.ctb.csi;
        String optString = jSONObject.optString("link");
        if (Util.isNullOrNil(optString)) {
            Log.e("MicroMsg.JsApiShareTimeLine", "link is null");
            aVar.c("invalid_params", null);
            AppMethodBeat.o(78635);
            return;
        }
        String optString2 = jSONObject.optString("desc");
        if (optString2 != null) {
            if (optString2.startsWith(HttpWrapperBase.PROTOCAL_HTTP)) {
                optString2.substring(7);
            } else if (optString2.startsWith(HttpWrapperBase.PROTOCAL_HTTPS)) {
                optString2.substring(8);
            }
        }
        String optString3 = jSONObject.optString("appid");
        String optString4 = jSONObject.optString("img_width");
        String optString5 = jSONObject.optString("img_height");
        Log.i("MicroMsg.JsApiShareTimeLine", "doTimeline, rawUrl:[%s], shareUrl:[%s]", optString, optString);
        String optString6 = jSONObject.optString("type");
        String optString7 = jSONObject.optString("title");
        String optString8 = jSONObject.optString("img_url");
        String optString9 = jSONObject.optString("src_username");
        String optString10 = jSONObject.optString("src_displayname");
        int i2 = -1;
        try {
            i2 = Integer.valueOf(optString4).intValue();
            Integer.valueOf(optString5);
        } catch (Exception e2) {
        }
        Intent intent = new Intent();
        intent.putExtra("Ksnsupload_width", i2);
        intent.putExtra("Ksnsupload_height", i2);
        intent.putExtra("Ksnsupload_link", optString);
        intent.putExtra("Ksnsupload_title", optString7);
        intent.putExtra("Ksnsupload_imgurl", optString8);
        if (ab.IT(optString9)) {
            intent.putExtra("src_username", optString9);
            intent.putExtra("src_displayname", optString10);
        }
        intent.putExtra("Ksnsupload_source", 1);
        intent.putExtra("Ksnsupload_type", 1);
        if (!Util.isNullOrNil(optString6) && optString6.equals("music")) {
            intent.putExtra("ksnsis_music", true);
        }
        if (!Util.isNullOrNil(optString6) && optString6.equals("video")) {
            intent.putExtra("ksnsis_video", true);
        }
        if (optString3 != null && optString3.length() > 0) {
            intent.putExtra("Ksnsupload_appid", optString3);
        }
        intent.putExtra("ShareUrlOriginal", optString);
        intent.putExtra("ShareUrlOpen", aVar.cta.getUrl());
        intent.putExtra("JsAppId", aVar.cta.ITw.getAppId());
        intent.putExtra("need_result", true);
        Log.i("MicroMsg.JsApiShareTimeLine", "doTimeline, start activity");
        mMActivity.mmSetOnActivityResultCallback(new MMActivity.a() {
            /* class com.tencent.mm.plugin.webview.luggage.jsapi.bm.AnonymousClass1 */

            @Override // com.tencent.mm.ui.MMActivity.a
            public final void d(int i2, int i3, Intent intent) {
                AppMethodBeat.i(78634);
                if (i2 == (bm.this.hashCode() & 65535)) {
                    if (i3 == -1) {
                        aVar.c("", null);
                    } else {
                        aVar.c("cancel", null);
                    }
                    mMActivity.mmSetOnActivityResultCallback(null);
                }
                AppMethodBeat.o(78634);
            }
        });
        c.a((Context) mMActivity, "sns", ".ui.SnsUploadUI", intent, hashCode() & 65535, false);
        AppMethodBeat.o(78635);
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final void a(Context context, String str, br.a aVar) {
    }
}
