package com.tencent.mm.plugin.aa.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vending.g.b;

public final class j implements i {
    b jSE;
    long msgId = -1;

    public final void init() {
        AppMethodBeat.i(63356);
        g.aAi();
        g.aAg().hqi.a(1530, this);
        AppMethodBeat.o(63356);
    }

    public final void unInit() {
        AppMethodBeat.i(63357);
        g.aAi();
        g.aAg().hqi.b(1530, this);
        AppMethodBeat.o(63357);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(63358);
        Log.i("MicroMsg.CloseAALogic", "onSceneEnd, errType: %s, errCode: %s", Integer.valueOf(i2), Integer.valueOf(i3));
        if (i2 == 0 && i3 == 0) {
            e eVar = ((com.tencent.mm.plugin.aa.model.cgi.e) qVar).jTd;
            Log.i("MicroMsg.CloseAALogic", "closeAA, response.retcode: %s", Integer.valueOf(eVar.dDN));
            Log.d("MicroMsg.CloseAALogic", "closeAA, response.msgxml: %s", eVar.KBu);
            if (eVar.dDN == 0) {
                com.tencent.mm.vending.g.g.a(this.jSE, Boolean.TRUE);
                if (!Util.isNullOrNil(eVar.KBu) && this.msgId > 0 && ((com.tencent.mm.plugin.aa.model.cgi.e) qVar).scene == a.jSe) {
                    i.i(this.msgId, eVar.KBu);
                }
                h.INSTANCE.idkeyStat(407, 21, 1, false);
                AppMethodBeat.o(63358);
            } else if (eVar.dDN <= 0 || Util.isNullOrNil(eVar.qwn)) {
                this.jSE.ej(Boolean.FALSE);
                h.INSTANCE.idkeyStat(407, 23, 1, false);
                AppMethodBeat.o(63358);
            } else {
                this.jSE.ej(eVar.qwn);
                h.INSTANCE.idkeyStat(407, 11, 1, false);
                AppMethodBeat.o(63358);
            }
        } else {
            this.jSE.ej(Boolean.FALSE);
            h.INSTANCE.idkeyStat(407, 22, 1, false);
            AppMethodBeat.o(63358);
        }
    }
}
