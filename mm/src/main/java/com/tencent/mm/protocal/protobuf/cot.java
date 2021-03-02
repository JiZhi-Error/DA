package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;
import java.util.LinkedList;

public final class cot extends a {
    public int CreateTime;
    public dqi KHm;
    public String KHq;
    public String LbN;
    public int MuU;
    public String iAc;
    public int oUv;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(43104);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.KHm == null) {
                b bVar = new b("Not all required fields were included: ToUserName");
                AppMethodBeat.o(43104);
                throw bVar;
            }
            if (this.KHm != null) {
                aVar.ni(1, this.KHm.computeSize());
                this.KHm.writeFields(aVar);
            }
            if (this.iAc != null) {
                aVar.e(2, this.iAc);
            }
            aVar.aM(3, this.oUv);
            aVar.aM(4, this.CreateTime);
            aVar.aM(5, this.MuU);
            if (this.KHq != null) {
                aVar.e(6, this.KHq);
            }
            if (this.LbN != null) {
                aVar.e(9, this.LbN);
            }
            AppMethodBeat.o(43104);
            return 0;
        } else if (i2 == 1) {
            int nh = this.KHm != null ? g.a.a.a.nh(1, this.KHm.computeSize()) + 0 : 0;
            if (this.iAc != null) {
                nh += g.a.a.b.b.a.f(2, this.iAc);
            }
            int bu = nh + g.a.a.b.b.a.bu(3, this.oUv) + g.a.a.b.b.a.bu(4, this.CreateTime) + g.a.a.b.b.a.bu(5, this.MuU);
            if (this.KHq != null) {
                bu += g.a.a.b.b.a.f(6, this.KHq);
            }
            if (this.LbN != null) {
                bu += g.a.a.b.b.a.f(9, this.LbN);
            }
            AppMethodBeat.o(43104);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.KHm == null) {
                b bVar2 = new b("Not all required fields were included: ToUserName");
                AppMethodBeat.o(43104);
                throw bVar2;
            }
            AppMethodBeat.o(43104);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cot cot = (cot) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        dqi dqi = new dqi();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = dqi.populateBuilderWithField(aVar4, dqi, a.getNextFieldNumber(aVar4))) {
                        }
                        cot.KHm = dqi;
                    }
                    AppMethodBeat.o(43104);
                    return 0;
                case 2:
                    cot.iAc = aVar3.UbS.readString();
                    AppMethodBeat.o(43104);
                    return 0;
                case 3:
                    cot.oUv = aVar3.UbS.zi();
                    AppMethodBeat.o(43104);
                    return 0;
                case 4:
                    cot.CreateTime = aVar3.UbS.zi();
                    AppMethodBeat.o(43104);
                    return 0;
                case 5:
                    cot.MuU = aVar3.UbS.zi();
                    AppMethodBeat.o(43104);
                    return 0;
                case 6:
                    cot.KHq = aVar3.UbS.readString();
                    AppMethodBeat.o(43104);
                    return 0;
                case 7:
                case 8:
                default:
                    AppMethodBeat.o(43104);
                    return -1;
                case 9:
                    cot.LbN = aVar3.UbS.readString();
                    AppMethodBeat.o(43104);
                    return 0;
            }
        } else {
            AppMethodBeat.o(43104);
            return -1;
        }
    }
}
