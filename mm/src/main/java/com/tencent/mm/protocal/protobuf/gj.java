package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class gj extends a {
    public int KKl;
    public String hik;
    public String hio;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(152494);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.hik != null) {
                aVar.e(1, this.hik);
            }
            aVar.aM(2, this.KKl);
            if (this.hio != null) {
                aVar.e(3, this.hio);
            }
            AppMethodBeat.o(152494);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.hik != null ? g.a.a.b.b.a.f(1, this.hik) + 0 : 0) + g.a.a.b.b.a.bu(2, this.KKl);
            if (this.hio != null) {
                f2 += g.a.a.b.b.a.f(3, this.hio);
            }
            AppMethodBeat.o(152494);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(152494);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            gj gjVar = (gj) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    gjVar.hik = aVar3.UbS.readString();
                    AppMethodBeat.o(152494);
                    return 0;
                case 2:
                    gjVar.KKl = aVar3.UbS.zi();
                    AppMethodBeat.o(152494);
                    return 0;
                case 3:
                    gjVar.hio = aVar3.UbS.readString();
                    AppMethodBeat.o(152494);
                    return 0;
                default:
                    AppMethodBeat.o(152494);
                    return -1;
            }
        } else {
            AppMethodBeat.o(152494);
            return -1;
        }
    }
}
