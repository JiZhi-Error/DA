package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;

public final class eyr extends a {
    public String KWF;
    public int xNF;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(32530);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.KWF == null) {
                b bVar = new b("Not all required fields were included: Data");
                AppMethodBeat.o(32530);
                throw bVar;
            }
            aVar.aM(1, this.xNF);
            if (this.KWF != null) {
                aVar.e(2, this.KWF);
            }
            AppMethodBeat.o(32530);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.xNF) + 0;
            if (this.KWF != null) {
                bu += g.a.a.b.b.a.f(2, this.KWF);
            }
            AppMethodBeat.o(32530);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.KWF == null) {
                b bVar2 = new b("Not all required fields were included: Data");
                AppMethodBeat.o(32530);
                throw bVar2;
            }
            AppMethodBeat.o(32530);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            eyr eyr = (eyr) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    eyr.xNF = aVar3.UbS.zi();
                    AppMethodBeat.o(32530);
                    return 0;
                case 2:
                    eyr.KWF = aVar3.UbS.readString();
                    AppMethodBeat.o(32530);
                    return 0;
                default:
                    AppMethodBeat.o(32530);
                    return -1;
            }
        } else {
            AppMethodBeat.o(32530);
            return -1;
        }
    }
}
