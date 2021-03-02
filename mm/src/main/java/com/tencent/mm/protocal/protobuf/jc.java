package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class jc extends a {
    public String CiX;
    public boolean KNE;
    public String KNF;
    public String KNs;
    public String KNu;
    public String dDj;
    public String ynT;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(19405);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.ynT != null) {
                aVar.e(1, this.ynT);
            }
            if (this.CiX != null) {
                aVar.e(2, this.CiX);
            }
            if (this.dDj != null) {
                aVar.e(3, this.dDj);
            }
            aVar.cc(4, this.KNE);
            if (this.KNu != null) {
                aVar.e(5, this.KNu);
            }
            if (this.KNs != null) {
                aVar.e(6, this.KNs);
            }
            if (this.KNF != null) {
                aVar.e(7, this.KNF);
            }
            AppMethodBeat.o(19405);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.ynT != null ? g.a.a.b.b.a.f(1, this.ynT) + 0 : 0;
            if (this.CiX != null) {
                f2 += g.a.a.b.b.a.f(2, this.CiX);
            }
            if (this.dDj != null) {
                f2 += g.a.a.b.b.a.f(3, this.dDj);
            }
            int fS = f2 + g.a.a.b.b.a.fS(4) + 1;
            if (this.KNu != null) {
                fS += g.a.a.b.b.a.f(5, this.KNu);
            }
            if (this.KNs != null) {
                fS += g.a.a.b.b.a.f(6, this.KNs);
            }
            if (this.KNF != null) {
                fS += g.a.a.b.b.a.f(7, this.KNF);
            }
            AppMethodBeat.o(19405);
            return fS;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(19405);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            jc jcVar = (jc) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    jcVar.ynT = aVar3.UbS.readString();
                    AppMethodBeat.o(19405);
                    return 0;
                case 2:
                    jcVar.CiX = aVar3.UbS.readString();
                    AppMethodBeat.o(19405);
                    return 0;
                case 3:
                    jcVar.dDj = aVar3.UbS.readString();
                    AppMethodBeat.o(19405);
                    return 0;
                case 4:
                    jcVar.KNE = aVar3.UbS.yZ();
                    AppMethodBeat.o(19405);
                    return 0;
                case 5:
                    jcVar.KNu = aVar3.UbS.readString();
                    AppMethodBeat.o(19405);
                    return 0;
                case 6:
                    jcVar.KNs = aVar3.UbS.readString();
                    AppMethodBeat.o(19405);
                    return 0;
                case 7:
                    jcVar.KNF = aVar3.UbS.readString();
                    AppMethodBeat.o(19405);
                    return 0;
                default:
                    AppMethodBeat.o(19405);
                    return -1;
            }
        } else {
            AppMethodBeat.o(19405);
            return -1;
        }
    }
}
