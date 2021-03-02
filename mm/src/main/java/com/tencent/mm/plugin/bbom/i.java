package com.tencent.mm.plugin.bbom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.g;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.y;
import com.tencent.mm.protocal.protobuf.afh;

public final class i implements y<afh> {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.bw.a] */
    @Override // com.tencent.mm.plugin.messenger.foundation.a.y
    public final /* bridge */ /* synthetic */ void a(afh afh) {
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.bw.a] */
    @Override // com.tencent.mm.plugin.messenger.foundation.a.y
    public final /* synthetic */ void b(afh afh) {
        AppMethodBeat.i(22359);
        String a2 = z.a(afh.Lqk);
        if (g.Ne(a2)) {
            g.Nj(a2);
        }
        AppMethodBeat.o(22359);
    }
}
