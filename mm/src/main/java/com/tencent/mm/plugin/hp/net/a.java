package com.tencent.mm.plugin.hp.net;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cxu;
import com.tencent.mm.protocal.protobuf.cxv;
import com.tencent.mm.protocal.protobuf.cxw;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public class a extends q implements m {
    protected i callback;
    protected int mScene = 0;
    protected LinkedList<cxv> pUc = new LinkedList<>();
    protected final d rr;
    protected String type;
    protected String ymP;
    protected String ymQ;
    protected LinkedList<cxu> ymR = new LinkedList<>();
    protected int ymS = 0;

    public a() {
        AppMethodBeat.i(117444);
        d.a aVar = new d.a();
        aVar.iLN = new cxv();
        aVar.iLO = new cxw();
        aVar.uri = "/cgi-bin/micromsg-bin/prconfig";
        aVar.funcId = 3899;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        AppMethodBeat.o(117444);
    }

    @Override // com.tencent.mm.ak.q
    public int getType() {
        return 3899;
    }

    @Override // com.tencent.mm.ak.q
    public int doScene(g gVar, i iVar) {
        AppMethodBeat.i(117445);
        this.callback = iVar;
        cxv cxv = (cxv) this.rr.iLK.iLR;
        cxv.MCI = this.ymP;
        cxv.APx = this.ymQ;
        cxv.MCJ = this.ymR;
        cxv.type = this.type;
        cxv.Iow = this.pUc;
        cxv.MCK = this.ymS;
        cxv.MCL = this.mScene;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(117445);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(117446);
        Log.i("MicroMsg.Tinker.NetSceneBaseCheckTinkerUpdate", "errType:%d errCode:%d errMsg:%s ", Integer.valueOf(i3), Integer.valueOf(i4), str);
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(117446);
    }
}
