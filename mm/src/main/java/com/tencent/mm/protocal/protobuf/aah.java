package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class aah extends a {
    public int Lls;
    public int Llt;
    public int Llu;
    public boolean Llv;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(187870);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.Lls);
            aVar.aM(2, this.Llt);
            aVar.aM(3, this.Llu);
            aVar.cc(4, this.Llv);
            AppMethodBeat.o(187870);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.Lls) + 0 + g.a.a.b.b.a.bu(2, this.Llt) + g.a.a.b.b.a.bu(3, this.Llu) + g.a.a.b.b.a.fS(4) + 1;
            AppMethodBeat.o(187870);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(187870);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            aah aah = (aah) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    aah.Lls = aVar3.UbS.zi();
                    AppMethodBeat.o(187870);
                    return 0;
                case 2:
                    aah.Llt = aVar3.UbS.zi();
                    AppMethodBeat.o(187870);
                    return 0;
                case 3:
                    aah.Llu = aVar3.UbS.zi();
                    AppMethodBeat.o(187870);
                    return 0;
                case 4:
                    aah.Llv = aVar3.UbS.yZ();
                    AppMethodBeat.o(187870);
                    return 0;
                default:
                    AppMethodBeat.o(187870);
                    return -1;
            }
        } else {
            AppMethodBeat.o(187870);
            return -1;
        }
    }
}
