package com.tencent.mm.plugin.webview.luggage;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.sdk.platformtools.Util;

public final class p {
    public static void ar(Context context, Intent intent) {
        AppMethodBeat.i(78414);
        if (Util.isNullOrNil(intent.getStringExtra("rawUrl"))) {
            AppMethodBeat.o(78414);
            return;
        }
        c.b(context, "webview", ".ui.tools.WebViewUI", intent);
        AppMethodBeat.o(78414);
    }
}
