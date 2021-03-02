package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class dzk extends a {
    public String LRU;
    public String MZd;
    public int MZe;
    public int MZf;
    public int MmV;
    public String UserName;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(125773);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.MZd != null) {
                aVar.e(1, this.MZd);
            }
            aVar.aM(2, this.MZe);
            if (this.UserName != null) {
                aVar.e(3, this.UserName);
            }
            if (this.LRU != null) {
                aVar.e(4, this.LRU);
            }
            aVar.aM(5, this.MmV);
            aVar.aM(6, this.MZf);
            AppMethodBeat.o(125773);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.MZd != null ? g.a.a.b.b.a.f(1, this.MZd) + 0 : 0) + g.a.a.b.b.a.bu(2, this.MZe);
            if (this.UserName != null) {
                f2 += g.a.a.b.b.a.f(3, this.UserName);
            }
            if (this.LRU != null) {
                f2 += g.a.a.b.b.a.f(4, this.LRU);
            }
            int bu = f2 + g.a.a.b.b.a.bu(5, this.MmV) + g.a.a.b.b.a.bu(6, this.MZf);
            AppMethodBeat.o(125773);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(125773);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dzk dzk = (dzk) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    dzk.MZd = aVar3.UbS.readString();
                    AppMethodBeat.o(125773);
                    return 0;
                case 2:
                    dzk.MZe = aVar3.UbS.zi();
                    AppMethodBeat.o(125773);
                    return 0;
                case 3:
                    dzk.UserName = aVar3.UbS.readString();
                    AppMethodBeat.o(125773);
                    return 0;
                case 4:
                    dzk.LRU = aVar3.UbS.readString();
                    AppMethodBeat.o(125773);
                    return 0;
                case 5:
                    dzk.MmV = aVar3.UbS.zi();
                    AppMethodBeat.o(125773);
                    return 0;
                case 6:
                    dzk.MZf = aVar3.UbS.zi();
                    AppMethodBeat.o(125773);
                    return 0;
                default:
                    AppMethodBeat.o(125773);
                    return -1;
            }
        } else {
            AppMethodBeat.o(125773);
            return -1;
        }
    }
}
