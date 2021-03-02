package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class bbr extends a {
    public String LKO;
    public LinkedList<bdj> LKY = new LinkedList<>();

    public bbr() {
        AppMethodBeat.i(209661);
        AppMethodBeat.o(209661);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209662);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.LKO != null) {
                aVar.e(1, this.LKO);
            }
            aVar.e(2, 8, this.LKY);
            AppMethodBeat.o(209662);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.LKO != null ? g.a.a.b.b.a.f(1, this.LKO) + 0 : 0) + g.a.a.a.c(2, 8, this.LKY);
            AppMethodBeat.o(209662);
            return f2;
        } else if (i2 == 2) {
            this.LKY.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(209662);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bbr bbr = (bbr) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    bbr.LKO = aVar3.UbS.readString();
                    AppMethodBeat.o(209662);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        bdj bdj = new bdj();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = bdj.populateBuilderWithField(aVar4, bdj, a.getNextFieldNumber(aVar4))) {
                        }
                        bbr.LKY.add(bdj);
                    }
                    AppMethodBeat.o(209662);
                    return 0;
                default:
                    AppMethodBeat.o(209662);
                    return -1;
            }
        } else {
            AppMethodBeat.o(209662);
            return -1;
        }
    }
}
