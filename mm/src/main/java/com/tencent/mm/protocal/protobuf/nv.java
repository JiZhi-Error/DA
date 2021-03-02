package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class nv extends a {
    public String KTu;
    public String pWm;
    public int ver;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(124418);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.KTu != null) {
                aVar.e(1, this.KTu);
            }
            if (this.pWm != null) {
                aVar.e(2, this.pWm);
            }
            aVar.aM(3, this.ver);
            AppMethodBeat.o(124418);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.KTu != null ? g.a.a.b.b.a.f(1, this.KTu) + 0 : 0;
            if (this.pWm != null) {
                f2 += g.a.a.b.b.a.f(2, this.pWm);
            }
            int bu = f2 + g.a.a.b.b.a.bu(3, this.ver);
            AppMethodBeat.o(124418);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(124418);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            nv nvVar = (nv) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    nvVar.KTu = aVar3.UbS.readString();
                    AppMethodBeat.o(124418);
                    return 0;
                case 2:
                    nvVar.pWm = aVar3.UbS.readString();
                    AppMethodBeat.o(124418);
                    return 0;
                case 3:
                    nvVar.ver = aVar3.UbS.zi();
                    AppMethodBeat.o(124418);
                    return 0;
                default:
                    AppMethodBeat.o(124418);
                    return -1;
            }
        } else {
            AppMethodBeat.o(124418);
            return -1;
        }
    }
}
