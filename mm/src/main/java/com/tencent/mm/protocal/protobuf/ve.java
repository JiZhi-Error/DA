package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class ve extends a {
    public int Lfw;
    public String Lfx;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(50081);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.Lfw);
            if (this.Lfx != null) {
                aVar.e(2, this.Lfx);
            }
            AppMethodBeat.o(50081);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.Lfw) + 0;
            if (this.Lfx != null) {
                bu += g.a.a.b.b.a.f(2, this.Lfx);
            }
            AppMethodBeat.o(50081);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(50081);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ve veVar = (ve) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    veVar.Lfw = aVar3.UbS.zi();
                    AppMethodBeat.o(50081);
                    return 0;
                case 2:
                    veVar.Lfx = aVar3.UbS.readString();
                    AppMethodBeat.o(50081);
                    return 0;
                default:
                    AppMethodBeat.o(50081);
                    return -1;
            }
        } else {
            AppMethodBeat.o(50081);
            return -1;
        }
    }
}
