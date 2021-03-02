package com.tencent.mm.plugin.account.friend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dwc;
import com.tencent.mm.protocal.protobuf.dwd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class an extends q implements m {
    private i callback;
    private final d rr;

    public an(String str) {
        AppMethodBeat.i(131145);
        d.a aVar = new d.a();
        aVar.iLN = new dwc();
        aVar.iLO = new dwd();
        aVar.uri = "/cgi-bin/micromsg-bin/newsetemailpwd";
        aVar.funcId = 382;
        aVar.iLP = 181;
        aVar.respCmdId = 1000000181;
        this.rr = aVar.aXF();
        ((dwc) this.rr.iLK.iLR).KQi = Util.getCutPasswordMD5(str);
        Log.d("MicroMsg.NetSceneSetEmailPwd", "md5 ".concat(String.valueOf(str)));
        AppMethodBeat.o(131145);
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(131146);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(131146);
        return dispatch;
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 382;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(131147);
        Log.d("MicroMsg.NetSceneSetEmailPwd", "onGYNetEnd  errType:" + i3 + " errCode:" + i4);
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(131147);
    }
}
