package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class l extends a {
    public boolean xJk;
    public boolean xJl;
    public boolean xJm;
    public boolean xJn;
    public boolean xJo;
    public boolean xJp;
    public boolean xJq;
    public boolean xJr;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(256628);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.cc(1, this.xJk);
            aVar.cc(2, this.xJl);
            aVar.cc(3, this.xJm);
            aVar.cc(4, this.xJn);
            aVar.cc(5, this.xJo);
            aVar.cc(6, this.xJp);
            aVar.cc(7, this.xJq);
            aVar.cc(8, this.xJr);
            AppMethodBeat.o(256628);
            return 0;
        } else if (i2 == 1) {
            int fS = g.a.a.b.b.a.fS(1) + 1 + 0 + g.a.a.b.b.a.fS(2) + 1 + g.a.a.b.b.a.fS(3) + 1 + g.a.a.b.b.a.fS(4) + 1 + g.a.a.b.b.a.fS(5) + 1 + g.a.a.b.b.a.fS(6) + 1 + g.a.a.b.b.a.fS(7) + 1 + g.a.a.b.b.a.fS(8) + 1;
            AppMethodBeat.o(256628);
            return fS;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(256628);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            l lVar = (l) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    lVar.xJk = aVar3.UbS.yZ();
                    AppMethodBeat.o(256628);
                    return 0;
                case 2:
                    lVar.xJl = aVar3.UbS.yZ();
                    AppMethodBeat.o(256628);
                    return 0;
                case 3:
                    lVar.xJm = aVar3.UbS.yZ();
                    AppMethodBeat.o(256628);
                    return 0;
                case 4:
                    lVar.xJn = aVar3.UbS.yZ();
                    AppMethodBeat.o(256628);
                    return 0;
                case 5:
                    lVar.xJo = aVar3.UbS.yZ();
                    AppMethodBeat.o(256628);
                    return 0;
                case 6:
                    lVar.xJp = aVar3.UbS.yZ();
                    AppMethodBeat.o(256628);
                    return 0;
                case 7:
                    lVar.xJq = aVar3.UbS.yZ();
                    AppMethodBeat.o(256628);
                    return 0;
                case 8:
                    lVar.xJr = aVar3.UbS.yZ();
                    AppMethodBeat.o(256628);
                    return 0;
                default:
                    AppMethodBeat.o(256628);
                    return -1;
            }
        } else {
            AppMethodBeat.o(256628);
            return -1;
        }
    }
}