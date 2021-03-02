package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class n extends a {
    public int jTs;
    public int jTt;
    public int jTu;
    public long jTv;
    public long jTw;
    public String jTx;
    public String jTy;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91323);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.jTs);
            aVar.aM(2, this.jTt);
            aVar.aM(3, this.jTu);
            aVar.bb(4, this.jTv);
            aVar.bb(5, this.jTw);
            if (this.jTx != null) {
                aVar.e(6, this.jTx);
            }
            if (this.jTy != null) {
                aVar.e(7, this.jTy);
            }
            AppMethodBeat.o(91323);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.jTs) + 0 + g.a.a.b.b.a.bu(2, this.jTt) + g.a.a.b.b.a.bu(3, this.jTu) + g.a.a.b.b.a.r(4, this.jTv) + g.a.a.b.b.a.r(5, this.jTw);
            if (this.jTx != null) {
                bu += g.a.a.b.b.a.f(6, this.jTx);
            }
            if (this.jTy != null) {
                bu += g.a.a.b.b.a.f(7, this.jTy);
            }
            AppMethodBeat.o(91323);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(91323);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            n nVar = (n) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    nVar.jTs = aVar3.UbS.zi();
                    AppMethodBeat.o(91323);
                    return 0;
                case 2:
                    nVar.jTt = aVar3.UbS.zi();
                    AppMethodBeat.o(91323);
                    return 0;
                case 3:
                    nVar.jTu = aVar3.UbS.zi();
                    AppMethodBeat.o(91323);
                    return 0;
                case 4:
                    nVar.jTv = aVar3.UbS.zl();
                    AppMethodBeat.o(91323);
                    return 0;
                case 5:
                    nVar.jTw = aVar3.UbS.zl();
                    AppMethodBeat.o(91323);
                    return 0;
                case 6:
                    nVar.jTx = aVar3.UbS.readString();
                    AppMethodBeat.o(91323);
                    return 0;
                case 7:
                    nVar.jTy = aVar3.UbS.readString();
                    AppMethodBeat.o(91323);
                    return 0;
                default:
                    AppMethodBeat.o(91323);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91323);
            return -1;
        }
    }
}
