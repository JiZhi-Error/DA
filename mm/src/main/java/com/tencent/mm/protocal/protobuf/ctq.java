package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class ctq extends a {
    public int MlF;
    public int MyT;
    public int MyU;
    public int MyV;
    public int MyW;
    public int MyX;
    public int MyY;
    public int oUv;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(143985);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.MlF);
            aVar.aM(2, this.MyT);
            aVar.aM(3, this.MyU);
            aVar.aM(4, this.MyV);
            aVar.aM(5, this.MyW);
            aVar.aM(6, this.MyX);
            aVar.aM(7, this.MyY);
            aVar.aM(8, this.oUv);
            AppMethodBeat.o(143985);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.MlF) + 0 + g.a.a.b.b.a.bu(2, this.MyT) + g.a.a.b.b.a.bu(3, this.MyU) + g.a.a.b.b.a.bu(4, this.MyV) + g.a.a.b.b.a.bu(5, this.MyW) + g.a.a.b.b.a.bu(6, this.MyX) + g.a.a.b.b.a.bu(7, this.MyY) + g.a.a.b.b.a.bu(8, this.oUv);
            AppMethodBeat.o(143985);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(143985);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ctq ctq = (ctq) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ctq.MlF = aVar3.UbS.zi();
                    AppMethodBeat.o(143985);
                    return 0;
                case 2:
                    ctq.MyT = aVar3.UbS.zi();
                    AppMethodBeat.o(143985);
                    return 0;
                case 3:
                    ctq.MyU = aVar3.UbS.zi();
                    AppMethodBeat.o(143985);
                    return 0;
                case 4:
                    ctq.MyV = aVar3.UbS.zi();
                    AppMethodBeat.o(143985);
                    return 0;
                case 5:
                    ctq.MyW = aVar3.UbS.zi();
                    AppMethodBeat.o(143985);
                    return 0;
                case 6:
                    ctq.MyX = aVar3.UbS.zi();
                    AppMethodBeat.o(143985);
                    return 0;
                case 7:
                    ctq.MyY = aVar3.UbS.zi();
                    AppMethodBeat.o(143985);
                    return 0;
                case 8:
                    ctq.oUv = aVar3.UbS.zi();
                    AppMethodBeat.o(143985);
                    return 0;
                default:
                    AppMethodBeat.o(143985);
                    return -1;
            }
        } else {
            AppMethodBeat.o(143985);
            return -1;
        }
    }
}
