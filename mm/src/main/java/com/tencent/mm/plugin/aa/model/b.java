package com.tencent.mm.plugin.aa.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.aa.model.a.c;
import com.tencent.mm.plugin.aa.model.cgi.k;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.a;
import com.tencent.mm.protocal.protobuf.y;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vending.g.g;

public final class b implements i {
    com.tencent.mm.vending.g.b jSi;

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(63319);
        Log.i("MicroMsg.AAGetPaylistDetailLogic", "onSceneEnd, errType: %s, errCode: %s", Integer.valueOf(i2), Integer.valueOf(i3));
        if (i2 == 0 && i3 == 0) {
            y yVar = ((k) qVar).jTp;
            Log.i("MicroMsg.AAGetPaylistDetailLogic", "AAQueryDetailRes, onSceneEnd, retCode: %s", Integer.valueOf(yVar.dDN));
            if (yVar.dDN == 0) {
                g.a(this.jSi, yVar);
                h.INSTANCE.idkeyStat(407, 6, 1, false);
                c SD = com.tencent.mm.plugin.aa.b.blZ().SD(yVar.KBs);
                if (SD != null) {
                    SD.field_status = yVar.state;
                    com.tencent.mm.plugin.aa.b.blZ().b(SD);
                }
                AppMethodBeat.o(63319);
                return;
            }
            a aVar = yVar.KBE;
            if (aVar != null && aVar.cSx == 1) {
                this.jSi.ej(aVar);
            } else if (yVar.dDN <= 0 || Util.isNullOrNil(yVar.qwn)) {
                this.jSi.ej(Boolean.FALSE);
            } else {
                this.jSi.ej(yVar.qwn);
            }
            h.INSTANCE.idkeyStat(407, 8, 1, false);
            AppMethodBeat.o(63319);
            return;
        }
        if (this.jSi != null) {
            this.jSi.ej(Boolean.FALSE);
        }
        h.INSTANCE.idkeyStat(407, 7, 1, false);
        AppMethodBeat.o(63319);
    }
}
