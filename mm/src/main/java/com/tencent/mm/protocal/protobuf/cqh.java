package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;

public final class cqh extends a {
    public int MvC;
    public String MvG;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(43111);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.MvG == null) {
                b bVar = new b("Not all required fields were included: ContactUsername");
                AppMethodBeat.o(43111);
                throw bVar;
            }
            if (this.MvG != null) {
                aVar.e(1, this.MvG);
            }
            aVar.aM(2, this.MvC);
            AppMethodBeat.o(43111);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.MvG != null ? g.a.a.b.b.a.f(1, this.MvG) + 0 : 0) + g.a.a.b.b.a.bu(2, this.MvC);
            AppMethodBeat.o(43111);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.MvG == null) {
                b bVar2 = new b("Not all required fields were included: ContactUsername");
                AppMethodBeat.o(43111);
                throw bVar2;
            }
            AppMethodBeat.o(43111);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cqh cqh = (cqh) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cqh.MvG = aVar3.UbS.readString();
                    AppMethodBeat.o(43111);
                    return 0;
                case 2:
                    cqh.MvC = aVar3.UbS.zi();
                    AppMethodBeat.o(43111);
                    return 0;
                default:
                    AppMethodBeat.o(43111);
                    return -1;
            }
        } else {
            AppMethodBeat.o(43111);
            return -1;
        }
    }
}
