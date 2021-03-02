package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class fcc extends a {
    public int KSa;
    public int MjZ;
    public int MqC;
    public int MqD;
    public String MqE;
    public int Scene;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(123683);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.MjZ);
            aVar.aM(2, this.KSa);
            aVar.aM(3, this.Scene);
            if (this.MqE != null) {
                aVar.e(4, this.MqE);
            }
            aVar.aM(5, this.MqD);
            aVar.aM(6, this.MqC);
            AppMethodBeat.o(123683);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.MjZ) + 0 + g.a.a.b.b.a.bu(2, this.KSa) + g.a.a.b.b.a.bu(3, this.Scene);
            if (this.MqE != null) {
                bu += g.a.a.b.b.a.f(4, this.MqE);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(5, this.MqD) + g.a.a.b.b.a.bu(6, this.MqC);
            AppMethodBeat.o(123683);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(123683);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            fcc fcc = (fcc) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    fcc.MjZ = aVar3.UbS.zi();
                    AppMethodBeat.o(123683);
                    return 0;
                case 2:
                    fcc.KSa = aVar3.UbS.zi();
                    AppMethodBeat.o(123683);
                    return 0;
                case 3:
                    fcc.Scene = aVar3.UbS.zi();
                    AppMethodBeat.o(123683);
                    return 0;
                case 4:
                    fcc.MqE = aVar3.UbS.readString();
                    AppMethodBeat.o(123683);
                    return 0;
                case 5:
                    fcc.MqD = aVar3.UbS.zi();
                    AppMethodBeat.o(123683);
                    return 0;
                case 6:
                    fcc.MqC = aVar3.UbS.zi();
                    AppMethodBeat.o(123683);
                    return 0;
                default:
                    AppMethodBeat.o(123683);
                    return -1;
            }
        } else {
            AppMethodBeat.o(123683);
            return -1;
        }
    }
}
