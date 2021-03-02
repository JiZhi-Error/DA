package com.tencent.mm.plugin.websearch.widget.c.a;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.websearch.widget.c.c;
import com.tencent.mm.sdk.http.HttpWrapperBase;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class d implements a {
    @Override // com.tencent.mm.plugin.websearch.widget.c.a.a
    public final boolean aXt(String str) {
        AppMethodBeat.i(116665);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(116665);
            return false;
        } else if (str.startsWith(HttpWrapperBase.PROTOCAL_HTTP) || str.startsWith(HttpWrapperBase.PROTOCAL_HTTPS)) {
            AppMethodBeat.o(116665);
            return true;
        } else {
            AppMethodBeat.o(116665);
            return false;
        }
    }

    @Override // com.tencent.mm.plugin.websearch.widget.c.a.a
    public final boolean Mb(long j2) {
        AppMethodBeat.i(116666);
        boolean ak = c.ak(j2, 0);
        AppMethodBeat.o(116666);
        return ak;
    }

    @Override // com.tencent.mm.plugin.websearch.widget.c.a.a
    public final boolean aXu(String str) {
        AppMethodBeat.i(116667);
        if (!aXt(str)) {
            AppMethodBeat.o(116667);
            return false;
        }
        Intent intent = new Intent();
        intent.putExtra("rawUrl", str);
        intent.putExtra("useJs", true);
        com.tencent.mm.br.c.b(MMApplicationContext.getContext(), "webview", ".ui.tools.WebViewUI", intent);
        AppMethodBeat.o(116667);
        return true;
    }
}
