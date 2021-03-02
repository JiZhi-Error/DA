package com.tencent.luggage.game.d.b;

import com.tencent.luggage.game.widget.input.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import org.json.JSONObject;

public final class d extends com.tencent.mm.plugin.appbrand.jsapi.d<s> {
    private static final int CTRL_INDEX = 70;
    private static final String NAME = "hideKeyboard";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(s sVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(130610);
        final s sVar2 = sVar;
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.luggage.game.d.b.d.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(130609);
                ac currentPageView = sVar2.getCurrentPageView();
                if (currentPageView == null) {
                    AppMethodBeat.o(130609);
                    return;
                }
                a cd = a.cd(currentPageView.getContentView());
                if (cd != null) {
                    cd.hide();
                }
                AppMethodBeat.o(130609);
            }
        });
        sVar2.i(i2, h("ok", null));
        AppMethodBeat.o(130610);
    }
}
