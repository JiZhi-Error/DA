package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class czw extends a {
    public String KZR;
    public int MFg;
    public String MFh;
    public String MFi;
    public String dNI;
    public String iwv;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91579);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.dNI != null) {
                aVar.e(1, this.dNI);
            }
            aVar.aM(2, this.MFg);
            if (this.MFh != null) {
                aVar.e(3, this.MFh);
            }
            if (this.MFi != null) {
                aVar.e(4, this.MFi);
            }
            if (this.KZR != null) {
                aVar.e(5, this.KZR);
            }
            if (this.iwv != null) {
                aVar.e(6, this.iwv);
            }
            AppMethodBeat.o(91579);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.dNI != null ? g.a.a.b.b.a.f(1, this.dNI) + 0 : 0) + g.a.a.b.b.a.bu(2, this.MFg);
            if (this.MFh != null) {
                f2 += g.a.a.b.b.a.f(3, this.MFh);
            }
            if (this.MFi != null) {
                f2 += g.a.a.b.b.a.f(4, this.MFi);
            }
            if (this.KZR != null) {
                f2 += g.a.a.b.b.a.f(5, this.KZR);
            }
            if (this.iwv != null) {
                f2 += g.a.a.b.b.a.f(6, this.iwv);
            }
            AppMethodBeat.o(91579);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(91579);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            czw czw = (czw) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    czw.dNI = aVar3.UbS.readString();
                    AppMethodBeat.o(91579);
                    return 0;
                case 2:
                    czw.MFg = aVar3.UbS.zi();
                    AppMethodBeat.o(91579);
                    return 0;
                case 3:
                    czw.MFh = aVar3.UbS.readString();
                    AppMethodBeat.o(91579);
                    return 0;
                case 4:
                    czw.MFi = aVar3.UbS.readString();
                    AppMethodBeat.o(91579);
                    return 0;
                case 5:
                    czw.KZR = aVar3.UbS.readString();
                    AppMethodBeat.o(91579);
                    return 0;
                case 6:
                    czw.iwv = aVar3.UbS.readString();
                    AppMethodBeat.o(91579);
                    return 0;
                default:
                    AppMethodBeat.o(91579);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91579);
            return -1;
        }
    }
}
