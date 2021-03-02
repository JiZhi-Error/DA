package com.tencent.mm.plugin.webwx.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.akx;
import com.tencent.mm.protocal.protobuf.aky;

public final class e extends q implements m {
    private i callback;
    public final d iUB;
    public boolean yAX;

    public e(String str, String str2, boolean z) {
        AppMethodBeat.i(30178);
        this.yAX = z;
        d.a aVar = new d.a();
        akx akx = new akx();
        aky aky = new aky();
        aVar.iLN = akx;
        aVar.iLO = aky;
        aVar.uri = "/cgi-bin/micromsg-bin/extdeviceloginconfirmok";
        aVar.funcId = 972;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        akx.LtA = str;
        akx.LtL = str2;
        akx.LtN = z;
        this.iUB = aVar.aXF();
        AppMethodBeat.o(30178);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 972;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(30179);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.iUB, this);
        AppMethodBeat.o(30179);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(30180);
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(30180);
    }
}
