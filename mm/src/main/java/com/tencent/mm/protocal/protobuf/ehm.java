package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class ehm extends a {
    public long NgY;
    public long NgZ;
    public int Nha;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(125848);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.bb(1, this.NgY);
            aVar.bb(2, this.NgZ);
            aVar.aM(3, this.Nha);
            AppMethodBeat.o(125848);
            return 0;
        } else if (i2 == 1) {
            int r = g.a.a.b.b.a.r(1, this.NgY) + 0 + g.a.a.b.b.a.r(2, this.NgZ) + g.a.a.b.b.a.bu(3, this.Nha);
            AppMethodBeat.o(125848);
            return r;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(125848);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ehm ehm = (ehm) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ehm.NgY = aVar3.UbS.zl();
                    AppMethodBeat.o(125848);
                    return 0;
                case 2:
                    ehm.NgZ = aVar3.UbS.zl();
                    AppMethodBeat.o(125848);
                    return 0;
                case 3:
                    ehm.Nha = aVar3.UbS.zi();
                    AppMethodBeat.o(125848);
                    return 0;
                default:
                    AppMethodBeat.o(125848);
                    return -1;
            }
        } else {
            AppMethodBeat.o(125848);
            return -1;
        }
    }
}