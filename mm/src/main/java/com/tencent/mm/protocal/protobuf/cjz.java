package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class cjz extends a {
    public double KUt;
    public double KUu;
    public String MpA;
    public String Mpy;
    public String Mpz;
    public String rBy;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(32338);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.e(1, this.KUu);
            aVar.e(2, this.KUt);
            if (this.rBy != null) {
                aVar.e(3, this.rBy);
            }
            if (this.Mpy != null) {
                aVar.e(4, this.Mpy);
            }
            if (this.Mpz != null) {
                aVar.e(5, this.Mpz);
            }
            if (this.MpA != null) {
                aVar.e(6, this.MpA);
            }
            AppMethodBeat.o(32338);
            return 0;
        } else if (i2 == 1) {
            int fS = g.a.a.b.b.a.fS(1) + 8 + 0 + g.a.a.b.b.a.fS(2) + 8;
            if (this.rBy != null) {
                fS += g.a.a.b.b.a.f(3, this.rBy);
            }
            if (this.Mpy != null) {
                fS += g.a.a.b.b.a.f(4, this.Mpy);
            }
            if (this.Mpz != null) {
                fS += g.a.a.b.b.a.f(5, this.Mpz);
            }
            if (this.MpA != null) {
                fS += g.a.a.b.b.a.f(6, this.MpA);
            }
            AppMethodBeat.o(32338);
            return fS;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(32338);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cjz cjz = (cjz) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cjz.KUu = Double.longBitsToDouble(aVar3.UbS.zn());
                    AppMethodBeat.o(32338);
                    return 0;
                case 2:
                    cjz.KUt = Double.longBitsToDouble(aVar3.UbS.zn());
                    AppMethodBeat.o(32338);
                    return 0;
                case 3:
                    cjz.rBy = aVar3.UbS.readString();
                    AppMethodBeat.o(32338);
                    return 0;
                case 4:
                    cjz.Mpy = aVar3.UbS.readString();
                    AppMethodBeat.o(32338);
                    return 0;
                case 5:
                    cjz.Mpz = aVar3.UbS.readString();
                    AppMethodBeat.o(32338);
                    return 0;
                case 6:
                    cjz.MpA = aVar3.UbS.readString();
                    AppMethodBeat.o(32338);
                    return 0;
                default:
                    AppMethodBeat.o(32338);
                    return -1;
            }
        } else {
            AppMethodBeat.o(32338);
            return -1;
        }
    }
}
