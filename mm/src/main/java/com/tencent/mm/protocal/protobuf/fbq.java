package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class fbq extends a {
    public int KSa;
    public String NxM;
    public String NxN;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(123682);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.KSa);
            if (this.NxM != null) {
                aVar.e(2, this.NxM);
            }
            if (this.NxN != null) {
                aVar.e(3, this.NxN);
            }
            AppMethodBeat.o(123682);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.KSa) + 0;
            if (this.NxM != null) {
                bu += g.a.a.b.b.a.f(2, this.NxM);
            }
            if (this.NxN != null) {
                bu += g.a.a.b.b.a.f(3, this.NxN);
            }
            AppMethodBeat.o(123682);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(123682);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            fbq fbq = (fbq) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    fbq.KSa = aVar3.UbS.zi();
                    AppMethodBeat.o(123682);
                    return 0;
                case 2:
                    fbq.NxM = aVar3.UbS.readString();
                    AppMethodBeat.o(123682);
                    return 0;
                case 3:
                    fbq.NxN = aVar3.UbS.readString();
                    AppMethodBeat.o(123682);
                    return 0;
                default:
                    AppMethodBeat.o(123682);
                    return -1;
            }
        } else {
            AppMethodBeat.o(123682);
            return -1;
        }
    }
}
