package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class eam extends a {
    public int Etq;
    public int Etr;
    public String KIC;
    public String KID;
    public String KIE;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(125804);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.KIC != null) {
                aVar.e(1, this.KIC);
            }
            if (this.KID != null) {
                aVar.e(2, this.KID);
            }
            if (this.KIE != null) {
                aVar.e(3, this.KIE);
            }
            aVar.aM(4, this.Etq);
            aVar.aM(5, this.Etr);
            AppMethodBeat.o(125804);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.KIC != null ? g.a.a.b.b.a.f(1, this.KIC) + 0 : 0;
            if (this.KID != null) {
                f2 += g.a.a.b.b.a.f(2, this.KID);
            }
            if (this.KIE != null) {
                f2 += g.a.a.b.b.a.f(3, this.KIE);
            }
            int bu = f2 + g.a.a.b.b.a.bu(4, this.Etq) + g.a.a.b.b.a.bu(5, this.Etr);
            AppMethodBeat.o(125804);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(125804);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            eam eam = (eam) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    eam.KIC = aVar3.UbS.readString();
                    AppMethodBeat.o(125804);
                    return 0;
                case 2:
                    eam.KID = aVar3.UbS.readString();
                    AppMethodBeat.o(125804);
                    return 0;
                case 3:
                    eam.KIE = aVar3.UbS.readString();
                    AppMethodBeat.o(125804);
                    return 0;
                case 4:
                    eam.Etq = aVar3.UbS.zi();
                    AppMethodBeat.o(125804);
                    return 0;
                case 5:
                    eam.Etr = aVar3.UbS.zi();
                    AppMethodBeat.o(125804);
                    return 0;
                default:
                    AppMethodBeat.o(125804);
                    return -1;
            }
        } else {
            AppMethodBeat.o(125804);
            return -1;
        }
    }
}
