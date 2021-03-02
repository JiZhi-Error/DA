package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;
import java.util.LinkedList;

public final class o extends a {
    public String ID;
    public long oTO;
    public m oTR;
    public int oTT;
    public long oTU;
    public long oTV;
    public int oTW;
    public int oTX;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(22119);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.ID == null) {
                b bVar = new b("Not all required fields were included: ID");
                AppMethodBeat.o(22119);
                throw bVar;
            }
            if (this.ID != null) {
                aVar.e(1, this.ID);
            }
            aVar.bb(2, this.oTU);
            aVar.bb(3, this.oTV);
            aVar.aM(4, this.oTW);
            aVar.aM(5, this.oTX);
            aVar.bb(6, this.oTO);
            if (this.oTR != null) {
                aVar.ni(7, this.oTR.computeSize());
                this.oTR.writeFields(aVar);
            }
            aVar.aM(8, this.oTT);
            AppMethodBeat.o(22119);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.ID != null ? g.a.a.b.b.a.f(1, this.ID) + 0 : 0) + g.a.a.b.b.a.r(2, this.oTU) + g.a.a.b.b.a.r(3, this.oTV) + g.a.a.b.b.a.bu(4, this.oTW) + g.a.a.b.b.a.bu(5, this.oTX) + g.a.a.b.b.a.r(6, this.oTO);
            if (this.oTR != null) {
                f2 += g.a.a.a.nh(7, this.oTR.computeSize());
            }
            int bu = f2 + g.a.a.b.b.a.bu(8, this.oTT);
            AppMethodBeat.o(22119);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.ID == null) {
                b bVar2 = new b("Not all required fields were included: ID");
                AppMethodBeat.o(22119);
                throw bVar2;
            }
            AppMethodBeat.o(22119);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            o oVar = (o) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    oVar.ID = aVar3.UbS.readString();
                    AppMethodBeat.o(22119);
                    return 0;
                case 2:
                    oVar.oTU = aVar3.UbS.zl();
                    AppMethodBeat.o(22119);
                    return 0;
                case 3:
                    oVar.oTV = aVar3.UbS.zl();
                    AppMethodBeat.o(22119);
                    return 0;
                case 4:
                    oVar.oTW = aVar3.UbS.zi();
                    AppMethodBeat.o(22119);
                    return 0;
                case 5:
                    oVar.oTX = aVar3.UbS.zi();
                    AppMethodBeat.o(22119);
                    return 0;
                case 6:
                    oVar.oTO = aVar3.UbS.zl();
                    AppMethodBeat.o(22119);
                    return 0;
                case 7:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        m mVar = new m();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = mVar.populateBuilderWithField(aVar4, mVar, a.getNextFieldNumber(aVar4))) {
                        }
                        oVar.oTR = mVar;
                    }
                    AppMethodBeat.o(22119);
                    return 0;
                case 8:
                    oVar.oTT = aVar3.UbS.zi();
                    AppMethodBeat.o(22119);
                    return 0;
                default:
                    AppMethodBeat.o(22119);
                    return -1;
            }
        } else {
            AppMethodBeat.o(22119);
            return -1;
        }
    }
}
