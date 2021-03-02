package com.tencent.mm.plugin.sns.ad.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.i.c;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;

public final class f {
    public String DrX;
    public String finderUsername;
    public String objectNonceId;

    public static f A(Map<String, String> map, String str) {
        AppMethodBeat.i(201856);
        if (c.isEmpty(map) || TextUtils.isEmpty(str)) {
            AppMethodBeat.o(201856);
            return null;
        }
        try {
            f fVar = new f();
            fVar.finderUsername = Util.nullAsNil(map.get(str + ".finderUsername"));
            fVar.DrX = Util.nullAsNil(map.get(str + ".exportId"));
            fVar.objectNonceId = Util.nullAsNil(map.get(str + ".objectNonceId"));
            AppMethodBeat.o(201856);
            return fVar;
        } catch (Throwable th) {
            AppMethodBeat.o(201856);
            return null;
        }
    }
}
