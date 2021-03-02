package com.tencent.mm.plugin.webview.model;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.plugin.x.a;
import com.tencent.mm.sdk.platformtools.IntentUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public final class as extends a {
    @Override // com.tencent.mm.plugin.x.a, com.tencent.mm.plugin.x.b
    public final int getType() {
        return 4;
    }

    @Override // com.tencent.mm.plugin.x.b
    public final void k(Context context, Intent intent) {
        AppMethodBeat.i(79038);
        intent.putExtra("type", 4);
        intent.putExtra("id", "");
        String bl = bl(intent);
        if (Util.isNullOrNil(bl)) {
            AppMethodBeat.o(79038);
            return;
        }
        Intent intent2 = new Intent();
        intent2.putExtra("rawUrl", bl);
        intent2.putExtra("from_shortcut", true);
        intent2.addFlags(268435456);
        c.b(context, "webview", ".ui.tools.WebViewUI", intent2);
        AppMethodBeat.o(79038);
    }

    private static String bl(Intent intent) {
        AppMethodBeat.i(79039);
        try {
            String decode = URLDecoder.decode(IntentUtil.getStringExtra(intent, "ext_info"), ProtocolPackage.ServerEncoding);
            AppMethodBeat.o(79039);
            return decode;
        } catch (UnsupportedEncodingException e2) {
            AppMethodBeat.o(79039);
            return "";
        }
    }
}
