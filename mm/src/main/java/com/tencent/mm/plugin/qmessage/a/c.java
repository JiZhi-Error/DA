package com.tencent.mm.plugin.qmessage.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bom;
import com.tencent.mm.protocal.protobuf.bon;
import com.tencent.mm.sdk.platformtools.Log;

public final class c extends q implements m {
    private i Bqf;
    public final d jof;

    public c() {
        AppMethodBeat.i(27716);
        d.a aVar = new d.a();
        aVar.iLN = new bom();
        aVar.iLO = new bon();
        aVar.uri = "/cgi-bin/micromsg-bin/getimunreadmsgcount";
        aVar.funcId = getType();
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.jof = aVar.aXF();
        AppMethodBeat.o(27716);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(27717);
        Log.d("MicroMsg.NetSceneGetImUnreadMsgCount", "end get im unread msg count, errType: %d, errCode:%d", Integer.valueOf(i3), Integer.valueOf(i4));
        this.Bqf.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(27717);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 630;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(27718);
        Log.d("MicroMsg.NetSceneGetImUnreadMsgCount", "get im unread msg count");
        this.Bqf = iVar;
        int dispatch = dispatch(gVar, this.jof, this);
        AppMethodBeat.o(27718);
        return dispatch;
    }
}
