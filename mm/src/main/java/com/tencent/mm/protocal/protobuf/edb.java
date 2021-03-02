package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class edb extends a {
    public long Nds;
    public int Ndt;
    public int Ndu;
    public String ThumbUrl;
    public String UserName;
    public String xLk;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(118434);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.UserName != null) {
                aVar.e(1, this.UserName);
            }
            aVar.bb(2, this.Nds);
            aVar.aM(3, this.Ndt);
            if (this.ThumbUrl != null) {
                aVar.e(4, this.ThumbUrl);
            }
            aVar.aM(5, this.Ndu);
            if (this.xLk != null) {
                aVar.e(6, this.xLk);
            }
            AppMethodBeat.o(118434);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.UserName != null ? g.a.a.b.b.a.f(1, this.UserName) + 0 : 0) + g.a.a.b.b.a.r(2, this.Nds) + g.a.a.b.b.a.bu(3, this.Ndt);
            if (this.ThumbUrl != null) {
                f2 += g.a.a.b.b.a.f(4, this.ThumbUrl);
            }
            int bu = f2 + g.a.a.b.b.a.bu(5, this.Ndu);
            if (this.xLk != null) {
                bu += g.a.a.b.b.a.f(6, this.xLk);
            }
            AppMethodBeat.o(118434);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(118434);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            edb edb = (edb) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    edb.UserName = aVar3.UbS.readString();
                    AppMethodBeat.o(118434);
                    return 0;
                case 2:
                    edb.Nds = aVar3.UbS.zl();
                    AppMethodBeat.o(118434);
                    return 0;
                case 3:
                    edb.Ndt = aVar3.UbS.zi();
                    AppMethodBeat.o(118434);
                    return 0;
                case 4:
                    edb.ThumbUrl = aVar3.UbS.readString();
                    AppMethodBeat.o(118434);
                    return 0;
                case 5:
                    edb.Ndu = aVar3.UbS.zi();
                    AppMethodBeat.o(118434);
                    return 0;
                case 6:
                    edb.xLk = aVar3.UbS.readString();
                    AppMethodBeat.o(118434);
                    return 0;
                default:
                    AppMethodBeat.o(118434);
                    return -1;
            }
        } else {
            AppMethodBeat.o(118434);
            return -1;
        }
    }
}
