package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class buu extends a {
    public String KXA;
    public int MaY;
    public String Mba;
    public String Mbb;
    public int Scene;
    public String SessionId;
    public String iAc;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(187873);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.Scene);
            if (this.SessionId != null) {
                aVar.e(2, this.SessionId);
            }
            if (this.Mba != null) {
                aVar.e(3, this.Mba);
            }
            if (this.Mbb != null) {
                aVar.e(4, this.Mbb);
            }
            aVar.aM(5, this.MaY);
            if (this.KXA != null) {
                aVar.e(6, this.KXA);
            }
            if (this.iAc != null) {
                aVar.e(7, this.iAc);
            }
            AppMethodBeat.o(187873);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.Scene) + 0;
            if (this.SessionId != null) {
                bu += g.a.a.b.b.a.f(2, this.SessionId);
            }
            if (this.Mba != null) {
                bu += g.a.a.b.b.a.f(3, this.Mba);
            }
            if (this.Mbb != null) {
                bu += g.a.a.b.b.a.f(4, this.Mbb);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(5, this.MaY);
            if (this.KXA != null) {
                bu2 += g.a.a.b.b.a.f(6, this.KXA);
            }
            if (this.iAc != null) {
                bu2 += g.a.a.b.b.a.f(7, this.iAc);
            }
            AppMethodBeat.o(187873);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(187873);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            buu buu = (buu) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    buu.Scene = aVar3.UbS.zi();
                    AppMethodBeat.o(187873);
                    return 0;
                case 2:
                    buu.SessionId = aVar3.UbS.readString();
                    AppMethodBeat.o(187873);
                    return 0;
                case 3:
                    buu.Mba = aVar3.UbS.readString();
                    AppMethodBeat.o(187873);
                    return 0;
                case 4:
                    buu.Mbb = aVar3.UbS.readString();
                    AppMethodBeat.o(187873);
                    return 0;
                case 5:
                    buu.MaY = aVar3.UbS.zi();
                    AppMethodBeat.o(187873);
                    return 0;
                case 6:
                    buu.KXA = aVar3.UbS.readString();
                    AppMethodBeat.o(187873);
                    return 0;
                case 7:
                    buu.iAc = aVar3.UbS.readString();
                    AppMethodBeat.o(187873);
                    return 0;
                default:
                    AppMethodBeat.o(187873);
                    return -1;
            }
        } else {
            AppMethodBeat.o(187873);
            return -1;
        }
    }
}
