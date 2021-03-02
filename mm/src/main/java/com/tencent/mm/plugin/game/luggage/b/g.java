package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.plugin.webview.luggage.jsapi.br;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONArray;
import org.json.JSONException;

public class g extends br<com.tencent.luggage.d.a> {
    @Override // com.tencent.luggage.d.b
    public final String name() {
        return "clearGameData";
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final int dTs() {
        return 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x00ab  */
    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b(final com.tencent.luggage.d.b<com.tencent.luggage.d.a>.a r8) {
        /*
        // Method dump skipped, instructions count: 192
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.game.luggage.b.g.b(com.tencent.luggage.d.b$a):void");
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final void a(Context context, String str, br.a aVar) {
        AppMethodBeat.i(83063);
        AppMethodBeat.o(83063);
    }

    static class a implements b<Bundle, Bundle> {
        private a() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public /* synthetic */ void invoke(Bundle bundle, d<Bundle> dVar) {
            AppMethodBeat.i(186853);
            Bundle bundle2 = bundle;
            String string = bundle2.getString("appId");
            String string2 = bundle2.getString("keys");
            if (bundle2.getBoolean("clearAllData")) {
                com.tencent.mm.plugin.webview.b.b.gam().aXT(string);
            } else if (!Util.isNullOrNil(string2)) {
                try {
                    com.tencent.mm.plugin.webview.b.b.gam().b(string, new JSONArray(string2));
                } catch (JSONException e2) {
                }
            }
            dVar.bn(null);
            AppMethodBeat.o(186853);
        }
    }
}
