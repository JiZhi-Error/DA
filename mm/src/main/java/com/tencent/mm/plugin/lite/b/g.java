package com.tencent.mm.plugin.lite.b;

import android.os.Bundle;
import com.google.android.gms.actions.SearchIntents;
import com.tencent.liteapp.storage.WxaLiteAppInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h;
import com.tencent.mm.plugin.lite.c.b;
import com.tencent.mm.plugin.lite.launch.a;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.Map;

public final class g implements p {
    @Override // com.tencent.mm.plugin.messenger.foundation.a.p
    public final h.b a(String str, Map<String, String> map, h.a aVar) {
        final String[] strArr;
        AppMethodBeat.i(198887);
        Log.i("MicroMsg.LiteAppNewXmlConsumer", "liteapp consumeNewXml subtype: %s values: %s", str, map.toString());
        if (!map.containsKey(".sysmsg.mmlite.pkg_cdn_url") || !map.containsKey(".sysmsg.mmlite.app_id") || !map.containsKey(".sysmsg.mmlite.pkg_ecsda_pubkey") || !map.containsKey(".sysmsg.mmlite.pkg_md5")) {
            AppMethodBeat.o(198887);
        } else {
            com.tencent.mm.plugin.boots.a.g gVar = new com.tencent.mm.plugin.boots.a.g();
            gVar.appId = map.get(".sysmsg.mmlite.app_id");
            gVar.pkK = map.get(".sysmsg.mmlite.pkg_cdn_url");
            gVar.pkL = map.get(".sysmsg.mmlite.pkg_md5");
            gVar.crh = map.get(".sysmsg.mmlite.pkg_ecsda_pubkey");
            String[] strArr2 = new String[2];
            if (!map.containsKey(".sysmsg.mmlite.entry") || map.get(".sysmsg.mmlite.entry").isEmpty()) {
                strArr = strArr2;
            } else {
                Log.i("MicroMsg.LiteAppNewXmlConsumer", "liteapp consumeNewXml entry:" + map.get(".sysmsg.mmlite.entry"));
                strArr = b.bM(map.get(".sysmsg.mmlite.entry"), false);
            }
            e.INSTANCE.a(gVar, "debug", new a() {
                /* class com.tencent.mm.plugin.lite.b.g.AnonymousClass1 */

                @Override // com.tencent.mm.plugin.lite.launch.a
                public final void a(WxaLiteAppInfo wxaLiteAppInfo) {
                    AppMethodBeat.i(198886);
                    Bundle bundle = new Bundle();
                    bundle.putString("appId", wxaLiteAppInfo.appId);
                    if (strArr[0] != null) {
                        bundle.putString("path", strArr[0]);
                    }
                    if (strArr[1] != null) {
                        bundle.putString(SearchIntents.EXTRA_QUERY, strArr[1]);
                    }
                    ((com.tencent.mm.plugin.lite.a.a) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.lite.a.a.class)).a(MMApplicationContext.getContext(), bundle, false, null);
                    AppMethodBeat.o(198886);
                }

                @Override // com.tencent.mm.plugin.lite.launch.a
                public final void dTu() {
                }
            });
            AppMethodBeat.o(198887);
        }
        return null;
    }
}
