package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class st extends a {
    public boolean EHr;
    public LinkedList<su> LaK = new LinkedList<>();

    public st() {
        AppMethodBeat.i(226014);
        AppMethodBeat.o(226014);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(226015);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.e(1, 8, this.LaK);
            aVar.cc(2, this.EHr);
            AppMethodBeat.o(226015);
            return 0;
        } else if (i2 == 1) {
            int c2 = g.a.a.a.c(1, 8, this.LaK) + 0 + g.a.a.b.b.a.fS(2) + 1;
            AppMethodBeat.o(226015);
            return c2;
        } else if (i2 == 2) {
            this.LaK.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(226015);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            st stVar = (st) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        su suVar = new su();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = suVar.populateBuilderWithField(aVar4, suVar, a.getNextFieldNumber(aVar4))) {
                        }
                        stVar.LaK.add(suVar);
                    }
                    AppMethodBeat.o(226015);
                    return 0;
                case 2:
                    stVar.EHr = aVar3.UbS.yZ();
                    AppMethodBeat.o(226015);
                    return 0;
                default:
                    AppMethodBeat.o(226015);
                    return -1;
            }
        } else {
            AppMethodBeat.o(226015);
            return -1;
        }
    }
}
