package com.tencent.mm.plugin.sns.ui.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.protocal.protobuf.ami;
import com.tencent.mm.sdk.platformtools.Log;

public final class c extends a {
    public c() {
        super(new SnsInfo());
        AppMethodBeat.i(99844);
        hdm();
        AppMethodBeat.o(99844);
    }

    @Override // com.tencent.mm.plugin.sns.ui.a.b.b
    public final String L(long j2, String str) {
        AppMethodBeat.i(179324);
        Log.printDebugStack("MicroMsg.SnsTimeLineVending", "updateDownLimitSeq", new Object[0]);
        Log.d("MicroMsg.SnsTimeLineVending", "updateLitmitSeq %s %s", Integer.valueOf(aj.faE().fbw()), str);
        String Jc = r.Jc(aj.faO().g(j2, str.equals("") ? aj.faE().fbw() / 2 : aj.faE().fbw(), false));
        String fkh = fkh();
        if (!fkh.equals("") && Jc.compareTo(fkh) >= 0) {
            Jc = fkh;
        }
        ami feM = aj.faS().aQr("@__weixintimtline").feM();
        if (feM.Lvc == 0) {
            AppMethodBeat.o(179324);
            return Jc;
        }
        String Jc2 = r.Jc(feM.Lvc);
        if (Jc.equals("")) {
            AppMethodBeat.o(179324);
            return Jc2;
        } else if (Jc2.compareTo(Jc) > 0) {
            AppMethodBeat.o(179324);
            return Jc2;
        } else {
            AppMethodBeat.o(179324);
            return Jc;
        }
    }

    @Override // com.tencent.mm.plugin.sns.ui.a.b.b
    public final String JV(long j2) {
        AppMethodBeat.i(179325);
        Log.d("MicroMsg.SnsTimeLineVending", "updateUpLimitSeq %s", Integer.valueOf(aj.faE().fbw()));
        String Jc = r.Jc(aj.faO().h(j2, aj.faE().fbw(), false));
        String fkd = fkd();
        if (fkd.equals("")) {
            AppMethodBeat.o(179325);
            return Jc;
        } else if (Jc.compareTo(fkd) <= 0) {
            AppMethodBeat.o(179325);
            return Jc;
        } else {
            AppMethodBeat.o(179325);
            return "";
        }
    }
}
