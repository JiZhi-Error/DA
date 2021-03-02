package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class sp extends a {
    public LinkedList<Integer> LaF = new LinkedList<>();

    public sp() {
        AppMethodBeat.i(226009);
        AppMethodBeat.o(226009);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(226010);
        if (i2 == 0) {
            ((g.a.a.c.a) objArr[0]).e(1, 2, this.LaF);
            AppMethodBeat.o(226010);
            return 0;
        } else if (i2 == 1) {
            int c2 = g.a.a.a.c(1, 2, this.LaF) + 0;
            AppMethodBeat.o(226010);
            return c2;
        } else if (i2 == 2) {
            this.LaF.clear();
            g.a.a.a.a aVar = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar)) {
                if (!super.populateBuilderWithField(aVar, this, nextFieldNumber)) {
                    aVar.hPl();
                }
            }
            AppMethodBeat.o(226010);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar2 = (g.a.a.a.a) objArr[0];
            sp spVar = (sp) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    spVar.LaF.add(Integer.valueOf(aVar2.UbS.zi()));
                    AppMethodBeat.o(226010);
                    return 0;
                default:
                    AppMethodBeat.o(226010);
                    return -1;
            }
        } else {
            AppMethodBeat.o(226010);
            return -1;
        }
    }
}
