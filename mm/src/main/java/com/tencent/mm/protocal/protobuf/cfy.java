package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;

public final class cfy extends a {
    public int MlF;
    public b MlG;
    public int MlM;
    public int MlN;
    public int oTz;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(116337);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.MlF);
            if (this.MlG != null) {
                aVar.c(2, this.MlG);
            }
            aVar.aM(3, this.MlM);
            aVar.aM(4, this.oTz);
            aVar.aM(5, this.MlN);
            AppMethodBeat.o(116337);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.MlF) + 0;
            if (this.MlG != null) {
                bu += g.a.a.b.b.a.b(2, this.MlG);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(3, this.MlM) + g.a.a.b.b.a.bu(4, this.oTz) + g.a.a.b.b.a.bu(5, this.MlN);
            AppMethodBeat.o(116337);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(116337);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cfy cfy = (cfy) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cfy.MlF = aVar3.UbS.zi();
                    AppMethodBeat.o(116337);
                    return 0;
                case 2:
                    cfy.MlG = aVar3.UbS.hPo();
                    AppMethodBeat.o(116337);
                    return 0;
                case 3:
                    cfy.MlM = aVar3.UbS.zi();
                    AppMethodBeat.o(116337);
                    return 0;
                case 4:
                    cfy.oTz = aVar3.UbS.zi();
                    AppMethodBeat.o(116337);
                    return 0;
                case 5:
                    cfy.MlN = aVar3.UbS.zi();
                    AppMethodBeat.o(116337);
                    return 0;
                default:
                    AppMethodBeat.o(116337);
                    return -1;
            }
        } else {
            AppMethodBeat.o(116337);
            return -1;
        }
    }
}
