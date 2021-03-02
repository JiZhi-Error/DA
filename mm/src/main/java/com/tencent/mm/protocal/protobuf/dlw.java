package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class dlw extends a {
    public int MJg;
    public String MPA;
    public int MPB;
    public String MPz;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91667);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.MJg);
            if (this.MPz != null) {
                aVar.e(2, this.MPz);
            }
            if (this.MPA != null) {
                aVar.e(3, this.MPA);
            }
            aVar.aM(4, this.MPB);
            AppMethodBeat.o(91667);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.MJg) + 0;
            if (this.MPz != null) {
                bu += g.a.a.b.b.a.f(2, this.MPz);
            }
            if (this.MPA != null) {
                bu += g.a.a.b.b.a.f(3, this.MPA);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(4, this.MPB);
            AppMethodBeat.o(91667);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(91667);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dlw dlw = (dlw) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    dlw.MJg = aVar3.UbS.zi();
                    AppMethodBeat.o(91667);
                    return 0;
                case 2:
                    dlw.MPz = aVar3.UbS.readString();
                    AppMethodBeat.o(91667);
                    return 0;
                case 3:
                    dlw.MPA = aVar3.UbS.readString();
                    AppMethodBeat.o(91667);
                    return 0;
                case 4:
                    dlw.MPB = aVar3.UbS.zi();
                    AppMethodBeat.o(91667);
                    return 0;
                default:
                    AppMethodBeat.o(91667);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91667);
            return -1;
        }
    }
}
