package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class csu extends a {
    public String LYu;
    public int Loh;
    public int MxQ;
    public String MxR;
    public String MxS;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(115847);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.LYu != null) {
                aVar.e(1, this.LYu);
            }
            aVar.aM(2, this.MxQ);
            if (this.MxR != null) {
                aVar.e(3, this.MxR);
            }
            aVar.aM(4, this.Loh);
            if (this.MxS != null) {
                aVar.e(5, this.MxS);
            }
            AppMethodBeat.o(115847);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.LYu != null ? g.a.a.b.b.a.f(1, this.LYu) + 0 : 0) + g.a.a.b.b.a.bu(2, this.MxQ);
            if (this.MxR != null) {
                f2 += g.a.a.b.b.a.f(3, this.MxR);
            }
            int bu = f2 + g.a.a.b.b.a.bu(4, this.Loh);
            if (this.MxS != null) {
                bu += g.a.a.b.b.a.f(5, this.MxS);
            }
            AppMethodBeat.o(115847);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(115847);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            csu csu = (csu) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    csu.LYu = aVar3.UbS.readString();
                    AppMethodBeat.o(115847);
                    return 0;
                case 2:
                    csu.MxQ = aVar3.UbS.zi();
                    AppMethodBeat.o(115847);
                    return 0;
                case 3:
                    csu.MxR = aVar3.UbS.readString();
                    AppMethodBeat.o(115847);
                    return 0;
                case 4:
                    csu.Loh = aVar3.UbS.zi();
                    AppMethodBeat.o(115847);
                    return 0;
                case 5:
                    csu.MxS = aVar3.UbS.readString();
                    AppMethodBeat.o(115847);
                    return 0;
                default:
                    AppMethodBeat.o(115847);
                    return -1;
            }
        } else {
            AppMethodBeat.o(115847);
            return -1;
        }
    }
}
