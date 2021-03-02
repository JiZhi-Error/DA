package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import android.content.Intent;
import com.tencent.luggage.d.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.plugin.game.luggage.g.i;
import com.tencent.mm.plugin.webview.luggage.jsapi.br;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import java.util.HashMap;

public class w extends br<i> {
    @Override // com.tencent.luggage.d.b
    public final String name() {
        return "openGameRegion";
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final int dTs() {
        return 0;
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final void b(final b<i>.a aVar) {
        AppMethodBeat.i(83081);
        Log.i("MicroMsg.JsApiOpenGameRegion", "invoke");
        final MMActivity mMActivity = (MMActivity) aVar.cta.mContext;
        mMActivity.mmSetOnActivityResultCallback(new MMActivity.a() {
            /* class com.tencent.mm.plugin.game.luggage.b.w.AnonymousClass1 */

            @Override // com.tencent.mm.ui.MMActivity.a
            public final void d(int i2, int i3, Intent intent) {
                AppMethodBeat.i(83080);
                if (i2 == (w.this.hashCode() & 65535)) {
                    if (i3 == -1) {
                        if (intent != null) {
                            String nullAs = Util.nullAs(intent.getStringExtra("gameRegionName"), "");
                            HashMap hashMap = new HashMap();
                            hashMap.put("gameRegionName", nullAs);
                            aVar.e("", hashMap);
                        } else {
                            aVar.c("fail", null);
                        }
                    } else if (i3 == 1) {
                        aVar.c("fail", null);
                    } else {
                        aVar.c("cancel", null);
                    }
                    mMActivity.mmSetOnActivityResultCallback(null);
                }
                AppMethodBeat.o(83080);
            }
        });
        c.a((Context) mMActivity, "game", ".ui.GameRegionSelectUI", (Intent) null, hashCode() & 65535, false);
        AppMethodBeat.o(83081);
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final void a(Context context, String str, br.a aVar) {
    }
}
