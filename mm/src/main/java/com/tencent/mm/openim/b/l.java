package com.tencent.mm.openim.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.messenger.foundation.a.a.k;
import com.tencent.mm.protocal.protobuf.cwk;
import com.tencent.mm.protocal.protobuf.cwl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.smtt.sdk.TbsListener;

public final class l extends q implements m {
    private i callback;
    public k.b jHe;
    private int opType;
    private final d rr;

    public l(k.b bVar) {
        AppMethodBeat.i(116859);
        d.a aVar = new d.a();
        aVar.iLN = new cwk();
        aVar.iLO = new cwl();
        aVar.uri = "/cgi-bin/micromsg-bin/openimoplog";
        aVar.funcId = TbsListener.ErrorCode.INFO_OPEN_FILE_MINIQB_INIT_FAILED;
        this.rr = aVar.aXF();
        this.opType = bVar.zqr;
        this.jHe = bVar;
        Log.i("MicroMsg.Openim.NetSceneOpenIMOPLog", "type: %d", Integer.valueOf(this.opType));
        cwk cwk = (cwk) this.rr.iLK.iLR;
        cwk.type = this.opType;
        cwk.MBx = new b(bVar.getBuffer());
        AppMethodBeat.o(116859);
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(116860);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(116860);
        return dispatch;
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return TbsListener.ErrorCode.INFO_OPEN_FILE_MINIQB_INIT_FAILED;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(116861);
        Log.i("MicroMsg.Openim.NetSceneOpenIMOPLog", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s, opType:%d", Integer.valueOf(i3), Integer.valueOf(i4), str, Integer.valueOf(this.opType));
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(116861);
    }
}
