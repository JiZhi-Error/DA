package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class aja extends a {
    public long Brn;
    public int BsF;
    public int BsG;
    public int LsD;
    public String MD5;
    public int Ret;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(109447);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.Ret);
            aVar.aM(2, this.BsG);
            aVar.aM(3, this.BsF);
            if (this.MD5 != null) {
                aVar.e(4, this.MD5);
            }
            aVar.aM(5, this.LsD);
            aVar.bb(6, this.Brn);
            AppMethodBeat.o(109447);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.Ret) + 0 + g.a.a.b.b.a.bu(2, this.BsG) + g.a.a.b.b.a.bu(3, this.BsF);
            if (this.MD5 != null) {
                bu += g.a.a.b.b.a.f(4, this.MD5);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(5, this.LsD) + g.a.a.b.b.a.r(6, this.Brn);
            AppMethodBeat.o(109447);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(109447);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            aja aja = (aja) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    aja.Ret = aVar3.UbS.zi();
                    AppMethodBeat.o(109447);
                    return 0;
                case 2:
                    aja.BsG = aVar3.UbS.zi();
                    AppMethodBeat.o(109447);
                    return 0;
                case 3:
                    aja.BsF = aVar3.UbS.zi();
                    AppMethodBeat.o(109447);
                    return 0;
                case 4:
                    aja.MD5 = aVar3.UbS.readString();
                    AppMethodBeat.o(109447);
                    return 0;
                case 5:
                    aja.LsD = aVar3.UbS.zi();
                    AppMethodBeat.o(109447);
                    return 0;
                case 6:
                    aja.Brn = aVar3.UbS.zl();
                    AppMethodBeat.o(109447);
                    return 0;
                default:
                    AppMethodBeat.o(109447);
                    return -1;
            }
        } else {
            AppMethodBeat.o(109447);
            return -1;
        }
    }
}
