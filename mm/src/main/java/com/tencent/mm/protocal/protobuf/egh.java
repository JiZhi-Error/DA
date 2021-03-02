package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class egh extends a {
    public String Ngm;
    public String Ngn;
    public int Ngo;
    public String Ngp;
    public int xub;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(187887);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Ngm != null) {
                aVar.e(1, this.Ngm);
            }
            if (this.Ngn != null) {
                aVar.e(2, this.Ngn);
            }
            aVar.aM(3, this.xub);
            aVar.aM(4, this.Ngo);
            if (this.Ngp != null) {
                aVar.e(5, this.Ngp);
            }
            AppMethodBeat.o(187887);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.Ngm != null ? g.a.a.b.b.a.f(1, this.Ngm) + 0 : 0;
            if (this.Ngn != null) {
                f2 += g.a.a.b.b.a.f(2, this.Ngn);
            }
            int bu = f2 + g.a.a.b.b.a.bu(3, this.xub) + g.a.a.b.b.a.bu(4, this.Ngo);
            if (this.Ngp != null) {
                bu += g.a.a.b.b.a.f(5, this.Ngp);
            }
            AppMethodBeat.o(187887);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(187887);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            egh egh = (egh) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    egh.Ngm = aVar3.UbS.readString();
                    AppMethodBeat.o(187887);
                    return 0;
                case 2:
                    egh.Ngn = aVar3.UbS.readString();
                    AppMethodBeat.o(187887);
                    return 0;
                case 3:
                    egh.xub = aVar3.UbS.zi();
                    AppMethodBeat.o(187887);
                    return 0;
                case 4:
                    egh.Ngo = aVar3.UbS.zi();
                    AppMethodBeat.o(187887);
                    return 0;
                case 5:
                    egh.Ngp = aVar3.UbS.readString();
                    AppMethodBeat.o(187887);
                    return 0;
                default:
                    AppMethodBeat.o(187887);
                    return -1;
            }
        } else {
            AppMethodBeat.o(187887);
            return -1;
        }
    }
}
