package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class cla extends a {
    public int KHa;
    public String Mqy;
    public String Title;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(124528);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Mqy != null) {
                aVar.e(1, this.Mqy);
            }
            if (this.Title != null) {
                aVar.e(2, this.Title);
            }
            aVar.aM(3, this.KHa);
            AppMethodBeat.o(124528);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.Mqy != null ? g.a.a.b.b.a.f(1, this.Mqy) + 0 : 0;
            if (this.Title != null) {
                f2 += g.a.a.b.b.a.f(2, this.Title);
            }
            int bu = f2 + g.a.a.b.b.a.bu(3, this.KHa);
            AppMethodBeat.o(124528);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(124528);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cla cla = (cla) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cla.Mqy = aVar3.UbS.readString();
                    AppMethodBeat.o(124528);
                    return 0;
                case 2:
                    cla.Title = aVar3.UbS.readString();
                    AppMethodBeat.o(124528);
                    return 0;
                case 3:
                    cla.KHa = aVar3.UbS.zi();
                    AppMethodBeat.o(124528);
                    return 0;
                default:
                    AppMethodBeat.o(124528);
                    return -1;
            }
        } else {
            AppMethodBeat.o(124528);
            return -1;
        }
    }
}
