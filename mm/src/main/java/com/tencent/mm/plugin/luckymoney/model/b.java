package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.protocal.protobuf.adf;
import com.tencent.mm.protocal.protobuf.adg;

public final class b extends c<adg> {
    public b(String str) {
        AppMethodBeat.i(65161);
        adf adf = new adf();
        adf.Lot = str;
        d.a aVar = new d.a();
        aVar.iLN = adf;
        aVar.iLO = new adg();
        if (((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_hongbao_envelope_transfer_new_cgi, 1) == 1) {
            aVar.funcId = 479;
            aVar.uri = "/cgi-bin/micromsg-bin/confirmshowsourcenew";
        } else {
            aVar.funcId = 2968;
            aVar.uri = "/cgi-bin/mmpay-bin/ftfhb/confirmshowsource";
        }
        c(aVar.aXF());
        AppMethodBeat.o(65161);
    }
}
