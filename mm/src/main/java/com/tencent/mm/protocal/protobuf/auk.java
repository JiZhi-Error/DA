package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;

public final class auk extends a {
    public long LFj;
    public String LFk;
    public b LFl;
    public String LFm;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209477);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.bb(1, this.LFj);
            if (this.LFk != null) {
                aVar.e(2, this.LFk);
            }
            if (this.LFl != null) {
                aVar.c(3, this.LFl);
            }
            if (this.LFm != null) {
                aVar.e(4, this.LFm);
            }
            AppMethodBeat.o(209477);
            return 0;
        } else if (i2 == 1) {
            int r = g.a.a.b.b.a.r(1, this.LFj) + 0;
            if (this.LFk != null) {
                r += g.a.a.b.b.a.f(2, this.LFk);
            }
            if (this.LFl != null) {
                r += g.a.a.b.b.a.b(3, this.LFl);
            }
            if (this.LFm != null) {
                r += g.a.a.b.b.a.f(4, this.LFm);
            }
            AppMethodBeat.o(209477);
            return r;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(209477);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            auk auk = (auk) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    auk.LFj = aVar3.UbS.zl();
                    AppMethodBeat.o(209477);
                    return 0;
                case 2:
                    auk.LFk = aVar3.UbS.readString();
                    AppMethodBeat.o(209477);
                    return 0;
                case 3:
                    auk.LFl = aVar3.UbS.hPo();
                    AppMethodBeat.o(209477);
                    return 0;
                case 4:
                    auk.LFm = aVar3.UbS.readString();
                    AppMethodBeat.o(209477);
                    return 0;
                default:
                    AppMethodBeat.o(209477);
                    return -1;
            }
        } else {
            AppMethodBeat.o(209477);
            return -1;
        }
    }
}
