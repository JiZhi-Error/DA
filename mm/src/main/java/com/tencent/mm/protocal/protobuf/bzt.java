package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class bzt extends a {
    public int Mfo;
    public int Mfp;
    public boolean Mfq;
    public boolean Mfr;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(50094);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.Mfo);
            aVar.aM(2, this.Mfp);
            aVar.cc(3, this.Mfq);
            aVar.cc(4, this.Mfr);
            AppMethodBeat.o(50094);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.Mfo) + 0 + g.a.a.b.b.a.bu(2, this.Mfp) + g.a.a.b.b.a.fS(3) + 1 + g.a.a.b.b.a.fS(4) + 1;
            AppMethodBeat.o(50094);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(50094);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bzt bzt = (bzt) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bzt.Mfo = aVar3.UbS.zi();
                    AppMethodBeat.o(50094);
                    return 0;
                case 2:
                    bzt.Mfp = aVar3.UbS.zi();
                    AppMethodBeat.o(50094);
                    return 0;
                case 3:
                    bzt.Mfq = aVar3.UbS.yZ();
                    AppMethodBeat.o(50094);
                    return 0;
                case 4:
                    bzt.Mfr = aVar3.UbS.yZ();
                    AppMethodBeat.o(50094);
                    return 0;
                default:
                    AppMethodBeat.o(50094);
                    return -1;
            }
        } else {
            AppMethodBeat.o(50094);
            return -1;
        }
    }
}
