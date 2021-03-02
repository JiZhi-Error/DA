package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class ge extends a {
    public String KJV;
    public int KJW;
    public int KJX;
    public long KJY;
    public int KJZ;
    public long iAQ;
    public int idx;
    public String url;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(124388);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.KJV != null) {
                aVar.e(1, this.KJV);
            }
            aVar.bb(2, this.iAQ);
            aVar.aM(3, this.idx);
            aVar.aM(4, this.KJW);
            aVar.aM(5, this.KJX);
            aVar.bb(6, this.KJY);
            aVar.aM(7, this.KJZ);
            if (this.url != null) {
                aVar.e(8, this.url);
            }
            AppMethodBeat.o(124388);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.KJV != null ? g.a.a.b.b.a.f(1, this.KJV) + 0 : 0) + g.a.a.b.b.a.r(2, this.iAQ) + g.a.a.b.b.a.bu(3, this.idx) + g.a.a.b.b.a.bu(4, this.KJW) + g.a.a.b.b.a.bu(5, this.KJX) + g.a.a.b.b.a.r(6, this.KJY) + g.a.a.b.b.a.bu(7, this.KJZ);
            if (this.url != null) {
                f2 += g.a.a.b.b.a.f(8, this.url);
            }
            AppMethodBeat.o(124388);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(124388);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ge geVar = (ge) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    geVar.KJV = aVar3.UbS.readString();
                    AppMethodBeat.o(124388);
                    return 0;
                case 2:
                    geVar.iAQ = aVar3.UbS.zl();
                    AppMethodBeat.o(124388);
                    return 0;
                case 3:
                    geVar.idx = aVar3.UbS.zi();
                    AppMethodBeat.o(124388);
                    return 0;
                case 4:
                    geVar.KJW = aVar3.UbS.zi();
                    AppMethodBeat.o(124388);
                    return 0;
                case 5:
                    geVar.KJX = aVar3.UbS.zi();
                    AppMethodBeat.o(124388);
                    return 0;
                case 6:
                    geVar.KJY = aVar3.UbS.zl();
                    AppMethodBeat.o(124388);
                    return 0;
                case 7:
                    geVar.KJZ = aVar3.UbS.zi();
                    AppMethodBeat.o(124388);
                    return 0;
                case 8:
                    geVar.url = aVar3.UbS.readString();
                    AppMethodBeat.o(124388);
                    return 0;
                default:
                    AppMethodBeat.o(124388);
                    return -1;
            }
        } else {
            AppMethodBeat.o(124388);
            return -1;
        }
    }
}
