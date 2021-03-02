package com.tencent.mm.plugin.sns.ad.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;

public final class c {
    public String finderLiveFeedExportId;
    public String finderLiveFeedNonceId;
    public String finderLiveId;
    public String finderUsername;

    public static c v(Map<String, String> map, String str) {
        AppMethodBeat.i(201851);
        if (com.tencent.mm.plugin.sns.ad.i.c.isEmpty(map)) {
            AppMethodBeat.o(201851);
            return null;
        }
        String str2 = map.get(str + ".finderUsername");
        if (TextUtils.isEmpty(str2)) {
            AppMethodBeat.o(201851);
            return null;
        }
        try {
            c cVar = new c();
            cVar.finderUsername = Util.nullAsNil(str2);
            cVar.finderLiveId = Util.nullAsNil(map.get(str + ".finderLiveId"));
            cVar.finderLiveFeedExportId = Util.nullAsNil(map.get(str + ".finderLiveFeedExportId"));
            cVar.finderLiveFeedNonceId = Util.nullAsNil(map.get(str + ".finderLiveFeedNonceId"));
            AppMethodBeat.o(201851);
            return cVar;
        } catch (Throwable th) {
            AppMethodBeat.o(201851);
            return null;
        }
    }
}
