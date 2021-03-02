package com.tencent.mm.plugin.account.friend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.c;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.alw;
import com.tencent.mm.protocal.protobuf.alx;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class w extends q implements m {
    private i callback;
    public int opType;
    private d rr;

    public w(int i2, String str) {
        AppMethodBeat.i(131079);
        this.opType = i2;
        d.a aVar = new d.a();
        aVar.iLN = new alw();
        aVar.iLO = new alx();
        aVar.uri = "/cgi-bin/micromsg-bin/facebookauth";
        aVar.funcId = 183;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        alw alw = (alw) this.rr.iLK.iLR;
        alw.Luy = Util.isNullOrNil(str) ? "" : str;
        alw.him = i2;
        AppMethodBeat.o(131079);
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(131080);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(131080);
        return dispatch;
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 183;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(131081);
        updateDispatchId(i2);
        Log.d("MicroMsg.NetSceneFaceBookAuth", "onGYNetEnd errType:" + i3 + " errCode:" + i4);
        if (i3 == 0 && i4 == 0) {
            alx alx = (alx) this.rr.iLL.iLR;
            int i5 = alx.getBaseResponse().Ret;
            if (i5 != 0) {
                Log.e("MicroMsg.NetSceneFaceBookAuth", "baseresponse.ret = ".concat(String.valueOf(i5)));
                this.callback.onSceneEnd(4, i5, str, this);
                AppMethodBeat.o(131081);
                return;
            }
            Log.d("MicroMsg.NetSceneFaceBookAuth", "fbuserid = " + alx.LuA + ", fbusername = " + alx.LuB);
            if (this.opType == 0 || this.opType == 1) {
                com.tencent.mm.kernel.g.aAh().azQ().set(65825, new StringBuilder().append(alx.LuA).toString());
                c.LX(new StringBuilder().append(alx.LuA).toString());
                com.tencent.mm.kernel.g.aAh().azQ().set(65826, alx.LuB);
                com.tencent.mm.kernel.g.aAh().azQ().gBI();
            }
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(131081);
    }
}
