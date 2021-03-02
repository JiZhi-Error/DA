package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class bfl extends a {
    public String LPd;
    public long LPe;
    public int dIZ;
    public String id;
    public int wPz;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(32213);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.id != null) {
                aVar.e(1, this.id);
            }
            aVar.aM(2, this.wPz);
            if (this.LPd != null) {
                aVar.e(3, this.LPd);
            }
            aVar.bb(4, this.LPe);
            aVar.aM(5, this.dIZ);
            AppMethodBeat.o(32213);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.id != null ? g.a.a.b.b.a.f(1, this.id) + 0 : 0) + g.a.a.b.b.a.bu(2, this.wPz);
            if (this.LPd != null) {
                f2 += g.a.a.b.b.a.f(3, this.LPd);
            }
            int r = f2 + g.a.a.b.b.a.r(4, this.LPe) + g.a.a.b.b.a.bu(5, this.dIZ);
            AppMethodBeat.o(32213);
            return r;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(32213);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bfl bfl = (bfl) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bfl.id = aVar3.UbS.readString();
                    AppMethodBeat.o(32213);
                    return 0;
                case 2:
                    bfl.wPz = aVar3.UbS.zi();
                    AppMethodBeat.o(32213);
                    return 0;
                case 3:
                    bfl.LPd = aVar3.UbS.readString();
                    AppMethodBeat.o(32213);
                    return 0;
                case 4:
                    bfl.LPe = aVar3.UbS.zl();
                    AppMethodBeat.o(32213);
                    return 0;
                case 5:
                    bfl.dIZ = aVar3.UbS.zi();
                    AppMethodBeat.o(32213);
                    return 0;
                default:
                    AppMethodBeat.o(32213);
                    return -1;
            }
        } else {
            AppMethodBeat.o(32213);
            return -1;
        }
    }
}
