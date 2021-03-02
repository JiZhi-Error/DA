package com.tencent.mm.plugin.voip.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.voip.b.e;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.protocal.protobuf.eus;
import com.tencent.mm.protocal.protobuf.eut;
import com.tencent.mm.protocal.protobuf.euu;
import java.util.LinkedList;

public final class l extends n<eut, euu> {
    public l(String str, String str2, String str3, String str4, String str5, String[] strArr, String[] strArr2, String[] strArr3, String[] strArr4) {
        AppMethodBeat.i(115253);
        d.a aVar = new d.a();
        aVar.iLN = new eut();
        aVar.iLO = new euu();
        aVar.uri = "/cgi-bin/micromsg-bin/voipstatreport";
        aVar.funcId = 320;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        eut eut = (eut) this.rr.iLK.iLR;
        eus eus = new eus();
        dqi dqi = new dqi();
        dqi.bhy(str);
        eus.NgE = dqi;
        eus eus2 = new eus();
        dqi dqi2 = new dqi();
        dqi2.bhy(str2);
        eus2.NgE = dqi2;
        eus eus3 = new eus();
        dqi dqi3 = new dqi();
        dqi3.bhy(str3);
        eus3.NgE = dqi3;
        eus eus4 = new eus();
        dqi dqi4 = new dqi();
        dqi4.bhy(str4);
        eus4.NgE = dqi4;
        eus eus5 = new eus();
        dqi dqi5 = new dqi();
        dqi5.bhy(str5);
        eus5.NgE = dqi5;
        eut.NqI = eus;
        eut.NsO = eus2;
        eut.NsN = eus3;
        eut.NsP = eus4;
        eut.NsQ = eus5;
        e.Logd("MicroMsg.NetSceneVoipStatReport", "natReportList length:" + strArr.length);
        LinkedList<dqi> linkedList = new LinkedList<>();
        for (String str6 : strArr) {
            linkedList.add(new dqi().bhy(str6));
        }
        eut.NsR = linkedList.size();
        eut.NsS = linkedList;
        LinkedList<dqi> linkedList2 = new LinkedList<>();
        for (String str7 : strArr2) {
            linkedList2.add(new dqi().bhy(str7));
        }
        eut.Lri = linkedList2.size();
        eut.NsT = linkedList2;
        LinkedList<dqi> linkedList3 = new LinkedList<>();
        for (String str8 : strArr3) {
            linkedList3.add(new dqi().bhy(str8));
        }
        eut.MPZ = linkedList3.size();
        eut.NsU = linkedList3;
        LinkedList<dqi> linkedList4 = new LinkedList<>();
        for (String str9 : strArr4) {
            linkedList4.add(new dqi().bhy(str9));
        }
        eut.NsV = linkedList4.size();
        eut.NsW = linkedList4;
        AppMethodBeat.o(115253);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 320;
    }

    @Override // com.tencent.mm.plugin.voip.model.a.n
    public final i fIF() {
        AppMethodBeat.i(115254);
        AnonymousClass1 r0 = new i() {
            /* class com.tencent.mm.plugin.voip.model.a.l.AnonymousClass1 */

            @Override // com.tencent.mm.ak.i
            public final void onSceneEnd(int i2, int i3, String str, q qVar) {
                AppMethodBeat.i(115252);
                e.Logd("MicroMsg.NetSceneVoipStatReport", "onSceneEnd type:" + qVar.getType() + " errType:" + i2 + " errCode:" + i3);
                AppMethodBeat.o(115252);
            }
        };
        AppMethodBeat.o(115254);
        return r0;
    }
}
