package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;

public final class ekx extends a {
    public int Nkj;
    public int Nkk;
    public String Nkl;
    public b Nkm;
    public int Nkn;
    public int Nko;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(82481);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.Nkj);
            aVar.aM(2, this.Nkk);
            if (this.Nkl != null) {
                aVar.e(3, this.Nkl);
            }
            if (this.Nkm != null) {
                aVar.c(4, this.Nkm);
            }
            aVar.aM(5, this.Nkn);
            aVar.aM(6, this.Nko);
            AppMethodBeat.o(82481);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.Nkj) + 0 + g.a.a.b.b.a.bu(2, this.Nkk);
            if (this.Nkl != null) {
                bu += g.a.a.b.b.a.f(3, this.Nkl);
            }
            if (this.Nkm != null) {
                bu += g.a.a.b.b.a.b(4, this.Nkm);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(5, this.Nkn) + g.a.a.b.b.a.bu(6, this.Nko);
            AppMethodBeat.o(82481);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(82481);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ekx ekx = (ekx) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ekx.Nkj = aVar3.UbS.zi();
                    AppMethodBeat.o(82481);
                    return 0;
                case 2:
                    ekx.Nkk = aVar3.UbS.zi();
                    AppMethodBeat.o(82481);
                    return 0;
                case 3:
                    ekx.Nkl = aVar3.UbS.readString();
                    AppMethodBeat.o(82481);
                    return 0;
                case 4:
                    ekx.Nkm = aVar3.UbS.hPo();
                    AppMethodBeat.o(82481);
                    return 0;
                case 5:
                    ekx.Nkn = aVar3.UbS.zi();
                    AppMethodBeat.o(82481);
                    return 0;
                case 6:
                    ekx.Nko = aVar3.UbS.zi();
                    AppMethodBeat.o(82481);
                    return 0;
                default:
                    AppMethodBeat.o(82481);
                    return -1;
            }
        } else {
            AppMethodBeat.o(82481);
            return -1;
        }
    }
}
