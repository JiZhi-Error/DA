package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public class cxt extends a {
    public String AAN;
    public double KUt;
    public double KUu;
    public String LpJ;
    public String LpK;
    public String MCE;
    public String MCF;
    public String MCG;
    public String MCH;
    public String Name;
    public String kdZ;
    public String kea;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(56257);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Name != null) {
                aVar.e(1, this.Name);
            }
            if (this.MCE != null) {
                aVar.e(2, this.MCE);
            }
            aVar.e(3, this.KUt);
            aVar.e(4, this.KUu);
            if (this.MCF != null) {
                aVar.e(5, this.MCF);
            }
            if (this.AAN != null) {
                aVar.e(6, this.AAN);
            }
            if (this.MCG != null) {
                aVar.e(7, this.MCG);
            }
            if (this.kdZ != null) {
                aVar.e(8, this.kdZ);
            }
            if (this.kea != null) {
                aVar.e(9, this.kea);
            }
            if (this.LpJ != null) {
                aVar.e(10, this.LpJ);
            }
            if (this.LpK != null) {
                aVar.e(11, this.LpK);
            }
            if (this.MCH != null) {
                aVar.e(12, this.MCH);
            }
            AppMethodBeat.o(56257);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.Name != null ? g.a.a.b.b.a.f(1, this.Name) + 0 : 0;
            if (this.MCE != null) {
                f2 += g.a.a.b.b.a.f(2, this.MCE);
            }
            int fS = f2 + g.a.a.b.b.a.fS(3) + 8 + g.a.a.b.b.a.fS(4) + 8;
            if (this.MCF != null) {
                fS += g.a.a.b.b.a.f(5, this.MCF);
            }
            if (this.AAN != null) {
                fS += g.a.a.b.b.a.f(6, this.AAN);
            }
            if (this.MCG != null) {
                fS += g.a.a.b.b.a.f(7, this.MCG);
            }
            if (this.kdZ != null) {
                fS += g.a.a.b.b.a.f(8, this.kdZ);
            }
            if (this.kea != null) {
                fS += g.a.a.b.b.a.f(9, this.kea);
            }
            if (this.LpJ != null) {
                fS += g.a.a.b.b.a.f(10, this.LpJ);
            }
            if (this.LpK != null) {
                fS += g.a.a.b.b.a.f(11, this.LpK);
            }
            if (this.MCH != null) {
                fS += g.a.a.b.b.a.f(12, this.MCH);
            }
            AppMethodBeat.o(56257);
            return fS;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(56257);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cxt cxt = (cxt) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cxt.Name = aVar3.UbS.readString();
                    AppMethodBeat.o(56257);
                    return 0;
                case 2:
                    cxt.MCE = aVar3.UbS.readString();
                    AppMethodBeat.o(56257);
                    return 0;
                case 3:
                    cxt.KUt = Double.longBitsToDouble(aVar3.UbS.zn());
                    AppMethodBeat.o(56257);
                    return 0;
                case 4:
                    cxt.KUu = Double.longBitsToDouble(aVar3.UbS.zn());
                    AppMethodBeat.o(56257);
                    return 0;
                case 5:
                    cxt.MCF = aVar3.UbS.readString();
                    AppMethodBeat.o(56257);
                    return 0;
                case 6:
                    cxt.AAN = aVar3.UbS.readString();
                    AppMethodBeat.o(56257);
                    return 0;
                case 7:
                    cxt.MCG = aVar3.UbS.readString();
                    AppMethodBeat.o(56257);
                    return 0;
                case 8:
                    cxt.kdZ = aVar3.UbS.readString();
                    AppMethodBeat.o(56257);
                    return 0;
                case 9:
                    cxt.kea = aVar3.UbS.readString();
                    AppMethodBeat.o(56257);
                    return 0;
                case 10:
                    cxt.LpJ = aVar3.UbS.readString();
                    AppMethodBeat.o(56257);
                    return 0;
                case 11:
                    cxt.LpK = aVar3.UbS.readString();
                    AppMethodBeat.o(56257);
                    return 0;
                case 12:
                    cxt.MCH = aVar3.UbS.readString();
                    AppMethodBeat.o(56257);
                    return 0;
                default:
                    AppMethodBeat.o(56257);
                    return -1;
            }
        } else {
            AppMethodBeat.o(56257);
            return -1;
        }
    }
}
