package com.tencent.mm.plugin.welab.c;

import android.app.Activity;
import android.content.Intent;
import com.google.android.gms.actions.SearchIntents;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.br.c;
import com.tencent.mm.g.a.om;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.plugin.websearch.api.ak;
import com.tencent.mm.plugin.websearch.api.ar;
import com.tencent.mm.plugin.websearch.api.i;
import com.tencent.mm.plugin.welab.a.a.b;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;

public final class a implements b {
    @Override // com.tencent.mm.plugin.welab.a.a.b
    public final void m(final Activity activity, String str) {
        AppMethodBeat.i(30249);
        if (!ai.afs(0)) {
            Log.e("MicroMsg.FTS.LookOneLookOpener", "fts h5 template not avail");
            AppMethodBeat.o(30249);
            return;
        }
        final String optString = ak.aXe("discoverRecommendEntry").optString("wording");
        if (Util.isNullOrNil(optString)) {
            Log.e("MicroMsg.FTS.LookOneLookOpener", "empty query");
            AppMethodBeat.o(30249);
            return;
        }
        ((i) g.af(i.class)).a(MMApplicationContext.getContext(), new Runnable() {
            /* class com.tencent.mm.plugin.welab.c.a.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(30248);
                Intent fXX = ai.fXX();
                fXX.putExtra("ftsbizscene", 21);
                fXX.putExtra("ftsQuery", optString);
                fXX.putExtra("title", optString);
                fXX.putExtra("isWebwx", optString);
                fXX.putExtra("ftscaneditable", false);
                Map<String, String> h2 = ai.h(21, false, 2);
                h2.put(SearchIntents.EXTRA_QUERY, optString);
                h2.put("sceneActionType", "2");
                fXX.putExtra("rawUrl", ai.g(h2, 1));
                om omVar = new om();
                omVar.dUz.scene = 0;
                EventCenter.instance.publish(omVar);
                c.b(activity, "webview", ".ui.tools.fts.FTSWebViewUI", fXX);
                ar.cO(21, optString);
                AppMethodBeat.o(30248);
            }
        });
        AppMethodBeat.o(30249);
    }

    @Override // com.tencent.mm.plugin.welab.a.a.b
    public final String gjl() {
        AppMethodBeat.i(30250);
        String optString = ak.aXe("discoverRecommendEntry").optString("labIcon");
        AppMethodBeat.o(30250);
        return optString;
    }

    @Override // com.tencent.mm.plugin.welab.a.a.b
    public final String gjm() {
        AppMethodBeat.i(30251);
        String optString = ak.aXe("discoverRecommendEntry").optString("wording");
        if (Util.isNullOrNil(optString)) {
            String string = MMApplicationContext.getContext().getString(R.string.cf5);
            AppMethodBeat.o(30251);
            return string;
        }
        AppMethodBeat.o(30251);
        return optString;
    }
}
