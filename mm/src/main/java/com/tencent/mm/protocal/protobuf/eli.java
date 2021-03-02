package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class eli extends a {
    public String ANo;
    public String KNs;
    public String KNt;
    public String dDj;
    public String iwv;
    public String ynT;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(72615);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.dDj != null) {
                aVar.e(1, this.dDj);
            }
            if (this.iwv != null) {
                aVar.e(2, this.iwv);
            }
            if (this.ynT != null) {
                aVar.e(3, this.ynT);
            }
            if (this.ANo != null) {
                aVar.e(4, this.ANo);
            }
            if (this.KNs != null) {
                aVar.e(5, this.KNs);
            }
            if (this.KNt != null) {
                aVar.e(6, this.KNt);
            }
            AppMethodBeat.o(72615);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.dDj != null ? g.a.a.b.b.a.f(1, this.dDj) + 0 : 0;
            if (this.iwv != null) {
                f2 += g.a.a.b.b.a.f(2, this.iwv);
            }
            if (this.ynT != null) {
                f2 += g.a.a.b.b.a.f(3, this.ynT);
            }
            if (this.ANo != null) {
                f2 += g.a.a.b.b.a.f(4, this.ANo);
            }
            if (this.KNs != null) {
                f2 += g.a.a.b.b.a.f(5, this.KNs);
            }
            if (this.KNt != null) {
                f2 += g.a.a.b.b.a.f(6, this.KNt);
            }
            AppMethodBeat.o(72615);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(72615);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            eli eli = (eli) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    eli.dDj = aVar3.UbS.readString();
                    AppMethodBeat.o(72615);
                    return 0;
                case 2:
                    eli.iwv = aVar3.UbS.readString();
                    AppMethodBeat.o(72615);
                    return 0;
                case 3:
                    eli.ynT = aVar3.UbS.readString();
                    AppMethodBeat.o(72615);
                    return 0;
                case 4:
                    eli.ANo = aVar3.UbS.readString();
                    AppMethodBeat.o(72615);
                    return 0;
                case 5:
                    eli.KNs = aVar3.UbS.readString();
                    AppMethodBeat.o(72615);
                    return 0;
                case 6:
                    eli.KNt = aVar3.UbS.readString();
                    AppMethodBeat.o(72615);
                    return 0;
                default:
                    AppMethodBeat.o(72615);
                    return -1;
            }
        } else {
            AppMethodBeat.o(72615);
            return -1;
        }
    }
}
