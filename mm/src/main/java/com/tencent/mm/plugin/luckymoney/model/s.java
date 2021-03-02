package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.cbz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.as;

public final class s {
    public static void hWc() {
        AppMethodBeat.i(258583);
        if (((int) ((l) g.af(l.class)).aSN().bjJ("1@fackuser").gMZ) > 0) {
            ((l) g.af(l.class)).aSN().aNa("1@fackuser");
        }
        as asVar = new as();
        asVar.setUsername("1@fackuser");
        asVar.setNickname(MMApplicationContext.getContext().getString(R.string.erg));
        asVar.aqQ();
        asVar.gMZ = -99;
        asVar.ni(3);
        ((l) g.af(l.class)).aSN().am(asVar);
        AppMethodBeat.o(258583);
    }

    public static void hWd() {
        AppMethodBeat.i(258584);
        Log.d("MicroMsg.LuckyMoneyEnvelopePreview", "before cursor: %s", Integer.valueOf(((l) g.af(l.class)).eiy().aEv("1@fackuser").getCount()));
        ((l) g.af(l.class)).eiy().aEE("1@fackuser");
        Log.d("MicroMsg.LuckyMoneyEnvelopePreview", "after cursor: %s", Integer.valueOf(((l) g.af(l.class)).eiy().aEv("1@fackuser").getCount()));
        AppMethodBeat.o(258584);
    }

    static /* synthetic */ cbz h(d dVar) {
        return (cbz) dVar.iLL.iLR;
    }
}
