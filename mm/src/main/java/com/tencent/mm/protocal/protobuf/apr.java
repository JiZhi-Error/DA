package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class apr extends a {
    public long LBA;
    public int LBB;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209357);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.bb(1, this.LBA);
            aVar.aM(2, this.LBB);
            AppMethodBeat.o(209357);
            return 0;
        } else if (i2 == 1) {
            int r = g.a.a.b.b.a.r(1, this.LBA) + 0 + g.a.a.b.b.a.bu(2, this.LBB);
            AppMethodBeat.o(209357);
            return r;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(209357);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            apr apr = (apr) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    apr.LBA = aVar3.UbS.zl();
                    AppMethodBeat.o(209357);
                    return 0;
                case 2:
                    apr.LBB = aVar3.UbS.zi();
                    AppMethodBeat.o(209357);
                    return 0;
                default:
                    AppMethodBeat.o(209357);
                    return -1;
            }
        } else {
            AppMethodBeat.o(209357);
            return -1;
        }
    }
}