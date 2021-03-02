package com.tencent.mm.plugin.brandservice.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dsi;
import com.tencent.mm.protocal.protobuf.dsj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class m extends q implements com.tencent.mm.network.m {
    private i callback;
    private String dDv;
    private d pnF;
    private long pnH;
    public dsj pnI;
    private int scene;

    public m(String str, long j2, int i2) {
        AppMethodBeat.i(5590);
        this.dDv = str;
        this.pnH = j2;
        this.scene = i2;
        Log.i("MicroMsg.NetSceneSearchHomePageNew", "Constructors: keyword (%s) , businessType (%d), scene (%d)", str, Long.valueOf(j2), Integer.valueOf(i2));
        AppMethodBeat.o(5590);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(5591);
        Log.i("MicroMsg.NetSceneSearchHomePageNew", "netId (%d) , errType (%d) , errCode (%d) , errMsg (%s)", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str);
        if (i3 == 0 && i4 == 0 && this.pnF != null) {
            this.pnI = (dsj) this.pnF.iLL.iLR;
        }
        if (this.callback != null) {
            this.callback.onSceneEnd(i3, i4, str, this);
        }
        AppMethodBeat.o(5591);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1070;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(5592);
        Log.i("MicroMsg.NetSceneSearchHomePageNew", "doScene");
        this.callback = iVar;
        if (!Util.isNullOrNil(this.dDv)) {
            d.a aVar = new d.a();
            aVar.funcId = 1070;
            aVar.uri = "/cgi-bin/mmbiz-bin/bizsearch/homepage";
            aVar.iLN = new dsi();
            aVar.iLO = new dsj();
            aVar.iLP = 0;
            aVar.respCmdId = 0;
            this.pnF = aVar.aXF();
            dsi dsi = (dsi) this.pnF.iLK.iLR;
            dsi.LUZ = this.dDv;
            dsi.MlQ = e.clJ();
            dsi.KZg = this.pnH;
            dsi.MUr = this.scene;
            Log.i("MicroMsg.NetSceneSearchHomePageNew", "businessTypeList is %d", Long.valueOf(this.pnH));
            int dispatch = dispatch(gVar, this.pnF, this);
            AppMethodBeat.o(5592);
            return dispatch;
        }
        Log.e("MicroMsg.NetSceneSearchHomePageNew", "keyword is unavailable");
        AppMethodBeat.o(5592);
        return -1;
    }
}
