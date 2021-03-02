package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class clu extends a {
    public String MaZ;
    public long Mrf;
    public long Mrg;
    public int Mrh;
    public int Scene;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(117877);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.Scene);
            if (this.MaZ != null) {
                aVar.e(2, this.MaZ);
            }
            aVar.bb(3, this.Mrg);
            aVar.bb(4, this.Mrf);
            aVar.aM(5, this.Mrh);
            AppMethodBeat.o(117877);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.Scene) + 0;
            if (this.MaZ != null) {
                bu += g.a.a.b.b.a.f(2, this.MaZ);
            }
            int r = bu + g.a.a.b.b.a.r(3, this.Mrg) + g.a.a.b.b.a.r(4, this.Mrf) + g.a.a.b.b.a.bu(5, this.Mrh);
            AppMethodBeat.o(117877);
            return r;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(117877);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            clu clu = (clu) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    clu.Scene = aVar3.UbS.zi();
                    AppMethodBeat.o(117877);
                    return 0;
                case 2:
                    clu.MaZ = aVar3.UbS.readString();
                    AppMethodBeat.o(117877);
                    return 0;
                case 3:
                    clu.Mrg = aVar3.UbS.zl();
                    AppMethodBeat.o(117877);
                    return 0;
                case 4:
                    clu.Mrf = aVar3.UbS.zl();
                    AppMethodBeat.o(117877);
                    return 0;
                case 5:
                    clu.Mrh = aVar3.UbS.zi();
                    AppMethodBeat.o(117877);
                    return 0;
                default:
                    AppMethodBeat.o(117877);
                    return -1;
            }
        } else {
            AppMethodBeat.o(117877);
            return -1;
        }
    }
}
