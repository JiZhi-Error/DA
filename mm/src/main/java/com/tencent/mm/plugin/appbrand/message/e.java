package com.tencent.mm.plugin.appbrand.message;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.messenger.a.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;

public final class e implements e.a {
    @Override // com.tencent.mm.plugin.messenger.a.e.a
    public final String f(Map<String, String> map, String str) {
        AppMethodBeat.i(47715);
        if (map == null || map.isEmpty()) {
            Log.w("MicroMsg.WxaSysTemplateMsgDigestHandler", "values map is null or nil");
            AppMethodBeat.o(47715);
            return "";
        }
        String nullAsNil = Util.nullAsNil(map.get(str + ".title"));
        AppMethodBeat.o(47715);
        return nullAsNil;
    }
}
