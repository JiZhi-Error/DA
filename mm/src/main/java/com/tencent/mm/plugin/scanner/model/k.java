package com.tencent.mm.plugin.scanner.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ol;
import com.tencent.mm.protocal.protobuf.om;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class k extends q implements m {
    private i callback;
    public d rr;

    public k(String str, LinkedList<String> linkedList, int i2, String str2, double d2, double d3) {
        AppMethodBeat.i(51617);
        d.a aVar = new d.a();
        aVar.iLN = new ol();
        aVar.iLO = new om();
        aVar.uri = "/cgi-bin/mmbiz-bin/usrmsg/bizscangetactioninfo";
        aVar.funcId = 1068;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        ol olVar = (ol) this.rr.iLK.iLR;
        olVar.ProductID = str;
        olVar.Scene = i2;
        olVar.KUs = str2;
        olVar.KUr = linkedList;
        olVar.KUu = d3;
        olVar.KUt = d2;
        AppMethodBeat.o(51617);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(51618);
        Log.i("MicroMsg.NetSceneGetActionInfo", "onGYNetEnd errtype:" + i3 + " errcode:" + i4 + " errMsg:" + str);
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(51618);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1068;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(51619);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(51619);
        return dispatch;
    }
}
