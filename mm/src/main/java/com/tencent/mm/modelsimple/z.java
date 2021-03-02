package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dmn;
import com.tencent.mm.protocal.protobuf.dwg;
import com.tencent.mm.protocal.protobuf.dwh;
import com.tencent.mm.sdk.platformtools.Log;

public final class z extends q implements m {
    private i callback;
    public final d iUB;

    public z(int i2, dmn dmn) {
        AppMethodBeat.i(20647);
        Log.i("MicroMsg.NetSceneSetMsgRemind", "[NetSceneSetMsgRemind] opType:%s RemindId:%s time:%s Type:%s SubType:%s", Integer.valueOf(i2), dmn.MQb, Integer.valueOf(dmn.rBX), Integer.valueOf(dmn.oUv), Integer.valueOf(dmn.MJT));
        d.a aVar = new d.a();
        aVar.iLN = new dwg();
        aVar.iLO = new dwh();
        aVar.uri = "/cgi-bin/micromsg-bin/setmsgremind";
        aVar.funcId = 525;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.iUB = aVar.aXF();
        dwg dwg = (dwg) this.iUB.iLK.iLR;
        dwg.him = i2 == 0 ? 1 : i2;
        dwg.MWJ = dmn;
        AppMethodBeat.o(20647);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 525;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(20648);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.iUB, this);
        AppMethodBeat.o(20648);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(20649);
        if (i3 == 0 && i4 == 0) {
            Log.i("MicroMsg.NetSceneSetMsgRemind", "[onGYNetEnd] RemindId:%s", ((dwh) this.iUB.iLL.iLR).MQb);
        } else {
            Log.e("MicroMsg.NetSceneSetMsgRemind", "[onGYNetEnd] errType:%s,errCode:%s,errMsg:%s", Integer.valueOf(i3), Integer.valueOf(i4), str);
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(20649);
    }
}
