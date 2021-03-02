package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class xx extends a {
    public String LiU;
    public String LiV;
    public String LiW;
    public int LiX;
    public int LiY;
    public String LiZ;
    public int Lja;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(127444);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.LiU != null) {
                aVar.e(1, this.LiU);
            }
            if (this.LiV != null) {
                aVar.e(2, this.LiV);
            }
            if (this.LiW != null) {
                aVar.e(3, this.LiW);
            }
            aVar.aM(4, this.LiX);
            aVar.aM(5, this.LiY);
            if (this.LiZ != null) {
                aVar.e(6, this.LiZ);
            }
            aVar.aM(7, this.Lja);
            AppMethodBeat.o(127444);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.LiU != null ? g.a.a.b.b.a.f(1, this.LiU) + 0 : 0;
            if (this.LiV != null) {
                f2 += g.a.a.b.b.a.f(2, this.LiV);
            }
            if (this.LiW != null) {
                f2 += g.a.a.b.b.a.f(3, this.LiW);
            }
            int bu = f2 + g.a.a.b.b.a.bu(4, this.LiX) + g.a.a.b.b.a.bu(5, this.LiY);
            if (this.LiZ != null) {
                bu += g.a.a.b.b.a.f(6, this.LiZ);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(7, this.Lja);
            AppMethodBeat.o(127444);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(127444);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            xx xxVar = (xx) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    xxVar.LiU = aVar3.UbS.readString();
                    AppMethodBeat.o(127444);
                    return 0;
                case 2:
                    xxVar.LiV = aVar3.UbS.readString();
                    AppMethodBeat.o(127444);
                    return 0;
                case 3:
                    xxVar.LiW = aVar3.UbS.readString();
                    AppMethodBeat.o(127444);
                    return 0;
                case 4:
                    xxVar.LiX = aVar3.UbS.zi();
                    AppMethodBeat.o(127444);
                    return 0;
                case 5:
                    xxVar.LiY = aVar3.UbS.zi();
                    AppMethodBeat.o(127444);
                    return 0;
                case 6:
                    xxVar.LiZ = aVar3.UbS.readString();
                    AppMethodBeat.o(127444);
                    return 0;
                case 7:
                    xxVar.Lja = aVar3.UbS.zi();
                    AppMethodBeat.o(127444);
                    return 0;
                default:
                    AppMethodBeat.o(127444);
                    return -1;
            }
        } else {
            AppMethodBeat.o(127444);
            return -1;
        }
    }
}
