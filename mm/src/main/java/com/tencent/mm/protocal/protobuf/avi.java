package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class avi extends a {
    public int LFV;
    public String LFW;
    public int LFX;
    public String LFY;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209501);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.LFV);
            if (this.LFW != null) {
                aVar.e(2, this.LFW);
            }
            aVar.aM(3, this.LFX);
            if (this.LFY != null) {
                aVar.e(4, this.LFY);
            }
            AppMethodBeat.o(209501);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.LFV) + 0;
            if (this.LFW != null) {
                bu += g.a.a.b.b.a.f(2, this.LFW);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(3, this.LFX);
            if (this.LFY != null) {
                bu2 += g.a.a.b.b.a.f(4, this.LFY);
            }
            AppMethodBeat.o(209501);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(209501);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            avi avi = (avi) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    avi.LFV = aVar3.UbS.zi();
                    AppMethodBeat.o(209501);
                    return 0;
                case 2:
                    avi.LFW = aVar3.UbS.readString();
                    AppMethodBeat.o(209501);
                    return 0;
                case 3:
                    avi.LFX = aVar3.UbS.zi();
                    AppMethodBeat.o(209501);
                    return 0;
                case 4:
                    avi.LFY = aVar3.UbS.readString();
                    AppMethodBeat.o(209501);
                    return 0;
                default:
                    AppMethodBeat.o(209501);
                    return -1;
            }
        } else {
            AppMethodBeat.o(209501);
            return -1;
        }
    }
}
