package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;

public final class eys extends a {
    public int KIy;
    public String Lox;
    public String Nvp;
    public String Nvq;
    public String Nvr;
    public String Nvs;
    public String Nvt;
    public String Nvu;
    public String fMj;
    public String oTJ;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(32531);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Nvp == null) {
                b bVar = new b("Not all required fields were included: LocalNodeId");
                AppMethodBeat.o(32531);
                throw bVar;
            }
            if (this.Nvp != null) {
                aVar.e(1, this.Nvp);
            }
            if (this.oTJ != null) {
                aVar.e(2, this.oTJ);
            }
            if (this.Nvq != null) {
                aVar.e(3, this.Nvq);
            }
            if (this.fMj != null) {
                aVar.e(4, this.fMj);
            }
            if (this.Nvr != null) {
                aVar.e(5, this.Nvr);
            }
            if (this.Lox != null) {
                aVar.e(6, this.Lox);
            }
            if (this.Nvs != null) {
                aVar.e(7, this.Nvs);
            }
            if (this.Nvt != null) {
                aVar.e(8, this.Nvt);
            }
            if (this.Nvu != null) {
                aVar.e(9, this.Nvu);
            }
            aVar.aM(10, this.KIy);
            AppMethodBeat.o(32531);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.Nvp != null ? g.a.a.b.b.a.f(1, this.Nvp) + 0 : 0;
            if (this.oTJ != null) {
                f2 += g.a.a.b.b.a.f(2, this.oTJ);
            }
            if (this.Nvq != null) {
                f2 += g.a.a.b.b.a.f(3, this.Nvq);
            }
            if (this.fMj != null) {
                f2 += g.a.a.b.b.a.f(4, this.fMj);
            }
            if (this.Nvr != null) {
                f2 += g.a.a.b.b.a.f(5, this.Nvr);
            }
            if (this.Lox != null) {
                f2 += g.a.a.b.b.a.f(6, this.Lox);
            }
            if (this.Nvs != null) {
                f2 += g.a.a.b.b.a.f(7, this.Nvs);
            }
            if (this.Nvt != null) {
                f2 += g.a.a.b.b.a.f(8, this.Nvt);
            }
            if (this.Nvu != null) {
                f2 += g.a.a.b.b.a.f(9, this.Nvu);
            }
            int bu = f2 + g.a.a.b.b.a.bu(10, this.KIy);
            AppMethodBeat.o(32531);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.Nvp == null) {
                b bVar2 = new b("Not all required fields were included: LocalNodeId");
                AppMethodBeat.o(32531);
                throw bVar2;
            }
            AppMethodBeat.o(32531);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            eys eys = (eys) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    eys.Nvp = aVar3.UbS.readString();
                    AppMethodBeat.o(32531);
                    return 0;
                case 2:
                    eys.oTJ = aVar3.UbS.readString();
                    AppMethodBeat.o(32531);
                    return 0;
                case 3:
                    eys.Nvq = aVar3.UbS.readString();
                    AppMethodBeat.o(32531);
                    return 0;
                case 4:
                    eys.fMj = aVar3.UbS.readString();
                    AppMethodBeat.o(32531);
                    return 0;
                case 5:
                    eys.Nvr = aVar3.UbS.readString();
                    AppMethodBeat.o(32531);
                    return 0;
                case 6:
                    eys.Lox = aVar3.UbS.readString();
                    AppMethodBeat.o(32531);
                    return 0;
                case 7:
                    eys.Nvs = aVar3.UbS.readString();
                    AppMethodBeat.o(32531);
                    return 0;
                case 8:
                    eys.Nvt = aVar3.UbS.readString();
                    AppMethodBeat.o(32531);
                    return 0;
                case 9:
                    eys.Nvu = aVar3.UbS.readString();
                    AppMethodBeat.o(32531);
                    return 0;
                case 10:
                    eys.KIy = aVar3.UbS.zi();
                    AppMethodBeat.o(32531);
                    return 0;
                default:
                    AppMethodBeat.o(32531);
                    return -1;
            }
        } else {
            AppMethodBeat.o(32531);
            return -1;
        }
    }
}
