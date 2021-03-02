package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;

public final class dte extends a {
    public b LrK;
    public int MVl;
    public int MVm;
    public int MVn;
    public int MVo;
    public int MVp;
    public int MVq;
    public int MVr;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(32425);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.LrK == null) {
                g.a.a.b bVar = new g.a.a.b("Not all required fields were included: data");
                AppMethodBeat.o(32425);
                throw bVar;
            }
            aVar.aM(1, this.MVl);
            aVar.aM(2, this.MVm);
            aVar.aM(3, this.MVn);
            aVar.aM(4, this.MVo);
            aVar.aM(5, this.MVp);
            aVar.aM(6, this.MVq);
            aVar.aM(7, this.MVr);
            if (this.LrK != null) {
                aVar.c(8, this.LrK);
            }
            AppMethodBeat.o(32425);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.MVl) + 0 + g.a.a.b.b.a.bu(2, this.MVm) + g.a.a.b.b.a.bu(3, this.MVn) + g.a.a.b.b.a.bu(4, this.MVo) + g.a.a.b.b.a.bu(5, this.MVp) + g.a.a.b.b.a.bu(6, this.MVq) + g.a.a.b.b.a.bu(7, this.MVr);
            if (this.LrK != null) {
                bu += g.a.a.b.b.a.b(8, this.LrK);
            }
            AppMethodBeat.o(32425);
            return bu;
        } else if (i2 == 2) {
            byte[] bArr = (byte[]) objArr[0];
            g.a.a.a.a aVar2 = new g.a.a.a.a(bArr, unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (bArr == null) {
                g.a.a.b bVar2 = new g.a.a.b("Not all required fields were included: data");
                AppMethodBeat.o(32425);
                throw bVar2;
            }
            AppMethodBeat.o(32425);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dte dte = (dte) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    dte.MVl = aVar3.UbS.zi();
                    AppMethodBeat.o(32425);
                    return 0;
                case 2:
                    dte.MVm = aVar3.UbS.zi();
                    AppMethodBeat.o(32425);
                    return 0;
                case 3:
                    dte.MVn = aVar3.UbS.zi();
                    AppMethodBeat.o(32425);
                    return 0;
                case 4:
                    dte.MVo = aVar3.UbS.zi();
                    AppMethodBeat.o(32425);
                    return 0;
                case 5:
                    dte.MVp = aVar3.UbS.zi();
                    AppMethodBeat.o(32425);
                    return 0;
                case 6:
                    dte.MVq = aVar3.UbS.zi();
                    AppMethodBeat.o(32425);
                    return 0;
                case 7:
                    dte.MVr = aVar3.UbS.zi();
                    AppMethodBeat.o(32425);
                    return 0;
                case 8:
                    dte.LrK = aVar3.UbS.hPo();
                    AppMethodBeat.o(32425);
                    return 0;
                default:
                    AppMethodBeat.o(32425);
                    return -1;
            }
        } else {
            AppMethodBeat.o(32425);
            return -1;
        }
    }
}
