package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class amw extends a {
    public int KGZ;
    public int KHa;
    public int KHb;
    public int KHc;
    public String KHf;
    public int oTW;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(127470);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.KGZ);
            aVar.aM(2, this.oTW);
            if (this.KHf != null) {
                aVar.e(3, this.KHf);
            }
            aVar.aM(4, this.KHa);
            aVar.aM(5, this.KHb);
            aVar.aM(6, this.KHc);
            AppMethodBeat.o(127470);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.KGZ) + 0 + g.a.a.b.b.a.bu(2, this.oTW);
            if (this.KHf != null) {
                bu += g.a.a.b.b.a.f(3, this.KHf);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(4, this.KHa) + g.a.a.b.b.a.bu(5, this.KHb) + g.a.a.b.b.a.bu(6, this.KHc);
            AppMethodBeat.o(127470);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(127470);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            amw amw = (amw) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    amw.KGZ = aVar3.UbS.zi();
                    AppMethodBeat.o(127470);
                    return 0;
                case 2:
                    amw.oTW = aVar3.UbS.zi();
                    AppMethodBeat.o(127470);
                    return 0;
                case 3:
                    amw.KHf = aVar3.UbS.readString();
                    AppMethodBeat.o(127470);
                    return 0;
                case 4:
                    amw.KHa = aVar3.UbS.zi();
                    AppMethodBeat.o(127470);
                    return 0;
                case 5:
                    amw.KHb = aVar3.UbS.zi();
                    AppMethodBeat.o(127470);
                    return 0;
                case 6:
                    amw.KHc = aVar3.UbS.zi();
                    AppMethodBeat.o(127470);
                    return 0;
                default:
                    AppMethodBeat.o(127470);
                    return -1;
            }
        } else {
            AppMethodBeat.o(127470);
            return -1;
        }
    }
}
