package com.tencent.mm.chatroom.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dpz;
import com.tencent.mm.protocal.protobuf.dqa;
import com.tencent.mm.protocal.protobuf.dqb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class t extends q implements m {
    private i callback;
    private String errMsg;
    private dqa gst;
    private final d rr;

    public t(String str, String str2, String str3, dqb dqb) {
        AppMethodBeat.i(182091);
        Log.i("MicroMsg.roomTodo.NetSceneRoomToolsReplyTodo", "NetSceneRoomToolsReplyTodo chatRoomName:%s creator:%s", Util.nullAs(str, ""), Util.nullAs(str2, ""), Util.nullAs(str3, ""), y.a(dqb));
        d.a aVar = new d.a();
        aVar.uri = "/cgi-bin/micromsg-bin/roomtoolsreplytodo";
        aVar.funcId = 3854;
        aVar.iLN = new dpz();
        aVar.iLO = new dqa();
        this.rr = aVar.aXF();
        dpz dpz = (dpz) this.rr.iLK.iLR;
        dpz.KGO = Util.nullAs(str, "");
        dpz.MSX = str2;
        dpz.MSY = str3;
        dpz.MSW = dqb;
        AppMethodBeat.o(182091);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 3854;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(182092);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(182092);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(182093);
        Log.d("MicroMsg.roomTodo.NetSceneRoomToolsReplyTodo", "onGYNetEnd:[%d,%d,%s]", Integer.valueOf(i3), Integer.valueOf(i4), str);
        this.gst = (dqa) ((d) sVar).iLL.iLR;
        this.callback.onSceneEnd(i3, i4, str, this);
        this.errMsg = str;
        AppMethodBeat.o(182093);
    }
}
