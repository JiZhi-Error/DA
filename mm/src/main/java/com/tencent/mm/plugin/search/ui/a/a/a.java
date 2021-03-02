package com.tencent.mm.plugin.search.ui.a.a;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.service.s;
import com.tencent.mm.plugin.fts.a.d.a.b;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.fts.ui.a.j;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands;
import com.tencent.mm.storage.as;

public final class a implements b {
    @Override // com.tencent.mm.plugin.fts.a.d.a.b
    public final boolean a(Context context, View view, com.tencent.mm.plugin.fts.a.d.a.a aVar) {
        AppMethodBeat.i(232055);
        j jVar = (j) aVar;
        ((n) g.ah(n.class)).updateTopHitsRank(jVar.wWd.wWB, jVar.lqW, 0);
        if (aMY(jVar.xdl.field_url) && !WeChatBrands.Business.Entries.DiscoveryGame.checkAvailable(view.getContext())) {
            AppMethodBeat.o(232055);
        } else if (((s) g.af(s.class)).n(jVar.xdl.field_url, null)) {
            AppMethodBeat.o(232055);
        } else if (jVar.xdl.field_actionType == 2) {
            Intent intent = new Intent();
            intent.putExtra("rawUrl", jVar.xdl.field_url);
            c.b(context, "webview", ".ui.tools.WebViewUI", intent);
            AppMethodBeat.o(232055);
        } else {
            if (!com.tencent.mm.plugin.search.a.a.an(context, jVar.xdl.field_featureId)) {
                Intent intent2 = new Intent();
                intent2.putExtra("rawUrl", jVar.xdl.field_updateUrl);
                c.b(context, "webview", ".ui.tools.WebViewUI", intent2);
            }
            AppMethodBeat.o(232055);
        }
        return true;
    }

    private static boolean aMY(String str) {
        AppMethodBeat.i(232056);
        Uri uri = null;
        try {
            uri = Uri.parse(str);
        } catch (Exception e2) {
        }
        if (uri == null) {
            AppMethodBeat.o(232056);
            return false;
        }
        String queryParameter = uri.getQueryParameter(ch.COL_USERNAME);
        if (Util.isNullOrNil(queryParameter) || !as.HF(queryParameter)) {
            AppMethodBeat.o(232056);
            return false;
        }
        boolean equals = "gh_e9a0a3cb9d1e@app".equals(queryParameter);
        AppMethodBeat.o(232056);
        return equals;
    }
}
