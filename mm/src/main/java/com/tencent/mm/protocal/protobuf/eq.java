package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class eq extends a {
    public boolean CxY;
    public boolean Cyr;
    public boolean Cys;
    public int KAy;
    public String value;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(50078);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.KAy);
            if (this.value != null) {
                aVar.e(2, this.value);
            }
            aVar.cc(3, this.Cyr);
            aVar.cc(4, this.CxY);
            aVar.cc(5, this.Cys);
            AppMethodBeat.o(50078);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.KAy) + 0;
            if (this.value != null) {
                bu += g.a.a.b.b.a.f(2, this.value);
            }
            int fS = bu + g.a.a.b.b.a.fS(3) + 1 + g.a.a.b.b.a.fS(4) + 1 + g.a.a.b.b.a.fS(5) + 1;
            AppMethodBeat.o(50078);
            return fS;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(50078);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            eq eqVar = (eq) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    eqVar.KAy = aVar3.UbS.zi();
                    AppMethodBeat.o(50078);
                    return 0;
                case 2:
                    eqVar.value = aVar3.UbS.readString();
                    AppMethodBeat.o(50078);
                    return 0;
                case 3:
                    eqVar.Cyr = aVar3.UbS.yZ();
                    AppMethodBeat.o(50078);
                    return 0;
                case 4:
                    eqVar.CxY = aVar3.UbS.yZ();
                    AppMethodBeat.o(50078);
                    return 0;
                case 5:
                    eqVar.Cys = aVar3.UbS.yZ();
                    AppMethodBeat.o(50078);
                    return 0;
                default:
                    AppMethodBeat.o(50078);
                    return -1;
            }
        } else {
            AppMethodBeat.o(50078);
            return -1;
        }
    }
}
