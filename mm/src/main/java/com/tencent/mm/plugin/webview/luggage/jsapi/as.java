package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.luggage.d.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.plugin.webview.luggage.jsapi.br;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKFileItem;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.vfs.s;

public class as extends bs<g> {
    @Override // com.tencent.luggage.d.b
    public final String name() {
        return "previewVideo";
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final int dTs() {
        return 0;
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final void b(final b<g>.a aVar) {
        AppMethodBeat.i(78598);
        Log.i("MicroMsg.GameJsApiPreviewVideo", "invoke");
        if (Util.isNullOrNil(aVar.ctb.csi.optString(ch.COL_LOCALID))) {
            Log.i("MicroMsg.GameJsApiPreviewVideo", "data is invalid");
            aVar.c("invalid_data", null);
            AppMethodBeat.o(78598);
            return;
        }
        String optString = aVar.ctb.csi.optString(ch.COL_LOCALID);
        Log.i("MicroMsg.GameJsApiPreviewVideo", "localId:%s", optString);
        final MMActivity mMActivity = (MMActivity) aVar.cta.mContext;
        mMActivity.mmSetOnActivityResultCallback(new MMActivity.a() {
            /* class com.tencent.mm.plugin.webview.luggage.jsapi.as.AnonymousClass1 */

            @Override // com.tencent.mm.ui.MMActivity.a
            public final void d(int i2, int i3, Intent intent) {
                AppMethodBeat.i(78597);
                if (i2 == (as.this.hashCode() & 65535)) {
                    switch (i3) {
                        case -1:
                            aVar.c("", null);
                            break;
                        case 0:
                            aVar.c("cancel", null);
                            break;
                        default:
                            aVar.c("fail", null);
                            break;
                    }
                    mMActivity.mmSetOnActivityResultCallback(null);
                }
                AppMethodBeat.o(78597);
            }
        });
        Intent intent = new Intent();
        if (Util.nullAsNil(optString).trim().startsWith("weixin://bgmixid/")) {
            intent.putExtra("game_bg_mix_fake_local_id", Util.nullAsNil(optString).trim());
            c.b(mMActivity, "game", ".media.background.GameFakeVideoUI", intent, hashCode() & 65535);
            AppMethodBeat.o(78598);
            return;
        }
        WebViewJSSDKFileItem aYC = com.tencent.mm.plugin.webview.luggage.c.b.aYC(optString);
        if (aYC == null || TextUtils.isEmpty(aYC.laR) || !s.YS(aYC.laR)) {
            Log.e("MicroMsg.GameJsApiPreviewVideo", "the item is null or the File item not exist for localId: %s", optString);
            aVar.c("fail", null);
            AppMethodBeat.o(78598);
            return;
        }
        intent.putExtra("key_video_path", aYC.laR);
        c.b(mMActivity, "card", ".ui.CardGiftVideoUI", intent, hashCode() & 65535);
        AppMethodBeat.o(78598);
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final void a(Context context, String str, br.a aVar) {
    }
}
