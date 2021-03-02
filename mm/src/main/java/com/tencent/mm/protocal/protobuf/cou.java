package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class cou extends dpc {
    public int Brl;
    public long Brn;
    public int CreateTime;
    public dqi KHm;
    public int KLp;
    public int MuU;
    public int Ret;
    public int oUv;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(43105);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.KHm == null) {
                b bVar = new b("Not all required fields were included: ToUserName");
                AppMethodBeat.o(43105);
                throw bVar;
            }
            aVar.aM(1, this.Ret);
            if (this.KHm != null) {
                aVar.ni(2, this.KHm.computeSize());
                this.KHm.writeFields(aVar);
            }
            aVar.aM(3, this.Brl);
            aVar.aM(4, this.MuU);
            aVar.aM(5, this.CreateTime);
            aVar.aM(6, this.KLp);
            aVar.aM(7, this.oUv);
            aVar.bb(8, this.Brn);
            AppMethodBeat.o(43105);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.Ret) + 0;
            if (this.KHm != null) {
                bu += g.a.a.a.nh(2, this.KHm.computeSize());
            }
            int bu2 = bu + g.a.a.b.b.a.bu(3, this.Brl) + g.a.a.b.b.a.bu(4, this.MuU) + g.a.a.b.b.a.bu(5, this.CreateTime) + g.a.a.b.b.a.bu(6, this.KLp) + g.a.a.b.b.a.bu(7, this.oUv) + g.a.a.b.b.a.r(8, this.Brn);
            AppMethodBeat.o(43105);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.KHm == null) {
                b bVar2 = new b("Not all required fields were included: ToUserName");
                AppMethodBeat.o(43105);
                throw bVar2;
            }
            AppMethodBeat.o(43105);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cou cou = (cou) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    cou.Ret = aVar3.UbS.zi();
                    AppMethodBeat.o(43105);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        dqi dqi = new dqi();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = dqi.populateBuilderWithField(aVar4, dqi, dpc.getNextFieldNumber(aVar4))) {
                        }
                        cou.KHm = dqi;
                    }
                    AppMethodBeat.o(43105);
                    return 0;
                case 3:
                    cou.Brl = aVar3.UbS.zi();
                    AppMethodBeat.o(43105);
                    return 0;
                case 4:
                    cou.MuU = aVar3.UbS.zi();
                    AppMethodBeat.o(43105);
                    return 0;
                case 5:
                    cou.CreateTime = aVar3.UbS.zi();
                    AppMethodBeat.o(43105);
                    return 0;
                case 6:
                    cou.KLp = aVar3.UbS.zi();
                    AppMethodBeat.o(43105);
                    return 0;
                case 7:
                    cou.oUv = aVar3.UbS.zi();
                    AppMethodBeat.o(43105);
                    return 0;
                case 8:
                    cou.Brn = aVar3.UbS.zl();
                    AppMethodBeat.o(43105);
                    return 0;
                default:
                    AppMethodBeat.o(43105);
                    return -1;
            }
        } else {
            AppMethodBeat.o(43105);
            return -1;
        }
    }
}
