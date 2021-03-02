package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class doo extends a {
    public int KXC;
    public String MbW;
    public int MbZ;
    public String dNI;
    public String username;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(175247);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.dNI != null) {
                aVar.e(1, this.dNI);
            }
            if (this.username != null) {
                aVar.e(2, this.username);
            }
            if (this.MbW != null) {
                aVar.e(3, this.MbW);
            }
            aVar.aM(4, this.MbZ);
            aVar.aM(5, this.KXC);
            AppMethodBeat.o(175247);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.dNI != null ? g.a.a.b.b.a.f(1, this.dNI) + 0 : 0;
            if (this.username != null) {
                f2 += g.a.a.b.b.a.f(2, this.username);
            }
            if (this.MbW != null) {
                f2 += g.a.a.b.b.a.f(3, this.MbW);
            }
            int bu = f2 + g.a.a.b.b.a.bu(4, this.MbZ) + g.a.a.b.b.a.bu(5, this.KXC);
            AppMethodBeat.o(175247);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(175247);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            doo doo = (doo) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    doo.dNI = aVar3.UbS.readString();
                    AppMethodBeat.o(175247);
                    return 0;
                case 2:
                    doo.username = aVar3.UbS.readString();
                    AppMethodBeat.o(175247);
                    return 0;
                case 3:
                    doo.MbW = aVar3.UbS.readString();
                    AppMethodBeat.o(175247);
                    return 0;
                case 4:
                    doo.MbZ = aVar3.UbS.zi();
                    AppMethodBeat.o(175247);
                    return 0;
                case 5:
                    doo.KXC = aVar3.UbS.zi();
                    AppMethodBeat.o(175247);
                    return 0;
                default:
                    AppMethodBeat.o(175247);
                    return -1;
            }
        } else {
            AppMethodBeat.o(175247);
            return -1;
        }
    }
}
