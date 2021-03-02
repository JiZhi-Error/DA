package com.tencent.mm.plugin.welab.c;

import android.app.Activity;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.br.c;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.plugin.websearch.api.ak;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;

public final class b implements com.tencent.mm.plugin.welab.a.a.b {
    @Override // com.tencent.mm.plugin.welab.a.a.b
    public final void m(Activity activity, String str) {
        AppMethodBeat.i(30252);
        if (!ai.afs(0)) {
            Log.e("MicroMsg.FTS.SearchOneSearchOpener", "fts h5 template not avail");
            AppMethodBeat.o(30252);
            return;
        }
        Intent fXX = ai.fXX();
        fXX.putExtra("ftsbizscene", 20);
        Map<String, String> h2 = ai.h(20, true, 0);
        fXX.putExtra("ftsneedkeyboard", true);
        fXX.putExtra("rawUrl", ai.bd(h2));
        c.b(activity, "webview", ".ui.tools.fts.FTSSearchOneSearchWebViewUI", fXX);
        AppMethodBeat.o(30252);
    }

    @Override // com.tencent.mm.plugin.welab.a.a.b
    public final String gjl() {
        AppMethodBeat.i(30253);
        String optString = ak.aXe("discoverSearchEntry").optString("labIcon");
        AppMethodBeat.o(30253);
        return optString;
    }

    @Override // com.tencent.mm.plugin.welab.a.a.b
    public final String gjm() {
        AppMethodBeat.i(30254);
        String optString = ak.aXe("discoverSearchEntry").optString("wording");
        if (Util.isNullOrNil(optString)) {
            String string = MMApplicationContext.getContext().getString(R.string.cf5);
            AppMethodBeat.o(30254);
            return string;
        }
        AppMethodBeat.o(30254);
        return optString;
    }
}
