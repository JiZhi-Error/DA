package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class qk extends a {
    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(124463);
        if (i2 == 0) {
            AppMethodBeat.o(124463);
            return 0;
        } else if (i2 == 1) {
            AppMethodBeat.o(124463);
            return 0;
        } else if (i2 == 2) {
            g.a.a.a.a aVar = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar)) {
                if (!super.populateBuilderWithField(aVar, this, nextFieldNumber)) {
                    aVar.hPl();
                }
            }
            AppMethodBeat.o(124463);
            return 0;
        } else if (i2 == 3) {
            ((Integer) objArr[2]).intValue();
            AppMethodBeat.o(124463);
            return -1;
        } else {
            AppMethodBeat.o(124463);
            return -1;
        }
    }
}
