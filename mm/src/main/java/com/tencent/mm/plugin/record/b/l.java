package com.tencent.mm.plugin.record.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bp;
import com.tencent.mm.plugin.record.a.f;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.ca;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class l implements f {
    private Map<Long, String> BGY = Collections.synchronizedMap(new HashMap());

    public l() {
        AppMethodBeat.i(215181);
        AppMethodBeat.o(215181);
    }

    @Override // com.tencent.mm.plugin.record.a.f
    public final void C(long j2, String str) {
        AppMethodBeat.i(215182);
        this.BGY.put(Long.valueOf(j2), str);
        AppMethodBeat.o(215182);
    }

    @Override // com.tencent.mm.plugin.record.a.f
    public final void HQ(long j2) {
        AppMethodBeat.i(215183);
        if (this.BGY.keySet().contains(Long.valueOf(j2))) {
            jz(this.BGY.get(Long.valueOf(j2)), MMApplicationContext.getContext().getString(R.string.ad4));
            this.BGY.remove(Long.valueOf(j2));
        }
        AppMethodBeat.o(215183);
    }

    @Override // com.tencent.mm.plugin.record.a.f
    public final void D(long j2, String str) {
        AppMethodBeat.i(215184);
        if (this.BGY.keySet().contains(Long.valueOf(j2))) {
            jz(str, MMApplicationContext.getContext().getString(R.string.ad4));
            this.BGY.remove(Long.valueOf(j2));
        }
        AppMethodBeat.o(215184);
    }

    private static void jz(String str, String str2) {
        AppMethodBeat.i(215185);
        ca caVar = new ca();
        caVar.setCreateTime(bp.Kw(str));
        caVar.Cy(str);
        caVar.setContent(str2);
        caVar.setType(10000);
        caVar.setStatus(6);
        caVar.nv(0);
        ((com.tencent.mm.plugin.messenger.foundation.a.l) g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().aC(caVar);
        AppMethodBeat.o(215185);
    }
}
