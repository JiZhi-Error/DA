package com.tencent.mm.plugin.nearby.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.chr;
import com.tencent.mm.protocal.protobuf.chs;
import com.tencent.mm.sdk.platformtools.Log;

public final class d extends q implements m {
    public String Azx;
    private i callback;
    public String jHa;
    private final com.tencent.mm.ak.d rr;

    public d(float f2, float f3, int i2, String str, String str2) {
        AppMethodBeat.i(89769);
        d.a aVar = new d.a();
        aVar.iLN = new chr();
        aVar.iLO = new chs();
        aVar.uri = "/cgi-bin/micromsg-bin/joinlbsroom";
        aVar.funcId = 376;
        aVar.iLP = 183;
        aVar.respCmdId = 1000000183;
        this.rr = aVar.aXF();
        chr chr = (chr) this.rr.iLK.iLR;
        chr.OpCode = 1;
        chr.LbC = f2;
        chr.LbD = f3;
        chr.LuT = i2;
        chr.LuU = str;
        chr.LuV = str2;
        chr.LuW = 0;
        Log.d("MicroMsg.NetSceneLbsRoom", "Req: opcode:1 lon:" + f2 + " lat:" + f3 + " pre:" + i2 + " gpsSource:0 mac" + str + " cell:" + str2);
        AppMethodBeat.o(89769);
    }

    public d(String str, int i2, int i3) {
        AppMethodBeat.i(89770);
        d.a aVar = new d.a();
        aVar.iLN = new chr();
        aVar.iLO = new chs();
        aVar.uri = "/cgi-bin/micromsg-bin/joinlbsroom";
        aVar.funcId = 376;
        aVar.iLP = 183;
        aVar.respCmdId = 1000000183;
        this.rr = aVar.aXF();
        chr chr = (chr) this.rr.iLK.iLR;
        chr.LbC = 0.0f;
        chr.LbD = 0.0f;
        chr.LuT = 0;
        chr.LuW = 0;
        chr.LuU = "";
        chr.LuV = "";
        chr.OpCode = 2;
        chr.jfM = str;
        chr.Mnc = i2;
        chr.Mnb = i3;
        AppMethodBeat.o(89770);
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(89771);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(89771);
        return dispatch;
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 376;
    }

    public final int Vj() {
        return ((chr) this.rr.iLK.iLR).OpCode;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(89772);
        Log.d("MicroMsg.NetSceneLbsRoom", "onGYNetEnd  errType:" + i3 + " errCode:" + i4 + " opCode:" + Vj());
        chs chs = (chs) ((com.tencent.mm.ak.d) sVar).iLL.iLR;
        if (i3 != 0) {
            this.callback.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(89772);
        } else if (Vj() == 1) {
            this.jHa = chs.jfM;
            this.Azx = chs.Mnd;
            this.callback.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(89772);
        } else {
            if (Vj() == 2) {
                b.aIt(((chr) ((com.tencent.mm.ak.d) sVar).iLK.iLR).jfM);
                this.callback.onSceneEnd(i3, i4, str, this);
            }
            AppMethodBeat.o(89772);
        }
    }
}
