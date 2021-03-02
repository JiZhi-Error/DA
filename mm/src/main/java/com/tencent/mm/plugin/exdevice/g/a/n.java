package com.tencent.mm.plugin.exdevice.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.elx;
import com.tencent.mm.protocal.protobuf.ely;
import com.tencent.mm.sdk.platformtools.Log;
import org.xwalk.core.XWalkFeature;

public final class n extends q implements m {
    private i callback = null;
    public String coverUrl;
    public String rCp;
    private d rr = null;

    public n(String str, String str2) {
        AppMethodBeat.i(23537);
        this.coverUrl = str;
        this.rCp = str2;
        d.a aVar = new d.a();
        aVar.iLN = new elx();
        aVar.iLO = new ely();
        aVar.uri = "/cgi-bin/mmbiz-bin/rank/updatecover";
        aVar.funcId = XWalkFeature.INTERFACE_SHOW_HIDE;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        elx elx = (elx) this.rr.iLK.iLR;
        elx.McL = str;
        elx.rCp = str2;
        AppMethodBeat.o(23537);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return XWalkFeature.INTERFACE_SHOW_HIDE;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(23538);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(23538);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(23539);
        Log.d("MicroMsg.NetSceneUpdateRankCoverAndMotto", "hy: scene end. errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i3), Integer.valueOf(i4), str);
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(23539);
    }
}
