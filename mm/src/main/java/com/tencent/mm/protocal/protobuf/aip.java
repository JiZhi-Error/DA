package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class aip extends a {
    public int centerX;
    public int centerY;
    public float mat;
    public float scale;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(201294);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.centerX);
            aVar.aM(2, this.centerY);
            aVar.E(3, this.scale);
            aVar.E(4, this.mat);
            AppMethodBeat.o(201294);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.centerX) + 0 + g.a.a.b.b.a.bu(2, this.centerY) + g.a.a.b.b.a.fS(3) + 4 + g.a.a.b.b.a.fS(4) + 4;
            AppMethodBeat.o(201294);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(201294);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            aip aip = (aip) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    aip.centerX = aVar3.UbS.zi();
                    AppMethodBeat.o(201294);
                    return 0;
                case 2:
                    aip.centerY = aVar3.UbS.zi();
                    AppMethodBeat.o(201294);
                    return 0;
                case 3:
                    aip.scale = Float.intBitsToFloat(aVar3.UbS.zm());
                    AppMethodBeat.o(201294);
                    return 0;
                case 4:
                    aip.mat = Float.intBitsToFloat(aVar3.UbS.zm());
                    AppMethodBeat.o(201294);
                    return 0;
                default:
                    AppMethodBeat.o(201294);
                    return -1;
            }
        } else {
            AppMethodBeat.o(201294);
            return -1;
        }
    }
}
