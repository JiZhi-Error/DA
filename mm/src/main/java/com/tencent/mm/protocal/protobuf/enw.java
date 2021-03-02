package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class enw extends a {
    public LinkedList<String> NlK = new LinkedList<>();
    public int OpCode;

    public enw() {
        AppMethodBeat.i(104845);
        AppMethodBeat.o(104845);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(104846);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.OpCode);
            aVar.e(2, 1, this.NlK);
            AppMethodBeat.o(104846);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.OpCode) + 0 + g.a.a.a.c(2, 1, this.NlK);
            AppMethodBeat.o(104846);
            return bu;
        } else if (i2 == 2) {
            this.NlK.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(104846);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            enw enw = (enw) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    enw.OpCode = aVar3.UbS.zi();
                    AppMethodBeat.o(104846);
                    return 0;
                case 2:
                    enw.NlK.add(aVar3.UbS.readString());
                    AppMethodBeat.o(104846);
                    return 0;
                default:
                    AppMethodBeat.o(104846);
                    return -1;
            }
        } else {
            AppMethodBeat.o(104846);
            return -1;
        }
    }
}
