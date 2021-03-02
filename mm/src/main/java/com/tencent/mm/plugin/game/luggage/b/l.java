package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.plugin.webview.luggage.jsapi.br;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;

public class l extends br<com.tencent.luggage.d.a> {
    @Override // com.tencent.luggage.d.b
    public final String name() {
        return "getGameData";
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final int dTs() {
        return 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x009b  */
    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b(final com.tencent.luggage.d.b<com.tencent.luggage.d.a>.a r7) {
        /*
        // Method dump skipped, instructions count: 191
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.game.luggage.b.l.b(com.tencent.luggage.d.b$a):void");
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final void a(Context context, String str, br.a aVar) {
    }

    static class a implements b<Bundle, Bundle> {
        private a() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public /* synthetic */ void invoke(Bundle bundle, d<Bundle> dVar) {
            AppMethodBeat.i(83068);
            Bundle bundle2 = bundle;
            com.tencent.mm.plugin.webview.b.a lN = com.tencent.mm.plugin.webview.b.b.gam().lN(bundle2.getString("appId"), bundle2.getString("key"));
            Bundle bundle3 = new Bundle();
            bundle3.putString("value", lN.field_value);
            bundle3.putString("weight", lN.field_weight);
            bundle3.putLong("expireTime", lN.field_expireTime - (System.currentTimeMillis() / 1000));
            bundle3.putString(DownloadInfo.FILENAME, lN.field_localFile);
            dVar.bn(bundle3);
            AppMethodBeat.o(83068);
        }
    }
}
