package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class cly extends a {
    public boolean Mrm;
    public boolean Mrn;
    public int Mro;
    public String Mrp;
    public boolean Mrq;
    public boolean Mrr;
    public String Mrs;
    public String dNI;
    public int vUh;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(127172);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.cc(1, this.Mrm);
            aVar.cc(2, this.Mrn);
            aVar.aM(3, this.vUh);
            aVar.aM(4, this.Mro);
            if (this.Mrp != null) {
                aVar.e(5, this.Mrp);
            }
            aVar.cc(6, this.Mrq);
            if (this.dNI != null) {
                aVar.e(7, this.dNI);
            }
            aVar.cc(8, this.Mrr);
            if (this.Mrs != null) {
                aVar.e(9, this.Mrs);
            }
            AppMethodBeat.o(127172);
            return 0;
        } else if (i2 == 1) {
            int fS = g.a.a.b.b.a.fS(1) + 1 + 0 + g.a.a.b.b.a.fS(2) + 1 + g.a.a.b.b.a.bu(3, this.vUh) + g.a.a.b.b.a.bu(4, this.Mro);
            if (this.Mrp != null) {
                fS += g.a.a.b.b.a.f(5, this.Mrp);
            }
            int fS2 = fS + g.a.a.b.b.a.fS(6) + 1;
            if (this.dNI != null) {
                fS2 += g.a.a.b.b.a.f(7, this.dNI);
            }
            int fS3 = fS2 + g.a.a.b.b.a.fS(8) + 1;
            if (this.Mrs != null) {
                fS3 += g.a.a.b.b.a.f(9, this.Mrs);
            }
            AppMethodBeat.o(127172);
            return fS3;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(127172);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cly cly = (cly) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cly.Mrm = aVar3.UbS.yZ();
                    AppMethodBeat.o(127172);
                    return 0;
                case 2:
                    cly.Mrn = aVar3.UbS.yZ();
                    AppMethodBeat.o(127172);
                    return 0;
                case 3:
                    cly.vUh = aVar3.UbS.zi();
                    AppMethodBeat.o(127172);
                    return 0;
                case 4:
                    cly.Mro = aVar3.UbS.zi();
                    AppMethodBeat.o(127172);
                    return 0;
                case 5:
                    cly.Mrp = aVar3.UbS.readString();
                    AppMethodBeat.o(127172);
                    return 0;
                case 6:
                    cly.Mrq = aVar3.UbS.yZ();
                    AppMethodBeat.o(127172);
                    return 0;
                case 7:
                    cly.dNI = aVar3.UbS.readString();
                    AppMethodBeat.o(127172);
                    return 0;
                case 8:
                    cly.Mrr = aVar3.UbS.yZ();
                    AppMethodBeat.o(127172);
                    return 0;
                case 9:
                    cly.Mrs = aVar3.UbS.readString();
                    AppMethodBeat.o(127172);
                    return 0;
                default:
                    AppMethodBeat.o(127172);
                    return -1;
            }
        } else {
            AppMethodBeat.o(127172);
            return -1;
        }
    }
}
