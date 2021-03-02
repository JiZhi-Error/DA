package com.tencent.mm.plugin.bbom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.p;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.n.g;
import com.tencent.mm.plugin.messenger.foundation.a.y;
import com.tencent.mm.protocal.protobuf.cqm;

public final class t implements y<cqm> {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.bw.a] */
    @Override // com.tencent.mm.plugin.messenger.foundation.a.y
    public final /* bridge */ /* synthetic */ void a(cqm cqm) {
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.bw.a] */
    @Override // com.tencent.mm.plugin.messenger.foundation.a.y
    public final /* synthetic */ void b(cqm cqm) {
        AppMethodBeat.i(22435);
        cqm cqm2 = cqm;
        p.aYn();
        g.oI(cqm2.Mwm);
        bg.aVF();
        c.clearPluginData(cqm2.KEc);
        com.tencent.mm.aj.c.LX(new StringBuilder().append(cqm2.LuA).toString());
        AppMethodBeat.o(22435);
    }
}
