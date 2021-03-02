package com.tencent.mm.chatroom.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.protocal.protobuf.dpu;
import com.tencent.mm.protocal.protobuf.dpx;
import com.tencent.mm.protocal.protobuf.dpy;
import com.tencent.mm.protocal.protobuf.dqc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;

public final class s extends q implements m {
    private i callback;
    private String errMsg;
    private dpy gss;
    private final d rr;

    public s(String str, LinkedList<dqc> linkedList) {
        AppMethodBeat.i(182088);
        Log.i("MicroMsg.roomtools.NetSceneRoomToolsAlterWxApp", "NetSceneRoomToolsAlterWxApp chatRoomName:%s roomToolsWxApps%s", Util.nullAs(str, ""), Integer.valueOf(linkedList.size()));
        d.a aVar = new d.a();
        aVar.uri = "/cgi-bin/micromsg-bin/roomtoolsalterwxapp";
        aVar.funcId = 3546;
        aVar.iLN = new dpx();
        aVar.iLO = new dpy();
        this.rr = aVar.aXF();
        dpx dpx = (dpx) this.rr.iLK.iLR;
        dpx.KGO = Util.nullAs(str, "");
        dpx.LTS = new dpu();
        dpx.LTS.MST = linkedList.size();
        dpx.LTS.MSU = linkedList;
        AppMethodBeat.o(182088);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 3546;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(182089);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(182089);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, com.tencent.mm.network.s sVar, byte[] bArr) {
        AppMethodBeat.i(182090);
        Log.d("MicroMsg.roomtools.NetSceneRoomToolsAlterWxApp", "onGYNetEnd:[%d,%d,%s]", Integer.valueOf(i3), Integer.valueOf(i4), str);
        this.gss = (dpy) ((d) sVar).iLL.iLR;
        this.callback.onSceneEnd(i3, i4, str, this);
        this.errMsg = str;
        AppMethodBeat.o(182090);
    }
}
