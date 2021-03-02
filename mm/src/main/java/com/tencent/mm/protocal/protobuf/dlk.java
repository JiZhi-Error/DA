package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class dlk extends a {
    public String KUp;
    public long KVE;
    public String MPh;
    public int status;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(212304);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.KUp != null) {
                aVar.e(1, this.KUp);
            }
            aVar.bb(2, this.KVE);
            aVar.aM(3, this.status);
            if (this.MPh != null) {
                aVar.e(4, this.MPh);
            }
            AppMethodBeat.o(212304);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.KUp != null ? g.a.a.b.b.a.f(1, this.KUp) + 0 : 0) + g.a.a.b.b.a.r(2, this.KVE) + g.a.a.b.b.a.bu(3, this.status);
            if (this.MPh != null) {
                f2 += g.a.a.b.b.a.f(4, this.MPh);
            }
            AppMethodBeat.o(212304);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(212304);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dlk dlk = (dlk) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    dlk.KUp = aVar3.UbS.readString();
                    AppMethodBeat.o(212304);
                    return 0;
                case 2:
                    dlk.KVE = aVar3.UbS.zl();
                    AppMethodBeat.o(212304);
                    return 0;
                case 3:
                    dlk.status = aVar3.UbS.zi();
                    AppMethodBeat.o(212304);
                    return 0;
                case 4:
                    dlk.MPh = aVar3.UbS.readString();
                    AppMethodBeat.o(212304);
                    return 0;
                default:
                    AppMethodBeat.o(212304);
                    return -1;
            }
        } else {
            AppMethodBeat.o(212304);
            return -1;
        }
    }
}
