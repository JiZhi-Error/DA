package com.tencent.mm.plugin.brandservice.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dru;
import com.tencent.mm.protocal.protobuf.drv;
import com.tencent.mm.protocal.protobuf.ru;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class l extends q implements m {
    private i callback;
    private String dDv;
    private String hes;
    private int offset;
    private d pnF;
    private drv pnG;
    private long pnH;
    private int scene;

    public l(String str, long j2, int i2, int i3, String str2) {
        AppMethodBeat.i(5587);
        this.dDv = str;
        this.pnH = j2;
        this.offset = i2;
        this.scene = i3;
        this.hes = str2;
        Log.i("MicroMsg.NetSceneSearchDetailPageNew", "Constructors: keyword = (%s) , LSB exist () , businessType is (%d) , offset is (%d) , scene is (%d), searchId(%s).", str, Long.valueOf(j2), Integer.valueOf(i2), Integer.valueOf(i3), str2);
        AppMethodBeat.o(5587);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(5588);
        Log.i("MicroMsg.NetSceneSearchDetailPageNew", "netId (%d) , errType (%d) , errCode (%d) , errMsg (%s)", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str);
        if (i3 == 0 && i4 == 0 && this.pnF != null) {
            this.pnG = (drv) this.pnF.iLL.iLR;
        }
        if (this.callback != null) {
            this.callback.onSceneEnd(i3, i4, str, this);
        }
        AppMethodBeat.o(5588);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1071;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(5589);
        this.callback = iVar;
        if (!Util.isNullOrNil(this.dDv)) {
            d.a aVar = new d.a();
            aVar.funcId = 1071;
            aVar.uri = "/cgi-bin/mmbiz-bin/bizsearch/detailpage";
            aVar.iLN = new dru();
            aVar.iLO = new drv();
            aVar.iLP = 0;
            aVar.respCmdId = 0;
            this.pnF = aVar.aXF();
            dru dru = (dru) this.pnF.iLK.iLR;
            dru.MlQ = e.clJ();
            dru.LUZ = this.dDv;
            dru.KZg = this.pnH;
            dru.KZk = this.offset;
            dru.MUr = this.scene;
            dru.KZj = this.hes;
            int dispatch = dispatch(gVar, this.pnF, this);
            AppMethodBeat.o(5589);
            return dispatch;
        }
        Log.e("MicroMsg.NetSceneSearchDetailPageNew", "keyword is unavailable.");
        AppMethodBeat.o(5589);
        return -1;
    }

    public final ru clR() {
        if (this.pnG == null) {
            return null;
        }
        return this.pnG.MUt;
    }
}
