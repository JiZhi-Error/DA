package com.tencent.mm.openim.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cdq;
import com.tencent.mm.protocal.protobuf.cdr;
import com.tencent.mm.protocal.protobuf.cvt;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class k extends q implements m {
    private i callback;
    private String dOe;
    private final d rr;

    public k(String str, LinkedList<cvt> linkedList) {
        AppMethodBeat.i(151209);
        d.a aVar = new d.a();
        aVar.iLN = new cdq();
        aVar.iLO = new cdr();
        aVar.uri = "/cgi-bin/micromsg-bin/inviteopenimchatroommember";
        aVar.funcId = 887;
        this.rr = aVar.aXF();
        this.dOe = str;
        cdq cdq = (cdq) this.rr.iLK.iLR;
        cdq.jHa = str;
        cdq.KHx = linkedList;
        Log.i("MicroMsg.Openim.NetSceneInviteOpenIMChatRoomMember", "roomname: %s, size:%d", str, Integer.valueOf(linkedList.size()));
        AppMethodBeat.o(151209);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(151210);
        Log.i("MicroMsg.Openim.NetSceneInviteOpenIMChatRoomMember", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s, roomname = %s", Integer.valueOf(i3), Integer.valueOf(i4), str, this.dOe);
        if (this.callback != null) {
            this.callback.onSceneEnd(i3, i4, str, this);
        }
        AppMethodBeat.o(151210);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 887;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(151211);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(151211);
        return dispatch;
    }
}
