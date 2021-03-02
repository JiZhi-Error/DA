package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class cdw extends a {
    public int KLv;
    public String Mjs;
    public String Mjt;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(82432);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Mjs != null) {
                aVar.e(1, this.Mjs);
            }
            aVar.aM(2, this.KLv);
            if (this.Mjt != null) {
                aVar.e(3, this.Mjt);
            }
            AppMethodBeat.o(82432);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.Mjs != null ? g.a.a.b.b.a.f(1, this.Mjs) + 0 : 0) + g.a.a.b.b.a.bu(2, this.KLv);
            if (this.Mjt != null) {
                f2 += g.a.a.b.b.a.f(3, this.Mjt);
            }
            AppMethodBeat.o(82432);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(82432);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cdw cdw = (cdw) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cdw.Mjs = aVar3.UbS.readString();
                    AppMethodBeat.o(82432);
                    return 0;
                case 2:
                    cdw.KLv = aVar3.UbS.zi();
                    AppMethodBeat.o(82432);
                    return 0;
                case 3:
                    cdw.Mjt = aVar3.UbS.readString();
                    AppMethodBeat.o(82432);
                    return 0;
                default:
                    AppMethodBeat.o(82432);
                    return -1;
            }
        } else {
            AppMethodBeat.o(82432);
            return -1;
        }
    }
}
