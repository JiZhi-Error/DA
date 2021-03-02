package com.tencent.mm.al;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dgh;
import com.tencent.mm.protocal.protobuf.dgi;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Date;

public final class x extends q implements m {
    private i callback;
    private Object data;
    public d rr;

    public x(d dVar, int i2, int i3, Object obj) {
        AppMethodBeat.i(124123);
        d.a aVar = new d.a();
        aVar.iLN = new dgh();
        aVar.iLO = new dgi();
        aVar.uri = "/cgi-bin/mmocbiz-bin/reportpluginstat";
        aVar.funcId = 2805;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        dgh dgh = (dgh) this.rr.iLK.iLR;
        dgh.MKU = 1;
        dgh.MKV = dVar.field_wwCorpId;
        dgh.KTS = dVar.field_wwUserVid;
        g.aAf();
        dgh.MKW = a.getUin();
        dgh.scene = i3;
        dgh.dDe = i2;
        dgh.Btv = 0;
        dgh.MKX = new Date().getTime();
        dgh.platform = 1;
        dgh.MFo = ChannelUtil.formatVersion(null, com.tencent.mm.protocal.d.KyO);
        this.data = obj;
        AppMethodBeat.o(124123);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(124124);
        Log.d("MicroMsg.NetSceneEnterprisePushStat", "onGYNetEnd code(%d, %d)", Integer.valueOf(i3), Integer.valueOf(i4));
        if (this.callback != null) {
            this.callback.onSceneEnd(i3, i4, str, this);
        }
        AppMethodBeat.o(124124);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 2805;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(com.tencent.mm.network.g gVar, i iVar) {
        AppMethodBeat.i(124125);
        this.callback = iVar;
        Log.i("MicroMsg.NetSceneEnterprisePushStat", "do scene");
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(124125);
        return dispatch;
    }
}
