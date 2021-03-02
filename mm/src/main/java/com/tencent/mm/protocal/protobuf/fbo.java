package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class fbo extends a {
    public int KCD;
    public String Mmh;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(123681);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.KCD);
            if (this.Mmh != null) {
                aVar.e(2, this.Mmh);
            }
            AppMethodBeat.o(123681);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.KCD) + 0;
            if (this.Mmh != null) {
                bu += g.a.a.b.b.a.f(2, this.Mmh);
            }
            AppMethodBeat.o(123681);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(123681);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            fbo fbo = (fbo) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    fbo.KCD = aVar3.UbS.zi();
                    AppMethodBeat.o(123681);
                    return 0;
                case 2:
                    fbo.Mmh = aVar3.UbS.readString();
                    AppMethodBeat.o(123681);
                    return 0;
                default:
                    AppMethodBeat.o(123681);
                    return -1;
            }
        } else {
            AppMethodBeat.o(123681);
            return -1;
        }
    }
}
