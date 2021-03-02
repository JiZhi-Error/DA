package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class aaw extends a {
    public int Lmd;
    public String Lme;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209319);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.Lmd);
            if (this.Lme != null) {
                aVar.e(2, this.Lme);
            }
            AppMethodBeat.o(209319);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.Lmd) + 0;
            if (this.Lme != null) {
                bu += g.a.a.b.b.a.f(2, this.Lme);
            }
            AppMethodBeat.o(209319);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(209319);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            aaw aaw = (aaw) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    aaw.Lmd = aVar3.UbS.zi();
                    AppMethodBeat.o(209319);
                    return 0;
                case 2:
                    aaw.Lme = aVar3.UbS.readString();
                    AppMethodBeat.o(209319);
                    return 0;
                default:
                    AppMethodBeat.o(209319);
                    return -1;
            }
        } else {
            AppMethodBeat.o(209319);
            return -1;
        }
    }
}
