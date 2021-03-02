package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class cmz extends a {
    public int MlH;
    public int Msw;
    public String SessionId;
    public int xuT;
    public int xub;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(125742);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.xub);
            aVar.aM(2, this.xuT);
            aVar.aM(3, this.Msw);
            if (this.SessionId != null) {
                aVar.e(4, this.SessionId);
            }
            aVar.aM(5, this.MlH);
            AppMethodBeat.o(125742);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.xub) + 0 + g.a.a.b.b.a.bu(2, this.xuT) + g.a.a.b.b.a.bu(3, this.Msw);
            if (this.SessionId != null) {
                bu += g.a.a.b.b.a.f(4, this.SessionId);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(5, this.MlH);
            AppMethodBeat.o(125742);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(125742);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cmz cmz = (cmz) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cmz.xub = aVar3.UbS.zi();
                    AppMethodBeat.o(125742);
                    return 0;
                case 2:
                    cmz.xuT = aVar3.UbS.zi();
                    AppMethodBeat.o(125742);
                    return 0;
                case 3:
                    cmz.Msw = aVar3.UbS.zi();
                    AppMethodBeat.o(125742);
                    return 0;
                case 4:
                    cmz.SessionId = aVar3.UbS.readString();
                    AppMethodBeat.o(125742);
                    return 0;
                case 5:
                    cmz.MlH = aVar3.UbS.zi();
                    AppMethodBeat.o(125742);
                    return 0;
                default:
                    AppMethodBeat.o(125742);
                    return -1;
            }
        } else {
            AppMethodBeat.o(125742);
            return -1;
        }
    }
}
