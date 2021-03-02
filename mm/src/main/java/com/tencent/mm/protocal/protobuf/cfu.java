package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;

public final class cfu extends a {
    public int Lrp;
    public int MlF;
    public b MlG;
    public int MlH;
    public int MlI;
    public int oTz;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(143982);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.MlF);
            if (this.MlG != null) {
                aVar.c(2, this.MlG);
            }
            aVar.aM(3, this.MlH);
            aVar.aM(4, this.Lrp);
            aVar.aM(5, this.oTz);
            aVar.aM(6, this.MlI);
            AppMethodBeat.o(143982);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.MlF) + 0;
            if (this.MlG != null) {
                bu += g.a.a.b.b.a.b(2, this.MlG);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(3, this.MlH) + g.a.a.b.b.a.bu(4, this.Lrp) + g.a.a.b.b.a.bu(5, this.oTz) + g.a.a.b.b.a.bu(6, this.MlI);
            AppMethodBeat.o(143982);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(143982);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cfu cfu = (cfu) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cfu.MlF = aVar3.UbS.zi();
                    AppMethodBeat.o(143982);
                    return 0;
                case 2:
                    cfu.MlG = aVar3.UbS.hPo();
                    AppMethodBeat.o(143982);
                    return 0;
                case 3:
                    cfu.MlH = aVar3.UbS.zi();
                    AppMethodBeat.o(143982);
                    return 0;
                case 4:
                    cfu.Lrp = aVar3.UbS.zi();
                    AppMethodBeat.o(143982);
                    return 0;
                case 5:
                    cfu.oTz = aVar3.UbS.zi();
                    AppMethodBeat.o(143982);
                    return 0;
                case 6:
                    cfu.MlI = aVar3.UbS.zi();
                    AppMethodBeat.o(143982);
                    return 0;
                default:
                    AppMethodBeat.o(143982);
                    return -1;
            }
        } else {
            AppMethodBeat.o(143982);
            return -1;
        }
    }
}
