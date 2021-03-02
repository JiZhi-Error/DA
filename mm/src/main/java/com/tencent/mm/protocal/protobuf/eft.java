package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class eft extends a {
    public int NfL;
    public String NfM;
    public int oUv;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(153305);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(2, this.oUv);
            aVar.aM(3, this.NfL);
            if (this.NfM != null) {
                aVar.e(4, this.NfM);
            }
            AppMethodBeat.o(153305);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(2, this.oUv) + 0 + g.a.a.b.b.a.bu(3, this.NfL);
            if (this.NfM != null) {
                bu += g.a.a.b.b.a.f(4, this.NfM);
            }
            AppMethodBeat.o(153305);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(153305);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            eft eft = (eft) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 2:
                    eft.oUv = aVar3.UbS.zi();
                    AppMethodBeat.o(153305);
                    return 0;
                case 3:
                    eft.NfL = aVar3.UbS.zi();
                    AppMethodBeat.o(153305);
                    return 0;
                case 4:
                    eft.NfM = aVar3.UbS.readString();
                    AppMethodBeat.o(153305);
                    return 0;
                default:
                    AppMethodBeat.o(153305);
                    return -1;
            }
        } else {
            AppMethodBeat.o(153305);
            return -1;
        }
    }
}
