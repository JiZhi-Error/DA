package com.tencent.mm.chatroom.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dpv;
import com.tencent.mm.protocal.protobuf.dpw;
import com.tencent.mm.protocal.protobuf.dqb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class r extends q implements m {
    private i callback;
    private String errMsg;
    private dpw gsr;
    private final d rr;

    public r(String str, int i2, dqb dqb) {
        AppMethodBeat.i(182085);
        Log.i("MicroMsg.roomTodo.NetSceneRoomToolsAlterTodo", "NetSceneRoomToolsAlterTodo chatRoomName:%s op:%s roomToolsTodo%s", Util.nullAs(str, ""), Integer.valueOf(i2), y.a(dqb));
        d.a aVar = new d.a();
        aVar.uri = "/cgi-bin/micromsg-bin/roomtoolsaltertodo";
        aVar.funcId = 3618;
        aVar.iLN = new dpv();
        aVar.iLO = new dpw();
        this.rr = aVar.aXF();
        dpv dpv = (dpv) this.rr.iLK.iLR;
        dpv.KGO = Util.nullAs(str, "");
        dpv.MSV = i2;
        dpv.MSW = dqb;
        AppMethodBeat.o(182085);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 3618;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(182086);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(182086);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(182087);
        Log.d("MicroMsg.roomTodo.NetSceneRoomToolsAlterTodo", "onGYNetEnd:[%d,%d,%s]", Integer.valueOf(i3), Integer.valueOf(i4), str);
        this.gsr = (dpw) ((d) sVar).iLL.iLR;
        this.callback.onSceneEnd(i3, i4, str, this);
        this.errMsg = str;
        AppMethodBeat.o(182087);
    }
}
