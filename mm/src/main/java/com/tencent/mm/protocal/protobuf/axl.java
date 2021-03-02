package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;

public final class axl extends a {
    public b LHW;
    public String LHX;
    public int infoType;
    public int jlm;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209565);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.infoType);
            if (this.LHW != null) {
                aVar.c(2, this.LHW);
            }
            if (this.LHX != null) {
                aVar.e(3, this.LHX);
            }
            aVar.aM(4, this.jlm);
            AppMethodBeat.o(209565);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.infoType) + 0;
            if (this.LHW != null) {
                bu += g.a.a.b.b.a.b(2, this.LHW);
            }
            if (this.LHX != null) {
                bu += g.a.a.b.b.a.f(3, this.LHX);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(4, this.jlm);
            AppMethodBeat.o(209565);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(209565);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            axl axl = (axl) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    axl.infoType = aVar3.UbS.zi();
                    AppMethodBeat.o(209565);
                    return 0;
                case 2:
                    axl.LHW = aVar3.UbS.hPo();
                    AppMethodBeat.o(209565);
                    return 0;
                case 3:
                    axl.LHX = aVar3.UbS.readString();
                    AppMethodBeat.o(209565);
                    return 0;
                case 4:
                    axl.jlm = aVar3.UbS.zi();
                    AppMethodBeat.o(209565);
                    return 0;
                default:
                    AppMethodBeat.o(209565);
                    return -1;
            }
        } else {
            AppMethodBeat.o(209565);
            return -1;
        }
    }
}
