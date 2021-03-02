package com.tencent.mm.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import java.util.Map;

public final class a implements p {
    @Override // com.tencent.mm.plugin.messenger.foundation.a.p
    public final h.b a(String str, Map<String, String> map, h.a aVar) {
        h ck;
        h.b bVar = null;
        AppMethodBeat.i(153088);
        if (!(str == null || !str.equals("abtest") || (ck = h.d.ck(-1879048184)) == null)) {
            bVar = ck.b(aVar);
        }
        AppMethodBeat.o(153088);
        return bVar;
    }
}
