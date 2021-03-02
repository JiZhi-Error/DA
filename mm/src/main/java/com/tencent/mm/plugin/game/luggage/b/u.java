package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import android.content.Intent;
import com.tencent.luggage.d.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.api.g;
import com.tencent.mm.plugin.game.luggage.g.i;
import com.tencent.mm.plugin.webview.luggage.jsapi.br;
import com.tencent.mm.plugin.webview.luggage.jsapi.bs;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class u extends bs<i> {
    @Override // com.tencent.luggage.d.b
    public final String name() {
        return "launchGameVideoEditor";
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final int dTs() {
        return 0;
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final void a(Context context, String str, br.a aVar) {
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final void b(final b<i>.a aVar) {
        AppMethodBeat.i(83078);
        String optString = aVar.ctb.csi.optString("videoUrl");
        String optString2 = aVar.ctb.csi.optString("thumbUrl");
        String optString3 = aVar.ctb.csi.optString("appId");
        int optInt = aVar.ctb.csi.optInt("sourceSceneId");
        if (Util.isNullOrNil(optString)) {
            aVar.c("invalid_videoUrl", null);
            AppMethodBeat.o(83078);
            return;
        }
        ((g) com.tencent.mm.kernel.g.af(g.class)).a(aVar.cta.mContext, optString, optString2, optString3, 510, optInt);
        ((MMActivity) aVar.cta.mContext).mmSetOnActivityResultCallback(new MMActivity.a() {
            /* class com.tencent.mm.plugin.game.luggage.b.u.AnonymousClass1 */

            @Override // com.tencent.mm.ui.MMActivity.a
            public final void d(int i2, int i3, Intent intent) {
                AppMethodBeat.i(83077);
                if (i2 == 510) {
                    if (i3 == -1) {
                        switch (intent.getIntExtra("webview_callback_err", 0)) {
                            case 0:
                                JSONObject jSONObject = new JSONObject();
                                try {
                                    jSONObject.put("videoInfo", new JSONArray(intent.getStringExtra("key_video_info")).getJSONObject(0));
                                } catch (JSONException e2) {
                                    Log.e("MicroMsg.JsApiLaunchGameVideoEditor", "json_err:%s", e2.getMessage());
                                }
                                aVar.c("", jSONObject);
                                break;
                            case 1:
                                aVar.c("cancel", null);
                                break;
                            case 2:
                                aVar.c("download_err", null);
                                break;
                        }
                    } else {
                        aVar.c("cancel", null);
                    }
                    ((MMActivity) aVar.cta.mContext).mmSetOnActivityResultCallback(null);
                }
                AppMethodBeat.o(83077);
            }
        });
        AppMethodBeat.o(83078);
    }
}
