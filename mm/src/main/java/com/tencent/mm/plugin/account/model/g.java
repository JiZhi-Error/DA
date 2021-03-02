package com.tencent.mm.plugin.account.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.yc;
import com.tencent.mm.protocal.protobuf.yd;
import com.tencent.mm.sdk.platformtools.Log;

public final class g extends q implements m {
    private i callback;
    public d iUB;

    public g() {
        AppMethodBeat.i(196849);
        d.a aVar = new d.a();
        aVar.iLN = new yc();
        aVar.iLO = new yd();
        aVar.uri = "/cgi-bin/micromsg-bin/checkcansetalias";
        aVar.funcId = getType();
        this.iUB = aVar.aXF();
        AppMethodBeat.o(196849);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 926;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(com.tencent.mm.network.g gVar, i iVar) {
        AppMethodBeat.i(196850);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.iUB, this);
        AppMethodBeat.o(196850);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(196851);
        Log.i("MicroMsg.NetSceneCheckModifyAlias", "errType %d, errCode %d, errMsg %s", Integer.valueOf(i3), Integer.valueOf(i4), str);
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(196851);
    }
}
