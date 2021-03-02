package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class cmv extends a {
    public LinkedList<Float> Msu = new LinkedList<>();

    public cmv() {
        AppMethodBeat.i(201297);
        AppMethodBeat.o(201297);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(201298);
        if (i2 == 0) {
            ((g.a.a.c.a) objArr[0]).e(1, 5, this.Msu);
            AppMethodBeat.o(201298);
            return 0;
        } else if (i2 == 1) {
            int c2 = g.a.a.a.c(1, 5, this.Msu) + 0;
            AppMethodBeat.o(201298);
            return c2;
        } else if (i2 == 2) {
            this.Msu.clear();
            g.a.a.a.a aVar = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar)) {
                if (!super.populateBuilderWithField(aVar, this, nextFieldNumber)) {
                    aVar.hPl();
                }
            }
            AppMethodBeat.o(201298);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar2 = (g.a.a.a.a) objArr[0];
            cmv cmv = (cmv) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cmv.Msu.add(Float.valueOf(Float.intBitsToFloat(aVar2.UbS.zm())));
                    AppMethodBeat.o(201298);
                    return 0;
                default:
                    AppMethodBeat.o(201298);
                    return -1;
            }
        } else {
            AppMethodBeat.o(201298);
            return -1;
        }
    }
}
