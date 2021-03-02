package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.luggage.d.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.br.c;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.plugin.webview.luggage.jsapi.br;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;

public class an extends bs<g> {
    @Override // com.tencent.luggage.d.b
    public final String name() {
        return "openUrlWithExtraWebview";
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final int dTs() {
        return 0;
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final void b(final b<g>.a aVar) {
        AppMethodBeat.i(78590);
        Log.i("MicroMsg.JsApiOpenUrlWithExtraWebview", "invokeInOwn");
        final String optString = aVar.ctb.csi.optString("url");
        Log.i("MicroMsg.JsApiOpenUrlWithExtraWebview", "url: %s", optString);
        if (Util.isNullOrNil(optString)) {
            aVar.c("fail", null);
            AppMethodBeat.o(78590);
            return;
        }
        Uri parse = Uri.parse(optString);
        if (Util.nullAsNil(parse.getQueryParameter("not_in_game_luggage")).equals("1") || (parse.getHost() != null && !parse.getHost().equals(WeChatHosts.domainString(R.string.e1h)))) {
            Intent intent = new Intent();
            intent.putExtra("rawUrl", optString);
            c.b(aVar.cta.mContext, "webview", ".ui.tools.WebViewUI", intent);
            aVar.c("", null);
            AppMethodBeat.o(78590);
            return;
        }
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.webview.luggage.jsapi.an.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(78589);
                Bundle bundle = new Bundle();
                bundle.putString("rawUrl", optString);
                bundle.putBoolean("from_find_more_friend", aVar.cta.mParams.getBoolean("from_find_more_friend", false));
                aVar.cta.ctg.Ly().h(optString, bundle);
                AppMethodBeat.o(78589);
            }
        });
        aVar.c("", null);
        AppMethodBeat.o(78590);
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final void a(Context context, String str, br.a aVar) {
    }
}
