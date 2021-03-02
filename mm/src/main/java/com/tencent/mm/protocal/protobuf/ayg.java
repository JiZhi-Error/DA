package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class ayg extends a {
    public float LIt;
    public float LIu;
    public float LIv;
    public float LIw;
    public float LIx;
    public boolean LIy;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209586);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.E(1, this.LIt);
            aVar.E(2, this.LIu);
            aVar.E(3, this.LIv);
            aVar.E(4, this.LIw);
            aVar.E(5, this.LIx);
            aVar.cc(6, this.LIy);
            AppMethodBeat.o(209586);
            return 0;
        } else if (i2 == 1) {
            int fS = g.a.a.b.b.a.fS(1) + 4 + 0 + g.a.a.b.b.a.fS(2) + 4 + g.a.a.b.b.a.fS(3) + 4 + g.a.a.b.b.a.fS(4) + 4 + g.a.a.b.b.a.fS(5) + 4 + g.a.a.b.b.a.fS(6) + 1;
            AppMethodBeat.o(209586);
            return fS;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(209586);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ayg ayg = (ayg) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ayg.LIt = Float.intBitsToFloat(aVar3.UbS.zm());
                    AppMethodBeat.o(209586);
                    return 0;
                case 2:
                    ayg.LIu = Float.intBitsToFloat(aVar3.UbS.zm());
                    AppMethodBeat.o(209586);
                    return 0;
                case 3:
                    ayg.LIv = Float.intBitsToFloat(aVar3.UbS.zm());
                    AppMethodBeat.o(209586);
                    return 0;
                case 4:
                    ayg.LIw = Float.intBitsToFloat(aVar3.UbS.zm());
                    AppMethodBeat.o(209586);
                    return 0;
                case 5:
                    ayg.LIx = Float.intBitsToFloat(aVar3.UbS.zm());
                    AppMethodBeat.o(209586);
                    return 0;
                case 6:
                    ayg.LIy = aVar3.UbS.yZ();
                    AppMethodBeat.o(209586);
                    return 0;
                default:
                    AppMethodBeat.o(209586);
                    return -1;
            }
        } else {
            AppMethodBeat.o(209586);
            return -1;
        }
    }
}
