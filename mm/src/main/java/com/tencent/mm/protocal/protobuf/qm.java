package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class qm extends a {
    public String KSj;
    public int KUx;
    public int KUy;
    public int KXq;
    public String KXr;
    public String Title;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(124464);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.KUx);
            aVar.aM(2, this.KUy);
            aVar.aM(3, this.KXq);
            if (this.Title != null) {
                aVar.e(4, this.Title);
            }
            if (this.KXr != null) {
                aVar.e(5, this.KXr);
            }
            if (this.KSj != null) {
                aVar.e(6, this.KSj);
            }
            AppMethodBeat.o(124464);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.KUx) + 0 + g.a.a.b.b.a.bu(2, this.KUy) + g.a.a.b.b.a.bu(3, this.KXq);
            if (this.Title != null) {
                bu += g.a.a.b.b.a.f(4, this.Title);
            }
            if (this.KXr != null) {
                bu += g.a.a.b.b.a.f(5, this.KXr);
            }
            if (this.KSj != null) {
                bu += g.a.a.b.b.a.f(6, this.KSj);
            }
            AppMethodBeat.o(124464);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(124464);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            qm qmVar = (qm) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    qmVar.KUx = aVar3.UbS.zi();
                    AppMethodBeat.o(124464);
                    return 0;
                case 2:
                    qmVar.KUy = aVar3.UbS.zi();
                    AppMethodBeat.o(124464);
                    return 0;
                case 3:
                    qmVar.KXq = aVar3.UbS.zi();
                    AppMethodBeat.o(124464);
                    return 0;
                case 4:
                    qmVar.Title = aVar3.UbS.readString();
                    AppMethodBeat.o(124464);
                    return 0;
                case 5:
                    qmVar.KXr = aVar3.UbS.readString();
                    AppMethodBeat.o(124464);
                    return 0;
                case 6:
                    qmVar.KSj = aVar3.UbS.readString();
                    AppMethodBeat.o(124464);
                    return 0;
                default:
                    AppMethodBeat.o(124464);
                    return -1;
            }
        } else {
            AppMethodBeat.o(124464);
            return -1;
        }
    }
}
