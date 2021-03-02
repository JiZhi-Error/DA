package com.tencent.mm.plugin.mall.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bsi;
import com.tencent.mm.protocal.protobuf.bsj;
import com.tencent.mm.sdk.platformtools.Log;

public final class h extends q implements m {
    private i callback;
    private d hJu;
    private bsi zjv = ((bsi) this.hJu.iLK.iLR);
    public bsj zjw;

    public h() {
        AppMethodBeat.i(65997);
        d.a aVar = new d.a();
        aVar.iLN = new bsi();
        aVar.iLO = new bsj();
        aVar.funcId = 1754;
        aVar.uri = "/cgi-bin/mmpay-bin/tenpay/getpaymenu";
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.hJu = aVar.aXF();
        AppMethodBeat.o(65997);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1754;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(65998);
        Log.d("MicroMsg.NetSceneGetPayMenu", "doScene");
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.hJu, this);
        AppMethodBeat.o(65998);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        int i5;
        AppMethodBeat.i(65999);
        Log.i("MicroMsg.NetSceneGetPayMenu", "onGYNetEnd, errType: %s, errCode: %s", Integer.valueOf(i3), Integer.valueOf(i4));
        if (i3 == 0 && i4 == 0) {
            this.zjw = (bsj) this.hJu.iLL.iLR;
            Object[] objArr = new Object[3];
            objArr[0] = this.zjw.title;
            objArr[1] = this.zjw.LZr;
            if (this.zjw.LZr != null) {
                i5 = this.zjw.LZr.size();
            } else {
                i5 = 0;
            }
            objArr[2] = Integer.valueOf(i5);
            Log.i("MicroMsg.NetSceneGetPayMenu", "onGYNetEnd, title: %s, sectors: %s, sectors.size: %s", objArr);
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(65999);
    }
}
