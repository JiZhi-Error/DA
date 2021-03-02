package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.luggage.d.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.plugin.webview.luggage.jsapi.br;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKFileItem;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKImageItem;
import com.tencent.mm.plugin.webview.model.an;
import com.tencent.mm.plugin.webview.model.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.h;
import org.json.JSONException;
import org.json.JSONObject;

public class q extends bs<g> {
    private ProgressDialog gtM = null;

    @Override // com.tencent.luggage.d.b
    public final String name() {
        return "downloadImage";
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final int dTs() {
        return 2;
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final void b(b<g>.a aVar) {
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final void a(Context context, String str, final br.a aVar) {
        AppMethodBeat.i(78551);
        JSONObject Zc = com.tencent.mm.plugin.webview.luggage.c.b.Zc(str);
        if (Zc == null) {
            Log.i("MicroMsg.JsApiDownLoadImage", "data is null");
            aVar.i("invalid_data", null);
            AppMethodBeat.o(78551);
            return;
        }
        String optString = Zc.optString("preVerifyAppId");
        final String optString2 = Zc.optString("serverId");
        boolean z = Util.getInt(Zc.optString("isShowProgressTips", AppEventsConstants.EVENT_PARAM_VALUE_NO), 0) == 1;
        Log.i("MicroMsg.JsApiDownLoadImage", "doDownLoadImage, appid is : %s, media id is : %s", optString, optString2);
        if (Util.isNullOrNil(optString) || Util.isNullOrNil(optString2)) {
            aVar.i("missing arguments", null);
            AppMethodBeat.o(78551);
            return;
        }
        final AnonymousClass1 r5 = new f.b() {
            /* class com.tencent.mm.plugin.webview.luggage.jsapi.q.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.webview.model.f.b
            public final void a(boolean z, int i2, String str, String str2, String str3, String str4) {
                AppMethodBeat.i(78549);
                Log.i("MicroMsg.JsApiDownLoadImage", "doDownLoadImage, on cdn finish, is success : %b, local id : %s, media id is : %s", Boolean.valueOf(z), str, str2);
                if (!Util.isNullOrNil(str2) && str2.equals(optString2)) {
                    com.tencent.mm.plugin.webview.modeltools.g.gdu().b(this);
                    if (q.this.gtM != null) {
                        q.this.gtM.dismiss();
                        q.this.gtM = null;
                    }
                    if (!z) {
                        aVar.i("fail", null);
                        AppMethodBeat.o(78549);
                        return;
                    }
                    WebViewJSSDKFileItem aYO = com.tencent.mm.plugin.webview.modeltools.g.gdv().aYO(str);
                    if ((aYO instanceof WebViewJSSDKImageItem) && Util.isNullOrNil(aYO.lPx)) {
                        ((WebViewJSSDKImageItem) aYO).hXM();
                    }
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put(ch.COL_LOCALID, str);
                    } catch (JSONException e2) {
                    }
                    aVar.i(null, jSONObject);
                }
                AppMethodBeat.o(78549);
            }
        };
        com.tencent.mm.plugin.webview.modeltools.g.gdu().a(optString, optString2, r5);
        Log.i("MicroMsg.JsApiDownLoadImage", "doDownLoadImage, add cdn download task result : %b", Boolean.TRUE);
        if (z) {
            context.getString(R.string.zb);
            this.gtM = h.a(context, context.getString(R.string.j4k), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                /* class com.tencent.mm.plugin.webview.luggage.jsapi.q.AnonymousClass2 */

                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(78550);
                    com.tencent.mm.plugin.webview.modeltools.g.gdu().b(r5);
                    com.tencent.mm.plugin.webview.modeltools.g.gdu();
                    an.aYI(optString2);
                    aVar.i("downloadImage:fail", null);
                    AppMethodBeat.o(78550);
                }
            });
        }
        AppMethodBeat.o(78551);
    }
}
