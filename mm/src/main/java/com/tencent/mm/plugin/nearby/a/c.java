package com.tencent.mm.plugin.nearby.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.p;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.c.a;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.chi;
import com.tencent.mm.protocal.protobuf.chm;
import com.tencent.mm.protocal.protobuf.chn;
import com.tencent.mm.protocal.protobuf.ewf;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class c extends q implements m {
    private i callback;
    private final d rr;

    public c(int i2, float f2, float f3, int i3, int i4, String str, String str2) {
        AppMethodBeat.i(89765);
        if (!(i2 == 1 || i2 == 2 || i2 == 3 || i2 == 4)) {
            Log.e("MicroMsg.NetSceneLbsP", "OpCode Error :".concat(String.valueOf(i2)));
        }
        d.a aVar = new d.a();
        aVar.iLN = new chm();
        aVar.iLO = new chn();
        aVar.uri = "/cgi-bin/micromsg-bin/lbsfind";
        aVar.funcId = 148;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        chm chm = (chm) this.rr.iLK.iLR;
        chm.OpCode = i2;
        chm.LbC = f2;
        chm.LbD = f3;
        chm.LuT = i3;
        chm.LuU = str;
        chm.LuV = str2;
        chm.LuW = i4;
        try {
            ewf ewf = new ewf();
            ewf.NtQ = new SKBuiltinBuffer_t().setBuffer(com.tencent.mm.plugin.normsg.a.d.INSTANCE.exJ());
            chm.KLQ = new SKBuiltinBuffer_t().setBuffer(ewf.toByteArray());
        } catch (Throwable th) {
        }
        Log.d("MicroMsg.NetSceneLbsP", "Req: opcode:" + i2 + " lon:" + f2 + " lat:" + f3 + " pre:" + i3 + " gpsSource:" + i4 + " mac" + str + " cell:" + str2);
        o.a(2001, f2, f3, i3);
        AppMethodBeat.o(89765);
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(89766);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(89766);
        return dispatch;
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 148;
    }

    public final int Vj() {
        return ((chm) this.rr.iLK.iLR).OpCode;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(89767);
        Log.d("MicroMsg.NetSceneLbsP", "onGYNetEnd  errType:" + i3 + " errCode:" + i4);
        chn chn = (chn) ((d) sVar).iLL.iLR;
        ArrayList arrayList = new ArrayList();
        for (int i5 = 0; i5 < chn.LUC.size(); i5++) {
            com.tencent.mm.aj.i iVar = new com.tencent.mm.aj.i();
            iVar.username = chn.LUC.get(i5).UserName;
            iVar.fuz = chn.LUC.get(i5).KHo;
            iVar.iKX = chn.LUC.get(i5).Lir;
            iVar.iKW = chn.LUC.get(i5).Lis;
            iVar.fv(true);
            arrayList.add(iVar);
        }
        p.aYB().av(arrayList);
        if (Vj() == 1 || Vj() == 3 || Vj() == 4) {
            if (i3 == 0 || i4 != -2001) {
                com.tencent.mm.kernel.g.aAh().azQ().set(8210, Long.valueOf(System.currentTimeMillis() + ((long) (chn.MmY * 1000))));
            } else {
                com.tencent.mm.kernel.g.aAh().azQ().set(8210, (Object) 0L);
                this.callback.onSceneEnd(i3, i4, str, this);
                AppMethodBeat.o(89767);
                return;
            }
        } else if (Vj() == 2) {
            com.tencent.mm.kernel.g.aAh().azQ().set(8210, (Object) 0L);
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(89767);
    }

    public final boolean ewR() {
        return ((chn) this.rr.iLL.iLR).MmZ == 1;
    }

    public final int ewS() {
        return ((chn) this.rr.iLL.iLR).Mna;
    }

    public final List<chi> ewT() {
        AppMethodBeat.i(89768);
        LinkedList<chi> linkedList = ((chn) this.rr.iLL.iLR).LUC;
        if (linkedList != null) {
            com.tencent.mm.kernel.g.aAf().azk();
            for (chi chi : linkedList) {
                a.bqE().aTp().mP(chi.UserName, chi.LRO);
            }
        }
        AppMethodBeat.o(89768);
        return linkedList;
    }
}
