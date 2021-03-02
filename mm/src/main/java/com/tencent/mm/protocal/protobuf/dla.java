package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class dla extends a {
    public int GroupCount;
    public LinkedList<dkz> MOW = new LinkedList<>();

    public dla() {
        AppMethodBeat.i(6422);
        AppMethodBeat.o(6422);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(6423);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.GroupCount);
            aVar.e(2, 8, this.MOW);
            AppMethodBeat.o(6423);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.GroupCount) + 0 + g.a.a.a.c(2, 8, this.MOW);
            AppMethodBeat.o(6423);
            return bu;
        } else if (i2 == 2) {
            this.MOW.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(6423);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dla dla = (dla) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    dla.GroupCount = aVar3.UbS.zi();
                    AppMethodBeat.o(6423);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        dkz dkz = new dkz();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = dkz.populateBuilderWithField(aVar4, dkz, a.getNextFieldNumber(aVar4))) {
                        }
                        dla.MOW.add(dkz);
                    }
                    AppMethodBeat.o(6423);
                    return 0;
                default:
                    AppMethodBeat.o(6423);
                    return -1;
            }
        } else {
            AppMethodBeat.o(6423);
            return -1;
        }
    }
}
