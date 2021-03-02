package com.tencent.mm.plugin.aa.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.aa.model.cgi.j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.r;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vending.g.b;

public final class g implements i {
    boolean jSA = false;
    b jSi;

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(63334);
        Log.i("MicroMsg.AAPayLogic", "AAPayLogic, onSceneEnd, errType: %s, errCode: %s", Integer.valueOf(i2), Integer.valueOf(i3));
        this.jSA = false;
        if (i2 == 0 && i3 == 0) {
            r rVar = ((j) qVar).jTn;
            Log.i("MicroMsg.AAPayLogic", "AAPayLogic, onSceneEnd, retcode: %s, retmsg: %s", Integer.valueOf(rVar.dDN), rVar.qwn);
            if (rVar.dDN == 0) {
                com.tencent.mm.vending.g.g.a(this.jSi, rVar);
                h.INSTANCE.idkeyStat(407, 9, 1, false);
                AppMethodBeat.o(63334);
                return;
            }
            if (this.jSi != null) {
                if (rVar.KBE != null && rVar.KBE.cSx == 1 && !Util.isNullOrNil(rVar.KBE.qwt) && !Util.isNullOrNil(rVar.KBE.lHA) && !Util.isNullOrNil(rVar.KBE.lHB) && !Util.isNullOrNil(rVar.KBE.dQx)) {
                    this.jSi.ej(rVar.KBE);
                } else if (rVar.dDN <= 0 || Util.isNullOrNil(rVar.qwn)) {
                    this.jSi.ej(Boolean.FALSE);
                } else {
                    this.jSi.ej(rVar.qwn);
                }
            }
            h.INSTANCE.idkeyStat(407, 11, 1, false);
            AppMethodBeat.o(63334);
            return;
        }
        if (this.jSi != null) {
            this.jSi.ej(Boolean.FALSE);
        }
        h.INSTANCE.idkeyStat(407, 10, 1, false);
        AppMethodBeat.o(63334);
    }
}
