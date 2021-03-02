package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class axz extends a {
    public long Ghu;
    public long Ghw;
    public int LIl;
    public String LIm;
    public int LIn;
    public int Vjw;
    public long refObjectId;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209580);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.bb(1, this.Ghu);
            aVar.aM(2, this.LIl);
            aVar.bb(3, this.refObjectId);
            if (this.LIm != null) {
                aVar.e(4, this.LIm);
            }
            aVar.bb(5, this.Ghw);
            aVar.aM(6, this.LIn);
            aVar.aM(7, this.Vjw);
            AppMethodBeat.o(209580);
            return 0;
        } else if (i2 == 1) {
            int r = g.a.a.b.b.a.r(1, this.Ghu) + 0 + g.a.a.b.b.a.bu(2, this.LIl) + g.a.a.b.b.a.r(3, this.refObjectId);
            if (this.LIm != null) {
                r += g.a.a.b.b.a.f(4, this.LIm);
            }
            int r2 = r + g.a.a.b.b.a.r(5, this.Ghw) + g.a.a.b.b.a.bu(6, this.LIn) + g.a.a.b.b.a.bu(7, this.Vjw);
            AppMethodBeat.o(209580);
            return r2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(209580);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            axz axz = (axz) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    axz.Ghu = aVar3.UbS.zl();
                    AppMethodBeat.o(209580);
                    return 0;
                case 2:
                    axz.LIl = aVar3.UbS.zi();
                    AppMethodBeat.o(209580);
                    return 0;
                case 3:
                    axz.refObjectId = aVar3.UbS.zl();
                    AppMethodBeat.o(209580);
                    return 0;
                case 4:
                    axz.LIm = aVar3.UbS.readString();
                    AppMethodBeat.o(209580);
                    return 0;
                case 5:
                    axz.Ghw = aVar3.UbS.zl();
                    AppMethodBeat.o(209580);
                    return 0;
                case 6:
                    axz.LIn = aVar3.UbS.zi();
                    AppMethodBeat.o(209580);
                    return 0;
                case 7:
                    axz.Vjw = aVar3.UbS.zi();
                    AppMethodBeat.o(209580);
                    return 0;
                default:
                    AppMethodBeat.o(209580);
                    return -1;
            }
        } else {
            AppMethodBeat.o(209580);
            return -1;
        }
    }
}
