package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class np extends a {
    public int KSY;
    public int KSZ;
    public int KTa;
    public String KTb;
    public String KTc;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(124410);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.KSY);
            aVar.aM(2, this.KSZ);
            aVar.aM(3, this.KTa);
            if (this.KTb != null) {
                aVar.e(4, this.KTb);
            }
            if (this.KTc != null) {
                aVar.e(5, this.KTc);
            }
            AppMethodBeat.o(124410);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.KSY) + 0 + g.a.a.b.b.a.bu(2, this.KSZ) + g.a.a.b.b.a.bu(3, this.KTa);
            if (this.KTb != null) {
                bu += g.a.a.b.b.a.f(4, this.KTb);
            }
            if (this.KTc != null) {
                bu += g.a.a.b.b.a.f(5, this.KTc);
            }
            AppMethodBeat.o(124410);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(124410);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            np npVar = (np) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    npVar.KSY = aVar3.UbS.zi();
                    AppMethodBeat.o(124410);
                    return 0;
                case 2:
                    npVar.KSZ = aVar3.UbS.zi();
                    AppMethodBeat.o(124410);
                    return 0;
                case 3:
                    npVar.KTa = aVar3.UbS.zi();
                    AppMethodBeat.o(124410);
                    return 0;
                case 4:
                    npVar.KTb = aVar3.UbS.readString();
                    AppMethodBeat.o(124410);
                    return 0;
                case 5:
                    npVar.KTc = aVar3.UbS.readString();
                    AppMethodBeat.o(124410);
                    return 0;
                default:
                    AppMethodBeat.o(124410);
                    return -1;
            }
        } else {
            AppMethodBeat.o(124410);
            return -1;
        }
    }
}
