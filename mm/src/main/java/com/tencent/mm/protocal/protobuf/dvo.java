package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class dvo extends a {
    public boolean gyp = true;
    public LinkedList<dvp> iAd = new LinkedList<>();

    public dvo() {
        AppMethodBeat.i(122542);
        AppMethodBeat.o(122542);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(122543);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.cc(1, this.gyp);
            aVar.e(2, 8, this.iAd);
            AppMethodBeat.o(122543);
            return 0;
        } else if (i2 == 1) {
            int fS = g.a.a.b.b.a.fS(1) + 1 + 0 + g.a.a.a.c(2, 8, this.iAd);
            AppMethodBeat.o(122543);
            return fS;
        } else if (i2 == 2) {
            this.iAd.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(122543);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dvo dvo = (dvo) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    dvo.gyp = aVar3.UbS.yZ();
                    AppMethodBeat.o(122543);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        dvp dvp = new dvp();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = dvp.populateBuilderWithField(aVar4, dvp, a.getNextFieldNumber(aVar4))) {
                        }
                        dvo.iAd.add(dvp);
                    }
                    AppMethodBeat.o(122543);
                    return 0;
                default:
                    AppMethodBeat.o(122543);
                    return -1;
            }
        } else {
            AppMethodBeat.o(122543);
            return -1;
        }
    }
}
