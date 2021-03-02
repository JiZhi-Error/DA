package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class dvf extends a {
    public LinkedList<String> KKJ = new LinkedList<>();
    public LinkedList<String> MWk = new LinkedList<>();

    public dvf() {
        AppMethodBeat.i(91685);
        AppMethodBeat.o(91685);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91686);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.e(1, 1, this.KKJ);
            aVar.e(2, 1, this.MWk);
            AppMethodBeat.o(91686);
            return 0;
        } else if (i2 == 1) {
            int c2 = g.a.a.a.c(1, 1, this.KKJ) + 0 + g.a.a.a.c(2, 1, this.MWk);
            AppMethodBeat.o(91686);
            return c2;
        } else if (i2 == 2) {
            this.KKJ.clear();
            this.MWk.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(91686);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dvf dvf = (dvf) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    dvf.KKJ.add(aVar3.UbS.readString());
                    AppMethodBeat.o(91686);
                    return 0;
                case 2:
                    dvf.MWk.add(aVar3.UbS.readString());
                    AppMethodBeat.o(91686);
                    return 0;
                default:
                    AppMethodBeat.o(91686);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91686);
            return -1;
        }
    }
}
