package com.tencent.mm.plugin.scanner.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.on;
import com.tencent.mm.protocal.protobuf.oo;
import com.tencent.mm.sdk.platformtools.Log;

public final class l extends q implements m {
    private i callback;
    private String productId;
    private String qyZ;
    public d rr;
    private int scene;

    public l(String str, int i2, String str2) {
        this.productId = str;
        this.scene = i2;
        this.qyZ = str2;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(51620);
        this.callback = iVar;
        d.a aVar = new d.a();
        aVar.iLN = new on();
        aVar.iLO = new oo();
        aVar.uri = "/cgi-bin/mmbiz-bin/usrmsg/bizscangetproductinfo";
        aVar.funcId = 1063;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        on onVar = (on) this.rr.iLK.iLR;
        onVar.ProductID = this.productId;
        onVar.Scene = this.scene;
        onVar.KUs = this.qyZ;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(51620);
        return dispatch;
    }

    @Override // com.tencent.mm.ak.q
    public final q.b securityVerificationChecked(s sVar) {
        AppMethodBeat.i(51621);
        on onVar = (on) ((d) sVar).iLK.iLR;
        if (onVar.Scene < 0 || onVar.ProductID == null || onVar.ProductID.length() <= 0) {
            Log.e("MicroMsg.scanner.NetSceneGetProductInfo", "ERR: Security Check Failed, Scene = %s", Integer.valueOf(onVar.Scene));
            q.b bVar = q.b.EFailed;
            AppMethodBeat.o(51621);
            return bVar;
        }
        q.b bVar2 = q.b.EOk;
        AppMethodBeat.o(51621);
        return bVar2;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(51622);
        Log.d("MicroMsg.scanner.NetSceneGetProductInfo", "onGYNetEnd errtype:" + i3 + " errcode:" + i4 + " errMsg:" + str);
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(51622);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1063;
    }
}
