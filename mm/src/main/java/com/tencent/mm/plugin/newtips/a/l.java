package com.tencent.mm.plugin.newtips.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.plugin.newtips.b.c;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class l implements p {
    private static final Long duN = 604800L;
    private ConcurrentHashMap<String, a> ADO = new ConcurrentHashMap<>();

    public interface a {
        boolean a(long j2, String str, List<c> list, Map<String, String> map);

        boolean b(long j2, String str, List<c> list, Map<String, String> map);
    }

    public l() {
        AppMethodBeat.i(188566);
        AppMethodBeat.o(188566);
    }

    static {
        AppMethodBeat.i(127261);
        AppMethodBeat.o(127261);
    }

    public final void a(String str, a aVar) {
        AppMethodBeat.i(188567);
        this.ADO.put(str, aVar);
        AppMethodBeat.o(188567);
    }

    /* JADX WARNING: Removed duplicated region for block: B:224:0x0923  */
    /* JADX WARNING: Removed duplicated region for block: B:230:0x093a  */
    /* JADX WARNING: Removed duplicated region for block: B:234:0x0948  */
    /* JADX WARNING: Removed duplicated region for block: B:238:0x0959  */
    /* JADX WARNING: Removed duplicated region for block: B:249:0x096d A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0150  */
    @Override // com.tencent.mm.plugin.messenger.foundation.a.p
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.tencent.mm.ak.h.b a(java.lang.String r28, java.util.Map<java.lang.String, java.lang.String> r29, com.tencent.mm.ak.h.a r30) {
        /*
        // Method dump skipped, instructions count: 2434
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.newtips.a.l.a(java.lang.String, java.util.Map, com.tencent.mm.ak.h$a):com.tencent.mm.ak.h$b");
    }
}
