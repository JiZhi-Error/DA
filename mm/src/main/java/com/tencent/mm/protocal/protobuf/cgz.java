package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class cgz extends a {
    public int KCD;
    public String Mdz;
    public String Mmf;
    public boolean Mmg;
    public String Mmh;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(123623);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.KCD);
            if (this.Mmf != null) {
                aVar.e(2, this.Mmf);
            }
            aVar.cc(3, this.Mmg);
            if (this.Mmh != null) {
                aVar.e(4, this.Mmh);
            }
            if (this.Mdz != null) {
                aVar.e(5, this.Mdz);
            }
            AppMethodBeat.o(123623);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.KCD) + 0;
            if (this.Mmf != null) {
                bu += g.a.a.b.b.a.f(2, this.Mmf);
            }
            int fS = bu + g.a.a.b.b.a.fS(3) + 1;
            if (this.Mmh != null) {
                fS += g.a.a.b.b.a.f(4, this.Mmh);
            }
            if (this.Mdz != null) {
                fS += g.a.a.b.b.a.f(5, this.Mdz);
            }
            AppMethodBeat.o(123623);
            return fS;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(123623);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cgz cgz = (cgz) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cgz.KCD = aVar3.UbS.zi();
                    AppMethodBeat.o(123623);
                    return 0;
                case 2:
                    cgz.Mmf = aVar3.UbS.readString();
                    AppMethodBeat.o(123623);
                    return 0;
                case 3:
                    cgz.Mmg = aVar3.UbS.yZ();
                    AppMethodBeat.o(123623);
                    return 0;
                case 4:
                    cgz.Mmh = aVar3.UbS.readString();
                    AppMethodBeat.o(123623);
                    return 0;
                case 5:
                    cgz.Mdz = aVar3.UbS.readString();
                    AppMethodBeat.o(123623);
                    return 0;
                default:
                    AppMethodBeat.o(123623);
                    return -1;
            }
        } else {
            AppMethodBeat.o(123623);
            return -1;
        }
    }
}
