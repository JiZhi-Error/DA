package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class vh extends a {
    public int LfB;
    public int LfC;
    public int jlJ;
    public String qHk;
    public int tag;
    public String url;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(196378);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.tag);
            if (this.url != null) {
                aVar.e(2, this.url);
            }
            aVar.aM(3, this.LfB);
            if (this.qHk != null) {
                aVar.e(4, this.qHk);
            }
            aVar.aM(5, this.jlJ);
            aVar.aM(6, this.LfC);
            AppMethodBeat.o(196378);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.tag) + 0;
            if (this.url != null) {
                bu += g.a.a.b.b.a.f(2, this.url);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(3, this.LfB);
            if (this.qHk != null) {
                bu2 += g.a.a.b.b.a.f(4, this.qHk);
            }
            int bu3 = bu2 + g.a.a.b.b.a.bu(5, this.jlJ) + g.a.a.b.b.a.bu(6, this.LfC);
            AppMethodBeat.o(196378);
            return bu3;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(196378);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            vh vhVar = (vh) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    vhVar.tag = aVar3.UbS.zi();
                    AppMethodBeat.o(196378);
                    return 0;
                case 2:
                    vhVar.url = aVar3.UbS.readString();
                    AppMethodBeat.o(196378);
                    return 0;
                case 3:
                    vhVar.LfB = aVar3.UbS.zi();
                    AppMethodBeat.o(196378);
                    return 0;
                case 4:
                    vhVar.qHk = aVar3.UbS.readString();
                    AppMethodBeat.o(196378);
                    return 0;
                case 5:
                    vhVar.jlJ = aVar3.UbS.zi();
                    AppMethodBeat.o(196378);
                    return 0;
                case 6:
                    vhVar.LfC = aVar3.UbS.zi();
                    AppMethodBeat.o(196378);
                    return 0;
                default:
                    AppMethodBeat.o(196378);
                    return -1;
            }
        } else {
            AppMethodBeat.o(196378);
            return -1;
        }
    }
}
