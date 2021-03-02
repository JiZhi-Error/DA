package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class exd extends a {
    public LinkedList<exe> LSL = new LinkedList<>();

    public exd() {
        AppMethodBeat.i(91727);
        AppMethodBeat.o(91727);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91728);
        if (i2 == 0) {
            ((g.a.a.c.a) objArr[0]).e(1, 8, this.LSL);
            AppMethodBeat.o(91728);
            return 0;
        } else if (i2 == 1) {
            int c2 = g.a.a.a.c(1, 8, this.LSL) + 0;
            AppMethodBeat.o(91728);
            return c2;
        } else if (i2 == 2) {
            this.LSL.clear();
            g.a.a.a.a aVar = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar)) {
                if (!super.populateBuilderWithField(aVar, this, nextFieldNumber)) {
                    aVar.hPl();
                }
            }
            AppMethodBeat.o(91728);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar2 = (g.a.a.a.a) objArr[0];
            exd exd = (exd) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar2.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        exe exe = new exe();
                        g.a.a.a.a aVar3 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = exe.populateBuilderWithField(aVar3, exe, a.getNextFieldNumber(aVar3))) {
                        }
                        exd.LSL.add(exe);
                    }
                    AppMethodBeat.o(91728);
                    return 0;
                default:
                    AppMethodBeat.o(91728);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91728);
            return -1;
        }
    }
}
