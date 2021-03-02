package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class px extends a {
    public String KWK;
    public int KWL;
    public String KWM;
    public int KWN;
    public LinkedList<ne> KWO = new LinkedList<>();

    public px() {
        AppMethodBeat.i(152509);
        AppMethodBeat.o(152509);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(152510);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.KWK != null) {
                aVar.e(1, this.KWK);
            }
            aVar.aM(2, this.KWL);
            if (this.KWM != null) {
                aVar.e(3, this.KWM);
            }
            aVar.aM(4, this.KWN);
            aVar.e(5, 8, this.KWO);
            AppMethodBeat.o(152510);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.KWK != null ? g.a.a.b.b.a.f(1, this.KWK) + 0 : 0) + g.a.a.b.b.a.bu(2, this.KWL);
            if (this.KWM != null) {
                f2 += g.a.a.b.b.a.f(3, this.KWM);
            }
            int bu = f2 + g.a.a.b.b.a.bu(4, this.KWN) + g.a.a.a.c(5, 8, this.KWO);
            AppMethodBeat.o(152510);
            return bu;
        } else if (i2 == 2) {
            this.KWO.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(152510);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            px pxVar = (px) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    pxVar.KWK = aVar3.UbS.readString();
                    AppMethodBeat.o(152510);
                    return 0;
                case 2:
                    pxVar.KWL = aVar3.UbS.zi();
                    AppMethodBeat.o(152510);
                    return 0;
                case 3:
                    pxVar.KWM = aVar3.UbS.readString();
                    AppMethodBeat.o(152510);
                    return 0;
                case 4:
                    pxVar.KWN = aVar3.UbS.zi();
                    AppMethodBeat.o(152510);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        ne neVar = new ne();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = neVar.populateBuilderWithField(aVar4, neVar, a.getNextFieldNumber(aVar4))) {
                        }
                        pxVar.KWO.add(neVar);
                    }
                    AppMethodBeat.o(152510);
                    return 0;
                default:
                    AppMethodBeat.o(152510);
                    return -1;
            }
        } else {
            AppMethodBeat.o(152510);
            return -1;
        }
    }
}
