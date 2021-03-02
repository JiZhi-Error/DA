package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class cgv extends a {
    public int KWb;
    public int Mmd;
    public String Mme;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(146308);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.Mmd);
            if (this.Mme != null) {
                aVar.e(2, this.Mme);
            }
            aVar.aM(3, this.KWb);
            AppMethodBeat.o(146308);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.Mmd) + 0;
            if (this.Mme != null) {
                bu += g.a.a.b.b.a.f(2, this.Mme);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(3, this.KWb);
            AppMethodBeat.o(146308);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(146308);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cgv cgv = (cgv) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cgv.Mmd = aVar3.UbS.zi();
                    AppMethodBeat.o(146308);
                    return 0;
                case 2:
                    cgv.Mme = aVar3.UbS.readString();
                    AppMethodBeat.o(146308);
                    return 0;
                case 3:
                    cgv.KWb = aVar3.UbS.zi();
                    AppMethodBeat.o(146308);
                    return 0;
                default:
                    AppMethodBeat.o(146308);
                    return -1;
            }
        } else {
            AppMethodBeat.o(146308);
            return -1;
        }
    }
}
