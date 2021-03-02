package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.d.b;
import com.tencent.luggage.d.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiCancelDownloadTask;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.webview.luggage.jsapi.br;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public class g extends br<s> {
    @Override // com.tencent.luggage.d.b
    public final String name() {
        return JsApiCancelDownloadTask.NAME;
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final int dTs() {
        return 1;
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final void b(b<s>.a aVar) {
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final void a(Context context, String str, br.a aVar) {
        AppMethodBeat.i(78524);
        Log.i("MicroMsg.JsApiCancelDownloadTask", "invokeInMM");
        JSONObject Zc = com.tencent.mm.plugin.webview.luggage.c.b.Zc(str);
        if (Zc == null) {
            aVar.i("fail", null);
            AppMethodBeat.o(78524);
            return;
        }
        long optLong = Zc.optLong("download_id");
        if (optLong <= 0) {
            Log.e("MicroMsg.JsApiCancelDownloadTask", "fail, invalid downloadId = ".concat(String.valueOf(optLong)));
            aVar.i("invalid_downloadid", null);
            AppMethodBeat.o(78524);
        } else if (f.cBv().Cn(optLong) > 0) {
            aVar.i(null, null);
            AppMethodBeat.o(78524);
        } else {
            aVar.i("fail", null);
            AppMethodBeat.o(78524);
        }
    }
}
