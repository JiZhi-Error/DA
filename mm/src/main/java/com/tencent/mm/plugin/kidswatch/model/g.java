package com.tencent.mm.plugin.kidswatch.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cgm;
import com.tencent.mm.protocal.protobuf.cgr;
import com.tencent.mm.protocal.protobuf.cgs;

public final class g extends q implements m {
    private i callback;
    private final d iUB;
    private boolean yAX = false;

    public g(String str, String str2, int i2, cgm cgm) {
        AppMethodBeat.i(256404);
        d.a aVar = new d.a();
        cgr cgr = new cgr();
        cgs cgs = new cgs();
        aVar.iLN = cgr;
        aVar.iLO = cgs;
        aVar.uri = "/cgi-bin/micromsg-bin/extdeviceloginconfirmok";
        aVar.funcId = 972;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        cgr.LtA = str;
        cgr.LtL = str2;
        cgr.LtN = false;
        cgr.MlY = i2;
        cgr.MlZ = cgm;
        this.iUB = aVar.aXF();
        AppMethodBeat.o(256404);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 972;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(com.tencent.mm.network.g gVar, i iVar) {
        AppMethodBeat.i(256405);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.iUB, this);
        AppMethodBeat.o(256405);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(256406);
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(256406);
    }
}
