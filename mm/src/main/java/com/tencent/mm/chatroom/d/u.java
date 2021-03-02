package com.tencent.mm.chatroom.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dwa;
import com.tencent.mm.protocal.protobuf.dwb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.smtt.utils.TbsLog;

public final class u extends q implements m {
    private i callback;
    private final d rr;

    public u(String str, String str2) {
        AppMethodBeat.i(12492);
        d.a aVar = new d.a();
        dwa dwa = new dwa();
        dwa.KGO = str;
        dwa.LTP = str2;
        aVar.iLN = dwa;
        aVar.iLO = new dwb();
        aVar.uri = "/cgi-bin/micromsg-bin/setchatroomannouncement";
        aVar.funcId = TbsLog.TBSLOG_CODE_SDK_CONFLICT_X5CORE;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        AppMethodBeat.o(12492);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(12493);
        Log.w("MicroMsg.NetSceneSetChatRoomAnnouncement", "errType = " + i3 + " errCode " + i4 + " errMsg " + str);
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(12493);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return TbsLog.TBSLOG_CODE_SDK_CONFLICT_X5CORE;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(12494);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(12494);
        return dispatch;
    }
}
