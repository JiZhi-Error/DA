package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class amk extends a {
    public String KSu;
    public String LbJ;
    public int LbK;
    public String LiU;
    public String LiV;
    public String LiW;
    public int LiX;
    public String Lvf;
    public int Lvg;
    public int oTW;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(127456);
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
            if (this.Lvf != null) {
                aVar.e(5, this.Lvf);
            }
            if (this.LbJ != null) {
                aVar.e(6, this.LbJ);
            }
            aVar.aM(7, this.LbK);
            if (this.KSu != null) {
                aVar.e(8, this.KSu);
            }
            aVar.aM(9, this.oTW);
            aVar.aM(10, this.Lvg);
            AppMethodBeat.o(127456);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.LiU != null ? g.a.a.b.b.a.f(1, this.LiU) + 0 : 0;
            if (this.LiV != null) {
                f2 += g.a.a.b.b.a.f(2, this.LiV);
            }
            if (this.LiW != null) {
                f2 += g.a.a.b.b.a.f(3, this.LiW);
            }
            int bu = f2 + g.a.a.b.b.a.bu(4, this.LiX);
            if (this.Lvf != null) {
                bu += g.a.a.b.b.a.f(5, this.Lvf);
            }
            if (this.LbJ != null) {
                bu += g.a.a.b.b.a.f(6, this.LbJ);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(7, this.LbK);
            if (this.KSu != null) {
                bu2 += g.a.a.b.b.a.f(8, this.KSu);
            }
            int bu3 = bu2 + g.a.a.b.b.a.bu(9, this.oTW) + g.a.a.b.b.a.bu(10, this.Lvg);
            AppMethodBeat.o(127456);
            return bu3;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(127456);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            amk amk = (amk) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    amk.LiU = aVar3.UbS.readString();
                    AppMethodBeat.o(127456);
                    return 0;
                case 2:
                    amk.LiV = aVar3.UbS.readString();
                    AppMethodBeat.o(127456);
                    return 0;
                case 3:
                    amk.LiW = aVar3.UbS.readString();
                    AppMethodBeat.o(127456);
                    return 0;
                case 4:
                    amk.LiX = aVar3.UbS.zi();
                    AppMethodBeat.o(127456);
                    return 0;
                case 5:
                    amk.Lvf = aVar3.UbS.readString();
                    AppMethodBeat.o(127456);
                    return 0;
                case 6:
                    amk.LbJ = aVar3.UbS.readString();
                    AppMethodBeat.o(127456);
                    return 0;
                case 7:
                    amk.LbK = aVar3.UbS.zi();
                    AppMethodBeat.o(127456);
                    return 0;
                case 8:
                    amk.KSu = aVar3.UbS.readString();
                    AppMethodBeat.o(127456);
                    return 0;
                case 9:
                    amk.oTW = aVar3.UbS.zi();
                    AppMethodBeat.o(127456);
                    return 0;
                case 10:
                    amk.Lvg = aVar3.UbS.zi();
                    AppMethodBeat.o(127456);
                    return 0;
                default:
                    AppMethodBeat.o(127456);
                    return -1;
            }
        } else {
            AppMethodBeat.o(127456);
            return -1;
        }
    }
}
