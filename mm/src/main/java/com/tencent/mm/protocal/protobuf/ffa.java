package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class ffa extends a {
    public int KSa;
    public int MjZ;
    public int NAo;
    public int NAp;
    public int Scene;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(123712);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.MjZ);
            aVar.aM(2, this.KSa);
            aVar.aM(3, this.NAo);
            aVar.aM(4, this.Scene);
            aVar.aM(10, this.NAp);
            AppMethodBeat.o(123712);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.MjZ) + 0 + g.a.a.b.b.a.bu(2, this.KSa) + g.a.a.b.b.a.bu(3, this.NAo) + g.a.a.b.b.a.bu(4, this.Scene) + g.a.a.b.b.a.bu(10, this.NAp);
            AppMethodBeat.o(123712);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(123712);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ffa ffa = (ffa) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ffa.MjZ = aVar3.UbS.zi();
                    AppMethodBeat.o(123712);
                    return 0;
                case 2:
                    ffa.KSa = aVar3.UbS.zi();
                    AppMethodBeat.o(123712);
                    return 0;
                case 3:
                    ffa.NAo = aVar3.UbS.zi();
                    AppMethodBeat.o(123712);
                    return 0;
                case 4:
                    ffa.Scene = aVar3.UbS.zi();
                    AppMethodBeat.o(123712);
                    return 0;
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                default:
                    AppMethodBeat.o(123712);
                    return -1;
                case 10:
                    ffa.NAp = aVar3.UbS.zi();
                    AppMethodBeat.o(123712);
                    return 0;
            }
        } else {
            AppMethodBeat.o(123712);
            return -1;
        }
    }
}
