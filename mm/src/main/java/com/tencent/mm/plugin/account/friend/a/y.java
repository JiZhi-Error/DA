package com.tencent.mm.plugin.account.friend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.mf;
import com.tencent.mm.protocal.protobuf.mg;
import com.tencent.mm.sdk.platformtools.Log;

public final class y extends q implements m {
    private i callback;
    public d hJu;

    public y(String str) {
        AppMethodBeat.i(184422);
        d.a aVar = new d.a();
        aVar.funcId = getType();
        mf mfVar = new mf();
        mfVar.dTx = str;
        aVar.iLN = mfVar;
        aVar.uri = "/cgi-bin/micromsg-bin/bindoldwx";
        aVar.iLO = new mg();
        this.hJu = aVar.aXF();
        AppMethodBeat.o(184422);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 870;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(184423);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.hJu, this);
        AppMethodBeat.o(184423);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(184424);
        Log.i("MicroMsg.NetSceneBindOldWx", "errType %d, errCode %d, errMsg %s", Integer.valueOf(i3), Integer.valueOf(i4), str);
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(184424);
    }
}
