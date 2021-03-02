package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class ebp extends a {
    public int Lqt;
    public int Mmd;
    public int Nbp;
    public int Nbq;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(125840);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.Lqt);
            aVar.aM(2, this.Mmd);
            aVar.aM(3, this.Nbp);
            aVar.aM(4, this.Nbq);
            AppMethodBeat.o(125840);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.Lqt) + 0 + g.a.a.b.b.a.bu(2, this.Mmd) + g.a.a.b.b.a.bu(3, this.Nbp) + g.a.a.b.b.a.bu(4, this.Nbq);
            AppMethodBeat.o(125840);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(125840);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ebp ebp = (ebp) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ebp.Lqt = aVar3.UbS.zi();
                    AppMethodBeat.o(125840);
                    return 0;
                case 2:
                    ebp.Mmd = aVar3.UbS.zi();
                    AppMethodBeat.o(125840);
                    return 0;
                case 3:
                    ebp.Nbp = aVar3.UbS.zi();
                    AppMethodBeat.o(125840);
                    return 0;
                case 4:
                    ebp.Nbq = aVar3.UbS.zi();
                    AppMethodBeat.o(125840);
                    return 0;
                default:
                    AppMethodBeat.o(125840);
                    return -1;
            }
        } else {
            AppMethodBeat.o(125840);
            return -1;
        }
    }
}
