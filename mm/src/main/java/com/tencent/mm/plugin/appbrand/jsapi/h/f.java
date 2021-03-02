package com.tencent.mm.plugin.appbrand.jsapi.h;

import android.os.Looper;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ab;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.widget.input.h;
import com.tencent.mm.plugin.appbrand.widget.input.w;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.SyncTask;
import org.json.JSONObject;

public final class f extends ab<ac> {
    private static final int CTRL_INDEX = -2;
    private static final String NAME = "restoreWebviewFocus";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.ab
    public final /* synthetic */ String a(ac acVar, JSONObject jSONObject) {
        AppMethodBeat.i(136273);
        final ac acVar2 = acVar;
        final boolean optBoolean = jSONObject.optBoolean("focus", false);
        new SyncTask<Void>() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.h.f.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // com.tencent.mm.sdk.platformtools.SyncTask
            public final /* synthetic */ Void run() {
                AppMethodBeat.i(136272);
                ac acVar = acVar2;
                boolean z = optBoolean;
                h.cbe().e(acVar.nmX);
                View contentView = acVar.nmX.getContentView();
                if (z) {
                    w b2 = w.b(contentView, acVar.bRo());
                    if (b2 != null) {
                        b2.setShowDoneButton(false);
                    }
                    contentView.requestFocus();
                }
                AppMethodBeat.o(136272);
                return null;
            }
        }.exec(new MMHandler(Looper.getMainLooper()));
        String h2 = h("ok", null);
        AppMethodBeat.o(136273);
        return h2;
    }
}
