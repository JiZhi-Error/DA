package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class erc extends a {
    public LinkedList<Float> LOe = new LinkedList<>();

    public erc() {
        AppMethodBeat.i(140932);
        AppMethodBeat.o(140932);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(140933);
        if (i2 == 0) {
            ((g.a.a.c.a) objArr[0]).e(1, 5, this.LOe);
            AppMethodBeat.o(140933);
            return 0;
        } else if (i2 == 1) {
            int c2 = g.a.a.a.c(1, 5, this.LOe) + 0;
            AppMethodBeat.o(140933);
            return c2;
        } else if (i2 == 2) {
            this.LOe.clear();
            g.a.a.a.a aVar = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar)) {
                if (!super.populateBuilderWithField(aVar, this, nextFieldNumber)) {
                    aVar.hPl();
                }
            }
            AppMethodBeat.o(140933);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar2 = (g.a.a.a.a) objArr[0];
            erc erc = (erc) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    erc.LOe.add(Float.valueOf(Float.intBitsToFloat(aVar2.UbS.zm())));
                    AppMethodBeat.o(140933);
                    return 0;
                default:
                    AppMethodBeat.o(140933);
                    return -1;
            }
        } else {
            AppMethodBeat.o(140933);
            return -1;
        }
    }
}