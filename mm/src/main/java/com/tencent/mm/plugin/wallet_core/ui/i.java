package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.xweb.WebView;
import com.tencent.xweb.ac;

public final class i extends ac {
    private Context context;

    public i(Context context2) {
        this.context = context2;
    }

    @Override // com.tencent.xweb.ac
    public final boolean a(WebView webView, String str) {
        AppMethodBeat.i(70681);
        Intent intent = new Intent();
        intent.putExtra("rawUrl", str);
        Log.d("MicroMsg.ProtoColWebViewClient", "raw url: %s", intent.getStringExtra("rawUrl"));
        c.b(this.context, "webview", ".ui.tools.WebViewUI", intent);
        AppMethodBeat.o(70681);
        return true;
    }
}
