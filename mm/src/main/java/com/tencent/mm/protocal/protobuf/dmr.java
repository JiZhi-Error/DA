package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class dmr extends a {
    public int LCN;
    public String dNI;
    public String tsW;
    public String tsX;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209812);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.dNI != null) {
                aVar.e(1, this.dNI);
            }
            if (this.tsX != null) {
                aVar.e(2, this.tsX);
            }
            if (this.tsW != null) {
                aVar.e(3, this.tsW);
            }
            aVar.aM(4, this.LCN);
            AppMethodBeat.o(209812);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.dNI != null ? g.a.a.b.b.a.f(1, this.dNI) + 0 : 0;
            if (this.tsX != null) {
                f2 += g.a.a.b.b.a.f(2, this.tsX);
            }
            if (this.tsW != null) {
                f2 += g.a.a.b.b.a.f(3, this.tsW);
            }
            int bu = f2 + g.a.a.b.b.a.bu(4, this.LCN);
            AppMethodBeat.o(209812);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(209812);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dmr dmr = (dmr) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    dmr.dNI = aVar3.UbS.readString();
                    AppMethodBeat.o(209812);
                    return 0;
                case 2:
                    dmr.tsX = aVar3.UbS.readString();
                    AppMethodBeat.o(209812);
                    return 0;
                case 3:
                    dmr.tsW = aVar3.UbS.readString();
                    AppMethodBeat.o(209812);
                    return 0;
                case 4:
                    dmr.LCN = aVar3.UbS.zi();
                    AppMethodBeat.o(209812);
                    return 0;
                default:
                    AppMethodBeat.o(209812);
                    return -1;
            }
        } else {
            AppMethodBeat.o(209812);
            return -1;
        }
    }
}
