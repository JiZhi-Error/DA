package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class exq extends a {
    public String APs;
    public String MEq;
    public String Mbb;
    public String NuS;
    public String NuT;
    public String NuU;
    public String NuV;
    public String NuW;
    public int Scene;
    public int kcR;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(121110);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.NuS != null) {
                aVar.e(1, this.NuS);
            }
            if (this.NuT != null) {
                aVar.e(2, this.NuT);
            }
            if (this.Mbb != null) {
                aVar.e(3, this.Mbb);
            }
            if (this.MEq != null) {
                aVar.e(4, this.MEq);
            }
            aVar.aM(5, this.kcR);
            if (this.APs != null) {
                aVar.e(6, this.APs);
            }
            if (this.NuU != null) {
                aVar.e(7, this.NuU);
            }
            if (this.NuV != null) {
                aVar.e(8, this.NuV);
            }
            aVar.aM(9, this.Scene);
            if (this.NuW != null) {
                aVar.e(19, this.NuW);
            }
            AppMethodBeat.o(121110);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.NuS != null ? g.a.a.b.b.a.f(1, this.NuS) + 0 : 0;
            if (this.NuT != null) {
                f2 += g.a.a.b.b.a.f(2, this.NuT);
            }
            if (this.Mbb != null) {
                f2 += g.a.a.b.b.a.f(3, this.Mbb);
            }
            if (this.MEq != null) {
                f2 += g.a.a.b.b.a.f(4, this.MEq);
            }
            int bu = f2 + g.a.a.b.b.a.bu(5, this.kcR);
            if (this.APs != null) {
                bu += g.a.a.b.b.a.f(6, this.APs);
            }
            if (this.NuU != null) {
                bu += g.a.a.b.b.a.f(7, this.NuU);
            }
            if (this.NuV != null) {
                bu += g.a.a.b.b.a.f(8, this.NuV);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(9, this.Scene);
            if (this.NuW != null) {
                bu2 += g.a.a.b.b.a.f(19, this.NuW);
            }
            AppMethodBeat.o(121110);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(121110);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            exq exq = (exq) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    exq.NuS = aVar3.UbS.readString();
                    AppMethodBeat.o(121110);
                    return 0;
                case 2:
                    exq.NuT = aVar3.UbS.readString();
                    AppMethodBeat.o(121110);
                    return 0;
                case 3:
                    exq.Mbb = aVar3.UbS.readString();
                    AppMethodBeat.o(121110);
                    return 0;
                case 4:
                    exq.MEq = aVar3.UbS.readString();
                    AppMethodBeat.o(121110);
                    return 0;
                case 5:
                    exq.kcR = aVar3.UbS.zi();
                    AppMethodBeat.o(121110);
                    return 0;
                case 6:
                    exq.APs = aVar3.UbS.readString();
                    AppMethodBeat.o(121110);
                    return 0;
                case 7:
                    exq.NuU = aVar3.UbS.readString();
                    AppMethodBeat.o(121110);
                    return 0;
                case 8:
                    exq.NuV = aVar3.UbS.readString();
                    AppMethodBeat.o(121110);
                    return 0;
                case 9:
                    exq.Scene = aVar3.UbS.zi();
                    AppMethodBeat.o(121110);
                    return 0;
                case 10:
                case 11:
                case 12:
                case 13:
                case 14:
                case 15:
                case 16:
                case 17:
                case 18:
                default:
                    AppMethodBeat.o(121110);
                    return -1;
                case 19:
                    exq.NuW = aVar3.UbS.readString();
                    AppMethodBeat.o(121110);
                    return 0;
            }
        } else {
            AppMethodBeat.o(121110);
            return -1;
        }
    }
}
