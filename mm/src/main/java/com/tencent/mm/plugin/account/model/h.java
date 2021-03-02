package com.tencent.mm.plugin.account.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.der;
import com.tencent.mm.protocal.protobuf.des;
import com.tencent.mm.sdk.platformtools.Log;

public final class h extends q implements m {
    private i callback;
    private d hJu;
    private der kit = ((der) this.hJu.iLK.iLR);

    public h(int i2, String str) {
        AppMethodBeat.i(127832);
        d.a aVar = new d.a();
        aVar.iLN = new der();
        aVar.iLO = new des();
        aVar.funcId = getType();
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        aVar.uri = "/cgi-bin/micromsg-bin/privacypolicychoise";
        this.hJu = aVar.aXF();
        this.kit.MJM = i2;
        this.kit.keh = str;
        AppMethodBeat.o(127832);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 268;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(127833);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.hJu, this);
        AppMethodBeat.o(127833);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(127834);
        Log.i("MicroMsg.NetScenePrivacyPolicyChoice", "errType %d,errCode %d,errMsg %s", Integer.valueOf(i3), Integer.valueOf(i4), str);
        if (this.callback != null) {
            this.callback.onSceneEnd(i3, i4, str, this);
        }
        AppMethodBeat.o(127834);
    }
}
