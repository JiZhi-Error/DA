package com.tencent.mm.plugin.account.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.xj;
import com.tencent.mm.protocal.protobuf.xk;
import com.tencent.mm.sdk.platformtools.Log;

public final class f extends q implements m {
    private i callback;
    public String fMb;
    private d iUB;

    public f(String str) {
        AppMethodBeat.i(196846);
        d.a aVar = new d.a();
        xj xjVar = new xj();
        xjVar.fMb = str;
        this.fMb = str;
        aVar.iLN = xjVar;
        aVar.iLO = new xk();
        aVar.uri = "/cgi-bin/micromsg-bin/checkaliasvalid";
        aVar.funcId = getType();
        this.iUB = aVar.aXF();
        AppMethodBeat.o(196846);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 3516;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(196847);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.iUB, this);
        AppMethodBeat.o(196847);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(196848);
        Log.i("MicroMsg.NetSceneCheckAliasValid", "errType %d, errCode %d, errMsg %s", Integer.valueOf(i3), Integer.valueOf(i4), str);
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(196848);
    }
}
