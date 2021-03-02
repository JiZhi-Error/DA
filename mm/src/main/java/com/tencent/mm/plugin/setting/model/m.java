package com.tencent.mm.plugin.setting.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dtn;
import com.tencent.mm.protocal.protobuf.dto;
import com.tencent.mm.sdk.platformtools.Log;

public final class m extends q implements com.tencent.mm.network.m {
    private i callback;
    private final d rr;

    public m(String str, String str2) {
        this(str, str2, 0);
    }

    public m(String str, String str2, int i2) {
        AppMethodBeat.i(73780);
        d.a aVar = new d.a();
        aVar.iLN = new dtn();
        aVar.iLO = new dto();
        aVar.uri = "/cgi-bin/micromsg-bin/sendfeedback";
        aVar.funcId = 153;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        dtn dtn = (dtn) this.rr.iLK.iLR;
        dtn.MVC = str;
        dtn.iAc = str2;
        dtn.MlN = i2;
        AppMethodBeat.o(73780);
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(73781);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(73781);
        return dispatch;
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 153;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(73782);
        Log.d("MicroMsg.NetSendSceneFeedBack", "onGYNetEnd type:" + i3 + " code:" + i4);
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(73782);
    }
}
