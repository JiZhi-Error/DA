package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.protocal.protobuf.bvh;
import com.tencent.mm.protocal.protobuf.bvi;
import com.tencent.mm.sdk.platformtools.Log;

public final class d extends c<bvi> {
    public d(String str, int i2) {
        AppMethodBeat.i(258570);
        bvh bvh = new bvh();
        d.a aVar = new d.a();
        aVar.iLN = bvh;
        aVar.iLO = new bvi();
        boolean z = ((b) g.af(b.class)).a(b.a.clicfg_hongbao_envelope_transfer_new_cgi, 1) == 1;
        Log.d("CgiGetShowSource", "is new: %s", Boolean.valueOf(z));
        if (z) {
            aVar.funcId = 3857;
            aVar.uri = "/cgi-bin/micromsg-bin/getshowsourcenew";
        } else {
            aVar.funcId = 2620;
            aVar.uri = "/cgi-bin/mmpay-bin/ftfhb/getshowsource";
        }
        bvh.Mbr = str;
        bvh.VjL = i2;
        c(aVar.aXF());
        AppMethodBeat.o(258570);
    }
}
