package com.tencent.mm.plugin.mall.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d;
import com.tencent.mm.protocal.protobuf.czt;
import com.tencent.mm.protocal.protobuf.kc;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import java.util.List;

public final class a extends c<kd> {
    public List<czt> zji;

    public a(LinkedList<czt> linkedList, int i2) {
        AppMethodBeat.i(65987);
        kc kcVar = new kc();
        kcVar.KOq = linkedList;
        kcVar.KOr = i2;
        kcVar.KOs = 0;
        d.a aVar = new d.a();
        aVar.iLN = kcVar;
        aVar.iLO = new kd();
        aVar.funcId = 2938;
        aVar.uri = "/cgi-bin/micromsg-bin/batchfunctionoperate";
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        c(aVar.aXF());
        this.zji = linkedList;
        Log.i("MicroMsg.CgiBatchFunctionOperate", "TpaCountry: %s", Integer.valueOf(i2));
        AppMethodBeat.o(65987);
    }
}
