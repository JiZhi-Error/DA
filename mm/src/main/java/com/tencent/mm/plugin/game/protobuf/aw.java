package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;

public final class aw extends a {
    public String Title;
    public String xIy;
    public String xJt;
    public int xJv;
    public String xKM;
    public boolean xKN;
    public boolean xKO;
    public String xKP;
    public String xKQ;
    public int xKR;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(41742);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Title == null) {
                b bVar = new b("Not all required fields were included: Title");
                AppMethodBeat.o(41742);
                throw bVar;
            } else if (this.xKM == null) {
                b bVar2 = new b("Not all required fields were included: NavKey");
                AppMethodBeat.o(41742);
                throw bVar2;
            } else {
                if (this.Title != null) {
                    aVar.e(1, this.Title);
                }
                if (this.xKM != null) {
                    aVar.e(2, this.xKM);
                }
                if (this.xIy != null) {
                    aVar.e(3, this.xIy);
                }
                aVar.cc(4, this.xKN);
                aVar.cc(5, this.xKO);
                if (this.xKP != null) {
                    aVar.e(6, this.xKP);
                }
                if (this.xKQ != null) {
                    aVar.e(7, this.xKQ);
                }
                aVar.aM(8, this.xKR);
                aVar.aM(9, this.xJv);
                if (this.xJt != null) {
                    aVar.e(10, this.xJt);
                }
                AppMethodBeat.o(41742);
                return 0;
            }
        } else if (i2 == 1) {
            int f2 = this.Title != null ? g.a.a.b.b.a.f(1, this.Title) + 0 : 0;
            if (this.xKM != null) {
                f2 += g.a.a.b.b.a.f(2, this.xKM);
            }
            if (this.xIy != null) {
                f2 += g.a.a.b.b.a.f(3, this.xIy);
            }
            int fS = f2 + g.a.a.b.b.a.fS(4) + 1 + g.a.a.b.b.a.fS(5) + 1;
            if (this.xKP != null) {
                fS += g.a.a.b.b.a.f(6, this.xKP);
            }
            if (this.xKQ != null) {
                fS += g.a.a.b.b.a.f(7, this.xKQ);
            }
            int bu = fS + g.a.a.b.b.a.bu(8, this.xKR) + g.a.a.b.b.a.bu(9, this.xJv);
            if (this.xJt != null) {
                bu += g.a.a.b.b.a.f(10, this.xJt);
            }
            AppMethodBeat.o(41742);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.Title == null) {
                b bVar3 = new b("Not all required fields were included: Title");
                AppMethodBeat.o(41742);
                throw bVar3;
            } else if (this.xKM == null) {
                b bVar4 = new b("Not all required fields were included: NavKey");
                AppMethodBeat.o(41742);
                throw bVar4;
            } else {
                AppMethodBeat.o(41742);
                return 0;
            }
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            aw awVar = (aw) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    awVar.Title = aVar3.UbS.readString();
                    AppMethodBeat.o(41742);
                    return 0;
                case 2:
                    awVar.xKM = aVar3.UbS.readString();
                    AppMethodBeat.o(41742);
                    return 0;
                case 3:
                    awVar.xIy = aVar3.UbS.readString();
                    AppMethodBeat.o(41742);
                    return 0;
                case 4:
                    awVar.xKN = aVar3.UbS.yZ();
                    AppMethodBeat.o(41742);
                    return 0;
                case 5:
                    awVar.xKO = aVar3.UbS.yZ();
                    AppMethodBeat.o(41742);
                    return 0;
                case 6:
                    awVar.xKP = aVar3.UbS.readString();
                    AppMethodBeat.o(41742);
                    return 0;
                case 7:
                    awVar.xKQ = aVar3.UbS.readString();
                    AppMethodBeat.o(41742);
                    return 0;
                case 8:
                    awVar.xKR = aVar3.UbS.zi();
                    AppMethodBeat.o(41742);
                    return 0;
                case 9:
                    awVar.xJv = aVar3.UbS.zi();
                    AppMethodBeat.o(41742);
                    return 0;
                case 10:
                    awVar.xJt = aVar3.UbS.readString();
                    AppMethodBeat.o(41742);
                    return 0;
                default:
                    AppMethodBeat.o(41742);
                    return -1;
            }
        } else {
            AppMethodBeat.o(41742);
            return -1;
        }
    }
}
